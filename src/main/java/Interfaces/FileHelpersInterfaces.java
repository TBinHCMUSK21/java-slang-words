/*
 * Interfaces.FileHelpers
 * Create by Bin
 * Date 11/10/23, 5:13 PM
 * Description:
 */

/*
 * Interfaces.FileHelpers
 * Create by Bin
 * Date 11/7/23, 11:44 PM
 * Description: A Class to read the data from the file
 */

package Interfaces;

import java.io.IOException;

public interface FileHelpersInterfaces<T> {
    T readAllLines() throws IOException;
    void writeLines(T contents) throws IOException;
    void appendLine(T line) throws IOException;
}