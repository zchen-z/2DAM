/*
 * UT2 · Relación de ejercicios · Ejercicio 4.1 – Arregla el jardín
 *
 * Una puerta que avisa al contador común por cada visitante (soluciones 1 y 2).
 */
package bloque4.jardin;

public class Puerta implements Runnable {

    private final Contador contador;
    private final int visitantes;

    public Puerta(Contador contador, int visitantes) {
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
