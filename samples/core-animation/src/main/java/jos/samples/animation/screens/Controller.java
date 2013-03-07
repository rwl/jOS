package jos.samples.animation.screens;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import jos.api.foundation.NSAction;
import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGRect;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIToolbar;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class Controller extends UIViewController implements IDetailView {

    protected UIToolbar toolbar;
    protected TransitionViewController controller1;
    protected BackTransitionViewController controller2;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        toolbar = new UIToolbar(makeRect(0, 0, getView().getFrame().size.width, 44));
        getView().addSubview(toolbar);

        CGRect mainFrame = makeRect(0, toolbar.getFrame().size.height,
                getView().getFrame().size.width,
                getView().getFrame().size.height - toolbar.getFrame().size.height);

        controller1 = new TransitionViewController();
        controller1.getView().setFrame(mainFrame);
        controller2 = new BackTransitionViewController();
        controller2.getView().setFrame(mainFrame);

        getView().addSubview(controller1.getView());

        // controller2.getView().setHidden(true);

        controller1.transitionClicked = new EventListener() {

            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                UIView.animate(1, 0, controller1.getSelectedTransition(), new NSAction() {
                    @Override
                    public void action() {
                        controller1.getView().removeFromSuperview();
                        getView().addSubview (controller2.getView());
                        // controller1.View.Hidden = false;
                        // controller2.View.Hidden = true;
                    }
                }, null);
                UIView.beginAnimations("ViewChange", null);
                /*UIView.setAnimationTransition(UIViewAnimationTransition.FLIP_FROM_LEFT,
                        getView(), true) {
                    controller1.getView().removeFromSuperview();
                    getView().addSubview(controller2.getView());
                }
                UIView.commitAnimations();*/
            }
        };

        controller2.backClicked = new EventListener() {

            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                UIView.animate(.75, 0, controller1.getSelectedTransition(), new NSAction() {
                    @Override
                    public void action() {
                        controller2.getView().removeFromSuperview();
                        getView().addSubview(controller1.getView());
                    }
                }, null);
            }
        };
    }

    @Override
    public void addContentsButton(UIBarButtonItem button) {
        button.setTitle("Contents");
        toolbar.setItems(new UIBarButtonItem[] { button }, false);
    }

    @Override
    public void removeContentsButton() {
         toolbar.setItems(new UIBarButtonItem[0], false);
    }

}
