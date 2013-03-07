package jos.api.coreimage;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSCopying;
import jos.api.foundation.NSData;
import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSError;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;
import jos.api.foundation.NSUrl;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCoding.class, NSCopying.class})
@Register(isWrapper = true)
public class CIFilter extends NSObject {

    @Export("outputImage")
    public CIImage getOutputImage() {
        throw new RuntimeException();
    }

    @Export("name")
    public String name() {
        throw new RuntimeException();
    }

    @Export("inputKeys")
    public NSArray inputKeys() {
        throw new RuntimeException();
    }

    @Export("outputKeys")
    public NSArray outputKeys() {
        throw new RuntimeException();
    }

    @Export("setDefaults")
    public void setDefaults() {
        throw new RuntimeException();
    }

    @Export("attributes")
    public NSDictionary attributes() {
        throw new RuntimeException();
    }


    @Export("filterWithName:")
    public CIFilter filterWithName(String name) {
        throw new RuntimeException();
    }

    @Export("filterWithName:keysAndValues:")
    public static CIFilter filterWithNamekeysAndValues(String name) {
        throw new RuntimeException();
    }

    @Export("filterNamesInCategory:")
    public NSArray filterNamesInCategory(String category) {
        throw new RuntimeException();
    }

    @Export("filterNamesInCategories:")
    public NSArray filterNamesInCategories(NSArray categories) {
        throw new RuntimeException();
    }

    @Export("registerFilterName:constructor:classAttributes:")
    public void registerFilterName(String name, CIFilterConstructor anObject, NSDictionary attributes) {
        throw new RuntimeException();
    }

    @Export("localizedNameForFilterName:")
    public String localizedNameForFilterName(String filterName) {
        throw new RuntimeException();
    }

    @Export("localizedNameForCategory:")
    public String localizedNameForCategory(String category) {
        throw new RuntimeException();
    }

    @Export("localizedDescriptionForFilterName:")
    public String localizedDescriptionForFilterName(String filterName) {
        throw new RuntimeException();
    }

    @Export("localizedReferenceDocumentationForFilterName:")
    public NSUrl localizedReferenceDocumentationForFilterName(NSString name) {
        throw new RuntimeException();
    }

    @Export("serializedXMPFromFilters:inputImageExtent:")
    public NSData serializedXMPFromFiltersinputImageExtent(NSArray filters, CGRect extent) {
        throw new RuntimeException();
    }

    @Export("filterArrayFromSerializedXMP:inputImageExtent:error:")
    public NSArray filterArrayFromSerializedXMPinputImageExtenterror(NSData xmpData, CGRect extent, NSError outError) {
        throw new RuntimeException();
    }

}

