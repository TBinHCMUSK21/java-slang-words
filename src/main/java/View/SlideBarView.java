/*
 * View.SlideBarView
 * Create by Bin
 * Date 11/6/23, 2:39 AM
 * Description:
 */

package View;

import javax.swing.*;
import java.awt.*;

public class SlideBarView extends JPanel {
    private JPanel sidebarPanel;

    public SlideBarView() {
        /**
         * Tạo layout
         */
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(56, 55, 55));
        setPreferredSize(new Dimension(200, getHeight()));

        /**
         * Thêm tiêu đề cho thanh bên trái
         */
        JLabel title = new JLabel("Slang Dictionary", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(title);

        /**
         * Thêm từng nút bấm vòa thanh bên trái
         */
        add(createMenuItem("Search by slang word", new Color(78, 115, 117)));
        add(createMenuItem("Search by definition", new Color(78, 115, 117)));
        add(createMenuItem("Display history search", new Color(78, 115, 117)));
        add(createMenuItem("Add a new slang word", new Color(78, 115, 117)));
        add(createMenuItem("Edit a slang word", new Color(78, 115, 117)));
        add(createMenuItem("Delete a slang word", new Color(78, 115, 117)));
        add(createMenuItem("Reset the origin slang word", new Color(78, 115, 117)));
        add(createMenuItem("Random slang word", new Color(78, 115, 117)));
        add(createMenuItem("Game with slang word", new Color(78, 115, 117)));
        add(createMenuItem("Game with definitions", new Color(78, 115, 117)));
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
    public JPanel getSidebarPanel() {
        return sidebarPanel;
    }
}
