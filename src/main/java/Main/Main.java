/*
 * Main.Main
 * Create by Bin
 * Date 11/5/23, 12:18 AM
 * Description: Main Program!!!
 */

package Main;


import Model.ListSlangWord;
import Utils.FileHelpers;
import Utils.SlangFileHelpers;
import View.*;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SlangFileHelpers fileHelper = new SlangFileHelpers("slang.txt");
        ListSlangWord listSlangWord = fileHelper.readAllLines();
        System.out.println(listSlangWord.toString());

        /*
        SwingUtilities.invokeLater(() -> new HomePageView().setVisible(true));
        */
    }

}
