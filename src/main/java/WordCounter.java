package main.java;

import java.io.*;
import java.util.*;

public class WordCounter {

    public void writeFile() {
        File file = new File("file.txt");

        try (FileWriter writer = new FileWriter(file)) {
            String text = "the day is sunny the the\n" +
                    "the sunny is is is is";
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> readFile() {
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
      List<String> array = List.of(line1.split(" "));
        return array;
    }

    public Map<String, Integer> sortWords() {

        Map<String, Integer> words = new TreeMap<>();

        for (String string : readFile()) {
            if (words.containsKey(string))
                words.put(string, words.get(string) + 1);
            else {
                words.put(string, 1);
            }
        }
        MyComparator comparator = new MyComparator(words);

        Map<String, Integer> newMap = new TreeMap<>(comparator);
        newMap.putAll(words);

        return newMap;
    }

    public void printWords() {

        for (Map.Entry<String, Integer> map : sortWords().entrySet()) {
            String key = map.getKey();
            Integer value = map.getValue();

            System.out.printf("%s %s\n", key, value);
        }
    }
}

