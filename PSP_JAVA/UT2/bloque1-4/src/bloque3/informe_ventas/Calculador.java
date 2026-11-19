/*
 * UT2 · Relación de ejercicios · Ejercicio 3.1 – El informe de ventas
 *
 * Calcula el total facturado y el importe medio de las ventas.
 */
package bloque3.informe_ventas;

public class Calculador implements Runnable {

    private final Ventas ventas;
    // Solo en la versión corregida: el hilo al que hay que esperar antes de calcular.
    private Thread cargador = null;

    public Calculador(Ventas ventas) {
        this.ventas = ventas;
    }

    public Calculador(Ventas ventas, Thread cargador) {
        this.ventas = ventas;
        this.cargador = cargador;
    }

    public void calcular() {
        try {
            // Corrección: no leer hasta que el cargador haya terminado de escribir.
            if (cargador != null) {
                cargador.join();
            }

            long total = 0;
            for (int i = 0; i < Ventas.NUM_VENTAS; i++) {
                total = total + ventas.importes[i];
            }
            double media = (double) total / Ventas.NUM_VENTAS;
            System.out.println("[Calculador] Total facturado: " + total + " €");
            System.out.printf("[Calculador] Importe medio: %.2f €%n", media);
        } catch (InterruptedException e) {
            System.out.println("Calculador interrumpido");
        }
    }

    @Override
    public void run() {
        calcular();
    }
}
