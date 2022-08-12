package main.java;

import java.io.*;
import java.util.*;


public class WordCounter {

    private List<String> list = new ArrayList<>();

    public void writeFile(String text) {
        File file = new File("file.txt");

        try (FileWriter writer = new FileWriter(file)) {

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
        list = List.of(line1.split(" "));
        return list;

    }

    public void sortWords(List<String> list) {
        Set<String> distinct = new HashSet<>(list);
        printWords(distinct);

    }

    private void printWords(Set<String> distinct) {
        for (String s : distinct) {
            System.out.println(s + " " + Collections.frequency(list, s));
        }
    }
}

