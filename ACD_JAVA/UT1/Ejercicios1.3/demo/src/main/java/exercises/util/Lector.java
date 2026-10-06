package exercises.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Lector {

    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static String leerTextoNoVacio(String mensaje) throws IOException {
        String texto = "";
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            texto = br.readLine();
            if (texto.isEmpty()) {
                System.out.println("  Error: no puede estar vacío.");
            } else {
                valido = true;
            }
        }
        return texto;
    }

    public static LocalDate leerFechaIso(String mensaje) throws IOException {
        LocalDate fecha = null;
        while (fecha == null) {
            System.out.print(mensaje);
            String texto = br.readLine();
            try {
                fecha = LocalDate.parse(texto);
            } catch (DateTimeParseException e) {
                System.out.println("  Error: formato incorrecto. Usa yyyy-MM-dd (ej. 2025-03-15).");
            }
        }
        return fecha;
    }
    public static double leerDoubleNoNegativo(String mensaje) throws IOException {
        double numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String texto = br.readLine().replace(',', '.');
            try {
                numero = Double.parseDouble(texto);
                if (numero < 0) {
                    System.out.println("Error: debe ser mayor o igual que 0.");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: escribe un número válido (ej. 1500.50).");
            }
        }
        return numero;
    }

    public static boolean leerSiNo(String mensaje) throws IOException {
        boolean respuesta = false;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String texto = br.readLine().toLowerCase();
            if (texto.equals("s") || texto.equals("si") || texto.equals("sí")) {
                respuesta = true;
                valido = true;
            } else if (texto.equals("n") || texto.equals("no")) {
                respuesta = false;
                valido = true;
            } else {
                System.out.println("  Error: responde s o n.");
            }
        }
        return respuesta;
    }

    /**
     * Pide un número entero dentro de un rango (ambos incluidos).
     */
    public static int leerEnteroEnRango(String mensaje, int min, int max) throws IOException {
        int numero = min;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String texto = br.readLine();
            try {
                numero = Integer.parseInt(texto);
                if (numero < min || numero > max) {
                    System.out.println("  Error: elige un número entre " + min + " y " + max + ".");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("  Error: escribe un número entero.");
            }
        }
        return numero;
    }


}
