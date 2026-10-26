package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("calc");

        try {
            System.out.println("Lanzando: " + pb.command());
            Process hijo = pb.start();

            System.out.println("PID del proceso lanzado: " + hijo.pid());

            System.out.println("PID del programa Java: " + ProcessHandle.current().pid());

            System.out.println("Esperando 10 seg");
            Thread.sleep(10000);

            System.out.println("Fin de la espera");




        } catch (IOException e) {
            System.out.println("No se pudo lanzar el comando: " + e.getMessage());
        }catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida");
        }
    }
}
