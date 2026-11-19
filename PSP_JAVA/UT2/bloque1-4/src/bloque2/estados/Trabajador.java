/*
 * UT2 · Relación de ejercicios · Ejercicio 2.1 – Estados de un hilo
 *
 * El hilo observado.
 */
package bloque2.estados;

public class Trabajador implements Runnable {

    @Override
    public void run() {
        try {
            calcular();                 // RUNNABLE

            Thread.sleep(300);          // TIMED_WAITING: espera con tiempo límite

            Thread ayudante = new Thread(new Ayudante());
            ayudante.start();
            ayudante.join();            // WAITING: espera sin límite a que termine otro hilo

            calcular();                 // RUNNABLE otra vez
        } catch (InterruptedException e) {
            System.out.println("Trabajador interrumpido");
        }
    }

    // Trabajo de CPU para que el hilo esté un rato en RUNNABLE.
    private void calcular() {
        double x = 0;
        for (int i = 0; i < 30_000_000; i++) {
            x = x + Math.sqrt(i);
        }
    }
}
