/*
 * View.AddSlang
 * Create by Bin
 * Date 11/6/23, 9:55 AM
 * Description:
 */

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddSlang extends JFrame {
    private SlideBarView sidebar;
    private JTextField slangField;

    private JTextField definitionField;

    public AddSlang() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeComponents() {
        Font mainFont = new Font("Arial", Font.PLAIN, 18);

        setLayout(new BorderLayout());
        sidebar = new SlideBarView();
        add(sidebar, BorderLayout.WEST);
        add(createMainContent(mainFont), BorderLayout.CENTER);
    }

    private JPanel createMainContent(Font font) {
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createAddPanel(font), BorderLayout.CENTER);
        return mainContent;
    }

    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("Add a new slang words", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    private JPanel createAddPanel(Font font) {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));
        searchPanel.add(createInputPanel(font), BorderLayout.NORTH);
        return searchPanel;
    }

    private JPanel createInputPanel(Font font) {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel slangLabel = new JLabel("Slang Word:");
        slangLabel.setFont(font);
        gbc.weightx = 0.1;
        inputPanel.add(slangLabel, gbc);

        slangField = new JTextField(15);
        slangField.setFont(font);
        gbc.weightx = 1.0;
        inputPanel.add(slangField, gbc);

        JLabel definitionLabel = new JLabel("Definition Word:");
        definitionLabel.setFont(font);
        gbc.weightx = 0.1;
        inputPanel.add(definitionLabel, gbc);

        definitionField = new JTextField(15);
        definitionField.setFont(font);
        gbc.weightx = 1.0;
        inputPanel.add(definitionField, gbc);

        JButton addButton = createButton("Add", font);
        gbc.weightx = 0.0;

        inputPanel.add(addButton, gbc);


        GridBagConstraints gbcFiller = new GridBagConstraints();
        gbcFiller.gridwidth = GridBagConstraints.REMAINDER;
        gbcFiller.fill = GridBagConstraints.BOTH;
        gbcFiller.weightx = 1;
        gbcFiller.weighty = 100;
        inputPanel.add(new JPanel(), gbcFiller);
        return inputPanel;
    }

    private JButton createButton(String title, Font font, ActionListener action) {
        JButton button = new JButton(title);
        button.setFont(font);
        button.addActionListener(action);
        return button;
    }

    private JButton createButton(String title, Font font) {
        return createButton(title, font, null);
    }


}
