package jos.dialog;

/**
 * Captures the information about mutually exclusive elements in a RootElement
 */
public class RadioGroup extends Group {
    int selected;

    public int getSelected() {
        return selected;
    }

    public void setSelected(int value) {
        selected = value;
    }

    public RadioGroup(String key, int selected) {
        super(key);
        this.selected = selected;
    }

    public RadioGroup(int selected) {
        super(null);
        this.selected = selected;
    }
}