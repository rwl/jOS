package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIStoryboardSegue {

    @Export("identifier")
    public String getIdentifier() {
        throw new RuntimeException();
    }

    @Export("sourceViewController")
    public NSObject getSourceViewController() {
        throw new RuntimeException();
    }

    @Export("destinationViewController")
    public NSObject getDestinationViewController() {
        throw new RuntimeException();
    }

    @Export("segueWithIdentifier:source:destination:performHandler:)performHandler")
    public NSObject segueWithIdentifiersourcedestinationperformHandler(String identifier, UIViewController source, UIViewController destination, Object performHandler) {
        throw new RuntimeException();
    }

    @Export("initWithIdentifier:source:destination:")
    public NSObject initWithIdentifiersourcedestination(String identifier, UIViewController source, UIViewController destination) {
        throw new RuntimeException();
    }

    @Export("perform")
    public void perform() {
        throw new RuntimeException();
    }

}
