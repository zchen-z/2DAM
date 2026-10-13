import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejerc1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ruta de fichero: ");
        Path ruta1 = Paths.get(sc.nextLine());


        System.out.println("Nombre del fichero: ");
        System.out.println(ruta1.getFileName());
        System.out.println(ruta1.toAbsolutePath().getParent());

        if(Files.exists(ruta1)){
            System.out.println("La ruta existe");
            if(Files.isRegularFile(ruta1)){
                System.out.println("Es un fichero");
                System.out.println("Tamaño: " + Files.size(ruta1) + "bytes");
            }else if(Files.isDirectory(ruta1)){
                System.out.println("Es un directorio");
            }
        }else{
            System.out.println("La ruta no existe");
        }
    }
}
