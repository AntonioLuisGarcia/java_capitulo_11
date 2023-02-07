package estadisticas;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileStats {
    
    private String filename;

    public FileStats(String filename){
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    public ArrayList<String> getLines(){
        ArrayList<String> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            String line = "";

            while( (line=br.readLine()) != null){
                list.add(line);
            }
            br.close();
        }catch(IOException io){
            System.out.println(io.getMessage());
        }

        return list; 
    }

    public ArrayList<String> getWords(){

        ArrayList<String> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            String line = "";

            while( (line=br.readLine()) != null){
                line = reduceBlanks(replaceIfNotAlphabetic(line, ' '));
                String[] words = line.split(" ");
                for(int i = 0 ; i < words.length; i ++){
                    if(words[i] != null && !words.equals("")){
                        list.add(words[i]);
                    }
                }
            }
            br.close();
        }catch(IOException io){
            System.out.println(io.getMessage());
        }

        return list; 
    }

    private String replaceIfNotAlphabetic(String text, char replaceBy){
        for(int i = 0 ; i< text.length(); i++){
            if(!Character.isAlphabetic(text.charAt(i))){
                text = text.replace(text.charAt(i),replaceBy);
            }
        }
        return text;
    }

    private static String reduceBlanks(String entry){
        return entry.trim().replaceAll("\\s+", " ");
    }

    public ArrayList<Word> getDifferentWords(){
        HashMap<String,Word> wordsAuxiliar = new HashMap<>();
        ArrayList<Word> words = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            String line = "";

            while( (line=br.readLine()) != null){
                line = reduceBlanks(replaceIfNotAlphabetic(line, ' '));
                String[] wordsArray = line.split(" ");
                for(int i = 0 ; i < wordsArray.length; i ++){
                    if(wordsArray[i] != null && !wordsArray.equals("")){
                        if(wordsAuxiliar.containsKey(wordsArray[i])){
                            Word w = wordsAuxiliar.get(wordsArray[i]);
                            w.inc();
                            wordsAuxiliar.put(wordsArray[i],w);
                        }else{
                            wordsAuxiliar.put(wordsArray[i], new Word(wordsArray[i], 1));
                        }
                    }
                }
            }

            for(Word w : wordsAuxiliar.values()){
                words.add(w);
            }

            br.close();
            
        }catch(IOException io){
            System.out.println(io.getMessage());
        }

        return words;
    }
}
