/*
 * Controller.EditSlangController
 * Create by Bin
 * Date 11/8/23, 2:41 PM
 * Description:
 */

package Controller;

import View.EditSlangView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class EditSlangController implements Action {
    private final EditSlangView currentView;
    public EditSlangController(EditSlangView currentView){
        this.currentView=currentView;
    }
    @Override
    public Object getValue(String key) {
        return null;
    }

    @Override
    public void putValue(String key, Object value) {

    }

    @Override
    public void setEnabled(boolean b) {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Find")){
            this.currentView.findTheSlang();
        }

    }
}
