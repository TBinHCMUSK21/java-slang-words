/*
 * View.HistoryPageTest
 * Create by Bin
 * Date 11/10/23, 1:00 PM
 * Description:
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

public class HistoryPageView extends JPanel{
    public DefaultTableModel tableModel;
    /**
     * The main frame
     */
    public HistoryPageView() {
        initializeComponents();
    }
    /**
     * Add the sidebar
     */
    private void initializeComponents() {
        setLayout(new BorderLayout());
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

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(action);
        updateButton.setText("Update");
        updateButton.setFont(new Font("Arial", Font.PLAIN, 16));


        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(action);
        clearButton.setText("Clear");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 16));

        buttonPane.add(updateButton);
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
        updateHistory();

        // Feature for table
        table.setFillsViewportHeight(false);
        table.setRowHeight(30);

        // Add table to JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        Dimension preferredSize = scrollPane.getPreferredSize();
        preferredSize.height = 300;
        scrollPane.setPreferredSize(preferredSize);

        return scrollPane;
    }
    public void removeAllHistory() {
        Object[] options = {"Yes", "No"};
        int result = JOptionPane.showOptionDialog(this,
                "Are you sure to delete all history?",
                "Slang History",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (result == JOptionPane.YES_OPTION){
            Main.historySlangWord.clear();
            tableModel.setRowCount(0);
            JOptionPane.showMessageDialog(this,"Success!!!");
        }
        else if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(this,"Cancel!!!");
        }

    }

    public void updateHistory() {
        this.tableModel.setRowCount(0);
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
    }
}
