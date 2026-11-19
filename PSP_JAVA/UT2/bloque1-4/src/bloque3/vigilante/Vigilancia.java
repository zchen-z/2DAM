/*
 * UT2 · Relación de ejercicios · Ejercicio 3.3 – El vigilante
 *
 * El jefe de seguridad avisa al vigilante a los 2 segundos.
 */
package bloque3.vigilante;

public class Vigilancia {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- 1. Sin volatile ---");
        Thread vigilante = new Thread(new VigilanteSinVolatile());
        // Daemon: si no se entera, el programa termina igualmente.
        vigilante.setDaemon(true);
        vigilante.start();
        Thread.sleep(2000);
        VigilanteSinVolatile.finTurno = true;
        System.out.println("[Jefe] Aviso: fin de turno");
        vigilante.join(3000);
        if (vigilante.isAlive()) {
            System.out.println("[Jefe] El vigilante no se ha enterado del aviso");
        }

        System.out.println("\n--- 2. Corregido con volatile ---");
        avisar(1);

        System.out.println("\n--- 3. Tres vigilantes con un total común ---");
        avisar(3);
    }

    static void avisar(int numVigilantes) throws InterruptedException {
        Vigilante.finTurno = false;
        Vigilante.totalRondas = 0;

        Vigilante[] vigilantes = new Vigilante[numVigilantes];
        Thread[] hilos = new Thread[numVigilantes];
        for (int i = 0; i < numVigilantes; i++) {
            vigilantes[i] = new Vigilante("Vigilante " + (i + 1));
            hilos[i] = new Thread(vigilantes[i]);
            hilos[i].setDaemon(true);
            hilos[i].start();
        }

        Thread.sleep(2000);
        Vigilante.finTurno = true;
        System.out.println("[Jefe] Aviso: fin de turno");

        long suma = 0;
        for (int i = 0; i < numVigilantes; i++) {
            hilos[i].join(3000);
            if (hilos[i].isAlive()) {
                System.out.println("[Jefe] El vigilante " + (i + 1) + " no se ha enterado del aviso");
            } else {
                suma = suma + vigilantes[i].getRondas();
            }
        }

        if (numVigilantes > 1) {
            System.out.println("Suma de las rondas de cada vigilante: " + suma);
            System.out.println("Total común acumulado:               " + Vigilante.totalRondas);
            System.out.println("Rondas perdidas en el total común:   " + (suma - Vigilante.totalRondas));
        }
    }
}
