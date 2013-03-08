package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSSecureCoding.class})
@Register(isWrapper = true)
public class NSLocale extends NSObject {

    @Export("objectForKey:")
    public NSObject objectForKey(NSObject key) {
        throw new RuntimeException();
    }

    @Export("displayNameForKey:value:")
    public String displayNameForKeyvalue(NSObject key, NSObject value) {
        throw new RuntimeException();
    }

    @Export("localeIdentifier")
    public String localeIdentifier() {
        throw new RuntimeException();
    }

    @Export("systemLocale")
    public static NSObject systemLocale() {
        throw new RuntimeException();
    }

    @Export("autoupdatingCurrentLocale")
    public static NSObject autoupdatingCurrentLocale() {
        throw new RuntimeException();
    }

    @Export("initWithLocaleIdentifier:")
    public NSObject initWithLocaleIdentifier(String string) {
        throw new RuntimeException();
    }

    @Export("availableLocaleIdentifiers")
    public static NSArray availableLocaleIdentifiers() {
        throw new RuntimeException();
    }

    @Export("ISOCountryCodes")
    public static NSArray ISOCountryCodes() {
        throw new RuntimeException();
    }

    @Export("ISOCurrencyCodes")
    public static NSArray ISOCurrencyCodes() {
        throw new RuntimeException();
    }

    @Export("commonISOCurrencyCodes")
    public static NSArray commonISOCurrencyCodes() {
        throw new RuntimeException();
    }

    @Export("preferredLanguages")
    public static NSArray preferredLanguages() {
        throw new RuntimeException();
    }

    @Export("componentsFromLocaleIdentifier:")
    public static NSDictionary componentsFromLocaleIdentifier(String string) {
        throw new RuntimeException();
    }

    @Export("localeIdentifierFromComponents:")
    public static String localeIdentifierFromComponents(NSDictionary dict) {
        throw new RuntimeException();
    }

    @Export("canonicalLocaleIdentifierFromString:")
    public static String canonicalLocaleIdentifierFromString(String string) {
        throw new RuntimeException();
    }

    @Export("canonicalLanguageIdentifierFromString:")
    public static String canonicalLanguageIdentifierFromString(String string) {
        throw new RuntimeException();
    }

    @Export("localeIdentifierFromWindowsLocaleCode:")
    public static String localeIdentifierFromWindowsLocaleCode(int lcid) {
        throw new RuntimeException();
    }

    @Export("windowsLocaleCodeFromLocaleIdentifier:")
    public static int windowsLocaleCodeFromLocaleIdentifier(String localeIdentifier) {
        throw new RuntimeException();
    }

    @Export("characterDirectionForLanguage:")
    public static NSLocaleLanguageDirection characterDirectionForLanguage(String isoLangCode) {
        throw new RuntimeException();
    }

    @Export("lineDirectionForLanguage:")
    public static NSLocaleLanguageDirection lineDirectionForLanguage(String isoLangCode) {
        throw new RuntimeException();
    }

}