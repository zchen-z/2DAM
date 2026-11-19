/*
 * UT2 · Relación de ejercicios · Ejercicio 4.2 – Taquillas sin overbooking
 *
 * Ampliación: dentro de la parte protegida solo se reserva la entrada; se cobra fuera.
 */
package bloque4.entradas;

public class SalaReserva implements Sala {

    private int entradas = 100;

    public boolean vender() throws InterruptedException {
        boolean reservada = false;

        // Comprobar y descontar juntos: es lo único que no puede partirse.
        synchronized (this) {
            if (entradas > 0) {
                entradas--;
                reservada = true;
            }
        }

        // La entrada ya es de este cliente: se cobra sin bloquear a las demás taquillas.
        if (reservada) {
            Thread.sleep(1);
        }
        return reservada;
    }

    public synchronized int quedan() {
        return entradas;
    }
}
