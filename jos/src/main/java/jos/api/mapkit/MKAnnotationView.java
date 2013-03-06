package jos.api.mapkit;

import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGPoint;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIView;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(UIView.class)
@Register(isWrapper = true)
public class MKAnnotationView extends UIView {

    @Export("reuseIdentifier")
    public String getReuseIdentifier() {
        throw new RuntimeException();
    }

    @Export("annotation")
    public MKAnnotation annotation() {
        throw new RuntimeException();
    }

    @Export("setAnnotation:")
    public void setAnnotation(MKAnnotation value) {
        throw new RuntimeException();
    }

    @Export("image")
    public UIImage getImage() {
        throw new RuntimeException();
    }

    @Export("setImage:")
    public void setImage(UIImage value) {
        throw new RuntimeException();
    }

    @Export("initWithAnnotation:reuseIdentifier:")
    public NSObject initWithAnnotationreuseIdentifier(MKAnnotation annotation, String reuseIdentifier) {
        throw new RuntimeException();
    }

    @Export("prepareForReuse")
    public void prepareForReuse() {
        throw new RuntimeException();
    }

    @Export("centerOffset")
    public CGPoint centerOffset() {
        throw new RuntimeException();
    }

    @Export("calloutOffset")
    public CGPoint calloutOffset() {
        throw new RuntimeException();
    }

    @Export("enabled")
    public boolean enabled() {
        throw new RuntimeException();
    }

    @Export("highlighted")
    public boolean highlighted() {
        throw new RuntimeException();
    }

    @Export("selected")
    public boolean selected() {
        throw new RuntimeException();
    }

    @Export("setSelected:animated:")
    public void setSelectedanimated(boolean selected, boolean animated) {
        throw new RuntimeException();
    }

    @Export("canShowCallout")
    public boolean canShowCallout() {
        throw new RuntimeException();
    }

    @Export("leftCalloutAccessoryView")
    public UIView leftCalloutAccessoryView() {
        throw new RuntimeException();
    }

    @Export("rightCalloutAccessoryView")
    public UIView rightCalloutAccessoryView() {
        throw new RuntimeException();
    }

    @Export("draggable")
    public boolean draggable() {
        throw new RuntimeException();
    }

    @Export("dragState")
    public MKAnnotationViewDragState dragState() {
        throw new RuntimeException();
    }

    @Export("setDragState:animated:")
    public void setDragStateanimated(MKAnnotationViewDragState newDragState, boolean animated) {
        throw new RuntimeException();
    }

}

