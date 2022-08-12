package main.java;


public class WordCounters {
    public static void main(String[] args) {
        WordCounter test = new WordCounter();
        String text = "day is sunny the\n" + "the day is sunny the the\n" +
                "the sunny is is is is";
        test.writeFile(text);
        test.readFile();
        test.sortWords(test.readFile());


    }
}
