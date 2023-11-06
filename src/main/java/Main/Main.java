/*
 * Main.Main
 * Create by Bin
 * Date 11/5/23, 12:18 AM
 * Description: Main Program!!!
 */

package Main;


import View.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddSlang().setVisible(true);
            }
        });

    }
}
