/*
 * UT2 · Relación de ejercicios · Ejercicio 2.3 – Autoguardado
 *
 * El usuario escribe durante 4 segundos y cierra el editor.
 */
package bloque2.autoguardado;

public class Editor {

    public static void main(String[] args) throws InterruptedException {
        StringBuilder documento = new StringBuilder();

        Thread autoguardado = new Thread(new Autoguardado(documento));
        // Daemon: la JVM no lo espera. Cuando termine el main, el programa acaba.
        // Hay que indicarlo ANTES de start().
        autoguardado.setDaemon(true);
        autoguardado.start();

        long inicio = System.currentTimeMillis();
        int palabras = 0;
        while (System.currentTimeMillis() - inicio < 4000) {
            Thread.sleep(300);
            palabras++;
            synchronized (documento) {
                documento.append("palabra").append(palabras).append(" ");
            }
        }

        System.out.println("El usuario cierra el editor (" + palabras + " palabras)");
    }
}
