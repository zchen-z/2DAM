package UT1;

import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
          String[] comando = {"open", "-a", "kcalc"};
        
        ProcessBuilder pb = new ProcessBuilder(comando);
        
        try {
            Process proceso = pb.start();
            System.out.println("¡Proceso lanzado con éxito!");
                        
            long pidCalculadora = proceso.pid();
            System.out.println("-> PID del proceso lanzado (Calculadora): " + pidCalculadora);
            
            long pidJava = ProcessHandle.current().pid();
            System.out.println("-> PID de este programa Java: " + pidJava);
            
            System.out.println("El programa va a dormir. Abre la terminal y ejecuta los comandos indicados en la reflexión...");
            
            Thread.sleep(10000); 
            
            System.out.println("El programa ha terminado de ejecutarse correctamente.");
            
        } catch (IOException e) {
            System.err.println("ERROR I/O: No se pudo lanzar el comando.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("ERROR: El hilo fue interrumpido durante la pausa.");
            e.printStackTrace();
        }
    }
}
