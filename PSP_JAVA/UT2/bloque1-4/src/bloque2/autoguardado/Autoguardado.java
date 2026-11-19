/*
 * UT2 · Relación de ejercicios · Ejercicio 2.3 – Autoguardado
 *
 * Guarda el documento cada segundo. Su bucle no tiene condición de fin.
 */
package bloque2.autoguardado;

public class Autoguardado implements Runnable {

    private final StringBuilder documento;

    public Autoguardado(StringBuilder documento) {
        this.documento = documento;
    }

    /** Guarda el documento cada segundo, sin fin. */
    public void guardarPeriodicamente() {
        int guardados = 0;
        try {
            while (true) {
                Thread.sleep(1000);
                guardados++;
                String texto;
                // El editor escribe en el mismo StringBuilder: leemos sin que escriba a la vez.
                synchronized (documento) {
                    texto = documento.toString();
                }
                System.out.println("[Autoguardado " + guardados + "] \"" + texto + "\"");
            }
        } catch (InterruptedException e) {
            System.out.println("[Autoguardado] Interrumpido");
        }
    }

    @Override
    public void run() {
        guardarPeriodicamente();
    }
}
