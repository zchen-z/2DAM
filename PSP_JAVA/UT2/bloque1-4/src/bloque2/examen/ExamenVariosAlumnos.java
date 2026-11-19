/*
 * UT2 · Relación de ejercicios · Ejercicio 2.2 – El examen (ampliación)
 *
 * Cinco alumnos hacen el examen a la vez, con los mismos 5 segundos para todos.
 */
package bloque2.examen;

public class ExamenVariosAlumnos {

    public static void main(String[] args) throws InterruptedException {
        Alumno[] alumnos = new Alumno[5];
        Thread[] hilos = new Thread[5];
        for (int i = 0; i < 5; i++) {
            alumnos[i] = new Alumno("Alumno " + (i + 1));
            hilos[i] = new Thread(alumnos[i]);
            hilos[i].start();
        }

        // Una sola hora de fin para todos.
        long fin = System.currentTimeMillis() + 5000;

        for (int i = 0; i < 5; i++) {
            // A cada alumno solo se le espera el tiempo que QUEDA, no 5 s enteros.
            long queda = fin - System.currentTimeMillis();
            if (queda > 0) {
                hilos[i].join(queda);
            }
        }

        // Se acabó el tiempo: se retira el examen a quien no haya terminado.
        for (int i = 0; i < 5; i++) {
            if (hilos[i].isAlive()) {
                hilos[i].interrupt();
            }
            hilos[i].join();
        }

        System.out.println();
        for (int i = 0; i < 5; i++) {
            String resultado;
            if (alumnos[i].terminoATiempo()) {
                resultado = "terminó a tiempo";
            } else {
                resultado = "no terminó";
            }
            System.out.println(alumnos[i].getNombre() + ": " + alumnos[i].getContestadas()
                    + " de " + Alumno.PREGUNTAS + " (" + resultado + ")");
        }
    }
}
