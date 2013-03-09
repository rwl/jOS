package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSSecureCoding.class})
@Register(isWrapper = true)
public class NSCalendar extends NSObject {

    @Export("currentCalendar")
    public static NSObject currentCalendar() {
        throw new RuntimeException();
    }

    @Export("initWithCalendarIdentifier:")
    public NSObject initWithCalendarIdentifier(String ident) {
        throw new RuntimeException();
    }

    @Export("calendarIdentifier")
    public String calendarIdentifier() {
        throw new RuntimeException();
    }

    @Export("minimumRangeOfUnit:")
    public NSRange minimumRangeOfUnit(NSCalendarUnit unit) {
        throw new RuntimeException();
    }

    @Export("maximumRangeOfUnit:")
    public NSRange maximumRangeOfUnit(NSCalendarUnit unit) {
        throw new RuntimeException();
    }

    @Export("rangeOfUnit:inUnit:forDate:")
    public NSRange rangeOfUnitinUnitforDate(NSCalendarUnit smaller, NSCalendarUnit larger, NSDate date) {
        throw new RuntimeException();
    }

    @Export("ordinalityOfUnit:inUnit:forDate:")
    public int ordinalityOfUnitinUnitforDate(NSCalendarUnit smaller, NSCalendarUnit larger, NSDate date) {
        throw new RuntimeException();
    }

    @Export("rangeOfUnit:startDate:interval:forDate:")
    public boolean rangeOfUnitstartDateintervalforDate(NSCalendarUnit unit, NSDate datep, double tip, NSDate date) {
        throw new RuntimeException();
    }

    @Export("dateFromComponents:")
    public NSDate dateFromComponents(NSDateComponents comps) {
        throw new RuntimeException();
    }

    @Export("components:fromDate:")
    public NSDateComponents componentsfromDate(int unitFlags, NSDate date) {
        throw new RuntimeException();
    }

    @Export("dateByAddingComponents:toDate:options:")
    public NSDate dateByAddingComponentstoDateoptions(NSDateComponents comps, NSDate date, int opts) {
        throw new RuntimeException();
    }

    @Export("components:fromDate:toDate:options:")
    public NSDateComponents componentsfromDatetoDateoptions(int unitFlags, NSDate startingDate, NSDate resultDate, int opts) {
        throw new RuntimeException();
    }

    // Detected properties
    @Export("locale")
    public NSLocale getLocale() {
        throw new RuntimeException();
    }

    @Export("setLocale:")
    public void setLocale(NSLocale value) {
        throw new RuntimeException();
    }

    @Export("timeZone")
    public NSTimeZone getTimeZone() {
        throw new RuntimeException();
    }

    @Export("setTimeZone:")
    public void setTimeZone(NSTimeZone value) {
        throw new RuntimeException();
    }

    @Export("firstWeekday")
    public int getFirstWeekday() {
        throw new RuntimeException();
    }

    @Export("setFirstWeekday:")
    public void setFirstWeekday(int value) {
        throw new RuntimeException();
    }

    @Export("minimumDaysInFirstWeek")
    public int getMinimumDaysInFirstWeek() {
        throw new RuntimeException();
    }

    @Export("setMinimumDaysInFirstWeek:")
    public void setMinimumDaysInFirstWeek(int value) {
        throw new RuntimeException();
    }

}