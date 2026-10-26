package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java -cp bin PSP.Ejercicio3 <comando> [argumentos...]");
            System.out.println("Ejemplo: java -cp bin PSP.Ejercicio3 notepad datos.txt");
        }else{
        
        ProcessBuilder pb = new ProcessBuilder(args);

        System.out.println("Comando a lanzar: " + String.join(" ", pb.command()));

        try {
            Process proceso = pb.start();
            System.out.println("Proceso lanzado con éxito con el PID: " + proceso.pid());
            

        } catch (IOException e) {
            System.err.println("ERROR: No se pudo ejecutar el comando. ");
        }
        }

        
    }
}

