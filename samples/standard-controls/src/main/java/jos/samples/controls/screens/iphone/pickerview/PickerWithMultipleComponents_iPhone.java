package jos.samples.controls.screens.iphone.pickerview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIPickerView;
import jos.api.uikit.UIPickerViewModel;

import com.google.j2objc.annotations.Export;

public class PickerWithMultipleComponents_iPhone extends AbstractPickerWithMultipleComponents_iPhone {

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
        pickerDataModel.items.put (0, items);

        items = new ArrayList<String> ();
        items.add ("Red");
        items.add ("Green");
        items.add ("Blue");
        items.add ("Alpha");
        pickerDataModel.items.put (1, items);

        // set it on our picker class
        this.pkrMain().model = pickerDataModel;


        // wire up the item selected method
        pickerDataModel.delegate = new PickerDataModelDelegate() {

            @Override
            public void onValueChanged(PickerDataModel model) {
                //lblSelectedItem().text = pickerDataModel.selectedItem;
            }
        };

        // set our initial selection on the label
        //this.lblSelectedItem().text = pickerDataModel.selectedItem;
    }

    /**
     * This is our simple picker model. it uses a list of strings as it's dats
     */
    protected class PickerDataModel extends UIPickerViewModel {

        public PickerDataModelDelegate delegate;

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
            if (this.delegate != null) {
                this.delegate.onValueChanged(this);
            }
        }
    }

    protected interface PickerDataModelDelegate {

        void onValueChanged(PickerDataModel model);
    }

}
