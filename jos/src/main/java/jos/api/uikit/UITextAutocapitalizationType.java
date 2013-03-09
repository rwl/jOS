package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UITextAutocapitalizationType {
    @Bind("UITextAutocapitalizationTypeNone") NONE,
    @Bind("UITextAutocapitalizationTypeWords") WORDS,
    @Bind("UITextAutocapitalizationTypeSentences") SENTENCES,
    @Bind("UITextAutocapitalizationTypeAllCharacters") ALL_CHARACTERS;
}
