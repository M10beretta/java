package javarush.questsyntax.task1923._0;

import java.io.*;
/*
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             FileWriter fileWriter = new FileWriter(args[1])) {
            String fileReadLine;
            String[] splitedLine;
            while ((fileReadLine = fileReader.readLine()) != null) {
                splitedLine = fileReadLine.split(" ");
                for (String word : splitedLine) {
                    if (word.matches(".+[0-9].+")) {
                        fileWriter.write(word + " ");
                    }
                }
            }
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}