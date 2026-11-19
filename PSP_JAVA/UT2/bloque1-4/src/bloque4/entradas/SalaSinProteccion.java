/*
 * UT2 · Relación de ejercicios · Ejercicio 4.2 – Taquillas sin overbooking
 *
 * La sala del ejercicio 3.4, sin corregir (solo para comparar).
 */
package bloque4.entradas;

public class SalaSinProteccion implements Sala {

    private int entradas = 100;

    public boolean vender() throws InterruptedException {
        boolean vendida = false;
        if (entradas > 0) {
            Thread.sleep(1);   // cobrar
            entradas--;
            vendida = true;
        }
        return vendida;
    }

    public int quedan() {
        return entradas;
    }
}
