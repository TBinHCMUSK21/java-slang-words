/*
 * Controller.QuizDefinitionController
 * Create by Bin
 * Date 11/9/23, 7:51 PM
 * Description:
 */

package Controller;

import View.QuizDefinitionView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class QuizDefinitionController implements Action {

    private final QuizDefinitionView currentView;
    public QuizDefinitionController(QuizDefinitionView currentView){
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
        if (str.equals("Next")){
            this.currentView.randomNew();
        }
        else if (str.equals(""+this.currentView.rightOption)){
            this.currentView.displayRightChoose();
        }
        else{
            this.currentView.displayWrongChoose(str);
        }
    }
}
