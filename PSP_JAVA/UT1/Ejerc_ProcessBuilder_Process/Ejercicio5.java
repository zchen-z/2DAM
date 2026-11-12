package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Host: ");
        String host = sc.nextLine().trim();

        ProcessBuilder pb = new ProcessBuilder("ping", "-c", "1", host);
        pb.inheritIO();

        try {
            System.out.println("Lanzando: " + String.join(" ", pb.command()));
            Process p = pb.start();
            
            int codigo = p.waitFor();
            System.out.println("Codigo de salida: " + codigo);

            if(codigo == 0){
                System.out.println("El host " + host + " responde");
            }else{
                System.out.println("El host " + host + "no responde");
            }
        } catch (IOException e) {
            System.out.println("No se pudo lanzar ping: " + e.getMessage());
        }catch(InterruptedException e ){
            System.out.println("La espera fue interrumpida");
        }

        sc.close();

        
    }
}
