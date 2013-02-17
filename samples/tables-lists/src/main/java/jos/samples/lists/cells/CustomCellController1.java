package jos.samples.lists.cells;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSBundle;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UILabel;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UIViewController;

public class CustomCellController1 extends UIViewController {

    @Outlet
    UITableViewCell celMain;

    @Outlet
    UIImageView imgMain;

    @Outlet
    UILabel lblHeading;

    @Outlet
    UILabel lblSubHeading;

    public CustomCellController1() {
        //super("CustomCellController1", null);
        // this next line forces the loading of the xib file to be synchronous
        NSBundle.getMainBundle().loadNib("CustomCellController1", this, null);
    }

    public String getHeading() {
        return this.lblHeading.getText();
    }

    public void setHeading(String value) {
        this.lblHeading.setText(value);
    }

    public String getSubHeading() {
        return this.lblSubHeading.getText();
    }

    public void setSubHeading(String value) {
        this.lblSubHeading.setText(value);
    }

    public UIImage getImage() {
        return this.imgMain.getImage();
    }

    public void setImage(UIImage value) {
        this.imgMain.setImage(value);
    }

}
