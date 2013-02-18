package jos.samples.animation.screens;

import jos.api.foundation.NSAction;
import jos.api.graphicsimaging.CGRect;
import jos.api.uikit.UIBarButtonItem;
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

        toolbar = new UIToolbar(makeRect(0, 0, view.getFrame().width, 44));
        view.add(toolbar);

        CGRect mainFrame = makeRect(0, toolbar.getFrame().height,
                view.getFrame().width, view.getFrame().height - toolbar.getFrame().height);

        controller1 = new TransitionViewController();
        controller1.getView().setFrame(mainFrame);
        controller2 = new BackTransitionViewController();
        controller2.getView().setFrame(mainFrame);

        view.addSubview(controller1.getView());

        // controller2.getView().setHidden(true);

        controller1.transitionClicked = (s, e) {
            UIView.animate(1, 0, controller1.SelectedTransition, new NSAction() {
                @Override
                public void action() {
                    controller1.View.RemoveFromSuperview ();
                    View.AddSubview (controller2.View);
                    // controller1.View.Hidden = false;
                    // controller2.View.Hidden = true;
                }
            }, null);
            UIView.beginAnimations("ViewChange");
//          UIView.setAnimationTransition(UIViewAnimationTransition.FlipFromLeft, view, true) {
//              controller1.getView().removeFromSuperview();
//              view.addSubview(controller2.getView());
//          }
//          UIView.commitAnimations();

        };

         controller2.backClicked = (s, e) {
            UIView.animate(.75, 0, controller1.SelectedTransition, new NSAction() {
                @Override
                public void action() {
                    controller2.getView().removeFromSuperview();
                    view.addSubview(controller1.getView());
                }
            }, null);
        };
    }

    public void addContentsButton(UIBarButtonItem button) {
        button.setTitle("Contents");
        toolbar.setItems(new UIBarButtonItem[] { button }, false);
    }

    public void removeContentsButton() {
         toolbar.setItems(new UIBarButtonItem[0], false);
    }

}
