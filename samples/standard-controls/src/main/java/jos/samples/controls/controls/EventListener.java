package jos.samples.controls.controls;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Target;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIEvent;

@Target("onEvent:event:")
@Register(isWrapper = true)
public interface EventListener {

    @Export("onEvent:event:")
    public void onEvent(NSObject sender, UIEvent event);

}
