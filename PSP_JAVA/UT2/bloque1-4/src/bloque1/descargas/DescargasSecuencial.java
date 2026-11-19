/*
 * UT2 · Relación de ejercicios · Ejercicio 1.1 – Descargas
 *
 * Versión que descarga los ficheros uno detrás de otro.
 */
package bloque1.descargas;

public class DescargasSecuencial {

    public static void main(String[] args) {
        Descarga[] descargas = {
            new Descarga("video.mp4", 40),
            new Descarga("fotos.zip", 15),
            new Descarga("apuntes.pdf", 25),
            new Descarga("musica.mp3", 10),
            new Descarga("juego.iso", 30)
        };

        // Todo lo hace el main: una descarga no empieza hasta que termina la anterior.
        for (int i = 0; i < descargas.length; i++) {
            descargas[i].descargar();
        }

        System.out.println("Todas descargadas en " + (System.currentTimeMillis() - Descarga.INICIO) / 1000.0 + " s");
    }
}
