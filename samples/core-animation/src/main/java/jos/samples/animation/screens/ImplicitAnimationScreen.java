package jos.samples.animation.screens;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIToolbar;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class ImplicitAnimationScreen extends UIViewController implements IDetailView {

    @Outlet
    UIView view;

    @Outlet
    UIToolbar tlbrMain;

    @Outlet
    UIButton btnAnimate;

    CALayer imgLayer;

    public ImplicitAnimationScreen()
    {
        super("ImplicitAnimationScreen", null);

        System.out.println("Creating Layer");

        // create our layer and set it's frame
        imgLayer = createLayerFromImage();
        imgLayer.setFrame(makeRect(200, 70, 114, 114));

        // add the layer to the layer tree so that it's visible
        view.getLayer().addSublayer(imgLayer);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // anonymous delegate that runs when the btnAnimate button is clicked
        btnAnimate.addTarget(new EventListener() {

            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                // if you want to override the animation duration, you can:
                //imgToAnimate.getLayer().setDuration(1.0);

                if (imgLayer.getFrame().origin.y == 70) {
                     imgLayer.setFrame(makeRect(200, 270,
                             imgLayer.getFrame().size.width,
                             imgLayer.getFrame().size.height));
                     imgLayer.setOpacity(0.2f);
                } else {
                     imgLayer.setFrame(makeRect(200, 70,
                             imgLayer.getFrame.size.width,
                             imgLayer.getFrame.size.height);
                     imgLayer.setOpacity(1.0f);
                }
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
    }

    //==== Ways to create a CALayer

    //==== Method 1: create a layer from an image
    protected CALayer createLayerFromImage() {
        CALayer layer = new CALayer();
        layer.setContents(UIImage.fromBundle("Images/Icons/114_icon.png").CGImage);
        return layer;
    }

    //==== Method 2: create a layer and assign a custom delegate that performs the drawing
    protected CALayer createLayerWithDelegate() {
        CALayer layer = new CALayer();
        layer.setDelegate(new LayerDelegate());
        return layer;
    }

    public static class LayerDelegate extends CALayerDelegate {
        @Override
        public void drawLayer(CALayer layer, CGContext context) {
            // implement your drawing
        }
    }

    //===== Method 3: Create a custom CALayer and override the appropriate methods
    public static class MyCustomLayer extends CALayer {
        @Override
        public void drawInContext(CGContext ctx) {
            super.drawInContext(ctx);
            // implement your drawing
        }
    }

    public void addContentsButton(UIBarButtonItem button) {
        button.setTitle("Contents");
        this.tlbrMain.setItems(new UIBarButtonItem[] { button }, false);
    }

    public void removeContentsButton() {
        this.tlbrMain.setItems(new UIBarButtonItem[0], false);
    }

}
