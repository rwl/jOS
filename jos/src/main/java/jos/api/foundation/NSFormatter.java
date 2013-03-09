package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSCoding.class})
@Register(isWrapper = true)
public class NSFormatter extends NSObject {

    @Export("stringForObjectValue:")
    public String stringForObjectValue(NSObject obj) {
        throw new RuntimeException();
    }

    @Export("attributedStringForObjectValue:withDefaultAttributes:")
    public NSAttributedString attributedStringForObjectValuewithDefaultAttributes(NSObject obj, NSDictionary attrs) {
        throw new RuntimeException();
    }

    @Export("editingStringForObjectValue:")
    public String editingStringForObjectValue(NSObject obj) {
        throw new RuntimeException();
    }

    @Export("isPartialStringValid:newEditingString:errorDescription:")
    public boolean isPartialStringValidnewEditingStringerrorDescription(String partialString, String newString, String error) {
        throw new RuntimeException();
    }

}

