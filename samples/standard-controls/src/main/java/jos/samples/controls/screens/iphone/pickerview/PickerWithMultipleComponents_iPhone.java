package jos.samples.controls.screens.iphone.pickerview;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Export;

public class PickerWithMultipleComponents_iPhone extends UIViewController {

    PickerDataModel pickerDataModel;

    public PickerWithMultipleComponents_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public PickerWithMultipleComponents_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public PickerWithMultipleComponents_iPhone() {
        super("PickerWithMultipleComponents_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        this.title = "Picker View";

        // create our simple picker modle
        pickerDataModel = new PickerDataModel ();

        List<String> items = new ArrayList<String> ();
        items.add ("1");
        items.add ("2");
        items.add ("3");
        pickerDataModel.items.add (0, items);

        items = new ArrayList<String> ();
        items.add ("Red");
        items.add ("Green");
        items.add ("Blue");
        items.add ("Alpha");
        pickerDataModel.items.add (1, items);

        // set it on our picker class
        this.pkrMain.model = pickerDataModel;


        // wire up the item selected method
        pickerDataModel.valueChanged += (s, e) => {
        //  this.lblSelectedItem.text = pickerDataModel.selectedItem;
        };

        // set our initial selection on the label
        //this.lblSelectedItem.text = pickerDataModel.selectedItem;
    }

    /**
     * This is our simple picker model. it uses a list of strings as it's dats
     */
    protected class PickerDataModel extends UIPickerViewModel {

        public/* event */EventHandler<EventArgs> valueChanged;

        /**
         * The items to show up in the picker
         */
        public Map<Integer, List<String>> items = new HashMap<Integer, List<String>>();

        public PickerDataModel() {
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
         * Called by the picker to get the text for a particular row in a
         * particular spinner item.
         */
        @Override
        public String getTitle(UIPickerView picker, int row, int component) {
            return items.get(component).get(row);
        }

        /**
         * Called by the picker to get the number of spinner items
         */
        @Override
        public int getComponentCount(UIPickerView picker) {
            return items.size();
        }

        /**
         * Called when a row is selected in the spinner
         */
        @Override
        public void selected(UIPickerView picker, int row, int component) {
            // selectedIndex = row;
            if (this.valueChanged != null) {
                this.valueChanged(this, new EventArgs());
            }
        }
    }

}
