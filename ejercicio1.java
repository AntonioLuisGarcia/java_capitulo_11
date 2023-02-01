/*
 * Ejercicio 1.
 * 
 * Escribe un programa que guarde en un fichero con nombre primos.dat los números primos que hay entre 1 y 500.
 * 
 * @author Antonio Luis Garcia
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import print.consolePrint;

public class ejercicio1{
    public static void main(String[] args) {
        
        
        int nPrimo = 1;
        String cadena = "";
        
        try{

            BufferedWriter bw = new BufferedWriter(new FileWriter("primos.dat"));
            String text = nPrimo + ", ";
            consolePrint.print(text,bw);
            
            do{    
                nPrimo = siguientePrimo(nPrimo);
                cadena = (nPrimo==499 ? nPrimo + "": nPrimo + ", ");
                bw.write(cadena);
                consolePrint.print(text, bw);
            }while(nPrimo<499);

            bw.close();
            
        }catch(IOException e){
            System.out.println("No se ha podido escribir en el fichero");
        }


    }

    public static boolean esPrimo(int n){

            for(int i = 2; i < n ;  i++){
                if(n%i == 0){
                    return false;
                }
            }

            return true;
    }

    public static int siguientePrimo(int n){

        do{
            n++;
        }while(!esPrimo(n));

        return n;
    }
}