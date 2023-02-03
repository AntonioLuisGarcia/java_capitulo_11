package practices;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    
    private HashMap<String, Integer> wordCounter;
    private BufferedReader br;
    private BufferedWriter bw;
    private String origin;
    private String destiny;

    public WordCounter(String origin,String destiny){
        this.wordCounter = new HashMap<>();
        this.origin = origin;
        this.destiny = destiny;

        try{
            this.br = new BufferedReader(new FileReader(origin));
            this.bw = new BufferedWriter(new FileWriter(destiny));
        }catch(IOException io){
            System.out.println("Los datos no son correctos");
        }
    }

    public void readText(){

        try{
            
            String line = br.readLine();
            
            while(line != null){
                String[] words = line.split(" ");
                counter(words);
                line = br.readLine();
            }
            br.close();

        }catch(IOException io){
        }
    }
    
    private void counter(String[] words){

        for(String w : words){

            if(wordCounter.containsKey(w)){
                wordCounter.put(w,wordCounter.get(w) + 1);
            }else{
                wordCounter.put(w,1);
            }
        }
    }

    public void generateWordCounter(){
        
        try{

            for(Map.Entry<String,Integer> word : wordCounter.entrySet()){
                bw.write(word.getKey() + " - " + word.getValue() + " veces");
                bw.newLine();
            }

            bw.close();
        }catch(IOException io){
        }
    }

    @Override
    public String toString(){

        String text = "";

        for(Map.Entry<String,Integer> word : wordCounter.entrySet()){
            text += word.getKey() + " - " + word.getValue() + " veces\n";
        }

        return text;
    }
}
