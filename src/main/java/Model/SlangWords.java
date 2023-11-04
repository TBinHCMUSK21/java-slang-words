/*
 * Model.SlangWords
 * Create by Bin
 * Date 11/5/23, 12:19 AM
 * Description: Class to store Slang Words
 */
package Model;
import java.util.List;
public class SlangWords {
    private String slangWords;
    private List<String> definitions;

    /**
     * Default Constructor
     */
    public SlangWords() {
        slangWords = "";
        definitions = null;
    }

    /**
     * Constructor with parameters
     * @param slangWords: Slang words
     * @param definitions: A List of definition of slang word
     */
    public SlangWords(String slangWords, List<String> definitions) {
        this.slangWords = slangWords;
        this.definitions = definitions;
    }

    /**
     * Getter of slangWords
     * @return slangWords
     */
    public String getSlangWords() {
        return slangWords;
    }

    /**
     * Setter of slangWords
     * @param slangWords: slang words
     */
    public void setSlangWords(String slangWords) {
        this.slangWords = slangWords;
    }
    /**
     * Getter of list of definitions
     * @return list of definitions
     */
    public List<String> getDefinitions() {
        return definitions;
    }
    /**
     * Setter of list of definitions
     * @param definitions: list of definitions
     */
    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<this.definitions.size();i++){
            builder.append(this.slangWords);
            builder.append('`');
            builder.append(this.definitions.get(i));
        }
        return builder.toString();
    }
}
