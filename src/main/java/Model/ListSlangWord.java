/*
 * Model.ListSlang
 * Create by Bin
 * Date 11/6/23, 1:11 AM
 * Description: Class for list of slang word
 */

package Model;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class ListSlangWord {
    private HashMap<String, LinkedHashSet<String>> listSlangWord;

    /**
     * Default Constructor
     */
    public ListSlangWord(){
        super();
        this.listSlangWord = new HashMap<>();
    }

    /**
     * Getter list of slang words
     * @return listSlangWord: list of slang words
     */
    public HashMap<String, LinkedHashSet<String>> getlistSlangWord() {
        return listSlangWord;
    }

    /**
     * Setter list of slang words
     * @param listSlangWord: list of slang words
     */
    public void setListSlang(HashMap<String, LinkedHashSet<String>> listSlangWord) {
        this.listSlangWord = listSlangWord;
    }
}
