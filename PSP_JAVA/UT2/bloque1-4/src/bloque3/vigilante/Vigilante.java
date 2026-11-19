/*
 * UT2 · Relación de ejercicios · Ejercicio 3.3 – El vigilante
 *
 * Hace rondas sin parar hasta que le avisan de que su turno ha terminado.
 * Versión corregida con volatile.
 */
package bloque3.vigilante;

public class Vigilante implements Runnable {

    // volatile: cada lectura ve el último valor escrito por cualquier hilo.
    public static volatile boolean finTurno = false;
    // Pregunta 3: total común de rondas de todos los vigilantes.
    public static volatile long totalRondas = 0;

    private final String nombre;
    private long rondas = 0;

    public Vigilante(String nombre) {
        this.nombre = nombre;
    }

    public void hacerRondas() {
        while (!finTurno) {
            rondas++;
            totalRondas++;   // volatile NO hace atómico el ++
        }
        System.out.println("[" + nombre + "] Fin de turno. Rondas: " + rondas);
    }

    @Override
    public void run() {
        hacerRondas();
    }

    public long getRondas() {
        return rondas;
    }
}
