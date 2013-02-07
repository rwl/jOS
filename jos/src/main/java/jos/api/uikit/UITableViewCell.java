package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.graphicsimaging.CGRect;

@Register(isWrapper = true)
public class UITableViewCell extends UIView {

    public UITableViewCellAccessoryType accessory;
    public UILabel textLabel;

    @Export("initWithFrame:")
    public UITableViewCell(CGRect frame) {
        super(frame);
    }

    @Export("initWithStyle:reuseIdentifier:")
    public UITableViewCell(UITableViewCellStyle style, String reuseIdentifier) {
    }

    @Export("accessory")
    public UITableViewCellAccessoryType getAccessory() {
        return accessory;
    }

    @Export("setAccessory:")
    public void setAccessory(UITableViewCellAccessoryType accessory) {
        this.accessory = accessory;
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
