/*
 * UT2 · Relación de ejercicios · Ejercicio 4.3 – La máquina de turnos
 *
 * Cuatro clientes usan la máquina a la vez.
 */
package bloque4.turnos;

public class Carniceria {

    static final int CLIENTES = 4;

    public static void main(String[] args) throws InterruptedException {
        probar("Sin protección   ", new MaquinaSinProteccion());
        probar("synchronized     ", new MaquinaTurnos());
        probar("compareAndSet    ", new MaquinaTurnosCAS());
    }

    static void probar(String nombre, Maquina maquina) throws InterruptedException {
        Cliente[] clientes = new Cliente[CLIENTES];
        Thread[] hilos = new Thread[CLIENTES];
        for (int i = 0; i < CLIENTES; i++) {
            clientes[i] = new Cliente(maquina);
            hilos[i] = new Thread(clientes[i]);
            hilos[i].start();
        }
        for (int i = 0; i < CLIENTES; i++) {
            hilos[i].join();
        }

        // Marcamos cada número que ha salido. Si ya estaba marcado, es un repetido.
        int total = CLIENTES * Cliente.NUMEROS;
        boolean[] visto = new boolean[total + 1];
        int repetidos = 0;
        int mayor = 0;
        for (int c = 0; c < CLIENTES; c++) {
            int[] numeros = clientes[c].getNumeros();
            for (int i = 0; i < numeros.length; i++) {
                int n = numeros[i];
                if (visto[n]) {
                    repetidos++;
                } else {
                    visto[n] = true;
                }
                if (n > mayor) {
                    mayor = n;
                }
            }
        }

        System.out.println(nombre + "| números sacados: " + total + " | repetidos: " + repetidos
                + " | último número: " + mayor);
    }
}
