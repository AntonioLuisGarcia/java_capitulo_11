package practices;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


public class lectorjson {
    public static void main(String[] args) {
        try{

            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            //BufferedWriter bw = new BufferedWriter(new FileWriter(args[0]));
            String line= "";
            boolean object = false;
            int inicioVariable = 0;
            int finalVariable = 0;
            int inicioValor = 0;
            int finalValor = 0;
            String nombreVariable = "";
            String nombre = "";
            String apellido = "";
            int edad = 0;


            while((line=br.readLine()) != null){

                if(line.contains("{")){
                    object = true;

                    while(object){
                        
                        if(line.contains("}")){
                            object = false;
                        }

                        if(object = true && line.contains("\"")){

                            // aqui cogemos el nombre del atributo
                            inicioVariable = line.indexOf("\"");
                            inicioVariable++;
                            finalVariable = line.indexOf("\"",inicioVariable);
                            nombreVariable = line.substring(inicioVariable,finalVariable);
        
                            //aqui cogemos el valor del atributo
                            inicioValor = line.indexOf("\n",finalVariable+1);
                            inicioValor++;
                            finalValor = line.indexOf("\n",inicioValor);
        
                            if(nombreVariable.equals("nombre")){
                                nombre = line.substring(inicioValor,finalValor);
                            }else if(nombreVariable.equals("apellido")){
                                apellido = line.substring(inicioValor,finalValor);
                            }else if(nombreVariable.equals("edad")){
                                edad = Integer.parseInt(line.substring(inicioValor,finalValor));
                            }
        
                        }

                        line = br.readLine();
                    }

                    //creamos objecto
                }

            }

        }catch(IOException io){
            System.out.println("Error");
        }

    }
}
