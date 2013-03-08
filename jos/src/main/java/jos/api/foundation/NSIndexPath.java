package jos.api.foundation;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class NSIndexPath {

    @Export("indexPathWithIndex:")
    public static NSObject indexPathWithIndex(int index) {
        return null;
    }

    @Export("indexPathWithIndexes:length:")
    public static NSObject indexPathWithIndexeslength(@Bind("NSUInteger") int[] indexes, int length) {
        return null;
    }

    @Export("initWithIndex:")
    public NSObject initWithIndex(int index) {
        return null;
    }

    @Export("initWithIndexes:length:")
    public NSObject initWithIndexeslength(@Bind("NSUInteger") int[] indexes, int length) {
        return null;
    }

    @Export("indexPathByAddingIndex:")
    public NSIndexPath indexPathByAddingIndex(int index) {
        return null;
    }

    @Export("indexPathByRemovingLastIndex")
    public NSIndexPath indexPathByRemovingLastIndex() {
        return null;
    }

    @Export("indexAtPosition:")
    public int indexAtPosition(int position) {
        return 0;
    }

    @Export("length")
    public int length() {
        return 0;
    }

    @Export("getIndexes:")
    public void getIndexes(int indexes) {
    }

    @Export("compare:")
    public NSComparisonResult compare(NSIndexPath otherObject) {
        return null;
    }

    /* UITableView */

    @Export("section")
    public int getSection() {
        throw new RuntimeException();
    }

    @Export("row")
    public int getRow() {
        throw new RuntimeException();
    }

    @Export("indexPathForRow:inSection:")
    public static NSIndexPath fromRowSection(int row, int section) {
        throw new RuntimeException();
    }

}
