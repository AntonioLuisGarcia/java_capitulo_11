import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileMixer {

    private String orig1;
    private String orig2;
    private String dest;
    ArrayList<String> mixture = new ArrayList<>();
    public boolean initialized = false;

    public FileMixer(String orig1, String orig2, String dest) throws Exception {
        this.init(orig1, orig2, dest);
    }

    private void init(String orig1, String orig2, String dest)throws Exception{
        this.orig1 = orig1;
        this.orig2 = orig2;
        this.dest = dest;
        this.initialized = true;
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(this.orig1));
            BufferedReader br2 = new BufferedReader(new FileReader(this.orig2));
            String linea1 = br1.readLine();
            String linea2 = br2.readLine();

            while((linea1 != null) || (linea2 != null)){
                String _mixture = "";
                if(linea1 != null){
                    mixture.add(linea1);
                    linea1 = br1.readLine();
                }
                
                if(linea2!= null){
                    mixture.add(linea2);
                    linea2 = br2.readLine();
                }

                mixture.add(_mixture);
            }

            br1.close();
            br2.close();

        }catch(Exception e){
            throw new Exception();
        }
    }

    public boolean writeToFile(){
        if(this.initialized){
            try {
                File file = new File(this.dest);
                if(file != null){
                    BufferedWriter bw = new BufferedWriter(new FileWriter(this.dest));
                    for(String linea : mixture){
                        bw.write(String.format("%s\n",linea));
                    }
                    bw.close();
                }
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }
}
