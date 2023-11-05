/*
 * DAO.ListSlangWordsDao
 * Create by Bin
 * Date 11/5/23, 3:53 PM
 * Description:
 */

package DAO;

import Model.ListSlangWords;
import Model.SlangWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ListSlangWordsDao implements InterfaceDao<ListSlangWords> {
    private final String filePath = "slang.txt";

    /**
     *  private constructor for Singleton pattern
     */
    private ListSlangWordsDao() {}


    /**
     *
     * @return
     */
    public static ListSlangWordsDao getInstance() {
        return ListSlangWordsDaoHelper.INSTANCE;
    }

    /**
     *
     */
    private static class ListSlangWordsDaoHelper {
        private static final ListSlangWordsDao INSTANCE = new ListSlangWordsDao();
    }

    /**
     * Get all the slang word in filepath = "slang.txt'
     * @return
     */
    @Override
    public ListSlangWords getAll() {
        ListSlangWords listSlangWords = new ListSlangWords();
        try{
            BufferedReader fin = new BufferedReader(new FileReader(filePath));
            while(true){
                String str = fin.readLine();
                if (str == null) {
                    break;
                }
                String[] slang = str.split("`");
                if (slang.length <= 1){
                    continue;
                }
                List<String> definitions = Arrays.asList(slang[1].split("\\|"));
                SlangWords slangWords = new SlangWords(slang[0],definitions);
                listSlangWords.addSlangWord(slangWords);
            }
            fin.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return listSlangWords;
    }
}
