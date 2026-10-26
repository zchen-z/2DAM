package PSP;

public class Operaciones {

    public static String sumar(long a, long b) {
        long resultado = a + b;
        return Long.toString(resultado);
    }

    public static String multiplicar(long a, long b) {
        long resultado = a * b;
        return Long.toString(resultado);
    }

    public static String factorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado = resultado * i;
        }
        return Long.toString(resultado);
    }

    public static String esPrimo(long n) {
        boolean primo = true;
        if (n < 2) {
            primo = false;
        } else {
            long divisor = 2;
            // Basta con probar divisores hasta la raíz cuadrada de n.
            while (divisor * divisor <= n && primo) {
                if (n % divisor == 0) {
                    primo = false;
                }
                divisor++;
            }
        }

        String respuesta;
        if (primo) {
            respuesta = "SI";
        } else {
            respuesta = "NO";
        }
        return respuesta;
    }
}
