package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSCoding;
import jos.api.graphicsimaging.CGAffineTransform;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(NSCoding.class)
@Register(isWrapper = true)
public class UIImagePickerController extends UINavigationController {

    @Export("delegate")
    public UINavigationControllerDelegate getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(UINavigationControllerDelegate value) {
        throw new RuntimeException();
    }

    @Export("delegate")
    public UIImagePickerControllerDelegate getImageDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setImageDelegate(UIImagePickerControllerDelegate value) {
        throw new RuntimeException();
    }

    @Export("sourceType")
    public UIImagePickerControllerSourceType getSourceType() {
        throw new RuntimeException();
    }

    @Export("setSourceType:")
    public void setSourceType(UIImagePickerControllerSourceType value) {
        throw new RuntimeException();
    }

    @Export("mediaTypes")
    public NSArray getMediaTypes() {
        throw new RuntimeException();
    }

    @Export("setMediaTypes:")
    public void setMediaTypes(NSArray value) {
        throw new RuntimeException();
    }

    @Export("allowsImageEditing")
    public boolean getAllowsImageEditing() {
        throw new RuntimeException();
    }

    @Export("setAllowsImageEditing:")
    public void setAllowsImageEditing(boolean value) {
        throw new RuntimeException();
    }

    @Export("videoQuality")
    public UIImagePickerControllerQualityType getVideoQuality() {
        throw new RuntimeException();
    }

    @Export("setVideoQuality:")
    public void setVideoQuality(UIImagePickerControllerQualityType value) {
        throw new RuntimeException();
    }

    @Export("cameraOverlayView")
    public UIView getCameraOverlayView() {
        throw new RuntimeException();
    }

    @Export("setCameraOverlayView:")
    public void setCameraOverlayView(UIView value) {
        throw new RuntimeException();
    }

    @Export("cameraViewTransform")
    public CGAffineTransform getCameraViewTransform() {
        throw new RuntimeException();
    }

    @Export("setCameraViewTransform:")
    public void setCameraViewTransform(CGAffineTransform value) {
        throw new RuntimeException();
    }

    @Export("cameraCaptureMode")
    public UIImagePickerControllerCameraCaptureMode getCameraCaptureMode() {
        throw new RuntimeException();
    }

    @Export("setCameraCaptureMode:")
    public void setCameraCaptureMode(UIImagePickerControllerCameraCaptureMode value) {
        throw new RuntimeException();
    }

    @Export("cameraDevice")
    public UIImagePickerControllerCameraDevice getCameraDevice() {
        throw new RuntimeException();
    }

    @Export("setCameraDevice:")
    public void setCameraDevice(UIImagePickerControllerCameraDevice value) {
        throw new RuntimeException();
    }

    @Export("cameraFlashMode")
    public UIImagePickerControllerCameraFlashMode getCameraFlashMode() {
        throw new RuntimeException();
    }

    @Export("setCameraFlashMode:")
    public void setCameraFlashMode(UIImagePickerControllerCameraFlashMode value) {
        throw new RuntimeException();
    }

    @Export("isSourceTypeAvailable:")
    public static boolean isSourceTypeAvailable(UIImagePickerControllerSourceType sourceType) {
        throw new RuntimeException();
    }

    @Export("availableMediaTypesForSourceType:")
    public static NSArray availableMediaTypesForSourceType(UIImagePickerControllerSourceType sourceType) {
        throw new RuntimeException();
    }

    @Export("isCameraDeviceAvailable:")
    public static boolean isCameraDeviceAvailable(UIImagePickerControllerCameraDevice cameraDevice) {
        throw new RuntimeException();
    }

    @Export("isFlashAvailableForCameraDevice:")
    public static boolean isFlashAvailableForCameraDevice(UIImagePickerControllerCameraDevice cameraDevice) {
        throw new RuntimeException();
    }

    @Export("availableCaptureModesForCameraDevice:")
    public static NSArray availableCaptureModesForCameraDevice(UIImagePickerControllerCameraDevice cameraDevice) {
        throw new RuntimeException();
    }

    @Export("allowsEditing")
    public boolean allowsEditing() {
        throw new RuntimeException();
    }

    @Export("NSTimeIntervalvideoMaximumDuration")
    public double videoMaximumDuration() {
        throw new RuntimeException();
    }

    @Export("showsCameraControls")
    public boolean showsCameraControls() {
        throw new RuntimeException();
    }

    @Export("takePicture")
    public void takePicture() {
        throw new RuntimeException();
    }

    @Export("startVideoCapture")
    public boolean startVideoCapture() {
        throw new RuntimeException();
    }

    @Export("stopVideoCapture")
    public void stopVideoCapture() {
        throw new RuntimeException();
    }

}