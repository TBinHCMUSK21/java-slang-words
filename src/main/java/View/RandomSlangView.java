/*
 * View.RandomSlangTest
 * Create by Bin
 * Date 11/10/23, 1:10 PM
 * Description:
 */

package View;

import Controller.RandomSlangController;
import Main.Main;
import Model.OneSlangWord;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RandomSlangView extends JPanel {
    public JTextField definitionField;
    public JTextField slangField;
    public JTextField dateField;
    /**
     * The layout of frame
     */
    public RandomSlangView() {
        initializeComponents();
    }
    /**
     * The initial components of the layout
     */
    private void initializeComponents() {
        Font mainFont = new Font("Arial", Font.PLAIN, 18);
        setLayout(new BorderLayout());
        add(createMainContent(mainFont), BorderLayout.CENTER);
    }

    /**
     * The main content of the frame
     * @param font: font for the content
     * @return mainContent: JPanel for the main content
     */
    private JPanel createMainContent(Font font){
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createContentPanel(font), BorderLayout.CENTER);
        return mainContent;
    }

    /**
     * Create a title of the main content
     * @return mainTitle: a JLabel to the title of the content
     */
    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("On this day slang word", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    /**
     * The content panel
     * @param font: font of the content
     * @return contentPage: JPanel for the content
     */
    private JPanel createContentPanel(Font font) {
        RandomSlangController action = new RandomSlangController(this);
        JPanel contentPage = new JPanel();
        contentPage.setLayout(new GridBagLayout());
        contentPage.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel slangLabel = new JLabel("Slang Word:");
        slangLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.weightx = 0.1;
        contentPage.add(slangLabel, gbc);

        slangField = new JTextField(15);
        slangField.setFont(font);
        slangField.setEditable(false);
        // Add
        gbc.weightx = 1.0;
        contentPage.add(slangField, gbc);

        JLabel definitionLabel = new JLabel("Definition Word:");
        definitionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.weightx = 0.1;
        contentPage.add(definitionLabel, gbc);

        definitionField = new JTextField(15);
        definitionField.setFont(font);
        definitionField.setEditable(false);
        // Add
        gbc.weightx = 1.0;
        contentPage.add(definitionField, gbc);

        JLabel dateLabel = new JLabel("Date and Time:");
        dateLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.weightx = 0.1;
        contentPage.add(dateLabel, gbc);
        // Add
        dateField = new JTextField(15);
        dateField.setFont(font);
        dateField.setEditable(false);
        gbc.weightx = 1.0;
        contentPage.add(dateField, gbc);

        JButton randomButton = createButton("Random", font);
        gbc.weightx = 0.0;
        randomButton.addActionListener(action);
        contentPage.add(randomButton, gbc);

        this.randomSlang();

        GridBagConstraints gbcFiller = new GridBagConstraints();
        gbcFiller.gridwidth = GridBagConstraints.REMAINDER;
        gbcFiller.fill = GridBagConstraints.BOTH;
        gbcFiller.weightx = 1;
        gbcFiller.weighty = 100;
        contentPage.add(new JPanel(), gbcFiller);
        return contentPage;
    }

    /**
     * A Button
     * @param title: button title
     * @param font: font for content
     * @return button: JButton
     */
    private JButton createButton(String title, Font font) {
        JButton button = new JButton(title);
        button.setFont(font);
        return button;
    }
    public void randomSlang(){
        LocalDateTime time =LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        String formattedDateTime = time.format(formatter);
        OneSlangWord oneSlangWord = Main.listSlangWord.randomOneSlang();
        this.slangField.setText(oneSlangWord.getSlang());
        StringBuilder builder = new StringBuilder();
        for (String string:oneSlangWord.getDefinitions()){
            builder.append(string);
            if (!string.equals(oneSlangWord.getDefinitions().getLast()))
            {
                builder.append(" | ");
            }
        }
        this.dateField.setText(formattedDateTime);
        this.definitionField.setText(builder.toString());
    }

}