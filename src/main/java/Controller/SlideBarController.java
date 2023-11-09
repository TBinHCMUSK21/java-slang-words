/*
 * Controller.SlideBarController
 * Create by Bin
 * Date 11/7/23, 2:31 AM
 * Description:
 */

package Controller;

import View.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class SlideBarController implements MouseListener {
    private JFrame currentView;

    public SlideBarController(JFrame mainFrame) {
        this.currentView = mainFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String ec = e.getComponent().getName();
        switch (ec) {
            case "HomePage" -> {
                currentView.setVisible(false);
                currentView = new HomePageView();
            }
            case "Search by slang word" -> {
                currentView.setVisible(false);
                currentView = new SearchSlangView();
            }
            case "Search by definition" -> {
                currentView.setVisible(false);
                currentView = new SearchDefinitionView();
            }
            case "Display history search" -> {
                currentView.setVisible(false);
                currentView = new HistoryPageView();
            }
            case "Add a new slang word" -> {
                currentView.setVisible(false);
                currentView = new AddSlangView();
            }
            case "Edit a slang word" -> {
                currentView.setVisible(false);
                currentView = new EditSlangView();
            }
            case "Delete a slang word" -> {
                currentView.setVisible(false);
                currentView = new DeleteSlangView();
            }
            case "Reset the origin slang word" -> {
                currentView.setVisible(false);
                currentView = new ResetSlangView();
            }
            case "Random slang word" -> {
                currentView.setVisible(false);
                currentView = new RandomSlangView();
            }
            case "Game with slang word" -> {
                currentView.setVisible(false);
                currentView = new QuizSlangView();
            }
            case "Game with definitions" -> {
                currentView.setVisible(false);
                currentView = new QuizDefinitionView();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
