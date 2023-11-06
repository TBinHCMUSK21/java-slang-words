/*
 * View.SearchSlang
 * Create by Bin
 * Date 11/6/23, 2:33 AM
 * Description:
 */

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDefinition extends JFrame {
    private SlideBarView sidebar;
    public SearchDefinition(){
        Font myFont = new Font("Arial", Font.PLAIN, 18);
        setLayout(new BorderLayout());
        sidebar = new SlideBarView();
        add(sidebar, BorderLayout.WEST);

        // Thêm phần nội dung ở giữa
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BorderLayout());
        mainContent.setBackground(Color.WHITE);

        // Tạo tiêu đề vào phần nội dung chính
        JLabel mainTitle = new JLabel("Slang Dictionary", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Tạo phần ở giữa
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));

        // Tạo tiêu đề và thanh search
        JPanel inputPanel = new JPanel((new FlowLayout(FlowLayout.CENTER, 0, 0)));

        JTextField searchField = new JTextField(15);
        searchField.setFont(myFont);

        JLabel contentTitle = new JLabel("Input the definition:");
        contentTitle.setFont(myFont);

        // Tạo hai nút bấm
        JButton findButton = new JButton("Find");
        findButton.setFont(myFont);

        JButton clearButton = new JButton("Clear");
        clearButton.setFont(myFont);

        inputPanel.add(contentTitle);
        inputPanel.add(searchField);
        inputPanel.add(findButton);
        inputPanel.add(clearButton);

        searchPanel.add(inputPanel,BorderLayout.NORTH);

        // Danh sách các giá trị tìm kiếm được
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> wordList = new JList<>(listModel);
        JScrollPane listScroller = new JScrollPane(wordList);
        listScroller.setPreferredSize(new Dimension(500, 500));

        // Thiết lập
        wordList.setFont(myFont);
        listScroller.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        wordList.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Thêm các thành phần text vào đây
        listModel.addElement("jrfnjer");

        searchPanel.add(listScroller);

        mainContent.add(searchPanel, BorderLayout.CENTER);

        // Thêm action cho nút clear
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchField.setText("");
                listModel.clear();
                // Also, clear the actual list if necessary
            }
        });

        // Thêm tiêu đề vào phía bên trên
        mainContent.add(mainTitle, BorderLayout.NORTH);

        add(mainContent, BorderLayout.CENTER);
        // Thiếu lập hiển thị
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

    }

}
