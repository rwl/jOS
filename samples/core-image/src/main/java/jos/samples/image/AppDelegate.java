package jos.samples.image;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jos.api.coreimage.CIFilter;
import jos.api.coreimage.CIImage;
import jos.api.coreimage.CIVector;
import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGImage;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.UIGraphics;
import jos.api.uikit.UIApplicationDelegate;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlState;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIScreen;
import jos.api.uikit.UIView;

public class AppDelegate extends UIApplicationDelegate {

    /**
     * "Flower" © 2012 Milica Sekulic, used under a Creative Commons Attribution-ShareAlike license: http://creativecommons.org/licenses/by-sa/3.0/
     */
    CIImage flower = CIImage.fromCGImage(UIImage.fromFile("flower.png").CGImage);

    /**
     * "Sunrise near Atkeison Plateau" © 2012 Charles Atkeison, used under a Creative Commons Attribution-ShareAlike license: http://creativecommons.org/licenses/by-sa/3.0/
     */
    CIImage clouds = CIImage.fromCGImage(UIImage.fromFile("clouds.jpg").CGImage);

    /**
     * "canon" © 2012 cuatrok77 hernandez, used under a Creative Commons Attribution-ShareAlike license: http://creativecommons.org/licenses/by-sa/3.0/
     */
    CIImage heron = CIImage.fromCGImage(UIImage.fromFile("heron.jpg").CGImage);

    @Override
    public boolean finishedLaunching(UIApplication app, NSDictionary options)
    {
        RootElement root = new RootElement("Effects") {
            new Section () {
                new RootElement ("Color Adjustment"){
                    new Section () {
                        new RootElement ("ColorControls", Demo(ColorControls)),
                        new RootElement ("ColorMatrix", Demo(ColorMatrix)),
                        new RootElement ("ExposureAdjust", Demo(ExposureAdjust)),
                        new RootElement ("GammaAdjust", Demo(GammaAdjust)),
                        new RootElement ("HueAdjust", Demo(HueAdjust)),
                        new RootElement ("TemperatureAndTint", Demo(TemperatureAndTint)),
                        new RootElement ("ToneCurve", Demo(ToneCurve)),
                        new RootElement ("Vibrance", Demo(Vibrance)),
                        new RootElement ("WhitePointAdjust", Demo(WhitePointAdjust))
                    }
                },
                new RootElement ("Color Effect"){
                    new Section () {
                        new RootElement ("ColorCube", Demo(ColorCube)),
                        new RootElement ("ColorInvert", Demo(ColorInvert)),
                        new RootElement ("ColorMap", null, Demo(ColorMap)),
                        new RootElement ("ColorMonochrome", Demo(ColorMonochrome)),
                        new RootElement ("ColorPosterize", null, Demo(ColorPosterize)),
                        new RootElement ("FalseColor", Demo(FalseColor)),
                        new RootElement ("MaskToAlpha", null, Demo(MaskToAlpha)),
                        new RootElement ("MaximumComponent", null, Demo(MaximumComponent)),
                        new RootElement ("MinimumComponent", null, Demo(MinimumComponent)),
                        new RootElement ("SepiaTone", Demo(SepiaTone)),
                        new RootElement ("Vignete", null, Demo(Vignette))
                    }
                },
                new RootElement ("Composite Operation"){
                    new Section () {
                        new RootElement ("AdditionCompositing", Demo (AdditionCompositing)),
                        new RootElement ("ColorBlendMode", Demo (ColorBlendMode)),
                        new RootElement ("ColorBurnBlendMode", Demo (ColorBurnBlendMode)),
                        new RootElement ("ColorDodgeBlendMode", Demo (ColorDodgeBlendMode)),
                        new RootElement ("DarkenBlendMode", Demo (DarkenBlendMode)),
                        new RootElement ("DifferenceBlendMode", Demo (DifferenceBlendMode)),
                        new RootElement ("ExclusionBlendMode", Demo (ExclusionBlendMode)),
                        new RootElement ("HardLightBlendMode", Demo (HardLightBlendMode)),
                        new RootElement ("HueBlendMode", Demo (HueBlendMode)),
                        new RootElement ("LightenBlendMode", Demo (LightenBlendMode)),
                        new RootElement ("LuminosityBlendMode", Demo (LuminosityBlendMode)),
                        new RootElement ("MaximumCompositing", Demo (MaximumCompositing)),
                        new RootElement ("MinimumCompositing", Demo (MinimumCompositing)),
                        new RootElement ("MultiplyBlendMode", Demo (MultiplyBlendMode)),
                        new RootElement ("MultiplyCompositing", Demo (MultiplyCompositing)),
                        new RootElement ("OverlayBlendMode", Demo (OverlayBlendMode)),
                        new RootElement ("SaturationBlendMode", Demo (SaturationBlendMode)),
                        new RootElement ("ScreenBlendMode", Demo (ScreenBlendMode)),
                        new RootElement ("SoftLightBlendMode", Demo (SoftLightBlendMode)),
                        new RootElement ("SourceAtopCompositing", Demo (SourceAtopCompositing)),
                        new RootElement ("SourceInCompositing", Demo(SourceInCompositing)),
                        new RootElement ("SourceOutCompositing", Demo(SourceOutCompositing)),
                        new RootElement ("SourceOverCompositing", Demo (SourceOverCompositing)),
                    }
                },
                new RootElement ("Distortions"){
                    new Section () {
                        new RootElement ("CircleSplashDistortion", null, Demo (CircleSplashDistortion)),
                        new RootElement ("HoleDistortion", null, Demo (HoleDistortion)),
                        new RootElement ("LightTunnel", null, Demo (LightTunel)),
                        new RootElement ("PinchDistortion", null, Demo (PinchDistortion)),
                        new RootElement ("TwirlDistortion", null, Demo (TwirlDistortion)),
                        new RootElement ("VortexDistortion", null, Demo (VortexDistortion))
                    }
                },
                new RootElement ("Generators"){
                    new Section () {
                        new RootElement ("CheckerboardGenerator", Demo (CheckerboardGenerator)),
                        new RootElement ("ConstantColorGenerator", Demo (ConstantColorGenerator)),
                        new RootElement ("RandomGenerator", null, Demo (RandomGenerator)),
                        new RootElement ("StarShineGenerator", null, Demo (StarShineGenerator)),
                        new RootElement ("StripesGenerator", Demo (StripesGenerator)),
                    }
                },
                new RootElement ("Geometry Adjust"){
                    new Section () {
                        new RootElement ("AffineTransform", Demo (AffineTransform)),
                        new RootElement ("Crop", Demo (Crop)),
                        new RootElement ("LanczosScaleTransform", null, Demo (LanczosScaleTransform)),
                        new RootElement ("PerspectiveTransform", null, Demo (PerspectiveTransform)),
                        new RootElement ("StraightenFilter", Demo (StraightenFilter)),
                    }
                },
                new RootElement ("Gradients"){
                    new Section () {
                        new RootElement ("GaussianGradient", Demo (GaussianGradient)),
                        new RootElement ("LinearGradient", Demo(LinearGradient)),
                        new RootElement ("RadialGradient", Demo (RadialGradient)),
                    }
                },
                new RootElement ("Halftone Effect") {
                    new Section () {
                        new RootElement ("CircularScreen", null, Demo (CircularScreen)),
                        new RootElement ("DotScreen", null, Demo (DotScreen)),
                        new RootElement ("HatchedScreen", null, Demo (HatchedScreen)),
                        new RootElement ("LineScreen", null, Demo (LineScreen))
                    }
                },
                new RootElement ("Sharpen") {
                    new Section () {
                        new RootElement ("SharpenLuminance", null, Demo (SharpenLuminance)),
                        new RootElement ("UnsharpMask", null, Demo (UnsharpMask)),
                    }
                },
                new RootElement ("Stylize"){
                    new Section () {
                        new RootElement ("BlendWithMask", null, Demo (BlendWithMask)),
                        new RootElement ("Bloom", null, Demo (Bloom)),
                        new RootElement ("Gloom", null, Demo (Gloom)),
                        new RootElement ("HighlightShadowAdjust", Demo (HighlightShadowAdjust)),
                        new RootElement ("Pixellate", null, Demo (Pixellate)),
                    }
                },
                new RootElement ("Tile Effect"){
                    new Section () {
                        new RootElement ("AffineClamp", null, Demo (AffineClamp)),
                        new RootElement ("AffineTile", null, Demo (AffineTile)),
                        new RootElement ("EightfoldReflectedTile", null, Demo (EightfoldReflectedTile)),
                        new RootElement ("FourfoldReflectedTile", null, Demo (FourfoldReflectedTile)),
                        new RootElement ("FourfoldRotatedTile", null, Demo (FourfoldRotatedTile)),
                        new RootElement ("GlideReflectedTile", null, Demo (GlideReflectedTile)),
                        new RootElement ("PerspectiveTile", null, Demo (PerspectiveTile)),
                        new RootElement ("SixfoldReflectedTile", null, Demo (SixfoldReflectedTile)),
                        new RootElement ("SixfoldRotatedTile", null, Demo (SixfoldRotatedTile)),
                        new RootElement ("TriangleKaleidoscope", null, Demo (TriangleKaleidoscope)),
                        new RootElement ("TwelvefoldReflectedTile", null, Demo (TwelvefoldReflectedTile))
                    }
                },
                new RootElement ("Transition"){
                    new Section () {
                        new RootElement ("BarsSwipeTransition", null, Demo (BarsSwipeTransition)),
                        new RootElement ("CopyMachineTransition", null, Demo (CopyMachineTransition)),
                        new RootElement ("DissolveTransition", null, Demo (DissolveTransition)),
                        new RootElement ("FlashTransition", null, Demo (FlashTransition)),
                        new RootElement ("ModTransition", null, Demo (ModTransition)),
                        new RootElement ("SwipeTransition", null, Demo (SwipeTransition))
                    }
                },
                //new RootElement("Rebase Test Images", RebaseTestImages()),
                //new RootElement("Test Filters", TestView())
            }
        };

        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        window.setRootViewController(new UINavigationController(
                new DialogViewController(root)));
        window.makeKeyAndVisible();

        return true;
    }

    /**
     * Utility function used by pure-output generation filters
     */
    public CIImage crop(CIFilter input)
    {
        return new CICrop (
            /*image =*/ input.outputImage,
            /*rectangle =*/ new CIVector (0, 0, window.getBounds().width,
                    window.getBounds().height)
        ).outputImage;
    }

    public UIViewController demo(Method<CIImage> makeDemo)
    {
        UIViewController v = new UIViewController ();
        UIImageView imageView = new UIImageView (v.getView().getBounds());
        v.getView().addSubview(imageView);

        CIImage output = makeDemo ();
        CIContext context = CIContext.fromOptions (null);
        CGImage result = context.createCGImage (output, output.Extent);
        imageView.setImage(UIImage.fromImage(result));
        return v;
    }

    public UIViewController testView()
    {
        // Create a view with a Button to run the tests and a text view
        //  for the results.
        UIViewController vc = new UIViewController();

        UIButton btn = new UIButton(makeRect(0, 0, 100, 40));
        btn.setTitle("Run Tests", UIControlState.NORMAL);
        btn.setBackgroundColor(UIColor.WHITE);
        btn.setTitleColor(UIColor.BLACK, UIControlState.NORMAL);

        UITextView textResults = new UITextView(makeRect(0, 50, vc.getView().getBounds().width, 40));
        textResults.setText("");
        textResults.setHidden(true);

        // Setup test here
        btn.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                System.out.println("Running Tests...");
                textResults.setText("Tests Running");
                btn.setEnabled(false);

                textResults.setNeedsDisplay();
                btn.setNeedsDisplay();

                try
                {
                    List<TestResult> results = runTests();

                    List<TestResult> failed = new ArrayList<TestResult>();
                    for (TestResult r : results) {
                        if (!r.passed) {
                            failed.add(r);
                        }
                    }

                    textResults.setText(failed.size() == 0 ? "All Filters Passed" : "These filters failed " + String.join(Environment.newLine, failed.select(r.filterName)));
                    textResults.setHidden(false);
                }
                finally
                {
                    btn.setEnabled(true);
                }
            }
        }, UIcontrolEvent.TouchUpInside);

        vc.getView().addSubviews(btn, textResults);

        return vc;
    }

    private static class TestResult
    {
        public boolean passed;
        public String filterName;
    }

    List<TestResult> runTests()
    {
        Map filters = createFilterDictionary();
        List<TestResult> resultList = new ArrayList<TestResult>();

        for (MapEntry filter : filters.entrySet())
        {
            System.out.println("Testing Filter " + filter.getKey());

            // Run the Filter
            var view = filter.getValue();

            // Capture the Ouput as an Image
            var image = captureView(view.getView());
            CGImage cgImage = image.CGImage;

            // Get the Image data for the current Image
            byte[] testRawData = new byte[cgImage.width * cgImage.height * 4];
            var testColorSpace = CGColorSpace.createDeviceRGB();

            CGBitmapContext testCGContext = new CGBitmapContext(testRawData, cgImage.width, cgImage.height, 8, cgImage.bytesPerRow, testColorSpace, CGImageAlphaInfo.PREMULTIPLIED_LAST);
            testCGContext.drawImage(makeRect(0, 0, cgImage.width, cgImage.height), cgImage);

            // Get the base image
            var baseImage = getTestImage(filter.getKey());

            // Get the image data for the base image.
            byte[] baseRawData = new byte[baseImage.width * baseImage.height * 4];
            var baseColorSpace = CGColorSpace.createDeviceRGB();

            CGBitmapContext baseCGContext = new CGBitmapContext(baseRawData, baseImage.width, baseImage.height, 8, baseImage.bytesPerRow, baseColorSpace, CGImageAlphaInfo.PREMULTIPLIED_LAST);
            baseCGContext.drawImage(makeRect(0, 0, baseImage.width, baseImage.height), baseImage);

            // Compare each Pixel
            boolean wasMismatch = false;
            for(var i = 0; i < baseRawData.length; i++)
            {
                if(testRawData[i] != baseRawData[i])
                {
                    wasMismatch = true;
                    resultList.add(new TestResult(/*filterName =*/ filter.getKey(), /*pass =*/ false));
                    break;
                }
            }

            if(!wasMismatch) {
                resultList.add(new TestResult(/*filterName =*/ filter.getKey(), /*pass =*/ true));
            }
        }

        return resultList;
    }

    CGImage getTestImage(String imageName)
    {
        UIImage image = UIImage.fromFile(imagePath(imageName));
        return image.CGImage;
    }

    private UIViewController rebaseTestImages()
    {
        Map filterList = createFilterDictionary();
        UIViewController view = new UIViewController();

        CGFrame txtBounds = view.getView().getBounds();
        int boundsHeight = 20;
        txtBounds.height = boundsHeight;

        UITextView text = new UITextView(txtBounds);
        text.setText("Rebasing Images");
        text.setHidden(true);
        view.getView().addSubview(text);

        CGFrame btnBounds = view.getView().getBounds();
        btnBounds.origin.y = boundsHeight;
        btnBounds.height = boundsHeight;

        UIButton btn = new UIButton(btnBounds);
        btn.setBackgroundColor(UIColor.BLACK);
        btn.setTitleColor(UIColor.WHITE, UIControlState.NORMAL);
        btn.setTitle("Rebase", UIControlState.NORMAL);

        btn.addTarget(new EventListener() {

            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                System.out.println("Rebasing Images");
                text.setText("Rebasing Images");
                text.setHidden(false);

                // For each ViewController, Display it, take a screen shot and then, save it
                for (MapEntry filter : filterList)
                {
                    System.out.println("Rebasing Filter " + filter.getKey());
                    view = filter.getValue();

                    // Display the filter
                    //window.setRootViewController(view);

                    // Get a screenshot
                    var image = captureView(view.getView());

                    // Save the screenshot.
                    NSError err;
                    File directory = imageDirectory();
                    File fileName = imagePath(filter.getKey());

                    if(!directory.exists()) {
                        directory.mkdirs();
                    }

                    if (Runtime.arch == Arch.SIMULATOR) {
                        if(fileName.exists()) {
                            fileName.delete();
                        }

                        image.asPNG().save(fileName, NSDataWritingOptions.FILE_PROTECTION_NONE, out err);

                        if(err != null) {
                            System.out.println("Could not write image File. " + Environment.newLine + err.getLocalizedDescription());
                        }
                    }
                }

                if (Runtime.Arch == Arch.DEVICE) {
                    System.out.println("File cannnot be updated on device (only on the simulator)");
                }

                text.setText("Done");
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);

        view.getView().addSubview(btn);
        return view;
    }

    String imagePath(String imageName)
    {
        File fileName = new File(imageDirectory(), imageName);
        fileName = File.changeExtension(fileName, ".png");

        return fileName;
    }

    String imageDirectory()
    {
        File directory = new File(File.getCurrentDirectory(), "TestImages");
        return directory;
    }

    UIImage captureView(UIView view)
    {
        CGRect rect = UIScreen.getMainScreen().getBounds();
        UIGraphics.beginImageContext(rect.size);

        CGContext context = UIGraphics.getCurrentContext();
        view.getLayer().renderInContext(context);
        UIImage img = UIGraphics.getImageFromCurrentImageContext();

        UIGraphics.endImageContext();
        return img;
    }

    private Map<String, Func<UIViewController>> createFilterDictionary()
    {
        Map<String, Func<UIViewController>> dictionary = new HashMap<String, Func<UIViewController>>();
        {
            dictionary.put("ColorControls", Demo (ColorControls));
            dictionary.put("ColorMatrix", Demo (ColorMatrix));
            dictionary.put("ExposureAdjust", Demo (ExposureAdjust));
            dictionary.put("GammaAdjust", Demo (GammaAdjust));
            dictionary.put("HueAdjust", Demo (HueAdjust));
            dictionary.put("TemperatureAndTint", Demo (TemperatureAndTint));
            dictionary.put("ToneCurve", Demo (ToneCurve));
            dictionary.put("Vibrance", Demo (Vibrance));
            dictionary.put("WhitePointAdjust", Demo(WhitePointAdjust));
            //dictionary.put("ColorCube", Demo (ColorCube));
            dictionary.put("ColorInvert", Demo (ColorInvert));
            dictionary.put("ColorMonochrome", Demo (ColorMonochrome));
            dictionary.put("FalseColor", Demo (FalseColor));
            dictionary.put("SepiaTone", Demo (SepiaTone));
            dictionary.put("AdditionCompositing", Demo (AdditionCompositing));
            dictionary.put("ColorBlendMode", Demo (ColorBlendMode));
            dictionary.put("ColorBurnBlendMode", Demo (ColorBurnBlendMode));
            dictionary.put("ColorDodgeBlendMode", Demo (ColorDodgeBlendMode));
            dictionary.put("DarkenBlendMode", Demo (DarkenBlendMode));
            dictionary.put("DifferenceBlendMode", Demo (DifferenceBlendMode));
            dictionary.put("ExclusionBlendMode", Demo (ExclusionBlendMode));
            dictionary.put("HardLightBlendMode", Demo (HardLightBlendMode));
            dictionary.put("HueBlendMode", Demo (HueBlendMode));
            dictionary.put("LightenBlendMode", Demo (LightenBlendMode));
            dictionary.put("LuminosityBlendMode", Demo (LuminosityBlendMode));
            dictionary.put("MaximumCompositing", Demo (MaximumCompositing));
            dictionary.put("MinimumCompositing", Demo (MinimumCompositing));
            dictionary.put("MultiplyCompositing", Demo (MultiplyCompositing));
            dictionary.put("MultiplyBlendMode", Demo (MultiplyBlendMode));
            dictionary.put("OverlayBlendMode", Demo (OverlayBlendMode));
            dictionary.put("SaturationBlendMode", Demo (SaturationBlendMode));
            dictionary.put("ScreenBlendMode", Demo (ScreenBlendMode));
            dictionary.put("SoftLightBlendMode", Demo (SoftLightBlendMode));
            dictionary.put("SourceAtopCompositing", Demo (SourceAtopCompositing));
            dictionary.put("SourceInCompositing", Demo(SourceInCompositing));
            dictionary.put("SourceOutCompositing", Demo(SourceOutCompositing));
            dictionary.put("SourceOverCompositing", Demo (SourceOverCompositing));
            dictionary.put("CheckerboardGenerator", Demo (CheckerboardGenerator));
            dictionary.put("ConstantColorGenerator", Demo (ConstantColorGenerator));
            dictionary.put("StripesGenerator", Demo (StripesGenerator));
            dictionary.put("AffineTransform", Demo (AffineTransform));
            dictionary.put("Crop", Demo (Crop));
            dictionary.put("StraightenFilter", Demo (StraightenFilter));
            dictionary.put("GaussianGradient", Demo (GaussianGradient));
            dictionary.put("LinearGradient", Demo(LinearGradient));
            dictionary.put("RadialGradient", Demo (RadialGradient));
            dictionary.put("HighlightShadowAdjust", Demo (HighlightShadowAdjust));
            dictionary.put("Vignette", Demo (Vignette));

            //dictionary.put("RandomGenerator", Demo (RandomGenerator));
            dictionary.put("StarShineGenerator", Demo (StarShineGenerator));
            dictionary.put("LanczosScaleTransform", Demo (LanczosScaleTransform));
            dictionary.put("PerspectiveTransform", Demo (PerspectiveTransform));
            dictionary.put("CircularScreen", Demo (CircularScreen));
            dictionary.put("DotScreen", Demo (DotScreen));
            dictionary.put("HatchedScreen", Demo (HatchedScreen));
            dictionary.put("LineScreen", Demo (LineScreen));
            dictionary.put("SharpenLuminance", Demo (SharpenLuminance));
            dictionary.put("UnsharpMask", Demo (UnsharpMask));
            dictionary.put("BlendWithMask", Demo (BlendWithMask));
            dictionary.put("Bloom", Demo (Bloom));
            dictionary.put("Gloom", Demo (Gloom));
            dictionary.put("Pixellate", Demo (Pixellate));
            dictionary.put("AffineClamp", Demo (AffineClamp));
            dictionary.put("AffineTile", Demo (AffineTile));
            dictionary.put("EightfoldReflectedTile", Demo (EightfoldReflectedTile));
            dictionary.put("FourfoldReflectedTile", Demo (FourfoldReflectedTile));
            dictionary.put("FourfoldRotatedTile", Demo (FourfoldRotatedTile));
            dictionary.put("GlideReflectedTile", Demo (GlideReflectedTile));
            dictionary.put("PerspectiveTile", Demo (PerspectiveTile));
            dictionary.put("SixfoldReflectedTile", Demo (SixfoldReflectedTile));
            dictionary.put("SixfoldRotatedTile", Demo (SixfoldRotatedTile));
            dictionary.put("TriangleKaleidoscope", Demo (TriangleKaleidoscope));
            dictionary.put("TwelvefoldReflectedTile", Demo (TwelvefoldReflectedTile));
            dictionary.put("BarsSwipeTransition", Demo (BarsSwipeTransition));
            dictionary.put("CopyMachineTransition", Demo (CopyMachineTransition));
            dictionary.put("DissolveTransition", Demo (DissolveTransition));
            dictionary.put("FlashTransition", Demo (FlashTransition));
            dictionary.put("ModTransition", Demo (ModTransition));
            dictionary.put("SwipeTransition", Demo (SwipeTransition));
        }

        return dictionary;
    }

    /**
     * Multiplies source color values and adds a bias factor to each color component.
     */
    @Filter
    public CIImage colorMatrix()
    {
        CIVector rVector = new CIVector (.5F, 0F, 0F); // Multiple the Red Values by .5 (s.r = dot(s, rVector))
        CIVector gVector = new CIVector (0F, 1.5F, 0F); // Multiple the Green Vector by 1.5 (s.g = dot(s, gVector))
        CIVector bVector = new CIVector (0F, 0F, .75F); // Multiple the Blue Vectoer by .75 (s.b = dot(s, bVector))
        CIVector aVector = new CIVector (0F, 0F, 0F, 1.25F); // Multiple the Alpha values by 1.25 (s.a = dot(s, bVector))
        CIVector biasVector = new CIVector (0, 1, 0, 0); // A Bias to be Added to each Color Vector (s = s + bias)

        CIColorMatrix colorMatrix = new CIColorMatrix ();
        {
            Image = flower;
            RVector = rVector;
            GVector = gVector;
            BVector = bVector;
            AVector = aVector;
            BiasVector = biasVector;
        }

        return colorMatrix.getOutputImage();
    }

    /**
     * Adjusts saturation, brightness, and contrast values.
     */
    @Filter
    public CIImage colorControls ()
    {
        CIColorControls colorCtrls = new CIColorControls ();
        {
            Image = flower;
            Brightness = .5F; // Min: 0 Max: 2
            Saturation = 1.2F; // Min: -1 Max: 1
            Contrast = 3.1F; // Min: 0 Max: 4
        };

        return colorCtrls.getOutputImage();
    }

    /**
     * Changes the overall hue, or tint, of the source pixels.
     */
    @Filter
    public CIImage hueAdjust()
    {
        CIHueAdjust hueAdjust = new CIHueAdjust();
        {
            Image = flower;
            Angle = 1F; // Default is 0
        }

        return hueAdjust.getOutputImage();
    }

    /**
     * Adapts the reference white point for an image.
     */
    @Filter
    public CIImage temperatureAndTint()
    {
        CITemperatureAndTint temperatureAdjust = new CITemperatureAndTint();
        {
            Image = flower;
            Neutral = new CIVector(6500, 0); // Default [6500, 0]
            TargetNeutral = new CIVector(4000, 0); // Default [6500, 0]
        }

        return temperatureAdjust.getOutputImage();
    }

    /**
     * Adjusts tone response of the R, G, and B channels of an image.
     */
    @Filter
    public CIImage toneCurve()
    {
        CIVector point0 = new CIVector(0,0); // Default [0 0]
        CIVector point1 = new CIVector(.1F, .5F); // Default [.25 .25]
        CIVector point2 = new CIVector(.3F, .15F); // Default [.3 .15]
        CIVector point3 = new CIVector(.6F, .6F); // Default [.75 .75]
        CIVector point4 = new CIVector(1.1F, 1F); // Default [1 1]

        CIToneCurve toneCurve = new CIToneCurve();
        {
            Image = flower;
            Point0 = point0;
            Point1 = point1;
            Point2 = point2;
            Point3 = point3;
            Point4 = point4;
        }

        return toneCurve.getOutputImage();
    }

    /**
     * Adjusts the saturation of an image while keeping pleasing skin tones.
     */
    @Filter
    public CIImage vibrance()
    {
        CIVibrance vibrance = new CIVibrance();
        {
            Image = flower;
            Amount = -1.0F; // Default 0
        }

        return vibrance.getOutputImage();
    }

    /**
     * Add a reduction of an image's brightness or saturation at the periphery compared to the image center.
     */
    @Filter
    public CIImage vignette()
    {
        CIVignette vignette = new CIVignette();
        {
            Image = flower;
            Intensity = 2F;
            Radius = 10F;
        };

        return vignette.getOutputImage();
    }

    /**
     * Adjusts the reference white point for an image and maps all colors in the source using the new reference.
     */
    public CIImage whitePointAdjust()
    {
        var whitePointAdjust = new CIWhitePointAdjust();
        {
            Image = flower;
            Color = new CIColor(new CGColor(255F, 0, 187F)); // A Magenta Color
        };

        return whitePointAdjust.getOutputImage();
    }

    /**
     * Applies a Sepia Filter to an image
     */
    @Filter
    public CIImage sepiaTone ()
    {
        CISepiaTone sepia = new CISepiaTone ();
        {
            Image = flower;
            Intensity = .8f;
        }
        return sepia.getOutputImage();
    }

    /**
     * Uses a three-dimensional color table to transform the source image pixels.
     */
    @Filter
    public /*unsafe*/ CIImage colorCube ()
    {
        int size = 64;
        var data = generateCubeData(size);

        CIColorCube cube = new CIColorCube ();
        {
            Image = flower;
            CubeDimension = size;
            CubeData = data;
        }

        return cube.getOutputImage();
    }

    /**
     * Generates the cube data. Based on Objective-C example at
     * https://github.com/vhbit/ColorCubeSample
     * Many thanks to the original author!
     *
     * Original author grants permission to use this sample code
     * https://github.com/vhbit/ColorCubeSample/issues/1
     */
    NSData generateCubeData (int size)
    {
        NSData data = new NSData ();

        float minHueAngle = 0.1f; // modify to see different result
        float maxHueAngle = 0.4f; // modify to see different result
        float centerHueAngle = minHueAngle + (maxHueAngle - minHueAngle)/2.0f;
        float destCenterHueAngle = 1.0f/4.0f; // modify to see different result

        byte [] cubeData = new byte[size*size*size*4];
        float [] rgb = new float[3], hsv = new float[3], newRGB = new float[3];

        uint offset = 0;

        for (int z = 0; z < size; z++)
        {
            rgb[2] = (float) ((double) z) / size; // blue value
            for (int y = 0; y < size; y++)
            {
                rgb[1] = (float) ((double) y) / size; // green value
                for (int x = 0; x < size; x++)
                {
                    rgb[0] = (float) ((double) x) / size; // red value
                    rgbToHSV(rgb, /*ref*/ hsv);

                    if (hsv[0] < minHueAngle || hsv[0] > maxHueAngle) {
                        newRGB = rgb;
                    } else {
                        hsv[0] = destCenterHueAngle + (centerHueAngle - hsv[0]);
                        hsvToRGB(hsv, /*ref*/ newRGB);
                    }

                    cubeData[offset]   = (byte) (newRGB[0] * 255);
                    cubeData[offset+1] = (byte) (newRGB[1] * 255);
                    cubeData[offset+2] = (byte) (newRGB[2] * 255);
                    cubeData[offset+3] = (byte) 255; //1.0;

                    offset += 4;
                }
            }
        }
        return NSData.fromArray(cubeData);
    }

    /**
     * https://github.com/vhbit/ColorCubeSample
     */
    void rgbToHSV(float[] rgb, /*ref*/ float[] hsv)
    {
        float min, max, delta;
        float r = rgb[0], g = rgb[1], b = rgb[2];

        min = Math.min( r, Math.min( g, b ));
        max = Math.max( r, Math.max( g, b ));
        hsv[2] = max;               // v
        delta = max - min;
        if( max != 0 ) {
            hsv[1] = delta / max;       // s
        } else {
            // r = g = b = 0        // s = 0, v is undefined
            hsv[1] = 0;
            hsv[0] = -1;
            return;
        }
        if( r == max ) {
            hsv[0] = ( g - b ) / delta;     // between yellow & magenta
        } else if( g == max ) {
            hsv[0] = 2 + ( b - r ) / delta; // between cyan & yellow
        } else {
            hsv[0] = 4 + ( r - g ) / delta; // between magenta & cyan
        }
        hsv[0] *= 60;               // degrees
        if( hsv[0] < 0 ) {
            hsv[0] += 360;
        }
        hsv[0] /= 360.0f;
    }

    /**
     * https://github.com/vhbit/ColorCubeSample
     */
    void hsvToRGB(float[] hsv, /*ref*/ float[] rgb)
    {
        float C = hsv[2] * hsv[1];
        float HS = (float) hsv[0] * 6.0f;
        float X = (float)C * (1.0f - Math.abs((HS % 2.0f) - 1.0f));

        if (HS >= 0 && HS < 1)
        {
            rgb[0] = C;
            rgb[1] = X;
            rgb[2] = 0;
        }
        else if (HS >= 1 && HS < 2)
        {
            rgb[0] = X;
            rgb[1] = C;
            rgb[2] = 0;
        }
        else if (HS >= 2 && HS < 3)
        {
            rgb[0] = 0;
            rgb[1] = C;
            rgb[2] = X;
        }
        else if (HS >= 3 && HS < 4)
        {
            rgb[0] = 0;
            rgb[1] = X;
            rgb[2] = C;
        }
        else if (HS >= 4 && HS < 5)
        {
            rgb[0] = X;
            rgb[1] = 0;
            rgb[2] = C;
        }
        else if (HS >= 5 && HS < 6)
        {
            rgb[0] = C;
            rgb[1] = 0;
            rgb[2] = X;
        }
        else {
            rgb[0] = 0.0f;
            rgb[1] = 0.0f;
            rgb[2] = 0.0f;
        }


        float m = hsv[2] - C;
        rgb[0] += m;
        rgb[1] += m;
        rgb[2] += m;
    }

    /**
     * Inverts the colors in an image.
     */
    public CIImage colorInvert ()
    {
        CIColorInvert invert = new CIColorInvert ();
        {
            Image = flower;
        }

        return invert.getOutputImage();
    }

    CIImage colorMap ()
    {
        CIColorMap map = new CIColorMap ();
        {
            Image = flower;
            GradientImage = flower;
        }

        return map.getOutputImage();
    }

    /**
     * Remaps colors so they fall within shades of a single color.
     */
    @Filter
    public CIImage colorMonochrome ()
    {
        CIColor inputColor = new CIColor (new CGColor (100F, 0F, 100F)); // Make it Purple R + B = Purple
        CIColorMonochrome monoChrome = new CIColorMonochrome ()
        {
            Image = flower;
            Color = inputColor;
            Intensity = 1F; // Default 1
        }

        return monoChrome.getOutputImage();
    }

    CIImage colorPosterize ()
    {
        CIColorPosterize posterize = new CIColorPosterize ();
        {
            Image = flower;
            Levels = 8;
        }

        return posterize.getOutputImage();
    }

    /**
     * Maps luminance to a color ramp of two colors.
     */
    @Filter
    public CIImage falseColor ()
    {
        CIColor color0 = new CIColor (new CGColor (255F, 251F, 0F)); // A Yellowish Color
        CIColor color1 = new CIColor (new CGColor (51F, 0F, 255F)); // A Purplish Color
        CIFalseColor falseColor = new CIFalseColor ();
        {
            Image = flower;
            Color0 = color0;
            Color1 = color1;
        }

        return falseColor.getOutputImage();
    }

    CIImage maskToAlpha ()
    {
        CIMaskToAlpha masktoalpha = new CIMaskToAlpha ()
        {
            Image = heron;
        }

        return masktoalpha.getOutputImage();
    }

    CIImage maximumComponent ()
    {
        CIMaximumComponent maximumcomponent = new CIMaximumComponent ();
        {
            Image = flower;
        }

        return maximumcomponent.getOutputImage();
    }

    CIImage minimumComponent ()
    {
        CIMinimumComponent minimumcomponent = new CIMinimumComponent ();
        {
            Image = flower;
        }

        return minimumcomponent.getOutputImage();
    }

    /**
     * Adjusts midtone brightness.
     */
    @Filter
    public CIImage gammaAdjust ()
    {
        CIGammaAdjust gammaAdjust = new CIGammaAdjust ();
        {
            Image = flower;
            Power = 3F; // Default value: 0.75
        }

        return gammaAdjust.getOutputImage();
    }

    /**
     * Generates a gradient that varies from one color to another using a Gaussian distribution.
     */
    @Filter
    public CIImage gaussianGradient ()
    {
        CIVector centerVector = new CIVector (100, 100); // Default is [150 150]
        CIColor color1 = CIColor.fromRgba (1, 0, 1, 1);
        CIColor color0 = CIColor.fromRgba (0, 1, 1, 1);

        CIGaussianGradient gaussGradient = new CIGaussianGradient ();
        {
            Center = centerVector;
            Color0 = color0;
            Color1 = color1;
            Radius = 280f; // Default is 300
        }

        return crop (gaussGradient);
    }

    /**
     * Generates a gradient that varies along a linear axis between two defined endpoints.
     */
    @Filter
    public CIImage linearGradient()
    {
        CIVector point0 = new CIVector(0, 0); // Default [0 0]
        CIVector point1 = new CIVector(250, 250); // Default [200 200]
        CILinearGradient linearGrad = new CILinearGradient();
        {
            Point0 = point0;
            Point1 = point1;
            Color0 = new CIColor (UIColor.RED);
            Color1 = new CIColor (UIColor.BLUE);
        }

        return crop (linearGrad);
    }

    /**
     * Generates a gradient that varies radially between two circles having the same center.
     */
    @Filter
    public CIImage radialGradient()
    {
        CIVector center = new CIVector(100, 100); // Default [150 150]
        CIRadialGradient radGradient = new CIRadialGradient();
        {
            Center = center;
            Radius0 = 10F; // Default 5
            Radius1 = 150F; // Default 100
            Color0 = new CIColor(new CGColor(0, 255F, 0)); // Green
            Color1 = new CIColor(new CGColor(0, 0, 0)); // Black
        }

        return crop (radGradient);
    }

    CIImage circularScreen ()
    {
        CICircularScreen circular_screen = new CICircularScreen ();
        {
            Image = flower;
        }

        return circular_screen.getOutputImage();
    }

    CIImage dotScreen ()
    {
        CIDotScreen dot_screen = new CIDotScreen ();
        {
            Image = flower;
        }

        return dot_screen.getOutputImage();
    }

    CIImage hatchedScreen ()
    {
        var hatched_screen = new CIHatchedScreen ();
        {
            Image = flower;
        }

        return hatched_screen.getOutputImage();
    }

    CIImage lineScreen ()
    {
        CILineScreen line_screen = new CILineScreen ();
        {
            Image = flower;
        }

        return line_screen.getOutputImage();
    }

    CIImage sharpenLuminance ()
    {
        CISharpenLuminance sharpen = new CISharpenLuminance ();
        {
            Image = heron;
        }

        return sharpen.getOutputImage();
    }

    CIImage unsharpMask ()
    {
        CIUnsharpMask sharpen = new CIUnsharpMask ();
        {
            Image = heron;
        }

        return sharpen.getOutputImage();
    }

    /**
     * Applies a crop to an image.
     */
    @Filter
    public CIImage crop ()
    {
        CICrop crop = new CICrop ();
        {
            Image = flower;
            Rectangle = new CIVector (0, 0, 300, 300);
        };
        return crop.getOutputImage();
    }

    /**
     * Applies an affine transform to an image
     */
    @Filter
    public CIImage affineTransform ()
    {
        // Create an AffineTransform to Skew the Image
        CGAffineTransform transform = new CGAffineTransform (1F, .5F, .5F, 1F, 0F, 0F);

        CIAffineTransform affineTransform = new CIAffineTransform ();
        {
            Image = flower;
            Transform = transform;
        }

        return affineTransform.getOutputImage();
    }

    /**
     * Adjusts the exposure setting for an image similar to the way you control exposure for a camera when you change the F-stop.
     */
    @Filter
    public CIImage exposureAdjust ()
    {
        CIExposureAdjust exposureAdjust = new CIExposureAdjust ();
        {
            Image = flower;
            EV = 2F; // Default value: 0.50 Minimum: 0.00 Maximum: 0.00 Slider minimum: -10.00 Slider maximum: 10.00 Identity: 0.00
        }

        return exposureAdjust.getOutputImage();
    }

    CIImage lanczosScaleTransform ()
    {
        CILanczosScaleTransform lanczos_scale_transform = new CILanczosScaleTransform ();
        {
            Image = heron;
        }

        return lanczos_scale_transform.getOutputImage();
    }

    CIImage perspectiveTransform ()
    {
        CIPerspectiveTransform perspective_transform = new CIPerspectiveTransform ();
        {
            Image = heron;
        }

        return perspective_transform.getOutputImage();
    }

    /**
     * Rotates the source image by the specified angle in radians.
     */
    @Filter
    public CIImage straightenFilter()
    {
        CIStraightenFilter straightFilter = new CIStraightenFilter();
        {
            Image = heron;
            Angle = Math.PI / 4.0; // Change by 45 degrees = pi/4 Radians.
        };

        return straightFilter.getOutputImage();
    }

    /**
     * Adds color components to achieve a brightening effect.
     */
    @Filter
    public CIImage additionCompositing ()
    {
        CIAdditionCompositing addComp = new CIAdditionCompositing ();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return addComp.getOutputImage();
    }

    /**
     * Uses the luminance values of the background with the hue and saturation values of the source image.
     */
    @Filter
    public CIImage colorBlendMode ()
    {
        CIColorBlendMode colorBlend = new CIColorBlendMode ();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return colorBlend.getOutputImage();
    }

    /**
     * Darkens the background image samples to reflect the source image samples.
     */
    @Filter
    public CIImage colorBurnBlendMode()
    {
        CIColorBurnBlendMode colorBurn = new CIColorBurnBlendMode();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return colorBurn.getOutputImage();
    }

    /**
     * Brightens the background image samples to reflect the source image samples.
     */
    public CIImage colorDodgeBlendMode ()
    {
        CIColorDodgeBlendMode colorDodgeBlend = new CIColorDodgeBlendMode ();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return colorDodgeBlend.getOutputImage();
    }

    /**
     * Creates composite image samples by choosing the darker samples (from either the source image or the background).
     */
    @Filter
    public CIImage darkenBlendMode()
    {
        CIDarkenBlendMode darkenBlend = new CIDarkenBlendMode();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return darkenBlend.getOutputImage();
    }

    /**
     * Subtracts either the source image sample color from the background image sample color, or the reverse, depending on which sample has the greater brightness value.
     */
    @Filter
    public CIImage differenceBlendMode ()
    {
        CIDifferenceBlendMode differenceBlend = new CIDifferenceBlendMode ();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return differenceBlend.getOutputImage();
    }

    /**
     * Produces an effect similar to that produced by the CIDifferenceBlendMode filter but with lower contrast.
     */
    @Filter
    public CIImage exclusionBlendMode ()
    {
        CIExclusionBlendMode exclusionBlend = new CIExclusionBlendMode ();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return exclusionBlend.getOutputImage();
    }

    /**
     * Either multiplies or screens colors, depending on the source image sample color.
     */
    @Filter
    public CIImage hardLightBlendMode ()
    {
        CIHardLightBlendMode hardLightBlend = new CIHardLightBlendMode ();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return hardLightBlend.getOutputImage();
    }

    /**
     * Uses the luminance and saturation values of the background with the hue of the source image.
     */
    @Filter
    public CIImage hueBlendMode()
    {
        CIHueBlendMode hueBlend = new CIHueBlendMode();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return hueBlend.getOutputImage();
    }

    /**
     * Creates composite image samples by choosing the lighter samples (either from the source image or the background).
     */
    @Filter
    public CIImage lightenBlendMode()
    {
        CILightenBlendMode lightenBlend = new CILightenBlendMode();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return lightenBlend.getOutputImage();
    }

    /**
     * Uses the hue and saturation of the background with the luminance of the source image.
     */
    @Filter
    public CIImage luminosityBlendMode()
    {
        CILuminosityBlendMode luminosityBlend = new CILuminosityBlendMode();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return luminosityBlend.getOutputImage();
    }

    /**
     * Computes the maximum value, by color component, of two input images and creates an output image using the maximum values.
     */
    @Filter
    public CIImage maximumCompositing()
    {
        CIMaximumCompositing maxComposite = new CIMaximumCompositing();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return maxComposite.getOutputImage();
    }

    /**
     * Computes the minimum value, by color component, of two input images and creates an output image using the minimum values.
     */
    @Filter
    public CIImage minimumCompositing()
    {
        CIMinimumCompositing minComposite = new CIMinimumCompositing();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return minComposite.getOutputImage();
    }

    /**
     * Multiplies the source image samples with the background image samples.
     */
    @Filter
    public CIImage multiplyBlendMode()
    {
        CIMultiplyBlendMode multiBlend = new CIMultiplyBlendMode();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return multiBlend.getOutputImage();
    }

    /**
     * Multiplies the color component of two input images and creates an output image using the multiplied values.
     */
    @Filter
    public CIImage multiplyCompositing()
    {
        CIMultiplyCompositing multiComposite = new CIMultiplyCompositing();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return multiComposite.getOutputImage();
    }

    /**
     * Overlays the blend mode.
     */
    @Filter
    public CIImage overlayBlendMode()
    {
        CIOverlayBlendMode overlayBlend = new CIOverlayBlendMode();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return overlayBlend.getOutputImage();
    }

    /**
     * Saturations the blend mode.
     */
    @Filter
    public CIImage saturationBlendMode()
    {
        CISaturationBlendMode saturationBlend = new CISaturationBlendMode();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return saturationBlend.getOutputImage();
    }

    /**
     * Multiplies the inverse of the source image samples with the inverse of the background image samples.
     */
    @Filter
    public CIImage screenBlendMode()
    {
        CIScreenBlendMode screenBlend = new CIScreenBlendMode();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return screenBlend.getOutputImage();
    }

    /**
     * Either darkens or lightens colors, depending on the source image sample color.
     */
    @Filter
    public CIImage softLightBlendMode()
    {
        CISoftLightBlendMode softLightBlend = new CISoftLightBlendMode();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return softLightBlend.getOutputImage();
    }

    /**
     * Places the source image over the background image, then uses the luminance of the background image to determine what to show.
     */
    @Filter
    public CIImage sourceAtopCompositing()
    {
        CISourceAtopCompositing sourceAtopComposite = new CISourceAtopCompositing();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return sourceAtopComposite.getOutputImage();
    }

    /**
     * Uses the second image to define what to leave in the source image, effectively cropping the image.
     */
    @Filter
    public CIImage sourceInCompositing()
    {
        CISourceInCompositing sourceComposite = new CISourceInCompositing();
        {
            Image = clouds; // This image will be Cropped
            BackgroundImage = heron;
        }

        return sourceComposite.getOutputImage();
    }

    /**
     * Uses the second image to define what to take out of the first image.
     */
    @Filter
    public CIImage sourceOutCompositing()
    {
        CISourceOutCompositing sourceOutComposite = new CISourceOutCompositing();
        {
            Image = clouds; // This Image will be Cropped
            BackgroundImage = heron;
        }

        return sourceOutComposite.getOutputImage();
    }

    /**
     * Places the second image over the first.
     */
    @Filter
    public CIImage sourceOverCompositing()
    {
        CISourceOverCompositing sourceOverComposite = new CISourceOverCompositing();
        {
            Image = heron;
            BackgroundImage = clouds;
        }

        return sourceOverComposite.getOutputImage();
    }

    CIImage circleSplashDistortion ()
    {
        CICircleSplashDistortion distortion = new CICircleSplashDistortion ();
        {
            Image = heron;
        }

        return crop (distortion);
    }

    CIImage holeDistortion ()
    {
        CIHoleDistortion distortion = new CIHoleDistortion ();
        {
            Image = heron;
            Radius = 85;
        }

        return distortion.getOutputImage();
    }

    CIImage lightTunel ()
    {
        CILightTunnel lighttunel = new CILightTunnel ();
        {
            Image = flower;
        }

        return crop (lighttunel);
    }

    CIImage pinchDistortion ()
    {
        CIPinchDistortion pinchdistortion = new CIPinchDistortion ();
        {
            Image = flower;
        }

        return pinchdistortion.getOutputImage();
    }

    CIImage twirlDistortion ()
    {
        CITwirlDistortion twirldistortion = new CITwirlDistortion ();
        {
            Image = flower;
        }

        return twirldistortion.getOutputImage();
    }

    CIImage vortexDistortion ()
    {
        CIVortexDistortion vortexdistortion = new CIVortexDistortion ();
        {
            Image = heron;
        }

        return vortexdistortion.getOutputImage();
    }

    /**
     * Generates a checkerboard pattern.
     */
    @Filter
    public CIImage checkerboardGenerator ()
    {
        // Color 1
        var c0 = CIColor.fromRgb (1, 0, 0);
        var c1 = CIColor.fromRgb (0, 1, 0);
        CICheckerboardGenerator checker = new CICheckerboardGenerator ();
        {
            Color0 = c0;
            Color1 = c1;
            Center = new CIVector (new float[] { 10 , 10 }); // Default [80 80]
            Sharpness = 1F; // Default 1
        };

        return crop (checker);
    }

    /**
     * Generates a solid color.
     */
    @Filter
    public CIImage constantColorGenerator ()
    {
        CIConstantColorGenerator colorGen = new CIConstantColorGenerator ();
        {
            Color = new CIColor (UIColor.Blue);
        }

        return crop (colorGen);
    }

    CIImage randomGenerator ()
    {
        CIRandomGenerator random = new CIRandomGenerator ();
        return crop (random);
    }

    CIImage starShineGenerator ()
    {
        CIStarShineGenerator generator = new CIStarShineGenerator ();
        {
            Radius = 20;
        }

        return crop (generator);
    }

    /**
     * Generates a stripe pattern.
     */
    @Filter
    public CIImage stripesGenerator()
    {
        CIStripesGenerator stripeGen = new CIStripesGenerator();
        {
            Center = new CIVector(150, 100); // Default [150 150]
            Color0 = new CIColor (UIColor.Blue);
            Color1 = new CIColor (UIColor.Red);
            Width = 10;
        }

        return crop (stripeGen);
    }

    CIImage blendWithMask ()
    {
        CIBlendWithMask blend_with_mask = new CIBlendWithMask ();
        {
            Image = heron;
            BackgroundImage = clouds;
            Mask = RandomGenerator ();
        }

        return blend_with_mask.getOutputImage();
    }

    CIImage bloom ()
    {
        CIBloom bloom = new CIBloom ();
        {
            Image = flower;
        }

        return bloom.getOutputImage();
    }

    CIImage gloom ()
    {
        CIGloom gloom = new CIGloom ();
        {
            Image = flower;
        }

        return gloom.getOutputImage();
    }

    /**
     * Adjust the tonal mapping of an image while preserving spatial detail.
     */
    @Filter
    public CIImage highlightShadowAdjust ()
    {
        CIHighlightShadowAdjust shadowAdjust = new CIHighlightShadowAdjust ();
        {
            Image = flower;
            HighlightAmount = .75F; // Default is 1
            ShadowAmount = 1.5F; // Default is 0
        }

        return shadowAdjust.getOutputImage();
    }

    CIImage pixellate ()
    {
        CIGloom pixellate = new CIGloom ();
        {
            Image = flower;
        }

        return pixellate.getOutputImage();
    }

    CIImage affineClamp ()
    {
        CIAffineClamp affine_clamp = new CIAffineClamp ();
        {
            Image = flower;
        }

        return crop (affine_clamp);
    }

    CIImage affineTile ()
    {
        CIAffineTile affine_tile = new CIAffineTile ();
        {
            Image = flower;
        };

        return crop (affine_tile);
    }

    CIImage eightfoldReflectedTile ()
    {
        CIEightfoldReflectedTile tile = new CIEightfoldReflectedTile ();
        {
            Image = flower;
        }

        return crop (tile);
    }

    CIImage fourfoldReflectedTile ()
    {
        CIFourfoldReflectedTile tile = new CIFourfoldReflectedTile ();
        {
            Image = flower;
        }

        return crop (tile);
    }

    CIImage fourfoldRotatedTile ()
    {
        CIFourfoldRotatedTile tile = new CIFourfoldRotatedTile ();
        {
            Image = flower;
        }

        return crop (tile);
    }

    CIImage glideReflectedTile ()
    {
        CIGlideReflectedTile tile = new CIGlideReflectedTile ();
        {
            Image = flower;
        }

        return crop (tile);
    }

    CIImage perspectiveTile ()
    {
        CIPerspectiveTile tile = new CIPerspectiveTile ();
        {
            Image = flower;
        }

        return crop (tile);
    }

    CIImage sixfoldReflectedTile ()
    {
        CISixfoldReflectedTile tile = new CISixfoldReflectedTile ();
        {
            Image = flower;
        }

        return crop (tile);
    }

    CIImage sixfoldRotatedTile ()
    {
        CISixfoldRotatedTile tile = new CISixfoldRotatedTile ();
        {
            Image = flower;
        }

        return crop (tile);
    }

    CIImage triangleKaleidoscope ()
    {
        CITriangleKaleidoscope kaleidoscope = new CITriangleKaleidoscope ();
        {
            Image = heron;
        }

        return crop (kaleidoscope);
    }

    CIImage twelvefoldReflectedTile ()
    {
        CITwelvefoldReflectedTile tile = new CITwelvefoldReflectedTile ();
        {
            Image = flower;
        }

        return crop (tile);
    }

    CIImage barsSwipeTransition ()
    {
        CIBarsSwipeTransition transition = new CIBarsSwipeTransition ();
        {
            Image = heron;
            TargetImage = clouds;
            Time = 0.5f;
        }

        return transition.getOutputImage();
    }

    CIImage copyMachineTransition ()
    {
        CICopyMachineTransition transition = new CICopyMachineTransition ();
        {
            Image = heron;
            TargetImage = clouds;
            Time = 0.5f;
        }

        return transition.getOutputImage();
    }

    CIImage dissolveTransition ()
    {
        CIDissolveTransition transition = new CIDissolveTransition ();
        {
            Image = heron;
            TargetImage = clouds;
            Time = 0.5f;
        }

        return transition.getOutputImage();
    }

    CIImage flashTransition ()
    {
        CIFlashTransition transition = new CIFlashTransition ();
        {
            Image = heron;
            TargetImage = clouds;
            Time = 0.8f;
        }

        return transition.getOutputImage();
    }

    CIImage modTransition ()
    {
        CIModTransition transition = new CIModTransition ();
        {
            Image = heron;
            TargetImage = clouds;
            Time = 0.5f;
        }

        return transition.getOutputImage();
    }

    CIImage swipeTransition ()
    {
        CISwipeTransition transition = new CISwipeTransition ();
        {
            Image = heron;
            TargetImage = clouds;
            Time = 0.8f;
        }

        return transition.getOutputImage();
    }

}
