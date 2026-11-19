/*
 * UT2 · Relación de ejercicios · Ejercicio 2.2 – El examen
 *
 * El profesor da 5 segundos para el examen.
 */
package bloque2.examen;

public class Examen {

    public static void main(String[] args) throws InterruptedException {
        Alumno alumno = new Alumno("Alumno");
        Thread hilo = new Thread(alumno);
        hilo.start();

        hilo.join(5000);   // el profesor espera como máximo 5 s

        if (hilo.isAlive()) {
            hilo.interrupt();   // le retira el examen
            hilo.join();        // esperamos a que deje de escribir de verdad
        }

        System.out.println("Preguntas contestadas: " + alumno.getContestadas() + " de " + Alumno.PREGUNTAS);
        if (alumno.terminoATiempo()) {
            System.out.println("Terminó a tiempo");
        } else {
            System.out.println("No terminó a tiempo");
        }
    }
}
