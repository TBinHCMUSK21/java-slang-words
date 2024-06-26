/*
 * View.EditSlangTest
 * Create by Bin
 * Date 11/10/23, 1:04 PM
 * Description:
 */

package View;


import Controller.EditSlangController;
import Controller.TableModelChangeController;
import Main.Main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.LinkedHashSet;

public class EditSlangView extends JPanel {
    public JTextField slangField;
    public DefaultTableModel tableModel;

    public DefaultTableModel previousTableModel;

    /**
     * Main frame
     */
    public EditSlangView() {
        initializeComponents();
    }

    /**
     * Add the sidebar
     */
    private void initializeComponents() {
        Font mainFont = new Font("Arial", Font.PLAIN, 18);
        setLayout(new BorderLayout());
        add(createMainContent(mainFont), BorderLayout.CENTER);
    }

    /**
     * Create a main content of frame
     * @param font: Font of the content
     * @return mainContent: a JPanel of the main content
     */
    private JPanel createMainContent(Font font) {
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createEditPanel(font), BorderLayout.CENTER);
        mainContent.add(createSearchPanel(), BorderLayout.SOUTH);

        return mainContent;
    }

    /**
     * Create a title of the main content
     * @return mainTitle: The main title of the main content
     */
    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("Edit slang word", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    /**
     * Create the Edit panel
     * @param font: font of the main content
     * @return editPanel: the JPanel edit panel
     */
    private JPanel createEditPanel(Font font) {
        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.PAGE_AXIS));
        editPanel.add(createInputPanel(font), BorderLayout.NORTH);
        return editPanel;
    }

    /**
     * The input panel to get the user input
     * @param font: font of the main content
     * @return inputPanel: The JPanel to input the slang word
     */
    private JPanel createInputPanel(Font font) {
        EditSlangController action = new EditSlangController(this);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        // Create Layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add the title
        JLabel slangLabel = new JLabel("Slang Word:");
        slangLabel.setFont(font);
        gbc.weightx = 0.1;
        inputPanel.add(slangLabel, gbc);

        // Add the field to input
        slangField = new JTextField(15);
        slangField.setFont(font);
        gbc.weightx = 1.0;
        inputPanel.add(slangField, gbc);

        // Add the button
        JButton findButton = createButton("Find", font);
        gbc.weightx = 0.0;
        findButton.setText("Find");
        findButton.addActionListener(action);

        inputPanel.add(findButton, gbc);
        return inputPanel;
    }

    /**
     * Create a button
     * @param title: A button title
     * @param font: A font of the main content
     * @return button: A JButton button
     */
    private JButton createButton(String title, Font font) {
        JButton button = new JButton(title);
        button.setFont(font);
        return button;
    }

    /**
     * A panel to display a list of definition
     * @return searchPanel: A JPanel to display
     */
    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));
        searchPanel.add(createListScroller(), BorderLayout.CENTER);
        return searchPanel;
    }

    /**
     * Create a table to display a list slang-definition
     * @return scrollPane: A JScrollPane to display a list slang-definitions
     */
    private JScrollPane createListScroller() {

        TableModelChangeController action = new TableModelChangeController(this);
        tableModel = new DefaultTableModel(new Object[]{"STT", "Slang", "Meaning"}, 0) {};

        // Create Table
        Font tableFont = new Font("Arial", Font.PLAIN, 16);
        JTable table = new JTable(tableModel);
        table.setFont(tableFont);
        JTableHeader header = table.getTableHeader();
        header.setFont(tableFont);

        // Add data to table
        tableModel.setRowCount(0);
        tableModel.addTableModelListener(action);

        // Feature for table
        table.setFillsViewportHeight(false);
        table.setRowHeight(30);

        // Add table to JScrollPane
        return new JScrollPane(table);
    }

    public void findTheSlang() {
        tableModel.setRowCount(0);
        String slang = slangField.getText();
        LinkedHashSet<String> slangFind = Main.listSlangWord.searchBySlang(slang);
        previousTableModel = new DefaultTableModel(new Object[]{"STT", "Slang", "Meaning"}, 0) {};
        if (!slangFind.isEmpty()){
            int count = 1;
            for (String slangItem:slangFind){
                LinkedHashSet<String> definition = Main.listSlangWord.getListSlangWord().get(slangItem);
                for (String string:definition) {
                    tableModel.addRow(new Object[]{count, slang, string});
                    previousTableModel.addRow(new Object[]{count, slang, string});
                    count = count + 1;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Not Found");
        }
    }

    public void editTheSlang(int row,int column) {
        if (row >= 0 && column >= 0) {
            String new_slang = (String)tableModel.getValueAt(row,1);
            String new_definition = (String)tableModel.getValueAt(row,2);
            String prev_slang = (String) this.previousTableModel.getValueAt(row,1);
            String prev_definition = (String) this.previousTableModel.getValueAt(row,2);
            if (!new_slang.equals(prev_slang)){
                Main.listSlangWord.editSlang(prev_slang,new_slang);
                JOptionPane.showMessageDialog(this,"Success!!!");
            }
            else if (!new_definition.equals(prev_definition)){
                Main.listSlangWord.editDefinition(prev_definition,new_definition,prev_slang);
                JOptionPane.showMessageDialog(this,"Success!!!");
            }
            this.slangField.setText("");
            this.tableModel.setRowCount(0);
        }
    }
}