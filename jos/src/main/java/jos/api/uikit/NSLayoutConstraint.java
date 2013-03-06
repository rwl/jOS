package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class NSLayoutConstraint {
    @Export("firstAttribute")
    public NSLayoutAttribute getFirstAttribute() {
        throw new RuntimeException();
    }

    @Export("relation")
    public NSLayoutRelation getRelation() {
        throw new RuntimeException();
    }

    @Export("secondItem")
    public NSObject getSecondItem() {
        throw new RuntimeException();
    }

    @Export("secondAttribute")
    public NSLayoutAttribute getSecondAttribute() {
        throw new RuntimeException();
    }

    @Export("multiplier")
    public float getMultiplier() {
        throw new RuntimeException();
    }

    @Export("constraintsWithVisualFormat:options:metrics:views:")
    public NSArray constraintsWithVisualFormatoptionsmetricsviews(String format, NSLayoutFormatOptions opts, NSDictionary metrics, NSDictionary views) {
        throw new RuntimeException();
    }

    @Export("firstItem")
    public NSObject firstItem() {
        throw new RuntimeException();
    }

}
