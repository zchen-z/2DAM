/*
 * UT2 · Relación de ejercicios · Ejercicio 4.3 – La máquina de turnos
 *
 * Ampliación: sin synchronized y sin incrementAndGet()/getAndIncrement().
 */
package bloque4.turnos;

import java.util.concurrent.atomic.AtomicInteger;

public class MaquinaTurnosCAS implements Maquina {

    private final AtomicInteger ultimo = new AtomicInteger(0);

    public int nuevoTurno() {
        boolean conseguido = false;
        int nuevo = 0;
        while (!conseguido) {
            int actual = ultimo.get();
            nuevo = actual + 1;
            // compareAndSet solo guarda "nuevo" si nadie ha cambiado el valor desde que lo leímos.
            // Si otro cliente se ha adelantado, devuelve false y se vuelve a intentar.
            conseguido = ultimo.compareAndSet(actual, nuevo);
        }
        return nuevo;
    }
}
