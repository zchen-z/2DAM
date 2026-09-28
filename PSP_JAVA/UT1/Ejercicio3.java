package UT1;

import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("=== ERROR: No se ha especificado ningún comando ===");
        }else{
        System.out.println("=== PASO 1: Procesando argumentos ===");
        String comandoCompleto = String.join(" ", args);
        System.out.println("Comando detectado para lanzar: " + comandoCompleto);

        System.out.println("\n=== PASO 2: Lanzando el proceso ===");
        ProcessBuilder pb = new ProcessBuilder(args);

        try {
            System.out.println("Iniciando ejecución...");
            Process proceso = pb.start();
            System.out.println("¡Proceso lanzado con éxito con el PID: " + proceso.pid() + "!");
            
            System.out.println("Esperando a que el comando termine su ejecución...");
            int codigoSalida = proceso.waitFor();
            System.out.println("El proceso ha finalizado. Código de salida: " + codigoSalida);

        } catch (IOException e) {
            System.err.println("ERROR I/O: No se pudo ejecutar el comando. Verifica que el comando esté bien escrito y exista en el PATH de Linux.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("ERROR: El hilo principal fue interrumpido durante la espera.");
            e.printStackTrace();
        }
        }

        
    }
}

