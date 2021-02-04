package javarush.questsyntax.task1923._2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             FileWriter writer = new FileWriter(args[1])) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.equals(word.replaceAll("[\\d]", "")))
                        writer.write(word + " ");
                }
            }
        } catch (IOException e) {
            /* NOP */
        }
    }
}
