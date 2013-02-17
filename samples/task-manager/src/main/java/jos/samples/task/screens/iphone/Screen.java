package jos.samples.task.screens.iphone;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIControlState;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UITextField;
import jos.api.uikit.UIViewController;
import jos.samples.task.EventListener;

public class Screen extends UIViewController {

    @Outlet
    UITextField txtName;

    @Outlet
    UITextField txtNotes;

    @Outlet
    UIButton btnCancelDelete;

    @Outlet
    UIButton btnSave;

    Task _task;

    public Screen (Task task) {
        super("Screen", null);
        _task = task;
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        setTitle("Details");

        // set the cancel delete based on whether or not it's an existing task
        btnCancelDelete.setTitle((_task.ID == 0 ? "Cancel" : "Delete"), UIControlState.NORMAL);

        txtName.setText(_task.getName());
        txtNotes.setText(_task.getNotes());

        btnCancelDelete.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                cancelDelete();
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
        btnSave.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                save();
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);

        txtName.setReturnKeyType(UIReturnKeyType.NEXT);
        txtName.shouldReturn();// += (t) => { this.txtNotes.BecomeFirstResponder(); return true; };

        txtNotes.setReturnKeyType(UIReturnKeyType.DONE);
        txtNotes.shouldReturn();// += (t) => { this.txtNotes.ResignFirstResponder(); return true; };
    }

    protected void save()
    {
        _task.setName(txtName.getText());
        _task.setNotes(txtNotes.getText());
        TaskManager.saveTask(_task);
        getNavigationController().popViewControllerAnimated(true);
    }

    protected void cancelDelete()
    {
        if(_task.ID != 0)
        {
            TaskManager.deleteTask(_task.ID);
        }

        getNavigationController().popViewControllerAnimated(true);
    }

}
