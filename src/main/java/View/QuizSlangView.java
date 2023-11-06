/*
 * View.QuizSlang
 * Create by Bin
 * Date 11/6/23, 6:11 PM
 * Description:
 */

package View;

import javax.swing.*;
import java.awt.*;

public class QuizSlangView extends JFrame{
    private SlideBarView sidebar;
    public QuizSlangView() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void initializeComponents(){
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
        JLabel mainTitle = new JLabel("Quiz Slang Words", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }
    private JPanel createContentPanel(Font font) {
        JPanel contentPage = new JPanel();
        contentPage.setLayout(new GridBagLayout());
        contentPage.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();

        // Tiêu đề của chương trình
        JLabel titleLabel = new JLabel("Find out the correct answer");
        titleLabel.setFont(font.deriveFont(Font.BOLD, 24f));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contentPage.add(titleLabel, gbc);

        // Câu hỏi
        JLabel questionLabel = new JLabel("Slang: ");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridy++;
        gbc.gridwidth = 2;
        contentPage.add(questionLabel, gbc);

        // Thêm các nút chọn
        JToggleButton buttonA = new JToggleButton("A. Option 1");
        JToggleButton buttonB = new JToggleButton("B. Option 2");
        JToggleButton buttonC = new JToggleButton("C. Option 3");
        JToggleButton buttonD = new JToggleButton("D. Option 4");

        // Thiết lập mặc định của nút
        buttonA.setFont(font);
        buttonB.setFont(font);
        buttonC.setFont(font);
        buttonD.setFont(font);

        // Thêm các nút vào một group
        ButtonGroup group = new ButtonGroup();
        group.add(buttonA);
        group.add(buttonB);
        group.add(buttonC);
        group.add(buttonD);

        // Lần lượt thêm các nút vào trong layout
        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.fill = GridBagConstraints.BOTH;
        gbcButtons.insets = new Insets(5, 5, 5, 5);
        gbcButtons.weightx = 0.5;
        gbcButtons.weighty = 0.5;
        gbcButtons.gridx = 0;
        gbcButtons.gridy = 2;
        gbcButtons.gridwidth = 1;

        // Thêm nút một
        contentPage.add(buttonA, gbcButtons);

        // Thêm nút hai
        gbcButtons.gridx = 1;
        contentPage.add(buttonB, gbcButtons);

        // Thêm nút ba
        gbcButtons.gridx = 0;
        gbcButtons.gridy = 3;
        contentPage.add(buttonC, gbcButtons);

        // Thêm nút bốn
        gbcButtons.gridx = 1;
        contentPage.add(buttonD, gbcButtons);

        return contentPage;
    }
}
