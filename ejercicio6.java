import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio6 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line = br.readLine();
            int apearences = 0;

            while(line != null){
                if(line.contains(args[1])){
                    
                    apearences++;
                }
                line = br.readLine();
            }

            br.close();
            System.out.println(args[1] + " apear " + apearences +" times");
        } catch (IOException io) {
        }
    }

}
