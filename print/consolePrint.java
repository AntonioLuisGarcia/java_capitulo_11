package print;

import java.io.BufferedWriter;
import java.io.IOException;

public class consolePrint {
    public static void print(String text){
        System.out.println(text);
    }

    public static void print(String text, BufferedWriter bw)throws IOException{
        if(bw != null){
            try {
              bw.write(text);      
            } catch (IOException io) {
                throw io;
            }
        }else{
            print(text);
        }
    }
}
