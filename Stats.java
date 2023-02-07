import java.util.ArrayList;
import java.util.Collections;

import estadisticas.FileStats;
import estadisticas.Word;

public class Stats {
    public static void main(String[] args) {

        if(args.length != 1){
            System.out.println("Error de paso de argumentos");
        }

        String file = args[0];
        FileStats fs = new FileStats(file);

        try{
            ArrayList<String> lista = fs.getLines();
            ArrayList<String> words = fs.getWords();
            ArrayList<Word> difWords = fs.getDifferentWords();
            //System.out.println(lista);
            System.out.println("Numero de lineas: " + lista.size());
            System.out.println("Hay " + words.size() + " palabras");
            System.out.println(difWords.size());
            Collections.sort(difWords);
            System.out.println(difWords);
        }catch(Exception e){
            System.out.println("Error");
        }        
    }
}
