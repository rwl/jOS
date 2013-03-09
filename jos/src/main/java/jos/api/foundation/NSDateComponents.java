package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSSecureCoding.class})
@Register(isWrapper = true)
public class NSDateComponents extends NSObject {

    @Export("setTimeZone:")
    public void setTimeZone(NSTimeZone tz) {
        throw new RuntimeException();
    }

    @Export("date")
    public NSDate date() {
        throw new RuntimeException();
    }

    // Detected properties
    @Export("calendar")
    public NSCalendar getCalendar() {
        throw new RuntimeException();
    }

    @Export("setCalendar:")
    public void setCalendar(NSCalendar value) {
        throw new RuntimeException();
    }

    @Export("era")
    public int getEra() {
        throw new RuntimeException();
    }

    @Export("setEra:")
    public void setEra(int value) {
        throw new RuntimeException();
    }

    @Export("year")
    public int getYear() {
        throw new RuntimeException();
    }

    @Export("setYear:")
    public void setYear(int value) {
        throw new RuntimeException();
    }

    @Export("month")
    public int getMonth() {
        throw new RuntimeException();
    }

    @Export("setMonth:")
    public void setMonth(int value) {
        throw new RuntimeException();
    }

    @Export("day")
    public int getDay() {
        throw new RuntimeException();
    }

    @Export("setDay:")
    public void setDay(int value) {
        throw new RuntimeException();
    }

    @Export("hour")
    public int getHour() {
        throw new RuntimeException();
    }

    @Export("setHour:")
    public void setHour(int value) {
        throw new RuntimeException();
    }

    @Export("minute")
    public int getMinute() {
        throw new RuntimeException();
    }

    @Export("setMinute:")
    public void setMinute(int value) {
        throw new RuntimeException();
    }

    @Export("second")
    public int getSecond() {
        throw new RuntimeException();
    }

    @Export("setSecond:")
    public void setSecond(int value) {
        throw new RuntimeException();
    }

    @Export("week")
    public int getWeek() {
        throw new RuntimeException();
    }

    @Export("setWeek:")
    public void setWeek(int value) {
        throw new RuntimeException();
    }

    @Export("weekday")
    public int getWeekday() {
        throw new RuntimeException();
    }

    @Export("setWeekday:")
    public void setWeekday(int value) {
        throw new RuntimeException();
    }

    @Export("weekdayOrdinal")
    public int getWeekdayOrdinal() {
        throw new RuntimeException();
    }

    @Export("setWeekdayOrdinal:")
    public void setWeekdayOrdinal(int value) {
        throw new RuntimeException();
    }

    @Export("quarter")
    public int getQuarter() {
        throw new RuntimeException();
    }

    @Export("setQuarter:")
    public void setQuarter(int value) {
        throw new RuntimeException();
    }

    @Export("weekOfMonth")
    public int getWeekOfMonth() {
        throw new RuntimeException();
    }

    @Export("setWeekOfMonth:")
    public void setWeekOfMonth(int value) {
        throw new RuntimeException();
    }

    @Export("weekOfYear")
    public int getWeekOfYear() {
        throw new RuntimeException();
    }

    @Export("setWeekOfYear:")
    public void setWeekOfYear(int value) {
        throw new RuntimeException();
    }

    @Export("yearForWeekOfYear")
    public int getYearForWeekOfYear() {
        throw new RuntimeException();
    }

    @Export("setYearForWeekOfYear:")
    public void setYearForWeekOfYear(int value) {
        throw new RuntimeException();
    }

    @Bind("isLeapMonth")
    @Export("leapMonth")
    public boolean getLeapMonth() {
        throw new RuntimeException();
    }

    @Export("setLeapMonth:")
    public void setLeapMonth(boolean value) {
        throw new RuntimeException();
    }

}