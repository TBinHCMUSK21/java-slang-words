/*
 * View.HistoryPage
 * Create by Bin
 * Date 11/6/23, 9:23 AM
 * Description: The history page view
 */

package View;

import Controller.HistoryController;
import Main.Main;
import Model.SlangWordWithTime;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;

public class HistoryPageView extends JFrame {
    public DefaultTableModel tableModel;
    /**
     * The main frame
     */
    public HistoryPageView() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 675);
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
        HistoryController action = new HistoryController(this);

        JPanel historyPane = new JPanel();
        historyPane.setLayout(new BoxLayout(historyPane, BoxLayout.PAGE_AXIS));

        historyPane.add(createListScroller(),BorderLayout.CENTER);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(action);
        clearButton.setText("Clear");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 16));
        buttonPane.add(clearButton);

        historyPane.add(buttonPane, BorderLayout.PAGE_END);


        return historyPane;
    }

    /**
     * A table to display the list of slang words
     *
     * @return listScroller: JScrollPane of the history search
     */
    private JScrollPane createListScroller() {
         tableModel = new DefaultTableModel(new Object[]{"STT", "Slang", "Meaning","Time"}, 0) {
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
        int count = 1;
        for (SlangWordWithTime slangWord:Main.historySlangWord) {
            String key = slangWord.getSlangWords().getSlang();
            LinkedHashSet<String> value =slangWord.getSlangWords().getDefinitions();
            LocalDateTime time = slangWord.getTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
            String formattedDateTime = time.format(formatter);
            if (key==null){
                key="Not found";
            }
            if (value==null){
                tableModel.addRow(new Object[]{count,key,"Not Found",formattedDateTime});
            }
            else{
                tableModel.addRow(new Object[]{count,key,value,formattedDateTime});
            }
            count++;
        }

        // Feature for table
        table.setFillsViewportHeight(false);
        table.setRowHeight(30);

        // Add table to JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        Dimension preferredSize = scrollPane.getPreferredSize();
        preferredSize.height = 300;
        scrollPane.setPreferredSize(preferredSize);

        // Display window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        return scrollPane;
    }
    public void removeAllHistory() {
        Object[] options = {"Yes", "No"};
        int result = JOptionPane.showOptionDialog(this,
                "Are you sure to delete all history?",
                "Slang History",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (result == 1){
            JOptionPane.showMessageDialog(this,"Cancel!!!");
        }
        else{
            Main.historySlangWord.clear();
            tableModel.setRowCount(0);
            JOptionPane.showMessageDialog(this,"Success!!!");
        }

    }
}
