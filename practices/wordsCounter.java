package practices;

public class wordsCounter {
    public static void main(String[] args) {
        WordCounter w = new WordCounter(args[0] , args[1]);
        w.readText();
        w.generateWordCounter();
        System.out.println(w);
    }
}
