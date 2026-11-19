/*
 * UT2 · Relación de ejercicios · Ejercicio 4.3 – La máquina de turnos
 *
 * Un cliente que saca 100.000 números de turno.
 */
package bloque4.turnos;

public class Cliente implements Runnable {

    static final int NUMEROS = 100_000;

    private final Maquina maquina;
    // Cada cliente tiene su propio array: no se comparte, así que no necesita protección.
    private final int[] numeros = new int[NUMEROS];

    public Cliente(Maquina maquina) {
        this.maquina = maquina;
    }

    public void sacarTurnos() {
        for (int i = 0; i < NUMEROS; i++) {
            numeros[i] = maquina.nuevoTurno();
        }
    }

    @Override
    public void run() {
        sacarTurnos();
    }

    public int[] getNumeros() {
        return numeros;
    }
}
