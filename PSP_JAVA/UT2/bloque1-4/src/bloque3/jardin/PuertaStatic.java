/*
 * UT2 · Relación de ejercicios · Ejercicio 3.2 – El jardín ornamental
 *
 * Pregunta 3: otra forma de compartir el contador, con un atributo static.
 */
package bloque3.jardin;

public class PuertaStatic implements Runnable {

    // static: una sola variable para todas las puertas.
    public static int visitantes = 0;
    private final int entradas;

    public PuertaStatic(int entradas) {
        this.entradas = entradas;
    }

    public void abrir() {
        for (int i = 0; i < entradas; i++) {
            visitantes++;
        }
    }

    @Override
    public void run() {
        abrir();
    }
}
