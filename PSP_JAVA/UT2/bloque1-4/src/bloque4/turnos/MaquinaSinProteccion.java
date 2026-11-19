/*
 * UT2 · Relación de ejercicios · Ejercicio 4.3 – La máquina de turnos
 *
 * Pregunta 1: primera versión, sin ninguna protección.
 */
package bloque4.turnos;

public class MaquinaSinProteccion implements Maquina {

    private int ultimo = 0;

    public int nuevoTurno() {
        ultimo++;
        return ultimo;
    }
}
