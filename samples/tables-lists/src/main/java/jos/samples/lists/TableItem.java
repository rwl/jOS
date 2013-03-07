package jos.samples.lists;

import jos.api.uikit.UITableViewCellAccessoryType;
import jos.api.uikit.UITableViewCellStyle;

/**
 * Represents our item in the table
 */
public class TableItem {

    private String heading;

    private String subHeading;

    private String imageName;

    private UITableViewCellStyle cellStyle = UITableViewCellStyle.DEFAULT;

    private UITableViewCellAccessoryType cellAccessory = UITableViewCellAccessoryType.NONE;

    public TableItem() {}

    public TableItem(String heading) {
        this.heading = heading;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public UITableViewCellStyle getCellStyle() {
        return cellStyle;
    }

    public void setCellStyle(UITableViewCellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }

    public UITableViewCellAccessoryType getCellAccessory() {
        return cellAccessory;
    }

    public void setCellAccessory(UITableViewCellAccessoryType cellAccessory) {
        this.cellAccessory = cellAccessory;
    }

}
