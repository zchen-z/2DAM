/*
 * UT2 · Relación de ejercicios · Ejercicio 4.1 – Arregla el jardín
 *
 * Solución 2: AtomicInteger.
 */
package bloque4.jardin;

import java.util.concurrent.atomic.AtomicInteger;

public class ContadorAtomico implements Contador {

    private final AtomicInteger visitantes = new AtomicInteger(0);

    // incrementAndGet() lee, suma y escribe en un solo paso indivisible.
    public void entrar() {
        visitantes.incrementAndGet();
    }

    public int total() {
        return visitantes.get();
    }
}
