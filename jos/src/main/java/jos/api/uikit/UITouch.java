package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

@Register(isWrapper = true)
public class UITouch extends NSObject {

    public int tapCount;

    @Export("tapCount")
    public int getTapCount() {
        return tapCount;
    }

    @Export("setTapCount:")
    public void setTapCount(int tapCount) {
        this.tapCount = tapCount;
    }

}
