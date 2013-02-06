package jos.samples.controls.navigation;

import jos.api.uikit.UIViewController;

public class NavItem {

    /**
     * The name of the nav item, shows up as the label
     */
    public String name;

    /**
     *  The UIViewController that the nav item opens. Use this property if you
     *  wanted to early instantiate the controller when the nav table is built out,
     *  otherwise just set the Type property and it will lazy-instantiate when the
     *  nav item is clicked on.
     */
    public UIViewController controller;

    /**
     * Path to the image to show in the nav item
     */
    public String imagePath;

    /**
     * The Type of the UIViewController. Set this to the type and leave the Controller
     * property empty to lazy-instantiate the ViewController when the nav item is
     * clicked.
     */
    public Class<? extends UIViewController> controllerType;

    /**
     * A list of the constructor args (if neccesary) for the controller. use this in
     * conjunction with ControllerType if lazy-creating controllers.
     */
    private Object[] controllerConstructorArgs;

    public Object[] getControllerConstructorArgs() {
        return controllerConstructorArgs;
    }

    public void setControllerConstructorArgs(Object[] value) {
        controllerConstructorArgs = value;

        controllerConstructorTypes = new Class[controllerConstructorArgs.length];
        for (int i = 0; i < controllerConstructorArgs.length; i++) {
            controllerConstructorTypes[i] = (Class<? extends UIViewController>) controllerConstructorArgs[i].getClass();
        }
    }

    /**
     * The types of constructor args.
     */
    public Class<? extends UIViewController>[] controllerConstructorTypes;

    public NavItem () {
    }

    public NavItem (String name) {
        this();
        this.name = name;
    }

    public NavItem (String name, UIViewController controller) {
        this(name);
        this.controller = controller;
    }

    public NavItem (String name, Class<? extends UIViewController> controllerType) {
        this(name);
        this.controllerType = controllerType;
    }

    public NavItem (String name, Class<? extends UIViewController> controllerType, Object[] controllerConstructorArgs) {
        this(name, controllerType);
        setControllerConstructorArgs(controllerConstructorArgs);
    }

    public NavItem (String name, UIViewController controller, String imagePath) {
        this(name, controller);
        this.imagePath = imagePath;
    }

    public NavItem (String name, String imagePath, Class<? extends UIViewController> controllerType) {
        this(name, controllerType);
        this.imagePath = imagePath;
    }

    public NavItem (String name, String imagePath, Class<? extends UIViewController> controllerType, Object[] controllerConstructorArgs) {
        this(name, controllerType, controllerConstructorArgs);
        this.imagePath = imagePath;
    }
}
