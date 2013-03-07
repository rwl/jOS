package jos.api.quartz;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;
import jos.api.graphicsimaging.CGAffineTransform;
import jos.api.graphicsimaging.CGContextRef;
import jos.api.graphicsimaging.CGFloat;
import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCoding.class, CAMediaTiming.class})
@Register(isWrapper = true)
public class CALayer extends NSObject {

    @Export("layer")
    public NSObject layer() {
        throw new RuntimeException();
    }

    @Export("init")
    public CALayer() {
        throw new RuntimeException();
    }

    @Export("initWithLayer:")
    public CALayer(NSObject layer) {
        throw new RuntimeException();
    }

    @Export("presentationLayer")
    public NSObject presentationLayer() {
        throw new RuntimeException();
    }

    @Export("modelLayer")
    public NSObject modelLayer() {
        throw new RuntimeException();
    }

    @Export("defaultValueForKey:")
    public NSObject defaultValueForKey(String key) {
        throw new RuntimeException();
    }

    @Export("needsDisplayForKey:")
    public boolean needsDisplayForKey(NSString key) {
        throw new RuntimeException();
    }

    @Export("shouldArchiveValueForKey:")
    public boolean shouldArchiveValueForKey(String key) {
        throw new RuntimeException();
    }

    @Export("anchorPoint")
    public CGPoint anchorPoint() {
        throw new RuntimeException();
    }

    @Export("anchorPointZ")
    public CGFloat anchorPointZ() {
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

    @Export("isHidden")
    public boolean hidden() {
        throw new RuntimeException();
    }

    @Export("isDoubleSided")
    public boolean isDoubleSided() {
        throw new RuntimeException();
    }

    @Export("isGeometryFlipped")
    public boolean geometryFlipped() {
        throw new RuntimeException();
    }

    @Export("contentsAreFlipped")
    public boolean contentsAreFlipped() {
        throw new RuntimeException();
    }

    @Export("superlayer")
    public CALayer superlayer() {
        throw new RuntimeException();
    }

    @Export("removeFromSuperlayer")
    public void removeFromSuperlayer() {
        throw new RuntimeException();
    }

    @Export("sublayers")
    public NSArray sublayers() {
        throw new RuntimeException();
    }

    @Export("addSublayer:")
    public void addSublayer(CALayer layer) {
        throw new RuntimeException();
    }

    @Export("insertSublayer:atIndex:")
    public void insertSublayeratIndex(CALayer layer, int idx) {
        throw new RuntimeException();
    }

    @Export("insertSublayer:below:")
    public void insertSublayerbelow(CALayer layer, CALayer sibling) {
        throw new RuntimeException();
    }

    @Export("insertSublayer:above:")
    public void insertSublayerabove(CALayer layer, CALayer sibling) {
        throw new RuntimeException();
    }

    @Export("replaceSublayer:with:")
    public void replaceSublayerwith(CALayer layer, CALayer layer2) {
        throw new RuntimeException();
    }

    @Export("mask")
    public CALayer mask() {
        throw new RuntimeException();
    }

    @Export("masksToBounds")
    public boolean masksToBounds() {
        throw new RuntimeException();
    }

    @Export("convertPoint:fromLayer:")
    public CGPoint convertPointfromLayer(CGPoint p, CALayer l) {
        throw new RuntimeException();
    }

    @Export("convertPoint:toLayer:")
    public CGPoint convertPointtoLayer(CGPoint p, CALayer l) {
        throw new RuntimeException();
    }

    @Export("convertRect:fromLayer:")
    public CGRect convertRectfromLayer(CGRect r, CALayer l) {
        throw new RuntimeException();
    }

    @Export("convertRect:toLayer:")
    public CGRect convertRecttoLayer(CGRect r, CALayer l) {
        throw new RuntimeException();
    }

    @Export("convertTime:fromLayer:")
    public double convertTimefromLayer(double t, CALayer l) {
        throw new RuntimeException();
    }

    @Export("convertTime:toLayer:")
    public double convertTimetoLayer(double t, CALayer l) {
        throw new RuntimeException();
    }

    @Export("hitTest:")
    public CALayer hitTest(CGPoint p) {
        throw new RuntimeException();
    }

    @Export("containsPoint:")
    public boolean containsPoint(CGPoint p) {
        throw new RuntimeException();
    }

    @Export("contents")
    public NSObject contents() {
        throw new RuntimeException();
    }

    @Export("setContents")
    public void setContents(NSObject contents) {
        throw new RuntimeException();
    }

    @Export("contentsGravity")
    public NSString contentsGravity() {
        throw new RuntimeException();
    }

    @Export("contentsScale")
    public CGFloat contentsScale() {
        throw new RuntimeException();
    }

    @Export("minificationFilter")
    public NSString minificationFilter() {
        throw new RuntimeException();
    }

    @Export("magnificationFilter")
    public NSString magnificationFilter() {
        throw new RuntimeException();
    }

    @Export("isOpaque")
    public boolean opaque() {
        throw new RuntimeException();
    }

    @Export("display")
    public void display() {
        throw new RuntimeException();
    }

    @Export("setNeedsDisplay")
    public void setNeedsDisplay() {
        throw new RuntimeException();
    }

    @Export("setNeedsDisplayInRect:")
    public void setNeedsDisplayInRect(CGRect r) {
        throw new RuntimeException();
    }

    @Export("needsDisplay")
    public boolean needsDisplay() {
        throw new RuntimeException();
    }

    @Export("displayIfNeeded")
    public void displayIfNeeded() {
        throw new RuntimeException();
    }

    @Export("drawsAsynchronously")
    public boolean drawsAsynchronously() {
        throw new RuntimeException();
    }

    @Export("drawInContext:")
    public void drawInContext(CGContextRef ctx) {
        throw new RuntimeException();
    }

    @Export("renderInContext:")
    public void renderInContext(CGContextRef ctx) {
        throw new RuntimeException();
    }

    @Export("edgeAntialiasingMask")
    public int edgeAntialiasingMask() {
        throw new RuntimeException();
    }

    @Export("compositingFilter")
    public NSObject compositingFilter() {
        throw new RuntimeException();
    }

    @Export("filters")
    public NSArray filters() {
        throw new RuntimeException();
    }

    @Export("backgroundFilters")
    public NSArray backgroundFilters() {
        throw new RuntimeException();
    }

    @Export("shouldRasterize")
    public boolean shouldRasterize() {
        throw new RuntimeException();
    }

    @Export("rasterizationScale")
    public CGFloat rasterizationScale() {
        throw new RuntimeException();
    }

    @Export("shadowOffset")
    public CGSize shadowOffset() {
        throw new RuntimeException();
    }

    @Export("preferredFrameSize")
    public CGSize preferredFrameSize() {
        throw new RuntimeException();
    }

    @Export("setNeedsLayout")
    public void setNeedsLayout() {
        throw new RuntimeException();
    }

    @Export("needsLayout")
    public boolean needsLayout() {
        throw new RuntimeException();
    }

    @Export("layoutIfNeeded")
    public void layoutIfNeeded() {
        throw new RuntimeException();
    }

    @Export("layoutSublayers")
    public void layoutSublayers() {
        throw new RuntimeException();
    }

    @Export("actionForKey:")
    public CAAction actionForKey(String event) {
        throw new RuntimeException();
    }

    @Export("actions")
    public NSDictionary actions() {
        throw new RuntimeException();
    }

    @Export("addAnimation:forKey:")
    public void addAnimation(CAAnimation anim, String key) {
        throw new RuntimeException();
    }

    @Export("removeAllAnimations")
    public void removeAllAnimations() {
        throw new RuntimeException();
    }

    @Export("removeAnimationForKey:")
    public void removeAnimationForKey(String key) {
        throw new RuntimeException();
    }

    @Export("animationKeys")
    public NSArray animationKeys() {
        throw new RuntimeException();
    }

    @Export("animationForKey:")
    public CAAnimation animationForKey(String key) {
        throw new RuntimeException();
    }

    @Export("name")
    public NSString name() {
        throw new RuntimeException();
    }

    // Detected properties
    @Export("affineTransform")
    public CGAffineTransform getAffineTransform() {
        throw new RuntimeException();
    }

    @Export("setAffineTransform:")
    public void setAffineTransform(CGAffineTransform value) {
        throw new RuntimeException();
    }

    @Export("opacity")
    public float getOpacity() {
        throw new RuntimeException();
    }

    @Export("setOpacity")
    public void setOpacity(float opacity) {
        throw new RuntimeException();
    }

    @Export("setDelegate")
    public void setDelegate(NSObject layerDelegate) {
        throw new RuntimeException();
    }

    @Export("position")
    public CGPoint getPosition() {
        throw new RuntimeException();
    }

    @Export("setPosition")
    public void setPosition(CGPoint position) {
        throw new RuntimeException();
    }
}