package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
@Register(isWrapper = true)
public class NSBundle {

    @Export("mainBundle")
    public static NSBundle getMainBundle() {
        throw new RuntimeException();
    }

    @Export("bundleWithPath:")
    public static NSBundle bundleWithPath(String path) {
        throw new RuntimeException();
    }

    @Export("initWithPath:")
    public NSObject initWithPath(String path) {
        throw new RuntimeException();
    }

    @Export("bundleWithURL:")
    public static NSBundle bundleWithURL(NSUrl url) {
        throw new RuntimeException();
    }

    @Export("initWithURL:")
    public NSObject initWithURL(NSUrl url) {
        throw new RuntimeException();
    }

    @Export("bundleForClass:")
    public static NSBundle bundleForClass(Class aClass) {
        throw new RuntimeException();
    }

    @Export("bundleWithIdentifier:")
    public static NSBundle bundleWithIdentifier(String identifier) {
        throw new RuntimeException();
    }

    @Export("allBundles")
    public static NSArray allBundles() {
        throw new RuntimeException();
    }

    @Export("allFrameworks")
    public static NSArray allFrameworks() {
        throw new RuntimeException();
    }

    @Export("load")
    public boolean load() {
        throw new RuntimeException();
    }

    @Export("isLoaded")
    public boolean isLoaded() {
        throw new RuntimeException();
    }

    @Export("unload")
    public boolean unload() {
        throw new RuntimeException();
    }

    @Export("preflightAndReturnError:")
    public boolean preflightAndReturnError(NSError error) {
        throw new RuntimeException();
    }

    @Export("loadAndReturnError:")
    public boolean loadAndReturnError(NSError error) {
        throw new RuntimeException();
    }

    @Export("bundleURL")
    public NSUrl bundleURL() {
        throw new RuntimeException();
    }

    @Export("resourceURL")
    public NSUrl resourceURL() {
        throw new RuntimeException();
    }

    @Export("executableURL")
    public NSUrl executableURL() {
        throw new RuntimeException();
    }

    @Export("URLForAuxiliaryExecutable:")
    public NSUrl URLForAuxiliaryExecutable(String executableName) {
        throw new RuntimeException();
    }

    @Export("privateFrameworksURL")
    public NSUrl privateFrameworksURL() {
        throw new RuntimeException();
    }

    @Export("sharedFrameworksURL")
    public NSUrl sharedFrameworksURL() {
        throw new RuntimeException();
    }

    @Export("sharedSupportURL")
    public NSUrl sharedSupportURL() {
        throw new RuntimeException();
    }

    @Export("builtInPlugInsURL")
    public NSUrl builtInPlugInsURL() {
        throw new RuntimeException();
    }

    @Export("appStoreReceiptURL")
    public NSUrl appStoreReceiptURL() {
        throw new RuntimeException();
    }

    @Export("bundlePath")
    public String getBundlePath() {
        throw new RuntimeException();
    }

    @Export("resourcePath")
    public String getResourcePath() {
        throw new RuntimeException();
    }

    @Export("executablePath")
    public String getExecutablePath() {
        throw new RuntimeException();
    }

    @Export("pathForAuxiliaryExecutable:")
    public String pathForAuxiliaryExecutable(String executableName) {
        throw new RuntimeException();
    }

    @Export("privateFrameworksPath")
    public String privateFrameworksPath() {
        throw new RuntimeException();
    }

    @Export("sharedFrameworksPath")
    public String sharedFrameworksPath() {
        throw new RuntimeException();
    }

    @Export("sharedSupportPath")
    public String sharedSupportPath() {
        throw new RuntimeException();
    }

    @Export("builtInPlugInsPath")
    public String builtInPlugInsPath() {
        throw new RuntimeException();
    }

    @Export("URLForResource:withExtension:subdirectory:inBundleWithURL:")
    public static NSUrl URLForResourcewithExtensionsubdirectoryinBundleWithURL(String name, String ext, String subpath, NSUrl bundleURL) {
        throw new RuntimeException();
    }

    @Export("URLsForResourcesWithExtension:subdirectory:inBundleWithURL:")
    public static NSArray URLsForResourcesWithExtensionsubdirectoryinBundleWithURL(String ext, String subpath, NSUrl bundleURL) {
        throw new RuntimeException();
    }

    @Export("URLForResource:withExtension:")
    public NSUrl URLForResourcewithExtension(String name, String ext) {
        throw new RuntimeException();
    }

    @Export("URLForResource:withExtension:subdirectory:")
    public NSUrl URLForResourcewithExtensionsubdirectory(String name, String ext, String subpath) {
        throw new RuntimeException();
    }

    @Export("URLForResource:withExtension:subdirectory:localization:")
    public NSUrl URLForResourcewithExtensionsubdirectorylocalization(String name, String ext, String subpath, String localizationName) {
        throw new RuntimeException();
    }

    @Export("URLsForResourcesWithExtension:subdirectory:")
    public NSArray URLsForResourcesWithExtensionsubdirectory(String ext, String subpath) {
        throw new RuntimeException();
    }

    @Export("URLsForResourcesWithExtension:subdirectory:localization:")
    public NSArray URLsForResourcesWithExtensionsubdirectorylocalization(String ext, String subpath, String localizationName) {
        throw new RuntimeException();
    }

    @Export("pathForResource:ofType:inDirectory:")
    public static String pathForResourceofTypeinDirectory(String name, String ext, String bundlePath) {
        throw new RuntimeException();
    }

    @Export("pathsForResourcesOfType:inDirectory:")
    public static NSArray pathsForResourcesOfTypeinDirectory(String ext, String bundlePath) {
        throw new RuntimeException();
    }

    @Export("pathForResource:ofType:")
    public String pathForResourceofType(String name, String ext) {
        throw new RuntimeException();
    }

    @Export("pathForResource:ofType:inDirectory:")
    public String pathForResourceofType(String name, String ext, String subpath) {
        throw new RuntimeException();
    }

    @Export("pathForResource:ofType:inDirectory:forLocalization:")
    public String pathForResourceofTypeinDirectoryforLocalization(String name, String ext, String subpath, String localizationName) {
        throw new RuntimeException();
    }

    @Export("pathsForResourcesOfType:inDirectory:")
    public NSArray pathsForResourcesOfType(String ext, String subpath) {
        throw new RuntimeException();
    }

    @Export("pathsForResourcesOfType:inDirectory:forLocalization:")
    public NSArray pathsForResourcesOfTypeinDirectoryforLocalization(String ext, String subpath, String localizationName) {
        throw new RuntimeException();
    }

    @Export("localizedStringForKey:value:table:")
    public String localizedStringForKeyvaluetable(String key, String value, String tableName) {
        throw new RuntimeException();
    }

    @Export("bundleIdentifier")
    public String bundleIdentifier() {
        throw new RuntimeException();
    }

    @Export("infoDictionary")
    public NSDictionary infoDictionary() {
        throw new RuntimeException();
    }

    @Export("localizedInfoDictionary")
    public NSDictionary localizedInfoDictionary() {
        throw new RuntimeException();
    }

    @Export("objectForInfoDictionaryKey:")
    public NSObject objectForInfoDictionaryKey(String key) {
        throw new RuntimeException();
    }

    @Export("classNamed:")
    public Class classNamed(String className) {
        throw new RuntimeException();
    }

    @Export("principalClass")
    public Class principalClass() {
        throw new RuntimeException();
    }

    @Export("localizations")
    public NSArray localizations() {
        throw new RuntimeException();
    }

    @Export("preferredLocalizations")
    public NSArray preferredLocalizations() {
        throw new RuntimeException();
    }

    @Export("developmentLocalization")
    public String developmentLocalization() {
        throw new RuntimeException();
    }

    @Export("preferredLocalizationsFromArray:")
    public static NSArray preferredLocalizationsFromArray(NSArray localizationsArray) {
        throw new RuntimeException();
    }

    @Export("preferredLocalizationsFromArray:forPreferences:")
    public static NSArray preferredLocalizationsFromArrayforPreferences(NSArray localizationsArray, NSArray preferencesArray) {
        throw new RuntimeException();
    }

    @Export("executableArchitectures")
    public NSArray executableArchitectures() {
        throw new RuntimeException();
    }


    @Export("loadNibNamed:owner:options:")
    public NSArray loadNib(String name, NSObject owner, NSDictionary options) {
        throw new RuntimeException();
    }
}
