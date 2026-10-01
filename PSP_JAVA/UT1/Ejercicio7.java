package UT1;

import java.io.IOException;

public class Ejercicio7 {
     public static void main(String[] args) {
        System.out.println("=== INICIANDO EXPERIMENTO DE PROCESOS ===");
        
        ejecutarVersionA(); // Ejecución Secuencial
        System.out.println();
        ejecutarVersionB(); // Ejecución Paralela
    }

    public static void ejecutarVersionA() {
        System.out.println("--- [VERSIÓN A] Iniciando ejecución secuencial ---");
        long tiempoInicio = System.currentTimeMillis();

        try {
            System.out.println("[Padre] Lanzando sleep 3...");
            Process p1 = new ProcessBuilder("sleep", "3").start();
            p1.waitFor();

            Process p2 = new ProcessBuilder("sleep", "5").start();
            p2.waitFor();

            System.out.println("[Padre] Lanzando sleep 1...");
            Process p3 = new ProcessBuilder("sleep", "1").start();
            p3.waitFor();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error en la Versión A: " + e.getMessage());
        }

        long tiempoFin = System.currentTimeMillis();
        double tiempoTotal = (tiempoFin - tiempoInicio) / 1000.0;
        System.out.println("VERSIÓN A. Tiempo total secuencial: " + tiempoTotal + " segundos.");
    }

    public static void ejecutarVersionB() {
        System.out.println("--- [VERSIÓN B] Iniciando ejecución paralela ---");
        long tiempoInicio = System.currentTimeMillis();

        try {
        
            System.out.println("[Padre] Lanzando sleep 3, sleep 5 y sleep 1 en paralelo...");
            Process p1 = new ProcessBuilder("sleep", "3").start();
            Process p2 = new ProcessBuilder("sleep", "5").start();
            Process p3 = new ProcessBuilder("sleep", "1").start();

            System.out.println("[Padre] Esperando a que finalicen todos los procesos hijos...");
            p1.waitFor();
            p2.waitFor();
            p3.waitFor();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error en la Versión B: " + e.getMessage());
        }

        long tiempoFin = System.currentTimeMillis();
        double tiempoTotal = (tiempoFin - tiempoInicio) / 1000.0;
        System.out.println("VERSIÓN B. Tiempo total paralelo: " + tiempoTotal + " segundos.");
    }
}
