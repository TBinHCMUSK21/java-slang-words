/*
 * View.test
 * Create by Bin
 * Date 11/6/23, 9:31 AM
 * Description: Search Definition View
 */

package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.LinkedHashSet;

import Controller.SearchDefinitionController;
import Main.*;
import Model.OneSlangWord;


public class SearchDefinitionView extends JFrame {
    public DefaultTableModel listModel;
    public JTextField searchField;

    public SearchDefinitionView() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 675);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void initializeComponents() {
        Font mainFont = new Font("Arial", Font.PLAIN, 18);

        setLayout(new BorderLayout());
        SlideBarView sidebar = new SlideBarView(this);
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
        JLabel mainTitle = new JLabel("Search by definition", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    private JPanel createSearchPanel(Font font) {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));

        searchPanel.add(createInputPanel(font), BorderLayout.NORTH);
        searchPanel.add(createListScroller(font), BorderLayout.CENTER);

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

    private JScrollPane createListScroller(Font font) {
        listModel = new DefaultTableModel(new Object[]{"STT", "Slang", "Meaning"}, 0) {};
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

    public void searchDefinition() {
        listModel.setRowCount(0);
        String definition = searchField.getText();
        LinkedHashSet<OneSlangWord> result = Main.listSlangWord.searchByDefinition(definition);
        if (!result.isEmpty()){
            int count = 1;
            for (OneSlangWord item:result){
                listModel.addRow(new Object[]{count,item.getSlang(),item.getDefinitions().getFirst()});
                count = count + 1;
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Not Found");
        }
    }

    public void clearAll() {
        listModel.setRowCount(0);
        searchField.setText("");
    }
}
