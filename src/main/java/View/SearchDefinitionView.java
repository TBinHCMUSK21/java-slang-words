/*
 * View.SearchDefinitionTest
 * Create by Bin
 * Date 11/10/23, 12:56 PM
 * Description:
 */

package View;

import Controller.SearchDefinitionController;
import Main.Main;
import Model.OneSlangWord;
import Model.SlangWordWithTime;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashSet;

public class SearchDefinitionView extends JPanel {
    public DefaultTableModel listModel;
    public JTextField searchField;

    public SearchDefinitionView() {
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
        mainContent.add(createSearchPanel(font), BorderLayout.CENTER);
        return mainContent;
    }

    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("Search by definition", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    private JPanel createSearchPanel(Font font) {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));
        searchPanel.add(createInputPanel(font), BorderLayout.NORTH);
        searchPanel.add(createListScroller(), BorderLayout.CENTER);

        return searchPanel;
    }

    private JPanel createInputPanel(Font font) {
        SearchDefinitionController action = new SearchDefinitionController(this);
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        searchField = new JTextField(15);
        searchField.setFont(font);

        JLabel contentTitle = new JLabel("Input the definition:");
        contentTitle.setFont(font);

        JButton findButton = createButton("Find", font);
        findButton.addActionListener(action);
        JButton clearButton = createButton("Clear",font);
        clearButton.addActionListener(action);

        inputPanel.add(contentTitle);
        inputPanel.add(searchField);
        inputPanel.add(findButton);
        inputPanel.add(clearButton);

        return inputPanel;
    }

    private JButton createButton(String title, Font font) {

        JButton button = new JButton(title);
        button.setFont(font);
        return button;
    }

    private JScrollPane createListScroller() {
        listModel = new DefaultTableModel(new Object[]{"STT", "Slang", "Meaning"}, 0) { public boolean isCellEditable(int row, int column) {
            // Not edit the table
            return false;
        }};
        // Create Table
        Font tableFont = new Font("Arial", Font.PLAIN, 16);
        JTable table = new JTable(listModel);
        table.setFont(tableFont);
        JTableHeader header = table.getTableHeader();
        header.setFont(tableFont);

        // Add data to table
        listModel.setRowCount(0);


        // Feature for table
        table.setFillsViewportHeight(false);
        table.setRowHeight(30);

        // Add table to JScrollPane

        return new JScrollPane(table);
    }

    public void searchDefinition() {
        listModel.setRowCount(0);
        String definition = searchField.getText();
        LinkedHashSet<String> result = Main.listSlangWord.searchByDefinition(definition);
        if (!result.isEmpty()){
            int count = 1;
            for (String item:result){
                listModel.addRow(new Object[]{count,item,Main.listSlangWord.getListSlangWord().get(item)});
                LocalDateTime time = LocalDateTime.now();
                Main.historySlangWord.add(new SlangWordWithTime(new OneSlangWord(item,
                        Main.listSlangWord.getListSlangWord().get(item)),time));
                count = count + 1;
            }

        }
        else{
            LocalDateTime time = LocalDateTime.now();
            Main.historySlangWord.add(new SlangWordWithTime(new OneSlangWord(null,
                    new LinkedHashSet<>(Collections.singletonList(definition))),time));
            JOptionPane.showMessageDialog(this,"Not Found");
        }
    }

    public void clearAll() {
        listModel.setRowCount(0);
        searchField.setText("");
    }
}