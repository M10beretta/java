package javarush.questsyntax.task2003._1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {

        Properties properties = new Properties();
        properties.putAll(runtimeStorage);
        properties.store(outputStream, "my comments");
    }

    public static void load(InputStream inputStream) throws IOException {

        Properties properties = new Properties();
        properties.load(inputStream);
        properties.forEach((k, v) -> runtimeStorage.put((String) k, (String) v));

    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
            Solution.save(new FileOutputStream(reader.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
