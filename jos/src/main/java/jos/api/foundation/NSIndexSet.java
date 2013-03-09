package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSMutableCopying.class, NSCoding.class})
@Register(isWrapper = true)
public class NSIndexSet extends NSObject {

    @Export("indexSet")
    public static NSObject indexSet() {
        throw new RuntimeException();
    }

    @Export("indexSetWithIndex:")
    public static NSIndexSet fromIndex(int value) {
        throw new RuntimeException();
    }

    @Export("indexSetWithIndexesInRange:")
    public static NSIndexSet fromRange(NSRange range) {
        throw new RuntimeException();
    }

    @Export("init")
    public NSObject init() {
        throw new RuntimeException();
    }

    @Export("initWithIndex:")
    public NSObject initWithIndex(int value) {
        throw new RuntimeException();
    }

    @Export("initWithIndexesInRange:")
    public NSObject initWithIndexesInRange(NSRange range) {
        throw new RuntimeException();
    }

    @Export("initWithIndexSet:")
    public NSObject initWithIndexSet(NSIndexSet indexSet) {
        throw new RuntimeException();
    }

    @Export("isEqualToIndexSet:")
    public boolean isEqualToIndexSet(NSIndexSet indexSet) {
        throw new RuntimeException();
    }

    @Export("count")
    public int count() {
        throw new RuntimeException();
    }

    @Export("firstIndex")
    public int firstIndex() {
        throw new RuntimeException();
    }

    @Export("lastIndex")
    public int lastIndex() {
        throw new RuntimeException();
    }

    @Export("indexGreaterThanIndex:")
    public int indexGreaterThanIndex(int value) {
        throw new RuntimeException();
    }

    @Export("indexLessThanIndex:")
    public int indexLessThanIndex(int value) {
        throw new RuntimeException();
    }

    @Export("indexGreaterThanOrEqualToIndex:")
    public int indexGreaterThanOrEqualToIndex(int value) {
        throw new RuntimeException();
    }

    @Export("indexLessThanOrEqualToIndex:")
    public int indexLessThanOrEqualToIndex(int value) {
        throw new RuntimeException();
    }

    @Export("countOfIndexesInRange:")
    public int countOfIndexesInRange(NSRange range) {
        throw new RuntimeException();
    }

    @Export("containsIndex:")
    public boolean containsIndex(int value) {
        throw new RuntimeException();
    }

    @Export("containsIndexesInRange:")
    public boolean containsIndexesInRange(NSRange range) {
        throw new RuntimeException();
    }

    @Export("containsIndexes:")
    public boolean containsIndexes(NSIndexSet indexSet) {
        throw new RuntimeException();
    }

    @Export("intersectsIndexesInRange:")
    public boolean intersectsIndexesInRange(NSRange range) {
        throw new RuntimeException();
    }

}