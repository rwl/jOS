package jos.samples.animation.navigation;

import jos.api.uikit.UIViewController;

public class NavItem {

    /**
     * The name of the nav item, shows up as the label
     */
    private final String name;

    /**
     *  The UIViewController that the nav item opens. Use this property if you
     *  wanted to early instantiate the controller when the nav table is built out,
     *  otherwise just set the Type property and it will lazy-instantiate when the
     *  nav item is clicked on.
     */
    private UIViewController controller;

    /**
     * The Type of the UIViewController. Set this to the type and leave the Controller
     * property empty to lazy-instantiate the ViewController when the nav item is
     * clicked.
     */
    private final Class<? extends UIViewController> controllerType;

    public NavItem (String name, UIViewController controller) {
        this.name = name;
        this.controller = controller;
        this.controllerType = null;
    }

    public NavItem (String name, Class<? extends UIViewController> controllerType) {
        this.name = name;
        this.controller = null;
        this.controllerType = controllerType;
    }

    public UIViewController getController() {
        return controller;
    }

    public void setController(UIViewController controller) {
        this.controller = controller;
    }

    public String getName() {
        return name;
    }

    public Class<? extends UIViewController> getControllerType() {
        return controllerType;
    }

}
