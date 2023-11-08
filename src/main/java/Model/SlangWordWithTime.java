/*
 * Model.SlangWordWithTime
 * Create by Bin
 * Date 11/8/23, 8:25 PM
 * Description:
 */

package Model;
import java.time.LocalDateTime;

public class SlangWordWithTime {
    private OneSlangWord slangwords;
    private LocalDateTime time;

    public SlangWordWithTime(OneSlangWord slangwords, LocalDateTime time) {
        this.slangwords = slangwords;
        this.time = time;
    }

    public OneSlangWord getSlangwords() {
        return slangwords;
    }

    public void setSlangwords(OneSlangWord slangwords) {
        this.slangwords = slangwords;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
