package jos.api.foundation;

import jos.api.graphicsimaging.CGContextRef;
import jos.api.quartz.CAAction;
import jos.api.quartz.CAAnimation;
import jos.api.quartz.CALayer;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@Register(isWrapper = true)
public class NSObject {

    @Export("init")
    public NSObject() {
    }

    public void invokeOnMainThread(NSAction delegate) {
    }


    @Export("load")
    public static void load() {
        throw new RuntimeException();
    }

    @Export("initialize")
    public static void initialize() {
        throw new RuntimeException();
    }

    @Export("init")
    public NSObject init() {
        throw new RuntimeException();
    }

    @Export("allocWithZone:")
    public static NSObject allocWithZone(NSZone zone) {
        throw new RuntimeException();
    }

    @Export("alloc")
    public static NSObject alloc() {
        throw new RuntimeException();
    }

    @Export("dealloc")
    public void dealloc() {
        throw new RuntimeException();
    }

    @Export("finalize")
    public void finalize() {
        throw new RuntimeException();
    }

    @Export("copy")
    public NSObject copy() {
        throw new RuntimeException();
    }

    @Export("mutableCopy")
    public NSObject mutableCopy() {
        throw new RuntimeException();
    }

    @Export("doesNotRecognizeSelector:")
    public void doesNotRecognizeSelector(Selector aSelector) {
        throw new RuntimeException();
    }

    @Export("forwardingTargetForSelector:")
    public NSObject forwardingTargetForSelector(Selector aSelector) {
        throw new RuntimeException();
    }

    @Export("resolveClassMethod:")
    public static boolean resolveClassMethod(Selector sel) {
        throw new RuntimeException();
    }

    @Export("resolveInstanceMethod:")
    public static boolean resolveInstanceMethod(Selector sel) {
        throw new RuntimeException();
    }


    @Export("performSelector:")
    public NSObject performSelector(Selector aSelector) {
        throw new RuntimeException();
    }

    @Export("performSelector:withObject:")
    public NSObject performSelectorwithObject(Selector aSelector, NSObject object) {
        throw new RuntimeException();
    }

    @Export("performSelector:withObject:withObject:")
    public NSObject performSelectorwithObjectwithObject(Selector aSelector, NSObject object1, NSObject object2) {
        throw new RuntimeException();
    }

    @Export("description")
    public String description() {
        throw new RuntimeException();
    }

    @Export("debugDescription")
    public String debugDescription() {
        throw new RuntimeException();
    }


    @Export("version")
    public static int version() {
        throw new RuntimeException();
    }

    @Export("replacementObjectForCoder:")
    public NSObject replacementObjectForCoder(NSCoder aCoder) {
        throw new RuntimeException();
    }


    @Export("didPresentErrorWithRecovery:contextInfo:")
    public void didPresentErrorWithRecoverycontextInfo(boolean didRecover, Object contextInfo) {
        throw new RuntimeException();
    }

    @Export("attemptRecoveryFromError:optionIndex:delegate:didRecoverSelector:contextInfo:")
    public void attemptRecoveryFromErroroptionIndexdelegatedidRecoverSelectorcontextInfo(NSError error, int recoveryOptionIndex, NSObject delegate, Selector didRecoverSelector, Object contextInfo) {
        throw new RuntimeException();
    }

    @Export("attemptRecoveryFromError:optionIndex:")
    public boolean attemptRecoveryFromErroroptionIndex(NSError error, int recoveryOptionIndex) {
        throw new RuntimeException();
    }


    @Export("displayLayer:")
    public void displayLayer(CALayer layer) {
        throw new RuntimeException();
    }

    @Export("drawLayer:inContext:")
    public void drawLayerinContext(CALayer layer, CGContextRef ctx) {
        throw new RuntimeException();
    }

    @Export("layoutSublayersOfLayer:")
    public void layoutSublayersOfLayer(CALayer layer) {
        throw new RuntimeException();
    }

    @Export("actionForLayer:forKey:")
    public CAAction actionForLayer(CALayer layer, String event) {
        throw new RuntimeException();
    }


    @Export("animationDidStart:")
    public void animationDidStart(CAAnimation anim) {
        throw new RuntimeException();
    }

    @Export("animationDidStop:finished:")
    public void animationDidStop(CAAnimation animation, boolean flag) {
        throw new RuntimeException();
    }
}
