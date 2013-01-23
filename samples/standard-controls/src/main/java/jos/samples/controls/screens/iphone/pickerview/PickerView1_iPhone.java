package jos.samples.controls.screens.iphone.pickerview;

import java.util.ArrayList;
import java.util.List;

import com.google.j2objc.annotations.Export;

import jos.api.uikit.UIViewController;

public class PickerView1_iPhone extends UIViewController {

    PickerDataModel pickerDataModel;

    public PickerView1_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public PickerView1_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public PickerView1_iPhone() {
        super("PickerView1_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        this.title = "Picker View";

        // create our simple picker model
        pickerDataModel = new PickerDataModel ();
        pickerDataModel.items.add ("item the first!");
        pickerDataModel.items.add ("item the second!");
        pickerDataModel.items.add ("item the third!");
        pickerDataModel.items.add ("fourth item!");

        // set it on our picker class
        this.pkrMain.source = pickerDataModel;

        // wire up the value change method
        pickerDataModel.valueChanged += (s, e) => {
            this.lblSelectedItem.text = pickerDataModel.selectedItem;
        };

        // set our initial selection on the label
        this.lblSelectedItem.text = pickerDataModel.selectedItem;
    }

    /**
     * This is our simple picker model. it uses a list of strings as it's data
     * and exposes a valueChanged event when the picker changes.
     */
    protected class PickerDataModel extends UIPickerViewModel {

        public/* event */EventHandler<EventArgs> valueChanged;

        /**
         * The items to show up in the picker
         */
        public List<String> items = new ArrayList<String>();

        /**
         * The current selected item
         */
        public String selectedItem() {
            return items.get(selectedIndex);
        }

        protected int selectedIndex = 0;

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
            if (this.valueChanged != null) {
                this.valueChanged(this, new EventArgs());
            }
        }
    }
}
