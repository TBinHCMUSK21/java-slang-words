/*
 * Model.SlangWord
 * Create by Bin
 * Date 11/6/23, 1:02 AM
 * Description: Class for Slang Word
 */

package Model;

import java.util.LinkedHashSet;

public class OneSlangWord {
    private String slang;
    private LinkedHashSet<String> definitions;

    /**
     * Default Constructor
     */
    public OneSlangWord(){
        this.slang = "";
        this.definitions = new LinkedHashSet<>();
    }

    /**
     * Constructor with parameters
     * @param slang: slang word
     * @param definitions: list of definitions
     */
    public OneSlangWord(String slang, LinkedHashSet<String> definitions){
        super();
        this.slang=slang;
        this.definitions=definitions;
    }

    /**
     * Getter of the class OneSlangWord
     * @return slang: slang word
     */
    public String getSlang() {
        return slang;
    }

    /**
     * Setter of the class OneSlangWord
     * @param slang: slang word
     */
    public void setSlang(String slang) {
        this.slang = slang;
    }

    /**
     * Getter of the class OneSlangWord
     * @return definition: list of definition
     */
    public LinkedHashSet<String> getDefinitions() {
        return definitions;
    }
    /**
     * Setter of the class OneSlangWord
     * @param definitions: list of definition
     */
    public void setDefinitions(LinkedHashSet<String> definitions) {
        this.definitions = definitions;
    }
}
