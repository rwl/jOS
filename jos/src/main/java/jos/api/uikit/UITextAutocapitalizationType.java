package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UITextAutocapitalizationType {
    @Bind("UITextAutocapitalizationTypeNone") None,
    @Bind("UITextAutocapitalizationTypeWords") Words,
    @Bind("UITextAutocapitalizationTypeSentences") Sentences,
    @Bind("UITextAutocapitalizationTypeAllCharacters") AllCharacters;
}
