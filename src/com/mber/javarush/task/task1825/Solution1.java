package com.mber.javarush.task.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> files = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] parts1 = o1.split(".part");
                String[] parts2 = o2.split(".part");
                int number1 = Integer.parseInt(parts1[parts1.length - 1]);
                int number2 = Integer.parseInt(parts2[parts2.length - 1]);
                return number1 - number2;
            }
        });
        String outputFile = null;                                               // для определения имени outputFile
        String readString;
        while (!(readString = reader.readLine()).equals("end")) {
            files.add(readString);
            if (outputFile == null) {                                           // outputFile один раз
                int indexOfSuffix = readString.lastIndexOf(".part");
                outputFile = readString.substring(0, indexOfSuffix);
            }
        }
        if (outputFile == null) return;                                         // выход, если неправильное имя
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            for (String file : files) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    while (fileInputStream.available() > 0) {
                        int bytesRead = fileInputStream.read(buffer);           // заполняем буфер, получаем количество байтов
                        fileOutputStream.write(buffer, 0, bytesRead);       // записываем буфер в выходном потоке
                    }
                }
            }
        }
    }
}