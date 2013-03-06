package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UISearchDisplayDelegate extends NSObject {

    @Export("searchDisplayControllerWillBeginSearch:")
    public void searchDisplayControllerWillBeginSearch(UISearchDisplayController controller) {
        throw new RuntimeException();
    }

    @Export("searchDisplayControllerDidBeginSearch:")
    public void searchDisplayControllerDidBeginSearch(UISearchDisplayController controller) {
        throw new RuntimeException();
    }

    @Export("searchDisplayControllerWillEndSearch:")
    public void searchDisplayControllerWillEndSearch(UISearchDisplayController controller) {
        throw new RuntimeException();
    }

    @Export("searchDisplayControllerDidEndSearch:")
    public void searchDisplayControllerDidEndSearch(UISearchDisplayController controller) {
        throw new RuntimeException();
    }

    @Export("searchDisplayController:didLoadSearchResultsTableView:")
    public void searchDisplayControllerdidLoadSearchResultsTableView(UISearchDisplayController controller, UITableView tableView) {
        throw new RuntimeException();
    }

    @Export("searchDisplayController:willUnloadSearchResultsTableView:")
    public void searchDisplayControllerwillUnloadSearchResultsTableView(UISearchDisplayController controller, UITableView tableView) {
        throw new RuntimeException();
    }

    @Export("searchDisplayController:willShowSearchResultsTableView:")
    public void searchDisplayControllerwillShowSearchResultsTableView(UISearchDisplayController controller, UITableView tableView) {
        throw new RuntimeException();
    }

    @Export("searchDisplayController:didShowSearchResultsTableView:")
    public void searchDisplayControllerdidShowSearchResultsTableView(UISearchDisplayController controller, UITableView tableView) {
        throw new RuntimeException();
    }

    @Export("searchDisplayController:willHideSearchResultsTableView:")
    public void searchDisplayControllerwillHideSearchResultsTableView(UISearchDisplayController controller, UITableView tableView) {
        throw new RuntimeException();
    }

    @Export("searchDisplayController:didHideSearchResultsTableView:")
    public void searchDisplayControllerdidHideSearchResultsTableView(UISearchDisplayController controller, UITableView tableView) {
        throw new RuntimeException();
    }

    @Export("searchDisplayController:shouldReloadTableForSearchString:")
    public boolean searchDisplayControllershouldReloadTableForSearchString(UISearchDisplayController controller, String searchString) {
        throw new RuntimeException();
    }

    @Export("searchDisplayController:shouldReloadTableForSearchScope:")
    public boolean searchDisplayControllershouldReloadTableForSearchScope(UISearchDisplayController controller, int searchOption) {
        throw new RuntimeException();
    }

}
