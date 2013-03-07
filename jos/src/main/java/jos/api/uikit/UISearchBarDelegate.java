package jos.api.uikit;

import jos.api.foundation.NSObject;
import jos.api.foundation.NSRange;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UISearchBarDelegate extends NSObject {

    @Export("searchBarShouldBeginEditing:")
    public boolean shouldBeginEditing(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarTextDidBeginEditing:")
    public void textDidBeginEditing(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarShouldEndEditing:")
    public boolean shouldEndEditing(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarTextDidEndEditing:")
    public void textDidEndEditing(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBar:textDidChange:")
    public void textChanged(UISearchBar searchBar, String searchText) {
        throw new RuntimeException();
    }

    @Export("searchBar:shouldChangeTextInRange:replacementText:")
    public boolean shouldChangeTextInRangereplacementText(UISearchBar searchBar, NSRange range, String text) {
        throw new RuntimeException();
    }

    @Export("searchBarSearchButtonClicked:")
    public void searchButtonClicked(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarBookmarkButtonClicked:")
    public void bookmarkButtonClicked(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarCancelButtonClicked:")
    public void cancelButtonClicked(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarResultsListButtonClicked:")
    public void resultsListButtonClicked(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBar:selectedScopeButtonIndexDidChange:")
    public void selectedScopeButtonIndexDidChange(UISearchBar searchBar, int selectedScope) {
        throw new RuntimeException();
    }

}

