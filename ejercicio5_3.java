import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio5_3 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
            String line = br.readLine();

            while(line != null){
                if(line.contains("//")){
                    bw.write("\n");                    
                }else{
                    bw.write(line + "\n");                    
                }
                line = br.readLine();
            }

            bw.close();
            br.close();
        } catch (IOException io) {
        }
    }
}
