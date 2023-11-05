/*
 * View.MainPage
 * Create by Bin
 * Date 11/6/23, 1:23 AM
 * Description:
 */

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    public HomePage() {
        /**
         * Tạo layout
         */
        setLayout(new BorderLayout());
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(56, 55, 55));
        sidebar.setPreferredSize(new Dimension(200, getHeight()));

        /**
         * Thêm tiêu đề cho thanh bên trái
         */
        JLabel title = new JLabel("Slang Dictionary", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        sidebar.add(title);

        /**
         * Thêm từng nút bấm vòa thanh bên trái
         */
        sidebar.add(createMenuItem("Search by slang word", new Color(78, 115, 117)));
        sidebar.add(createMenuItem("Search by definition", new Color(78, 115, 117)));
        sidebar.add(createMenuItem("Display history search", new Color(78, 115, 117)));
        sidebar.add(createMenuItem("Add a new slang word", new Color(78, 115, 117)));
        sidebar.add(createMenuItem("Edit a slang word", new Color(78, 115, 117)));
        sidebar.add(createMenuItem("Delete a slang word", new Color(78, 115, 117)));
        sidebar.add(createMenuItem("Reset the origin slang word", new Color(78, 115, 117)));
        sidebar.add(createMenuItem("Random slang word", new Color(78, 115, 117)));
        sidebar.add(createMenuItem("Game with slang word", new Color(78, 115, 117)));
        sidebar.add(createMenuItem("Game with definitions", new Color(78, 115, 117)));
        add(sidebar, BorderLayout.WEST);

        /**
         * Thêm phần nội dung ở giữa
         */
        // Tạo layout
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BorderLayout());
        mainContent.setBackground(Color.WHITE);

        // Tạo và thêm tiêu đề vào phần nội dung chính
        JLabel mainTitle = new JLabel("Slang Dictionary", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        mainContent.add(mainTitle, BorderLayout.NORTH);

        JLabel subtitle = new JLabel("Lê Tuấn Bình - 21KTPM02 - 21127230",SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.ITALIC, 14));
        subtitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainContent.add(subtitle, BorderLayout.SOUTH);

        JTextArea textArea = new JTextArea(
                "1. Chức năng tìm kiếm theo slang word." + "\n\n" +
                "2. Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong definition có chứa keyword gõ vào." + "\n\n" +
                "3. Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.\n\n"+
                "4. Chức năng add 1 slang words mới. Nếu slang words trùng thì thông báo cho người dùng, confirm có overwrite hay duplicate ra 1 slang word mới.\n\n"+
                "5. Chức năng edit 1 slang word.\n\n" +
                "6. Chức năng delete 1 slang word. Confirm trước khi xoá.\n\n" +
                "7. Chức năng reset danh sách slang words gốc.\n\n" +
                "8. Chức năng random 1 slang word (On this day slang word).\n\n"+
                "9. Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho người dùng chọn.\n\n"+
                "10. Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho người dùng chọn.\n\n"
        );

        textArea.setFont(new Font("Arial", Font.PLAIN, 15));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        // Tạo JScrollPane chứa JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainContent.add(scrollPane, BorderLayout.CENTER);
        mainContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(mainContent, BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private JPanel createMenuItem(String text, Color hoverColor) {
        // Tạo JPanel tùy chỉnh cho menu item
        JPanel menuItem = new JPanel(new BorderLayout());
        menuItem.setBackground(new Color(59, 57, 57)); // Màu nền
        menuItem.setPreferredSize(new Dimension(200, 50)); // Kích thước

        // Label cho text
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE); // Màu chữ
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Thêm label vào menuItem
        menuItem.add(label, BorderLayout.CENTER);

        // Event để thay đổi màu khi hover
        menuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuItem.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuItem.setBackground(new Color(59, 57, 57));
            }
        });

        return menuItem;
    }
}
