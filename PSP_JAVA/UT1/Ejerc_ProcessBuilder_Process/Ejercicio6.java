package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;



public class Ejercicio6 {
    public static void main(String[] args) {
        Path carpeta = Path.of("UT1", "pruebas");
        Path fichero = carpeta.resolve("fichero.txt");

    
        ProcessBuilder pb = new ProcessBuilder("touch", "fichero.txt");
        pb.directory(carpeta.toFile());

        try {
            if(!Files.isDirectory(carpeta)){
                System.out.println("La carpeta " + carpeta + " no existe, la creo");
                Files.createDirectories(carpeta);
            }

            System.out.println("Lanzando " + pb.command() + " en la carpeta " + carpeta);
            Process p = pb.start();

            int codigo = p.waitFor();
            System.out.println("Codigo de salida: " + codigo);

            if(Files.exists(fichero)){
                System.out.println("El fichero se ha creado en " + fichero.toAbsolutePath());
            }else{
                System.out.println("El fichero no esta en " + fichero.toAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException e){
            System.out.println("La espera fue interrumpida");
        }
    }
}
