package jos.api.uikit;

import jos.api.foundation.NSCoding;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@BaseType({NSCoding.class, UIGestureRecognizerDelegate.class})
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

    @Export("initWithStyle:reuseIdentifier:")
    public UITableViewCell(UITableViewCellStyle style, NSString reuseIdentifier) {
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


    @Export("detailTextLabel")
    public UILabel getDetailTextLabel() {
        throw new RuntimeException();
    }

    @Export("reuseIdentifier")
    public String getReuseIdentifier() {
        throw new RuntimeException();
    }

    @Export("selectionStyle")
    public UITableViewCellSelectionStyle getSelectionStyle() {
        throw new RuntimeException();
    }

    @Export("setSelectionStyle:")
    public void setSelectionStyle(UITableViewCellSelectionStyle value) {
        throw new RuntimeException();
    }

    @Bind("isSelected")
    @Export("selected")
    public boolean getSelected() {
        throw new RuntimeException();
    }

    @Export("setSelected:")
    public void setSelected(boolean value) {
        throw new RuntimeException();
    }

    @Bind("isHighlighted")
    @Export("highlighted")
    public boolean getHighlighted() {
        throw new RuntimeException();
    }

    @Export("setHighlighted:")
    public void setHighlighted(boolean value) {
        throw new RuntimeException();
    }

    @Export("editingStyle")
    public UITableViewCellEditingStyle getEditingStyle() {
        throw new RuntimeException();
    }

    @Export("showsReorderControl")
    public boolean getShowsReorderControl() {
        throw new RuntimeException();
    }

    @Export("setShowsReorderControl:")
    public void setShowsReorderControl(boolean value) {
        throw new RuntimeException();
    }

    @Export("shouldIndentWhileEditing")
    public boolean getShouldIndentWhileEditing() {
        throw new RuntimeException();
    }

    @Export("setShouldIndentWhileEditing:")
    public void setShouldIndentWhileEditing(boolean value) {
        throw new RuntimeException();
    }

    @Export("accessoryView")
    public UIView getAccessoryView() {
        throw new RuntimeException();
    }

    @Export("setAccessoryView:")
    public void setAccessoryView(UIView value) {
        throw new RuntimeException();
    }

    @Export("editingAccessoryType")
    public UITableViewCellAccessoryType getEditingAccessoryType() {
        throw new RuntimeException();
    }

    @Export("setEditingAccessoryType:")
    public void setEditingAccessoryType(UITableViewCellAccessoryType value) {
        throw new RuntimeException();
    }

    @Export("editingAccessoryView")
    public UIView getEditingAccessoryView() {
        throw new RuntimeException();
    }

    @Export("setEditingAccessoryView:")
    public void setEditingAccessoryView(UIView value) {
        throw new RuntimeException();
    }

    @Export("indentationLevel")
    public int getIndentationLevel() {
        throw new RuntimeException();
    }

    @Export("setIndentationLevel:")
    public void setIndentationLevel(int value) {
        throw new RuntimeException();
    }

    @Export("indentationWidth")
    public float getIndentationWidth() {
        throw new RuntimeException();
    }

    @Export("setIndentationWidth:")
    public void setIndentationWidth(float value) {
        throw new RuntimeException();
    }

    @Bind("isEditing")
    @Export("editing")
    public boolean getEditing() {
        throw new RuntimeException();
    }

    @Export("setEditing:")
    public void setEditing(boolean value) {
        throw new RuntimeException();
    }

    @Export("showingDeleteConfirmation")
    public boolean getShowingDeleteConfirmation() {
        throw new RuntimeException();
    }

    @Export("initWithStyle:reuseIdentifier:")
    public NSObject initWithStylereuseIdentifier(UITableViewCellStyle style, String reuseIdentifier) {
        throw new RuntimeException();
    }

    @Export("imageView")
    public UIImageView getImageView() {
        throw new RuntimeException();
    }

    @Export("contentView")
    public UIView getContentView() {
        throw new RuntimeException();
    }

    @Export("backgroundView")
    public UIView getBackgroundView() {
        throw new RuntimeException();
    }

    @Export("selectedBackgroundView")
    public UIView getSelectedBackgroundView() {
        throw new RuntimeException();
    }

    @Export("multipleSelectionBackgroundView")
    public UIView getMultipleSelectionBackgroundView() {
        throw new RuntimeException();
    }

    @Export("prepareForReuse")
    public void prepareForReuse() {
        throw new RuntimeException();
    }

    @Export("setSelected:animated:")
    public void setSelectedanimated(boolean selected, boolean animated) {
        throw new RuntimeException();
    }

    @Export("setHighlighted:animated:")
    public void setHighlightedanimated(boolean highlighted, boolean animated) {
        throw new RuntimeException();
    }

    @Export("setEditing:animated:")
    public void setEditinganimated(boolean editing, boolean animated) {
        throw new RuntimeException();
    }

    @Export("willTransitionToState:")
    public void willTransitionToState(UITableViewCellStateMask state) {
        throw new RuntimeException();
    }

    @Export("didTransitionToState:")
    public void didTransitionToState(UITableViewCellStateMask state) {
        throw new RuntimeException();
    }


    @Export("font")
    public UIFont getFont() {
        throw new RuntimeException();
    }

    @Export("setFont:")
    public void setFont(UIFont value) {
        throw new RuntimeException();
    }

    @Export("textAlignment")
    public int getTextAlignment() {
        throw new RuntimeException();
    }

    @Export("setTextAlignment:")
    public void setTextAlignment(int value) {
        throw new RuntimeException();
    }

    @Export("lineBreakMode")
    public NSLineBreakMode getLineBreakMode() {
        throw new RuntimeException();
    }

    @Export("setLineBreakMode:")
    public void setLineBreakMode(NSLineBreakMode value) {
        throw new RuntimeException();
    }

    @Export("textColor")
    public UIColor getTextColor() {
        throw new RuntimeException();
    }

    @Export("setTextColor:")
    public void setTextColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("selectedTextColor")
    public UIColor getSelectedTextColor() {
        throw new RuntimeException();
    }

    @Export("setSelectedTextColor:")
    public void setSelectedTextColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("image")
    public UIImage getImage() {
        throw new RuntimeException();
    }

    @Export("setImage:")
    public void setImage(UIImage value) {
        throw new RuntimeException();
    }

    @Export("selectedImage")
    public UIImage getSelectedImage() {
        throw new RuntimeException();
    }

    @Export("setSelectedImage:")
    public void setSelectedImage(UIImage value) {
        throw new RuntimeException();
    }

    @Export("editAction")
    public Selector getEditAction() {
        throw new RuntimeException();
    }

    @Export("setEditAction:")
    public void setEditAction(Selector value) {
        throw new RuntimeException();
    }

    @Export("accessoryAction")
    public Selector getAccessoryAction() {
        throw new RuntimeException();
    }

    @Export("setAccessoryAction:")
    public void setAccessoryAction(Selector value) {
        throw new RuntimeException();
    }
}
