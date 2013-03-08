package jos.api.uikit;

import jos.api.foundation.NSIndexPath;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@BaseType(UIScrollViewDelegate.class)
@Model
@Register(isWrapper = true)
public abstract class UITableViewDelegate {

    @Export("tableView:didSelectRowAtIndexPath:")
    public void rowSelected(UITableView tableView, NSIndexPath indexPath) {
    }


    @Export("tableView:willDisplayCell:forRowAtIndexPath:")
    public void tableViewwillDisplayCellforRowAtIndexPath(UITableView tableView, UITableViewCell cell, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:willDisplayHeaderView:forSection:")
    public void tableViewwillDisplayHeaderViewforSection(UITableView tableView, UIView view, int section) {
        throw new RuntimeException();
    }

    @Export("tableView:willDisplayFooterView:forSection:")
    public void tableViewwillDisplayFooterViewforSection(UITableView tableView, UIView view, int section) {
        throw new RuntimeException();
    }

    @Export("tableView:didEndDisplayingCell:forRowAtIndexPath:")
    public void tableViewdidEndDisplayingCellforRowAtIndexPath(UITableView tableView, UITableViewCell cell, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:didEndDisplayingHeaderView:forSection:")
    public void tableViewdidEndDisplayingHeaderViewforSection(UITableView tableView, UIView view, int section) {
        throw new RuntimeException();
    }

    @Export("tableView:didEndDisplayingFooterView:forSection:")
    public void tableViewdidEndDisplayingFooterViewforSection(UITableView tableView, UIView view, int section) {
        throw new RuntimeException();
    }

    @Export("tableView:heightForRowAtIndexPath:")
    public float tableViewheightForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:heightForHeaderInSection:")
    public float tableViewheightForHeaderInSection(UITableView tableView, int section) {
        throw new RuntimeException();
    }

    @Export("tableView:heightForFooterInSection:")
    public float tableViewheightForFooterInSection(UITableView tableView, int section) {
        throw new RuntimeException();
    }

    @Export("tableView:viewForHeaderInSection:")
    public UIView tableViewviewForHeaderInSection(UITableView tableView, int section) {
        throw new RuntimeException();
    }

    @Export("tableView:viewForFooterInSection:")
    public UIView tableViewviewForFooterInSection(UITableView tableView, int section) {
        throw new RuntimeException();
    }

    @Export("tableView:accessoryButtonTappedForRowWithIndexPath:")
    public void tableViewaccessoryButtonTappedForRowWithIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:shouldHighlightRowAtIndexPath:")
    public boolean tableViewshouldHighlightRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:didHighlightRowAtIndexPath:")
    public void tableViewdidHighlightRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:didUnhighlightRowAtIndexPath:")
    public void tableViewdidUnhighlightRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:willSelectRowAtIndexPath:")
    public NSIndexPath tableViewwillSelectRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:willDeselectRowAtIndexPath:")
    public NSIndexPath tableViewwillDeselectRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:didSelectRowAtIndexPath:")
    public void tableViewdidSelectRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:didDeselectRowAtIndexPath:")
    public void tableViewdidDeselectRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:editingStyleForRowAtIndexPath:")
    public UITableViewCellEditingStyle tableVieweditingStyleForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:titleForDeleteConfirmationButtonForRowAtIndexPath:")
    public String tableViewtitleForDeleteConfirmationButtonForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:shouldIndentWhileEditingRowAtIndexPath:")
    public boolean tableViewshouldIndentWhileEditingRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:willBeginEditingRowAtIndexPath:")
    public void tableView(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:didEndEditingRowAtIndexPath:")
    public void tableViewdidEndEditingRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:targetIndexPathForMoveFromRowAtIndexPath:toProposedIndexPath:")
    public NSIndexPath tableViewtargetIndexPathForMoveFromRowAtIndexPathtoProposedIndexPath(UITableView tableView, NSIndexPath sourceIndexPath, NSIndexPath proposedDestinationIndexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:indentationLevelForRowAtIndexPath:")
    public int tableViewindentationLevelForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:shouldShowMenuForRowAtIndexPath:")
    public boolean tableViewshouldShowMenuForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("tableView:canPerformAction:forRowAtIndexPath:withSender:")
    public boolean tableViewcanPerformActionforRowAtIndexPathwithSender(UITableView tableView, Selector action, NSIndexPath indexPath, NSObject sender) {
        throw new RuntimeException();
    }

    @Export("tableView:performAction:forRowAtIndexPath:withSender:")
    public void tableViewperformActionforRowAtIndexPathwithSender(UITableView tableView, Selector action, NSIndexPath indexPath, NSObject sender) {
        throw new RuntimeException();
    }
}