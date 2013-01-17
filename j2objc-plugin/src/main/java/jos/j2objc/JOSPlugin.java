package jos.j2objc;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ITypeBinding;

import com.google.common.collect.Maps;
import com.google.devtools.j2objc.Plugin;
import com.google.devtools.j2objc.types.IOSTypeBinding;

public class JOSPlugin extends Plugin {

    @Override
    public void initializeTypeMap(final CompilationUnit unit,
            final Map<ITypeBinding, ITypeBinding> typeMap,
            Map<String, IOSTypeBinding> iosBindingMap) {
        Map<ITypeBinding, IOSTypeBinding> map = TypeMapBuilder.buildMap(unit);
        typeMap.putAll(map);
        for (Entry<ITypeBinding, IOSTypeBinding> entry : map.entrySet()) {
            IOSTypeBinding iosType = entry.getValue();
            iosBindingMap.put(iosType.getName(), iosType);
        }
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
