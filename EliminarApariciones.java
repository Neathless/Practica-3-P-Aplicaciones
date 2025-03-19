/*  PROBLEMA 1.  Escribe un programa que elimina todas las apariciones de una cadena 
especificada de un archivo de texto. */
import java.io.*;

public class EliminarApariciones {
    
    public static void main(String[] args) {
        // Verificar argumentos
        if (args.length != 2) {
            System.out.println("Uso: java EliminadorSimple <cadenaAEliminar> <archivo>");
            return;
        }
        
        String cadenaAEliminar = args[0]; // Primer argumento
        String nombreArchivo = args[1];   // Segundo argumento
        try {
            // Leer el archivo 
            String contenido = "";
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido += linea + "\n";
            }
            lector.close();
            
            // Eliminar la cadena 
            String nuevoContenido = contenido.replace(cadenaAEliminar, "");
            
            // Escribir el resultado de vuelta al archivo
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
            escritor.write(nuevoContenido);
            escritor.close();
            
            System.out.println("Cadena '" + cadenaAEliminar + "' eliminada de " + nombreArchivo);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}