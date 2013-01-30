package jos.maven.types;

public enum Family {
    IPHONE (1, "iPhone"),
    IPAD (2, "iPad");

    private final int familyInt;

    private final String familyName;

    private Family(final int familyInt, final String familyName) {
        this.familyInt = familyInt;
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getFamilyInt() {
        return familyInt;
    }
}
