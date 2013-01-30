package jos.maven.types;

public enum StatusBarStyle {
    DEFAULT ("UIStatusBarStyleDefault"),
    BLACK_TRANSLUCENT ("UIStatusBarStyleBlackTranslucent"),
    BLACK_OPAQUE ("UIStatusBarStyleBlackOpaque");

    private final String constant;

    private StatusBarStyle(final String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
