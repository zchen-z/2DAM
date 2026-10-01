package UT1;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el nombre de host o dirección IP a comprobar: ");
        String host = sc.nextLine();
        sc.close();

          ProcessBuilder pb = new ProcessBuilder("ping", "-c", "1", host);

        try {
            System.out.println("\nPADRE Lanzando proceso hijo ('ping') contra: " + host + "...");
            
            Process procesoPing = pb.start();

            int codigoSalida = procesoPing.waitFor();

            System.out.println("[PADRE] El proceso 'ping' ha finalizado.");
            System.out.println("[PADRE] Código de salida devuelto por Linux: " + codigoSalida);

            if (codigoSalida == 0) {
                System.out.println("\n El host '" + host + "' RESPONDE correctamente.");
            } else {
                System.out.println("\n El host '" + host + "' NO responde (o no existe).");
            }

        } catch (IOException e) {
            System.err.println("Error de E/S al intentar ejecutar el comando ping: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El proceso padre fue interrumpido bruscamente: " + e.getMessage());
        }






    }
}
