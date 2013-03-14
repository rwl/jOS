package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIImagePickerControllerQualityType {
    @Bind("UIImagePickerControllerQualityTypeHigh") HIGH,
    @Bind("UIImagePickerControllerQualityTypeMedium") MEDIUM,
    @Bind("UIImagePickerControllerQualityTypeLow") LOW,
    UIImagePickerControllerQualityType640x480,
    @Bind("UIImagePickerControllerQualityTypeIFrame1280x720") IFRAME_1280X720,
    @Bind("UIImagePickerControllerQualityTypeIFrame960x540") IFRAME_960X540;
}
