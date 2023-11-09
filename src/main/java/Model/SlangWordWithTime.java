/*
 * Model.SlangWordWithTime
 * Create by Bin
 * Date 11/8/23, 8:25 PM
 * Description:
 */

package Model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Map;

public class SlangWordWithTime {
    private OneSlangWord slangWords;
    private LocalDateTime time;

    public SlangWordWithTime(OneSlangWord slangWords, LocalDateTime time) {
        this.slangWords = slangWords;
        this.time = time;
    }


    public OneSlangWord getSlangWords() {
        return slangWords;
    }

    public void setSlangWords(OneSlangWord slangWords) {
        this.slangWords = slangWords;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.slangWords.toString());
        builder.append("`");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        String formattedDateTime = time.format(formatter);
        builder.append(formattedDateTime);
        return builder.toString();
    }

}
