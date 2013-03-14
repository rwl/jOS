package jos.dialog.utilities;

import java.net.URI;

/**
 * This interface needs to be implemented to be notified when an image
 * has been downloaded.   The notification will happen on the UI thread.
 * Upon notification, the code should call RequestImage again, this time
 * the image will be loaded from the on-disk cache or the in-memory cache.
 */
public interface IImageUpdated {
    void UpdatedImage (URI uri);
}