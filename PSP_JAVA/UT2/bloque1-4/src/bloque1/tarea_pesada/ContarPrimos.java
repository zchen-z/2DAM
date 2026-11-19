/*
 * UT2 · Relación de ejercicios · Ejercicio 1.2 – Tarea pesada sin bloquear
 *
 * El cálculo largo: cuántos números primos hay hasta un límite.
 */
package bloque1.tarea_pesada;

public class ContarPrimos implements Runnable {

    private final int limite;
    private int resultado;

    public ContarPrimos(int limite) {
        this.limite = limite;
    }

    /** Ya está hecho: no forma parte del ejercicio. */
    static boolean esPrimo(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int d = 3; (long) d * d <= n; d += 2) {
            if (n % d == 0) return false;
        }
        return true;
    }

    /** Cuenta los primos entre 2 y el límite. */
    public int contar() {
        int contador = 0;
        for (int n = 2; n <= limite; n++) {
            if (esPrimo(n)) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public void run() {
        resultado = contar();
    }

    /** Solo se debe leer cuando el hilo haya terminado. */
    public int getResultado() {
        return resultado;
    }
}
