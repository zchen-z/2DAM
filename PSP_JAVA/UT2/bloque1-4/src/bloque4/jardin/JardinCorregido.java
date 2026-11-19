/*
 * UT2 · Relación de ejercicios · Ejercicio 4.1 – Arregla el jardín
 *
 * Copia en este paquete tu solución del ejercicio 3.2 y corrígela de tres formas distintas.
 */
package bloque4.jardin;

public class JardinCorregido {

    static final int PUERTAS = 4;
    static final int POR_PUERTA = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Esperados: " + (PUERTAS * POR_PUERTA) + "\n");

        probar("Sin protección (3.2)  ", new ContadorSinProteccion());
        probar("1. synchronized       ", new ContadorSincronizado());
        probar("2. AtomicInteger      ", new ContadorAtomico());
        probarContadorPropio("3. Contador por puerta");
    }

    static void probar(String nombre, Contador contador) throws InterruptedException {
        long inicio = System.currentTimeMillis();

        Thread[] puertas = new Thread[PUERTAS];
        for (int i = 0; i < PUERTAS; i++) {
            puertas[i] = new Thread(new Puerta(contador, POR_PUERTA));
            puertas[i].start();
        }
        for (int i = 0; i < PUERTAS; i++) {
            puertas[i].join();
        }

        long tiempo = System.currentTimeMillis() - inicio;
        System.out.println(nombre + " -> " + contador.total() + " visitantes en " + tiempo + " ms");
    }

    static void probarContadorPropio(String nombre) throws InterruptedException {
        long inicio = System.currentTimeMillis();

        PuertaConContadorPropio[] puertas = new PuertaConContadorPropio[PUERTAS];
        Thread[] hilos = new Thread[PUERTAS];
        for (int i = 0; i < PUERTAS; i++) {
            puertas[i] = new PuertaConContadorPropio(POR_PUERTA);
            hilos[i] = new Thread(puertas[i]);
            hilos[i].start();
        }

        // Después de los join ya no escribe nadie: sumar no necesita protección.
        int total = 0;
        for (int i = 0; i < PUERTAS; i++) {
            hilos[i].join();
            total = total + puertas[i].getContados();
        }

        long tiempo = System.currentTimeMillis() - inicio;
        System.out.println(nombre + " -> " + total + " visitantes en " + tiempo + " ms");
    }
}
