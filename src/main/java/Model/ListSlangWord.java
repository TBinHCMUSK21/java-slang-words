/*
 * Model.ListSlang
 * Create by Bin
 * Date 11/6/23, 1:11 AM
 * Description: Class for list of slang word
 */

package Model;

import Main.Main;

import java.util.*;

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
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * Copy from the another ListSlangWord
     * @param another: another list of slang word
     */
    public void copy(ListSlangWord another){
        Main.listSlangWord.getListSlangWord().clear();
        for (Map.Entry<String, LinkedHashSet<String>> entry : another.getListSlangWord().entrySet()) {
            String key = entry.getKey();
            LinkedHashSet<String> value = entry.getValue();
            this.listSlangWord.put(key,value);
        }
    }

    /**
     * Search a list of slang word content the slang
     * @param slang: a slang we want to search
     * @return a set of slang word content slang
     */
    public LinkedHashSet<String> searchBySlang(String slang) {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        for (Map.Entry<String, LinkedHashSet<String>> entry : this.listSlangWord.entrySet()) {
            if (entry.getKey().contains(slang)){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    /**
     * Return a list of key of slang have the definition content an input from user
     * @param definition: a definition we want to search
     * @return set of key slang words
     */
    public LinkedHashSet<String> searchByDefinition (String definition) {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        for (Map.Entry<String, LinkedHashSet<String>> entry : this.listSlangWord.entrySet()) {
            String key = entry.getKey();
            LinkedHashSet<String> value = entry.getValue();
            definition=definition.toLowerCase();
            for(String string:value){
                string = string.toLowerCase();
                if (string.contains(definition)){
                    result.add(key);
                }
            }
        }
        return result;
    }
    public void editSlang(String prev_slang,String new_slang){
        LinkedHashSet<String> definition =this.listSlangWord.get(prev_slang);
        this.listSlangWord.remove(prev_slang);
        this.listSlangWord.put(new_slang,definition);

    }
    public void editDefinition(String prev_definition,String new_definition,String slang){
        this.listSlangWord.get(slang).remove(prev_definition);
        this.listSlangWord.get(slang).add(new_definition);
    }

    public void deleteSlang(String slang) {
        this.listSlangWord.remove(slang);
    }

    public OneSlangWord randomOneSlang() {
        ArrayList<String> keys = new ArrayList<>(this.listSlangWord.keySet());
        Random random = new Random();
        String randomKey = keys.get(random.nextInt(keys.size()));
        LinkedHashSet<String> definition = this.listSlangWord.get(randomKey);
        return new OneSlangWord(randomKey,definition);
    }
}
