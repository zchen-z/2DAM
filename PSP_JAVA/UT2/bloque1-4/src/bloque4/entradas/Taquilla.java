/*
 * UT2 · Relación de ejercicios · Ejercicio 4.2 – Taquillas sin overbooking
 *
 * Una taquilla: le llegan 40 clientes que quieren una entrada.
 */
package bloque4.entradas;

public class Taquilla implements Runnable {

    private final Sala sala;
    private int vendidas = 0;

    public Taquilla(Sala sala) {
        this.sala = sala;
    }

    public void atenderClientes() {
        try {
            for (int cliente = 0; cliente < 40; cliente++) {
                if (sala.vender()) {
                    vendidas++;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Taquilla interrumpida");
        }
    }

    @Override
    public void run() {
        atenderClientes();
    }

    public int getVendidas() {
        return vendidas;
    }
}
