/*
 * UT2 · Relación de ejercicios · Ejercicio 4.4 – El banco
 *
 * 10 cuentas con 1.000 € cada una.
 */
package bloque4.banco;

public class Banco {

    private final Cuenta[] cuentas;

    public Banco(int numCuentas, int saldoInicial) {
        cuentas = new Cuenta[numCuentas];
        for (int i = 0; i < numCuentas; i++) {
            cuentas[i] = new Cuenta(i, saldoInicial);
        }
    }

    public int numCuentas() {
        return cuentas.length;
    }

    /** Versión sin ninguna protección. */
    public void transferirSinProteccion(int origen, int destino, int cantidad) {
        mover(cuentas[origen], cuentas[destino], cantidad);
    }

    /** Mueve dinero de una cuenta a otra, solo si la de origen tiene saldo suficiente. */
    // Corrección: un solo cerrojo para todo el banco. Correcto, pero solo una transferencia a la vez.
    public synchronized void transferir(int origen, int destino, int cantidad) {
        mover(cuentas[origen], cuentas[destino], cantidad);
    }

    /** Ampliación: un cerrojo por cuenta. */
    public void transferirPorCuentas(int origen, int destino, int cantidad) {
        // Para evitar el interbloqueo, las cuentas se bloquean siempre en el mismo orden:
        // primero la de id menor y después la de id mayor.
        Cuenta primera = cuentas[origen];
        Cuenta segunda = cuentas[destino];
        if (origen > destino) {
            primera = cuentas[destino];
            segunda = cuentas[origen];
        }

        synchronized (primera) {
            synchronized (segunda) {
                mover(cuentas[origen], cuentas[destino], cantidad);
            }
        }
    }

    private void mover(Cuenta origen, Cuenta destino, int cantidad) {
        if (origen.saldo >= cantidad) {
            origen.saldo = origen.saldo - cantidad;
            destino.saldo = destino.saldo + cantidad;
        }
    }

    /** Dinero total del banco. */
    public int total() {
        int suma = 0;
        for (int i = 0; i < cuentas.length; i++) {
            suma = suma + cuentas[i].saldo;
        }
        return suma;
    }
}
