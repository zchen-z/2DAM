import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejerc3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta de un directorio: ");
        String entrada = sc.nextLine();
        
        Path rutaDir = Paths.get(entrada);

        if(Files.isDirectory(rutaDir)){
            System.out.println("Contenido de: " + rutaDir.toAbsolutePath());


             if (elementos.isEmpty()) {
                    System.out.println("(El directorio está vacío)");
                } else {
                    // 4. Recorrer y mostrar cada elemento diferenciando si es carpeta o fichero
                    for (Path elemento : elementos) {
                        String nombre = elemento.getFileName();
                    }
        }else{
            System.out.println("\nError: La ruta introducida no existe o no es un directorio válido.");
        }



    }

    
}
}
