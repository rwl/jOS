package jos.api.uikit;

import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UITableViewCell extends UIView {

    public UITableViewCellAccessoryType accessoryType;
    public UILabel textLabel;

    @Export("initWithFrame:")
    public UITableViewCell(CGRect frame) {
        super(frame);
    }

    @Export("initWithStyle:reuseIdentifier:")
    public UITableViewCell(UITableViewCellStyle style, String reuseIdentifier) {
    }

    @Export("accessoryType")
    public UITableViewCellAccessoryType getAccessoryType() {
        return accessoryType;
    }

    @Export("setAccessoryType:")
    public void setAccessoryType(UITableViewCellAccessoryType accessory) {
        this.accessoryType = accessory;
    }

    @Export("textLabel")
    public UILabel getTextLabel() {
        return textLabel;
    }

    @Export("setTextLabel:")
    public void setTextLabel(UILabel textLabel) {
        this.textLabel = textLabel;
    }

}
