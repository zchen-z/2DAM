/*
 * UT2 · Relación de ejercicios · Ejercicio 1.2 – Tarea pesada sin bloquear
 *
 * Versión sin hilos.
 */
package bloque1.tarea_pesada;

public class SinHilos {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        System.out.println("Sigo atendiendo al usuario...");

        // El main se pone a calcular y hasta que acabe no puede hacer nada más:
        // no hay nadie que muestre el mensaje cada medio segundo.
        int total = new ContarPrimos(8_000_000).contar();

        System.out.println("Sigo atendiendo al usuario...");
        System.out.println("Hay " + total + " primos hasta 8.000.000");
        System.out.println("Tiempo: " + (System.currentTimeMillis() - inicio) / 1000.0 + " s");
    }
}
