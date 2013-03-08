package jos.dialog;

import jos.api.uikit.UIFont;
import jos.api.uikit.UIImage;
import jos.api.uikit.UISlider;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;

/**
 * Used to display a slider on the screen.
 */
public class FloatElement extends Element {

    public boolean ShowCaption;
    public float Value;
    public float MinValue, MaxValue;
    static NSString skey = new NSString("FloatElement");
    //UIImage Left, Right;
    UISlider slider;

    public FloatElement(UIImage left, UIImage right, float value) {
        super(null);
        //Left = left;
        //Right = right;
        MinValue = 0;
        MaxValue = 1;
        Value = value;
    }

    @Override
    protected NSString CellKey() {
        return skey;
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        UITableViewCell cell = tv.DequeueReusableCell(getCellKey());
        if (cell == null) {
            cell = new UITableViewCell(UITableViewCellStyle.DEFAULT,
                    getCellKey());
            cell.setSelectionStyle(UITableViewCellSelectionStyle.NONE);
        } else {
            RemoveTag(cell, 1);
        }

        CGSize captionSize = makeSize(0, 0);
        if (Caption != null && ShowCaption) {
            cell.getTextLabel().setText(Caption);
            captionSize = cell.getTextLabel().setStringSize(
                    Caption,
                    UIFont.FromName(cell.getTextLabel().getFont().getName(),
                            UIFont.getLabelFontSize()));
            captionSize.setWidth(captionSize.getWidth() + 10); // Spacing
        }

        if (slider == null) {
            slider = new UISlider(makeRect(10f + captionSize.Width, 12f,
                    280f - captionSize.Width, 7f));
            slider.setBackgroundColor(UIColor.Clear);
            slider.setMinValue(this.MinValue);
            slider.setMaxValue(this.MaxValue);
            slider.setContinuous(true);
            slider.setValue(this.Value);
            slider.setTag(1);
            //            slider.ValueChanged += delegate {
            //                Value = slider.Value;
            //            };
        } else {
            slider.setValue(Value);
        }

        cell.getContentView().addSubview(slider);
        return cell;
    }

    @Override
    public String Summary() {
        return Value.toString();
    }

    @Override
    protected void Dispose(boolean disposing) {
        if (disposing) {
            if (slider != null) {
                slider.Dispose();
                slider = null;
            }
        }
    }

}