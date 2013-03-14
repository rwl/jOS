package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UILineBreakMode {
    @Bind("UILineBreakModeWordWrap") WORD_WRAP,
    @Bind("UILineBreakModeCharacterWrap") CHARACTER_WRAP,
    @Bind("UILineBreakModeClip") CLIP,
    @Bind("UILineBreakModeHeadTruncation") HEAD_TRUNCATION,
    @Bind("UILineBreakModeTailTruncation") TAIL_TRUNCATION,
    @Bind("UILineBreakModeMiddleTruncation") MIDDLE_TRUNCATION;
}
