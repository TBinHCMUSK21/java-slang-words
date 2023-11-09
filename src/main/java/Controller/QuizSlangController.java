/*
 * Controller.QuizSlangController
 * Create by Bin
 * Date 11/9/23, 1:12 AM
 * Description:
 */

package Controller;

import View.QuizSlangView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class QuizSlangController implements Action {

    private final QuizSlangView currentView;

    public QuizSlangController(QuizSlangView currentView){
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

    }
}
