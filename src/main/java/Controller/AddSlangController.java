/*
 * Controller.AddSlangController
 * Create by Bin
 * Date 11/8/23, 5:20 AM
 * Description:
 */

package Controller;

import View.AddSlangView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class AddSlangController implements Action {
    private AddSlangView currentView;

    public AddSlangController(AddSlangView currentView){
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
        if (str.equals("Add")){
            this.currentView.addANewSlang();
        }
    }
}
