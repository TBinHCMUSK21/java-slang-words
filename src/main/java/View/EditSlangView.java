/*
 * View.EditSlang
 * Create by Bin
 * Date 11/6/23, 10:27 AM
 * Description: The edit slang words view
 */

package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;


public class EditSlangView extends JFrame {
    /**
     * Main frame
     */
    public EditSlangView() {
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
        Font mainFont = new Font("Arial", Font.PLAIN, 18);

        setLayout(new BorderLayout());
        SlideBarView sidebar = new SlideBarView(this);
        add(sidebar, BorderLayout.WEST);
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
        JTextField slangField = new JTextField(15);
        slangField.setFont(font);
        gbc.weightx = 1.0;
        inputPanel.add(slangField, gbc);

        // Add the button
        JButton findButton = createButton("Find", font);
        gbc.weightx = 0.0;

        inputPanel.add(findButton, gbc);

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
