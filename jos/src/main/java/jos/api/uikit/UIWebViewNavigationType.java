package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIWebViewNavigationType {
    @Bind("UIWebViewNavigationTypeLinkClicked") LINK_CLICKED,
    @Bind("UIWebViewNavigationTypeFormSubmitted") FORM_SUBMITTED,
    @Bind("UIWebViewNavigationTypeBackForward") BACK_FORWARD,
    @Bind("UIWebViewNavigationTypeReload") RELOAD,
    @Bind("UIWebViewNavigationTypeFormResubmitted") FORM_RESUBMITTED,
    @Bind("UIWebViewNavigationTypeOther") OTHER;
}