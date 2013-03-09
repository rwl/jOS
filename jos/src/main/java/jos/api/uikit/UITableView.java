package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSIndexPath;
import jos.api.foundation.NSIndexSet;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;
import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Appearance;
import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(NSCoding.class)
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

    @Export("dequeueReusableCellWithIdentifier:")
    public UITableViewCell dequeueReusableCell(NSString cellIdentifier) {
        return null;
    }

    @Export("reloadData")
    public void reloadData() {
        throw new RuntimeException();
    }


    @Export("style")
    public UITableViewStyle getStyle() {
        throw new RuntimeException();
    }

    @Export("rowHeight")
    public float getRowHeight() {
        throw new RuntimeException();
    }

    @Export("setRowHeight:")
    public void setRowHeight(float value) {
        throw new RuntimeException();
    }

    @Export("sectionHeaderHeight")
    public float getSectionHeaderHeight() {
        throw new RuntimeException();
    }

    @Export("setSectionHeaderHeight:")
    public void setSectionHeaderHeight(float value) {
        throw new RuntimeException();
    }

    @Export("sectionFooterHeight")
    public float getSectionFooterHeight() {
        throw new RuntimeException();
    }

    @Export("setSectionFooterHeight:")
    public void setSectionFooterHeight(float value) {
        throw new RuntimeException();
    }

    @Export("backgroundView")
    public UIView getBackgroundView() {
        throw new RuntimeException();
    }

    @Export("setBackgroundView:")
    public void setBackgroundView(UIView value) {
        throw new RuntimeException();
    }

    @Export("allowsSelection")
    public boolean getAllowsSelection() {
        throw new RuntimeException();
    }

    @Export("setAllowsSelection:")
    public void setAllowsSelection(boolean value) {
        throw new RuntimeException();
    }

    @Export("allowsSelectionDuringEditing")
    public boolean getAllowsSelectionDuringEditing() {
        throw new RuntimeException();
    }

    @Export("setAllowsSelectionDuringEditing:")
    public void setAllowsSelectionDuringEditing(boolean value) {
        throw new RuntimeException();
    }

    @Export("allowsMultipleSelection")
    public boolean getAllowsMultipleSelection() {
        throw new RuntimeException();
    }

    @Export("setAllowsMultipleSelection:")
    public void setAllowsMultipleSelection(boolean value) {
        throw new RuntimeException();
    }

    @Export("allowsMultipleSelectionDuringEditing")
    public boolean getAllowsMultipleSelectionDuringEditing() {
        throw new RuntimeException();
    }

    @Export("setAllowsMultipleSelectionDuringEditing:")
    public void setAllowsMultipleSelectionDuringEditing(boolean value) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("sectionIndexColor")
    public UIColor getSectionIndexColor() {
        throw new RuntimeException();
    }

    @Export("setSectionIndexColor:")
    public void setSectionIndexColor(UIColor value) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("sectionIndexTrackingBackgroundColor")
    public UIColor getSectionIndexTrackingBackgroundColor() {
        throw new RuntimeException();
    }

    @Export("setSectionIndexTrackingBackgroundColor:")
    public void setSectionIndexTrackingBackgroundColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("separatorStyle")
    public UITableViewCellSeparatorStyle getSeparatorStyle() {
        throw new RuntimeException();
    }

    @Export("setSeparatorStyle:")
    public void setSeparatorStyle(UITableViewCellSeparatorStyle value) {
        throw new RuntimeException();
    }

    @Export("separatorColor")
    public UIColor getSeparatorColor() {
        throw new RuntimeException();
    }

    @Export("setSeparatorColor:")
    public void setSeparatorColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("tableHeaderView")
    public UIView getTableHeaderView() {
        throw new RuntimeException();
    }

    @Export("setTableHeaderView:")
    public void setTableHeaderView(UIView value) {
        throw new RuntimeException();
    }

    @Export("tableFooterView")
    public UIView getTableFooterView() {
        throw new RuntimeException();
    }

    @Export("setTableFooterView:")
    public void setTableFooterView(UIView value) {
        throw new RuntimeException();
    }

    @Export("initWithFrame:style:")
    public NSObject initWithFramestyle(CGRect frame, UITableViewStyle style) {
        throw new RuntimeException();
    }

    @Export("reloadSectionIndexTitles")
    public void reloadSectionIndexTitles() {
        throw new RuntimeException();
    }

    @Export("numberOfSections")
    public int numberOfSections() {
        throw new RuntimeException();
    }

    @Export("numberOfRowsInSection:")
    public int numberOfRowsInSection(int section) {
        throw new RuntimeException();
    }

    @Export("rectForSection:")
    public CGRect rectForSection(int section) {
        throw new RuntimeException();
    }

    @Export("rectForHeaderInSection:")
    public CGRect rectForHeaderInSection(int section) {
        throw new RuntimeException();
    }

    @Export("rectForFooterInSection:")
    public CGRect rectForFooterInSection(int section) {
        throw new RuntimeException();
    }

    @Export("rectForRowAtIndexPath:")
    public CGRect rectForRowAtIndexPath(NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("indexPathForRowAtPoint:")
    public NSIndexPath indexPathForRowAtPoint(CGPoint point) {
        throw new RuntimeException();
    }

    @Export("indexPathForCell:")
    public NSIndexPath indexPathForCell(UITableViewCell cell) {
        throw new RuntimeException();
    }

    @Export("indexPathsForRowsInRect:")
    public NSArray indexPathsForRowsInRect(CGRect rect) {
        throw new RuntimeException();
    }

    @Export("cellForRowAtIndexPath:")
    public UITableViewCell cellAt(NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("visibleCells")
    public NSArray visibleCells() {
        throw new RuntimeException();
    }

    @Export("indexPathsForVisibleRows")
    public NSArray indexPathsForVisibleRows() {
        throw new RuntimeException();
    }

    @Export("headerViewForSection:")
    public UITableViewHeaderFooterView headerViewForSection(int section) {
        throw new RuntimeException();
    }

    @Export("footerViewForSection:")
    public UITableViewHeaderFooterView footerViewForSection(int section) {
        throw new RuntimeException();
    }

    @Export("scrollToRowAtIndexPath:atScrollPosition:animated:")
    public void scrollToRowAtIndexPathatScrollPositionanimated(NSIndexPath indexPath, UITableViewScrollPosition scrollPosition, boolean animated) {
        throw new RuntimeException();
    }

    @Export("scrollToNearestSelectedRowAtScrollPosition:animated:")
    public void scrollToNearestSelectedRowAtScrollPositionanimated(UITableViewScrollPosition scrollPosition, boolean animated) {
        throw new RuntimeException();
    }

    @Export("beginUpdates")
    public void beginUpdates() {
        throw new RuntimeException();
    }

    @Export("endUpdates")
    public void endUpdates() {
        throw new RuntimeException();
    }

    @Export("insertSections:withRowAnimation:")
    public void insertSections(NSIndexSet sections, UITableViewRowAnimation animation) {
        throw new RuntimeException();
    }

    @Export("deleteSections:withRowAnimation:")
    public void deleteSections(NSIndexSet sections, UITableViewRowAnimation animation) {
        throw new RuntimeException();
    }

    @Export("reloadSections:withRowAnimation:")
    public void reloadSections(NSIndexSet sections, UITableViewRowAnimation animation) {
        throw new RuntimeException();
    }

    @Export("moveSection:toSection:")
    public void moveSectiontoSection(int section, int newSection) {
        throw new RuntimeException();
    }

    @Export("insertRowsAtIndexPaths:withRowAnimation:")
    public void insertRows(NSIndexPath[] indexPaths, UITableViewRowAnimation animation) {
        throw new RuntimeException();
    }

    @Export("deleteRowsAtIndexPaths:withRowAnimation:")
    public void deleteRows(NSIndexPath[] indexPaths, UITableViewRowAnimation animation) {
        throw new RuntimeException();
    }

    @Export("reloadRowsAtIndexPaths:withRowAnimation:")
    public void reloadRowsAtIndexPathswithRowAnimation(NSIndexPath[] indexPaths, UITableViewRowAnimation animation) {
        throw new RuntimeException();
    }

    @Export("moveRowAtIndexPath:toIndexPath:")
    public void moveRowAtIndexPathtoIndexPath(NSIndexPath indexPath, NSIndexPath newIndexPath) {
        throw new RuntimeException();
    }

    @Export("isEditing")
    public boolean isEditing() {
        throw new RuntimeException();
    }

    @Export("setEditing:animated:")
    public void setEditinganimated(boolean editing, boolean animated) {
        throw new RuntimeException();
    }

    @Export("indexPathForSelectedRow")
    public NSIndexPath indexPathForSelectedRow() {
        throw new RuntimeException();
    }

    @Export("indexPathsForSelectedRows")
    public NSArray indexPathsForSelectedRows() {
        throw new RuntimeException();
    }

    @Export("selectRowAtIndexPath:animated:scrollPosition:")
    public void selectRowAtIndexPath(NSIndexPath path, boolean animated, UITableViewScrollPosition scrollPosition) {
        throw new RuntimeException();
    }

    @Export("deselectRowAtIndexPath:animated:")
    public void deselectRow(NSIndexPath indexPath, boolean animated) {
        throw new RuntimeException();
    }

    @Export("sectionIndexMinimumDisplayRowCount")
    public int sectionIndexMinimumDisplayRowCount() {
        throw new RuntimeException();
    }

    @Export("dequeueReusableCellWithIdentifier:")
    public NSObject dequeueReusableCellWithIdentifier(String identifier) {
        throw new RuntimeException();
    }

    @Export("dequeueReusableCellWithIdentifier:forIndexPath:")
    public NSObject dequeueReusableCellWithIdentifierforIndexPath(String identifier, NSIndexPath indexPath) {
        throw new RuntimeException();
    }

    @Export("dequeueReusableHeaderFooterViewWithIdentifier:")
    public NSObject dequeueReusableHeaderFooterViewWithIdentifier(String identifier) {
        throw new RuntimeException();
    }

    @Export("registerNib:forCellReuseIdentifier:")
    public void registerNibforCellReuseIdentifier(UINib nib, String identifier) {
        throw new RuntimeException();
    }

    @Export("registerClass:forCellReuseIdentifier:")
    public void registerClassforCellReuseIdentifier(Class cellClass, String identifier) {
        throw new RuntimeException();
    }

    @Export("registerNib:forHeaderFooterViewReuseIdentifier:")
    public void registerNibforHeaderFooterViewReuseIdentifier(UINib nib, String identifier) {
        throw new RuntimeException();
    }

    @Export("registerClass:forHeaderFooterViewReuseIdentifier:")
    public void registerClassforHeaderFooterViewReuseIdentifier(Class aClass, String identifier) {
        throw new RuntimeException();
    }
}
