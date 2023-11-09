/*
 * View.AddSlang
 * Create by Bin
 * Date 11/6/23, 9:55 AM
 * Description: The AddSlang Page
 */

package View;

import Controller.AddSlangController;
import Main.Main;
import Utils.HistorySlangFileHelpers;
import Utils.SlangFileHelpers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class AddSlangView extends JFrame {

    public JTextField slangField;
    public JTextField definitionField;

    /**
     * The main frame
     */
    public AddSlangView() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 675);
        setLocationRelativeTo(null);
        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SlangFileHelpers fileHelpersOut = SlangFileHelpers.getInstance();
                fileHelpersOut.setPath("slang-new.txt");
                try {
                    fileHelpersOut.writeLines(Main.listSlangWord);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                HistorySlangFileHelpers historySlangFileHelpers = HistorySlangFileHelpers.getInstance();
                historySlangFileHelpers.setPath("history-slang.txt");
                try {
                    historySlangFileHelpers.writeLines(Main.historySlangWord);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    /**
     * Initial the sidebar in the left of frame
     */
    private void initializeComponents() {
        Font mainFont = new Font("Arial", Font.PLAIN, 18);
        setLayout(new BorderLayout());
        SlideBarView sidebar = new SlideBarView(this);
        add(sidebar, BorderLayout.WEST);
        add(createMainContent(mainFont), BorderLayout.CENTER);
    }

    /**
     * Create the main content in the center
     * @param font: Font of the content
     * @return mainContent: The main JPanel content in center
     */
    private JPanel createMainContent(Font font) {
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createAddPanel(font), BorderLayout.CENTER);
        return mainContent;
    }

    /**
     * Initial the title in the center top of the main content
     * @return mainTitle: The main title of the content
     */

    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("Add a new slang words", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    /**
     * Add the input panel to get input from the user
     * @param font: font of the content
     * @return addPanel: The JPanel of the input
     */
    private JPanel createAddPanel(Font font) {
        JPanel addPanel = new JPanel();
        addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.PAGE_AXIS));
        addPanel.add(createInputPanel(font), BorderLayout.NORTH);
        return addPanel;
    }

    /**
     * Design the input panel
     * @param font: font of the content
     * @return inputPanel: the JPanel of the input
     */

    private JPanel createInputPanel(Font font) {

        AddSlangController action = new AddSlangController(this);

        // Initial the input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        // Create a border
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Label of the field input slang
        JLabel slangLabel = new JLabel("Slang Word:");
        slangLabel.setFont(font);
        gbc.weightx = 0.1;
        inputPanel.add(slangLabel, gbc);

        // Field to input the slang word
        slangField = new JTextField(15);
        slangField.setFont(font);
        gbc.weightx = 1.0;
        inputPanel.add(slangField, gbc);

        // Label of the field input definition
        JLabel definitionLabel = new JLabel("Definition Word:");
        definitionLabel.setFont(font);
        gbc.weightx = 0.1;
        inputPanel.add(definitionLabel, gbc);

        // Field to input the definition
        definitionField = new JTextField(15);
        definitionField.setFont(font);
        gbc.weightx = 1.0;
        inputPanel.add(definitionField, gbc);

        // Button add to add the new slang
        JButton addButton = createButton("Add", font);
        addButton.setName("Add");
        gbc.weightx = 0.0;
        inputPanel.add(addButton, gbc);
        addButton.addActionListener(action);

        // Deal with the space empty to push the content to the top
        GridBagConstraints gbcFiller = new GridBagConstraints();
        gbcFiller.gridwidth = GridBagConstraints.REMAINDER;
        gbcFiller.fill = GridBagConstraints.BOTH;
        gbcFiller.weightx = 1;
        gbcFiller.weighty = 100;
        inputPanel.add(new JPanel(), gbcFiller);

        return inputPanel;
    }

    /**
     * Create the button
     * @param title: The title of the button
     * @param font: Font of the button
     * @return button: JButton of the button
     */
    private JButton createButton(String title, Font font) {
        JButton button = new JButton(title);
        button.setFont(font);
        return button;
    }

    public void addANewSlang() {
        String slang = slangField.getText();
        String userDefinition = definitionField.getText();
        LinkedHashSet<String>  definition = new LinkedHashSet<>
                (Arrays.stream(userDefinition.split("\\|"))
                .map(String::trim)
                .toList());
        if (Main.listSlangWord.getListSlangWord().get(slang)!=null){
            Object[] options = {"Overwrite", "Duplicate", "Cancel"};
            int result = JOptionPane.showOptionDialog(this,
                    "This slang word already exists. What would you like to do?",
                    "Slang Exists",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);
            if (result == JOptionPane.YES_OPTION) {
                Main.listSlangWord.getListSlangWord().put(slang,definition);
                JOptionPane.showMessageDialog(this,"Success!!!");
            }
            if (result == JOptionPane.NO_OPTION){
                Main.listSlangWord.getListSlangWord().get(slang).addAll(definition);
                JOptionPane.showMessageDialog(this,"Success!!!");
            }
        }
        else {
            Main.listSlangWord.getListSlangWord().put(slang,definition);
            JOptionPane.showMessageDialog(this,"Success!!!");
        }
        this.slangField.setText("");
        this.definitionField.setText("");
    }
}
