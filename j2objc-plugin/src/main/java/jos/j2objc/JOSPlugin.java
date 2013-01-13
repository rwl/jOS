package jos.j2objc;

import java.io.File;
import java.util.Map;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ITypeBinding;

import com.google.devtools.j2objc.Plugin;

public class JOSPlugin extends Plugin {

    @Override
    public void initializeTypeMap(final CompilationUnit unit, final Map<ITypeBinding, ITypeBinding> typeMap) {
        typeMap.putAll(MapBuilder.buildMap(unit));
    }

    @Override
    public void populateSimpleTypeMap(final CompilationUnit unit, final Map<String, String> simpleTypeMap) {
    }

    @Override
    public void processUnit(final CompilationUnit unit) {
        new JOSToIOSTypeConverter().run(unit);
    }

    @Override
    public void endProcessing(final File outputDirectory) {
    }
}
