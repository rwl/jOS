package jos.dialog;

/**
 * Used by root elements to fetch information when they need to render a summary
 * (Checkbox count or selected radio group).
 */
public class Group {
    public String Key;

    public Group(String key) {
        Key = key;
    }
}