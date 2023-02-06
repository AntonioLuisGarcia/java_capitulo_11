import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class Ejercicio4_2 {
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Error en los argumentos.");
            System.out.println("Ayuda");
            System.out.println("java Ejercicio4 file.txt");
            return;
        }
        String file = args[0];
        BufferedReader br = null;
        ArrayList<String> palabras = new ArrayList<String>();

        try {
            br = new BufferedReader(new FileReader(file));
            String linea="";
            while((linea=br.readLine()) != null){
                palabras.add(linea);
            }
            br.close();
            Collections.sort(palabras);
            int pos = 0;
            String sortedFile = ((pos=file.lastIndexOf(".txt"))!=-1?file.substring(0, pos):file) + "_sorted.txt"; 
            BufferedWriter bw = new BufferedWriter(new FileWriter(sortedFile));
            for(String l : palabras){
                bw.write(l+"\n");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
