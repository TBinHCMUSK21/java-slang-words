/*
 * Controller.MainViewController
 * Create by Bin
 * Date 11/10/23, 8:44 PM
 * Description:
 */

package Controller;

import View.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import Enum.*;

public class MainViewController implements Action {

    MainView mainView;

    public MainViewController(MainView mainView){
        this.mainView=mainView;
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
        if (str.equals("Display history search")){
            JPanel origin = mainView.map.get("Display history search");
            HistoryPageView newPanel = (HistoryPageView)(origin);
            newPanel.update();
        }
        if (str.equals("Search by slang word")){
            JPanel origin = mainView.map.get("Search by slang word");
            SearchSlangView newPanel = (SearchSlangView)(origin);
            newPanel.clearAll();
        }
        if (str.equals("Search by definition")){
            JPanel origin = mainView.map.get("Search by definition");
            SearchDefinitionView newPanel = (SearchDefinitionView)(origin);
            newPanel.clearAll();
        }
        if (str.equals("Reset the origin slang word")){
            JPanel origin = mainView.map.get("Reset the origin slang word");
            ResetSlangView newPanel = (ResetSlangView)(origin);
            newPanel.update();
        }
        mainView.cardLayout.show(mainView.cardPanel, e.getActionCommand());
    }
}
