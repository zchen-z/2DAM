/*
 * UT2 · Relación de ejercicios · Ejercicio 4.2 – Taquillas sin overbooking
 *
 * Copia en este paquete tu solución del ejercicio 3.4 y corrígela.
 */
package bloque4.entradas;

public class CineCorregido {

    public static void main(String[] args) throws InterruptedException {
        probar("Sin proteger (3.4)       ", new SalaSinProteccion());
        probar("Solo el descuento (P1)   ", new SalaSoloDescuento());
        probar("synchronized vender()    ", new SalaSincronizada());
        probar("Reservar y cobrar fuera  ", new SalaReserva());
    }

    static void probar(String nombre, Sala sala) throws InterruptedException {
        long inicio = System.currentTimeMillis();

        Taquilla[] taquillas = new Taquilla[4];
        Thread[] hilos = new Thread[4];
        for (int i = 0; i < 4; i++) {
            taquillas[i] = new Taquilla(sala);
            hilos[i] = new Thread(taquillas[i]);
            hilos[i].start();
        }

        int total = 0;
        String porTaquilla = "";
        for (int i = 0; i < 4; i++) {
            hilos[i].join();
            total = total + taquillas[i].getVendidas();
            porTaquilla = porTaquilla + taquillas[i].getVendidas() + " ";
        }

        long tiempo = System.currentTimeMillis() - inicio;
        System.out.println(nombre + "| por taquilla: " + porTaquilla + "| total " + total
                + " | quedan " + sala.quedan() + " | " + tiempo + " ms");
    }
}
