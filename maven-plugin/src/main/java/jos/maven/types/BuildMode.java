package jos.maven.types;

public enum BuildMode {
    DEVELOPMENT ("Development"),
    RELEASE ("Release"),
    DISTRIBUTION ("Distribution");
    
    private final String modeName;
    
    private BuildMode(final String modeName) {
    	this.modeName = modeName;
    }
    
    public String getModeName() {
    	return modeName;
    }
}
