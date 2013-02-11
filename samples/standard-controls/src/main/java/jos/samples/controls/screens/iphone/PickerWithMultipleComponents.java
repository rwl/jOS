package jos.samples.controls.screens.iphone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jos.api.uikit.UILabel;
import jos.api.uikit.UIPickerView;
import jos.api.uikit.UIPickerViewDataSource;
import jos.api.uikit.UIPickerViewDelegate;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Outlet;

public class PickerWithMultipleComponents extends UIViewController {

    @Outlet
    UILabel lblSelectedItem;

    @Outlet
    UIPickerView pkrMain;

    PickerDelegate pickerDelegate;

    PickerDataSource pickerDataSource;

    public PickerWithMultipleComponents() {
        super("PickerWithMultipleComponents_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Picker View");

        Map<Integer, List<String>> pickerItems = new HashMap<Integer, List<String>>();

        List<String> items = new ArrayList<String>();
        items.add("1");
        items.add("2");
        items.add("3");
        pickerItems.put(0, items);

        items = new ArrayList<String>();
        items.add("Red");
        items.add("Green");
        items.add("Blue");
        items.add("Alpha");
        pickerItems.put(1, items);

        // create our simple picker data source
        pickerDelegate = new PickerDelegate(pickerItems);
        pickerDataSource = new PickerDataSource(pickerItems);

        // set them on our picker class
        pkrMain.setDelegate(pickerDelegate);
        pkrMain.setDataSource(pickerDataSource);

        // wire up the item selected method
        pickerDelegate.delegate = new PickerDataModelDelegate() {

            @Override
            public void onValueChanged(String selected) {
                lblSelectedItem.setText(selected);
            }
        };
    }

    private static class PickerDelegate extends UIPickerViewDelegate {

        private PickerDataModelDelegate delegate;

        /**
         * The items to show up in the picker
         */
        private final Map<Integer, List<String>> items;

        public PickerDelegate(Map<Integer, List<String>> items) {
            this.items = items;
        }

        /**
         * Called by the picker to get the text for a particular row in a
         * particular spinner item.
         */
        @Override
        public String getTitle(UIPickerView picker, int row, int component) {
            return items.get(component).get(row);
        }

        /**
         * Called when a row is selected in the spinner
         */
        @Override
        public void selected(UIPickerView picker, int row, int component) {
            if (this.delegate != null) {
                this.delegate.onValueChanged(getTitle(picker, row, component));
            }
        }

    }

    protected interface PickerDataModelDelegate {

        void onValueChanged(String selected);
    }

    /**
     * This is our simple picker model. it uses a list of strings as it's data
     */
    private static class PickerDataSource extends UIPickerViewDataSource {

        /**
         * The items to show up in the picker
         */
        private final Map<Integer, List<String>> items;

        public PickerDataSource(Map<Integer, List<String>> items) {
            this.items = items;
        }

        /**
         * Called by the picker to determine how many rows are in a given
         * spinner item
         */
        @Override
        public int getRowsInComponent(UIPickerView picker, int component) {
            return items.get(component).size();
        }

        /**
         * Called by the picker to get the number of spinner items
         */
        @Override
        public int getComponentCount(UIPickerView picker) {
            return items.size();
        }

    }

}
