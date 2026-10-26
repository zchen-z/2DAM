package PSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumWorker {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long pid = ProcessHandle.current().pid();
        boolean seguir = true;

        try {
            while (seguir) {
                // El readLine() se queda esperando hasta que el gestor manda una orden.
                // Si devuelve null es que el gestor ha cerrado la tubería.
                String linea = br.readLine();

                if (linea == null) {
                    seguir = false;
                } else {
                    String[] partes = linea.trim().split(" +");
                    String orden = partes[0].toUpperCase();

                    if (orden.equals("CRASH") && partes.length == 1) {
                        System.exit(3);
                    } else if (orden.equals("EXIT") && partes.length == 1) {
                        System.out.println("BYE");
                        System.out.flush();
                        System.exit(0);
                    } else {
                        String respuesta = atenderOrden(partes, pid);
                        if (respuesta.equals("ERROR")) {
                            System.err.println("[PID " + pid + "] Orden no válida: " + linea);
                        }
                        // Sin flush la respuesta se puede quedar en el búfer
                        // y el gestor se quedaría esperando para siempre.
                        System.out.println(respuesta);
                        System.out.flush();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("[PID " + pid + "] Error al leer: " + e.getMessage());
        }
    }

    public static String atenderOrden(String[] partes, long pid) {
        String orden = partes[0].toUpperCase();
        String respuesta = "ERROR";

        try {
            switch (orden) {
                case "SUM":
                    if (partes.length == 3) {
                        long a = Long.parseLong(partes[1]);
                        long b = Long.parseLong(partes[2]);
                        respuesta = Operaciones.sumar(a, b);
                    }
                    break;
                case "MUL":
                    if (partes.length == 3) {
                        long a = Long.parseLong(partes[1]);
                        long b = Long.parseLong(partes[2]);
                        respuesta = Operaciones.multiplicar(a, b);
                    }
                    break;
                case "FACT":
                    if (partes.length == 2) {
                        int n = Integer.parseInt(partes[1]);
                        if (n >= 0 && n <= 20) {
                            respuesta = Operaciones.factorial(n);
                        }
                    }
                    break;
                case "PRIMO":
                    if (partes.length == 2) {
                        long n = Long.parseLong(partes[1]);
                        respuesta = Operaciones.esPrimo(n);
                    }
                    break;
                case "PID":
                    if (partes.length == 1) {
                        respuesta = Long.toString(pid);
                    }
                    break;
                default:
                    respuesta = "ERROR";
            }
        } catch (NumberFormatException e) {
            respuesta = "ERROR";
        }

        return respuesta;
    }
}
