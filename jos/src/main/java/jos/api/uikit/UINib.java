package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSBundle;
import jos.api.foundation.NSData;
import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;

import com.google.j2objc.annotations.Export;

public class UINib extends NSObject {

    @Export("nibWithNibName:bundle:")
    public UINib(NSString name, NSBundle bundleOrNil) {
        throw new RuntimeException();
    }

    @Export("nibWithData:bundle:")
    public UINib(NSData data, NSBundle bundleOrNil) {
        throw new RuntimeException();
    }

    @Export("instantiateWithOwner:options:")
    public NSArray instantiateWithOwneroptions(NSObject ownerOrNil, NSDictionary optionsOrNil) {
        throw new RuntimeException();
    }

}
