package com.mber.javarush.task.task18.task1820;

import java.io.*;

/*
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        reader = new BufferedReader(new FileReader(fileName1));
        String num = reader.readLine();
        String[] numbers = num.split(" ");
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        for (String number : numbers) {
            writer.write(Math.round(Double.parseDouble(number)) + " ");
        }
    }
}
