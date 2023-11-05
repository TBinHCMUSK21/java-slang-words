/*
 * Model.ListSlangWords
 * Create by Bin
 * Date 11/5/23, 12:21 AM
 * Description: Class to store List of Slang Words
 */

package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListSlangWords {
    private HashMap<String, List<String>> listSlangWords;

    /**
     * Default Constructor
     */
    public ListSlangWords() {
        this.listSlangWords=new HashMap<>();
    }
    /**
     * Constructor with parameters
     * @param listSlangWords: List of the Slang Words
     */
    public ListSlangWords(HashMap<String, List<String>> listSlangWords) {
        this.listSlangWords = listSlangWords;
    }

    /**
     * Getter the listSlangWords
     * @return listSlangWords
     */
    public HashMap<String, List<String>> getListSlangWords() {
        return listSlangWords;
    }

    /**
     * Setter listSlangWords
     * @param listSlangWords: List of Slang Words
     */
    public void setListSlangWords(HashMap<String, List<String>> listSlangWords) {
        this.listSlangWords = listSlangWords;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : listSlangWords.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            SlangWords slangWords = new SlangWords(key,value);
            String string  = slangWords.toString();
            builder.append(string);
        }
        return builder.toString();
    }
    public void addSlangWord(SlangWords slangWords){
        this.listSlangWords.put(slangWords.getSlangWords(),slangWords.getDefinitions());
    }
}
