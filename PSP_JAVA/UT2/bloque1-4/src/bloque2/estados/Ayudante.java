/*
 * UT2 · Relación de ejercicios · Ejercicio 2.1 – Estados de un hilo
 *
 * Hilo auxiliar: el hilo observado lo espera con join() para pasar a WAITING.
 */
package bloque2.estados;

public class Ayudante implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.out.println("Ayudante interrumpido");
        }
    }
}
