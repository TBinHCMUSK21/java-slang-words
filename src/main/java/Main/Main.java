/*
 * Main.Main
 * Create by Bin
 * Date 11/5/23, 12:18 AM
 * Description: Main Program!!!
 */

package Main;


import Model.ListSlangWord;
import Utils.SlangFileHelpers;
import View.*;
import javax.swing.*;
import java.io.IOException;


public class Main {
    public static ListSlangWord listSlangWord;
    public static ListSlangWord historySlangWord;
    public static ListSlangWord originSlangWord;
    public static void main(String[] args) throws IOException {
        SlangFileHelpers fileHelper = new SlangFileHelpers("slang.txt");

        listSlangWord = fileHelper.readAllLines();
        originSlangWord = fileHelper.readAllLines();
        historySlangWord = new ListSlangWord();

        SwingUtilities.invokeLater(() -> new HomePageView().setVisible(true));
    }

}
