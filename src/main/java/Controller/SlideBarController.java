/*
 * Controller.SlideBarController
 * Create by Bin
 * Date 11/7/23, 2:31 AM
 * Description:
 */

package Controller;

import View.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class SlideBarController implements MouseListener {
    private JFrame currentView = null;

    public SlideBarController(JFrame mainFrame) {
        this.currentView = mainFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFrame newView = null;
        String ec = e.getComponent().getName();
        switch (ec) {
            case "HomePage" -> {
                currentView.setVisible(false);
                currentView = new HomePageView();
                break;
            }
            case "Search by slang word" -> {
                currentView.setVisible(false);
                currentView = new SearchSlangView();
                break;
            }
            case "Search by definition" -> {
                currentView.setVisible(false);
                currentView = new SearchDefinitionView();
                break;
            }
            case "Display history search" -> {
                currentView.setVisible(false);
                currentView = new HistoryPageView();
                break;
            }
            case "Add a new slang word" -> {
                currentView.setVisible(false);
                currentView = new AddSlangView();
                break;
            }
            case "Edit a slang word" -> {
                currentView.setVisible(false);
                currentView =new EditSlangView();
                break;
            }
            case "Delete a slang word" -> {
                currentView.setVisible(false);
                currentView = new DeleteSlangView();
                break;
            }
            case "Reset the origin slang word" -> {
                currentView.setVisible(false);
                currentView = new ResetSlangView();
                break;
            }
            case "Random slang word" -> {
                currentView.setVisible(false);
                currentView = new RandomSlangView();
                break;
            }
            case "Game with slang word" -> {
                currentView.setVisible(false);
                currentView = new QuizSlangView();
                break;
            }
            case "Game with definitions" -> {
                currentView.setVisible(false);
                currentView = new QuizDefinitionView();
                break;
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



