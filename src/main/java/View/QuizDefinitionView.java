/*
 * View.QuizDefinition
 * Create by Bin
 * Date 11/6/23, 6:11 PM
 * Description: Quiz definition view
 */

package View;

import javax.swing.*;
import java.awt.*;

public class QuizDefinitionView extends JFrame{
    /**
     * The main layout
     */
    public QuizDefinitionView() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * The main initial layout
     */
    public void initializeComponents(){
        Font mainFont = new Font("Arial", Font.PLAIN, 18);

        setLayout(new BorderLayout());
        SlideBarView sidebar = new SlideBarView(this);
        add(sidebar, BorderLayout.WEST);

        add(createMainContent(mainFont), BorderLayout.CENTER);
    }

    /**
     * Add the element to the main content
     * @param font: font of the content
     * @return mainContent: JPanel display content
     */
    private JPanel createMainContent(Font font){
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createContentPanel(font), BorderLayout.CENTER);
        return mainContent;
    }

    /**
     * The main title of the content
     * @return mainTitle: a Panel to display the title
     */
    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("Quiz Definition Slang", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    /**
     * The main content
     * @param font: font of the content
     * @return contentPage: Panel display content
     */
    private JPanel createContentPanel(Font font) {
        JPanel contentPage = new JPanel();
        contentPage.setLayout(new GridBagLayout());
        contentPage.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();

        // Title of the content
        JLabel titleLabel = new JLabel("Find out the correct answer");
        titleLabel.setFont(font.deriveFont(Font.BOLD, 24f));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contentPage.add(titleLabel, gbc);

        // Question
        JLabel questionLabel = new JLabel("Definition: ");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridy++;
        gbc.gridwidth = 2;
        contentPage.add(questionLabel, gbc);

        // Add the button
        JToggleButton buttonA = new JToggleButton("A. Option 1");
        JToggleButton buttonB = new JToggleButton("B. Option 2");
        JToggleButton buttonC = new JToggleButton("C. Option 3");
        JToggleButton buttonD = new JToggleButton("D. Option 4");

        // The main setting of button
        buttonA.setFont(font);
        buttonB.setFont(font);
        buttonC.setFont(font);
        buttonD.setFont(font);

        // Add a button to group
        ButtonGroup group = new ButtonGroup();
        group.add(buttonA);
        group.add(buttonB);
        group.add(buttonC);
        group.add(buttonD);

        // Add the button to layout
        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.fill = GridBagConstraints.BOTH;
        gbcButtons.insets = new Insets(5, 5, 5, 5);
        gbcButtons.weightx = 0.5;
        gbcButtons.weighty = 0.5;
        gbcButtons.gridx = 0;
        gbcButtons.gridy = 2;
        gbcButtons.gridwidth = 1;

        // Add the first button
        contentPage.add(buttonA, gbcButtons);

        // Add the second button
        gbcButtons.gridx = 1;
        contentPage.add(buttonB, gbcButtons);

        // Add the third button
        gbcButtons.gridx = 0;
        gbcButtons.gridy = 3;
        contentPage.add(buttonC, gbcButtons);

        // Add the fourth button
        gbcButtons.gridx = 1;
        contentPage.add(buttonD, gbcButtons);

        return contentPage;
    }
}
