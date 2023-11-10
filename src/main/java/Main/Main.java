/*
 * Main.Main
 * Create by Bin
 * Date 11/5/23, 12:18 AM
 * Description: Main Program!!!
 */

package Main;
import Model.ListSlangWord;
import Model.SlangWordWithTime;
import Utils.HistorySlangFileHelpers;
import Utils.SlangFileHelpers;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import View.*;

public class Main{
    public static ListSlangWord listSlangWord;
    public static ArrayList<SlangWordWithTime> historySlangWord;
    public static ListSlangWord originSlangWord;
    public static void main(String[] args) throws IOException {

        SlangFileHelpers fileHelperIn = SlangFileHelpers.getInstance();

        fileHelperIn.setPath("data/slang.txt");
        originSlangWord = fileHelperIn.readAllLines();

        File file = new File("data/slang-new.txt");
        if (file.exists()){
            fileHelperIn.setPath("data/slang-new.txt");
        }
        else fileHelperIn.setPath("data/slang.txt");

        listSlangWord = fileHelperIn.readAllLines();

        HistorySlangFileHelpers fileHelpersHistory = HistorySlangFileHelpers.getInstance();
        fileHelpersHistory.setPath("data/history-slang.txt");
        historySlangWord = fileHelpersHistory.readAllLines();

        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
    public static void createAndShowGUI() {
        new MainView().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SlangFileHelpers fileHelpersOut = SlangFileHelpers.getInstance();
                fileHelpersOut.setPath("data/slang-new.txt");
                try {
                    fileHelpersOut.writeLines(Main.listSlangWord);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                HistorySlangFileHelpers historySlangFileHelpers = HistorySlangFileHelpers.getInstance();
                historySlangFileHelpers.setPath("data/history-slang.txt");
                try {
                    historySlangFileHelpers.writeLines(Main.historySlangWord);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}