package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UISearchDisplayController {

    @Export("delegate")
    public UISearchDisplayDelegate getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(UISearchDisplayDelegate value) {
        throw new RuntimeException();
    }

    @Bind("isActive")
    @Export("active")
    public boolean getActive() {
        throw new RuntimeException();
    }

    @Export("setActive:")
    public void setActive(boolean value) {
        throw new RuntimeException();
    }

    @Export("searchBar")
    public UISearchBar getSearchBar() {
        throw new RuntimeException();
    }

    @Export("searchContentsController")
    public UIViewController getSearchContentsController() {
        throw new RuntimeException();
    }

    @Export("searchResultsTableView")
    public UITableView getSearchResultsTableView() {
        throw new RuntimeException();
    }

    @Export("searchResultsDataSource")
    public UITableViewDataSource getSearchResultsDataSource() {
        throw new RuntimeException();
    }

    @Export("setSearchResultsDataSource:")
    public void setSearchResultsDataSource(UITableViewDataSource value) {
        throw new RuntimeException();
    }

    @Export("searchResultsDelegate")
    public UITableViewDelegate getSearchResultsDelegate() {
        throw new RuntimeException();
    }

    @Export("setSearchResultsDelegate:")
    public void setSearchResultsDelegate(UITableViewDelegate value) {
        throw new RuntimeException();
    }

    @Export("searchResultsTitle")
    public String getSearchResultsTitle() {
        throw new RuntimeException();
    }

    @Export("setSearchResultsTitle:")
    public void setSearchResultsTitle(String value) {
        throw new RuntimeException();
    }

    @Export("initWithSearchBar:contentsController:")
    public NSObject initWithSearchBarcontentsController(UISearchBar searchBar, UIViewController viewController) {
        throw new RuntimeException();
    }

    @Export("setActive:animated:")
    public void setActiveanimated(boolean visible, boolean animated) {
        throw new RuntimeException();
    }

}