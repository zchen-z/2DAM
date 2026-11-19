package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class Ejercicio11 {
    public static void main(String[] args) {
        // Padre (sh) -> hijo 1 (sh -> nieto sleep 60) y hijo 2 (sleep 60)
        ProcessBuilder pb = new ProcessBuilder("sh", "-c", "sh -c 'sleep 60 & wait' & sleep 60 & wait");

        try {
            Process padre = pb.start();
            System.out.println("Proceso padre lanzado con PID " + padre.pid());

            Thread.sleep(500);

            System.out.println("children(): " + padre.children().count());
            System.out.println("descendants(): " + padre.descendants().count());

            System.out.println("\nDescendientes:");
            Iterator<ProcessHandle> it = padre.descendants().iterator();
            while (it.hasNext()) {
                ProcessHandle h = it.next();
                long pidPadre = -1;
                if (h.parent().isPresent()) {
                    pidPadre = h.parent().get().pid();
                }
                String comando = h.info().commandLine().orElse("-");
                System.out.println("PID " + h.pid() + " | padre " + pidPadre + " | " + comando);
            }

            ArrayList<ProcessHandle> lista = new ArrayList<>();
            it = padre.descendants().iterator();
            while (it.hasNext()) {
                ProcessHandle h = it.next();
                lista.add(h);
                h.destroy();
            }
            padre.destroy();
            padre.waitFor();

            // Medio segundo para que el sistema elimine a los descendientes.
            Thread.sleep(500);

            System.out.println("\n¿Padre " + padre.pid() + " vivo? " + padre.isAlive());
            for (int i = 0; i < lista.size(); i++) {
                ProcessHandle h = lista.get(i);
                System.out.println("¿PID " + h.pid() + " vivo? " + h.isAlive());
            }

        } catch (IOException e) {
            System.out.println("No se pudo lanzar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida");
        }
    }
}
