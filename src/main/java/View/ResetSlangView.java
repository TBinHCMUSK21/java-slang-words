/*
 * View.ResetSlang
 * Create by Bin
 * Date 11/6/23, 11:05 AM
 * Description: Reset View
 */

package View;

import Controller.ResetSlangController;
import Main.Main;
import Model.OneSlangWord;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Map;

import static Main.Main.*;

public class ResetSlangView extends JFrame {
    public DefaultTableModel tableModel;
    public ResetSlangView() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 675);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeComponents() {
        Font mainFont = new Font("Arial", Font.PLAIN, 18);

        setLayout(new BorderLayout());
        SlideBarView sidebar = new SlideBarView(this);
        add(sidebar, BorderLayout.WEST);
        add(createMainContent(mainFont), BorderLayout.CENTER);
    }
    private JPanel createMainContent(Font font) {
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(createTitle(), BorderLayout.NORTH);
        mainContent.add(createAddPanel(font), BorderLayout.CENTER);
        mainContent.add(createSearchPanel(), BorderLayout.SOUTH);

        return mainContent;
    }
    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("Reset Slang Words", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }
    private JPanel createAddPanel(Font font) {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));
        searchPanel.add(createInputPanel(font), BorderLayout.NORTH);
        return searchPanel;
    }
    private JPanel createInputPanel(Font font) {
        ResetSlangController action = new ResetSlangController(this);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel slangLabel = new JLabel("Do you want to reset the origin slang dictionary");
        slangLabel.setHorizontalAlignment(SwingConstants.LEFT);
        slangLabel.setFont(font);
        gbc.weightx = 0.1;
        inputPanel.add(slangLabel, gbc);

        JButton resetButton = createButton("Reset", font);
        resetButton.addActionListener(action);
        gbc.weightx = 0.0;

        inputPanel.add(resetButton, gbc);

        GridBagConstraints gbcFiller = new GridBagConstraints();
        gbcFiller.gridwidth = GridBagConstraints.REMAINDER;
        gbcFiller.fill = GridBagConstraints.BOTH;
        gbcFiller.weightx = 1;
        gbcFiller.weighty = 50;
        inputPanel.add(new JPanel(), gbcFiller);

        return inputPanel;
    }

    private JButton createButton(String title, Font font) {
        JButton button = new JButton(title);
        button.setFont(font);
        return button;
    }
    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));
        searchPanel.add(createListScroller(), BorderLayout.CENTER);
        return searchPanel;
    }
    private JScrollPane createListScroller() {
        tableModel = new DefaultTableModel(new Object[]{"STT", "Slang", "Meaning"}, 0) {
            public boolean isCellEditable(int row, int column) {
                // Not allow to edit
                return false;
            }
        };

        // Create a table
        Font tableFont = new Font("Arial", Font.PLAIN, 16);
        JTable table = new JTable(tableModel);
        table.setFont(tableFont);
        JTableHeader header = table.getTableHeader();
        header.setFont(tableFont);

        // Add data to table
        int count = 1;
        for (Map.Entry<String, LinkedHashSet<String>> entry : listSlangWord.getListSlangWord().entrySet()) {
            String key = entry.getKey();
            LinkedHashSet<String> value = entry.getValue();
            tableModel.addRow(new Object[]{count,key,value});
            count++;
        }

        // Attribute for table
        table.setFillsViewportHeight(false);
        table.setRowHeight(30);

        // Add table to JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        Dimension preferredSize = scrollPane.getPreferredSize();
        preferredSize.height = 400;
        scrollPane.setPreferredSize(preferredSize);

        // Display
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        return scrollPane;
    }

    public void resetTheOrigin() {
        Main.listSlangWord.copy(originSlangWord);
        tableModel.setRowCount(0);
        int count = 1;
        for (Map.Entry<String, LinkedHashSet<String>> entry : listSlangWord.getListSlangWord().entrySet()) {
            String key = entry.getKey();
            LinkedHashSet<String> value = entry.getValue();
            tableModel.addRow(new Object[]{count,key,value});
            count++;
        }
    }
}
