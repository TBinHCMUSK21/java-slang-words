/*
 * View.RandomSlang
 * Create by Bin
 * Date 11/6/23, 12:27 PM
 * Description:
 */

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RandomSlang extends JFrame{
    private SlideBarView sidebar;
    public RandomSlang() {
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

    private JPanel createMainContent(Font font){
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createContentPanel(font), BorderLayout.CENTER);
        return mainContent;
    }
    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("Random Slang Words", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }
    private JPanel createContentPanel(Font font) {
        JPanel contentPage = new JPanel();
        contentPage.setLayout(new GridBagLayout());
        contentPage.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel slangLabel = new JLabel("Slang Word:");
        slangLabel.setFont(font);
        gbc.weightx = 0.1;
        contentPage.add(slangLabel, gbc);

        JTextField slangField = new JTextField(15);
        slangField.setFont(font);
        slangField.setEditable(false);
        slangField.setText("Slang words");
        gbc.weightx = 1.0;
        contentPage.add(slangField, gbc);

        JLabel definitionLabel = new JLabel("Definition Word:");
        definitionLabel.setFont(font);
        gbc.weightx = 0.1;
        contentPage.add(definitionLabel, gbc);

        JTextField definitionField = new JTextField(15);
        definitionField.setFont(font);
        definitionField.setEditable(false);
        definitionField.setText("Definitions");
        gbc.weightx = 1.0;
        contentPage.add(definitionField, gbc);

        JButton randomButton = createButton("Random", font);
        gbc.weightx = 0.0;

        contentPage.add(randomButton, gbc);

        GridBagConstraints gbcFiller = new GridBagConstraints();
        gbcFiller.gridwidth = GridBagConstraints.REMAINDER;
        gbcFiller.fill = GridBagConstraints.BOTH;
        gbcFiller.weightx = 1;
        gbcFiller.weighty = 100;
        contentPage.add(new JPanel(), gbcFiller);
        return contentPage;
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
