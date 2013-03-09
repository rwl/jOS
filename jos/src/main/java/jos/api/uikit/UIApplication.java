package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSUrl;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@BaseType(UIActionSheetDelegate.class)
@Register(isWrapper = true)
public class UIApplication extends UIResponder {

    @Export("main:principalClassName:delegateClassName:")
    public static void main(String[] args, String principalClassName, String delegateClassName) {
    }


    @Export("delegate")
    public UIApplicationDelegate getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(UIApplicationDelegate value) {
        throw new RuntimeException();
    }

    @Bind("isIdleTimerDisabled")
    @Export("idleTimerDisabled")
    public boolean getIdleTimerDisabled() {
        throw new RuntimeException();
    }

    @Export("setIdleTimerDisabled:")
    public void setIdleTimerDisabled(boolean value) {
        throw new RuntimeException();
    }

    @Export("keyWindow")
    public UIWindow getKeyWindow() {
        throw new RuntimeException();
    }

    @Export("windows")
    public NSArray getWindows() {
        throw new RuntimeException();
    }

    @Bind("isNetworkActivityIndicatorVisible")
    @Export("networkActivityIndicatorVisible")
    public boolean getNetworkActivityIndicatorVisible() {
        throw new RuntimeException();
    }

    @Export("setNetworkActivityIndicatorVisible:")
    public void setNetworkActivityIndicatorVisible(boolean value) {
        throw new RuntimeException();
    }

    @Export("statusBarStyle")
    public UIStatusBarStyle getStatusBarStyle() {
        throw new RuntimeException();
    }

    @Export("setStatusBarStyle:")
    public void setStatusBarStyle(UIStatusBarStyle value) {
        throw new RuntimeException();
    }

    @Bind("isStatusBarHidden")
    @Export("statusBarHidden")
    public boolean getStatusBarHidden() {
        throw new RuntimeException();
    }

    @Export("setStatusBarHidden:")
    public void setStatusBarHidden(boolean value) {
        throw new RuntimeException();
    }

    @Export("statusBarOrientationAnimationDuration")
    public double getStatusBarOrientationAnimationDuration() {
        throw new RuntimeException();
    }

    @Export("statusBarFrame")
    public CGRect getStatusBarFrame() {
        throw new RuntimeException();
    }

    @Export("applicationIconBadgeNumber")
    public int getApplicationIconBadgeNumber() {
        throw new RuntimeException();
    }

    @Export("setApplicationIconBadgeNumber:")
    public void setApplicationIconBadgeNumber(int value) {
        throw new RuntimeException();
    }

    @Export("applicationSupportsShakeToEdit")
    public boolean getApplicationSupportsShakeToEdit() {
        throw new RuntimeException();
    }

    @Export("setApplicationSupportsShakeToEdit:")
    public void setApplicationSupportsShakeToEdit(boolean value) {
        throw new RuntimeException();
    }

    @Export("applicationState")
    public UIApplicationState getApplicationState() {
        throw new RuntimeException();
    }

    @Export("backgroundTimeRemaining")
    public double getBackgroundTimeRemaining() {
        throw new RuntimeException();
    }

    @Bind("isProtectedDataAvailable")
    @Export("protectedDataAvailable")
    public boolean getProtectedDataAvailable() {
        throw new RuntimeException();
    }

    @Export("userInterfaceLayoutDirection")
    public UIUserInterfaceLayoutDirection getUserInterfaceLayoutDirection() {
        throw new RuntimeException();
    }

    @Export("sharedApplication")
    public static UIApplication getSharedApplication() {
        throw new RuntimeException();
    }

    @Export("beginIgnoringInteractionEvents")
    public void beginIgnoringInteractionEvents() {
        throw new RuntimeException();
    }

    @Export("endIgnoringInteractionEvents")
    public void endIgnoringInteractionEvents() {
        throw new RuntimeException();
    }

    @Export("isIgnoringInteractionEvents")
    public boolean isIgnoringInteractionEvents() {
        throw new RuntimeException();
    }

    @Export("openURL:")
    public boolean openURL(NSUrl url) {
        throw new RuntimeException();
    }

    @Export("canOpenURL:")
    public boolean canOpenURL(NSUrl url) {
        throw new RuntimeException();
    }

    @Export("sendEvent:")
    public void sendEvent(UIEvent event) {
        throw new RuntimeException();
    }

    @Export("sendAction:to:from:forEvent:")
    public boolean sendActiontofromforEvent(Selector action, NSObject target, NSObject sender, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("setStatusBarStyle:animated:")
    public void setStatusBarStyleanimated(UIStatusBarStyle statusBarStyle, boolean animated) {
        throw new RuntimeException();
    }

    @Export("setStatusBarHidden:withAnimation:")
    public void setStatusBarHiddenwithAnimation(boolean hidden, UIStatusBarAnimation animation) {
        throw new RuntimeException();
    }

    @Export("statusBarOrientation")
    public UIInterfaceOrientation statusBarOrientation() {
        throw new RuntimeException();
    }

    @Export("setStatusBarOrientation:animated:")
    public void setStatusBarOrientationanimated(UIInterfaceOrientation interfaceOrientation, boolean animated) {
        throw new RuntimeException();
    }

    @Export("supportedInterfaceOrientationsForWindow:")
    public int supportedInterfaceOrientationsForWindow(UIWindow window) {
        throw new RuntimeException();
    }

    @Export("endBackgroundTask:")
    public void endBackgroundTask(int identifier) {
        throw new RuntimeException();
    }

    @Export("clearKeepAliveTimeout")
    public void clearKeepAliveTimeout() {
        throw new RuntimeException();
    }


    @Export("registerForRemoteNotificationTypes:")
    public void registerForRemoteNotificationTypes(UIRemoteNotificationType types) {
        throw new RuntimeException();
    }

    @Export("enabledRemoteNotificationTypes")
    public UIRemoteNotificationType enabledRemoteNotificationTypes() {
        throw new RuntimeException();
    }

    @Export("scheduledLocalNotifications")
    public NSArray getScheduledLocalNotifications() {
        throw new RuntimeException();
    }

    @Export("setScheduledLocalNotifications:")
    public void setScheduledLocalNotifications(NSArray value) {
        throw new RuntimeException();
    }

    @Export("presentLocalNotificationNow:")
    public void presentLocalNotificationNow(UILocalNotification notification) {
        throw new RuntimeException();
    }

    @Export("scheduleLocalNotification:")
    public void scheduleLocalNotification(UILocalNotification notification) {
        throw new RuntimeException();
    }

    @Export("cancelLocalNotification:")
    public void cancelLocalNotification(UILocalNotification notification) {
        throw new RuntimeException();
    }

    @Export("cancelAllLocalNotifications")
    public void cancelAllLocalNotifications() {
        throw new RuntimeException();
    }


    @Export("beginReceivingRemoteControlEvents")
    public void beginReceivingRemoteControlEvents() {
        throw new RuntimeException();
    }


    @Export("extendStateRestoration")
    public void extendStateRestoration() {
        throw new RuntimeException();
    }

    @Export("completeStateRestoration")
    public void completeStateRestoration() {
        throw new RuntimeException();
    }
}
