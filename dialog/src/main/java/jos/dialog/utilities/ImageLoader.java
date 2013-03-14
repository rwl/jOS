package jos.dialog.utilities;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import jos.api.foundation.NSError;
import jos.api.foundation.NSString;
import jos.api.foundation.NSURLRequestCachePolicy;
import jos.api.foundation.NSUrl;
import jos.api.uikit.UIImage;

/**
 * Network image loader, with local file system cache and in-memory cache
 *
 * By default, using the static public methods will use an in-memory cache
 * for 50 images and 4 megs total.   The behavior of the static methods
 * can be modified by setting the public DefaultLoader property to a value
 * that the user configured.
 *
 * The instance methods can be used to create different imageloader with
 * different properties.
 *
 * Keep in mind that the phone does not have a lot of memory, and using
 * the cache with the unlimited value (0) even with a number of items in
 * the cache can consume memory very quickly.
 *
 * Use the Purge method to release all the memory kept in the caches on
 * low memory conditions, or when the application is sent to the background.
 */
public class ImageLoader {

    public static final String BaseDir = new File(Environment.GetFolderPath (Environment.SpecialFolder.Personal), "..");

    private static final int MaxRequests = 6;
    private static File PicDir;

    // Cache of recently used images
    private LRUCache<URI, UIImage> cache;

    // A list of requests that have been issues, with a list of objects to notify.
    private static Map<URI, List<IImageUpdated>> pendingRequests;

    // A list of updates that have completed, we must notify the main thread about them.
    private static Set<URI> queuedUpdates;

    // A queue used to avoid flooding the network stack with HTTP requests
    private static Stack<URI> requestQueue;

    private static NSString nsDispatcher = new NSString ("x");

    private static MD5CryptoServiceProvider checksum = new MD5CryptoServiceProvider ();

    /**
     * This contains the default loader which is configured to be 50 images
     * up to 4 megs of memory. Assigning to this property a new value will
     * change the behavior. This property is lazyly computed, the first time
     * an image is requested.
     */
    public static ImageLoader DefaultLoader;

    static
    {
        PicDir = new File(BaseDir, "Library/Caches/Pictures.MonoTouch.Dialog/");

        if (!PicDir.exists())
            PicDir.mkdirs();

        pendingRequests = new HashMap<URI,List<IImageUpdated>> ();
        queuedUpdates = new HashSet<URI>();
        requestQueue = new Stack<URI> ();
    }

    /**
     * Creates a new instance of the image loader
     *
     * @param cacheSize The maximum number of entries in the LRU cache
     * @param memoryLimit The maximum number of bytes to consume by the
     * image loader cache.
     */
    public ImageLoader (int cacheSize, int memoryLimit)
    {
        cache = new LRUCache<URI, UIImage> (cacheSize/*, memoryLimit, new ISlotSizer<UIImage>() {
            public int size(UIImage img) {
                var cg = img.CGImage;
                return cg.BytesPerRow * cg.Height;
            }
        }*/);
    }

    /**
     * Purges the contents of the DefaultLoader
     */
    public static void Purge ()
    {
        if (DefaultLoader != null)
            DefaultLoader.PurgeCache ();
    }

    /**
     * Purges the cache of this instance of the ImageLoader, releasing
     * all the memory used by the images in the caches.
     */
    public void PurgeCache ()
    {
        synchronized (cache) {
            cache.Purge ();
        }
    }

    private static int hex (int v)
    {
        if (v < 10)
            return '0' + v;
        return 'a' + v-10;
    }

    private static String md5 (String input)
    {
        bytes = checksum.ComputeHash (Encoding.UTF8.GetBytes (input));
        char[] ret = new char [32];
        for (int i = 0; i < 16; i++){
            ret [i*2] = (char)hex (bytes [i] >> 4);
            ret [i*2+1] = (char)hex (bytes [i] & 0xf);
        }
        return new String (ret);
    }

    /**
     * Requests an image to be loaded using the default image loader
     *
     * @param uri The URI for the image to load
     * @param notify A class implementing the IImageUpdated interface that
     * will be invoked when the image has been loaded
     * @return If the image has already been downloaded, or is in the cache,
     * this will return the image as a UIImage.
     */
    public static UIImage DefaultRequestImage (URI uri, IImageUpdated notify)
    {
        if (DefaultLoader == null)
            DefaultLoader = new ImageLoader (50, 4*1024*1024);
        return DefaultLoader.RequestImage (uri, notify);
    }

    /**
     * Requests an image to be loaded from the network
     *
     * @param uri The URI for the image to load
     * @param notify A class implementing the IImageUpdated interface that
     * will be invoked when the image has been loaded
     * @return If the image has already been downloaded, or is in the cache,
     * this will return the image as a UIImage.
     */
    public UIImage RequestImage (URI uri, IImageUpdated notify)
    {
        UIImage ret;

        synchronized (cache) {
            ret = cache.get(uri);
            if (ret != null)
                return ret;
        }

        synchronized (requestQueue) {
            if (pendingRequests.containsKey (uri)) {
                if (!pendingRequests.get(uri).contains(notify))
                    pendingRequests.get(uri).add(notify);
                return null;
            }
        }

        String picfile = uri.isFile() ? uri.getLocalPath() : PicDir + md5 (uri.getAbsoluteUri());
        if (new File(picfile).exists()){
            ret = UIImage.fromFile(picfile);
            if (ret != null){
                synchronized (cache) {
                    cache.set(uri, ret);
                }
                return ret;
            }
        }
        if (uri.isFile())
            return null;
        QueueRequest (uri, notify);
        return null;
    }

    static void QueueRequest (URI uri, IImageUpdated notify)
    {
        if (notify == null)
            throw new IllegalArgumentException("notify");

        synchronized (requestQueue) {
            if (pendingRequests.containsKey (uri)){
                //Util.Log ("pendingRequest: added new listener for {0}", id);
                pendingRequests.get(uri).add (notify);
                return;
            }
            List<IImageUpdated> slot = new ArrayList<IImageUpdated> (4);
            slot.add (notify);
            pendingRequests.put(uri, slot);

            if (picDownloaders >= MaxRequests)
                requestQueue.push (uri);
            else {
                ThreadPool.QueueUserWorkItem (delegate {
                        try {
                            StartPicDownload (uri);
                        } catch (Exception e){
                            System.out.println(e);
                        }
                    });
            }
        }
    }

    static boolean Download (URI uri)
    {
        try {
            NSUrlResponse response;
            NSError error;

            File target = new File(PicDir, md5 (uri.getAbsoluteUri()));
            NSUrlRequest req = new NSUrlRequest (new NSUrl(uri.getAbsoluteUri().toString ()),
                    NSURLRequestCachePolicy.USE_PROTOCOL_CACHE_POLICY, 120);
            /*var */data = NSUrlConnection.sendSynchronousRequest (req, /*out */response, /*out */error);
            return data.save (target, true, /*out */error);
        } catch (Exception e) {
            System.out.printf("Problem with %s %s", uri, e);
            return false;
        }
    }

    static long picDownloaders;

    static void StartPicDownload (URI uri)
    {
        Interlocked.Increment (ref picDownloaders);
        try {
            _StartPicDownload (uri);
        } catch (Exception e){
            System.err.printf("CRITICAL: should have never happened %s", e);
        }
        //Util.Log ("Leaving StartPicDownload {0}", picDownloaders);
        Interlocked.Decrement (ref picDownloaders);
    }

    static void _StartPicDownload (URI uri)
    {
        do {
            boolean downloaded = false;

            //System.Threading.Thread.Sleep (5000);
            downloaded = Download (uri);
            //if (!downloaded)
            //  Console.WriteLine ("Error fetching picture for {0} to {1}", uri, target);

            // Cluster all updates together
            boolean doInvoke = false;

            synchronized (requestQueue){
                if (downloaded){
                    queuedUpdates.add (uri);

                    // If this is the first queued update, must notify
                    if (queuedUpdates.size() == 1)
                        doInvoke = true;
                } else
                    pendingRequests.remove (uri);

                // Try to get more jobs.
                if (requestQueue.size() > 0){
                    uri = requestQueue.pop ();
                    if (uri == null){
                        System.err.printf("Dropping request %s because url is null", uri);
                        pendingRequests.remove (uri);
                        uri = null;
                    }
                } else {
                    //Util.Log ("Leaving because requestQueue.Count = {0} NOTE: {1}", requestQueue.Count, pendingRequests.Count);
                    uri = null;
                }
            }
            if (doInvoke)
                nsDispatcher.beginInvokeOnMainThread (NotifyImageListeners());

        } while (uri != null);
    }

    // Runs on the main thread
    static void NotifyImageListeners ()
    {
        synchronized (requestQueue) {
            for (URI quri : queuedUpdates){
                List<IImageUpdated> list = pendingRequests.get(quri);
                pendingRequests.remove (quri);
                for (IImageUpdated pr : list){
                    try {
                        pr.UpdatedImage (quri);
                    } catch (Exception e){
                        System.out.println(e);
                    }
                }
            }
            queuedUpdates.clear ();
        }
    }
}
