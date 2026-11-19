/*
 * UT2 · Relación de ejercicios · Ejercicio 3.1 – El informe de ventas
 *
 * El cargador y el calculador se lanzan a la vez.
 */
package bloque3.informe_ventas;

public class Informe {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Tal como se describe: los dos a la vez ---");
        Ventas ventas = new Ventas();
        Thread cargador = new Thread(new Cargador(ventas));
        Thread calculador = new Thread(new Calculador(ventas));
        cargador.start();
        calculador.start();
        cargador.join();
        calculador.join();

        System.out.println("\n--- Corregido: el calculador espera al cargador con join() ---");
        Ventas ventas2 = new Ventas();
        Thread cargador2 = new Thread(new Cargador(ventas2));
        Thread calculador2 = new Thread(new Calculador(ventas2, cargador2));
        cargador2.start();
        calculador2.start();
        cargador2.join();
        calculador2.join();
    }
}
