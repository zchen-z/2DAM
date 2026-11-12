package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;

public class Ejercicio7 {

    static String[] segundos = { "3", "5", "1" };

    public static void main(String[] args) {
        try {
            versionSecuencial();
            versionPararela();
        } catch (IOException e) {
            System.out.println("No se pudo lanzar el proceso: " + e.getMessage());
        } catch (InterruptedException e){
            System.out.println("La espera fue interrumpida");
        }
    }

    public static void versionSecuencial() throws IOException, InterruptedException {
        System.out.println("Version A secuencial");
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < segundos.length; i++) {
            Process p = new ProcessBuilder("sleep", segundos[i]).start();
            System.out.println("Lanzado sleep" + segundos[i] + "(PID " + p.pid() + ")");
            p.waitFor();
            System.out.println("Terminado sleep " + segundos[i]);
        }
         long fin = System.currentTimeMillis();
         System.out.println("Tiempo total: " + (fin - inicio) / 1000.0 + " s");
    }

    public static void versionPararela() throws IOException, InterruptedException{
        System.out.println("Version B paralera");
        long inicio = System.currentTimeMillis();

        Process [] procesos = new Process[segundos.length];
        for (int i = 0; i < segundos.length; i++) {
            procesos[i] = new ProcessBuilder("sleep", segundos[i]).start();
            System.out.println("Lanzado sleep " + segundos[i] + " (PID " + procesos[i].pid() + ")");
        }

        for (int i = 0; i < procesos.length; i++) {
            procesos[i].waitFor();
            System.out.println("Terminadno sleep " + segundos[i]);
        }

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (fin -inicio) / 1000 + " s");

    }
}
