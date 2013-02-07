package jos.api.uikit;

import com.google.j2objc.annotations.Export;

public class UIPageControl extends UIControl {

    public int currentPage;

    @Export("currentPage")
    public int getCurrentPage() {
        return currentPage;
    }

    @Export("setCurrentPage:")
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}
