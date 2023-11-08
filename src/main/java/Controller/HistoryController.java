/*
 * Controller.HistoryController
 * Create by Bin
 * Date 11/8/23, 4:52 AM
 * Description:
 */

package Controller;

import View.HistoryPageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class HistoryController implements Action {
    private final HistoryPageView currentView;

    public HistoryController(HistoryPageView currentView){
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
        if (str.equals("Clear")){
            this.currentView.removeAllHistory();
        }
    }
}
