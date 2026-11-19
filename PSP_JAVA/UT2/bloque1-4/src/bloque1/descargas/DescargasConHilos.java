/*
 * UT2 · Relación de ejercicios · Ejercicio 1.1 – Descargas
 *
 * Versión que descarga los ficheros a la vez.
 */
package bloque1.descargas;

public class DescargasConHilos {

    public static void main(String[] args) throws InterruptedException {
        Descarga[] descargas = {
            new Descarga("video.mp4", 40),
            new Descarga("fotos.zip", 15),
            new Descarga("apuntes.pdf", 25),
            new Descarga("musica.mp3", 10),
            new Descarga("juego.iso", 30)
        };

        // Cada descarga en su propio hilo: todas a la vez.
        Thread[] hilos = new Thread[descargas.length];
        for (int i = 0; i < descargas.length; i++) {
            hilos[i] = new Thread(descargas[i]);
            hilos[i].start();
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].join();
        }

        System.out.println("Todas descargadas en " + (System.currentTimeMillis() - Descarga.INICIO) / 1000.0 + " s");
    }
}
