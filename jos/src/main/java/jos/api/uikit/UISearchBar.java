package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSDictionary;

import com.google.j2objc.annotations.Appearance;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UISearchBar extends UIView {

    @Export("barStyle")
    public UIBarStyle getBarStyle() {
        throw new RuntimeException();
    }

    @Export("setBarStyle:")
    public void setBarStyle(UIBarStyle value) {
        throw new RuntimeException();
    }

    @Export("delegate")
    public UISearchBarDelegate getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(UISearchBarDelegate value) {
        throw new RuntimeException();
    }

    @Export("text")
    public String getText() {
        throw new RuntimeException();
    }

    @Export("setText:")
    public void setText(String value) {
        throw new RuntimeException();
    }

    @Export("prompt")
    public String getPrompt() {
        throw new RuntimeException();
    }

    @Export("setPrompt:")
    public void setPrompt(String value) {
        throw new RuntimeException();
    }

    @Export("placeholder")
    public String getPlaceholder() {
        throw new RuntimeException();
    }

    @Export("setPlaceholder:")
    public void setPlaceholder(String value) {
        throw new RuntimeException();
    }

    @Export("showsBookmarkButton")
    public boolean getShowsBookmarkButton() {
        throw new RuntimeException();
    }

    @Export("setShowsBookmarkButton:")
    public void setShowsBookmarkButton(boolean value) {
        throw new RuntimeException();
    }

    @Export("showsCancelButton")
    public boolean getShowsCancelButton() {
        throw new RuntimeException();
    }

    @Export("setShowsCancelButton:")
    public void setShowsCancelButton(boolean value) {
        throw new RuntimeException();
    }

    @Export("showsSearchResultsButton")
    public boolean getShowsSearchResultsButton() {
        throw new RuntimeException();
    }

    @Export("setShowsSearchResultsButton:")
    public void setShowsSearchResultsButton(boolean value) {
        throw new RuntimeException();
    }

    @Bind("isSearchResultsButtonSelected")
    @Export("searchResultsButtonSelected")
    public boolean getSearchResultsButtonSelected() {
        throw new RuntimeException();
    }

    @Export("setSearchResultsButtonSelected:")
    public void setSearchResultsButtonSelected(boolean value) {
        throw new RuntimeException();
    }

    @Export("tintColor")
    public UIColor getTintColor() {
        throw new RuntimeException();
    }

    @Export("setTintColor:")
    public void setTintColor(UIColor value) {
        throw new RuntimeException();
    }

    @Bind("isTranslucent")
    @Export("translucent")
    public boolean getTranslucent() {
        throw new RuntimeException();
    }

    @Export("setTranslucent:")
    public void setTranslucent(boolean value) {
        throw new RuntimeException();
    }

    @Export("autocorrectionType")
    public UITextAutocorrectionType getAutocorrectionType() {
        throw new RuntimeException();
    }

    @Export("setAutocorrectionType:")
    public void setAutocorrectionType(UITextAutocorrectionType value) {
        throw new RuntimeException();
    }

    @Export("spellCheckingType")
    public UITextSpellCheckingType getSpellCheckingType() {
        throw new RuntimeException();
    }

    @Export("setSpellCheckingType:")
    public void setSpellCheckingType(UITextSpellCheckingType value) {
        throw new RuntimeException();
    }

    @Export("keyboardType")
    public UIKeyboardType getKeyboardType() {
        throw new RuntimeException();
    }

    @Export("setKeyboardType:")
    public void setKeyboardType(UIKeyboardType value) {
        throw new RuntimeException();
    }

    @Export("scopeButtonTitles")
    public NSArray getScopeButtonTitles() {
        throw new RuntimeException();
    }

    @Export("setScopeButtonTitles:")
    public void setScopeButtonTitles(NSArray value) {
        throw new RuntimeException();
    }

    @Export("selectedScopeButtonIndex")
    public int getSelectedScopeButtonIndex() {
        throw new RuntimeException();
    }

    @Export("setSelectedScopeButtonIndex:")
    public void setSelectedScopeButtonIndex(int value) {
        throw new RuntimeException();
    }

    @Export("showsScopeBar")
    public boolean getShowsScopeBar() {
        throw new RuntimeException();
    }

    @Export("setShowsScopeBar:")
    public void setShowsScopeBar(boolean value) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("scopeBarBackgroundImage")
    public UIImage getScopeBarBackgroundImage() {
        throw new RuntimeException();
    }

    @Export("setScopeBarBackgroundImage:")
    public void setScopeBarBackgroundImage(UIImage value) {
        throw new RuntimeException();
    }

    @Export("setShowsCancelButton:animated:")
    public void setShowsCancelButtonanimated(boolean showsCancelButton, boolean animated) {
        throw new RuntimeException();
    }

    @Export("autocapitalizationType")
    public UITextAutocapitalizationType autocapitalizationType() {
        throw new RuntimeException();
    }

    @Export("inputAccessoryView")
    public UIView inputAccessoryView() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("backgroundImage")
    public UIImage backgroundImage() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setSearchFieldBackgroundImage:forState:")
    public void setSearchFieldBackgroundImageforState(UIImage backgroundImage, UIControlState state) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("searchFieldBackgroundImageForState:")
    public UIImage searchFieldBackgroundImageForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setImage:forSearchBarIcon:state:")
    public void setImageforSearchBarIconstate(UIImage iconImage, UISearchBarIcon icon, UIControlState state) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("imageForSearchBarIcon:state:")
    public UIImage imageForSearchBarIconstate(UISearchBarIcon icon, UIControlState state) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setScopeBarButtonBackgroundImage:forState:")
    public void setScopeBarButtonBackgroundImageforState(UIImage backgroundImage, UIControlState state) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("scopeBarButtonBackgroundImageForState:")
    public UIImage scopeBarButtonBackgroundImageForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setScopeBarButtonDividerImage:forLeftSegmentState:rightSegmentState:")
    public void setScopeBarButtonDividerImage(UIImage image, UIControlState leftState, UIControlState rightState) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("scopeBarButtonDividerImageForLeftSegmentState:rightSegmentState:")
    public UIImage scopeBarButtonDividerImageForLeftSegmentStaterightSegmentState(UIControlState leftState, UIControlState rightState) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setScopeBarButtonTitleTextAttributes:forState:")
    public void setScopeBarButtonTitleTextAttributesforState(NSDictionary attributes, UIControlState state) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("scopeBarButtonTitleTextAttributesForState:")
    public NSDictionary scopeBarButtonTitleTextAttributesForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("searchFieldBackgroundPositionAdjustment")
    public UIOffset searchFieldBackgroundPositionAdjustment() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("searchTextPositionAdjustment")
    public UIOffset searchTextPositionAdjustment() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setPositionAdjustment:forSearchBarIcon:")
    public void setPositionAdjustmentforSearchBarIcon(UIOffset adjustment, UISearchBarIcon icon) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("positionAdjustmentForSearchBarIcon:")
    public UIOffset positionAdjustmentForSearchBarIcon(UISearchBarIcon icon) {
        throw new RuntimeException();
    }

}