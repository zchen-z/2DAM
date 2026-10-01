package UT1;

import java.io.File;
import java.io.IOException;

public class Ejercicio6 {
    public static void main(String[] args) {
        File directorioTrabajo = new File("pruebas");
        String nombreFichero = "fichero.txt";

        if (!directorioTrabajo.exists() || !directorioTrabajo.isDirectory()) {
            System.err.println("Error: La carpeta 'pruebas' no existe. Créala primero.");
        }else{
        ProcessBuilder pb = new ProcessBuilder("touch", nombreFichero);

        pb.directory(directorioTrabajo);

        try {
            System.out.println("Ejecutando comando touch...");
            Process proceso = pb.start();
            int codigoSalida = proceso.waitFor();

            if (codigoSalida == 0) {
                System.out.println("El proceso touch ha terminado correctamente.");
                
                File ficheroCreado = new File(directorioTrabajo, nombreFichero);

                if (ficheroCreado.exists()) {
                    System.out.println("Verificación Java. El fichero existe en: " + ficheroCreado.getAbsolutePath());
                } else {
                    System.err.println("Verificación Java. Error: El fichero NO se encuentra en la ruta esperada.");
                }
                
            } else {
                System.err.println("El comando falló con el código de salida: " + codigoSalida);
            }

        } catch (IOException e) {
            System.err.println("Error de E/S al ejecutar el comando: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El proceso fue interrumpido: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        }

        
    }
}
