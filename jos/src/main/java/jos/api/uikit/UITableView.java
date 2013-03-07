package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UITableView extends UIScrollView {

    public UITableViewDataSource dataSource;

    private UITableViewDelegate delegate;

    @Export("dataSource")
    public UITableViewDataSource getDataSource() {
        return this.dataSource;
    }

    @Export("setDataSource:")
    public void setDataSource(UITableViewDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Export("delegate")
    public UITableViewDelegate getTableViewDelegate() {
        return this.delegate;
    }

    @Export("setDelegate:")
    public void setTableViewDelegate(UITableViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Export("dequeueReusableCellWithIdentifier:")
    public UITableViewCell dequeueReusableCell(String cellIdentifier) {
        return null;
    }

    @Export("reloadData")
    public void reloadData() {
        throw new RuntimeException();
    }

}
