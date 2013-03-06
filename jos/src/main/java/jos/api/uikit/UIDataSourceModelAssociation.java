package jos.api.uikit;

import jos.api.foundation.NSIndexPath;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UIDataSourceModelAssociation extends NSObject {

    @Export("modelIdentifierForElementAtIndexPath:inView:")
    public String modelIdentifierForElementAtIndexPathinView(NSIndexPath idx, UIView view) {
        throw new RuntimeException();
    }

}

