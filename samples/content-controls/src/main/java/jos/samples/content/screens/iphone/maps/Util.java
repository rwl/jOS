package jos.samples.content.screens.iphone.maps;

public class Util {

    private Util() {
    }

    /**
     * Converts miles to latitude degrees
     */
    public static double milesToLatitudeDegrees(double miles) {
        double earthRadius = 3960.0;
        double radiansToDegrees = 180.0/Math.PI;
        return (miles/earthRadius) * radiansToDegrees;
    }

    /**
     * Converts miles to longitudinal degrees at a specified latitude
     */
    public static double milesToLongitudeDegrees(double miles, double atLatitude) {
        double earthRadius = 3960.0;
        double degreesToRadians = Math.PI/180.0;
        double radiansToDegrees = 180.0/Math.PI;

        // derive the earth's radius at that point in latitude
        double radiusAtLatitude = earthRadius * Math.cos(atLatitude * degreesToRadians);
        return (miles / radiusAtLatitude) * radiansToDegrees;
    }
}
