package jos.maven.ios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import jos.build.Configuration;
import jos.build.types.BuildMode;
import jos.build.types.Family;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

public abstract class AbstractMojo extends org.apache.maven.plugin.AbstractMojo {

	@Component
	MavenProject project;

	@Parameter(defaultValue = "${localRepository}", required = true, readonly = true)
	ArtifactRepository localRepository;

	@Parameter(defaultValue = "${basedir}/src/main/objc", required = true)
	File sourceDirectory;

	@Parameter(defaultValue = "${project.build.directory}", required = true)
	File targetDirectory;

	@Parameter(defaultValue = "${basedir}/src/main/resources", required = true)
	File resourcesDirectory;

	@Parameter(defaultValue = "${project.artifactId}", required = true)
	String name;

	@Parameter
	File[] libraries;

	@Parameter
	File[] includes;

	@Parameter
	String delegateClassName;

	@Parameter
	String[] families;

	@Parameter
	String[] icons;

	Configuration getConfig(final BuildMode buildMode) throws MojoExecutionException {
        final Configuration config = new Configuration(project.getBasedir(),
                buildMode);
        config.setSourceDir(sourceDirectory);
        config.setBuildDir(targetDirectory);
        config.setResourcesDir(resourcesDirectory);
        config.setName(name);

        final List<File> libs = Lists.newArrayList();
        final List<File> headers = Lists.newArrayList();
        if (libraries != null) {
        	libs.addAll(Lists.newArrayList(libraries));
        }
        if (includes != null) {
        	headers.addAll(Lists.newArrayList(includes));
        }
        for (Iterator<?> i = project.getDependencyArtifacts().iterator(); i.hasNext(); ) {
        	Artifact artifact = (Artifact) i.next();
        	File file = new File(localRepository.getBasedir(), localRepository.pathOf(artifact));

        	if (!file.exists()) {
        		continue;
        	}

        	final String classifier = artifact.getClassifier();
        	final String type = artifact.getType();
        	if ("library".equals(classifier) && "a".equals(type)) {
        		if (!file.getName().startsWith("lib")) {
        			final File lib = new File(file.getParentFile(), "lib" + file.getName());
        			if (!lib.exists()) {
	        			try {
							Files.copy(file, lib);
						} catch (IOException e) {
		            		throw new MojoExecutionException("Error copying library", e);
						}
        			}
            		getLog().info("Adding renamed library: " + lib.getAbsolutePath());
        			libs.add(lib);
        		} else {
            		getLog().info("Adding library: " + file.getAbsolutePath());
        			libs.add(file);
        		}
        	} else if ("headers".equals(classifier) && "tar".equals(type)) {
        		final File include = new File(file.getParent(), "include");
        		if (!include.exists()) {
	        		try {
	        			include.mkdirs();
						unTar(file, include);
					} catch (FileNotFoundException e) {
	            		throw new MojoExecutionException("File not found", e);
					} catch (IOException e) {
	            		throw new MojoExecutionException("Error untaring headers", e);
					} catch (ArchiveException e) {
	            		throw new MojoExecutionException("Error untaring headers", e);
					}
        		}
				getLog().info("Including headers in: " + include.getAbsolutePath());
				headers.add(include);
        	}
        }
        config.setLibs(libs);
        config.setHeaders(headers);

        if (delegateClassName != null) {
        	config.setDelegateClassName(delegateClassName);
        }
        if (families != null) {
        	List<Family> familyEnums = Lists.newArrayList();
        	for (String family : families) {
        		try {
        			familyEnums.add(Family.valueOf(family.toUpperCase()));
        		} catch (IllegalArgumentException e) {
            		throw new MojoExecutionException("Unrecognised device family: "
            				+ family, e);
        		}
        	}
        	if (familyEnums.size() > 0) {
        		config.setDeviceFamilies(familyEnums);
        	}
        }
        if (icons != null) {
        	config.setIcons(Lists.newArrayList(icons));
        }
        return config;
    }

	private List<File> unTar(final File inputFile, final File outputDir) throws FileNotFoundException, IOException, ArchiveException {
	    final List<File> untaredFiles = Lists.newLinkedList();
	    final InputStream inputStream = new FileInputStream(inputFile);
	    final TarArchiveInputStream tarInputStream = (TarArchiveInputStream) new ArchiveStreamFactory().createArchiveInputStream("tar", inputStream);
	    TarArchiveEntry entry = null;
	    while ((entry = (TarArchiveEntry)tarInputStream.getNextEntry()) != null) {
	        final File outputFile = new File(outputDir, entry.getName());
	        if (entry.isDirectory()) {
	            if (!outputFile.exists()) {
	                if (!outputFile.mkdirs()) {
	                    throw new IllegalStateException("Error creating directory: %s" + outputFile.getAbsolutePath());
	                }
	            }
	        } else {
	            final OutputStream outputFileStream = new FileOutputStream(outputFile);
	            IOUtils.copy(tarInputStream, outputFileStream);
	            outputFileStream.close();
	        }
	        untaredFiles.add(outputFile);
	    }
	    tarInputStream.close();
	    return untaredFiles;
	}

}
