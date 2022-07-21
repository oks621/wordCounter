package main.java;

import java.io.*;
import java.util.*;

public class WordCounter {
    public void writeFile() {
        File file = new File("file.txt");

        try (FileWriter writer = new FileWriter(file)) {
            String text = "the day is sunny the the\n" +
                    "the sunny is is";
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void counterWord() {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line1 = sb.toString();
        String[] array = line1.split(" ");
        Map<String, Integer> words = new HashMap<>();

        for (String string : array) {
            if (words.containsKey(string))
                words.put(string, words.get(string) + 1);
            else {
                words.put(string, 1);
            }
        }
        MyComparator comparator = new MyComparator(words);

        Map<String, Integer> newMap = new TreeMap<>(comparator);
        newMap.putAll(words);
        for (Map.Entry<String, Integer> map : newMap.entrySet()) {
            String key = map.getKey();
            Integer value = map.getValue();

            System.out.printf("%s %s\n", key, value);
        }
    }
}

