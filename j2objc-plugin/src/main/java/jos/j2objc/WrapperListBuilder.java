package jos.j2objc;

import java.util.List;

import jos.foundation.NSObject;

import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMemberValuePairBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import com.google.common.collect.Lists;
import com.google.devtools.j2objc.types.Types;
import com.google.devtools.j2objc.util.ErrorReportingASTVisitor;

public class WrapperListBuilder extends ErrorReportingASTVisitor {

    private final List<ITypeBinding> bindingList = Lists.newArrayList();

    public static List<ITypeBinding> buildList(final CompilationUnit unit) {
        final WrapperListBuilder builder = new WrapperListBuilder();
        builder.run(unit);
        return builder.bindingList;
    }

    private void add(final ITypeBinding binding) {
        bindingList.add(binding);
    }

    @Override
    public boolean visit(TypeDeclaration node) {
        final ITypeBinding typeBinding = node.resolveBinding();
        addIfWrapper(typeBinding);
        return super.visit(node);
    }

    @Override
    public boolean visit(ClassInstanceCreation node) {
        addIfWrapper(node.resolveTypeBinding());
        return super.visit(node);
    }

    private void addIfWrapper(ITypeBinding typeBinding) {
        if (typeBinding == null) {
            return;
        }
        if (Types.isWrapper(typeBinding)) {
            add(typeBinding);
        }
        if (typeBinding.getQualifiedName().equals(NSObject.class.getName())) {
            return;
        }
        addIfWrapper(typeBinding.getSuperclass());
    }

    /*@Override
    public boolean visit(SimpleName node) {
        final ITypeBinding typeBinding = getTypeBinding(node.resolveBinding());
        if (isNSObjectSubclass(typeBinding)) {
            add(typeBinding);
        }
        if (hasWrapperAnnotation(typeBinding)) {
            add(typeBinding);
        }
        return true;
    }*/

    /*private static boolean isNSObjectSubclass(final ITypeBinding binding) {
        if (binding.getQualifiedName().equals(NSObject.class.getName())) {
            return true;
        }
        final ITypeBinding superTypeBinding = binding.getSuperclass();
        if (superTypeBinding != null) {
            return isNSObjectSubclass(superTypeBinding);
        }
        return false;
    }*/

    /*private static boolean hasWrapperAnnotation(final ITypeBinding binding) {
        for (final IAnnotationBinding anno : binding.getAnnotations()) {
            for (final IMemberValuePairBinding pair : anno.getAllMemberValuePairs()) {
                if (pair.getName().equals("isWrapper")) {
                    final Boolean isWrapper = (Boolean) pair.getValue();
                    if (isWrapper) {
                        return true;
                    }
                }
            }
        }
        return false;
    }*/

    /*private static ITypeBinding getTypeBinding(IBinding binding) {
        if (binding instanceof ITypeBinding) {
            return (ITypeBinding) binding;
        } else if (binding instanceof IMethodBinding) {
            IMethodBinding m = (IMethodBinding) binding;
            return m.isConstructor() ? m.getDeclaringClass() : m
                    .getReturnType();
        } else if (binding instanceof IVariableBinding) {
            return ((IVariableBinding) binding).getType();
        }
        return null;
    }*/
}
