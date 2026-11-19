/*
 * UT2 · Relación de ejercicios · Ejercicio 3.4 – Venta de entradas
 *
 * La sesión de cine: 100 entradas.
 */
package bloque3.entradas;

public class Sala {

    private int entradas = 100;

    /** Vende una entrada si queda alguna. Cobrar al cliente lleva un instante. */
    public boolean vender() throws InterruptedException {
        boolean vendida = false;
        // ---- Fragmento problemático ----
        if (entradas > 0) {     // 1. comprobar
            Thread.sleep(1);    // 2. cobrar
            entradas--;         // 3. descontar
            vendida = true;
        }
        // --------------------------------
        return vendida;
    }

    public int quedan() {
        return entradas;
    }
}
