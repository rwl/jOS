package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSObject;

@Model
@Register(isWrapper = true)
public class UIApplicationDelegate extends NSObject {

    public UIWindow window;

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

    /**
     * Sent when the application is about to move from active to inactive state.
     * This can occur for certain types of temporary interruptions (such as an
     * incoming phone call or SMS message) or when the user quits the
     * application and it begins the transition to the background state.
     *
     * Use this method to pause ongoing tasks, disable timers, and throttle down
     * OpenGL ES frame rates. Games should use this method to pause the game.
     */
    @Export("applicationWillResignActive:")
    public void onResignActivation(UIApplication application) {
    }

    /**
     * Use this method to release shared resources, save user data, invalidate
     * timers, and store enough application state information to restore your
     * application to its current state in case it is terminated later.
     *
     * If your application supports background execution, this method is called
     * instead of applicationWillTerminate when the user quits.
     */
    @Export("applicationDidEnterBackground:")
    public void didEnterBackground(UIApplication application) {
    }

    /**
     * Called as part of the transition from the background to the inactive
     * state; here you can undo many of the changes made on entering the
     * background.
     */
    @Export("applicationWillEnterForeground:")
    public void willEnterForeground(UIApplication application) {
    }

    /**
     * Called when the application is about to terminate. Save data if
     * appropriate.
     *
     * @see applicationDidEnterBackground
     */
    @Export("applicationWillTerminate:")
    public void willTerminate(UIApplication application) {
    }

}
