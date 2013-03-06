package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UITextRange {

    @Bind("isEmpty")
    @Export("empty")
    public boolean getEmpty() {
        throw new RuntimeException();
    }

    @Export("end")
    public UITextPosition getEnd() {
        throw new RuntimeException();
    }

}