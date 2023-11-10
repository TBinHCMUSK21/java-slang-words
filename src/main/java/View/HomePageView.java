/*
 * View.HomePageTest
 * Create by Bin
 * Date 11/10/23, 11:54 AM
 * Description:
 */

package View;
import javax.swing.*;
import java.awt.*;
public class HomePageView extends JPanel {
    /**
     * Main layout
     */
    public HomePageView() {
        setLayout(new BorderLayout());
        setSize(new Dimension(850,675));
        JLabel mainTitle = new JLabel("Slang Dictionary", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(mainTitle,BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(
                """
                        1. Chức năng tìm kiếm theo slang word.

                        2. Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong definition có chứa keyword gõ vào.

                        3. Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.

                        4. Chức năng add 1 slang words mới. Nếu slang words trùng thì thông báo cho người dùng, confirm có overwrite hay duplicate ra 1 slang word mới.

                        5. Chức năng edit 1 slang word.

                        6. Chức năng delete 1 slang word. Confirm trước khi xoá.

                        7. Chức năng reset danh sách slang words gốc.

                        8. Chức năng random 1 slang word (On this day slang word).

                        9. Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho người dùng chọn.

                        10. Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho người dùng chọn.

                        """
        );

        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setSize(this.getSize());

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JLabel subtitle = new JLabel("Lê Tuấn Bình - 21KTPM02 - 21127230",SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.ITALIC, 16));
        subtitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(subtitle,BorderLayout.SOUTH);
    }

}
