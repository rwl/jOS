package jos.j2objc;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ITypeBinding;

import com.google.common.collect.Maps;
import com.google.devtools.j2objc.Plugin;

public class JOSPlugin extends Plugin {

    @Override
    public void initializeTypeMap(final CompilationUnit unit, final Map<ITypeBinding, ITypeBinding> typeMap) {
        typeMap.putAll(TypeMapBuilder.buildMap(unit));
    }

    @Override
    public void populateSimpleTypeMap(final CompilationUnit unit, final Map<String, String> simpleTypeMap) {
    }

    @Override
    public void mapMethods(final CompilationUnit unit, final Map<String, String> methodMappings) {

        methodMappings.putAll(Maps.difference(MethodMapBuilder.buildMap(unit), methodMappings).entriesOnlyOnLeft());

        //methodMappings.putAll(MethodMapBuilder.buildMap(unit));
    }

    @Override
    public List<ITypeBinding> getWrapperBindings(CompilationUnit unit) {
        //return Lists.newArrayList();//WrapperListMapBuilder.buildList(unit);
        return WrapperListBuilder.buildList(unit);
    }

    @Override
    public void processUnit(final CompilationUnit unit) {
        new JOSToIOSTypeConverter().run(unit);
    }

    @Override
    public void endProcessing(final File outputDirectory) {
    }
}
