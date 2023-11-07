/*
 * Controller.SearchDefinitionController
 * Create by Bin
 * Date 11/8/23, 3:42 AM
 * Description:
 */

package Controller;


import View.SearchDefinitionView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class SearchDefinitionController implements Action {

    private final SearchDefinitionView currentView;

    public SearchDefinitionController(SearchDefinitionView currentView){
        this.currentView = currentView;
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
            this.currentView.searchDefinition();
        }
        if (str.equals("Clear")){
            this.currentView.clearAll();
        }
    }
}
