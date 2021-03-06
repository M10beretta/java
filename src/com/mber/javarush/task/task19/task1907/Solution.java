package com.mber.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Считаем слово
*/

public class Solution {
    private static int counter = 0;

    public static void main(String[] args) throws IOException {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        StringBuilder text = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) text.append((char) fileReader.read());
        }
        String replaceString = text.toString().replaceAll("\\p{Punct}", " ").replaceAll("\\s", " ");
        for (String x : replaceString.split(" ")) {
            if (x.equals("world")) counter++;
        }
        System.out.println(counter);

    }
}

