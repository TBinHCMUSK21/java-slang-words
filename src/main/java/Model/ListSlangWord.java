/*
 * Model.ListSlang
 * Create by Bin
 * Date 11/6/23, 1:11 AM
 * Description: Class for list of slang word
 */

package Model;

import Main.Main;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

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
     * Constructor with parameter
     */
    public ListSlangWord(HashMap<String, LinkedHashSet<String>> listSlangWord){
        super();
        this.listSlangWord = listSlangWord;
    }
    /**
     * Getter list of slang words
     * @return listSlangWord: list of slang words
     */
    public HashMap<String, LinkedHashSet<String>> getListSlangWord() {
        return listSlangWord;
    }

    /**
     * Setter list of slang words
     * @param listSlangWord: list of slang words
     */
    public void setListSlang(HashMap<String, LinkedHashSet<String>> listSlangWord) {
        this.listSlangWord = listSlangWord;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, LinkedHashSet<String>> entry : this.listSlangWord.entrySet()) {
            String key = entry.getKey();
            LinkedHashSet<String> value = entry.getValue();
            OneSlangWord slang = new OneSlangWord(key,value);
            builder.append(slang.toString());
        }
        return builder.toString();
    }

    public LinkedHashSet<String> searchBySlang(String slang) {
        return Main.listSlangWord.getListSlangWord().get(slang);
    }
}
