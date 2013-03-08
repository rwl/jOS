package jos.dialog;

import jos.api.uikit.UISearchBar;
import jos.api.uikit.UITableViewStyle;

/**
 *  The DialogViewController is the main entry point to use Dialog,
 *  it provides a simplified API to the UITableViewController.
 */
public class DialogViewController extends UITableViewController
{
    public UITableViewStyle Style = UITableViewStyle.GROUPED;
    public Action<NSIndexPath> OnSelection;
    UISearchBar searchBar;
    UITableView tableView;
    RefreshTableHeaderView refreshView;
    RootElement root;
    boolean pushing;
    boolean dirty;
    boolean reloading;

    /**
     * The root element displayed by the DialogViewController, the value can be changed during runtime to update the contents.
     */
    public RootElement getRoot() {
            return root;
        }
    public void setRoot(RootElement value) {
            if (root == value)
                return;
            if (root != null)
                root.Dispose ();

            root = value;
            root.TableView = tableView;
            ReloadData ();
    }

    EventHandler refreshRequested;

    /**
     * If you assign a handler to this event before the view is shown, the
     * DialogViewController will have support for pull-to-refresh UI.
     */
    public void setRefreshRequested(EventHandler value) {
            if (tableView != null)
                throw new IllegalArgumentException("You should set the handler before the controller is shown");
            refreshRequested = value;
    }

    // If the value is true, we are enabled, used in the source for quick computation
    boolean enableSearch;

    public boolean getEnableSearch() {
           return enableSearch;
        }
        public void setEnableSearch(boolean value) {
            if (enableSearch == value)
                return;

            // After MonoTouch 3.0, we can allow for the search to be enabled/disable
            if (tableView != null)
                throw new IllegalArgumentException("You should set EnableSearch before the controller is shown");
            enableSearch = value;
    }

    // If set, we automatically scroll the content to avoid showing the search bar until
    // the user manually pulls it down.
    public boolean AutoHideSearch ;

    public String SearchPlaceholder ;

    /**
     * Invoke this method to trigger a data refresh.
     *
     * This will invoke the RerfeshRequested event handler, the code attached to it
     * should start the background operation to fetch the data and when it completes
     * it should call ReloadComplete to restore the control state.
     */
    public void TriggerRefresh ()
    {
        TriggerRefresh (false);
    }

    void TriggerRefresh (boolean showStatus)
    {
        if (refreshRequested == null)
            return;

        if (reloading)
            return;

        reloading = true;
        if (refreshView != null)
            refreshView.SetActivity (true);
        refreshRequested (this, EventArgs.Empty);

        if (reloading && showStatus && refreshView != null){
            UIView.BeginAnimations ("reloadingData");
            UIView.SetAnimationDuration (0.2);
            TableView.ContentInset = new UIEdgeInsets (60, 0, 0, 0);
            UIView.CommitAnimations ();
        }
    }

    /**
     * Invoke this method to signal that a reload has completed, this will update the UI accordingly.
     */
    public void ReloadComplete ()
    {
        if (refreshView != null)
            refreshView.LastUpdate = DateTime.Now;
        if (!reloading)
            return;

        reloading = false;
        if (refreshView == null)
            return;

        refreshView.SetActivity (false);
        refreshView.Flip (false);
        UIView.BeginAnimations ("doneReloading");
        UIView.SetAnimationDuration (0.3f);
        TableView.ContentInset = new UIEdgeInsets (0, 0, 0, 0);
        refreshView.SetStatus (RefreshViewStatus.PullToReload);
        UIView.CommitAnimations ();
    }

    /**
     * Controls whether the DialogViewController should auto rotate
     */
    public boolean Autorotate ;

    @Override
    public boolean ShouldAutorotateToInterfaceOrientation (UIInterfaceOrientation toInterfaceOrientation)
    {
        return Autorotate || toInterfaceOrientation == UIInterfaceOrientation.Portrait;
    }

    @Override
    public void DidRotate (UIInterfaceOrientation fromInterfaceOrientation)
    {
        super.DidRotate (fromInterfaceOrientation);

        //Fixes the RefreshView's size if it is shown during rotation
        if (refreshView != null) {
            var bounds = View.Bounds;

            refreshView.setFrame(makeRect(0, -bounds.Height, bounds.Width, bounds.Height));
        }

        ReloadData ();
    }

    Section [] originalSections;
    Element [][] originalElements;

    /**
     * Allows caller to programatically activate the search bar and start the search process
     */
    public void StartSearch ()
    {
        if (originalSections != null)
            return;

        searchBar.BecomeFirstResponder ();
        originalSections = Root.Sections.ToArray ();
        originalElements = new Element [originalSections.Length][];
        for (int i = 0; i < originalSections.Length; i++)
            originalElements [i] = originalSections [i].Elements.ToArray ();
    }

    /**
     * Allows the caller to programatically stop searching.
     */
    public void FinishSearch ()
    {
        if (originalSections == null)
            return;

        Root.Sections = new List<Section> (originalSections);
        originalSections = null;
        originalElements = null;
        searchBar.ResignFirstResponder ();
        ReloadData ();
    }

//    public /*delegate */void SearchTextEventHandler (object sender, SearchChangedEventArgs args);
    public SearchTextEventHandler SearchTextChanged;

    public void OnSearchTextChanged (String text)
    {
        if (SearchTextChanged != null)
            SearchTextChanged (this, new SearchChangedEventArgs (text));
    }

    public void PerformFilter (String text)
    {
        if (originalSections == null)
            return;

        OnSearchTextChanged (text);

        var newSections = new List<Section> ();

        for (int sidx = 0; sidx < originalSections.Length; sidx++){
            Section newSection = null;
            Section section = originalSections [sidx];
            Element [] elements = originalElements [sidx];

            for (int eidx = 0; eidx < elements.Length; eidx++){
                if (elements [eidx].Matches (text)){
                    if (newSection == null){
                        newSection = new Section (section.Header, section.Footer);
                        newSection.setFooterView(section.FooterView),
                        newSection.setHeaderView(section.HeaderView);
                        newSections.Add (newSection);
                    }
                    newSection.Add (elements [eidx]);
                }
            }
        }

        Root.Sections = newSections;

        ReloadData ();
    }

    public void SearchButtonClicked (string text)
    {
    }

    class SearchDelegate extends UISearchBarDelegate {

        DialogViewController container;

        public SearchDelegate (DialogViewController container)
        {
            this.container = container;
        }

        @Override
        public void OnEditingStarted (UISearchBar searchBar)
        {
            searchBar.ShowsCancelButton = true;
            container.StartSearch ();
        }

        @Override
        public void OnEditingStopped (UISearchBar searchBar)
        {
            searchBar.ShowsCancelButton = false;
            container.FinishSearch ();
        }

        @Override
        public void TextChanged (UISearchBar searchBar, string searchText)
        {
            container.PerformFilter (searchText ?? "");
        }

        @Override
        public void CancelButtonClicked (UISearchBar searchBar)
        {
            searchBar.ShowsCancelButton = false;
            container.searchBar.Text = "";
            container.FinishSearch ();
            searchBar.ResignFirstResponder ();
        }

        @Override
        public void SearchButtonClicked (UISearchBar searchBar)
        {
            container.SearchButtonClicked (searchBar.Text);
        }
    }

    public class Source extends UITableViewSource {

        final float yboundary = 65;
        protected DialogViewController Container;
        protected RootElement Root;
        boolean checkForRefresh;

        public Source (DialogViewController container)
        {
            this.Container = container;
            Root = container.root;
        }

        @Override
        public void AccessoryButtonTapped (UITableView tableView, NSIndexPath indexPath)
        {
            var section = Root.Sections [indexPath.Section];
            var element = (section.Elements [indexPath.Row] as StyledStringElement);
            if (element != null)
                element.AccessoryTap ();
        }

        @Override
        public int RowsInSection (UITableView tableview, int section)
        {
            var s = Root.Sections [section];
            var count = s.Elements.Count;

            return count;
        }

        @Override
        public int NumberOfSections (UITableView tableView)
        {
            return Root.Sections.Count;
        }

        @Override
        public string TitleForHeader (UITableView tableView, int section)
        {
            return Root.Sections [section].Caption;
        }

        @Override
        public String TitleForFooter (UITableView tableView, int section)
        {
            return Root.Sections [section].Footer;
        }

        @Override
        public UITableViewCell GetCell (UITableView tableView, MonoTouch.Foundation.NSIndexPath indexPath)
        {
            var section = Root.Sections [indexPath.Section];
            var element = section.Elements [indexPath.Row];

            return element.GetCell (tableView);
        }

        @Override
        public void WillDisplay (UITableView tableView, UITableViewCell cell, NSIndexPath indexPath)
        {
            if (Root.NeedColorUpdate){
                var section = Root.Sections [indexPath.Section];
                var element = section.Elements [indexPath.Row];
                var colorized = element as IColorizeBackground;
                if (colorized != null)
                    colorized.WillDisplay (tableView, cell, indexPath);
            }
        }

        @Override
        public void RowDeselected (UITableView tableView, NSIndexPath indexPath)
        {
            Container.Deselected (indexPath);
        }

        @Override
        public void RowSelected (UITableView tableView, NSIndexPath indexPath)
        {
            var onSelection = Container.OnSelection;
            if (onSelection != null)
                onSelection (indexPath);
            Container.Selected (indexPath);
        }

        @Override
        public UIView GetViewForHeader (UITableView tableView, int sectionIdx)
        {
            var section = Root.Sections [sectionIdx];
            return section.HeaderView;
        }

        @Override
        public float GetHeightForHeader (UITableView tableView, int sectionIdx)
        {
            var section = Root.Sections [sectionIdx];
            if (section.HeaderView == null)
                return -1;
            return section.HeaderView.Frame.Height;
        }

        @Override
        public UIView GetViewForFooter (UITableView tableView, int sectionIdx)
        {
            var section = Root.Sections [sectionIdx];
            return section.FooterView;
        }

        @Override
        public float GetHeightForFooter (UITableView tableView, int sectionIdx)
        {
            var section = Root.Sections [sectionIdx];
            if (section.FooterView == null)
                return -1;
            return section.FooterView.Frame.Height;
        }

        /* Pull to Refresh support */

        @Override
        public void Scrolled (UIScrollView scrollView)
        {
            if (!checkForRefresh)
                return;
            if (Container.reloading)
                return;
            var view  = Container.refreshView;
            if (view == null)
                return;

            var point = Container.TableView.ContentOffset;

            if (view.IsFlipped && point.Y > -yboundary && point.Y < 0){
                view.Flip (true);
                view.SetStatus (RefreshViewStatus.PullToReload);
            } else if (!view.IsFlipped && point.Y < -yboundary){
                view.Flip (true);
                view.SetStatus (RefreshViewStatus.ReleaseToReload);
            }
        }

        @Override
        public void DraggingStarted (UIScrollView scrollView)
        {
            checkForRefresh = true;
        }

        @Override
        public void DraggingEnded (UIScrollView scrollView, bool willDecelerate)
        {
            if (Container.refreshView == null)
                return;

            checkForRefresh = false;
            if (Container.TableView.ContentOffset.Y > -yboundary)
                return;
            Container.TriggerRefresh (true);
        }
    }

    //
    // Performance trick, if we expose GetHeightForRow, the UITableView will
    // probe *every* row for its size;   Avoid this by creating a separate
    // model that is used only when we have items that require resizing
    //
    public class SizingSource extends Source {

        public SizingSource (DialogViewController controller) {
            super(controller);
        }

        @Override
        public float GetHeightForRow (UITableView tableView, NSIndexPath indexPath)
        {
            Section section = Root.Sections [indexPath.Section];
            Element element = section.Elements [indexPath.Row];

            IElementSizing sizable = (IElementSizing) element;
            if (sizable == null)
                return tableView.RowHeight;
            return sizable.GetHeight (tableView, indexPath);
        }
    }

    /**
     * Activates a nested view controller from the DialogViewController.
     * If the view controller is hosted in a UINavigationController it
     * will push the result.   Otherwise it will show it as a modal
     * dialog
     */
    public void ActivateController (UIViewController controller)
    {
        dirty = true;

        parent = ParentViewController;
        UINavigationController nav = (UINavigationController) parent;

        // We can not push a nav controller into a nav controller
        if (nav != null && !(controller is UINavigationController))
            nav.PushViewController (controller, true);
        else
            PresentModalViewController (controller, true);
    }

    /**
     * Dismisses the view controller. It either pops or dismisses
     * based on the kind of container we are hosted in.
     */
    public void DeactivateController (boolean animated)
    {
        var parent = ParentViewController;
        UINavigationController nav = (UINavigationController) parent;

        if (nav != null)
            nav.PopViewControllerAnimated (animated);
        else
            DismissModalViewControllerAnimated (animated);
    }

    void SetupSearch ()
    {
        if (enableSearch){
            searchBar = new UISearchBar (makeRect(0, 0, tableView.Bounds.Width, 44));
            searchBar.setDelegate(new SearchDelegate (this));
            if (SearchPlaceholder != null)
                searchBar.Placeholder = this.SearchPlaceholder;
            tableView.TableHeaderView = searchBar;
        } else {
            tableView.setTableHeaderView(null);
        }
    }

    public void Deselected (NSIndexPath indexPath)
    {
        Section section = root.Sections [indexPath.Section];
        Element element = section.Elements [indexPath.Row];

        element.Deselected (this, tableView, indexPath);
    }

    public void Selected (NSIndexPath indexPath)
    {
        Section section = root.Sections [indexPath.Section];
        Element element = section.Elements [indexPath.Row];

        element.Selected (this, tableView, indexPath);
    }

    public UITableView MakeTableView (CGRect bounds, UITableViewStyle style)
    {
        return new UITableView (bounds, style);
    }

    @Override
    public void LoadView ()
    {
        tableView = MakeTableView (UIScreen.MainScreen.Bounds, Style);
        tableView.setAutoresizingMask(UIViewAutoresizing.FlexibleHeight | UIViewAutoresizing.FlexibleWidth | UIViewAutoresizing.FlexibleTopMargin);
        tableView.setAutosizesSubviews(true);

        if (root != null)
            root.Prepare ();

        UpdateSource ();
        View = tableView;
        SetupSearch ();
        ConfigureTableView ();

        if (root == null)
            return;
        root.TableView = tableView;
    }

    void ConfigureTableView ()
    {
        if (refreshRequested != null){
            // The dimensions should be large enough so that even if the user scrolls, we render the
            // whole are with the background color.
            var bounds = View.Bounds;
            refreshView = MakeRefreshTableHeaderView (new RectangleF (0, -bounds.Height, bounds.Width, bounds.Height));
            if (reloading)
                refreshView.SetActivity (true);
            TableView.AddSubview (refreshView);
        }
    }

    public RefreshTableHeaderView MakeRefreshTableHeaderView (CGRect rect)
    {
        return new RefreshTableHeaderView (rect);
    }

    @Override
    public void ViewWillAppear (bool animated)
    {
        super.ViewWillAppear (animated);
        if (AutoHideSearch){
            if (enableSearch){
                if (TableView.ContentOffset.Y < 44)
                    TableView.ContentOffset = new PointF (0, 44);
            }
        }
        if (root == null)
            return;

        root.Prepare ();

        NavigationItem.HidesBackButton = !pushing;
        if (root.Caption != null)
            NavigationItem.Title = root.Caption;
        if (dirty){
            tableView.ReloadData ();
            dirty = false;
        }
    }

    public boolean getPushing() {
            return pushing;
        }
        public void setPushing(boolean value) {
            pushing = value;
            if (NavigationItem != null)
                NavigationItem.HidesBackButton = !pushing;
    }

    public Source CreateSizingSource (boolean unevenRows)
    {
        return unevenRows ? new SizingSource (this) : new Source (this);
    }

    Source TableSource;

    void UpdateSource ()
    {
        if (root == null)
            return;

        TableSource = CreateSizingSource (root.UnevenRows);
        tableView.Source = TableSource;
    }

    public void ReloadData ()
    {
        if (root == null)
            return;

        if(root.Caption != null)
            NavigationItem.setTitle(root.getCaption());

        root.Prepare ();
        if (tableView != null){
            UpdateSource ();
            tableView.ReloadData ();
        }
        dirty = false;
    }

    public EventHandler ViewDisappearing;

    @Override
    public void ViewWillDisappear (boolean animated)
    {
        super.ViewWillDisappear (animated);
        if (ViewDisappearing != null)
            ViewDisappearing (this/*, EventArgs.Empty*/);
    }

    public DialogViewController (RootElement root) {
        super(UITableViewStyle.Grouped);
        this.root = root;
    }

    public DialogViewController (UITableViewStyle style, RootElement root) {
        super(style);
        Style = style;
        this.root = root;
    }

    /**
     * Creates a new DialogViewController from a RootElement and sets the push status
     *
     * @param root The <see cref="RootElement"/> containing the information to render.
     * @param pushing A <see cref="System.Boolean"/> describing whether this is being pushed
     * (NavigationControllers) or not. If pushing is true, then the back button
     * will be shown, allowing the user to go back to the previous controller
     */
    public DialogViewController (RootElement root, boolean pushing) {
        super(UITableViewStyle.Grouped);
        this.pushing = pushing;
        this.root = root;
    }

    public DialogViewController (UITableViewStyle style, RootElement root, bool pushing) {
        super(style);
        Style = style;
        this.pushing = pushing;
        this.root = root;
    }

    public DialogViewController (IntPtr handle) {
        super(handle);
        this.root = new RootElement ("");
    }
}