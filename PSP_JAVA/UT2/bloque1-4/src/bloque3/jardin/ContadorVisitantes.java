/*
 * UT2 · Relación de ejercicios · Ejercicio 3.2 – El jardín ornamental
 *
 * El único contador de visitantes del jardín.
 */
package bloque3.jardin;

public class ContadorVisitantes {

    private int visitantes = 0;

    /** Se llama cada vez que entra un visitante por cualquier puerta. */
    public void entrar() {
        visitantes++;   // leer, sumar 1, escribir: NO es atómico
    }

    public int total() {
        return visitantes;
    }
}
