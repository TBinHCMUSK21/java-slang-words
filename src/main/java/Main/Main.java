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
import View.HomePageView;
import java.io.IOException;
import java.util.ArrayList;

public class Main{

    public static ListSlangWord listSlangWord;
    public static ArrayList<SlangWordWithTime> historySlangWord;
    public static ListSlangWord originSlangWord;
    public static void main(String[] args) throws IOException {
        SlangFileHelpers fileHelperIn = SlangFileHelpers.getInstance();

        fileHelperIn.setPath("slang.txt");
        originSlangWord = fileHelperIn.readAllLines();

        fileHelperIn.setPath("slang-new.txt");
        listSlangWord = fileHelperIn.readAllLines();

        HistorySlangFileHelpers fileHelpersHistory = HistorySlangFileHelpers.getInstance();
        fileHelpersHistory.setPath("history-slang.txt");
        historySlangWord = fileHelpersHistory.readAllLines();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        HomePageView view = new HomePageView();
    }
}