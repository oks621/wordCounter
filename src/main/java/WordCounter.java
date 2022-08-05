package main.java;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class WordCounter  {
  private   List list=new ArrayList<>();

    @Override
    public String toString() {
        return  sortedMap.keySet() +" "+sortedMap.values()
               ;
    }

    private Map<String,Integer> sortedMap=new HashMap<>();
    public void writeFile() {
        File file = new File("file.txt");

        try (FileWriter writer = new FileWriter(file)) {
            String text = "the day is sunny the the\n" +"the day is sunny the the\n"+
                    "the sunny is is is is";
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFile() {
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
    }

    public void sortWords() {
        for (Object list1:list) {
            if (sortedMap.containsKey(list1))
                sortedMap.put(String.valueOf(list1), sortedMap.get(list1) + 1);
            else {
                sortedMap.put(String.valueOf(list1), 1);
            }
        }
        list = new ArrayList(sortedMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b)
            {
                return b.getValue() - a.getValue();
            }
        });
        }

    public void printWords() {
        for (Object word:list) {
            String string= String.valueOf(word);
            String string1=  string.replace("="," ") ;
            System.out.println(string1);
        }


    }}

