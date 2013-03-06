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
    public boolean searchBarShouldBeginEditing(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarTextDidBeginEditing:")
    public void searchBarTextDidBeginEditing(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarShouldEndEditing:")
    public boolean searchBarShouldEndEditing(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarTextDidEndEditing:")
    public void searchBarTextDidEndEditing(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBar:textDidChange:")
    public void searchBartextDidChange(UISearchBar searchBar, String searchText) {
        throw new RuntimeException();
    }

    @Export("searchBar:shouldChangeTextInRange:replacementText:")
    public boolean searchBarshouldChangeTextInRangereplacementText(UISearchBar searchBar, NSRange range, String text) {
        throw new RuntimeException();
    }

    @Export("searchBarSearchButtonClicked:")
    public void searchBarSearchButtonClicked(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarBookmarkButtonClicked:")
    public void searchBarBookmarkButtonClicked(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarCancelButtonClicked:")
    public void searchBarCancelButtonClicked(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBarResultsListButtonClicked:")
    public void searchBarResultsListButtonClicked(UISearchBar searchBar) {
        throw new RuntimeException();
    }

    @Export("searchBar:selectedScopeButtonIndexDidChange:")
    public void searchBarselectedScopeButtonIndexDidChange(UISearchBar searchBar, int selectedScope) {
        throw new RuntimeException();
    }

}

