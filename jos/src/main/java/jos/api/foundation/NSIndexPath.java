package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;

@BaseType(NSObject.class)
public class NSIndexPath {
    @Export(selector = "indexPathWithIndex:")
    public static NSObject indexPathWithIndex(int index) {
        return null;
    }

    @Export(selector = "indexPathWithIndexes:length:")
    public static NSObject indexPathWithIndexeslength(@Bind("NSUInteger") int[] indexes, int length) {
        return null;
    }

    @Export(selector = "initWithIndex:")
    public NSObject initWithIndex(int index) {
        return null;
    }

    @Export(selector = "initWithIndexes:length:")
    public NSObject initWithIndexeslength(@Bind("NSUInteger") int[] indexes, int length) {
        return null;
    }

    @Export(selector = "indexPathByAddingIndex:")
    public NSIndexPath indexPathByAddingIndex(int index) {
        return null;
    }

    @Export(selector = "indexPathByRemovingLastIndex")
    public NSIndexPath indexPathByRemovingLastIndex() {
        return null;
    }

    @Export(selector = "indexAtPosition:")
    public int indexAtPosition(int position) {
        return 0;
    }

    @Export(selector = "length")
    public int length() {
        return 0;
    }

    @Export(selector = "getIndexes:")
    public void getIndexes(int indexes) {
    }

    @Export(selector = "compare:")
    public NSComparisonResult compare(NSIndexPath otherObject) {
        return null;
    }

    /* UITableView */

    @Export(selector = "section")
    public int section;

    public int getSection() {
        return this.section;
    }

    @Export(selector = "row")
    public int row;

    public int getRow() {
        return this.row;
    }
}
