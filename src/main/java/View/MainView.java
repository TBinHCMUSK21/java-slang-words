/*
 * View.MainView
 * Create by Bin
 * Date 11/10/23, 11:45 AM
 * Description:
 */

package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import Controller.MainViewController;
import Enum.*;

public class MainView  extends JFrame{
    public JPanel cardPanel;
    public CardLayout cardLayout;
    public HashMap<String,JPanel> map = new HashMap<>();

    public MainView() {
        setTitle("Slang words dictionary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 675);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(11, 1));
        String[] titleOfTheSideBar = {
                "HomePage",
                "Search by slang word",
                "Search by definition",
                "Display history search",
                "Add a new slang word",
                "Edit a slang word",
                "Delete a slang word",
                "Reset the origin slang word",
                "Random slang word",
                "Game with slang word",
                "Game with definitions"
        };

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        MainViewController action = new MainViewController(this);
        for (int i = 0; i < ViewType.values().length; i++) {
            JButton button = new JButton(titleOfTheSideBar[i]);
            leftPanel.add(button);
            button.addActionListener(action);
            JPanel panel = ViewFactory.getView(ViewType.values()[i]);
            cardPanel.add(panel,titleOfTheSideBar[i]);
            map.put(titleOfTheSideBar[i],panel);
        }

        Container contentPane = getContentPane();
        contentPane.add(leftPanel, BorderLayout.WEST);
        contentPane.add(cardPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
