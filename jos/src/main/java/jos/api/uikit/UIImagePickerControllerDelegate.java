package jos.api.uikit;

import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UIImagePickerControllerDelegate extends NSObject {

    @Export("imagePickerController:didFinishPickingImage:editingInfo:")
    public void finishedPickingImage(UIImagePickerController picker, UIImage image, NSDictionary editingInfo) {
        throw new RuntimeException();
    }

    @Export("imagePickerController:didFinishPickingMediaWithInfo:")
    public void imagePickerControllerdidFinishPickingMediaWithInfo(UIImagePickerController picker, NSDictionary info) {
        throw new RuntimeException();
    }

    @Export("imagePickerControllerDidCancel:")
    public void imagePickerControllerDidCancel(UIImagePickerController picker) {
        throw new RuntimeException();
    }

}