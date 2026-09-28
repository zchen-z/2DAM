package UT1;

import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {
        String[] comando = {"mkdir", "pruebas"};
        
        System.out.println("Comando a ejecutar: " + String.join(" ", comando));
        
        ProcessBuilder pb = new ProcessBuilder(comando);
        
        try {
            Process proceso = pb.start();
            
            System.out.println("Esperando a que el comando 'mkdir' finalice...");
            int codigoSalida = proceso.waitFor();
            
            System.out.println("Código de salida del proceso: " + codigoSalida);
            
            if (codigoSalida == 0) {
                System.out.println("Resultado: Carpeta creada");
            } else {
                System.out.println("Resultado: Error al crear la carpeta");
            }
            
        } catch (IOException e) {
            System.err.println("ERROR I/O: Ocurrió un fallo al intentar ejecutar el comando del sistema.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("ERROR: El programa fue interrumpido abruptamente mientras esperaba.");
            e.printStackTrace();
        }
    }
}

