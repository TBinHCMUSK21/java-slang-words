/*
 * View.QuizDefinitionTest
 * Create by Bin
 * Date 11/10/23, 1:13 PM
 * Description:
 */

package View;
import Controller.QuizDefinitionController;
import Main.Main;
import Model.OneSlangWord;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class QuizDefinitionView extends JPanel {
    public ArrayList<OneSlangWord> content;

    public JLabel questionLabel;

    public Random random = new Random();

    public JButton[] button = new JButton[4];

    public int rightOption;
    /**
     * The main layout
     */
    public QuizDefinitionView() {
        initializeComponents();
    }

    /**
     * The main initial layout
     */
    public void initializeComponents(){
        Font mainFont = new Font("Arial", Font.PLAIN, 18);
        setLayout(new BorderLayout());
        add(createMainContent(mainFont), BorderLayout.CENTER);
    }

    /**
     * Add the element to the main content
     * @param font: font of the content
     * @return mainContent: JPanel display content
     */
    private JPanel createMainContent(Font font){
        QuizDefinitionController action = new QuizDefinitionController(this);
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createContentPanel(font), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(200, 100));
        JButton button = new JButton("Next");
        button.setPreferredSize(new Dimension(200, 50));
        buttonPanel.add(button);
        button.setActionCommand("Next");
        button.addActionListener(action);

        mainContent.add(buttonPanel,BorderLayout.SOUTH);
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
        QuizDefinitionController action = new QuizDefinitionController(this);
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
        this.content=new ArrayList<>();

        for (int i=0;i<4;i++){
            content.add(Main.listSlangWord.randomOneSlang());
        }
        rightOption = random.nextInt(4);

        questionLabel = new JLabel("Definition: " + content.get(rightOption).getDefinitions().getFirst());
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy++;
        gbc.gridwidth = 2;
        contentPage.add(questionLabel, gbc);

        // Add the button
        Dimension buttonSize = new Dimension(150, 40);
        for (int i = 0;i <button.length;i++){
            String buttonText;
            if (i==rightOption){
                buttonText = content.get(rightOption).getSlang();
            }
            else{
                buttonText = content.get(i).getSlang();
            }
            button[i] = new JButton(buttonText);
            button[i].setToolTipText(buttonText);
            button[i].setActionCommand(Integer.toString(i));
            button[i].setPreferredSize(buttonSize);
            button[i].addActionListener(action);

        }

        // Button figure
        for (JButton eachButton:button){
            eachButton.setFont(font);
        }
        int[] position_gridx = {
                0,1,0,1
        };
        int[] position_gridy = {
                2,2,3,3
        };
        // Add the button to layout
        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.fill = GridBagConstraints.BOTH;
        gbcButtons.insets = new Insets(5, 5, 5, 5);
        gbcButtons.weightx = 0.5;
        gbcButtons.weighty = 0.5;
        gbcButtons.gridwidth = 1;

        for (int i =0;i<4;i++){
            gbcButtons.gridx=position_gridx[i];
            gbcButtons.gridy=position_gridy[i];
            contentPage.add(button[i],gbcButtons);
        }

        return contentPage;
    }
    public void displayRightChoose() {
        button[rightOption].setBackground(Color.GREEN);
        JOptionPane.showMessageDialog(this,"Congratulations!!!");
        for (JButton jButton : button) {
            jButton.setEnabled(false);
            jButton.setForeground(Color.BLACK);
        }
    }
    public void displayWrongChoose(String str) {
        button[rightOption].setBackground(Color.GREEN);
        button[Integer.parseInt(str)].setBackground(Color.RED);
        JOptionPane.showMessageDialog(this,"Wrong answer!!!");
        for (JButton jButton : button) {
            jButton.setEnabled(false);
            jButton.setForeground(Color.BLACK);
        }
    }

    public void randomNew() {
        content.clear();
        for (int i=0;i<4;i++){
            content.add(Main.listSlangWord.randomOneSlang());
        }
        rightOption = random.nextInt(4);
        questionLabel.setText("Definition: " + content.get(rightOption).getDefinitions().getFirst());
        for (int i = 0;i <button.length;i++){
            button[i].setEnabled(true);
            button[i].setBackground(null);
            if (i==rightOption){
                button[i].setText(content.get(rightOption).getSlang());
            }
            else{
                button[i].setText(content.get(i).getSlang());
            }
        }
    }
}