package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSMutableCopying.class, NSSecureCoding.class})
@Register(isWrapper = true)
public class NSData extends NSObject {

    @Export("length")
    public int length() {
        throw new RuntimeException();
    }


    @Export("description")
    public String description() {
        throw new RuntimeException();
    }

    @Export("getBytes:range:")
    public void getBytesrange(Object buffer, NSRange range) {
        throw new RuntimeException();
    }

    @Export("isEqualToData:")
    public boolean isEqualToData(NSData other) {
        throw new RuntimeException();
    }

    @Export("subdataWithRange:")
    public NSData subdataWithRange(NSRange range) {
        throw new RuntimeException();
    }

    @Export("writeToFile:atomically:")
    public boolean writeToFileatomically(String path, boolean useAuxiliaryFile) {
        throw new RuntimeException();
    }

    @Export("writeToURL:atomically:")
    public boolean writeToURLatomically(NSUrl url, boolean atomically) {
        throw new RuntimeException();
    }

    @Export("writeToFile:options:error:")
    public boolean writeToFileoptionserror(String path, NSDataWritingOptions writeOptionsMask, NSError errorPtr) {
        throw new RuntimeException();
    }

    @Export("writeToURL:options:error:")
    public boolean writeToURLoptionserror(NSUrl url, NSDataWritingOptions writeOptionsMask, NSError errorPtr) {
        throw new RuntimeException();
    }

    @Export("rangeOfData:options:range:")
    public NSRange rangeOfDataoptionsrange(NSData dataToFind, NSDataSearchOptions mask, NSRange searchRange) {
        throw new RuntimeException();
    }


    @Export("data")
    public static NSObject data() {
        throw new RuntimeException();
    }

    @Export("dataWithBytesNoCopy:length:")
    public static NSObject dataWithBytesNoCopylength(Object bytes, int length) {
        throw new RuntimeException();
    }

    @Export("dataWithBytesNoCopy:length:freeWhenDone:")
    public static NSObject dataWithBytesNoCopylengthfreeWhenDone(Object bytes, int length, boolean b) {
        throw new RuntimeException();
    }

    @Export("dataWithContentsOfFile:options:error:")
    public static NSObject dataWithContentsOfFileoptionserror(String path, NSDataReadingOptions readOptionsMask, NSError errorPtr) {
        throw new RuntimeException();
    }

    @Export("dataWithContentsOfURL:options:error:")
    public static NSObject dataWithContentsOfURLoptionserror(NSUrl url, NSDataReadingOptions readOptionsMask, NSError errorPtr) {
        throw new RuntimeException();
    }

    @Export("dataWithContentsOfFile:")
    public static NSObject dataWithContentsOfFile(String path) {
        throw new RuntimeException();
    }

    @Export("dataWithContentsOfURL:")
    public static NSObject dataWithContentsOfURL(NSUrl url) {
        throw new RuntimeException();
    }

    @Export("initWithBytes:length:")
    public NSObject initWithByteslength(Object bytes, int length) {
        throw new RuntimeException();
    }

    @Export("initWithBytesNoCopy:length:")
    public NSObject initWithBytesNoCopylength(Object bytes, int length) {
        throw new RuntimeException();
    }

    @Export("initWithBytesNoCopy:length:freeWhenDone:")
    public NSObject initWithBytesNoCopylengthfreeWhenDone(Object bytes, int length, boolean b) {
        throw new RuntimeException();
    }

    @Export("initWithContentsOfFile:options:error:")
    public NSObject initWithContentsOfFileoptionserror(String path, NSDataReadingOptions readOptionsMask, NSError errorPtr) {
        throw new RuntimeException();
    }

    @Export("initWithContentsOfURL:options:error:")
    public NSObject initWithContentsOfURLoptionserror(NSUrl url, NSDataReadingOptions readOptionsMask, NSError errorPtr) {
        throw new RuntimeException();
    }

    @Export("initWithContentsOfFile:")
    public NSObject initWithContentsOfFile(String path) {
        throw new RuntimeException();
    }

    @Export("initWithContentsOfURL:")
    public NSObject initWithContentsOfURL(NSUrl url) {
        throw new RuntimeException();
    }

    @Export("initWithData:")
    public NSObject initWithData(NSData data) {
        throw new RuntimeException();
    }

    @Export("dataWithData:")
    public static NSObject dataWithData(NSData data) {
        throw new RuntimeException();
    }


    @Export("getBytes:")
    public void getBytes(Object buffer) {
        throw new RuntimeException();
    }

    @Export("dataWithContentsOfMappedFile:")
    public NSObject dataWithContentsOfMappedFile(String path) {
        throw new RuntimeException();
    }

    @Export("initWithContentsOfMappedFile:")
    public NSObject initWithContentsOfMappedFile(String path) {
        throw new RuntimeException();
    }
}