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
    private SlideBarView sidebar;
    public HomePage() {
        setLayout(new BorderLayout());
        sidebar = new SlideBarView();
        add(sidebar, BorderLayout.WEST);

        // Thêm phần nội dung ở giữa
        // Tạo layout
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BorderLayout());
        mainContent.setBackground(Color.WHITE);

        // Tạo tiêu đề vào phần nội dung chính
        JLabel mainTitle = new JLabel("Slang Dictionary", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Thêm tiêu đề vào phía bên trên
        mainContent.add(mainTitle, BorderLayout.NORTH);

        // Tạo tiêu đề phụ
        JLabel subtitle = new JLabel("Lê Tuấn Bình - 21KTPM02 - 21127230",SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.ITALIC, 14));
        subtitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Thêm tiêu đề phụ vào phía bên dưới
        mainContent.add(subtitle, BorderLayout.SOUTH);

        // Tạo phần nội dung ở trung tâm
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

        // Thiếu lập giá trị
        textArea.setFont(new Font("Arial", Font.PLAIN, 15));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        // Tạo JScrollPane chứa JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainContent.add(scrollPane, BorderLayout.CENTER);
        mainContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(mainContent, BorderLayout.CENTER);

        // Thiếu lập hiển thị
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
}
