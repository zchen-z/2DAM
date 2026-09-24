import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Ejerc2 {
    public static void main(String[] args) {
        Path rutaDirectorio = Paths.get("PruebasNIO");
        Path rutaFichero = rutaDirectorio.resolve("saludo.txt");

        try {
            if (Files.notExists(rutaDirectorio)) {
                Files.createDirectories(rutaDirectorio);
                System.out.println("Directorio 'PruebasNIO' creado.");
            }

            if (Files.notExists(rutaFichero)) {
                Files.createFile(rutaFichero);
                System.out.println("Fichero saludo.txt creado dentro de PruebasNIO");
            } else {
                System.out.println("El fichero 'saludo.txt' ya existe.");
            }

            String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String texto = "Hola desde NIO.2. Hoy es " + fechaActual;

            Files.writeString(rutaFichero, texto);
            System.out.println("Texto escrito correctamente en 'saludo.txt'.\n");

            System.out.println("--- Contenido del fichero ---");
            List<String> lineas = Files.readAllLines(rutaFichero);
            
            for (String linea : lineas) {
                System.out.println(linea);
            }

            System.out.println("-----------------------------");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al gestionar los archivos: " + e.getMessage());
        }

    }
}
