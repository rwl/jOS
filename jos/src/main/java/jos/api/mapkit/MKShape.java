package jos.api.mapkit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class MKShape extends MKAnnotation {

    @Export("title")
    public String getTitle() {
        throw new RuntimeException();
    }

    @Export("setTitle:")
    public void setTitle(String value) {
        throw new RuntimeException();
    }

    @Export("subtitle")
    public String getSubtitle() {
        throw new RuntimeException();
    }

    @Export("setSubtitle:")
    public void setSubtitle(String value) {
        throw new RuntimeException();
    }

}

