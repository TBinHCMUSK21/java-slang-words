/*
 * Model.SlangWord
 * Create by Bin
 * Date 11/6/23, 1:02 AM
 * Description: Class for Slang Word
 */

package Model;

import java.util.LinkedHashSet;

public class SlangWord {
    private String slang;
    private LinkedHashSet<String> definitions;

    /**
     * Default Constructor
     */
    public SlangWord(){
        this.slang = "";
        this.definitions = new LinkedHashSet<>();
    }

    /**
     * Constructor with parameters
     * @param slang: slang word
     * @param definitions: list of definitions
     */
    public SlangWord(String slang, LinkedHashSet<String> definitions){
        super();
        this.slang=slang;
        this.definitions=definitions;
    }


    public String getSlang() {
        return slang;
    }

    public void setSlang(String slang) {
        this.slang = slang;
    }

    public LinkedHashSet<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(LinkedHashSet<String> definitions) {
        this.definitions = definitions;
    }
}
