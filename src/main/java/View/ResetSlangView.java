/*
 * View.ResetSlangTest
 * Create by Bin
 * Date 11/10/23, 1:08 PM
 * Description:
 */

package View;


import Controller.ResetSlangController;
import Main.Main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Map;

import static Main.Main.listSlangWord;
import static Main.Main.originSlangWord;

public class ResetSlangView extends JPanel {
    public DefaultTableModel tableModel;
    public ResetSlangView() {
        initializeComponents();
    }

    private void initializeComponents() {
        Font mainFont = new Font("Arial", Font.PLAIN, 18);
        setLayout(new BorderLayout());
        add(createMainContent(mainFont), BorderLayout.CENTER);
    }
    private JPanel createMainContent(Font font) {
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createResetPanel(font), BorderLayout.CENTER);
        mainContent.add(createSearchPanel(), BorderLayout.SOUTH);

        return mainContent;
    }
    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("Reset Slang Words", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }
    private JPanel createResetPanel(Font font) {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));
        searchPanel.add(createInputPanel(font), BorderLayout.NORTH);
        return searchPanel;
    }
    private JPanel createInputPanel(Font font) {
        ResetSlangController action = new ResetSlangController(this);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel slangLabel = new JLabel("Do you want to reset the origin slang dictionary");
        slangLabel.setHorizontalAlignment(SwingConstants.LEFT);
        slangLabel.setFont(font);
        gbc.weightx = 0.1;
        inputPanel.add(slangLabel, gbc);

        JButton resetButton = createButton("Reset", font);
        resetButton.addActionListener(action);
        gbc.weightx = 0.0;

        inputPanel.add(resetButton, gbc);

        return inputPanel;
    }

    private JButton createButton(String title, Font font) {
        JButton button = new JButton(title);
        button.setFont(font);
        return button;
    }
    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));
        searchPanel.add(createListScroller(), BorderLayout.CENTER);
        return searchPanel;
    }
    private JScrollPane createListScroller() {
        tableModel = new DefaultTableModel(new Object[]{"STT", "Slang", "Meaning"}, 0) {
            public boolean isCellEditable(int row, int column) {
                // Not allow to edit
                return false;
            }
        };

        // Create a table
        Font tableFont = new Font("Arial", Font.PLAIN, 16);
        JTable table = new JTable(tableModel);
        table.setFont(tableFont);
        JTableHeader header = table.getTableHeader();
        header.setFont(tableFont);

        // Add data to table
        update();

        // Attribute for table
        table.setFillsViewportHeight(false);
        table.setRowHeight(30);

        // Add table to JScrollPane
        return new JScrollPane(table);
    }

    public void resetTheOrigin() {
        Main.listSlangWord.copy(originSlangWord);
        tableModel.setRowCount(0);
        int count = 1;
        for (Map.Entry<String, LinkedHashSet<String>> entry : listSlangWord.getListSlangWord().entrySet()) {
            String key = entry.getKey();
            LinkedHashSet<String> value = entry.getValue();
            tableModel.addRow(new Object[]{count,key,value});
            count++;
        }
    }
    public void update(){
        this.tableModel.setRowCount(0);
        int count = 1;
        for (Map.Entry<String, LinkedHashSet<String>> entry : listSlangWord.getListSlangWord().entrySet()) {
            String key = entry.getKey();
            LinkedHashSet<String> value = entry.getValue();
            tableModel.addRow(new Object[]{count,key,value});
            count++;
        }
    }
}