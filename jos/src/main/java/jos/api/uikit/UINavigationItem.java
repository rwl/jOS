package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

@Register(isWrapper = true)
public class UINavigationItem extends NSObject {

    public String title;

    @Export("title")
    public String getTitle() {
        return title;
    }

    @Export("setTitle:")
    public void setTitle(String title) {
        this.title = title;
    }

}
