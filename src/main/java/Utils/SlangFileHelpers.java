/*
 * Utils.SlangFileHelpers
 * Create by Bin
 * Date 11/7/23, 11:49 PM
 * Description: File helper for ListOfSlangWords
 */

package Utils;
import Model.ListSlangWord;

import java.io.*;
import java.util.*;

public class SlangFileHelpers implements FileHelpers<ListSlangWord> {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public SlangFileHelpers() {
    }
    public SlangFileHelpers(String path) {
        this.path = path;
    }

    @Override
    public ListSlangWord readAllLines()  {
        HashMap<String, LinkedHashSet<String>> data = new HashMap<>();
        try {
            BufferedReader fin = new BufferedReader(new FileReader(path));
            // Deal with the first line
            fin.readLine();
            // Read the list of Slang words
            while (true) {
                String str = fin.readLine();
                if (str == null) {
                    break;
                }
                String[] splitWord = str.split("`");
                if (splitWord.length<=1){
                    continue;
                }
                LinkedHashSet<String> definitions = new LinkedHashSet<>
                        (Arrays.asList(splitWord[1].split("\\|")));
                data.put(splitWord[0],definitions);
            }
            fin.close();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            throw new RuntimeException("Error reading from file", e);
        }
        return new ListSlangWord(data);
    }
    @Override
    public void writeLines(ListSlangWord listSlangWord) throws IOException {
        BufferedWriter fout = new BufferedWriter(new FileWriter(path));
        fout.write("Slang`Definitions\n");
        fout.write(listSlangWord.toString());
        fout.close();
    }
    @Override
    public void appendLine(ListSlangWord listSlangWord) throws IOException {
        BufferedWriter fout = new BufferedWriter(new FileWriter(path,true));
        fout.write(listSlangWord.toString());
        fout.close();
    }
}
