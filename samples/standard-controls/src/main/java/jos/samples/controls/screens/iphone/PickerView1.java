package jos.samples.controls.screens.iphone;

import java.util.ArrayList;
import java.util.List;

import jos.api.uikit.UILabel;
import jos.api.uikit.UIPickerView;
import jos.api.uikit.UIPickerViewModel;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Outlet;

public class PickerView1 extends UIViewController {

    @Outlet
    UILabel lblSelectedItem;

    @Outlet
    UIPickerView pkrMain;

    PickerDataModel pickerDataModel;

    public PickerView1() {
        super("PickerView1_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Picker View");

        // create our simple picker model
        pickerDataModel = new PickerDataModel();
        pickerDataModel.items.add("item the first!");
        pickerDataModel.items.add("item the second!");
        pickerDataModel.items.add("item the third!");
        pickerDataModel.items.add("fourth item!");

        // set it on our picker class
        pkrMain.setSource(pickerDataModel);

        // wire up the value change method
        pickerDataModel.delegate = new PickerDataModelDelegate() {

            @Override
            public void onValueChanged(PickerDataModel model) {
                lblSelectedItem.setText(pickerDataModel.selectedItem());
            }
        };

        // set our initial selection on the label
        lblSelectedItem.setText(pickerDataModel.selectedItem());
    }

    /**
     * This is our simple picker model. it uses a list of strings as it's data
     * and exposes a valueChanged event when the picker changes.
     */
    protected class PickerDataModel extends UIPickerViewModel {

        private PickerDataModelDelegate delegate;

        /**
         * The items to show up in the picker
         */
        private List<String> items = new ArrayList<String>();

        /**
         * The current selected item
         */
        public String selectedItem() {
            return items.get(selectedIndex);
        }

        private int selectedIndex = 0;

        public PickerDataModel() {
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
         * Called by the picker to get the text for a particular row in a
         * particular spinner item
         */
        @Override
        public String getTitle(UIPickerView picker, int row, int component) {
            return items.get(row);
        }

        /**
         * Called by the picker to get the number of spinner items
         */
        @Override
        public int getComponentCount(UIPickerView picker) {
            return 1;
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

    protected interface PickerDataModelDelegate {

        void onValueChanged(PickerDataModel model);

    }

}