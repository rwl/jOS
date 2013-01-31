package jos.build.types;

public enum Orientation {
    PORTRAIT ("UIInterfaceOrientationPortrait"),
    LANDSCAPE_LEFT ("UIInterfaceOrientationLandscapeLeft"),
    LANDSCAPE_RIGHT ("UIInterfaceOrientationLandscapeRight"),
    PORTRAIT_UPSIDE_DOWN ("UIInterfaceOrientationPortraitUpsideDown");

    private final String constant;

    private Orientation(final String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return this.constant;
    }
}
