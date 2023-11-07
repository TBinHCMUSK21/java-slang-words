/*
 * Utils.FileHelpers
 * Create by Bin
 * Date 11/7/23, 11:44 PM
 * Description: A Class to read the data from the file
 */

package Utils;

import java.io.IOException;

public interface FileHelpers<T> {
    T readAllLines() throws IOException;
    void writeLines(T contents) throws IOException;
    void appendLine(T line) throws IOException;
}