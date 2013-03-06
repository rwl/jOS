package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSSecureCoding.class, NSCopying.class})
@Register(isWrapper = true)
public class NSUrl extends NSObject {

    @Export("initWithScheme:host:path:")
    public NSUrl(String scheme, String host, String path) {
        throw new RuntimeException();
    }

    @Export("initFileURLWithPath:isDirectory:")
    public NSUrl(String path, boolean isDir) {
        throw new RuntimeException();
    }

    @Export("initFileURLWithPath:")
    public NSUrl(String path) {
        throw new RuntimeException();
    }

    @Export("fileURLWithPath:isDirectory:")
    public static NSObject fileURLWithPathisDirectory(String path, boolean isDir) {
        throw new RuntimeException();
    }

    @Export("fileURLWithPath:")
    public static NSObject fileURLWithPath(String path) {
        throw new RuntimeException();
    }

    @Export("URLString")
    public String URLString() {
        throw new RuntimeException();
    }

    @Export("URLStringrelativeToURL:")
    public String URLStringrelativeToURL(NSUrl baseURL) {
        throw new RuntimeException();
    }

    @Export("URLWithString:")
    public static NSObject URLWithString(String URLString) {
        throw new RuntimeException();
    }

    @Export("URLWithString:relativeToURL:")
    public static NSObject URLWithStringrelativeToURL(String URLString, NSUrl baseURL) {
        throw new RuntimeException();
    }

    @Export("absoluteString")
    public String getAbsoluteString() {
        throw new RuntimeException();
    }

    @Export("relativeString")
    public String getRelativeString() {
        throw new RuntimeException();
    }

    @Export("baseURL")
    public NSUrl getBaseURL() {
        throw new RuntimeException();
    }

    @Export("absoluteURL")
    public NSUrl getAbsoluteURL() {
        throw new RuntimeException();
    }

    @Export("scheme")
    public String scheme() {
        throw new RuntimeException();
    }

    @Export("resourceSpecifier")
    public String resourceSpecifier() {
        throw new RuntimeException();
    }

    @Export("host")
    public String host() {
        throw new RuntimeException();
    }

    @Export("port")
    public int port() {
        throw new RuntimeException();
    }

    @Export("user")
    public String user() {
        throw new RuntimeException();
    }

    @Export("password")
    public String password() {
        throw new RuntimeException();
    }

    @Export("path")
    public String path() {
        throw new RuntimeException();
    }

    @Export("fragment")
    public String fragment() {
        throw new RuntimeException();
    }

    @Export("parameterString")
    public String parameterString() {
        throw new RuntimeException();
    }

    @Export("query")
    public String query() {
        throw new RuntimeException();
    }

    @Export("relativePath")
    public String relativePath() {
        throw new RuntimeException();
    }

    @Export("isFileURL")
    public boolean isFileURL() {
        throw new RuntimeException();
    }

    @Export("standardizedURL")
    public NSUrl standardizedURL() {
        throw new RuntimeException();
    }

    @Export("checkResourceIsReachableAndReturnError:")
    public boolean checkResourceIsReachableAndReturnError(NSError error) {
        throw new RuntimeException();
    }

    @Export("isFileReferenceURL")
    public boolean isFileReferenceURL() {
        throw new RuntimeException();
    }

    @Export("fileReferenceURL")
    public NSUrl getFileReferenceURL() {
        throw new RuntimeException();
    }

    @Export("filePathURL")
    public NSUrl filePathURL() {
        throw new RuntimeException();
    }

    @Export("getResourceValue:forKey:error:")
    public boolean getResourceValue(NSObject out, String key, NSError error) {
        throw new RuntimeException();
    }

    @Export("resourceValuesForKeys:error:")
    public NSDictionary resourceValuesForKeys(NSArray keys, NSError error) {
        throw new RuntimeException();
    }

    @Export("setResourceValue:forKey:error:")
    public boolean setResourceValueforKeyerror(NSObject value, String key, NSError error) {
        throw new RuntimeException();
    }

    @Export("setResourceValues:error:")
    public boolean setResourceValueserror(NSDictionary keyedValues, NSError error) {
        throw new RuntimeException();
    }

    @Export("bookmarkDataWithOptions:includingResourceValuesForKeys:relativeToURL:error:")
    public NSData bookmarkDataWithOptionsincludingResourceValuesForKeysrelativeToURLerror(NSURLBookmarkCreationOptions options, NSArray keys, NSUrl relativeURL, NSError error) {
        throw new RuntimeException();
    }

    @Export("initByResolvingBookmarkData:options:relativeToURL:bookmarkDataIsStale:error:")
    public NSObject initByResolvingBookmarkDataoptionsrelativeToURLbookmarkDataIsStaleerror(NSData bookmarkData, NSURLBookmarkResolutionOptions options, NSUrl relativeURL, boolean isStale, NSError error) {
        throw new RuntimeException();
    }

    @Export("URLByResolvingBookmarkData:options:relativeToURL:bookmarkDataIsStale:error:")
    public static NSObject URLByResolvingBookmarkDataoptionsrelativeToURLbookmarkDataIsStaleerror(NSData bookmarkData, NSURLBookmarkResolutionOptions options, NSUrl relativeURL, boolean isStale, NSError error) {
        throw new RuntimeException();
    }

    @Export("resourceValuesForKeys:fromBookmarkData:")
    public NSDictionary resourceValuesForKeysfromBookmarkData(NSArray keys, NSData bookmarkData) {
        throw new RuntimeException();
    }

    @Export("writeBookmarkData:toURL:options:error:")
    public boolean writeBookmarkDatatoURLoptionserror(NSData bookmarkData, NSUrl bookmarkFileURL, NSURLBookmarkFileCreationOptions options, NSError error) {
        throw new RuntimeException();
    }

    @Export("bookmarkDataWithContentsOfURL:error:")
    public NSData bookmarkDataWithContentsOfURLerror(NSUrl bookmarkFileURL, NSError error) {
        throw new RuntimeException();
    }

    @Export("startAccessingSecurityScopedResource")
    public boolean startAccessingSecurityScopedResource() {
        throw new RuntimeException();
    }

    @Export("stopAccessingSecurityScopedResource")
    public void stopAccessingSecurityScopedResource() {
        throw new RuntimeException();
    }


    @Export("fileURLWithPathComponents:")
    public NSUrl fileURLWithPathComponents(NSArray components) {
        throw new RuntimeException();
    }

    @Export("pathComponents")
    public NSArray pathComponents() {
        throw new RuntimeException();
    }

    @Export("lastPathComponent")
    public String lastPathComponent() {
        throw new RuntimeException();
    }

    @Export("pathExtension")
    public String pathExtension() {
        throw new RuntimeException();
    }

    @Export("URLByAppendingPathComponent:")
    public NSUrl URLByAppendingPathComponent(String pathComponent) {
        throw new RuntimeException();
    }

    @Export("URLByAppendingPathComponent:isDirectory:")
    public NSUrl URLByAppendingPathComponentisDirectory(String pathComponent, boolean isDirectory) {
        throw new RuntimeException();
    }

    @Export("URLByDeletingLastPathComponent")
    public NSUrl URLByDeletingLastPathComponent() {
        throw new RuntimeException();
    }

    @Export("URLByAppendingPathExtension:")
    public NSUrl URLByAppendingPathExtension(String pathExtension) {
        throw new RuntimeException();
    }

    @Export("URLByDeletingPathExtension")
    public NSUrl URLByDeletingPathExtension() {
        throw new RuntimeException();
    }

    @Export("URLByStandardizingPath")
    public NSUrl URLByStandardizingPath() {
        throw new RuntimeException();
    }

    @Export("URLByResolvingSymlinksInPath")
    public NSUrl URLByResolvingSymlinksInPath() {
        throw new RuntimeException();
    }

}