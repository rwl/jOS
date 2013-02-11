package jos.samples.controls.screens.iphone;

import java.util.ArrayList;
import java.util.List;

import jos.api.uikit.UILabel;
import jos.api.uikit.UIPickerView;
import jos.api.uikit.UIPickerViewDataSource;
import jos.api.uikit.UIPickerViewDelegate;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Outlet;

public class PickerView1 extends UIViewController {

    @Outlet
    UILabel lblSelectedItem;

    @Outlet
    UIPickerView pkrMain;

    PickerDelegate pickerDelegate;

    PickerDataSource pickerDataSource;

    public PickerView1() {
        super("PickerView1_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Picker View");

        List<String> items = new ArrayList<String>();
        items.add("item the first!");
        items.add("item the second!");
        items.add("item the third!");
        items.add("fourth item!");

        // create our data source and delegate
        pickerDelegate = new PickerDelegate(items);
        pickerDataSource = new PickerDataSource(items);

        // set them on our picker class
        pkrMain.setDelegate(pickerDelegate);
        pkrMain.setDataSource(pickerDataSource);

        // wire up the value change method
        pickerDelegate.delegate = new PickerDataModelDelegate() {

            @Override
            public void onValueChanged(PickerDelegate model) {
                lblSelectedItem.setText(model.selectedItem());
            }
        };

        // set our initial selection on the label
        lblSelectedItem.setText(pickerDelegate.selectedItem());
    }

    private static class PickerDelegate extends UIPickerViewDelegate {

        private PickerDataModelDelegate delegate;

        /**
         * The items to show up in the picker
         */
        private final List<String> items;

        public PickerDelegate(List<String> items) {
            this.items = items;
        }

        /**
         * The current selected item
         */
        public String selectedItem() {
            return items.get(selectedIndex);
        }

        private int selectedIndex = 0;

        /**
         * Called by the picker to get the text for a particular row in a
         * particular spinner item
         */
        @Override
        public String getTitle(UIPickerView picker, int row, int component) {
            return items.get(row);
        }

        /**
         * Called when a row is selected in the spinner
         */
        @Override
        public void selected(UIPickerView picker, int row, int component) {
            selectedIndex = row;
            if (this.delegate != null) {
                this.delegate.onValueChanged(this);
            }
        }
    }

    private interface PickerDataModelDelegate {

        void onValueChanged(PickerDelegate model);
    }

    /**
     * This is our simple data source. it uses a list of strings as it's data.
     */
    private static class PickerDataSource extends UIPickerViewDataSource {

        /**
         * The items to show up in the picker
         */
        private final List<String> items;

        public PickerDataSource(List<String> items) {
            this.items = items;
        }

        /**
         * Called by the picker to determine how many rows are in a given
         * spinner item
         */
        @Override
        public int getRowsInComponent(UIPickerView picker, int component) {
            return items.size();
        }

        /**
         * Called by the picker to get the number of spinner items
         */
        @Override
        public int getComponentCount(UIPickerView picker) {
            return 1;
        }

    }

}
