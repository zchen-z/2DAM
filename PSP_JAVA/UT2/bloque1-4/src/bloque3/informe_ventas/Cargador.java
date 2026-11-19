/*
 * UT2 · Relación de ejercicios · Ejercicio 3.1 – El informe de ventas
 *
 * Carga las ventas del día (importes de 1 a 100 €).
 */
package bloque3.informe_ventas;

import java.util.Random;

public class Cargador implements Runnable {

    private final Ventas ventas;

    public Cargador(Ventas ventas) {
        this.ventas = ventas;
    }

    public void cargar() {
        Random r = new Random();
        for (int i = 0; i < Ventas.NUM_VENTAS; i++) {
            ventas.importes[i] = 1 + r.nextInt(100);
        }
        System.out.println("[Cargador] Ventas cargadas");
    }

    @Override
    public void run() {
        cargar();
    }
}
