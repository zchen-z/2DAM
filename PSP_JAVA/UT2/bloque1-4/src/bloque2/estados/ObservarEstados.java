/*
 * UT2 · Relación de ejercicios · Ejercicio 2.1 – Estados de un hilo
 *
 * Programa principal: observa un hilo mientras se ejecuta y muestra sus estados.
 * Crea en este paquete las clases que necesites.
 */
package bloque2.estados;

import java.util.ArrayList;

public class ObservarEstados {

    public static void main(String[] args) {
        Thread hilo = new Thread(new Trabajador());
        ArrayList<Thread.State> secuencia = new ArrayList<>();

        secuencia.add(hilo.getState());   // NEW
        hilo.start();

        // El main pregunta el estado sin parar y solo lo apunta si ha cambiado.
        Thread.State anterior = Thread.State.NEW;
        while (anterior != Thread.State.TERMINATED) {
            Thread.State actual = hilo.getState();
            if (actual != anterior) {
                secuencia.add(actual);
                anterior = actual;
            }
        }

        System.out.println("Secuencia de estados:");
        for (int i = 0; i < secuencia.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + secuencia.get(i));
        }
    }
}
