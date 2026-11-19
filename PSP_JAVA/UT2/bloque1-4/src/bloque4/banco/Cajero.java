/*
 * UT2 · Relación de ejercicios · Ejercicio 4.4 – El banco
 *
 * Un cajero que hace 200.000 transferencias de 1 a 100 € entre cuentas al azar.
 */
package bloque4.banco;

import java.util.Random;

public class Cajero implements Runnable {

    static final int TRANSFERENCIAS = 200_000;
    static final int SIN_PROTECCION = 1;
    static final int SINCRONIZADO = 2;
    static final int POR_CUENTAS = 3;

    private final Banco banco;
    private final int modo;

    public Cajero(Banco banco, int modo) {
        this.banco = banco;
        this.modo = modo;
    }

    public void hacerTransferencias() {
        Random r = new Random();
        for (int i = 0; i < TRANSFERENCIAS; i++) {
            int origen = r.nextInt(banco.numCuentas());
            int destino = r.nextInt(banco.numCuentas());
            while (destino == origen) {
                destino = r.nextInt(banco.numCuentas());
            }
            int cantidad = 1 + r.nextInt(100);

            if (modo == SIN_PROTECCION) {
                banco.transferirSinProteccion(origen, destino, cantidad);
            } else if (modo == SINCRONIZADO) {
                banco.transferir(origen, destino, cantidad);
            } else {
                banco.transferirPorCuentas(origen, destino, cantidad);
            }
        }
    }

    @Override
    public void run() {
        hacerTransferencias();
    }
}
