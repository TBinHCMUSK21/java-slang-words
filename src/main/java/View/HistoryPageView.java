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
        setSize(900, 675);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Add the sidebar
     */
    private void initializeComponents() {
        setLayout(new BorderLayout());
        SlideBarView sidebar = new SlideBarView(this);
        add(sidebar, BorderLayout.WEST);
        add(createMainContent(), BorderLayout.CENTER);
    }

    /**
     * Create a main content
     *
     * @return mainContent: The main content
     */
    private JPanel createMainContent() {
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createHistoryPane(), BorderLayout.CENTER);
        return mainContent;
    }

    /**
     * Create a title of the frame
     * @return mainTitle: JLabel for a title
     */
    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("History Search", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    /**
     * Create a history pane to display the history
     *
     * @return historyPane: The JPanel to display the history search
     */
    private JPanel createHistoryPane() {
        JPanel historyPane = new JPanel();
        historyPane.setLayout(new BoxLayout(historyPane, BoxLayout.PAGE_AXIS));
        historyPane.add(createListScroller(), BorderLayout.CENTER);
        return historyPane;
    }

    /**
     * A table to display the list of slang words
     *
     * @return listScroller: JScrollPane of the history search
     */
    private JScrollPane createListScroller() {
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"STT", "Slang", "Meaning"}, 0) {
            public boolean isCellEditable(int row, int column) {
                // Not edit the table
                return false;
            }
        };

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
