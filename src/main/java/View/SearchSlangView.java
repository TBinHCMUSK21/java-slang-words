/*
 * View.test
 * Create by Bin
 * Date 11/6/23, 9:31 AM
 * Description: Search Slang View
 */

package View;
import Controller.SearchSlangController;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashSet;


public class SearchSlangView extends JFrame {

    public DefaultListModel<String> listModel;
    public JTextField searchField;


    public SearchSlangView() {
        setTitle("Slang Dictionary Search");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
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
        searchPanel.add(createListScroller(font), BorderLayout.CENTER);
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
    private JScrollPane createListScroller(Font font) {
        listModel = new DefaultListModel<>();
        JList<String> wordList = new JList<>(listModel);
        wordList.setFont(font);
        wordList.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane listScroller = new JScrollPane(wordList);
        listScroller.setPreferredSize(new Dimension(500, 500));
        listScroller.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return listScroller;
    }

    public void findSlang() {
        listModel.removeAllElements();
        String slang = searchField.getText();
        if (Main.listSlangWord.getListSlangWord().get(slang)!=null){
           LinkedHashSet<String> definition = Main.listSlangWord.searchBySlang(slang);
           for (String string:definition){
               listModel.addElement(string);
           }
        }
        else{
            listModel.addElement("Not Found");
        }
    }
    public void clearAll() {
        listModel.removeAllElements();
        searchField.setText("");
    }
}
