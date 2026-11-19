/*
 * UT2 · Relación de ejercicios · Ejercicio 2.4 – Taxis
 *
 * Los 3 taxis trabajan a la vez.
 */
package bloque2.taxis;

public class Flota {

    public static void main(String[] args) throws InterruptedException {
        Taxi[] taxis = {new Taxi("1234-ABC"), new Taxi("5678-DEF"), new Taxi("9012-GHI")};
        Thread[] hilos = new Thread[taxis.length];

        for (int i = 0; i < taxis.length; i++) {
            hilos[i] = new Thread(taxis[i]);
            hilos[i].start();
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].join();
        }

        // Cada taxi ha sumado en sus propios km; el total se calcula al final.
        int total = 0;
        System.out.println();
        for (int i = 0; i < taxis.length; i++) {
            System.out.println(taxis[i].getMatricula() + ": " + taxis[i].getKmRecorridos() + " km");
            total = total + taxis[i].getKmRecorridos();
        }
        System.out.println("Total de la flota: " + total + " km");
    }
}
