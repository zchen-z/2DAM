package UT1;

public class Ejercicio8Hijo {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int numero = Integer.parseInt(args[0]);

                System.exit(numero);
            } catch (NumberFormatException e) {
                System.exit(-1);
            }
        } else {
            System.exit(-1);
        }
    }
}
