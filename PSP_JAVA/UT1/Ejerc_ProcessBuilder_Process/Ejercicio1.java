package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;

public class Ejercicio1 {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("calc");

        try {
            System.out.println("Lanzando: " + pb.command());
            Process p = pb.start();

            System.out.println("Prceso lanzado con PID: " + p.pid());


        } catch (IOException e) {
            System.out.println("No se pudo lanzar el comando: " + e.getMessage());
        }
        
    }
}

    

