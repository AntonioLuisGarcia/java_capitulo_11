package practices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class lectorjson {
    public static void main(String[] args) {

        String init = "personas.json";
        try{

            BufferedReader br = new BufferedReader(new FileReader(init));
            //BufferedWriter bw = new BufferedWriter(new FileWriter(args[0]));
            ArrayList<Persona> personas = new ArrayList<>();
            String line= br.readLine();
            boolean object = false;
            int inicioVariable = 0;
            int finalVariable = 0;
            int inicioValor = 0;
            int finalValor = 0;
            String nombreVariable = "";
            String nombre = "";
            String apellido = "";
            Integer edad = 0;
            int contador= 0;


            while(line != null){

                if(line.contains("{")){
                    object = true;
                }

                    //while(object){
                        
                        if(line.contains("}")){
                            object = false;
                        }

                        if( line.contains("\"")){

                            // aqui cogemos el nombre del atributo
                            inicioVariable = line.indexOf("\"");
                            inicioVariable++;
                            finalVariable = line.indexOf("\"",inicioVariable);
                            nombreVariable = line.substring(inicioVariable,finalVariable);
        
                            //aqui cogemos el valor del atributo
                            inicioValor = line.indexOf("\"",finalVariable+1);
                            inicioValor++;
                            finalValor = line.indexOf("\"",inicioValor);
        
                            if(nombreVariable.equals("nombre")){
                                nombre = line.substring(inicioValor,finalValor);
                                contador++;
                            }else if(nombreVariable.equals("apellido")){
                                apellido = line.substring(inicioValor,finalValor);
                                contador++;
                            }else if(nombreVariable.equals("edad")){
                                edad = Integer.parseInt(line.substring(inicioValor,finalValor));
                                contador++;
                            }
                            
                        }

                        line = br.readLine();
                    //}

                    if(!object && contador == 3){
                        contador =0;
                        personas.add(new Persona(edad, nombre, apellido));
                        edad = null;
                        nombre = null;
                        apellido = null;
                    }
            }
            br.close();
            for(Persona p: personas){
                System.out.println(p);
            }

        }catch(IOException io){
            System.out.println("Error");
        }

    }
}
