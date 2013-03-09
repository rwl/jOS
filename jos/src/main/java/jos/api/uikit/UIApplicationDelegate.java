package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSCoder;
import jos.api.foundation.NSData;
import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSError;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSUrl;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Abstract;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UIApplicationDelegate extends NSObject {

    public UIWindow window;

    @Abstract
    @Export("window")
    public UIWindow getWindow() {
        return window;
    }

    @Export("setWindow:")
    public void setWindow(UIWindow window) {
        this.window = window;
    }

    @Export("init")
    public UIApplicationDelegate() {
    }

    @Export("application:didFinishLaunchingWithOptions:")
    public boolean finishedLaunching(UIApplication application, NSDictionary launchOptions) {
        return false;
    }

    @Export("applicationWillResignActive:")
    public void onResignActivation(UIApplication application) {
    }

    @Export("applicationDidEnterBackground:")
    public void didEnterBackground(UIApplication application) {
    }

    @Export("applicationWillEnterForeground:")
    public void willEnterForeground(UIApplication application) {
    }

    @Export("applicationWillTerminate:")
    public void willTerminate(UIApplication application) {
    }


    @Export("applicationDidFinishLaunching:")
    public void applicationDidFinishLaunching(UIApplication application) {
        throw new RuntimeException();
    }

    @Export("application:willFinishLaunchingWithOptions:")
    public boolean applicationwillFinishLaunchingWithOptions(UIApplication application, NSDictionary launchOptions) {
        throw new RuntimeException();
    }

    @Export("application:didFinishLaunchingWithOptions:")
    public boolean applicationdidFinishLaunchingWithOptions(UIApplication application, NSDictionary launchOptions) {
        throw new RuntimeException();
    }

    @Export("applicationDidBecomeActive:")
    public void applicationDidBecomeActive(UIApplication application) {
        throw new RuntimeException();
    }

    @Export("applicationWillResignActive:")
    public void applicationWillResignActive(UIApplication application) {
        throw new RuntimeException();
    }

    @Export("application:handleOpenURL:")
    public boolean applicationhandleOpenURL(UIApplication application, NSUrl url) {
        throw new RuntimeException();
    }

    @Export("application:openURL:sourceApplication:annotation:")
    public boolean applicationopenURLsourceApplicationannotation(UIApplication application, NSUrl url, String sourceApplication, NSObject annotation) {
        throw new RuntimeException();
    }

    @Export("applicationDidReceiveMemoryWarning:")
    public void applicationDidReceiveMemoryWarning(UIApplication application) {
        throw new RuntimeException();
    }

    @Export("applicationWillTerminate:")
    public void applicationWillTerminate(UIApplication application) {
        throw new RuntimeException();
    }

    @Export("applicationSignificantTimeChange:")
    public void applicationSignificantTimeChange(UIApplication application) {
        throw new RuntimeException();
    }

    @Export("application:willChangeStatusBarOrientation:duration:")
    public void applicationwillChangeStatusBarOrientationduration(UIApplication application, UIInterfaceOrientation newStatusBarOrientation, double duration) {
        throw new RuntimeException();
    }

    @Export("application:didChangeStatusBarOrientation:")
    public void applicationdidChangeStatusBarOrientation(UIApplication application, UIInterfaceOrientation oldStatusBarOrientation) {
        throw new RuntimeException();
    }

    @Export("application:willChangeStatusBarFrame:")
    public void applicationwillChangeStatusBarFrame(UIApplication application, CGRect newStatusBarFrame) {
        throw new RuntimeException();
    }

    @Export("application:didChangeStatusBarFrame:")
    public void applicationdidChangeStatusBarFrame(UIApplication application, CGRect oldStatusBarFrame) {
        throw new RuntimeException();
    }

    @Export("application:didRegisterForRemoteNotificationsWithDeviceToken:")
    public void applicationdidRegisterForRemoteNotificationsWithDeviceToken(UIApplication application, NSData deviceToken) {
        throw new RuntimeException();
    }

    @Export("application:didFailToRegisterForRemoteNotificationsWithError:")
    public void applicationdidFailToRegisterForRemoteNotificationsWithError(UIApplication application, NSError error) {
        throw new RuntimeException();
    }

    @Export("application:didReceiveRemoteNotification:")
    public void applicationdidReceiveRemoteNotification(UIApplication application, NSDictionary userInfo) {
        throw new RuntimeException();
    }

    @Export("application:didReceiveLocalNotification:")
    public void applicationdidReceiveLocalNotification(UIApplication application, UILocalNotification notification) {
        throw new RuntimeException();
    }

    @Export("applicationDidEnterBackground:")
    public void applicationDidEnterBackground(UIApplication application) {
        throw new RuntimeException();
    }

    @Export("applicationWillEnterForeground:")
    public void applicationWillEnterForeground(UIApplication application) {
        throw new RuntimeException();
    }

    @Export("applicationProtectedDataWillBecomeUnavailable:")
    public void applicationProtectedDataWillBecomeUnavailable(UIApplication application) {
        throw new RuntimeException();
    }

    @Export("applicationProtectedDataDidBecomeAvailable:")
    public void applicationProtectedDataDidBecomeAvailable(UIApplication application) {
        throw new RuntimeException();
    }

    @Export("application:supportedInterfaceOrientationsForWindow:")
    public int applicationsupportedInterfaceOrientationsForWindow(UIApplication application, UIWindow window) {
        throw new RuntimeException();
    }

    @Export("application:viewControllerWithRestorationIdentifierPath:coder:")
    public UIViewController applicationviewControllerWithRestorationIdentifierPathcoder(UIApplication application, NSArray identifierComponents, NSCoder coder) {
        throw new RuntimeException();
    }

    @Export("application:shouldSaveApplicationState:")
    public boolean applicationshouldSaveApplicationState(UIApplication application, NSCoder coder) {
        throw new RuntimeException();
    }

    @Export("application:shouldRestoreApplicationState:")
    public boolean applicationshouldRestoreApplicationState(UIApplication application, NSCoder coder) {
        throw new RuntimeException();
    }

    @Export("application:willEncodeRestorableStateWithCoder:")
    public void applicationwillEncodeRestorableStateWithCoder(UIApplication application, NSCoder coder) {
        throw new RuntimeException();
    }

    @Export("application:didDecodeRestorableStateWithCoder:")
    public void applicationdidDecodeRestorableStateWithCoder(UIApplication application, NSCoder coder) {
        throw new RuntimeException();
    }
}
