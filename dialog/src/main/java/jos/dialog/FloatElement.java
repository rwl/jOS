package jos.dialog;

import static jos.api.graphicsimaging.CGGeometry.makeSize;
import static jos.api.graphicsimaging.CGGeometry.makeRect;

import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;
import jos.api.graphicsimaging.CGSize;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIFont;
import jos.api.uikit.UIImage;
import jos.api.uikit.UISlider;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellSelectionStyle;
import jos.api.uikit.UITableViewCellStyle;

/**
 * Used to display a slider on the screen.
 */
public class FloatElement extends Element {

    private boolean ShowCaption;
    private float Value;
    private float MinValue, MaxValue;
    private static NSString skey = new NSString("FloatElement");
    //UIImage Left, Right;
    private UISlider slider;

    public FloatElement(UIImage left, UIImage right, float value) {
        super(null);
        //Left = left;
        //Right = right;
        MinValue = 0;
        MaxValue = 1;
        Value = value;
    }

    @Override
    protected NSString getCellKey() {
        return skey;
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        UITableViewCell cell = tv.dequeueReusableCell(getCellKey());
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
            captionSize = new NSString(Caption).sizeWithFont(UIFont
                    .fromName(cell.getTextLabel().getFont().getFontName(),
                            Math.round(UIFont.labelFontSize())));
            captionSize.width = captionSize.width + 10; // Spacing
        }

        if (slider == null) {
            slider = new UISlider(makeRect(10f + captionSize.width, 12f,
                    280f - captionSize.width, 7f));
            slider.setBackgroundColor(UIColor.CLEAR);
            slider.setMinimumValue(MinValue);
            slider.setMaximumValue(MaxValue);
            slider.setContinuous(true);
            slider.setValue(this.Value);
            slider.setTag(1);
            slider.addTarget(new EventListener() {
                @Override
                public void onEvent(NSObject sender, UIEvent event) {
                    setValue(slider.getValue());
                }
            }, UIControlEvent.VALUE_CHANGED);
        } else {
            slider.setValue(Value);
        }

        cell.getContentView().addSubview(slider);
        return cell;
    }

    @Override
    public String Summary() {
        return String.valueOf(Value);
    }

    @Override
    protected void Dispose(boolean disposing) {
        if (disposing) {
            if (slider != null) {
                slider.dealloc();
                slider = null;
            }
        }
    }

    public float getValue() {
        return Value;
    }

    public void setValue(float value) {
        Value = value;
    }

    public boolean isShowCaption() {
        return ShowCaption;
    }

    public void setShowCaption(boolean showCaption) {
        ShowCaption = showCaption;
    }

    public float getMinValue() {
        return MinValue;
    }

    public void setMinValue(float minValue) {
        MinValue = minValue;
    }

    public float getMaxValue() {
        return MaxValue;
    }

    public void setMaxValue(float maxValue) {
        MaxValue = maxValue;
    }

}