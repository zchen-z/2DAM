package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "mkdir", "pruebas");

        try {
            System.out.println("Lanzando: " + pb.command());
            Process p = pb.start();

            int codigo = p.waitFor();
            System.out.println("Codigo de salida " + codigo);

            if (codigo == 0){
                System.out.println("Carpeta creada");
            }else{
                System.out.println("Error al crear la carpeta");
            }
        } catch (IOException e) {
            System.out.println("No se pudo lanzar el comando: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida");
        }
        }
    }


