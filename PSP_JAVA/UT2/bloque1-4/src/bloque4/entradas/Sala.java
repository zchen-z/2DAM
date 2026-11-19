/*
 * UT2 · Relación de ejercicios · Ejercicio 4.2 – Taquillas sin overbooking
 *
 * Lo que tienen en común todas las versiones de la sala.
 */
package bloque4.entradas;

public interface Sala {
    boolean vender() throws InterruptedException;
    int quedan();
}
