package jos.api.mapkit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class MKCircleView extends MKOverlayPathView {

    @Export("initWithOverlay:")
    public MKCircleView(MKOverlay overlay) {
        super(overlay);
    }

    @Export("circle")
    public MKCircle getCircle() {
        throw new RuntimeException();
    }

    @Export("initWithCircle:")
    public MKCircleView(MKCircle circle) {
        super(null);
        throw new RuntimeException();
    }

}

