package jos.build.types;

public enum Platform {
    IPHONE_OS ("iPhoneOS"),
    IPHONE_SIMULATOR ("iPhoneSimulator");

    private final String platform;

    private Platform(final String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }
}
