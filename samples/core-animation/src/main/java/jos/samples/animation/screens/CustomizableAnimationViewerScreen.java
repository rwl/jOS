package jos.samples.animation.screens;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import jos.api.foundation.NSObject;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UISegmentedControl;
import jos.api.uikit.UISlider;
import jos.api.uikit.UISwitch;
import jos.api.uikit.UITextField;
import jos.api.uikit.UIToolbar;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewAnimationCurve;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

public class CustomizableAnimationViewerScreen extends UIViewController implements IDetailView {

    @Outlet
    UIButton btnStart;

    @Outlet
    UIImageView imgToAnimate;

    @Outlet
    UISegmentedControl sgmtCurves;

    @Outlet
    UISlider sldrDelay;

    @Outlet
    UISlider sldrDuration;

    @Outlet
    UITextField txtRepeateCount;

    @Outlet
    UIToolbar tlbrMain;

    @Outlet
    UISwitch swtchAutoReverse;

    public CustomizableAnimationViewerScreen() {
        super("CustomizableAnimationViewerScreen", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        btnStart.addTarget(new EventListener() {

            @Override
            public void onEvent(NSObject sender, UIEvent event) {

                /*double duration = (double) sldrDuration.getValue();
                double delay = (double) sldrDelay.getValue();
                UIViewAnimationOptions animationOptions = UIViewAnimationOptions.CurveEaseIn | UIViewAnimationOptions.Repeat;
                UIView.animate(duration, delay, animationOptions, new NSAction() {

                    @Override
                    public void action() {
                        // move the image one way or the other
                        if(imgToAnimate.Frame.Y == 190)
                        {
                            imgToAnimate.Frame = new System.Drawing.RectangleF(
                                imgToAnimate.Frame.X, imgToAnimate.Frame.Y + 400,
                                imgToAnimate.Frame.Size.Width, imgToAnimate.Frame.Size.Height);
                        } else {
                            imgToAnimate.Frame = new System.Drawing.RectangleF(
                                imgToAnimate.Frame.X, imgToAnimate.Frame.Y - 400,
                                imgToAnimate.Frame.Size.Width, imgToAnimate.Frame.Size.Height);
                        }
                    }
                }, null);*/

                // begin our animation block. the name allows us to refer to it later
                UIView.beginAnimations("ImageMove", null);

                UIView.setAnimationDidStopSelector(new Selector("AnimationStopped"));
                UIView.setAnimationDelegate(this); // NOTE: you need this for the selector to work

                // animation delay
                UIView.setAnimationDelay((double) sldrDelay.getValue());

                // animation duration
                UIView.setAnimationDuration((double) sldrDuration.getValue());

                // animation curve
                UIViewAnimationCurve curve = UIViewAnimationCurve.EASE_IN_OUT;
                switch (sgmtCurves.getSelectedSegment()) {
                    case 0: curve = UIViewAnimationCurve.EASE_IN_OUT; break;
                    case 1: curve = UIViewAnimationCurve.EASE_IN; break;
                    case 2: curve = UIViewAnimationCurve.EASE_OUT; break;
                    case 3: curve = UIViewAnimationCurve.LINEAR; break;
                }
                UIView.setAnimationCurve (curve);

                // repeat count
                UIView.setAnimationRepeatCount(Float.valueOf(txtRepeateCount.getText()));

                // autorevese when repeating
                UIView.setAnimationRepeatAutoreverses(swtchAutoReverse.isOn());

                // move the image one way or the other
                if (imgToAnimate.getFrame().origin.y == 190) {
                    imgToAnimate.setFrame(makeRect(
                        imgToAnimate.getFrame().origin.x, imgToAnimate.getFrame().origin.y + 400,
                        imgToAnimate.getFrame().size.width, imgToAnimate.getFrame().size.height));
                } else {
                    imgToAnimate.setFrame(makeRect(
                        imgToAnimate.getFrame().origin.x, imgToAnimate.getFrame().origin.y - 400,
                        imgToAnimate.getFrame().size.width, imgToAnimate.getFrame().size.height));
                }

                // finish our animation block
                UIView.commitAnimations();
            };

        }, UIControlEvent.TOUCH_UP_INSIDE);
    }

    @Export
    public void animationStopped(String name, int numFinished, Object context) {
        System.out.println("Animation completed");
    }

    @Override
    public void addContentsButton(UIBarButtonItem button) {
        button.setTitle("Contents");
        tlbrMain.setItems(new UIBarButtonItem[] { button }, false );
    }

    @Override
    public void removeContentsButton() {
        tlbrMain.setItems(new UIBarButtonItem[0], false);
    }

}
