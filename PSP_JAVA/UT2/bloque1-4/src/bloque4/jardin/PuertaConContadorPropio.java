/*
 * UT2 · Relación de ejercicios · Ejercicio 4.1 – Arregla el jardín
 *
 * Solución 3: cada puerta cuenta en su propia variable y el main suma al final.
 */
package bloque4.jardin;

public class PuertaConContadorPropio implements Runnable {

    private final int visitantes;
    // Solo la toca este hilo: no se comparte, así que no hay carrera.
    private int contados = 0;

    public PuertaConContadorPropio(int visitantes) {
        this.visitantes = visitantes;
    }

    public void abrir() {
        for (int i = 0; i < visitantes; i++) {
            contados++;
        }
    }

    @Override
    public void run() {
        abrir();
    }

    public int getContados() {
        return contados;
    }
}
