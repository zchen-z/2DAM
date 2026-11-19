/*
 * UT2 · Relación de ejercicios · Ejercicio 4.2 – Taquillas sin overbooking
 *
 * Solución: comprobar, cobrar y descontar sin que otra taquilla se cuele en medio.
 */
package bloque4.entradas;

public class SalaSincronizada implements Sala {

    private int entradas = 100;

    // Solo se protege la venta de UNA entrada, no el bucle de la taquilla:
    // entre cliente y cliente las demás taquillas pueden entrar.
    public synchronized boolean vender() throws InterruptedException {
        boolean vendida = false;
        if (entradas > 0) {
            Thread.sleep(1);   // cobrar
            entradas--;
            vendida = true;
        }
        return vendida;
    }

    public synchronized int quedan() {
        return entradas;
    }
}
