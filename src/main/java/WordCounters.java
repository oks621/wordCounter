package main.java;

public class WordCounters {
    public static void main(String[] args) {
       WordCounter test=new WordCounter();
       test.writeFile();
       test.readFile();
       test.sortWords();
       test.printWords();
    }
}
