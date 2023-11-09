/*
 * View.QuizSlang
 * Create by Bin
 * Date 11/6/23, 6:11 PM
 * Description: Quiz Slang View
 */

package View;

import Controller.QuizSlangController;
import Main.Main;
import Model.OneSlangWord;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class QuizSlangView extends JFrame{
    public ArrayList<OneSlangWord> content;

    public JLabel questionLabel;

    public Random random = new Random();

    public JButton[] button = new JButton[4];

    public int rightOption;
    /**
     * The main frame
     */
    public QuizSlangView() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 675);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * The initial components add sidebar
     */
    public void initializeComponents(){
        Font mainFont = new Font("Arial", Font.PLAIN, 18);
        setLayout(new BorderLayout());
        SlideBarView sidebar = new SlideBarView(this);
        add(sidebar, BorderLayout.WEST);
        add(createMainContent(mainFont), BorderLayout.CENTER);
    }

    /**
     * Create the main content of the frame
     * @param font: font of the content
     * @return mainContent: the panel of the content
     */
    private JPanel createMainContent(Font font){
        QuizSlangController action = new QuizSlangController(this);
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
     * The title of the content
     * @return mainTitle: A Label of the title for content
     */
    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("Quiz Slang Words", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    /**
     * The panel of main content
     * @param font: font of the content
     * @return contentPage: The main content of page
     */
    private JPanel createContentPanel(Font font) {
        QuizSlangController action = new QuizSlangController(this);
        JPanel contentPage = new JPanel();
        contentPage.setLayout(new GridBagLayout());
        contentPage.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();

        // The title
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

        questionLabel = new JLabel("Slang: " + content.get(rightOption).getSlang());
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy++;
        gbc.gridwidth = 2;
        contentPage.add(questionLabel, gbc);

        // Add the button

        for (int i = 0;i <button.length;i++){
            if (i==rightOption){
                button[i] = new JButton(content.get(rightOption).getDefinitions().getFirst());
                button[i].setActionCommand(Integer.toString(i));
            }
            else{
                button[i] = new JButton(content.get(i).getDefinitions().getFirst());
                button[i].setActionCommand(Integer.toString(i));
            }
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
        questionLabel.setText("Slang: " + content.get(rightOption).getSlang());
        for (int i = 0;i <button.length;i++){
            button[i].setEnabled(true);
            button[i].setBackground(null);
            if (i==rightOption){
                button[i].setText(content.get(rightOption).getDefinitions().getFirst());
            }
            else{
                button[i].setText(content.get(i).getDefinitions().getFirst());
            }
        }
    }
}
