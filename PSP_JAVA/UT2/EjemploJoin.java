package UT2;

public class EjemploJoin {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inicio del programa (hilo principal)");

        // El primero no tiene hilo anterior. Cada uno recibe el hilo del anterior.
        Thread t1 = new Thread(new TareaEncadenada("Hilo-1", null));
        Thread t2 = new Thread(new TareaEncadenada("Hilo-2", t1));
        Thread t3 = new Thread(new TareaEncadenada("Hilo-3", t2));

        // Hay que arrancarlos en orden: un join() sobre un hilo que aún no ha hecho
        // start() no espera nada, porque ese hilo todavía no está vivo.
        t1.start();
        t2.start();
        t3.start();

        // Basta con esperar al último: si Hilo-3 ha terminado, los anteriores también.
        t3.join();

        System.out.println("Todos los hilos han terminado.");
        System.out.println("Fin del programa (hilo principal)");
    }
}