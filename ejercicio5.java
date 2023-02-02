import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio5 {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
            String lineaOrigen = "";
            String lineaDestino = "";
            boolean comentarioDeBloque = false;

            int i = 0;
            
            while ((lineaOrigen = br.readLine()) != null) {
                
                int l = lineaOrigen.length();
                lineaDestino = lineaOrigen;

                // Detecta inicio de comentario de bloque 
                if ((i = lineaOrigen.indexOf("/*")) != -1) {
                    comentarioDeBloque = true;
                    lineaDestino = lineaOrigen.substring(i+2);
                    lineaOrigen = lineaDestino;
                }
                
                // Detecta fin de comentario de bloque 
                if ((i = lineaOrigen.indexOf("*/")) != -1) {
                    comentarioDeBloque = false;
                    lineaDestino = lineaOrigen.substring(i + 2, l);
                }
                // Detecta comentario de línea
                if (((i = lineaOrigen.indexOf("//")) != -1) && !comentarioDeBloque) {
                    lineaDestino = lineaOrigen.substring(i+2);
                }

                if (!comentarioDeBloque) {
                    bw.write(lineaDestino + "\n");
                }
            }
            
            br.close();
            bw.close();
        } catch (IOException io) {
        }
    }
}
