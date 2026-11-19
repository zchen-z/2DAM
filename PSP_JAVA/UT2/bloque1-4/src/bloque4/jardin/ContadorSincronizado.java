/*
 * UT2 · Relación de ejercicios · Ejercicio 4.1 – Arregla el jardín
 *
 * Solución 1: método synchronized.
 */
package bloque4.jardin;

public class ContadorSincronizado implements Contador {

    private int visitantes = 0;

    // Solo un hilo a la vez puede estar dentro: el ++ ya no se puede partir.
    public synchronized void entrar() {
        visitantes++;
    }

    public int total() {
        return visitantes;
    }
}
