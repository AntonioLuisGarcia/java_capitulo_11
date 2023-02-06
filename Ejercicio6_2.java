import java.io.BufferedReader;
import java.io.FileReader;
public class Ejercicio6_2 {
    public static void main(String[] args){
        if(args.length!=2){
            System.out.println("Error en el paso de argumentos");
            return;
        }

        try {
            String archivo = args[0];
            String palabra = args[1];

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea = "";
            int contador = 0;
            System.out.print("Procesando archivo");
            while((linea=br.readLine())!=null){
                int i = 0;
                while ((i=linea.indexOf(palabra))!=-1) {
                    linea = linea.substring(i+palabra.length(), linea.length());
                    contador++;
                }
                System.out.print(".");
            }
            br.close();
            if (contador>0) {
                String resultado = "\nLa palabra %s aparece %d " + ((contador>1)?"veces":"vez");
                System.out.printf(resultado, palabra, contador);    
            }
            else
                System.out.printf("\nLa palabra %s no aparece en el archivo", palabra);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }    
}
