package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSIndexPath;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;

@BaseType(NSObject.class)
@Model
public class UITableViewDataSource {
    @Export(selector = "tableView:numberOfRowsInSection:")
    public int tableViewnumberOfRowsInSection(UITableView tableView, int section) {
        return 0;
    }

//    @Export(selector = "anddatasource(accessoryviews,editingcontrols)-(UITableViewCell*)tableView:cellForRowAtIndexPath:")
//    public separators anddatasource(accessoryviews,editingcontrols)-(UITableViewCell*)tableViewcellForRowAtIndexPath(accessory views, editing controls -, UITableViewCell tableView:(UITableView, NSIndexPath indexPath) {
//        return null;
//    }

    @Export(selector = "numberOfSectionsInTableView:")
    public int numberOfSectionsInTableView(UITableView tableView) {
        return 0;
    }

    @Export(selector = "tableView:titleForHeaderInSection:")
    public String tableViewtitleForHeaderInSection(UITableView tableView, int section) {
        return "";
    }

    @Export(selector = "tableView:titleForFooterInSection:")
    public String tableViewtitleForFooterInSection(UITableView tableView, int section) {
        return "";
    }

    @Export(selector = "tableView:canEditRowAtIndexPath:")
    public boolean tableViewcanEditRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        return false;
    }

    @Export(selector = "tableView:canMoveRowAtIndexPath:")
    public boolean tableViewcanMoveRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        return false;
    }

    @Export(selector = "sectionIndexTitlesForTableView:")
    public NSArray sectionIndexTitlesForTableView(UITableView tableView) {
        return null;
    }

    @Export(selector = "tableView:sectionForSectionIndexTitle:atIndex:")
    public int tableViewsectionForSectionIndexTitleatIndex(UITableView tableView, String title, int index) {
        return 0;
    }

//    @Export(selector = ",thedataSourcemustcommitthechange-(void)tableView:commitEditingStyle:forRowAtIndexPath:")
//    public based on the UITableViewCellEditingStyle for the cell ,thedataSourcemustcommitthechange-(void)tableViewcommitEditingStyleforRowAtIndexPath(void tableView:(UITableView, UITableViewCellEditingStyle editingStyle, NSIndexPath indexPath) {
//        return null;
//    }

    @Export(selector = "tableView:moveRowAtIndexPath:toIndexPath:")
    public void tableViewmoveRowAtIndexPathtoIndexPath(UITableView tableView, NSIndexPath sourceIndexPath, NSIndexPath destinationIndexPath) {
    }

}
