/*
 * UT2 · Relación de ejercicios · Ejercicio 3.3 – El vigilante
 *
 * Versión con el problema: el aviso se guarda en una variable sin volatile.
 */
package bloque3.vigilante;

public class VigilanteSinVolatile implements Runnable {

    public static boolean finTurno = false;

    public void hacerRondas() {
        long rondas = 0;
        while (!finTurno) {
            rondas++;
        }
        System.out.println("[Vigilante] Fin de turno. Rondas: " + rondas);
    }

    @Override
    public void run() {
        hacerRondas();
    }
}
