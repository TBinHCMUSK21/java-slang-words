/*
 * Controller.RandomSlangController
 * Create by Bin
 * Date 11/9/23, 12:08 AM
 * Description:
 */

package Controller;

import View.RandomSlangView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class RandomSlangController implements Action {
    private final RandomSlangView currentView;

    public RandomSlangController(RandomSlangView currentView){
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
        String str =e.getActionCommand();
        if (str.equals("Random")){
            this.currentView.randomSlang();
        }

    }
}
