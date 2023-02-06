import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ejercicio4 {
    public static void main(String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            int pos = ((args[0].lastIndexOf(".txt")));
            String destiny = ((args[0].substring(0,pos)) + "sort.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(destiny));
            ArrayList<String> words = new ArrayList<>();
            String line = br.readLine();

            while(line != null){
                words.add(line);
                line = br.readLine();
            }
            br.close();
            Collections.sort(words);

            for(String w : words){
                bw.write(w+"\n");
            }
            bw.close();

        } catch (IOException io) {

        }
    }
}
