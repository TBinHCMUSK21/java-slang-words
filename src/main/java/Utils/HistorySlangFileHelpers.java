/*
 * Utils.HistorySlangFileHelpers
 * Create by Bin
 * Date 11/9/23, 11:26 PM
 * Description:
 */

package Utils;

import Model.ListSlangWord;
import Model.OneSlangWord;
import Model.SlangWordWithTime;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HistorySlangFileHelpers implements FileHelpers<ArrayList<SlangWordWithTime>> {
    private String path;

    private HistorySlangFileHelpers() {
    }

    private HistorySlangFileHelpers(String path) {
        this.path = path;
    }

    private static class SingletonHelper {
        private static final HistorySlangFileHelpers INSTANCE = new HistorySlangFileHelpers();
    }

    public static HistorySlangFileHelpers getInstance() {
        return HistorySlangFileHelpers.SingletonHelper.INSTANCE;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    @Override
    public ArrayList<SlangWordWithTime> readAllLines() throws IOException {
        ArrayList<SlangWordWithTime> data = new ArrayList<>();
        try {
            BufferedReader fin = new BufferedReader(new FileReader(path));
            fin.readLine();
            while (true) {
                String str = fin.readLine();
                if (str == null) {
                    break;
                }
                String[] splitWord = str.split("`");
                if (splitWord.length<=1){
                    continue;
                }
                List<String> tmp = Arrays.stream(splitWord[1].split("\\|"))
                        .map(String::trim)
                        .toList();
                LinkedHashSet<String> definitions = new LinkedHashSet<>(tmp);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
                LocalDateTime time = LocalDateTime.parse(splitWord[2], formatter);
                SlangWordWithTime newSlang = new SlangWordWithTime(
                        new OneSlangWord(splitWord[0],definitions),time);
                data.add(newSlang);
            }
            fin.close();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            throw new RuntimeException("Error reading from file", e);
        }
        return data;
    }

    @Override
    public void writeLines(ArrayList<SlangWordWithTime> contents) throws IOException {
        BufferedWriter fout = new BufferedWriter(new FileWriter(path));
        fout.write("Slang`Definitions\n");
        for (SlangWordWithTime each:contents){
            fout.write(each.toString());
            fout.write("\n");
        }
        fout.close();
    }

    @Override
    public void appendLine(ArrayList<SlangWordWithTime> line) throws IOException {
        BufferedWriter fout = new BufferedWriter(new FileWriter(path,true));
        for (SlangWordWithTime each:line){
            fout.write(each.toString());
            fout.write("\n");
        }
        fout.close();
    }
}
