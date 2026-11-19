/*
 * UT2 · Relación de ejercicios · Ejercicio 4.3 – La máquina de turnos
 *
 * La máquina de turnos de la carnicería: ningún número puede repetirse.
 */
package bloque4.turnos;

public class MaquinaTurnos implements Maquina {

    private int ultimo = 0;

    // Sumar y devolver tienen que ir juntos: si no, dos clientes podrían
    // devolver el mismo valor aunque los dos hayan sumado.
    public synchronized int nuevoTurno() {
        ultimo++;
        return ultimo;
    }
}
