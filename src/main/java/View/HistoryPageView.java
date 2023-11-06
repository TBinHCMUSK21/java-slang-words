/*
 * View.HistoryPage
 * Create by Bin
 * Date 11/6/23, 9:23 AM
 * Description: The history page view
 */

package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class HistoryPageView extends JFrame {
    /**
     * The main frame
     */
    public HistoryPageView() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Add the sidebar
     */
    private void initializeComponents() {
        Font mainFont = new Font("Arial", Font.PLAIN, 18);

        setLayout(new BorderLayout());
        SlideBarView sidebar = new SlideBarView();
        add(sidebar, BorderLayout.WEST);

        add(createMainContent(mainFont), BorderLayout.CENTER);
    }

    /**
     * Create a main content
     * @param font: font of the content
     * @return mainContent: The main content
     */
    private JPanel createMainContent(Font font) {
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createHistoryPane(font), BorderLayout.CENTER);
        return mainContent;
    }

    /**
     * Create a title of the frame
     * @return mainTitle: JLable for a title
     */
    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("History Search", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    /**
     * Create a history pane to display the history
     * @param font: font of the main content
     * @return historyPane: The JPanel to display the history search
     */
    private JPanel createHistoryPane(Font font) {
        JPanel historyPane = new JPanel();
        historyPane.setLayout(new BoxLayout(historyPane, BoxLayout.PAGE_AXIS));
        historyPane.add(createListScroller(font), BorderLayout.CENTER);
        return historyPane;
    }

    /**
     * A table to display the list of distory
     * @param font: font of the content
     * @return listScroller: JSrollPane of the history search
     */
    private JScrollPane createListScroller(Font font) {
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"STT", "Slang", "Meaning"}, 0) {};

        // Create Table
        Font tableFont = new Font("Arial", Font.PLAIN, 16);
        JTable table = new JTable(tableModel);
        table.setFont(tableFont);
        JTableHeader header = table.getTableHeader();
        header.setFont(tableFont);

        // Add data to table
        tableModel.addRow(new Object[]{1, "Slang 1", "Meaning 1"});
        tableModel.addRow(new Object[]{2, "Slang 2", "Meaning 2"});
        tableModel.addRow(new Object[]{3, "Slang 3", "Meaning 3"});


        // Feature for table
        table.setFillsViewportHeight(false);
        table.setRowHeight(30);

        // Add table to JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        Dimension preferredSize = scrollPane.getPreferredSize();
        preferredSize.height = 370;
        scrollPane.setPreferredSize(preferredSize);

        // Display window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        return scrollPane;
    }
}
