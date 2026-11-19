/*
 * UT2 · Relación de ejercicios · Ejercicio 1.1 – Descargas
 *
 * Una descarga de un fichero a 10 MB/s.
 */
package bloque1.descargas;

public class Descarga implements Runnable {

    static final int MB_POR_SEGUNDO = 10;
    // Se guarda la primera vez que se usa la clase, es decir, al arrancar el programa.
    static final long INICIO = System.currentTimeMillis();

    private final String fichero;
    private final int megas;

    public Descarga(String fichero, int megas) {
        this.fichero = fichero;
        this.megas = megas;
    }

    /** Simula la descarga e indica, al terminar, cuánto tiempo ha pasado desde que arrancó el programa. */
    public void descargar() {
        try {
            Thread.sleep(megas * 1000L / MB_POR_SEGUNDO);   // 100 ms por MB
            double segundos = (System.currentTimeMillis() - INICIO) / 1000.0;
            System.out.println(fichero + " (" + megas + " MB) descargado a los " + segundos + " s");
        } catch (InterruptedException e) {
            System.out.println(fichero + ": descarga interrumpida");
        }
    }

    @Override
    public void run() {
        descargar();
    }
}
