package jos.j2objc;

import java.util.List;
import java.util.Map;

import jos.foundation.NSObject;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IMemberValuePairBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.devtools.j2objc.types.Types;
import com.google.devtools.j2objc.util.ErrorReportingASTVisitor;

public class MethodMapBuilder extends ErrorReportingASTVisitor {

    private final Map<String, String> bindingMap = Maps
            .newHashMap();

    public static Map<String, String> buildMap(
            final CompilationUnit unit) {
        final MethodMapBuilder builder = new MethodMapBuilder();
        builder.run(unit);
        return builder.bindingMap;
    }

//    private void put(/*final MethodDeclaration methodDeclaration, */final IMethodBinding methodBinding) {
//        if (methodBinding == null) {
//            return;
//        }
//        final ITypeBinding superTypeBinding = methodBinding.getDeclaringClass().getSuperclass();
//        final IMethodBinding overriddenMethod = getOverriddenMethod(superTypeBinding, methodBinding);
//        if (overriddenMethod != null) {
//            final String signature = getSignature(overriddenMethod);
//            final String iosSignature = getIOSSignature(overriddenMethod/*, methodDeclaration*/);
//            bindingMap.put(signature, iosSignature);
//        }
//    }

    /*@Override
    public boolean visit(MethodDeclaration node) {
      put(node, node.resolveBinding());
      return true;
    }*/

    /*@Override
    public boolean visit(MethodInvocation node) {
        //put(node., node.resolveMethodBinding());
        return true;
    }

    @Override
    public boolean visit(ConstructorInvocation node) {
        return super.visit(node);
    }

    @Override
    public boolean visit(SuperConstructorInvocation node) {
        return super.visit(node);
    }

    @Override
    public boolean visit(SuperMethodInvocation node) {
        return super.visit(node);
    }*/

    @Override
    public boolean visit(TypeDeclaration node) {
        final ITypeBinding typeBinding = node.resolveBinding();
        putIfWrapper(typeBinding);
        return super.visit(node);
    }

    private void putIfWrapper(ITypeBinding typeBinding) {
        if (typeBinding == null) {
            return;
        }
        if (Types.isWrapper(typeBinding)) {
            for (IMethodBinding methodBinding : typeBinding.getDeclaredMethods()) {
                String signature = getSignature(methodBinding);
                String iosSignature = getIOSSignature(methodBinding);
                bindingMap.put(signature, iosSignature);
            }
        }
        if (typeBinding.getQualifiedName().equals(NSObject.class.getName())) {
            return;
        }
        putIfWrapper(typeBinding.getSuperclass());
    }

    /*private static IMethodBinding getOverriddenMethod(final ITypeBinding typeBinding,
            final IMethodBinding methodBinding) {
        if (typeBinding == null || typeBinding.getQualifiedName().equals(NSObject.class.getName())) {
            return null;
        }
        final IMethodBinding[] methodBindings = typeBinding.getDeclaredMethods();
        for (final IMethodBinding declMethodBinding : methodBindings) {
            if (equalMethods(methodBinding, declMethodBinding)) {
                return declMethodBinding;
            }
        }
        return getOverriddenMethod(typeBinding.getSuperclass(), methodBinding);
    }

    private static boolean equalMethods(final IMethodBinding method1, final IMethodBinding method2) {
        assert method1 != null;
        assert method2 != null;
        if (method1 == method2) {
            return true;
        }
        if (method1.isConstructor() != method2.isConstructor()) {
            return false;
        }
        if (!method1.isConstructor() && !method1.getName().equals(method2.getName())) {
            return false;
        }
        if (method1.getParameterTypes().length != method2.getParameterTypes().length) {
            return false;
        }
        for (int i = 0; i < method1.getParameterTypes().length; i++) {
            final ITypeBinding parameterType1 = method1.getParameterTypes()[i];
            final ITypeBinding parameterType2 = method2.getParameterTypes()[i];
            if (!parameterType1.isEqualTo(parameterType2)) {
                return false;
            }
        }
        return true;
    }*/

    private static String getSignature(final IMethodBinding methodBinding) {
        final String clazz = methodBinding.getDeclaringClass().getQualifiedName();
        final String name = methodBinding.getName();
        final String signature = Types.getSignature(methodBinding);
        return clazz + '.' + name + signature;
    }

    private static String getIOSSignature(final IMethodBinding methodBinding/*,
            final MethodDeclaration methodDeclaration*/) {
        for (IAnnotationBinding anno : methodBinding.getAnnotations()) {
            for (IMemberValuePairBinding pair : anno.getDeclaredMemberValuePairs()) {
                if (pair.getName().equals("selector")) {
                    return parameterizeSelector((String) pair.getValue(), methodBinding/*, methodDeclaration*/);
                }
            }
        }
        final String selector = methodBinding.getName()
                + StringUtils.repeat(": ", methodBinding.getParameterTypes().length).trim();
        return parameterizeSelector(selector, methodBinding/*, methodDeclaration*/);
    }

    private static String parameterizeSelector(final String selector,
            final IMethodBinding methodBinding/*, final MethodDeclaration methodDeclaration*/) {
        final ITypeBinding[] parameterTypes = methodBinding.getParameterTypes();
//        @SuppressWarnings("unchecked")
//        final List<SingleVariableDeclaration> params = methodDeclaration.parameters(); // safe by definition
        final List<String> segments = Lists.newArrayList(selector.split(":"));
        assert parameterTypes.length == segments.size() - 1;
        for (int i = 0; i < parameterTypes.length; i++) {
            String paramType = parameterTypes[i].getName();
            String param = String.format(":(%s *)%s", paramType,
                    StringUtils.uncapitalize(paramType) + "_"
                    /*NameTable.getName(params.get(i).getName())*/);
            if (i != parameterTypes.length - 1) {
                param += ' ';
            }
            segments.add((2 * i) + 1, param);
        }
        final String clazz = methodBinding.getDeclaringClass().getName();
        return clazz + ' ' + StringUtils.join(segments, "");
    }
}
