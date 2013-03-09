package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSSecureCoding.class})
@Register(isWrapper = true)
public class NSTimeZone extends NSObject {

    @Export("name")
    public String name() {
        throw new RuntimeException();
    }

    @Export("secondsFromGMTForDate:")
    public int secondsFromGMTForDate(NSDate aDate) {
        throw new RuntimeException();
    }

    @Export("abbreviationForDate:")
    public String abbreviationForDate(NSDate aDate) {
        throw new RuntimeException();
    }

    @Export("isDaylightSavingTimeForDate:")
    public boolean isDaylightSavingTimeForDate(NSDate aDate) {
        throw new RuntimeException();
    }

    @Export("daylightSavingTimeOffsetForDate:")
    public double daylightSavingTimeOffsetForDate(NSDate aDate) {
        throw new RuntimeException();
    }

    @Export("nextDaylightSavingTimeTransitionAfterDate:")
    public NSDate nextDaylightSavingTimeTransitionAfterDate(NSDate aDate) {
        throw new RuntimeException();
    }


    @Export("systemTimeZone")
    public static NSTimeZone systemTimeZone() {
        throw new RuntimeException();
    }

    @Export("localTimeZone")
    public static NSTimeZone localTimeZone() {
        throw new RuntimeException();
    }

    @Export("knownTimeZoneNames")
    public static NSArray knownTimeZoneNames() {
        throw new RuntimeException();
    }

    @Export("timeZoneDataVersion")
    public static String timeZoneDataVersion() {
        throw new RuntimeException();
    }

    @Export("secondsFromGMT")
    public int secondsFromGMT() {
        throw new RuntimeException();
    }

    @Export("abbreviation")
    public String abbreviation() {
        throw new RuntimeException();
    }

    @Export("isDaylightSavingTime")
    public boolean isDaylightSavingTime() {
        throw new RuntimeException();
    }

    @Export("daylightSavingTimeOffset")
    public double daylightSavingTimeOffset() {
        throw new RuntimeException();
    }

    @Export("nextDaylightSavingTimeTransition")
    public NSDate nextDaylightSavingTimeTransition() {
        throw new RuntimeException();
    }

    @Export("description")
    public String description() {
        throw new RuntimeException();
    }

    @Export("isEqualToTimeZone:")
    public boolean isEqualToTimeZone(NSTimeZone aTimeZone) {
        throw new RuntimeException();
    }

    @Export("localizedName:locale:")
    public String localizedNamelocale(NSTimeZoneNameStyle style, NSLocale locale) {
        throw new RuntimeException();
    }

    // Detected properties
    @Export("defaultTimeZone")
    public NSTimeZone getDefaultTimeZone() {
        throw new RuntimeException();
    }

    @Export("setDefaultTimeZone:")
    public void setDefaultTimeZone(NSTimeZone value) {
        throw new RuntimeException();
    }

    @Export("abbreviationDictionary")
    public NSDictionary getAbbreviationDictionary() {
        throw new RuntimeException();
    }

    @Export("setAbbreviationDictionary:")
    public void setAbbreviationDictionary(NSDictionary value) {
        throw new RuntimeException();
    }


    @Export("timeZoneWithName:")
    public static NSObject timeZoneWithName(String tzName) {
        throw new RuntimeException();
    }

    @Export("timeZoneWithName:data:")
    public static NSObject timeZoneWithNamedata(String tzName, NSData aData) {
        throw new RuntimeException();
    }

    @Export("initWithName:")
    public NSObject initWithName(String tzName) {
        throw new RuntimeException();
    }

    @Export("initWithName:data:")
    public NSObject initWithNamedata(String tzName, NSData aData) {
        throw new RuntimeException();
    }

    @Export("timeZoneForSecondsFromGMT:")
    public NSObject timeZoneForSecondsFromGMT(int seconds) {
        throw new RuntimeException();
    }

    @Export("timeZoneWithAbbreviation:")
    public static NSObject timeZoneWithAbbreviation(String abbreviation) {
        throw new RuntimeException();
    }
}