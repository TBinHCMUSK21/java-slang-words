/*
 * Main.Main
 * Create by Bin
 * Date 11/5/23, 12:18 AM
 * Description: Main Program!!!
 */

package Main;

import Model.ListSlangWord;
import Model.SlangWordWithTime;
import Utils.SlangFileHelpers;
import View.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static ListSlangWord listSlangWord;
    public static ArrayList<SlangWordWithTime> historySlangWord;
    public static ListSlangWord originSlangWord;
    public static void main(String[] args) throws IOException {
        SlangFileHelpers fileHelperIn = new SlangFileHelpers("slang.txt");

        listSlangWord = fileHelperIn.readAllLines();
        originSlangWord = fileHelperIn.readAllLines();
        historySlangWord = new ArrayList<>();

        SwingUtilities.invokeLater(() -> new HomePageView().setVisible(true));
    }


}
