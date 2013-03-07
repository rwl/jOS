package jos.samples.content.screens.iphone.maps;

import static jos.api.corelocation.CLLocation.makeLocationCoordinate2D;
import static jos.api.mapkit.MKGeometry.makeCoordinateSpan;
import static jos.api.mapkit.MKGeometry.makeCoordinateRegion;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;

import jos.api.corelocation.CLLocationCoordinate2D;
import jos.api.foundation.NSObject;
import jos.api.mapkit.MKAnnotation;
import jos.api.mapkit.MKAnnotationView;
import jos.api.mapkit.MKCoordinateSpan;
import jos.api.mapkit.MKMapView;
import jos.api.mapkit.MKMapViewDelegate;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIButtonType;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIViewController;
import jos.samples.content.EventListener;

public class AnnotatedMapScreen extends UIViewController {

    @Outlet
    MKMapView mapMain;

    public AnnotatedMapScreen() {
        super("AnnotatedMapScreen", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad ();

        setTitle("Highland Park, Los Angeles");

        // create our location and zoom for los angeles
        CLLocationCoordinate2D coords = makeLocationCoordinate2D(34.120, -118.188);
        MKCoordinateSpan span = makeCoordinateSpan(milesToLatitudeDegrees (20),
                milesToLongitudeDegrees(20, coords.latitude));

        // set the coords and zoom on the map
        mapMain.regionThatFits(makeCoordinateRegion(coords, span));

        // set our delegate. we don't actually need a delegate if we want to just drop a pin
        // on there, but if we want to specify anything custom, we do
        mapMain.setDelegate(new MapDelegate());

        // add a basic annotation
        mapMain.addAnnotation(new BasicMapAnnotation(makeLocationCoordinate2D(34.120, -118.188),
                "Los Angeles", "City of Demons"));

        // can use this as well.
//      mapMain.addAnnotationObject(
//          new BasicMapAnnotationProto() {
//              coordinate = new CLLocationCoordinate2D(34.120, -118.188),
//              title = "Los Angeles", Subtitle = "City of Demons"
//          }
//      );
    }

    // The map delegate is much like the table delegate.
    protected static class MapDelegate extends MKMapViewDelegate
    {
        protected String annotationIdentifier = "BasicAnnotation";
        UIButton detailButton; // need class-level ref to avoid GC

        /**
         * This is very much like the GetCell method on the table delegate
         */
        @Override
        public MKAnnotationView getViewForAnnotation(MKAnnotation annotation)
        {
            // try and dequeue the annotation view
            MKAnnotationView annotationView = mapView.dequeueReusableAnnotation(annotationIdentifier);

            // if we couldn't dequeue one, create a new one
            if (annotationView == null) {
                annotationView = new MKPinAnnotationView(annotation, annotationIdentifier);
            } else {  // if we did dequeue one for reuse, assign the annotation to it
                annotationView.Annotation = annotation;
            }

            // configure our annotation view properties
            annotationView.setCanShowCallout(true);
            ((MKPinAnnotationView) annotationView).setAnimatesDrop(true);
            ((MKPinAnnotationView) annotationView).setPinColor(MKPinAnnotationColor.GREEN);
            annotationView.setSelected(true);

            // you can add an accessory view, in this case, we'll add a button on the right, and an image on the left
            detailButton = UIButton.fromType(UIButtonType.DETAIL_DISCLOSURE);
            detailButton.addTarget(new EventListener() {
                @Override
                public void onEvent(NSObject sender, UIEvent event) {
                    Coordinate c = ((MKAnnotation) annotation).coordinate;
                    new UIAlertView("Annotation Clicked", "You clicked on "
                            + c.latitude.toString() + ", "
                            + c.longitude.toString() , null, "OK", null).show();
                }
            }, UIControlEvent.TOUCH_UP_INSIDE);
            annotationView.setRightCalloutAccessoryView(detailButton);
            annotationView.setLeftCalloutAccessoryView(new UIImageView(UIImage.fromBundle("Images/Icon/29_icon.png")));
            //annotationView.setImage(UIImage.fromBundle("Images/Apress-29x29.png"));

            return annotationView;
        }

        /**
         * as an optimization, you should override this method to add or remove annotations as the
         * map zooms in or out.
         */
        @Override
        public void regionChanged (MKMapView mapView, bool animated) {}

    }

    // This errors with unrecognized selector error.
    // TODO: is this fixed now??
    // TODO: yes, but the better question is, do we support opt-in selector
    // invoking for properties yet?
    protected static class BasicMapAnnotationProto extends NSObject
    {
        @Export("coordinate")
        public CLLocationCoordinate2D getCoordinate ()
        {
            return coordinate;
        }

        @Export ("title")
        public String getTitle ()
        {
            return title;
            }

        @Export ("subtitle")
        public String getSubtitle ()
        { return subtitle; }

    }

    // MonoTouch doesn't provide even a basic map annotation base class, so this can
    // serve as one.
    protected class BasicMapAnnotation extends MKAnnotation
    {
        /**
         * The location of the annotation
         */
        @Override
        public CLLocationCoordinate2D getCoordinate() {
            return coordinate;
        }

        /**
         * The title text
         */
        @Override
        public String getTitle()
        { return title; }
        protected String title;

        /**
         * The subtitle text
         */
        @Override
        public String getSubtitle()
        { return subtitle; }
        protected String subtitle;

        public BasicMapAnnotation(CLLocationCoordinate2D coordinate, String title, String subTitle)
        {
            super();
            this.coordinate = coordinate;
            this.title = title;
            this.subtitle = subTitle;
        }

    }

    /**
     * Converts miles to latitude degrees
     */
    public double milesToLatitudeDegrees(double miles)
    {
        double earthRadius = 3960.0;
        double radiansToDegrees = 180.0/Math.PI;
        return (miles/earthRadius) * radiansToDegrees;
    }

    /**
     * Converts miles to longitudinal degrees at a specified latitude
     */
    public double milesToLongitudeDegrees(double miles, double atLatitude)
    {
        double earthRadius = 3960.0;
        double degreesToRadians = Math.PI/180.0;
        double radiansToDegrees = 180.0/Math.PI;

        // derive the earth's radius at that point in latitude
        double radiusAtLatitude = earthRadius * Math.cos(atLatitude * degreesToRadians);
        return (miles / radiusAtLatitude) * radiansToDegrees;
    }

}
