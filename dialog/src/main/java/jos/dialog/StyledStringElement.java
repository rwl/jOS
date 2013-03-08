package jos.dialog;

import java.net.URI;

import jos.api.foundation.NSAction;
import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIFont;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UILabel;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessoryType;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewRowAnimation;

/**
 * A version of the StringElement that can be styled with a number of formatting
 * options and can render images or background images either from UIImage
 * parameters or by downloading them from the net.
 */
public class StyledStringElement extends StringElement implements
        IImageUpdated, IColorizeBackground {

    static NSString[] skey = { new NSString(".1"), new NSString(".2"),
            new NSString(".3"), new NSString(".4") };

    public StyledStringElement(String caption) {
        super(caption);
    }

    public StyledStringElement(String caption, NSAction tapped) {
        super(caption, tapped);
    }

    public StyledStringElement(String caption, String value) {
        super(caption, value);
        style = UITableViewCellStyle.Value1;
    }

    public StyledStringElement(String caption, String value,
            UITableViewCellStyle style) {
        super(caption, value);
        this.style = style;
    }

    protected UITableViewCellStyle style;
    public NSAction AccessoryTapped;
    public UIFont Font;
    public UIFont SubtitleFont;
    public UIColor TextColor;
    public UILineBreakMode LineBreakMode = UILineBreakMode.WORD_WRAP;
    public int Lines = 0;
    public UITableViewCellAccessoryType Accessory = UITableViewCellAccessoryType.NONE;

    // To keep the size down for a StyleStringElement, we put all the image information
    // on a separate structure, and create this on demand.
    ExtraInfo extraInfo;

    class ExtraInfo {
        public UIImage Image; // Maybe add BackgroundImage?
        public UIColor BackgroundColor, DetailColor;
        public URI Uri, BackgroundUri;
    }

    ExtraInfo OnImageInfo() {
        if (extraInfo == null)
            extraInfo = new ExtraInfo();
        return extraInfo;
    }

    // Uses the specified image (use this or ImageUri)
    public UIImage getImage() {
        return extraInfo == null ? null : extraInfo.Image;
    }

    public void setImage(UIImage value) {
        OnImageInfo().Image = value;
        extraInfo.Uri = null;
    }

    // Loads the image from the specified uri (use this or Image)
    public URI getImageUri() {
        return extraInfo == null ? null : extraInfo.Uri;
    }

    public void setImageUri(URI value) {
        OnImageInfo().Uri = value;
        extraInfo.Image = null;
    }

    // Background color for the cell (alternative: BackgroundUri)
    public UIColor getBackgroundColor() {
        return extraInfo == null ? null : extraInfo.BackgroundColor;
    }

    public void setBackgroundColor(UIColor value) {
        OnImageInfo().BackgroundColor = value;
        extraInfo.BackgroundUri = null;
    }

    public UIColor getDetailColor() {
        return extraInfo == null ? null : extraInfo.DetailColor;
    }

    public void setDetailColor(UIColor value) {
        OnImageInfo().DetailColor = value;
    }

    // Uri for a Background image (alternatiev: BackgroundColor)
    public URI getBackgroundUri() {
        return extraInfo == null ? null : extraInfo.BackgroundUri;
    }

    public void setBackgroundUri(URI value) {
        OnImageInfo().BackgroundUri = value;
        extraInfo.BackgroundColor = null;
    }

    protected String GetKey(int style) {
        return skey[style];
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        String key = GetKey((int) style);
        UITableViewCell cell = tv.dequeueReusableCell(key);
        if (cell == null) {
            cell = new UITableViewCell(style, key);
            cell.setSelectionStyle(UITableViewCellSelectionStyle.BLUE);
        }
        PrepareCell(cell);
        return cell;
    }

    protected void PrepareCell (UITableViewCell cell)
    {
        cell.setAccessory(Accessory);
        UILabel tl = cell.getTextLabel();
        tl.setText(Caption);
        tl.setTextAlignment(Alignment);
        tl.setTextColor(TextColor == null ? UIColor.Black : TextColor);
        tl.setFont(Font == null ? UIFont.BoldSystemFontOfSize (17) : Font);
        tl.setLineBreakMode(LineBreakMode);
        tl.setLines(Lines);

        // The check is needed because the cell might have been recycled.
        if (cell.getDetailTextLabel() != null)
            cell.getDetailTextLabel().setText(Value == null ? "" : Value);

        if (extraInfo == null){
            ClearBackground (cell);
        } else {
            UIImageView imgView = cell.getImageView();
            UIImage img;

            if (imgView != null) {
                if (extraInfo.Uri != null)
                    img = ImageLoader.defaultRequestImage (extraInfo.Uri, this);
                else if (extraInfo.Image != null)
                    img = extraInfo.Image;
                else
                    img = null;
                imgView.setImage(img);
            }

            if (cell.getDetailTextLabel() != null)
                cell.getDetailTextLabel().setTextColor( = extraInfo.DetailColor == null ? UIColor.GRAY : extraInfo.DetailColor);
        }

        if (cell.getDetailTextLabel() != null){
            cell.getDetailTextLabel().setLines(Lines);
            cell.getDetailTextLabel().setLineBreakMode(LineBreakMode);
            cell.getDetailTextLabel().setFont(SubtitleFont == null ? UIFont.SystemFontOfSize (14) : SubtitleFont);
            cell.getDetailTextLabel().setTextColor((extraInfo == null || extraInfo.DetailColor == null) ? UIColor.GRAY : extraInfo.DetailColor);
        }
    }

    void ClearBackground(UITableViewCell cell) {
        cell.setBackgroundColor(UIColor.WHITE);
        cell.getTextLabel().setBackgroundColor(UIColor.CLEAR);
    }

    @Override
    void /*IColorizeBackground.*/WillDisplay(UITableView tableView,
            UITableViewCell cell, NSIndexPath indexPath) {
        if (extraInfo == null) {
            ClearBackground(cell);
            return;
        }

        if (extraInfo.BackgroundColor != null) {
            cell.setBackgroundColor(extraInfo.BackgroundColor);
            cell.getTextLabel().setBackgroundColor(UIColor.CLEAR);
        } else if (extraInfo.BackgroundUri != null) {
            img = ImageLoader
                    .defaultRequestImage(extraInfo.BackgroundUri, this);
            cell.setBackgroundColor(img == null ? UIColor.White : UIColor
                    .FromPatternImage(img));
            cell.getTextLabel().setBackgroundColor(UIColor.CLEAR);
        } else
            ClearBackground(cell);
    }

    @Override
    void /*IImageUpdated.*/UpdatedImage(URI uri) {
        if (uri == null || extraInfo == null)
            return;
        RootElement root = GetImmediateRootElement();
        if (root == null || root.TableView == null)
            return;
        root.TableView.ReloadRows(new NSIndexPath[] { IndexPath },
                UITableViewRowAnimation.NONE);
    }

    private void AccessoryTap() {
        NSAction tapped = AccessoryTapped;
        if (tapped != null)
            tapped.action();
    }
}