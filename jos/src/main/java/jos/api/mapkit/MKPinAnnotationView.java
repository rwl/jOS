package jos.api.mapkit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class MKPinAnnotationView extends MKAnnotationView {

    public MKPinAnnotationView(MKAnnotation annotation, String reuseIdentifier) {
        super(annotation, reuseIdentifier);
    }

    @Export("pinColor")
    public MKPinAnnotationColor getPinColor() {
        throw new RuntimeException();
    }

    @Export("setPinColor:")
    public void setPinColor(MKPinAnnotationColor value) {
        throw new RuntimeException();
    }

    @Export("animatesDrop")
    public boolean getAnimatesDrop() {
        throw new RuntimeException();
    }

    @Export("setAnimatesDrop:")
    public void setAnimatesDrop(boolean value) {
        throw new RuntimeException();
    }

}

