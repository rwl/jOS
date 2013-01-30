package jos.maven.types;

public enum BackgroundMode {
    AUDIO ("audio"),
    LOCATION ("location"),
    VOIP ("voip"),
    NEWSSTAND_CONTENT ("newsstand-content"),
    EXTERNAL_ACCESSORY ("external-accessory"),
    BLUETOOTH_CENTRAL ("bluetooth-central");

    private final String modeName;

    private BackgroundMode(final String modeName) {
        this.modeName = modeName;
    }

    public String getModeName() {
        return modeName;
    }
}
