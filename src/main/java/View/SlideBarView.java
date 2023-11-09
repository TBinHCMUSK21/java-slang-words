/*
 * View.SlideBarView
 * Create by Bin
 * Date 11/6/23, 2:39 AM
 * Description: Sidebar view
 */
package View;
import Controller.SlideBarController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class SlideBarView extends JPanel {

    public SlideBarView(JFrame currentFrame) {
        MouseListener action = new SlideBarController(currentFrame);
        /*
          Layout
         */
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(56, 55, 55));
        setPreferredSize(new Dimension(200, getHeight()));

        /*
          Title
         */
        JLabel title = new JLabel("Slang Dictionary", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(title);

        /*
          Add button
         */
        JPanel button;

        button = createMenuItem("HomePage", new Color(78, 115, 117));
        button.addMouseListener(action);
        button.setName("HomePage");
        add(button);

        button = createMenuItem("Search by slang word", new Color(78, 115, 117));
        button.addMouseListener(action);
        button.setName("Search by slang word");
        add(button);

        button = createMenuItem("Search by definition", new Color(78, 115, 117));
        button.addMouseListener(action);
        button.setName("Search by definition");
        add(button);

        button = createMenuItem("Display history search", new Color(78, 115, 117));
        button.addMouseListener(action);
        button.setName("Display history search");
        add(button);

        button = createMenuItem("Add a new slang word", new Color(78, 115, 117));
        button.addMouseListener(action);
        button.setName("Add a new slang word");
        add(button);

        button = createMenuItem("Edit a slang word", new Color(78, 115, 117));
        button.addMouseListener(action);
        button.setName("Edit a slang word");
        add(button);

        button = createMenuItem("Delete a slang word", new Color(78, 115, 117));
        button.addMouseListener(action);
        button.setName("Delete a slang word");
        add(button);

        button = createMenuItem("Reset the origin slang word", new Color(78, 115, 117));
        button.addMouseListener(action);
        button.setName("Reset the origin slang word");
        add(button);

        button = createMenuItem("Random slang word", new Color(78, 115, 117));
        button.addMouseListener(action);
        button.setName("Random slang word");
        add(button);

        button = createMenuItem("Game with slang word", new Color(78, 115, 117));
        button.addMouseListener(action);
        button.setName("Game with slang word");
        add(button);

        button = createMenuItem("Game with definitions", new Color(78, 115, 117));
        button.addMouseListener(action);
        button.setName("Game with definitions");
        add(button);

    }
    private JPanel createMenuItem(String text, Color hoverColor) {
        // Panel item
        JPanel menuItem = new JPanel(new BorderLayout());
        menuItem.setBackground(new Color(59, 57, 57));
        menuItem.setPreferredSize(new Dimension(200, 50));

        // Label for text
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.LEFT);

        // Add Label
        menuItem.add(label, BorderLayout.CENTER);

        // Event when hover
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
