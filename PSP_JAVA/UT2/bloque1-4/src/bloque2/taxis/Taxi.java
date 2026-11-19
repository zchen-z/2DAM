/*
 * UT2 · Relación de ejercicios · Ejercicio 2.4 – Taxis
 *
 * Un taxi de la flota: hace 5 carreras de 2 a 15 km (100 ms por km).
 */
package bloque2.taxis;

import java.util.Random;

// Taxi ya hereda de Vehiculo y Java solo permite una clase padre:
// no puede extender Thread, así que implementa Runnable.
public class Taxi extends Vehiculo implements Runnable {

    public Taxi(String matricula) {
        super(matricula);
    }

    /** Hace las 5 carreras del día. */
    public void trabajar() {
        Random r = new Random();
        try {
            for (int i = 1; i <= 5; i++) {
                int km = 2 + r.nextInt(14);   // entre 2 y 15 km
                Thread.sleep(km * 100L);      // 100 ms por km
                recorrer(km);
                System.out.println(matricula + " termina la carrera " + i + " (" + km + " km)");
            }
        } catch (InterruptedException e) {
            System.out.println(matricula + " interrumpido");
        }
    }

    @Override
    public void run() {
        trabajar();
    }
}
