import java.io.*;

/**
 PROBLEMA 2.  Escriba un programa que cuente el número de caracteres, palabras y líneas en un archivo. Las palabras 
 están separadas por espacios en blanco. 
 */
public class ContadorCaracteres {
    
    public static void main(String[] args) {
        // Verificar que se haya proporcionado el nombre del archivo como argumento
        if (args.length != 1) {
            System.out.println("Error: Debe proporcionar el nombre del archivo como argumento.");
            System.out.println("Uso: java ContadorArchivo <nombreArchivo>");
            return;
        }
        
        // Obtener el nombre del archivo del argumento
        String nombreArchivo = args[0];
        
        // Variables para los contadores
        int contadorCaracteres = 0;
        int contadorPalabras = 0;
        int contadorLineas = 0;
        
        try {
            // Crear un objeto FileReader y BufferedReader para leer el archivo
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String linea;
            
            // Leer el archivo línea por línea
            while ((linea = bufferedReader.readLine()) != null) {
                // Incrementar el contador de líneas
                contadorLineas++;
                
                // Añadir la longitud de la línea al contador de caracteres
                contadorCaracteres += linea.length();
                
                // Si la línea no está vacía, contar las palabras
                if (!linea.isEmpty()) {
                    // Dividir la línea en palabras usando espacios en blanco como separadores
                    String[] palabras = linea.split("\\s+");
                    contadorPalabras += palabras.length;
                }
            }
            
            // Cerrar los recursos
            bufferedReader.close();
            
            // Mostrar los resultados
            System.out.println(contadorCaracteres + " caracteres");
            System.out.println(contadorPalabras + " palabras");
            System.out.println(contadorLineas + " líneas");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo encontrar el archivo '" + nombreArchivo + "'");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
