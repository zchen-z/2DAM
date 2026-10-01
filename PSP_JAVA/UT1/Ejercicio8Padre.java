package UT1;

import java.io.IOException;

public class Ejercicio8Padre {
    public static void main(String[] args) {
        String[] valores = {"0", "5", "42"};

        for (String valor : valores) {
            String[] comando = {"java", "-cp", "bin", "UT1.Ejercicio8Hijo", valor};

            ProcessBuilder pb = new ProcessBuilder(comando);

            try {
                System.out.println("\nPadre Lanzando Hijo con el argumento: " + valor);
                Process procesoHijo = pb.start();

                int codigoSalida = procesoHijo.waitFor();

                System.out.println("Padre Hijo terminado. Código devuelto: " + codigoSalida);

            } catch (IOException e) {
                System.err.println("Error de E/S al lanzar el hijo: " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("El proceso fue interrumpido: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("\n--- Proceso Padre finalizado ---");
    }
        }
    

