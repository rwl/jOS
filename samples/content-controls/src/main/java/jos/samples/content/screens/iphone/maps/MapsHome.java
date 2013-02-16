package jos.samples.content.screens.iphone.maps;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIViewController;
import jos.samples.content.EventListener;

public class MapsHome extends UIViewController {

    @Outlet
    UIButton btnBasicMap;

    @Outlet
    UIButton btnMapWithOverlay;

    @Outlet
    UIButton btnMapWithAnnotations;

    BasicMapScreen basicMaps = null;
    AnnotatedMapScreen mapWithAnnotations = null;
    MapWithOverlayScreen mapWithOverlay = null;

    public MapsHome() {
        super("MapsHome", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad ();

        setTitle("Maps");

        btnBasicMap.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                if(basicMaps == null) {
                    basicMaps = new BasicMapScreen();
                }
                getNavigationController().pushViewController(basicMaps, true);
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);

        btnMapWithAnnotations.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                if(mapWithAnnotations == null) {
                    mapWithAnnotations = new AnnotatedMapScreen();
                }
                getNavigationController().pushViewController(mapWithAnnotations, true);
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);

        btnMapWithOverlay.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                if(mapWithOverlay == null) {
                    mapWithOverlay = new MapWithOverlayScreen();
                }
                getNavigationController().pushViewController(mapWithOverlay, true);
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
    }

}
