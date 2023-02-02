/*
 * Ejercicio 3.
 * 
 * Escribe un programa que guarde en un fichero el contenido de otros dos ficheros, de tal forma que 
 * en el fichero resultante aparezcan las líneas de los primeros dos ficheros mezcladas, es decir, la 
 * primera línea será del primer fichero, la segunda será del segundo fichero, la tercera será la siguiente del
 * primer fichero, etc. Los nombres de los dos ficheros origen y el nombre del fichero destino se deben pasar 
 * como argumentos en la línea de comandos. Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas
 * pueden tener tamaños diferentes
 * 
 * @author Antonio Luis Garcia
 */

public class ejercicio3 {
    public static void main(String[] args) {
        if(args.length!=3){
            System.out.println("Número incorecto de argumentos");
            return;
        }
        try {
            FileMixer fm = new FileMixer(args[0], args[1], args[2]);    
            fm.writeToFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
