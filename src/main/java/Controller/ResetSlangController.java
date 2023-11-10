/*
 * Controller.ResetSlangController
 * Create by Bin
 * Date 11/8/23, 5:21 AM
 * Description:
 */

package Controller;

import View.ResetSlangView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class ResetSlangController implements Action {
    private final ResetSlangView currentView;
    public ResetSlangController(ResetSlangView currentView){
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
        if (e.getActionCommand().equals("Reset")){
            currentView.resetTheOrigin();
            JOptionPane.showMessageDialog(currentView,"Success");
        }
    }
}
