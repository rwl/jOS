package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(NSData.class)
@Register(isWrapper = true)
public class NSMutableData extends NSData {

    @Export("appendBytes:length:")
    public void appendByteslength(Object bytes, int length) {
        throw new RuntimeException();
    }

    @Export("increaseLengthBy:")
    public void increaseLengthBy(int extraLength) {
        throw new RuntimeException();
    }

    @Export("replaceBytesInRange:withBytes:")
    public void replaceBytesInRangewithBytes(NSRange range, Object bytes) {
        throw new RuntimeException();
    }

    @Export("resetBytesInRange:")
    public void resetBytesInRange(NSRange range) {
        throw new RuntimeException();
    }

    @Export("setData:")
    public void setData(NSData data) {
        throw new RuntimeException();
    }

    @Export("replaceBytesInRange:withBytes:length:")
    public void replaceBytesInRangewithByteslength(NSRange range, Object replacementBytes, int replacementLength) {
        throw new RuntimeException();
    }


    @Export("dataWithCapacity:")
    public static NSObject dataWithCapacity(int aNumItems) {
        throw new RuntimeException();
    }

    @Export("initWithCapacity:")
    public NSObject initWithCapacity(int capacity) {
        throw new RuntimeException();
    }

    @Export("initWithLength:")
    public NSObject initWithLength(int length) {
        throw new RuntimeException();
    }

}