package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIImagePickerControllerSourceType {
    @Bind("UIImagePickerControllerSourceTypePhotoLibrary") PHOTO_LIBRARY,
    @Bind("UIImagePickerControllerSourceTypeCamera") CAMERA,
    @Bind("UIImagePickerControllerSourceTypeSavedPhotosAlbum") SAVED_PHOTOS_ALBUM;
}
