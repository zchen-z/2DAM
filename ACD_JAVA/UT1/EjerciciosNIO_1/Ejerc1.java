import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejerc1 {
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ruta del fichero: ");
            String entrada = sc.nextLine();
            
            Path ruta = Paths.get(entrada);
            
            if (Files.notExists(ruta)) {
                Files.createFile(ruta);
                System.out.println("Se acaba de crear");
            } else {
                System.out.println("Ya existe este archivo");
            }
            
            System.out.println("Nombre: " + ruta.getFileName());
            System.out.println("Direcctorio padre: " + ruta.getParent());
            
            if (Files.isRegularFile(ruta)) {
                System.out.println("Es un fichero");
            } else if (Files.isDirectory(ruta)) {
                System.out.println("Es un directorio");
            } else {
                System.out.println("La ruta no existe o es un tipo especial");
            }
            
            if (Files.isRegularFile(ruta)) {
                try {
                    long bytes = Files.size(ruta);
                    
                    System.out.println("El fichero existe.");
                    System.out.println("Tamaño: " + bytes + " bytes");
                    
                } catch (IOException e) {
                    System.out.println("Error al leer el tamaño del archivo: " + e.getMessage());
                }
            } else {
                System.out.println("La ruta no existe o no es un fichero válido.");
            }
        }
    }
}
