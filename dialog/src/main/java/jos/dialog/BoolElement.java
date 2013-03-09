package jos.dialog;

public abstract class BoolElement extends Element {

    boolean val;

    public boolean getValue() {
        return val;
    }

    public void setValue(boolean value) {
        boolean emit = val != value;
        val = value;
        if (emit && ValueChanged != null)
            ValueChanged.onEvent(this, null);
    }

    public EventListener ValueChanged;

    public BoolElement(String caption, boolean value) {
        super(caption);
        val = value;
    }

    @Override
    public String Summary() {
        return val ? "On" : "Off";
    }

}
