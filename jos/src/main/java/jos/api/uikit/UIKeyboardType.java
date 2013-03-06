package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIKeyboardType {
    @Bind("UIKeyboardTypeDefault") Default,
    @Bind("UIKeyboardTypeASCIICapable") ASCIICapable,
    @Bind("UIKeyboardTypeNumbersAndPunctuation") NumbersAndPunctuation,
    @Bind("UIKeyboardTypeURL") URL,
    @Bind("UIKeyboardTypeNumberPad") NumberPad,
    @Bind("UIKeyboardTypePhonePad") PhonePad,
    @Bind("UIKeyboardTypeNamePhonePad") NamePhonePad,
    @Bind("UIKeyboardTypeEmailAddress") EmailAddress,
    @Bind("UIKeyboardTypeDecimalPad") DecimalPad,
    @Bind("UIKeyboardTypeTwitter") Twitter,
    @Bind("UIKeyboardTypeAlphabet") Alphabet;
}
