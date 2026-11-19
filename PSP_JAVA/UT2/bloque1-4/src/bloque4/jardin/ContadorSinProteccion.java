/*
 * UT2 · Relación de ejercicios · Ejercicio 4.1 – Arregla el jardín
 *
 * El contador del ejercicio 3.2, sin corregir (solo para comparar).
 */
package bloque4.jardin;

public class ContadorSinProteccion implements Contador {

    private int visitantes = 0;

    public void entrar() {
        visitantes++;
    }

    public int total() {
        return visitantes;
    }
}
