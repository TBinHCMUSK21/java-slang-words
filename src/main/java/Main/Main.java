/*
 * Main.Main
 * Create by Bin
 * Date 11/5/23, 12:18 AM
 * Description: Main Program!!!
 */

package Main;

import DAO.ListSlangWordsDao;
import Model.ListSlangWords;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListSlangWords listSlangWords = ListSlangWordsDao.getInstance().getAll();
        System.out.println(listSlangWords.getListSlangWords().size());
    }
}
