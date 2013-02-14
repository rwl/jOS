package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class NSDate extends NSObject {

	@Export("initWithTimeIntervalSince1970:")
	public NSDate(double interval) {
	}

}
