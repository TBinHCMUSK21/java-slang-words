/*
 * View.DeleteSlang
 * Create by Bin
 * Date 11/6/23, 11:00 AM
 * Description: Delete Slang View
 */

package View;

import Controller.DeleteSlangController;
import Main.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.LinkedHashSet;

public class DeleteSlangView extends JFrame{

    public JTextField slangField;
    public DefaultTableModel tableModel;
    /**
     * The main frame layout
     */
    public DeleteSlangView() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 675);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Initialize the main components
     */
    private void initializeComponents() {
        Font mainFont = new Font("Arial", Font.PLAIN, 18);

        setLayout(new BorderLayout());
        SlideBarView sidebar = new SlideBarView(this);
        add(sidebar, BorderLayout.WEST);
        add(createMainContent(mainFont), BorderLayout.CENTER);
    }

    /**
     * Create the main content of the frame
     * @param font: font of the content
     * @return mainContent: JPanel of main content
     */
    private JPanel createMainContent(Font font) {
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createDeletePanel(font), BorderLayout.CENTER);
        mainContent.add(createSearchPanel(), BorderLayout.SOUTH);

        return mainContent;
    }

    /**
     * Create the title of the frame
     * @return mainTitle: a JLabel of the title
     */
    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("Delete slang word", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    /**
     * Create a Panel for input text to delete
     * @param font: font of the content
     * @return deletePanel: the panel of the delete frame
     */
    private JPanel createDeletePanel(Font font) {
        JPanel deletePanel = new JPanel();
        deletePanel.setLayout(new BoxLayout(deletePanel, BoxLayout.PAGE_AXIS));
        deletePanel.add(createInputPanel(font), BorderLayout.NORTH);
        return deletePanel;
    }

    /**
     * Create a panel for input the text to delete
     * @param font: font of the content
     * @return inputPanel: the panel to input text to delete
     */
    private JPanel createInputPanel(Font font) {
        DeleteSlangController action = new DeleteSlangController(this);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Title
        JLabel slangLabel = new JLabel("Slang Word:");
        slangLabel.setFont(font);
        gbc.weightx = 0.1;
        inputPanel.add(slangLabel, gbc);

        // Panel to input
        slangField = new JTextField(15);
        slangField.setFont(font);
        gbc.weightx = 1.0;
        inputPanel.add(slangField, gbc);

        // Button to find the definition of the slang
        JButton findButton = createButton("Find", font);
        gbc.weightx = 0.0;
        findButton.setText("Find");
        findButton.addActionListener(action);

        inputPanel.add(findButton, gbc);

        // Button to delete
        JButton deleteButton = createButton("Delete", font);
        gbc.weightx = 0.0;
        inputPanel.add(deleteButton, gbc);
        deleteButton.setText("Delete");
        deleteButton.addActionListener(action);

        // Deal with the space empty
        GridBagConstraints gbcFiller = new GridBagConstraints();
        gbcFiller.gridwidth = GridBagConstraints.REMAINDER;
        gbcFiller.fill = GridBagConstraints.BOTH;
        gbcFiller.weightx = 1;
        gbcFiller.weighty = 50;
        inputPanel.add(new JPanel(), gbcFiller);

        return inputPanel;
    }

    /**
     * Create a button
     * @param title: title of the button
     * @param font: font of the content
     * @return button: JButton
     */
    private JButton createButton(String title, Font font) {
        JButton button = new JButton(title);
        button.setFont(font);
        return button;
    }

    /**
     * Create a search panel to display the definition of the slang words
     * @return searchPanel:  a panel to display
     */
    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));
        searchPanel.add(createListScroller(), BorderLayout.CENTER);
        return searchPanel;
    }

    /**
     * A panel to display the list of the definition
     * @return JScrollPane: a table of all definition
     */
    private JScrollPane createListScroller() {
        tableModel = new DefaultTableModel(new Object[]{"STT", "Slang", "Meaning"}, 0) {
            public boolean isCellEditable(int row, int column) {
                // Not edit the table
                return false;
            }
        };

        // Create a table
        Font tableFont = new Font("Arial", Font.PLAIN, 16);
        JTable table = new JTable(tableModel);
        table.setFont(tableFont);
        JTableHeader header = table.getTableHeader();
        header.setFont(tableFont);

        // Add the value to the table



        // Edit the feature of table
        table.setFillsViewportHeight(false);
        table.setRowHeight(30);

        // Add the table to scrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        Dimension preferredSize = scrollPane.getPreferredSize();
        preferredSize.height = 330;
        scrollPane.setPreferredSize(preferredSize);

        // Display
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        return scrollPane;
    }

    public void findSlang() {
        String slang = slangField.getText();
        tableModel.setRowCount(0);
        if (Main.listSlangWord.getListSlangWord().get(slang)!=null){
            LinkedHashSet<String> definition = Main.listSlangWord.searchBySlang(slang);
            int count = 1;
            for (String string:definition){
                tableModel.addRow(new Object[]{count,slang,string});
                count = count + 1;
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Not Found");
        }
    }

    public void deleteSlang(){
        String slang = slangField.getText();
        if (Main.listSlangWord.getListSlangWord().get(slang)!=null){
            Object[] options = {"Yes", "No"};
            int result = JOptionPane.showOptionDialog(this,
                    "Are you sure to delete words?",
                    "Slang Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
            if (result==0){
                Main.listSlangWord.deleteSlang(slang);
                this.slangField.setText("");
                this.tableModel.setRowCount(0);
                JOptionPane.showMessageDialog(this,"Success!!!");
            }
            if (result==1){
                JOptionPane.showMessageDialog(this,"Cancel!!!");
            }

        }
        else{
            JOptionPane.showMessageDialog(this,"Not Found");
        }
    }
}
