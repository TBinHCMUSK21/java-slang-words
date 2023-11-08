/*
 * Model.SlangWordWithTime
 * Create by Bin
 * Date 11/8/23, 8:25 PM
 * Description:
 */

package Model;
import java.time.LocalDateTime;

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

}
