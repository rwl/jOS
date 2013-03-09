package jos.api.uikit;

import jos.api.foundation.NSCalendar;
import jos.api.foundation.NSCalendarUnit;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSCopying;
import jos.api.foundation.NSDate;
import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;
import jos.api.foundation.NSTimeZone;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSCoding.class})
@Register(isWrapper = true)
public class UILocalNotification extends NSObject {

    @Export("repeatInterval")
    public NSCalendarUnit getRepeatInterval() {
        throw new RuntimeException();
    }

    @Export("setRepeatInterval:")
    public void setRepeatInterval(NSCalendarUnit value) {
        throw new RuntimeException();
    }

    @Export("repeatCalendar")
    public NSCalendar getRepeatCalendar() {
        throw new RuntimeException();
    }

    @Export("setRepeatCalendar:")
    public void setRepeatCalendar(NSCalendar value) {
        throw new RuntimeException();
    }

    @Export("hasAction")
    public boolean getHasAction() {
        throw new RuntimeException();
    }

    @Export("setHasAction:")
    public void setHasAction(boolean value) {
        throw new RuntimeException();
    }

    @Export("alertAction")
    public String getAlertAction() {
        throw new RuntimeException();
    }

    @Export("setAlertAction:")
    public void setAlertAction(String value) {
        throw new RuntimeException();
    }

    @Export("alertLaunchImage")
    public String getAlertLaunchImage() {
        throw new RuntimeException();
    }

    @Export("setAlertLaunchImage:")
    public void setAlertLaunchImage(String value) {
        throw new RuntimeException();
    }

    @Export("fireDate")
    public NSDate fireDate() {
        throw new RuntimeException();
    }

    @Export("timeZone")
    public NSTimeZone timeZone() {
        throw new RuntimeException();
    }

    @Export("alertBody")
    public NSString alertBody() {
        throw new RuntimeException();
    }

    @Export("soundName")
    public NSString soundName() {
        throw new RuntimeException();
    }

    @Export("applicationIconBadgeNumber")
    public int applicationIconBadgeNumber() {
        throw new RuntimeException();
    }

    @Export("userInfo")
    public NSDictionary userInfo() {
        throw new RuntimeException();
    }

}

