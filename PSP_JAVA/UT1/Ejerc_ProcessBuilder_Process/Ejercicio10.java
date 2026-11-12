package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejercicio10 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("sh", "-c", "trap '' TERM; sleep 30");
        
         try {
            Process p = pb.start();
            System.out.println("Proceso rebelde lanzado con PID " + p.pid());

            // Le damos medio segundo para que la shell llegue a ejecutar el trap.
            Thread.sleep(500);

            // 1. Se lo pedimos amablemente (SIGTERM).
            System.out.println("Intentando terminarlo con destroy()...");
            p.destroy();

            boolean terminado = p.waitFor(2, TimeUnit.SECONDS);
            System.out.println("¿Ha terminado tras destroy()? " + terminado);

            // 2. Si no ha hecho caso, lo obligamos (SIGKILL).
            if (!terminado) {
                System.out.println("No hace caso. Lo terminamos con destroyForcibly()...");
                p.destroyForcibly();
                p.waitFor();
            }

            System.out.println("Código de salida: " + p.exitValue());

        } catch (IOException e) {
            System.out.println("No se pudo lanzar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida");
        }

    }
    

    
}
