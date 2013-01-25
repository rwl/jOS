package jos.api.uikit;

import jos.api.graphicsimaging.CGRect;

public class UITableViewCell extends UIView {

    public UITableViewCellAccessory accessory;
    public UILabel textLabel;

    public UITableViewCell(CGRect frame) {
        super(frame);
    }

    public UITableViewCell(UITableViewCellStyle default1, String cellIdentifier) {
    }

}
