/*
 * View.MainPage
 * Create by Bin
 * Date 11/6/23, 1:23 AM
 * Description: Home Page View
 */

package View;

import Main.Main;
import Utils.HistorySlangFileHelpers;
import Utils.SlangFileHelpers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class HomePageView extends JFrame {
    /**
     * Main layout
     */
    public HomePageView() {

        // The sidebar
        setLayout(new BorderLayout());
        SlideBarView sidebar = new SlideBarView(this);
        add(sidebar, BorderLayout.WEST);

        // The main content
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BorderLayout());
        mainContent.setBackground(Color.WHITE);

        // The main title
        JLabel mainTitle = new JLabel("Slang Dictionary", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Add the title
        mainContent.add(mainTitle, BorderLayout.NORTH);

        // The subtitle
        JLabel subtitle = new JLabel("Lê Tuấn Bình - 21KTPM02 - 21127230",SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.ITALIC, 14));
        subtitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the subtitle
        mainContent.add(subtitle, BorderLayout.SOUTH);

        // The main content
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

        // Set the feature
        textArea.setFont(new Font("Arial", Font.PLAIN, 15));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        // A Area to display text
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainContent.add(scrollPane, BorderLayout.CENTER);
        mainContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(mainContent, BorderLayout.CENTER);

        // Display
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 675);
        setLocationRelativeTo(null);
        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SlangFileHelpers fileHelpersOut = SlangFileHelpers.getInstance();
                fileHelpersOut.setPath("slang-new.txt");
                try {
                    fileHelpersOut.writeLines(Main.listSlangWord);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                HistorySlangFileHelpers historySlangFileHelpers = HistorySlangFileHelpers.getInstance();
                historySlangFileHelpers.setPath("history-slang.txt");
                try {
                    historySlangFileHelpers.writeLines(Main.historySlangWord);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
