/*
 * UT2 · Relación de ejercicios · Ejercicio 1.2 – Tarea pesada sin bloquear
 *
 * Versión con hilos.
 */
package bloque1.tarea_pesada;

public class ConHilos {

    public static void main(String[] args) throws InterruptedException {
        long inicio = System.currentTimeMillis();

        // El cálculo se va a otro hilo y el main queda libre.
        ContarPrimos calculo = new ContarPrimos(8_000_000);
        Thread hilo = new Thread(calculo);
        hilo.start();

        while (hilo.isAlive()) {
            System.out.println("Sigo atendiendo al usuario...");
            // Espera como mucho 500 ms; si el cálculo acaba antes, sigue enseguida.
            hilo.join(500);
        }

        System.out.println("Hay " + calculo.getResultado() + " primos hasta 8.000.000");
        System.out.println("Tiempo: " + (System.currentTimeMillis() - inicio) / 1000.0 + " s");
    }
}
