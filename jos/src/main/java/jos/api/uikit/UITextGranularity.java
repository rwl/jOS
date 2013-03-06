package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UITextGranularity {
    @Bind("UITextGranularityCharacter") CHARACTER,
    @Bind("UITextGranularityWord") WORD,
    @Bind("UITextGranularitySentence") SENTENCE,
    @Bind("UITextGranularityParagraph") PARAGRAPH,
    @Bind("UITextGranularityLine") LINE,
    @Bind("UITextGranularityDocument") DOCUMENT;
}
