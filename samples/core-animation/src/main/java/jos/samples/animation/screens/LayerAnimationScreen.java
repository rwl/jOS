package jos.samples.animation.screens;

import static jos.api.graphicsimaging.CGGeometry.makePoint;
import static jos.api.graphicsimaging.CGGeometry.makeSize;
import static jos.api.graphicsimaging.CGPath.moveToPoint;
import static jos.api.graphicsimaging.CGPath.addCurveToPoint;
import static jos.api.graphicsimaging.CGAffineTransform.scale;
import static jos.api.graphicsimaging.CGAffineTransform.translate;
import static jos.api.graphicsimaging.CGContext.concatCTM;
import static jos.api.graphicsimaging.CGContext.addPath;
import static jos.api.graphicsimaging.CGContext.setFillColor;
import static jos.api.graphicsimaging.CGContext.setLineWidth;
import static jos.api.graphicsimaging.CGContext.strokePath;
import static jos.api.graphicsimaging.CGContext.drawImage;
import static jos.api.graphicsimaging.CGBitmapContext.createBitmapContext;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGAffineTransform;
import jos.api.graphicsimaging.CGColorSpace;
import jos.api.graphicsimaging.CGContextRef;
import jos.api.graphicsimaging.CGImageAlphaInfo;
import jos.api.graphicsimaging.CGImageRef;
import jos.api.graphicsimaging.CGPath;
import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGSize;
import jos.api.quartz.CAKeyframeAnimation;
import jos.api.quartz.CAMediaTimingFunction;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UIToolbar;
import jos.api.uikit.UIViewController;

public class LayerAnimationScreen extends UIViewController implements IDetailView {

    @Outlet
    UIToolbar tlbrMain;

    @Outlet
    UIButton btnAnimate;

    @Outlet
    UIImageView imgToAnimate;

    CGPath animationPath = new CGPath();

    UIImageView backgroundImage = null;

    public LayerAnimationScreen() {
        super("LayerAnimationScreen", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // add our background image view that we'll show our path on
        backgroundImage = new UIImageView(getView().getFrame());
        getView().addSubview(backgroundImage);

        // create our path
        createPath();

        btnAnimate.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                // create a keyframe animation
                CAKeyframeAnimation keyFrameAnimation = (CAKeyframeAnimation) CAKeyframeAnimation.fromKeyPath("position");
                keyFrameAnimation.setPath(animationPath);
                //FIXME: keyFrameAnimation.setDuration(3);

                keyFrameAnimation.setTimingFunction(CAMediaTimingFunction.fromName("EaseInEaseOut"));

                imgToAnimate.getLayer().addAnimation(keyFrameAnimation, "MoveImage");
                imgToAnimate.getLayer().setPosition(makePoint(700, 900));

                // later, if we want to stop/remove the animation, we can call RemoveAnimation and pass the name:
                //imgToAnimate.getLayer().removeAnimation("MoveImage");
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
    }

    // Creates the path that we'll use to animate on. Once the path is created, it calls
    // drawPathAsBackground to draw the path on the screen.
    protected void createPath() {
        // define our path
        CGPoint curve1StartPoint = makePoint(56, 104);
        CGPoint curve1ControlPoint1 = makePoint(50, 250);
        CGPoint curve1ControlPoint2 = makePoint(220, 450);
        CGPoint curve1EndPoint = makePoint(384, 450);
        CGPoint curve2ControlPoint1 = makePoint(500, 450);
        CGPoint curve2ControlPoint2 = makePoint(700, 650);
        CGPoint curve2EndPoint = makePoint(700, 900);
        moveToPoint(animationPath, null, curve1StartPoint.x, curve1StartPoint.y);
        addCurveToPoint(animationPath, null, curve1ControlPoint1.x, curve1ControlPoint1.y,
                curve1ControlPoint2.x, curve1ControlPoint2.y,
                curve1EndPoint.x, curve1EndPoint.y);
        addCurveToPoint(animationPath, null, curve2ControlPoint1.x, curve2ControlPoint1.y,
                curve2ControlPoint2.x, curve2ControlPoint2.y,
                curve2EndPoint.x, curve2EndPoint.y);

        drawPathAsBackground();
    }

    // Draws our animation path on the background image, just to show it
    protected void drawPathAsBackground() {
        // create our offscreen bitmap context size
        CGSize bitmapSize = makeSize(getView().getFrame().size.width,
                getView().getFrame().size.height);
        CGContextRef context = createBitmapContext(
                   null,//IntPtr.Zero,
                   (int) bitmapSize.width, (int) bitmapSize.height, 8,
                   (int)(4 * bitmapSize.width), CGColorSpace.createDeviceRGB (),
                   CGImageAlphaInfo.PREMULTIPLIED_FIRST);

        // convert to View space
        CGAffineTransform affineTransform = CGAffineTransform.makeIdentity();
        // invert the y axis
        scale(affineTransform, 1, -1);
        // move the y axis up
        translate(affineTransform, 0, getView().getFrame().size.height);
        concatCTM(context, affineTransform);

        // actually draw the path
        addPath(context, animationPath);
        setFillColor(context, UIColor.LIGHT_GRAY.CGColor());
        setLineWidth(context, 3);
        strokePath(context);

        // set what we've drawn as the backgound image
        CGImageRef image = null;
        drawImage(context, getView().getFrame(), image);
        backgroundImage.setImage(UIImage.fromImage(image));

    }

    public void addContentsButton(UIBarButtonItem button) {
        button.setTitle("Contents");
        tlbrMain.setItems(new UIBarButtonItem[] { button }, false);
    }

    public void removeContentsButton() {
        tlbrMain.setItems(new UIBarButtonItem[0], false);
    }

}
