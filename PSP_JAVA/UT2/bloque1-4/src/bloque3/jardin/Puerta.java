/*
 * UT2 · Relación de ejercicios · Ejercicio 3.2 – El jardín ornamental
 *
 * Una puerta de entrada al jardín.
 */
package bloque3.jardin;

public class Puerta implements Runnable {

    // Forma 1 de compartir: todas las puertas reciben el mismo objeto contador.
    private final ContadorVisitantes contador;
    private final int visitantes;

    public Puerta(ContadorVisitantes contador, int visitantes) {
        this.contador = contador;
        this.visitantes = visitantes;
    }

    public void abrir() {
        for (int i = 0; i < visitantes; i++) {
            contador.entrar();
        }
    }

    @Override
    public void run() {
        abrir();
    }
}
