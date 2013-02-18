package jos.samples.animation.screens;

import static jos.api.graphicsimaging.CGGeometry.makeRect;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSAction;
import jos.api.foundation.NSObject;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UIToolbar;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class BasicUIViewAnimationScreen extends UIViewController {

    @Outlet
    UIButton btnClickMe;

    @Outlet
    UIImageView imgToAnimate;

    @Outlet
    UIToolbar tlbrMain;


    public BasicUIViewAnimationScreen() {
        super("BasicUIViewAnimationScreen", null);
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        btnClickMe.addTarget(new EventListener() {

            @Override
            public void onEvent(NSObject sender, UIEvent event) {

                //==== OLD WAY
                /*
                // begin our animation block. the name allows us to refer to it later
                UIView.beginAnimations("ImageMove");

                // move the image one way or the other
                if(imgToAnimate.getFrame().y == 64) {
                    imgToAnimate.setFrame(makeRect(
                        imgToAnimate.getFrame().x, imgToAnimate.getFrame().y + 400,
                        imgToAnimate.getFrame().size.width, imgToAnimate.getFrame().size.height));
                } else {
                    imgToAnimate.setFrame(makeRect(
                        imgToAnimate.getFrame().x, imgToAnimate.getFrame().y - 400,
                        imgToAnimate.getFrame().size.width, imgToAnimate.getFrame().size.height));
                }

                // finish our animation block
                UIView.commitAnimations();*/


                //===== NEW WAY

                // basic prototypes:
                //UIView.Animate(0.2, () => { /* code to animate */ });
                //UIView.Animate(0.2, delegate() { /* code to animate */ });
                UIView.animate(0.2, new NSAction() {

                    @Override
                    public void action() {
                        // move the image one way or the other
                        if(imgToAnimate.getFrame().origin.y == 64) {
                            imgToAnimate.setFrame(makeRect(
                                imgToAnimate.getFrame().origin.x, imgToAnimate.getFrame().origin.y + 400,
                                imgToAnimate.getFrame().size.width, imgToAnimate.getFrame().size.height));
                        } else {
                            imgToAnimate.setFrame(makeRect(
                                imgToAnimate.getFrame().origin.x, imgToAnimate.getFrame().origin.y - 400,
                                imgToAnimate.getFrame().size.width, imgToAnimate.getFrame().size.height));
                        }
                    }
                });
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
    }

    public void addContentsButton(UIBarButtonItem button) {
        button.setTitle("Contents");
        tlbrMain.setItems(new UIBarButtonItem[] { button }, false );
    }

    public void removeContentsButton () {
        tlbrMain.setItems(new UIBarButtonItem[0], false);
    }

}
