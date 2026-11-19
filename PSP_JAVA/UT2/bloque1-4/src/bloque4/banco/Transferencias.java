/*
 * UT2 · Relación de ejercicios · Ejercicio 4.4 – El banco
 *
 * Cuatro cajeros trabajan a la vez.
 */
package bloque4.banco;

public class Transferencias {

    public static void main(String[] args) throws InterruptedException {
        probar("Sin protección      ", Cajero.SIN_PROTECCION);
        probar("synchronized (banco)", Cajero.SINCRONIZADO);
        probar("Cerrojo por cuenta  ", Cajero.POR_CUENTAS);
    }

    static void probar(String nombre, int modo) throws InterruptedException {
        Banco banco = new Banco(10, 1000);
        int antes = banco.total();
        long inicio = System.currentTimeMillis();

        Thread[] cajeros = new Thread[4];
        for (int i = 0; i < 4; i++) {
            cajeros[i] = new Thread(new Cajero(banco, modo));
            cajeros[i].start();
        }
        for (int i = 0; i < 4; i++) {
            cajeros[i].join();
        }

        long tiempo = System.currentTimeMillis() - inicio;
        int despues = banco.total();
        String resultado;
        if (antes == despues) {
            resultado = "CORRECTO";
        } else {
            resultado = "INCORRECTO (" + (despues - antes) + " €)";
        }
        System.out.println(nombre + " | antes " + antes + " € | después " + despues + " € | "
                + resultado + " | " + tiempo + " ms");
    }
}
