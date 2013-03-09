package jos.dialog;

import java.util.Date;

import jos.api.foundation.NSDateFormatter;
import jos.api.foundation.NSDateFormatterStyle;
import jos.api.foundation.NSIndexPath;
import jos.api.graphicsimaging.CGRect;
import jos.api.uikit.UIApplication;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UIDatePickerMode;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIScreen;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessoryType;
import jos.api.uikit.UIViewAutoresizing;
import jos.api.uikit.UIViewController;

public class DateTimeElement extends StringElement {

    private Date DateValue;
    private UIDatePicker datePicker;
    private EventListener DateSelected;
    private UIColor BackgroundColor = UIColor.BLACK;

    protected NSDateFormatter fmt = new NSDateFormatter();
    {
        fmt.setDateStyle(NSDateFormatterStyle.SHORT);
    };

    public DateTimeElement(String caption, Date date) {
        super(caption);
        DateValue = date;
        Value = FormatDate(date);
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        Value = FormatDate(DateValue);
        UITableViewCell cell = super.GetCell(tv);
        cell.setAccessory(UITableViewCellAccessoryType.DISCLOSURE_INDICATOR);
        cell.setSelectionStyle(UITableViewCellSelectionStyle.BLUE);
        return cell;
    }

    @Override
    protected void Dispose(boolean disposing) {
        super.Dispose(disposing);
        if (disposing) {
            if (fmt != null) {
                fmt.Dispose();
                fmt = null;
            }
            if (datePicker != null) {
                datePicker.Dispose();
                datePicker = null;
            }
        }
    }

    protected Date GetDateWithKind(Date dt) {
        if (dt.Kind == DateTimeKind.UNSPECIFIED)
            return DateTime.specifyKind(dt, DateTimeKind.LOCAL);

        return dt;
    }

    public String FormatDate(Date dt) {
        dt = GetDateWithKind(dt);
        return fmt.toString(dt) + " " + dt.toLocalTime().toShortTimeString();
    }

    public UIDatePicker CreatePicker() {
        UIDatePicker picker = new UIDatePicker(RectangleF.Empty);
        picker.setAutoresizingMask(UIViewAutoresizing.FLEXIBLE_WIDTH);
        picker.setMode(UIDatePickerMode.DATE_AND_TIME);
        picker.setDate(DateValue);
        return picker;
    }

    static CGRect PickerFrameWithSize(CGSize size) {
        CGRect screenRect = UIScreen.getMainScreen().getApplicationFrame();
        float fY = 0, fX = 0;

        switch (UIApplication.getSharedApplication().getStatusBarOrientation()) {
        case UIInterfaceOrientation.LANDSCAPE_LEFT:
        case UIInterfaceOrientation.LANDSCAPE_RIGHT:
            fX = (screenRect.height - size.width) / 2;
            fY = (screenRect.width - size.Height) / 2 - 17;
            break;

        case UIInterfaceOrientation.PORTRAIT:
        case UIInterfaceOrientation.PORTRAIT_UPSIDE_DOWN:
            fX = (screenRect.width - size.Width) / 2;
            fY = (screenRect.height - size.Height) / 2 - 25;
            break;
        }

        return makeRect(fX, fY, size.Width, size.height);
    }

    class MyViewController extends UIViewController {

        DateTimeElement container;

        public MyViewController(DateTimeElement container) {
            this.container = container;
        }

        @Override
        public void viewWillDisappear(boolean animated) {
            super.viewWillDisappear(animated);
            container.setDateValue(container.getDatePicker().getDate());
            if (container.getDateSelected() != null)
                container.setDateSelected(container);
        }

        @Override
        public void DidRotate(UIInterfaceOrientation fromInterfaceOrientation) {
            super.DidRotate(fromInterfaceOrientation);
            container.getDatePicker().setFrame(
                    PickerFrameWithSize(container.getDatePicker().sizeThatFits(
                            CGSize.empty())));
        }

        public boolean Autorotate;

        @Override
        public boolean shouldAutorotateToInterfaceOrientation(
                UIInterfaceOrientation toInterfaceOrientation) {
            return Autorotate;
        }
    }

    @Override
    public void Selected(DialogViewController dvc, UITableView tableView,
            NSIndexPath path) {
        MyViewController vc = new MyViewController(this);
        vc.Autorotate = dvc.Autorotate;
        datePicker = CreatePicker();

        vc.getView().setBackgroundColor(BackgroundColor);
        vc.getView().addSubview(datePicker);
        dvc.ActivateController(vc);

        datePicker.setFrame(PickerFrameWithSize(datePicker.SizeThatFits(CGSize
                .empty())));
    }

}