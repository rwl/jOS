/*
 * Copyright (C) 2012 HipByte SPRL and contributors
 */
package jos.build;

import static jos.build.Application.read;
import static jos.build.Application.sh;
import static jos.build.Application.system;
import static jos.build.Application.write;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jos.build.Application.Platform;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang.StringUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Builder {

    public static File build(final Configuration config, final Platform platform,
            final Map<String, String> opts) {
        final File dataDir = config.getDataDir();
        final List<String> archs = Lists.newArrayList(config.getArchs().get(platform));

        final boolean isStaticLibrary = opts.remove("static") != null;

        final File ruby = new File(config.getBinDir(), "ruby");
        final File llc = new File(config.getBinDir(), "llc");

        if (config.isSpecMode() && config.getSpecFiles().isEmpty()) {
            Application.fail("No spec files in '"+config.getSpecsDir()+"'");
        }

        // Locate SDK and compilers.
        final File sdk = config.getSdk(platform);
        final File cc = config.locateCompiler(platform, "gcc");
        final File cxx = config.locateCompiler(platform, "clang++");

        final File buildDir = config.getVersionedBuildDir(platform);
        Application.info("Build", buildDir);

        // Prepare the list of BridgeSupport files needed.
        final List<File> bsFiles = config.getBridgeSupportFiles();

        // Build vendor libraries.
        final List<File> vendorLibs = Lists.newArrayList();
        for (Vendor vendorProject : config.getVendorProjects()) {
            vendorProject.build(platform);
            vendorLibs.addAll(vendorProject.libs);
            bsFiles.addAll(vendorProject.bsFiles);
        }

        // Build object files.
        final File objsBuildDir = new File(buildDir, "objs");
        objsBuildDir.mkdirs();
        boolean anyObjFileBuilt = false;

        final Runnable buildFile = new Runnable() {
            public void run() {
                File path = null;
                final File obj = new File(objsBuildDir, path.getAbsolutePath() + ".o");
                final boolean shouldRebuild = (!obj.exists()
                        || path.lastModified() > obj.lastModified()
                        || ruby.lastModified() > obj.lastModified());

                // Generate or retrieve init function.
                final String initFunc = "";
                if (shouldRebuild) {
                    //initFunc = sh("/usr/bin/uuidgen").trim().gsub("-", "");
                } else {
                    //initFunc = sh(config.locate_binary("nm") + obj).scan(/T\s+_(MREP_.*)/)[0][0];
                }

                if (shouldRebuild) {
                    Application.info("Compile", path);
                    obj.getParentFile().mkdirs();
                    final List<File> archObjs = Lists.newArrayList();
                    for (final String arch : archs) {
                        // Locate arch kernel.
                        final File kernel = new File(new File(dataDir, platform.getPlatform()), "kernel-"+arch+".bc");
                        if (!kernel.exists()) {
                            throw new IllegalStateException("Can't locate kernel file");
                        }

                        // LLVM bitcode.
                        final File bc = new File(objsBuildDir, path + arch + ".bc");
                        final List<String> bsFlagsList = Lists.newArrayList();
                        for (final File x : bsFiles) {
                            bsFlagsList.add("--uses-bs \"" + x + "\" ");
                        }
                        final String bsFlags = StringUtils.join(bsFlagsList, " ");
                        sh("/usr/bin/env VM_KERNEL_PATH=\""+kernel+"\" VM_OPT_LEVEL=\""+config.getOptLevel()+"\" "+ruby+" "+bsFlags+" --emit-llvm \""+bc+"\" " + initFunc + "\" "+path+"\"");

                        // Assembly.
                        final File asm = new File(objsBuildDir, path + arch + ".s");
                        final String llcArch;
                        if (arch.equals("i386")) {
                            llcArch = "x86";
                        } else if (arch.equals("x86_64")) {
                            llcArch = "x86-64";
                        } else if (arch.matches("^arm")) {
                            llcArch = "arm";
                        } else{
                            llcArch = arch;
                        }
                        sh(llc + "\""+bc+"\" -o=\""+asm+"\" -march="+llcArch+" -relocation-model=pic -disable-fp-elim -jit-enable-eh -disable-cfi");

                        // Object.
                        final File archObj = new File(objsBuildDir, path + arch + ".o");
                        sh(cc + " -fexceptions -c -arch "+arch+" \""+asm+"\" -o \""+archObj+"\"");

                        bc.delete();
                        asm.delete();
                        archObjs.add(archObj);
                    }

                    // Assemble fat binary.
                    final String archObjsList = StringUtils.join(Lists.transform(archObjs, new Function<File, String>() {
                        public String apply(File x) {
                            return "\"" + x+ "\"";
                        }
                    }), " ");
                    sh("/usr/bin/lipo -create "+archObjsList+" -output \""+obj+"\"");
                }

                //any_obj_file_built = true;
                //[obj, init_func]
            }
        };

        // Create builders.
        int buildersCount;
        if (System.getenv().containsKey("jobs")) {
            buildersCount = Integer.valueOf(System.getenv().get("jobs"));
        } else {
            buildersCount = Integer.valueOf(sh("/usr/sbin/sysctl -n machdep.cpu.thread_count").trim());
        }
        if (buildersCount < 1) {
            buildersCount = 1;
        }
        final List<List<File>> builderQueues = Lists.newArrayList();
        final List<Runnable> builderThreads = Lists.newArrayList();
        for (int i = 0; i < buildersCount; i++) {
            final List<File> queue = Lists.newArrayList();
            final Runnable th = new Runnable() {

                public void run() {
                    //Thread.sleep(100);
                    final List<File> objs = Lists.newArrayList();
                    while (queue.size() > 0) {
                        final File path = queue.get(0);
                        //objs.add(build_file.run(path));
                    }
                    queue.addAll(objs);
                }
            };
            builderQueues.add(queue);
            builderThreads.add(th);
        }

        // Resolve file dependencies
        if (config.isDetectDependencies()) {
            //        deps = new Dependency(config.files).run();
            //        config.dependencies = deps.putAll(config.dependencies);
        }

        // Feed builders with work.
        int builder_i = 0;
        for (final File path : config.getOrderedBuildFiles()) {
            builderQueues.get(builder_i).add(path);
            builder_i += 1;
            if (builder_i == buildersCount) {
                builder_i = 0;
            }
        }

        // Start build.
        for (int i = 0; i < buildersCount; i++) {
            final Runnable th = builderThreads.get(i);
            new Thread(th).start();
        }

        // Merge the result (based on build order).
        final List<File> objs = Lists.newArrayList();
        builder_i = 0;
        for (final File path : config.getOrderedBuildFiles()) {
            objs.add(builderQueues.get(builder_i).remove(0));
            builder_i += 1;
            if (builder_i == buildersCount) {
                builder_i = 0;
            }
        }

        if (anyObjFileBuilt) {
            try {
                FileUtils.touch(objsBuildDir);
            } catch (final IOException e) {
                Application.warn("Error touching build directory: " + e.getMessage());
            }
        }

        final List<File> appObjs = Lists.newArrayList(objs);
        final List<File> specObjs = Lists.newArrayList();
        if (config.isSpecMode()) {
            // Build spec files too, but sequentially.
            for (final File path : config.getSpecFiles()) {
                //specObjs.add(buildFile.run(path));
                objs.addAll(specObjs);
            }
        }

        // Generate init file.
        String initTxt =
                "#import <UIKit/UIKit.h>\n" +
                        "\n" +
                        "extern \"C\" {\n" +
                        "    void ruby_sysinit(int *, char ***);\n" +
                        "    void ruby_init(void);\n" +
                        "    void ruby_init_loadpath(void);\n" +
                        "    void ruby_script(const char *);\n" +
                        "    void ruby_set_argv(int, char **);\n" +
                        "    void rb_vm_init_compiler(void);\n" +
                        "    void rb_vm_init_jit(void);\n" +
                        "    void rb_vm_aot_feature_provide(const char *, void *);\n" +
                        "    void *rb_vm_top_self(void);\n" +
                        "    void rb_rb2oc_exc_handler(void);\n" +
                        "    void rb_exit(int);\n";

        //      app_objs.each do |_, init_func|
        //        init_txt << "void #{init_func}(void *, void *);\n"
        //      end
        initTxt +=
                "}\n" +
                        "\n" +
                        "extern \"C\"\n" +
                        "void\n" +
                        "RubyMotionInit(int argc, char **argv)\n" +
                        "{\n" +
                        "    static bool initialized = false;\n" +
                        "    if (!initialized) {\n" +
                        "	ruby_init();\n" +
                        "	ruby_init_loadpath();\n" +
                        "        if (argc > 0) {\n" +
                        "	    const char *progname = argv[0];\n" +
                        "	    ruby_script(progname);\n" +
                        "	}\n" +
                        "	try {\n" +
                        "	    void *self = rb_vm_top_self();\n";

        //      app_objs.each do |_, init_func|
        //        init_txt << "#{init_func}(self, 0);\n"
        //      end
        initTxt +=
                "	}\n" +
                        "	catch (...) {\n" +
                        "	    rb_rb2oc_exc_handler();\n" +
                        "	}\n" +
                        "	initialized = true;\n" +
                        "    }\n" +
                        "}\n";

        // Compile init file.
        final File init = new File(objsBuildDir, "init.mm");
        final File init_o = new File(objsBuildDir, "init.o");
        if (!(init.exists() && init_o.exists() && read(init).equals(initTxt))) {
            write(init, initTxt);
            sh(cxx + " \"" + init + "\" "+config.getCFlags(platform, true)+" -c -o \""+init_o+"\"");
        }

        if (isStaticLibrary) {
            // Create a static archive with all object files + the runtime.
            final File lib = new File(config.getVersionedBuildDir(platform), config.getName() + ".a");
            Application.info("Create", lib);
            final File libmacruby = new File(new File(dataDir, platform.getPlatform()), "libmacruby-static.a");
            final String objsList = "";//objs.map { |path, _| path }.unshift(init_o, *config.frameworks_stubs_objects(platform)).map { |x| "\"#{x}\"" }.join(' ')
            sh("/usr/bin/libtool -static \""+libmacruby+"\" "+objsList+" -o \""+lib+"\"");
            return lib;
        }

        // Generate main file.
        String mainTxt =
                "#import <UIKit/UIKit.h>\n" +
                        "\n" +
                        "extern \"C\" {\n" +
                        "    void rb_define_global_const(const char *, void *);\n" +
                        "    void rb_rb2oc_exc_handler(void);\n" +
                        "    void rb_exit(int);\n" +
                        "    void RubyMotionInit(int argc, char **argv);\n";

        if (config.isSpecMode()) {
            //        spec_objs.each do |_, init_func|
            //          main_txt << "void #{init_func}(void *, void *);\n"
            //        end
        }
        mainTxt += "}\n";

        if (config.isSpecMode()) {
            mainTxt +=
                    "@interface SpecLauncher : NSObject\n" +
                            "@end\n" +
                            "\n" +
                            "#include <dlfcn.h>\n" +
                            "\n" +
                            "@implementation SpecLauncher\n" +
                            "\n" +
                            "+ (id)launcher\n" +
                            "{\n" +
                            "    [UIApplication sharedApplication];\n" +
                            "\n" +
                            "    // Enable simulator accessibility.\n" +
                            "    // Thanks http://www.stewgleadow.com/blog/2011/10/14/enabling-accessibility-for-ios-applications/\n" +
                            "    NSString *simulatorRoot = [[[NSProcessInfo processInfo] environment] objectForKey:@\"IPHONE_SIMULATOR_ROOT\"];\n" +
                            "    if (simulatorRoot != nil) {\n" +
                            "        void *appSupportLibrary = dlopen([[simulatorRoot stringByAppendingPathComponent:@\"/System/Library/PrivateFrameworks/AppSupport.framework/AppSupport\"] fileSystemRepresentation], RTLD_LAZY);\n" +
                            "        CFStringRef (*copySharedResourcesPreferencesDomainForDomain)(CFStringRef domain) = (CFStringRef (*)(CFStringRef)) dlsym(appSupportLibrary, \"CPCopySharedResourcesPreferencesDomainForDomain\");\n" +
                            "\n" +
                            "        if (copySharedResourcesPreferencesDomainForDomain != NULL) {\n" +
                            "            CFStringRef accessibilityDomain = copySharedResourcesPreferencesDomainForDomain(CFSTR(\"com.apple.Accessibility\"));\n" +
                            "\n" +
                            "            if (accessibilityDomain != NULL) {\n" +
                            "                CFPreferencesSetValue(CFSTR(\"ApplicationAccessibilityEnabled\"), kCFBooleanTrue, accessibilityDomain, kCFPreferencesAnyUser, kCFPreferencesAnyHost);\n" +
                            "                CFRelease(accessibilityDomain);\n" +
                            "            }\n" +
                            "        }\n" +
                            "    }\n" +
                            "\n" +
                            "    // Load the UIAutomation framework.\n" +
                            "    dlopen(\"/Developer/Library/PrivateFrameworks/UIAutomation.framework/UIAutomation\", RTLD_LOCAL);\n" +
                            "\n" +
                            "    SpecLauncher *launcher = [[self alloc] init];\n" +
                            "    [[NSNotificationCenter defaultCenter] addObserver:launcher selector:@selector(appLaunched:) name:UIApplicationDidBecomeActiveNotification object:nil];\n" +
                            "    return launcher;\n" +
                            "}\n" +
                            "\n" +
                            "- (void)appLaunched:(id)notification\n" +
                            "{\n" +
                            "    // Give a bit of time for the simulator to attach...\n" +
                            "    [self performSelector:@selector(runSpecs) withObject:nil afterDelay:0.1];\n" +
                            "}\n" +
                            "\n" +
                            "- (void)runSpecs\n" +
                            "{\n";

            //        spec_objs.each do |_, init_func|
            //          main_txt << "#{init_func}(self, 0);\n"
            //        end
            mainTxt += "[NSClassFromString(@\"Bacon\") performSelector:@selector(run)];\n";
            mainTxt +=
                    "}\n" +
                            "\n" +
                            "@end\n";

        }
        mainTxt +=
                "int\n" +
                        "main(int argc, char **argv)\n" +
                        "{\n" +
                        "    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];\n" +
                        "    int retval = 0;\n" +
                        "    try {\n";

        if (config.isSpecMode()) {
            mainTxt += "[SpecLauncher launcher];\n";
        }
        mainTxt +=
                "        RubyMotionInit(argc, argv);\n";

        final String rubymotionEnv;
        if (config.isSpecMode()) {
            rubymotionEnv = "test";
        } else {
            rubymotionEnv = config.isDevelopment() ? "development" : "release";
        }
        mainTxt += "rb_define_global_const(\"RUBYMOTION_ENV\", @\"#{rubymotion_env}\");\n";
        mainTxt += "rb_define_global_const(\"RUBYMOTION_VERSION\", @\"#{Motion::Version}\");\n";
        mainTxt +=
                "        retval = UIApplicationMain(argc, argv, nil, @\"#{config.delegate_class}\");\n" +
                        "        rb_exit(retval);\n" +
                        "    }\n" +
                        "    catch (...) {\n" +
                        "	rb_rb2oc_exc_handler();\n" +
                        "    }\n" +
                        "    [pool release];\n" +
                        "    return retval;\n" +
                        "}\n";

        // Compile main file.
        final File main = new File(objsBuildDir, "main.mm");
        final File main_o = new File(objsBuildDir, "main.o");
        if (!(main.exists() && main_o.exists() && read(main).equals(mainTxt))) {
            write(main, mainTxt);
            sh(cxx+" \""+main+"\" "+config.getCFlags(platform, true)+" -c -o \""+main_o+"\"");
        }

        // Prepare bundle.
        final File bundlePath = config.getAppBundle(platform);
        if (!bundlePath.exists()) {
            Application.info("Create", bundlePath);
            bundlePath.mkdirs();
        }

        // Link executable.
        final File mainExec = config.getAppBundleExecutable(platform);
        boolean mainExecCreated = false;
        boolean modified = false;
        for (final File path : objs) {
            if (path.lastModified() > mainExec.lastModified()) {
                modified = true;
                break;
            }
        }
        for (final File lib  : vendorLibs) {
            if (lib.lastModified() > mainExec.lastModified()) {
                modified = true;
                break;
            }
        }
        if (!mainExec.exists()
                || config.getProjectFile().lastModified() > mainExec.lastModified()
                || modified
                || main_o.lastModified() > mainExec.lastModified()
                || new File(new File(dataDir, platform.getPlatform()), "libmacruby-static.a").lastModified() > mainExec.lastModified()) {
            Application.info("Link", mainExec);
            for (final File path : config.getFrameworksStubsObjects(platform)) {
                objs.add(0, path);
            }
            objs.add(0, main_o);
            objs.add(0, init_o);
            final String objsList = StringUtils.join(Lists.transform(objs, new Function<File, String>() {
                public String apply(final File x) {
                    return "\"" + x + "\"";
                }
            }), " ");
            final String frameworkSearchPaths = StringUtils.join(Lists.transform(config.getFrameworkSearchPaths(), new Function<File, String>() {
                public String apply(final File x) {
                    return "-F" + x.getAbsolutePath();
                }
            }), " ");
            final String frameworks = StringUtils.join(Lists.transform(config.getFrameworksDependencies(), new Function<String, String>() {
                public String apply(final String x) {
                    return "-framework " + x;
                }
            }), " ");
            final String weakFrameworks = StringUtils.join(Lists.transform(config.getWeakFrameworks(), new Function<String, String>() {
                public String apply(final String x) {
                    return "-weak_framework " + x;
                }
            }), " ");
            final String forceLoads = StringUtils.join(Lists.transform(vendorLibs, new Function<File, String>() {
                public String apply(final File x) {
                    return "-force_load \"" + x + "\"";
                }
            }), " ");

            sh(cxx+" -o \""+mainExec+"\" "+objsList+" "+config.getLdFlags(platform)+" -L"+new File(dataDir, platform.getPlatform())+" -lmacruby-static -lobjc -licucore "+frameworkSearchPaths+" "+frameworks+" "+weakFrameworks+" "+StringUtils.join(config.getLibs(), " ") + " "+ forceLoads);
            mainExecCreated = true;
        }

        // Create bundle/Info.plist.
        final File bundleInfoPlist = new File(bundlePath, "Info.plist");
        if (!bundleInfoPlist.exists() || config.getProjectFile().lastModified() > bundleInfoPlist.lastModified()) {
            Application.info("Create", bundleInfoPlist);
            write(bundleInfoPlist, config.getInfoPlistData());
            sh("/usr/bin/plutil -convert binary1 \""+bundleInfoPlist+"\"");
        }

        // Create bundle/PkgInfo.
        final File bundlePkgInfo = new File(bundlePath, "PkgInfo");
        if (!bundlePkgInfo.exists() || config.getProjectFile().lastModified() > bundlePkgInfo.lastModified()) {
            Application.info("Create", bundlePkgInfo);
            //File.open(bundlePkgInfo, 'w') { |io| io.write(config.getPkgInfoData) }
        }

        // Compile IB resources.
        if (config.getResourcesDir().exists()) {
            final List<File> ibResourcesSrc = Lists.newArrayList();
            final List<File> ibResourcesDest = Lists.newArrayList();
            for (final File path : FileUtils.listFiles(config.getResourcesDir(), new String[] {"xib", "storyboard"}, true)) {
                ibResourcesSrc.add(path);
                ibResourcesDest.add(new File(path.getPath().replaceFirst(".xib", ".nib").replaceFirst(".storyboard", ".storyboardc")));
            }
            assert ibResourcesSrc.size() == ibResourcesDest.size();
            for (int i = 0; i < ibResourcesSrc.size(); i++) {
                final File src = ibResourcesSrc.get(i);
                final File dest = ibResourcesDest.get(i);
                if (!dest.exists() || src.lastModified() > dest.lastModified()) {
                    Application.info("Compile", src);
                    sh("/usr/bin/ibtool --compile \""+dest+"\" \""+src+"\"");
                }
            }
        }

        // Compile CoreData Model resources.
        if (config.getResourcesDir().exists()) {
            final Collection<File> models = FileUtils.listFiles(config.getResourcesDir(), new String[] {"xcdatamodeld"}, true);
            for (final File model : models) {
                final File momd = new File(model.getPath().replaceFirst(".xcdatamodeld", ".momd"));
                if (!momd.exists() || model.lastModified() > momd.lastModified()) {
                    Application.info("Compile", model);
                    // momc wants absolute paths.
                    sh("\"" + config.getXcodeDir() + "/usr/bin/momc\" \"" + model.getAbsolutePath() + "\" \"" + momd.getAbsolutePath() + "\"");
                }
            }
        }

        // Copy resources, handle subdirectories.
        final Set<String> reservedAppBundleFiles = Sets.newHashSet(
                "_CodeSignature/CodeResources", "CodeResources", "embedded.mobileprovision",
                "Info.plist", "PkgInfo", "ResourceRules.plist",
                config.getName()
                );
        Collection<File> resourcesFiles = Lists.newArrayList();
        if (config.getResourcesDir().exists()) {
            resourcesFiles = FileUtils.listFilesAndDirs(config.getResourcesDir(),
                    new NotFileFilter(new SuffixFileFilter(new String[] {"xib", "storyboard", "xcdatamodeld", "lproj"})),
                    DirectoryFileFilter.DIRECTORY);
            for (final File resPath : resourcesFiles) {
                if (reservedAppBundleFiles.contains(resPath)) {
                    Application.fail("Cannot use '"+resPath+"' as a resource file because it's a reserved application bundle file");
                }
                final File destPath = new File(bundlePath, resPath.getPath());
                if (!destPath.exists() || resPath.lastModified() > destPath.lastModified()) {
                    destPath.getParentFile().mkdirs();
                    Application.info("Copy", resPath);
                    try {
                        FileUtils.copyFileToDirectory(resPath, destPath.getParentFile());
                    } catch (final IOException e) {
                        Application.warn("Error copying resource: " + resPath);
                    }
                }
            }
        }

        // Delete old resource files.
        final Collection<File> bundleResources = FileUtils.listFiles(
                config.getResourcesDir(),
                new WildcardFileFilter("**/*"),
                DirectoryFileFilter.DIRECTORY);
        for (final File bundleRes : bundleResources) {
            if (bundleRes.isDirectory()) continue;
            if (reservedAppBundleFiles.contains(bundleRes)) continue;
            if (resourcesFiles.contains(bundleRes)) continue;
            Application.warn("File `#{bundle_res}' found in app bundle but not in `#{config.resources_dir}', removing");
            FileUtils.deleteQuietly(bundleRes);
        }

        // Generate dSYM.
        final File dSymPath = config.getAppBundle_dSym(platform);
        if (!dSymPath.exists() || mainExec.lastModified() > dSymPath.lastModified()) {
            Application.info("Create", dSymPath);
            sh("/usr/bin/dsymutil \""+mainExec+"\" -o \""+dSymPath+"\"");
        }

        // Strip all symbols. Only in distribution mode.
        if (mainExecCreated && config.isDistributionMode()) {
            Application.info("Strip", mainExec);
            sh(config.locateBinary("strip")+" \""+mainExec+"\"");
        }
        return null;
    }

    public static void codeSign(final Configuration config, final Platform platform) {
        final File bundlePath = config.getAppBundle(platform);
        if (bundlePath.exists()) {
            throw new IllegalStateException();
        }

        // Create bundle/ResourceRules.plist.
        final File resourceRulesPlist = new File(bundlePath, "ResourceRules.plist");
        if (!resourceRulesPlist.exists()) {
            Application.info("Create", resourceRulesPlist);
            write(resourceRulesPlist,
                    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                            "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                            "<plist version=\"1.0\">\n" +
                            "<dict>\n" +
                            "        <key>rules</key>\n" +
                            "        <dict>\n" +
                            "                <key>.*</key>\n" +
                            "                <true/>\n" +
                            "                <key>Info.plist</key>\n" +
                            "                <dict>\n" +
                            "                        <key>omit</key>\n" +
                            "                        <true/>\n" +
                            "                        <key>weight</key>\n" +
                            "                        <real>10</real>\n" +
                            "                </dict>\n" +
                            "                <key>ResourceRules.plist</key>\n" +
                            "                <dict>\n" +
                            "                        <key>omit</key>\n" +
                            "                        <true/>\n" +
                            "                        <key>weight</key>\n" +
                            "                        <real>100</real>\n" +
                            "                </dict>\n" +
                            "        </dict>\n" +
                            "</dict>\n" +
                    "</plist>");
        }

        // Copy the provisioning profile.
        final File bundleProvision = new File(bundlePath, "embedded.mobileprovision");
        if (!bundleProvision.exists() || config.getProvisioningProfile().lastModified() > bundleProvision.lastModified()) {
            Application.info("Create", bundleProvision);
            try {
                FileUtils.copyFile(config.getProvisioningProfile(), bundleProvision);
            } catch (final IOException e) {
                Application.warn("Error copying provisioning profile: " + e.getMessage());
            }
        }

        // Codesign.
        final String codeSignCmd = "CODESIGN_ALLOCATE=\"#{new File(config.platform_dir(platform), 'Developer/usr/bin/codesign_allocate')}\" /usr/bin/codesign";
        if (config.getProjectFile().lastModified() > bundlePath.lastModified()
                || !system(codeSignCmd+" --verify \""+bundlePath+"\" >& /dev/null")) {
            Application.info("Codesign", bundlePath);
            final File entitlements = new File(config.getVersionedBuildDir(platform), "Entitlements.plist");
            write(entitlements, config.getEntitlementsData());
            sh(codeSignCmd+" -f -s \""+config.getCodeSignCertificate()+"\" --resource-rules=\""+resourceRulesPlist+"\" --entitlements "+entitlements+" \""+bundlePath+"\"");
        }
    }

    public static void archive(final Configuration config) {
        // Create .ipa archive.
        final File appBundle = config.getAppBundle(Platform.IPHONE_OS);
        final File archive = config.getArchive();
        if (!archive.exists() || appBundle.lastModified() > archive.lastModified()) {
            Application.info("Create", archive);
            final File tmp = new File("/tmp/ipa_root");
            sh("/bin/rm -rf "+tmp);
            sh("/bin/mkdir -p "+tmp+"/Payload");
            sh("/bin/cp -r \""+appBundle+"\" "+tmp+"/Payload");
            sh("/bin/chmod -R 755 Payload", tmp);
            sh("/usr/bin/zip -q -r archive.zip Payload", tmp);
            //sh("/bin/chmod -R 755 "+tmp+"/Payload";
            //sh("/usr/bin/zip -q -r "+tmp+"/archive.zip "+tmp+"/Payload");
            sh("/bin/cp "+tmp+"/archive.zip \""+archive+"\"");
        }

        /*
      # Create .xcarchive. Only in release mode.
      if config.release?
        xcarchive = new File(File.dirname(app_bundle), config.name + '.xcarchive')
        if !File.exist?(xcarchive) or File.mtime(app_bundle) > File.mtime(xcarchive)
          Application.info 'Create', xcarchive
          apps = new File(xcarchive, 'Products', 'Applications')
          FileUtils.mkdir_p apps
          sh "/bin/cp -r \"#{app_bundle}\" \"#{apps}\""
          dsyms = new File(xcarchive, 'dSYMs')
          FileUtils.mkdir_p dsyms
          sh "/bin/cp -r \"#{config.app_bundle_dsym('iPhoneOS')}\" \"#{dsyms}\""
          app_path = "Applications/#{config.name}.app"
          info_plist = {
            'ApplicationProperties' => {
              'ApplicationPath' => app_path,
              'CFBundleIdentifier' => config.identifier,
              'IconPaths' => config.icons.map { |x| new File(app_path, x) },
            },
            'ArchiveVersion' => 1,
            'CreationDate' => Time.now,
            'Name' => config.name,
            'SchemeName' => config.name
          }
          File.open(new File(xcarchive, 'Info.plist'), 'w') do |io|
            io.write Motion::PropertyList.to_s(info_plist)
          end
        end
      end
         */
    }

    /*  private static class Dependency {
//      require 'ripper'
//    rescue LoadError
//      $:.unshift(File.expand_path(new File(File.dirname(__FILE__), '../../ripper18')))
//      require 'ripper'
//    end

    private List<File> file_paths = Lists.newArrayList();

    public Dependency(final List<File> paths) {
      file_paths = Lists.newArrayList(paths);
      Collections.sort(file_paths);
    }

    private boolean cyclic(Map<File, List<File>> dependencies, File def_path, File ref_path) {
      List<File> deps = dependencies.get(def_path);
      if (deps != null) {
        if (deps.contains(ref_path)) {
          return true;
        }
        for (final File file : deps) {
        	if (cyclic(dependencies, file, ref_path)) {
        		return true;
        	}
        }
      }
      return false;
    }

    private Map<File, List<File>> run() {
      final Map<String, File> consts_defined = Maps.newHashMap();
      final Map<String, List<File>> consts_referred = Maps.newHashMap();
      for (final File path : file_paths) {
        final Constant parser = new Constant(Files.read(path));
        parser.parse();
        for (final Constant constant : parser.defined) {
          consts_defined.put(constant, path);
        }
        for (final Constant constant : parser.referred) {
          if (!consts_referred.containsKey(constant)) {
        	  consts_referred.out(constant, Lists.newArrayList());
          }
          consts_referred.get(constant).add(path);
        }
      }

      final Map<File, List<File>> dependency = Maps.newHashMap();
      for (Entry<String, File> entry : consts_defined) {
		final String constant = entry.getKey();
		final File def_path = entry.getValue();
        if (consts_referred.get(constant)) {
          for (final File ref_path : consts_referred.get(constant)) {
            if (!def_path.equals(ref_path)) {
              if (cyclic(dependency, def_path, ref_path)) {
                // remove cyclic dependencies
                continue;
              }

              if (!dependency.containsKey(ref_path)) {
            	  dependency.put(ref_path, Lists.newArrayList());
              }
              dependency.get(ref_path).add(def_path);
              //dependency.get(ref_path).uniq();
            }
          }
        }
      }

      return dependency;
    }

    private static class Constant < Ripper::SexpBuilder {
      private List<Boolean> defined;
      private List<Boolean> referred;

      public Constant(source) {
          super();
        defined  = Lists.newArrayList();
        referred = Lists.newArrayList();
      }

      public void on_const_ref(String[] args) {
        type, const_name, position = args;
        defined.add(const_name);
      }

      public void on_var_field(String[] args) {
        type, name, position = args;
        if (type.equals(constant) {
          defined.add(name);
        }
      }

      public void on_var_ref(String[] args) {
        type, name, position = args;
        if (type.equals(constant)) {
          referred.add(name);
        }
      }

      public void on_const_path_ref(String parent, String[] args) {
        on_var_ref(args);
      }
    }
  }*/

    private Builder() {
    }
}
