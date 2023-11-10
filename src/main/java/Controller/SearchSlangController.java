/*
 * Controller.SearchSlangController
 * Create by Bin
 * Date 11/8/23, 2:16 AM
 * Description:
 */

package Controller;
import View.SearchSlangView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;


public class SearchSlangController implements Action {
    private final SearchSlangView currentView;
    public SearchSlangController(SearchSlangView currentView ){
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
    public boolean accept(Object sender) {
        return Action.super.accept(sender);
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
            this.currentView.findSlang();
        }
        if (str.equals("Clear")){
            this.currentView.clearAll();
        }
    }
}
