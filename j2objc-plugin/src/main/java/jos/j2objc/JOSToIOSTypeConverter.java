package jos.j2objc;

import org.eclipse.jdt.core.dom.TypeDeclaration;

import com.google.devtools.j2objc.util.ErrorReportingASTVisitor;

public class JOSToIOSTypeConverter extends ErrorReportingASTVisitor {

	@Override
	public boolean visit(final TypeDeclaration node) {

	    return super.visit(node);
	}
}
