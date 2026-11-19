/*
 * UT2 · Relación de ejercicios · Ejercicio 2.2 – El examen
 *
 * Un alumno que contesta un examen de 20 preguntas (200–600 ms cada una).
 */
package bloque2.examen;

import java.util.Random;

public class Alumno implements Runnable {

    static final int PREGUNTAS = 20;

    private final String nombre;
    // volatile: el profesor (otro hilo) lee estos valores.
    private volatile int contestadas = 0;
    private volatile boolean aTiempo = false;

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    /** Contesta las preguntas una a una; si le retiran el examen, deja de escribir en ese momento. */
    public void hacerExamen() {
        Random r = new Random();
        try {
            while (contestadas < PREGUNTAS) {
                Thread.sleep(200 + r.nextInt(401));   // entre 200 y 600 ms
                contestadas++;
            }
            aTiempo = true;
        } catch (InterruptedException e) {
            // El profesor ha llamado a interrupt(): deja de escribir YA.
            System.out.println(nombre + ": me han retirado el examen");
        }
    }

    @Override
    public void run() {
        hacerExamen();
    }

    public String getNombre() { return nombre; }
    public int getContestadas() { return contestadas; }
    public boolean terminoATiempo() { return aTiempo; }
}
