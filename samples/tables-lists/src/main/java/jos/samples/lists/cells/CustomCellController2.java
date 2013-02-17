package jos.samples.lists.cells;

import static jos.api.graphicsimaging.CGGeometry.makeRect;

import jos.api.uikit.UIColor;
import jos.api.uikit.UIFont;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UILabel;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UIViewAutoresizing;
import jos.api.uikit.UIViewController;

public class CustomCellController2 extends UIViewController {

    UILabel lblHeading = new UILabel(makeRect(11, 0, 195, 46));
    UILabel lblSubHeading = new UILabel(makeRect(20, 45, 186, 30));
    UIImageView imgMain = new UIImageView(makeRect(214, 5, 100, 75));

    UITableViewCell cell = new UITableViewCell(UITableViewCellStyle.DEFAULT,
            "CustomCell2");

    public String getHeading() {
        return lblHeading.getText();
    }

    public void setHeading(String value) {
        lblHeading.setText(value);
    }

    public String getSubHeading() {
        return lblSubHeading.getText();
    }

    public void setSubHeading(String value) {
        lblSubHeading.setText(value);
    }

    public UIImage getImage() {
        return imgMain.getImage();
    }

    public setImage(UIImage value) {
        imgMain.setImage(value);
    }

    public CustomCellController2() {
        super();
        super.getView().addSubview(cell);
        cell.addSubview(lblHeading);
        cell.addSubview(lblSubHeading);
        cell.addSubview(imgMain);

        imgMain.setAutoresizingMask(UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN);
        lblHeading.setTextColor(UIColor.BROWN);
        lblHeading.setFont(UIFont.systemFontOfSize(32));
        lblSubHeading.setTextColor(UIColor.DARK_GRAY);
        lblSubHeading.setFont(UIFont.systemFontOfSize(13));
    }

}
