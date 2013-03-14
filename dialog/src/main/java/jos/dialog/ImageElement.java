package jos.dialog;

import static jos.api.graphicsimaging.CGBitmapContext.createBitmapContext;
import static jos.api.graphicsimaging.CGContext.addArc;
import static jos.api.graphicsimaging.CGContext.addLineToPoint;
import static jos.api.graphicsimaging.CGContext.clip;
import static jos.api.graphicsimaging.CGContext.drawImage;
import static jos.api.graphicsimaging.CGContext.fillRect;
import static jos.api.graphicsimaging.CGContext.moveTo;
import static jos.api.graphicsimaging.CGContext.scaleCTM;
import static jos.api.graphicsimaging.CGContext.setStrokeColor;
import static jos.api.graphicsimaging.CGContext.translateCTM;
import static jos.api.graphicsimaging.CGGeometry.makeRect;
import static jos.api.graphicsimaging.CGGeometry.makeSize;
import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSIndexPath;
import jos.api.foundation.NSString;
import jos.api.graphicsimaging.CGColorSpace;
import jos.api.graphicsimaging.CGColorSpaceRef;
import jos.api.graphicsimaging.CGContextRef;
import jos.api.graphicsimaging.CGImageAlphaInfo;
import jos.api.graphicsimaging.CGImageRef;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.UIGraphics;
import jos.api.uikit.UIDevice;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIImagePickerController;
import jos.api.uikit.UIImagePickerControllerDelegate;
import jos.api.uikit.UIPopoverArrowDirection;
import jos.api.uikit.UIPopoverController;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewRowAnimation;
import jos.api.uikit.UIViewController;

public class ImageElement extends Element {

    // Height for rows
    private static final int dimx = 48;
    private static final int dimy = 43;

    private UIImage Value;
    private static CGRect rect = makeRect(0, 0, dimx, dimy);
    private static NSString ikey = new NSString("ImageElement");
    private UIImage scaled;
    private UIPopoverController popover;

    // Apple leaks this one, so share across all.
    private static UIImagePickerController picker;

    // radius for rounding
    private static final int rad = 10;

    private static UIImage MakeEmpty() {
        CGColorSpaceRef cs = CGColorSpace.createDeviceRGB();
        CGContextRef bit = createBitmapContext(null,//IntPtr.Zero,
                dimx, dimy, 8, 0, cs, CGImageAlphaInfo.PREMULTIPLIED_FIRST);

        setStrokeColor(bit, 1, 0, 0, 0.5f);
        fillRect(bit, makeRect(0, 0, dimx, dimy));

        CGImageRef image = null;
        drawImage(bit, rect, image);
        return UIImage.fromImage(image);
    }

    private UIImage Scale(UIImage source) {
        UIGraphics.beginImageContext(makeSize(dimx, dimy));
        CGContextRef ctx = UIGraphics.getCurrentContext();

        CGImageRef img = source.CGImage;
        translateCTM(ctx, 0, dimy);
        if (img.width > img.height)
            scaleCTM(ctx, 1, -img.width / dimy);
        else
            scaleCTM(ctx, img.height / dimx, -1);

        drawImage(ctx, rect, source.CGImage);

        UIImage ret = UIGraphics.getImageFromCurrentImageContext();
        UIGraphics.endImageContext();
        return ret;
    }

    public ImageElement(UIImage image) {
        super("");
        if (image == null) {
            Value = MakeEmpty();
            scaled = Value;
        } else {
            Value = image;
            scaled = Scale(Value);
        }
    }

    @Override
    protected NSString getCellKey() {
        return ikey;
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        UITableViewCell cell = tv.dequeueReusableCell(getCellKey());
        if (cell == null) {
            cell = new UITableViewCell(UITableViewCellStyle.DEFAULT,
                    getCellKey());
        }

        if (scaled == null)
            return cell;

        Section psection = (Section) Parent;
        boolean roundTop = psection.getElements().get(0) == this;
        boolean roundBottom = psection.getElements().get(
                psection.getElements().size() - 1) == this;

        CGColorSpaceRef cs = CGColorSpace.createDeviceRGB();
        CGContextRef bit = createBitmapContext(null,//IntPtr.Zero,
                dimx, dimy, 8, 0, cs, CGImageAlphaInfo.PREMULTIPLIED_FIRST);

        // Clipping path for the image, different on top, middle and bottom.
        if (roundBottom) {
            addArc(bit, rad, rad, rad, (float) Math.PI,
                    (float) (3 * Math.PI / 2), 0);
        } else {
            moveTo(bit, 0, rad);
            addLineToPoint(bit, 0, 0);
        }
        addLineToPoint(bit, dimx, 0);
        addLineToPoint(bit, dimx, dimy);

        if (roundTop) {
            addArc(bit, rad, dimy - rad, rad, (float) (Math.PI / 2),
                    (float) Math.PI, 0);
            addLineToPoint(bit, 0, rad);
        } else {
            addLineToPoint(bit, 0, dimy);
        }
        clip(bit);
        drawImage(bit, rect, scaled.CGImage);

        cell.getImageView().setImage(
                UIImage.fromImage(scaled.CGImage/*toImage(bit)*/));

        return cell;
    }

    @Override
    protected void Dispose(boolean disposing) {
        if (disposing) {
            if (scaled != null) {
                scaled.dealloc();
                Value.dealloc();
                scaled = null;
                Value = null;
            }
        }
        super.Dispose(disposing);
    }

    private class MyDelegate extends UIImagePickerControllerDelegate {

        ImageElement container;
        UITableView table;
        NSIndexPath path;

        public MyDelegate(ImageElement container, UITableView table,
                NSIndexPath path) {
            this.container = container;
            this.table = table;
            this.path = path;
        }

        @Override
        public void finishedPickingImage(UIImagePickerController picker,
                UIImage image, NSDictionary editingInfo) {
            container.Picked(image);
            table.reloadRows(new NSIndexPath[] { path },
                    UITableViewRowAnimation.NONE);
        }
    }

    private void Picked(UIImage image) {
        Value = image;
        scaled = Scale(image);
        currentController.dismissModalViewControllerAnimated(true);

    }

    private UIViewController currentController;

    @Override
    public void Selected(DialogViewController dvc, UITableView tableView,
            NSIndexPath path) {
        if (picker == null)
            picker = new UIImagePickerController();
        picker.setImageDelegate(new MyDelegate(this, tableView, path));

        switch (UIDevice.getCurrentDevice().getUserInterfaceIdiom()) {
        case PAD:
            CGRect useRect;
            popover = new UIPopoverController(picker);
            UITableViewCell cell = tableView.cellAt(path);
            if (cell == null)
                useRect = rect;
            else
                useRect = cell.getFrame();
            popover.presentFromRect(useRect, dvc.getView(),
                    UIPopoverArrowDirection.ANY, true);
            break;

        default:
        case PHONE:
            dvc.ActivateController(picker);
            break;
        }
        currentController = dvc;
    }

}