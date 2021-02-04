package javarush.questsyntax.task1919._1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> treeMap = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (true) {
                String sting = reader.readLine();
                if (sting == null) break;
                String key = sting.replaceAll("[^a-яА-я]+", "");
                double value = Double.parseDouble(sting.replaceAll("[a-яА-я]+ ", "").trim());

                if (treeMap.containsKey(key)) {
                    double newValue = treeMap.get(key) + value;
                    treeMap.put(key, newValue);
                } else treeMap.put(key, value);

            }
        }

        for (Map.Entry<String, Double> stringIntegerEntry : treeMap.entrySet()) {
            System.out.printf("%s %s\n", stringIntegerEntry.getKey(),
                    new DecimalFormat("#.0#").format(stringIntegerEntry.getValue()).replaceAll(",", "."));
        }
    }
}
