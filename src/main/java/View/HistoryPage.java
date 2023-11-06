/*
 * View.HistoryPage
 * Create by Bin
 * Date 11/6/23, 9:23 AM
 * Description:
 */

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HistoryPage extends JFrame {
    private SlideBarView sidebar;
    private DefaultListModel<String> listModel;
    private JTextField searchField;

    public HistoryPage() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeComponents() {
        Font mainFont = new Font("Arial", Font.PLAIN, 18);

        setLayout(new BorderLayout());
        sidebar = new SlideBarView();
        add(sidebar, BorderLayout.WEST);

        add(createMainContent(mainFont), BorderLayout.CENTER);
    }

    private JPanel createMainContent(Font font) {
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createSearchPanel(font), BorderLayout.CENTER);

        return mainContent;
    }

    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("History", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    private JPanel createSearchPanel(Font font) {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));
        searchPanel.add(createListScroller(font), BorderLayout.CENTER);
        return searchPanel;
    }



    private JButton createButton(String title, Font font, ActionListener action) {
        JButton button = new JButton(title);
        button.setFont(font);
        button.addActionListener(action);
        return button;
    }

    private JButton createButton(String title, Font font) {
        return createButton(title, font, null);
    }

    private JScrollPane createListScroller(Font font) {
        listModel = new DefaultListModel<>();
        JList<String> wordList = new JList<>(listModel);
        wordList.setFont(font);
        wordList.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        listModel.addElement("History"); // Example element

        JScrollPane listScroller = new JScrollPane(wordList);
        listScroller.setPreferredSize(new Dimension(500, 500));
        listScroller.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return listScroller;
    }
}
