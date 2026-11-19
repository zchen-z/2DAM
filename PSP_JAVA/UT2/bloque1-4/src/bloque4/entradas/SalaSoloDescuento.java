/*
 * UT2 · Relación de ejercicios · Ejercicio 4.2 – Taquillas sin overbooking
 *
 * Pregunta 1: la propuesta del compañero (proteger solo el descuento).
 */
package bloque4.entradas;

public class SalaSoloDescuento implements Sala {

    private int entradas = 100;

    public boolean vender() throws InterruptedException {
        boolean vendida = false;
        if (entradas > 0) {          // la comprobación sigue fuera
            Thread.sleep(1);         // cobrar
            synchronized (this) {
                entradas--;          // solo esto está protegido
            }
            vendida = true;
        }
        return vendida;
    }

    public int quedan() {
        return entradas;
    }
}
