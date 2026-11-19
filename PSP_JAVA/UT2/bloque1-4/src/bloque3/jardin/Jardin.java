/*
 * UT2 · Relación de ejercicios · Ejercicio 3.2 – El jardín ornamental
 *
 * Dos puertas, 1.000.000 de visitantes por cada una.
 * Se puede pasar otro número de visitantes por args (pregunta 4).
 */
package bloque3.jardin;

public class Jardin {

    public static void main(String[] args) throws InterruptedException {
        int porPuerta = 1_000_000;
        if (args.length > 0) {
            porPuerta = Integer.parseInt(args[0]);
        }

        // Objeto común
        ContadorVisitantes contador = new ContadorVisitantes();
        Thread norte = new Thread(new Puerta(contador, porPuerta));
        Thread sur = new Thread(new Puerta(contador, porPuerta));
        norte.start();
        sur.start();
        norte.join();
        sur.join();
        System.out.println("Objeto común -> esperados: " + (2 * porPuerta) + " | contados: " + contador.total());

        // Atributo static
        Thread norte2 = new Thread(new PuertaStatic(porPuerta));
        Thread sur2 = new Thread(new PuertaStatic(porPuerta));
        norte2.start();
        sur2.start();
        norte2.join();
        sur2.join();
        System.out.println("Static       -> esperados: " + (2 * porPuerta) + " | contados: " + PuertaStatic.visitantes);
    }
}
