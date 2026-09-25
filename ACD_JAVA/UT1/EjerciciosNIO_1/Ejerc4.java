import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejerc4 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta del directorio base: ");
        String entrada = sc.nextLine();
        sc.close();

        Path directorioBase = Paths.get(entrada);

        if (!Files.isDirectory(directorioBase)) {
            System.err.println("Error: La ruta introducida no es un directorio válido o no existe.");
        } else {
            System.out.println("\nListando todos los ficheros de forma recursiva:");
            System.out.println("-----------------------------------------------------------------");

            List<Path> todosLosElementos;
            try (Stream<Path> explorador = Files.walk(directorioBase)) {
                todosLosElementos = explorador.toList();
            }

            for (Path elemento : todosLosElementos) {
                
                // Si es un fichero (y no una carpeta), mostramos su ruta absoluta
                if (Files.isRegularFile(elemento)) {
                    Path rutaAbsoluta = elemento.toAbsolutePath();
                    System.out.println(rutaAbsoluta);
                }
            }

            
        }

    }
}
