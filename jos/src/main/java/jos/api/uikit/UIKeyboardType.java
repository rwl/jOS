package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIKeyboardType {
    @Bind("UIKeyboardTypeDefault") DEFAULT,
    @Bind("UIKeyboardTypeASCIICapable") ASCII_CAPABLE,
    @Bind("UIKeyboardTypeNumbersAndPunctuation") NUMBERS_AND_PUNCTUATION,
    @Bind("UIKeyboardTypeURL") URL,
    @Bind("UIKeyboardTypeNumberPad") NUMBER_PAD,
    @Bind("UIKeyboardTypePhonePad") PHONE_PAD,
    @Bind("UIKeyboardTypeNamePhonePad") NAME_PHONE_PAD,
    @Bind("UIKeyboardTypeEmailAddress") EMAIL_ADDRESS,
    @Bind("UIKeyboardTypeDecimalPad") DECIMAL_PAD,
    @Bind("UIKeyboardTypeTwitter") TWITTER,
    @Bind("UIKeyboardTypeAlphabet") ALPHABET;
}
