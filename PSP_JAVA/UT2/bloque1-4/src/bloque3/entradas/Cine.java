/*
 * UT2 · Relación de ejercicios · Ejercicio 3.4 – Venta de entradas
 *
 * Cuatro taquillas venden a la vez.
 */
package bloque3.entradas;

public class Cine {

    public static void main(String[] args) throws InterruptedException {
        Sala sala = new Sala();
        Taquilla[] taquillas = new Taquilla[4];
        Thread[] hilos = new Thread[4];

        for (int i = 0; i < 4; i++) {
            taquillas[i] = new Taquilla("Taquilla " + (i + 1), sala);
            hilos[i] = new Thread(taquillas[i]);
            hilos[i].start();
        }
        for (int i = 0; i < 4; i++) {
            hilos[i].join();
        }

        int total = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println(taquillas[i].getNombre() + ": " + taquillas[i].getVendidas() + " entradas");
            total = total + taquillas[i].getVendidas();
        }
        System.out.println("Total vendido: " + total);
        System.out.println("Quedan: " + sala.quedan());
    }
}
