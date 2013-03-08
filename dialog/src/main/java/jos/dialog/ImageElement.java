package jos.dialog;

import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSIndexPath;
import jos.api.graphicsimaging.CGBitmapContext;
import jos.api.graphicsimaging.CGColorSpace;
import jos.api.graphicsimaging.CGColorSpaceRef;
import jos.api.graphicsimaging.CGImageAlphaInfo;
import jos.api.graphicsimaging.CGImageRef;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.UIGraphics;
import jos.api.uikit.UIDevice;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIPopoverController;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewRowAnimation;
import jos.api.uikit.UIViewController;

public class ImageElement extends Element {

    // Height for rows
    static final int dimx = 48;
    static final int dimy = 43;

    public UIImage Value;
    static CGRect rect = makeRect(0, 0, dimx, dimy);
    static NSString ikey = new NSString ("ImageElement");
    UIImage scaled;
    UIPopoverController popover;

    // Apple leaks this one, so share across all.
    static UIImagePickerController picker;

    // radius for rounding
    static final int rad = 10;

    static UIImage MakeEmpty ()
    {
        CGColorSpaceRef cs = CGColorSpace.createDeviceRGB();
        CGBitmapContext bit = new CGBitmapContext (null,//IntPtr.Zero,
                dimx, dimy, 8, 0, cs, CGImageAlphaInfo.PREMULTIPLIED_FIRST);

        setStrokeColor (bit, 1, 0, 0, 0.5f);
        fillRect (bit, makeRect(0, 0, dimx, dimy));

        return UIImage.fromImage (bit.ToImage ());
    }

    UIImage Scale (UIImage source)
    {
        UIGraphics.BeginImageContext (makeSize(dimx, dimy));
        CGBitmapContext ctx = UIGraphics.getCurrentContext ();

        CGImageRef img = source.CGImage;
        translateCTM (ctx, 0, dimy);
        if (img.width > img.height)
            scaleCTM (ctx, 1, -img.width/dimy);
        else
            scaleCTM (ctx, img.height/dimx, -1);

        drawImage (ctx, rect, source.CGImage);

        UIImage ret = UIGraphics.getImageFromCurrentImageContext ();
        UIGraphics.endImageContext ();
        return ret;
    }

    public ImageElement (UIImage image) {
        super("");
        if (image == null){
            Value = MakeEmpty ();
            scaled = Value;
        } else {
            Value = image;
            scaled = Scale (Value);
        }
    }

    @Override
    protected NSString getCellKey() {
            return ikey;
        }

    @Override
    public UITableViewCell GetCell (UITableView tv)
    {
        UITableViewCell cell = tv.dequeueReusableCell (getCellKey());
        if (cell == null){
            cell = new UITableViewCell (UITableViewCellStyle.DEFAULT, getCellKey());
        }

        if (scaled == null)
            return cell;

        Section psection = (Section) Parent;
        boolean roundTop = psection.Elements [0] == this;
        boolean roundBottom = psection.Elements [psection.Elements.Count-1] == this;

        CGColorSpaceRef cs = CGColorSpace.createDeviceRGB();
        CGBitmapContext bit = new CGBitmapContext(null,//IntPtr.Zero,
                dimx, dimy, 8, 0, cs, CGImageAlphaInfo.PREMULTIPLIED_FIRST);

        // Clipping path for the image, different on top, middle and bottom.
        if (roundBottom){
            addArc(bit, rad, rad, rad, (float) Math.PI, (float) (3*Math.PI/2), false);
        } else {
            MoveTo (bit, 0, rad);
            AddLineToPoint (bit, 0, 0);
        }
        AddLineToPoint (bit, dimx, 0);
        AddLineToPoint (bit, dimx, dimy);

        if (roundTop){
            AddArc (bit, rad, dimy-rad, rad, (float) (Math.PI/2), (float) Math.PI, false);
            AddLineToPoint (bit, 0, rad);
        } else {
            AddLineToPoint (bit, 0, dimy);
        }
        Clip (bit);
        DrawImage (bit, rect, scaled.CGImage);

        cell.getImageView().setImage(UIImage.fromImage(toImage(bit)));

        return cell;
    }

    @Override
    protected void Dispose (boolean disposing)
    {
        if (disposing){
            if (scaled != null){
                scaled.Dispose ();
                Value.Dispose ();
                scaled = null;
                Value = null;
            }
        }
        super.Dispose (disposing);
    }

    class MyDelegate extends UIImagePickerControllerDelegate {

        ImageElement container;
        UITableView table;
        NSIndexPath path;

        public MyDelegate (ImageElement container, UITableView table, NSIndexPath path)
        {
            this.container = container;
            this.table = table;
            this.path = path;
        }

        @Override
        public void FinishedPickingImage (UIImagePickerController picker, UIImage image, NSDictionary editingInfo)
        {
            container.Picked (image);
            table.ReloadRows (new NSIndexPath [] { path }, UITableViewRowAnimation.NONE);
        }
    }

    void Picked (UIImage image)
    {
        Value = image;
        scaled = Scale (image);
        currentController.DismissModalViewControllerAnimated (true);

    }

    UIViewController currentController;

    @Override
    public void Selected (DialogViewController dvc, UITableView tableView, NSIndexPath path)
    {
        if (picker == null)
            picker = new UIImagePickerController ();
        picker.setDelegate(new MyDelegate (this, tableView, path));

        switch (UIDevice.getCurrentDevice().getUserInterfaceIdiom()) {
        case UIUserInterfaceIdiom.PAD:
            CGRect useRect;
            popover = new UIPopoverController (picker);
            UITableViewCell cell = tableView.CellAt (path);
            if (cell == null)
                useRect = rect;
            else
                useRect = cell.getFrame();
            popover.PresentFromRect (useRect, dvc.View, UIPopoverArrowDirection.ANY, true);
            break;

        default:
        case UIUserInterfaceIdiom.PHONE:
            dvc.ActivateController (picker);
            break;
        }
        currentController = dvc;
    }

}