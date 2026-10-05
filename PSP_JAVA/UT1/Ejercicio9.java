package UT1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejercicio9 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("sleep", "10");

        try {
            System.out.println("[PADRE] Lanzando el proceso hijo (sleep 10)...");
            Process procesoHijo = pb.start();

            System.out.println("[PADRE] Esperando un máximo de 3 segundos al hijo...");
            boolean terminadoATiempo = procesoHijo.waitFor(3, TimeUnit.SECONDS);

            if (!terminadoATiempo) {
                System.out.println("[PADRE] ¡Tiempo de espera agotado! El hijo ha tardado demasiado.");

                System.out.println("¿El proceso está vivo antes de destruirlo? -> " + procesoHijo.isAlive());

                System.out.println("[PADRE] Destruyendo el proceso hijo...");
                procesoHijo.destroy();

                Thread.sleep(50); 

                System.out.println("¿El proceso está vivo después de destruirlo? -> " + procesoHijo.isAlive());
            } else {
                System.out.println("[PADRE] El hijo terminó por sí mismo dentro del tiempo.");
            }


            int codigoSalida = procesoHijo.exitValue();
            System.out.println("Código de salida final del proceso hijo: " + codigoSalida);

        } catch (IOException e) {
            System.err.println("Error de E/S al lanzar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El hilo principal fue interrumpido de forma inesperada.");
        }
    }
}
