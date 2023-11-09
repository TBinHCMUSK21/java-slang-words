/*
 * View.test
 * Create by Bin
 * Date 11/6/23, 9:31 AM
 * Description: Search Slang View
 */

package View;
import Controller.SearchSlangController;
import Main.Main;
import Model.OneSlangWord;
import Model.SlangWordWithTime;
import Utils.HistorySlangFileHelpers;
import Utils.SlangFileHelpers;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;


public class SearchSlangView extends JFrame {

    public DefaultTableModel listModel;
    public JTextField searchField;


    public SearchSlangView() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
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
        mainContent.add(createSearchPanel(font), BorderLayout.CENTER);
        return mainContent;
    }

    private JLabel createTitle() {
        JLabel mainTitle = new JLabel("Search by slang word", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        return mainTitle;
    }

    private JPanel createSearchPanel(Font font) {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));
        searchPanel.add(createInputPanel(font), BorderLayout.NORTH);
        searchPanel.add(createListScroller(), BorderLayout.CENTER);
        return searchPanel;
    }

    private JPanel createInputPanel(Font font) {
        Action action = new SearchSlangController(this);
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        searchField = new JTextField(15);
        searchField.setFont(font);

        JLabel contentTitle = new JLabel("Input the slang word:");
        contentTitle.setFont(font);

        JButton findButton = createButton("Find", font);
        findButton.addActionListener(action);

        JButton clearButton = createButton("Clear", font);
        clearButton.addActionListener(action);

        inputPanel.add(contentTitle);
        inputPanel.add(searchField);
        inputPanel.add(findButton);
        inputPanel.add(clearButton);

        return inputPanel;
    }
    private JButton createButton(String title, Font font) {
        JButton button = new JButton(title);
        button.setFont(font);
        return  button;
    }
    private JScrollPane createListScroller() {
        listModel = new DefaultTableModel(new Object[]{"STT", "Slang", "Meaning"}, 0) {
            public boolean isCellEditable(int row, int column) {
                // Not edit the table
                return false;
            }
        };
        // Create Table
        Font tableFont = new Font("Arial", Font.PLAIN, 16);
        JTable table = new JTable(listModel);
        table.setFont(tableFont);
        JTableHeader header = table.getTableHeader();
        header.setFont(tableFont);

        // Add data to table
        listModel.setRowCount(0);


        // Feature for table
        table.setFillsViewportHeight(false);
        table.setRowHeight(30);

        // Add table to JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Display window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        return scrollPane;
    }

    public void findSlang() {
        listModel.setRowCount(0);
        String slang = searchField.getText();
        LinkedHashSet<String> slangFind = Main.listSlangWord.searchBySlang(slang);
        if (!slangFind.isEmpty()){
            int count = 1;
            for (String slangItem:slangFind){
                LinkedHashSet<String> definition = Main.listSlangWord.getListSlangWord().get(slangItem);
                for (String string:definition){
                    listModel.addRow(new Object[]{count,slangItem,string});
                    count = count + 1;
                }
                LocalDateTime time = LocalDateTime.now();
                Main.historySlangWord.add(new SlangWordWithTime(new OneSlangWord(slang,definition),time));
            }
        }
        else{
            LocalDateTime time = LocalDateTime.now();
            Main.historySlangWord.add(new SlangWordWithTime(new OneSlangWord(slang,null),time));
            JOptionPane.showMessageDialog(this,"Not Found");
        }
    }
    public void clearAll() {
        listModel.setRowCount(0);
        searchField.setText("");
    }
}
