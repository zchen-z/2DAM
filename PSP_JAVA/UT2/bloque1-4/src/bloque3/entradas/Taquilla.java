/*
 * UT2 · Relación de ejercicios · Ejercicio 3.4 – Venta de entradas
 *
 * Una taquilla: le llegan 40 clientes que quieren una entrada.
 */
package bloque3.entradas;

public class Taquilla implements Runnable {

    private final String nombre;
    private final Sala sala;
    private int vendidas = 0;

    public Taquilla(String nombre, Sala sala) {
        this.nombre = nombre;
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
            System.out.println(nombre + " interrumpida");
        }
    }

    @Override
    public void run() {
        atenderClientes();
    }

    public String getNombre() {
        return nombre;
    }

    public int getVendidas() {
        return vendidas;
    }
}
