package jos.api.uikit;

import com.google.j2objc.annotations.Export;

public class UITableView extends UIScrollView {

    public UITableViewSource source;

    @Export("source")
    public UITableViewSource getSource() {
        return this.source;
    }

    @Export("setSource:")
    public void setSource(UITableViewSource source) {
        this.source = source;
    }

    @Export("dequeueReusableCellWithIdentifier:")
    public UITableViewCell dequeueReusableCell(String cellIdentifier) {
        return null;
    }

}
