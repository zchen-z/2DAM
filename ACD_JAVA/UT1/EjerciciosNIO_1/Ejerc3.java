import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejerc3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta de un directorio: ");
        String entrada = sc.nextLine();

        Path rutaDir = Paths.get(entrada);

        if (Files.isDirectory(rutaDir)) {
            System.out.println("Contenido de: " + rutaDir.toAbsolutePath());

            System.out.println("\nContenido del directorio:");

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(rutaDir)) {
                for (Path elemento : stream) {
                    
                    if (Files.isDirectory(elemento)) {
                        System.out.println("[DIRECTORIO] " + elemento.getFileName());
                    } else {
                        System.out.println("[FICHERO]    " + elemento.getFileName());
                    }
                }

            }

        } else {
            System.out.println("\nError: La ruta introducida no existe o no es un directorio válido.");
        }

        sc.close();
    }

}
