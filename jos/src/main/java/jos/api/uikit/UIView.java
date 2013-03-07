package jos.api.uikit;

import jos.api.foundation.NSAction;
import jos.api.foundation.NSArray;
import jos.api.foundation.NSCoder;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSDate;
import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGAffineTransform;
import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;
import jos.api.quartz.CALayer;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@BaseType({NSCoding.class, UIAppearance.class, UIAppearanceContainer.class})
@Register(isWrapper = true)
public class UIView extends UIResponder {

    @Export("init")
    public UIView() {
    }

    @Export("initWithFrame:")
    public UIView(final CGRect frame) {
    }

    @Bind("isUserInteractionEnabled")
    @Export("userInteractionEnabled")
    public boolean getUserInteractionEnabled() {
        throw new RuntimeException();
    }

    @Export("setUserInteractionEnabled:")
    public void setUserInteractionEnabled(boolean value) {
        throw new RuntimeException();
    }

    @Export("tag")
    public int getTag() {
        throw new RuntimeException();
    }

    @Export("setTag:")
    public void setTag(int value) {
        throw new RuntimeException();
    }

    @Export("layer")
    public CALayer getLayer() {
        throw new RuntimeException();
    }

    @Export("layerClass")
    public static Class layerClass() {
        throw new RuntimeException();
    }

    @Export("initWithFrame:")
    public NSObject initWithFrame(CGRect frame) {
        throw new RuntimeException();
    }

    @Export("center")
    public CGPoint getCenter() {
        throw new RuntimeException();
    }

    @Export("setCenter:")
    public void setCenter(CGPoint value) {
        throw new RuntimeException();
    }

    @Export("transform")
    public CGAffineTransform getTransform() {
        throw new RuntimeException();
    }

    @Export("setTransform:")
    public void setTransform(CGAffineTransform value) {
        throw new RuntimeException();
    }

    @Export("contentScaleFactor")
    public float getContentScaleFactor() {
        throw new RuntimeException();
    }

    @Export("setContentScaleFactor:")
    public void setContentScaleFactor(float value) {
        throw new RuntimeException();
    }

    @Bind("isMultipleTouchEnabled")
    @Export("multipleTouchEnabled")
    public boolean getMultipleTouchEnabled() {
        throw new RuntimeException();
    }

    @Export("setMultipleTouchEnabled:")
    public void setMultipleTouchEnabled(boolean value) {
        throw new RuntimeException();
    }

    @Bind("isExclusiveTouch")
    @Export("exclusiveTouch")
    public boolean getExclusiveTouch() {
        throw new RuntimeException();
    }

    @Export("setExclusiveTouch:")
    public void setExclusiveTouch(boolean value) {
        throw new RuntimeException();
    }

    @Export("autoresizesSubviews")
    public boolean getAutoresizesSubviews() {
        throw new RuntimeException();
    }

    @Export("setAutoresizesSubviews:")
    public void setAutoresizesSubviews(boolean value) {
        throw new RuntimeException();
    }

    @Export("autoresizingMask")
    public UIViewAutoresizing getAutoresizingMask() {
        throw new RuntimeException();
    }

    @Export("setAutoresizingMask:")
    public void setAutoresizingMask(int value) {
        throw new RuntimeException();
    }

    @Export("frame")
    public CGRect getFrame() {
        throw new RuntimeException();
    }

    @Export("setFrame:")
    public void setFrame(CGRect frame) {
        throw new RuntimeException();
    }

    @Export("bounds")
    public CGRect getBounds() {
        throw new RuntimeException();
    }

    @Export("hitTest:withEvent:")
    public UIView hitTestwithEvent(CGPoint point, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("pointInside:withEvent:")
    public boolean pointInsidewithEvent(CGPoint point, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("convertPoint:toView:")
    public CGPoint convertPointtoView(CGPoint point, UIView view) {
        throw new RuntimeException();
    }

    @Export("convertPoint:fromView:")
    public CGPoint convertPointfromView(CGPoint point, UIView view) {
        throw new RuntimeException();
    }

    @Export("convertRect:toView:")
    public CGRect convertRecttoView(CGRect rect, UIView view) {
        throw new RuntimeException();
    }

    @Export("convertRect:fromView:")
    public CGRect convertRectfromView(CGRect rect, UIView view) {
        throw new RuntimeException();
    }

    @Export("sizeThatFits:")
    public CGSize sizeThatFits(CGSize size) {
        throw new RuntimeException();
    }

    @Export("sizeToFit")
    public void sizeToFit() {
        throw new RuntimeException();
    }


    @Export("superview")
    public UIView getSuperview() {
        throw new RuntimeException();
    }

    @Export("window")
    public UIWindow getWindow() {
        throw new RuntimeException();
    }

    @Export("removeFromSuperview")
    public void removeFromSuperview() {
        throw new RuntimeException();
    }

    @Export("insertSubview:atIndex:")
    public void insertSubviewatIndex(UIView view, int index) {
        throw new RuntimeException();
    }

    @Export("exchangeSubviewAtIndex:withSubviewAtIndex:")
    public void exchangeSubviewAtIndexwithSubviewAtIndex(int index1, int index2) {
        throw new RuntimeException();
    }

    @Export("addSubview:")
    public void addSubview(UIView view) {
        throw new RuntimeException();
    }

    @Export("insertSubview:belowSubview:")
    public void insertSubviewbelowSubview(UIView view, UIView siblingSubview) {
        throw new RuntimeException();
    }

    @Export("insertSubview:aboveSubview:")
    public void insertSubviewaboveSubview(UIView view, UIView siblingSubview) {
        throw new RuntimeException();
    }

    @Export("bringSubviewToFront:")
    public void bringSubviewToFront(UIView view) {
        throw new RuntimeException();
    }

    @Export("sendSubviewToBack:")
    public void sendSubviewToBack(UIView view) {
        throw new RuntimeException();
    }

    @Export("didAddSubview:")
    public void didAddSubview(UIView subview) {
        throw new RuntimeException();
    }

    @Export("willRemoveSubview:")
    public void willRemoveSubview(UIView subview) {
        throw new RuntimeException();
    }

    @Export("willMoveToSuperview:")
    public void willMoveToSuperview(UIView newSuperview) {
        throw new RuntimeException();
    }

    @Export("didMoveToSuperview")
    public void didMoveToSuperview() {
        throw new RuntimeException();
    }

    @Export("willMoveToWindow:")
    public void willMoveToWindow(UIWindow newWindow) {
        throw new RuntimeException();
    }

    @Export("didMoveToWindow")
    public void didMoveToWindow() {
        throw new RuntimeException();
    }

    @Export("isDescendantOfView:")
    public boolean isDescendantOfView(UIView view) {
        throw new RuntimeException();
    }

    @Export("viewWithTag:")
    public UIView viewWithTag(int tag) {
        throw new RuntimeException();
    }

    @Export("setNeedsLayout")
    public void setNeedsLayout() {
        throw new RuntimeException();
    }

    @Export("layoutIfNeeded")
    public void layoutIfNeeded() {
        throw new RuntimeException();
    }

    @Export("layoutSubviews")
    public void layoutSubviews() {
        throw new RuntimeException();
    }


    @Export("clipsToBounds")
    public boolean getClipsToBounds() {
        throw new RuntimeException();
    }

    @Export("setClipsToBounds:")
    public void setClipsToBounds(boolean value) {
        throw new RuntimeException();
    }

    @Export("backgroundColor")
    public UIColor getBackgroundColor() {
        throw new RuntimeException();
    }

    @Export("setBackgroundColor:")
    public void setBackgroundColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("alpha")
    public float getAlpha() {
        throw new RuntimeException();
    }

    @Export("setAlpha:")
    public void setAlpha(float value) {
        throw new RuntimeException();
    }

    @Bind("isOpaque")
    @Export("opaque")
    public boolean getOpaque() {
        throw new RuntimeException();
    }

    @Export("setOpaque:")
    public void setOpaque(boolean value) {
        throw new RuntimeException();
    }

    @Export("clearsContextBeforeDrawing")
    public boolean getClearsContextBeforeDrawing() {
        throw new RuntimeException();
    }

    @Export("setClearsContextBeforeDrawing:")
    public void setClearsContextBeforeDrawing(boolean value) {
        throw new RuntimeException();
    }

    @Bind("isHidden")
    @Export("hidden")
    public boolean getHidden() {
        throw new RuntimeException();
    }

    @Export("setHidden:")
    public void setHidden(boolean value) {
        throw new RuntimeException();
    }

    @Export("contentMode")
    public UIViewContentMode getContentMode() {
        throw new RuntimeException();
    }

    @Export("setContentMode:")
    public void setContentMode(UIViewContentMode value) {
        throw new RuntimeException();
    }

    @Export("contentStretch")
    public CGRect getContentStretch() {
        throw new RuntimeException();
    }

    @Export("setContentStretch:")
    public void setContentStretch(CGRect value) {
        throw new RuntimeException();
    }

    @Export("drawRect:")
    public void draw(CGRect rect) {
        throw new RuntimeException();
    }

    @Export("setNeedsDisplay")
    public void setNeedsDisplay() {
        throw new RuntimeException();
    }

    @Export("setNeedsDisplayInRect:")
    public void setNeedsDisplayInRect(CGRect rect) {
        throw new RuntimeException();
    }


    @Export("beginAnimations:context:")
    public static void beginAnimationscontext(String animationID, Object context) {
        throw new RuntimeException();
    }

    @Export("setAnimationDelegate:")
    public static void setAnimationDelegate(Object delegate) {
        throw new RuntimeException();
    }

    @Export("setAnimationWillStartSelector:")
    public static void setAnimationWillStartSelector(Selector selector) {
        throw new RuntimeException();
    }

    @Export("setAnimationDidStopSelector:")
    public static void setAnimationDidStopSelector(Selector selector) {
        throw new RuntimeException();
    }

    @Export("setAnimationDuration:")
    public static void setAnimationDuration(double duration) {
        throw new RuntimeException();
    }

    @Export("setAnimationDelay:")
    public static void setAnimationDelay(double delay) {
        throw new RuntimeException();
    }

    @Export("setAnimationStartDate:")
    public static void setAnimationStartDate(NSDate startDate) {
        throw new RuntimeException();
    }

    @Export("setAnimationCurve:")
    public static void setAnimationCurve(UIViewAnimationCurve curve) {
        throw new RuntimeException();
    }

    @Export("setAnimationRepeatCount:")
    public static void setAnimationRepeatCount(float repeatCount) {
        throw new RuntimeException();
    }

    @Export("setAnimationRepeatAutoreverses:")
    public static void setAnimationRepeatAutoreverses(boolean repeatAutoreverses) {
        throw new RuntimeException();
    }

    @Export("setAnimationBeginsFromCurrentState:")
    public static void setAnimationBeginsFromCurrentState(boolean fromCurrentState) {
        throw new RuntimeException();
    }

    @Export("setAnimationTransition:forView:cache:")
    public static void setAnimationTransition(UIViewAnimationTransition transition, UIView view, boolean cache) {
        throw new RuntimeException();
    }

    @Export("setAnimationsEnabled:")
    public static void setAnimationsEnabled(boolean enabled) {
        throw new RuntimeException();
    }

    @Export("areAnimationsEnabled")
    public static boolean areAnimationsEnabled() {
        throw new RuntimeException();
    }


    @Export("gestureRecognizers")
    public NSArray getGestureRecognizers() {
        throw new RuntimeException();
    }

    @Export("setGestureRecognizers:")
    public void setGestureRecognizers(NSArray value) {
        throw new RuntimeException();
    }

    @Export("addGestureRecognizer:")
    public void addGestureRecognizer(UIGestureRecognizer gestureRecognizer) {
        throw new RuntimeException();
    }

    @Export("removeGestureRecognizer:")
    public void removeGestureRecognizer(UIGestureRecognizer gestureRecognizer) {
        throw new RuntimeException();
    }

    @Export("gestureRecognizerShouldBegin:")
    public boolean gestureRecognizerShouldBegin(UIGestureRecognizer gestureRecognizer) {
        throw new RuntimeException();
    }


    @Export("constraints")
    public NSArray constraints() {
        throw new RuntimeException();
    }

    @Export("addConstraint:")
    public void addConstraint(NSLayoutConstraint constraint) {
        throw new RuntimeException();
    }

    @Export("addConstraints:")
    public void addConstraints(NSArray constraints) {
        throw new RuntimeException();
    }

    @Export("removeConstraint:")
    public void removeConstraint(NSLayoutConstraint constraint) {
        throw new RuntimeException();
    }

    @Export("removeConstraints:")
    public void removeConstraints(NSArray constraints) {
        throw new RuntimeException();
    }


    @Export("updateConstraints")
    public void updateConstraints() {
        throw new RuntimeException();
    }

    @Export("setNeedsUpdateConstraints")
    public void setNeedsUpdateConstraints() {
        throw new RuntimeException();
    }


    @Export("requiresConstraintBasedLayout")
    public boolean requiresConstraintBasedLayout() {
        throw new RuntimeException();
    }

    // Detected properties
    @Export("translatesAutoresizingMaskIntoConstraints")
    public boolean getTranslatesAutoresizingMaskIntoConstraints() {
        throw new RuntimeException();
    }

    @Export("setTranslatesAutoresizingMaskIntoConstraints:")
    public void setTranslatesAutoresizingMaskIntoConstraints(boolean value) {
        throw new RuntimeException();
    }


    @Export("alignmentRectForFrame:")
    public CGRect alignmentRectForFrame(CGRect frame) {
        throw new RuntimeException();
    }

    @Export("frameForAlignmentRect:")
    public CGRect frameForAlignmentRect(CGRect alignmentRect) {
        throw new RuntimeException();
    }

    @Export("alignmentRectInsets")
    public UIEdgeInsets alignmentRectInsets() {
        throw new RuntimeException();
    }

    @Export("viewForBaselineLayout")
    public UIView viewForBaselineLayout() {
        throw new RuntimeException();
    }

    @Export("intrinsicContentSize")
    public CGSize intrinsicContentSize() {
        throw new RuntimeException();
    }

    @Export("invalidateIntrinsicContentSize")
    public void invalidateIntrinsicContentSize() {
        throw new RuntimeException();
    }

    @Export("contentHuggingPriorityForAxis:")
    public float contentHuggingPriorityForAxis(UILayoutConstraintAxis axis) {
        throw new RuntimeException();
    }

    @Export("setContentHuggingPriority:forAxis:")
    public void setContentHuggingPriorityforAxis(float priority, UILayoutConstraintAxis axis) {
        throw new RuntimeException();
    }

    @Export("contentCompressionResistancePriorityForAxis:")
    public float contentCompressionResistancePriorityForAxis(UILayoutConstraintAxis axis) {
        throw new RuntimeException();
    }

    @Export("setContentCompressionResistancePriority:forAxis:")
    public void setContentCompressionResistancePriorityforAxis(float priority, UILayoutConstraintAxis axis) {
        throw new RuntimeException();
    }


    @Export("systemLayoutSizeFittingSize:")
    public CGSize systemLayoutSizeFittingSize(CGSize targetSize) {
        throw new RuntimeException();
    }


    @Export("constraintsAffectingLayoutForAxis:")
    public NSArray constraintsAffectingLayoutForAxis(UILayoutConstraintAxis axis) {
        throw new RuntimeException();
    }

    @Export("hasAmbiguousLayout")
    public boolean hasAmbiguousLayout() {
        throw new RuntimeException();
    }

    @Export("exerciseAmbiguityInLayout")
    public void exerciseAmbiguityInLayout() {
        throw new RuntimeException();
    }


    @Export("encodeRestorableStateWithCoder:")
    public void encodeRestorableStateWithCoder(NSCoder coder) {
        throw new RuntimeException();
    }

    @Export("animateWithDuration:animations:")
    public static void animate(double duration, NSAction animations) {
        throw new RuntimeException();
    }

    @Export("animateWithDuration:delay:options:animations:completion:")
    public static void animate(double duration, double delay, int options,
            NSAction animations, NSAction completion) {
        throw new RuntimeException();
    }

    @Export("animateWithDuration:animations:completion:")
    public static void animate(double duration, NSAction animations, NSAction completion) {
        throw new RuntimeException();
    }

    @Export("beginAnimations:context:")
    public static void beginAnimations(String animationID, Object context) {
        throw new RuntimeException();
    }

    @Export("commitAnimations")
    public static void commitAnimations() {
        throw new RuntimeException();
    }

}
