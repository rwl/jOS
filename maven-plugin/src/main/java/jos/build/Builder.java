package jos.build;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang.StringUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Builder {

    public void build(final Configuration config, final String platform,
    		final Map<String, String> opts) {
      final File datadir = config.datadir();
      final String archs = config.archs().get(platform);

      final boolean static_library = opts.remove("static");

      final java.io.File ruby = new File(config.bindir(), "ruby");
      final File llc = new File(config.bindir(), "llc");

      if (config.spec_mode && config.spec_files.isEmpty()) {
        Application.fail("No spec files in '"+config.specs_dir+"'");
      }

      // Locate SDK and compilers.
      final String sdk = config.sdk(platform);
      final File cc = config.locate_compiler(platform, "gcc");
      final File cxx = config.locate_compiler(platform, "clang++");

      final File build_dir = new File(config.versionized_build_dir(platform));
      Application.info("Build", build_dir);

      // Prepare the list of BridgeSupport files needed.
      final List<File> bs_files = config.bridgesupport_files();

      // Build vendor libraries.
      final List<File> vendor_libs = Lists.newArrayList();
      for (Vendor vendor_project : config.vendor_projects) {
    	  vendor_project.build(platform);
    	  vendor_libs.addAll(vendor_project.libs);
    	  bs_files.addAll(vendor_project.bs_files);
      }

      // Build object files.
      final File objs_build_dir = new File(build_dir, "objs");
      objs_build_dir.mkdirs();
      boolean any_obj_file_built = false;
      {
//      build_file = Proc.new do |path|
//        rpath = path
        path = path.getAbsolutePath();
        final java.io.File obj = new File(objs_build_dir, path.getCanonicalPath() + ".o");
        final boolean should_rebuild = (!obj.exists()
            || path.lastModified() > obj.lastModified()
            || ruby.lastModified() > obj.lastModified());

        // Generate or retrieve init function.
        final String init_func;// = should_rebuild ? "MREP_#{`/usr/bin/uuidgen`.strip.gsub('-', '')}" : `#{config.locate_binary('nm')} \"#{obj}\"`.scan(/T\s+_(MREP_.*)/)[0][0]

        if (should_rebuild) {
          Application.info("Compile", rpath);
          obj.getParentFile().mkdirs();
          final List<File> arch_objs = Lists.newArrayList();
          for (final java.io.File arch : archs) {
            // Locate arch kernel.
            final File kernel = new File(datadir, platform, "kernel-"+arch.getName()+".bc");
            if (!kernel.exists()) {
            	throw new IllegalStateException("Can't locate kernel file");
            }

            // LLVM bitcode.
            final File bc = new File(objs_build_dir, path + arch + ".bc");
            final List<String> bs_flags_list = Lists.newArrayList();
            for (final File x : bs_files) {
				bs_flags_list.add("--uses-bs \""+ x + "\" ");
			}
            final String bs_flags = StringUtils.join(bs_flags_list, " ");
            //sh "/usr/bin/env VM_KERNEL_PATH=\"#{kernel}\" VM_OPT_LEVEL=\"#{config.opt_level}\" #{ruby} #{bs_flags} --emit-llvm \"#{bc}\" #{init_func} \"#{path}\""

            // Assembly.
            final File asm = new File(objs_build_dir, path + arch + ".s");
            final String llc_arch;
            if (arch.equals("i386")) {
            	llc_arch = "x86";
            } else if (arch.equals("x86_64")) {
            	llc_arch = "x86-64";
            } else if (arch.matches("^arm")) {
            	llc_arch = "arm";
            } else{
            	llc_arch = arch;
            }
            //sh "#{llc} \"#{bc}\" -o=\"#{asm}\" -march=#{llc_arch} -relocation-model=pic -disable-fp-elim -jit-enable-eh -disable-cfi"

            // Object.
            final File arch_obj = new File(objs_build_dir, path + arch+".o");
            //sh "#{cc} -fexceptions -c -arch #{arch} \"#{asm}\" -o \"#{arch_obj}\""

            bc.delete();
            asm.delete();
            arch_objs.add(arch_obj);
          }

          // Assemble fat binary.
          final String arch_objs_list = StringUtils.join(Lists.transform(arch_objs, new Function<File, String>() {
        	  String apply(File x) { return "\"" + x+ "\""; }
          }
        		  ), " ");
          //sh "/usr/bin/lipo -create #{arch_objs_list} -output \"#{obj}\""
        }

        any_obj_file_built = true;
        //[obj, init_func]
      }

      // Create builders.
      int builders_count;
      if (ENV["jobs"] != null) {
    	  builders_count = Integer.valueOf(ENV["jobs"]);
      } else {
    	  builders_count = 0;//`/usr/sbin/sysctl -n machdep.cpu.thread_count`.strip.to_i
      }
      if (builders_count < 1) {
    	  builders_count = 1;
      }
//      builders = []
//      builders_count.times do
//        queue = []
//        th = Thread.new do
//          sleep
//          objs = []
//          while path = queue.shift
//            objs << build_file.call(path)
//          end
//          queue.concat(objs)
//        end
//        builders << [queue, th]
//      end

      // Resolve file dependencies
      if (config.detect_dependencies) {
        deps = new Dependency(config.files).run();
        config.dependencies = deps.putAll(config.dependencies);
      }

      // Feed builders with work.
      int builder_i = 0;
      for (final File path : config.ordered_build_files()) {
		builders[builder_i][0].add(path);
        builder_i += 1;
        if (builder_i == builders_count) {
        	builder_i = 0;
        }
      }

      // Start build.
//      builders.each do |queue, th|
//        sleep 0.01 while th.status != 'sleep'
//        th.wakeup
//      end
//      builders.each { |queue, th| th.join }

      // Merge the result (based on build order).
      final List<File> objs = Lists.newArrayList();
      int builder_i = 0;
      for (final File path : config.ordered_build_files()) {
        objs.add(builders[builder_i][0].remove(0));
        builder_i += 1;
        if (builder_i == builders_count) {
        	builder_i = 0;
        }
      }

      if (any_obj_file_built) {
    	  FileUtils.touch(objs_build_dir);
      }

      app_objs = objs;
      final List<File> spec_objs = Lists.newArrayList();
      if (config.spec_mode) {
        // Build spec files too, but sequentially.
        spec_objs = config.spec_files.map { |path| build_file.call(path) }
        objs += spec_objs
      }

      // Generate init file.
      final String init_txt =
"#import <UIKit/UIKit.h>\n" +
"\n" +
"extern "C" {\n" +
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
"    void rb_exit(int);\n"

//      app_objs.each do |_, init_func|
//        init_txt << "void #{init_func}(void *, void *);\n"
//      end
      init_txt += \
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
      init_txt += \
"	}\n" +
"	catch (...) {\n" +
"	    rb_rb2oc_exc_handler();\n" +
"	}\n" +
"	initialized = true;\n" +
"    }\n" +
"}\n";

      // Compile init file.
      final File init = new File(objs_build_dir, "init.mm");
      final File init_o = new File(objs_build_dir, "init.o");
      if !(init.exists() && init_o.exist() && Files.read(init).equals(init_txt)) {
        Files.open(init, 'w') { |io| io.write(init_txt) }
        //sh "#{cxx} \"#{init}\" #{config.cflags(platform, true)} -c -o \"#{init_o}\""
      }

      if (static_library) {
        // Create a static archive with all object files + the runtime.
        final File lib = new File(config.versionized_build_dir(platform), config.name + ".a");
        Application.info("Create", lib);
        final File libmacruby = new File(datadir, platform, "libmacruby-static.a");
        objs_list = objs.map { |path, _| path }.unshift(init_o, *config.frameworks_stubs_objects(platform)).map { |x| "\"#{x}\"" }.join(' ')
        //sh "/usr/bin/libtool -static \"#{libmacruby}\" #{objs_list} -o \"#{lib}\""
        return lib;
      }

      // Generate main file.
      String main_txt = \
"#import <UIKit/UIKit.h>\n" +
"\n" +
"extern "C" {\n" +
"    void rb_define_global_const(const char *, void *);\n" +
"    void rb_rb2oc_exc_handler(void);\n" +
"    void rb_exit(int);\n" +
"    void RubyMotionInit(int argc, char **argv);\n";

      if (config.spec_mode) {
//        spec_objs.each do |_, init_func|
//          main_txt << "void #{init_func}(void *, void *);\n"
//        end
      }
      main_txt += "}\n";

      if (config.spec_mode) {
        main_txt += \
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
        main_txt += "[NSClassFromString(@\"Bacon\") performSelector:@selector(run)];\n";
        main_txt += \
"}\n" +
"\n" +
"@end\n";

      }
      main_txt += \
"int\n" +
"main(int argc, char **argv)\n" +
"{\n" +
"    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];\n" +
"    int retval = 0;\n" +
"    try {\n";

      if (config.spec_mode) {
    	  main_txt += "[SpecLauncher launcher];\n";
      }
      main_txt += \
"        RubyMotionInit(argc, argv);\n";

      final String rubymotion_env;
      if (config.spec_mode) {
    	  rubymotion_env = "test";
      } else {
    	  rubymotion_env = config.development() ? "development" : "release";
      }
      main_txt += "rb_define_global_const(\"RUBYMOTION_ENV\", @\"#{rubymotion_env}\");\n";
      main_txt += "rb_define_global_const(\"RUBYMOTION_VERSION\", @\"#{Motion::Version}\");\n";
      main_txt += \
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
      final File main = new File(objs_build_dir, "main.mm");
      final File main_o = new File(objs_build_dir, "main.o");
      if (!(main.exists() && main_o.exists() && Files.read(main).equals(main_txt))) {
        //Files.open(main, 'w') { |io| io.write(main_txt) }
        //sh "#{cxx} \"#{main}\" #{config.cflags(platform, true)} -c -o \"#{main_o}\""
      }

      // Prepare bundle.
      final File bundle_path = config.app_bundle(platform);
      if (!bundle_path.exists()) {
        Application.info("Create", bundle_path);
        bundle_path.mkdirs();
      }

      // Link executable.
      final File main_exec = config.app_bundle_executable(platform);
      boolean main_exec_created = false;
      if (!main_exec.exists()
          || config.project_file.lastModified() > main_exec.lastModified()
          || objs.any? { |path, _| path.lastModified() > main_exec.lastModified() }
          || main_o.lastModified() > main_exec.lastModified()
          || vendor_libs.any? { |lib| lib.lastModified() > main_exec.lastModified() }
          || new File(datadir, platform, "libmacruby-static.a").lastModified() > main_exec.lastModified()) {
        Application.info("Link", main_exec);
        objs_list = objs.map { |path, _| path }.unshift(init_o, main_o, *config.frameworks_stubs_objects(platform)).map { |x| "\"#{x}\"" }.join(' ')
        framework_search_paths = config.framework_search_paths.map { |x| "-F#{File.expand_path(x)}" }.join(' ')
        frameworks = config.frameworks_dependencies.map { |x| "-framework #{x}" }.join(' ')
        weak_frameworks = config.weak_frameworks.map { |x| "-weak_framework #{x}" }.join(' ')
        sh "#{cxx} -o \"#{main_exec}\" #{objs_list} #{config.ldflags(platform)} -L#{new File(datadir, platform)} -lmacruby-static -lobjc -licucore #{framework_search_paths} #{frameworks} #{weak_frameworks} #{config.libs.join(' ')} #{vendor_libs.map { |x| '-force_load "' + x + '"' }.join(' ')}"
        main_exec_created = true;
      }

      // Create bundle/Info.plist.
      final File bundle_info_plist = new File(bundle_path, "Info.plist");
      if (!bundle_info_plist.exists() || config.project_file.lastModified() > bundle_info_plist.lastModified()) {
        Application.info("Create", bundle_info_plist);
        //File.open(bundle_info_plist, 'w') { |io| io.write(config.info_plist_data) }
        //sh "/usr/bin/plutil -convert binary1 \"#{bundle_info_plist}\""
      }

      // Create bundle/PkgInfo.
      final File bundle_pkginfo = new File(bundle_path, "PkgInfo");
      if (!bundle_pkginfo.exists() || config.project_file.lastModified() > bundle_pkginfo.lastModified()) {
        Application.info("Create", bundle_pkginfo);
        //File.open(bundle_pkginfo, 'w') { |io| io.write(config.pkginfo_data) }
      }

      // Compile IB resources.
      if (config.resources_dir.exists()) {
        final List<File> ib_resources = Lists.newArrayList();
        ib_resources.concat((Dir.glob(new File(config.resources_dir, '**', '*.xib')) + Dir.glob(new File(config.resources_dir, '*.lproj', '*.xib'))).map { |xib| [xib, xib.sub(/\.xib$/, '.nib')] })
        ib_resources.concat(Dir.glob(new File(config.resources_dir, '**', '*.storyboard')).map { |storyboard| [storyboard, storyboard.sub(/\.storyboard$/, '.storyboardc')] })
        ib_resources.each do |src, dest|
          if (!dest.exists() || src.lastModified() > dest.lastModified()) {
            Application.info("Compile", src);
            //sh "/usr/bin/ibtool --compile \"#{dest}\" \"#{src}\""
          }
        end
      end

      // Compile CoreData Model resources.
      if (config.resources_dir.exists()) {
        final Collection<File> models = FileUtils.listFiles(
        		config.resources_dir(),
					FileFilterUtils.suffix(".xcdatamodeld"),
					DirectoryFileFilter.DIRECTORY);
        for (final File model : models) {
          momd = model.sub("\.xcdatamodeld$", ".momd");
          if (!momd.exists() || model.lastModified() > momd.lastModified()) {
            Application.info("Compile", model);
            // momc wants absolute paths.
            //sh "\"" + Application.config.xcode_dir() + "/usr/bin/momc\" \"" + model.getAbsolutePath()+"\" \""+momd.getAbsolutePath()+"\"";
          }
        }
      }

      // Copy resources, handle subdirectories.
      final String[] reserved_app_bundle_files = new String[] {
        "_CodeSignature/CodeResources", "CodeResources", "embedded.mobileprovision",
        "Info.plist", "PkgInfo", "ResourceRules.plist",
        config.name
      };
      final List<String> resources_files = Lists.newArrayList();
      if (config.resources_dir.exists()) {
        resources_files = Dir.chdir(config.resources_dir) do
          Dir.glob('**{,/*/**}/*').reject { |x| ['.xib', '.storyboard', '.xcdatamodeld', '.lproj'].include?(File.extname(x)) }
        end
        for (final String res : resources_files) {
          final File res_path = new File(config.resources_dir, res);
          if (reserved_app_bundle_files.contains(res)) {
            Application.fail("Cannot use `#{res_path}' as a resource file because it's a reserved application bundle file");
          }
          final File dest_path = new File(bundle_path, res);
          if (!dest_path.exists() || res_path.lastModified() > dest_path.lastModified()) {
            dest_path.getParentFile().mkdirs();
            Application.info("Copy", res_path);
            FileUtils.copy(res_path, dest_path.getParentFile());
          }
        }
      }

      // Delete old resource files.
      final Collection<File> bundle_resources = FileUtils.listFiles(
      		config.resources_dir(),
      		new WildcardFileFilter("**/*"),
      		DirectoryFileFilter.DIRECTORY);
      for (final File bundle_res : bundle_resources) {
          if (bundle_res.isDirectory()) continue;
          if (reserved_app_bundle_files.contains(bundle_res)) continue;
          if (resources_files.contains(bundle_res)) continue;
          Application.warn("File `#{bundle_res}' found in app bundle but not in `#{config.resources_dir}', removing");
          FileUtils.remove(bundle_res);
      }

      // Generate dSYM.
      final File dsym_path = config.app_bundle_dsym(platform);
      if (!dsym_path.exists() || main_exec.lastModified() > dsym_path.lastModified()) {
        Application.info("Create", dsym_path);
        //sh "/usr/bin/dsymutil \"#{main_exec}\" -o \"#{dsym_path}\""
      }

      // Strip all symbols. Only in distribution mode.
      if (main_exec_created && config.distribution_mode()) {
        Application.info("Strip", main_exec);
        //sh "#{config.locate_binary('strip')} \"#{main_exec}\""
      }
    }

    public void codesign(final Configuration config, final String platform) {
      final File bundle_path = config.app_bundle(platform);
      if (bundle_path.exists()) {
    	  throw new IllegalStateException();
      }

      // Create bundle/ResourceRules.plist.
      final File resource_rules_plist = new File(bundle_path, "ResourceRules.plist");
      if (!resource_rules_plist.exists()) {
        Application.info("Create", resource_rules_plist);
        File.open(resource_rules_plist, 'w') do |io|
          io.write(
"<?xml version="1.0" encoding="UTF-8"?>\n" +
"<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
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
      final File bundle_provision = new File(bundle_path, "embedded.mobileprovision");
      if (!bundle_provision.exists() || config.provisioning_profile.lastmodified() > bundle_provision.lastmodified()) {
        Application.info("Create", bundle_provision);
        FileUtils.copy(config.provisioning_profile, bundle_provision);
      }

      // Codesign.
      final String codesign_cmd = "CODESIGN_ALLOCATE=\"#{new File(config.platform_dir(platform), 'Developer/usr/bin/codesign_allocate')}\" /usr/bin/codesign";
      if (config.project_file.lastmodified() > bundle_path.lastmodified())
          || !system("#{codesign_cmd} --verify \"#{bundle_path}\" >& /dev/null")) {
        Application.info("Codesign", bundle_path);
        final File entitlements = new File(config.versionized_build_dir(platform), "Entitlements.plist");
        //File.open(entitlements, 'w') { |io| io.write(config.entitlements_data) }
        //sh "#{codesign_cmd} -f -s \"#{config.codesign_certificate}\" --resource-rules=\"#{resource_rules_plist}\" --entitlements #{entitlements} \"#{bundle_path}\"";
      }
    }

    public void archive(final Configuration config) {
      // Create .ipa archive.
      final File app_bundle = config.app_bundle("iPhoneOS");
      final File archive = config.archive();
      if (!archive.exists() || app_bundle.lastModified() > archive.lastModified()) {
        Application.info("Create", archive);
        final String tmp = "/tmp/ipa_root";
        sh("/bin/rm -rf "+tmp);
        sh("/bin/mkdir -p "+tmp+"/Payload");
        sh("/bin/cp -r \""+app_bundle+"\" "+tmp+"/Payload");
//        Dir.chdir(tmp) do
//            sh "/bin/chmod -R 755 Payload"
//            sh "/usr/bin/zip -q -r archive.zip Payload"
//          end
        sh("/bin/chmod -R 755 "+tmp+"/Payload";
        sh("/usr/bin/zip -q -r "+tmp+"/archive.zip "+tmp+"/Payload");
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

  private static class Dependency {
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

    private static class Constant /*< Ripper::SexpBuilder*/ {
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
  }
}
