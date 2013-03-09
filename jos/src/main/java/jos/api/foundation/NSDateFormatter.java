package jos.api.foundation;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class NSDateFormatter extends NSFormatter {

    @Export("init")
    public NSDateFormatter() {
        throw new RuntimeException();
    }

    @Export("stringFromDate:")
    public String stringFromDate(NSDate date) {
        throw new RuntimeException();
    }

    @Export("dateFromString:")
    public NSDate dateFromString(String string) {
        throw new RuntimeException();
    }

    @Export("localizedStringFromDate:dateStyle:timeStyle:")
    public static String localizedStringFromDatedateStyletimeStyle(NSDate date, NSDateFormatterStyle dstyle, NSDateFormatterStyle tstyle) {
        throw new RuntimeException();
    }

    @Export("dateFormatFromTemplate:options:locale:")
    public static String dateFormatFromTemplateoptionslocale(String tmplate, int opts, NSLocale locale) {
        throw new RuntimeException();
    }

    @Export("AMSymbol")
    public String AMSymbol() {
        throw new RuntimeException();
    }

    @Export("setAMSymbol:")
    public void setAMSymbol(String string) {
        throw new RuntimeException();
    }

    @Export("PMSymbol")
    public String PMSymbol() {
        throw new RuntimeException();
    }

    @Export("setPMSymbol:")
    public void setPMSymbol(String string) {
        throw new RuntimeException();
    }

    // Detected properties
    @Export("dateStyle")
    public NSDateFormatterStyle getDateStyle() {
        throw new RuntimeException();
    }

    @Export("setDateStyle:")
    public void setDateStyle(NSDateFormatterStyle value) {
        throw new RuntimeException();
    }

    @Export("timeStyle")
    public NSDateFormatterStyle getTimeStyle() {
        throw new RuntimeException();
    }

    @Export("setTimeStyle:")
    public void setTimeStyle(NSDateFormatterStyle value) {
        throw new RuntimeException();
    }

    @Export("locale")
    public NSLocale getLocale() {
        throw new RuntimeException();
    }

    @Export("setLocale:")
    public void setLocale(NSLocale value) {
        throw new RuntimeException();
    }

    @Export("generatesCalendarDates")
    public boolean getGeneratesCalendarDates() {
        throw new RuntimeException();
    }

    @Export("setGeneratesCalendarDates:")
    public void setGeneratesCalendarDates(boolean value) {
        throw new RuntimeException();
    }

    @Export("formatterBehavior")
    public NSDateFormatterBehavior getFormatterBehavior() {
        throw new RuntimeException();
    }

    @Export("setFormatterBehavior:")
    public void setFormatterBehavior(NSDateFormatterBehavior value) {
        throw new RuntimeException();
    }

    @Export("defaultFormatterBehavior")
    public NSDateFormatterBehavior getDefaultFormatterBehavior() {
        throw new RuntimeException();
    }

    @Export("setDefaultFormatterBehavior:")
    public void setDefaultFormatterBehavior(NSDateFormatterBehavior value) {
        throw new RuntimeException();
    }

    @Export("dateFormat")
    public String getDateFormat() {
        throw new RuntimeException();
    }

    @Export("setDateFormat:")
    public void setDateFormat(String value) {
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

    @Export("calendar")
    public NSCalendar getCalendar() {
        throw new RuntimeException();
    }

    @Export("setCalendar:")
    public void setCalendar(NSCalendar value) {
        throw new RuntimeException();
    }

    @Bind("isLenient")
    @Export("lenient")
    public boolean getLenient() {
        throw new RuntimeException();
    }

    @Export("setLenient:")
    public void setLenient(boolean value) {
        throw new RuntimeException();
    }

    @Export("twoDigitStartDate")
    public NSDate getTwoDigitStartDate() {
        throw new RuntimeException();
    }

    @Export("setTwoDigitStartDate:")
    public void setTwoDigitStartDate(NSDate value) {
        throw new RuntimeException();
    }

    @Export("defaultDate")
    public NSDate getDefaultDate() {
        throw new RuntimeException();
    }

    @Export("setDefaultDate:")
    public void setDefaultDate(NSDate value) {
        throw new RuntimeException();
    }

    @Export("eraSymbols")
    public NSArray getEraSymbols() {
        throw new RuntimeException();
    }

    @Export("setEraSymbols:")
    public void setEraSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("monthSymbols")
    public NSArray getMonthSymbols() {
        throw new RuntimeException();
    }

    @Export("setMonthSymbols:")
    public void setMonthSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("shortMonthSymbols")
    public NSArray getShortMonthSymbols() {
        throw new RuntimeException();
    }

    @Export("setShortMonthSymbols:")
    public void setShortMonthSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("weekdaySymbols")
    public NSArray getWeekdaySymbols() {
        throw new RuntimeException();
    }

    @Export("setWeekdaySymbols:")
    public void setWeekdaySymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("shortWeekdaySymbols")
    public NSArray getShortWeekdaySymbols() {
        throw new RuntimeException();
    }

    @Export("setShortWeekdaySymbols:")
    public void setShortWeekdaySymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("longEraSymbols")
    public NSArray getLongEraSymbols() {
        throw new RuntimeException();
    }

    @Export("setLongEraSymbols:")
    public void setLongEraSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("veryShortMonthSymbols")
    public NSArray getVeryShortMonthSymbols() {
        throw new RuntimeException();
    }

    @Export("setVeryShortMonthSymbols:")
    public void setVeryShortMonthSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("standaloneMonthSymbols")
    public NSArray getStandaloneMonthSymbols() {
        throw new RuntimeException();
    }

    @Export("setStandaloneMonthSymbols:")
    public void setStandaloneMonthSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("shortStandaloneMonthSymbols")
    public NSArray getShortStandaloneMonthSymbols() {
        throw new RuntimeException();
    }

    @Export("setShortStandaloneMonthSymbols:")
    public void setShortStandaloneMonthSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("veryShortStandaloneMonthSymbols")
    public NSArray getVeryShortStandaloneMonthSymbols() {
        throw new RuntimeException();
    }

    @Export("setVeryShortStandaloneMonthSymbols:")
    public void setVeryShortStandaloneMonthSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("veryShortWeekdaySymbols")
    public NSArray getVeryShortWeekdaySymbols() {
        throw new RuntimeException();
    }

    @Export("setVeryShortWeekdaySymbols:")
    public void setVeryShortWeekdaySymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("standaloneWeekdaySymbols")
    public NSArray getStandaloneWeekdaySymbols() {
        throw new RuntimeException();
    }

    @Export("setStandaloneWeekdaySymbols:")
    public void setStandaloneWeekdaySymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("shortStandaloneWeekdaySymbols")
    public NSArray getShortStandaloneWeekdaySymbols() {
        throw new RuntimeException();
    }

    @Export("setShortStandaloneWeekdaySymbols:")
    public void setShortStandaloneWeekdaySymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("veryShortStandaloneWeekdaySymbols")
    public NSArray getVeryShortStandaloneWeekdaySymbols() {
        throw new RuntimeException();
    }

    @Export("setVeryShortStandaloneWeekdaySymbols:")
    public void setVeryShortStandaloneWeekdaySymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("quarterSymbols")
    public NSArray getQuarterSymbols() {
        throw new RuntimeException();
    }

    @Export("setQuarterSymbols:")
    public void setQuarterSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("shortQuarterSymbols")
    public NSArray getShortQuarterSymbols() {
        throw new RuntimeException();
    }

    @Export("setShortQuarterSymbols:")
    public void setShortQuarterSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("standaloneQuarterSymbols")
    public NSArray getStandaloneQuarterSymbols() {
        throw new RuntimeException();
    }

    @Export("setStandaloneQuarterSymbols:")
    public void setStandaloneQuarterSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("shortStandaloneQuarterSymbols")
    public NSArray getShortStandaloneQuarterSymbols() {
        throw new RuntimeException();
    }

    @Export("setShortStandaloneQuarterSymbols:")
    public void setShortStandaloneQuarterSymbols(NSArray value) {
        throw new RuntimeException();
    }

    @Export("gregorianStartDate")
    public NSDate getGregorianStartDate() {
        throw new RuntimeException();
    }

    @Export("setGregorianStartDate:")
    public void setGregorianStartDate(NSDate value) {
        throw new RuntimeException();
    }

    @Export("doesRelativeDateFormatting")
    public boolean getDoesRelativeDateFormatting() {
        throw new RuntimeException();
    }

    @Export("setDoesRelativeDateFormatting:")
    public void setDoesRelativeDateFormatting(boolean value) {
        throw new RuntimeException();
    }


    @Export("initWithDateFormat:allowNaturalLanguage:")
    public NSObject initWithDateFormatallowNaturalLanguage(String format, boolean flag) {
        throw new RuntimeException();
    }
}