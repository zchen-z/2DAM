package UT2;

class TareaEncadenada implements Runnable {

    private String nombre;
    private Thread hiloAnterior;

    public TareaEncadenada(String nombre, Thread hiloAnterior) {
        this.nombre = nombre;
        this.hiloAnterior = hiloAnterior;
    }

    @Override
    public void run() {
        try {
            if (hiloAnterior != null) {
                System.out.println(nombre + " espera a que termine el hilo anterior");
                // El join() está dentro del hilo: es este hilo el que se queda esperando, no el main.
                hiloAnterior.join();
            }

            System.out.println("Inicio de " + nombre);
            for (int i = 1; i <= 5; i++) {
                System.out.println(nombre + " ejecutando paso " + i);
                Thread.sleep(500);
            }
            System.out.println("Fin de " + nombre);

        } catch (InterruptedException e) {
            System.out.println(nombre + " ha sido interrumpido");
        }
    }
}
