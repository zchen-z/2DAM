package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejercicio9 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("sleep", "10");

        try {
            Process p = pb.start();
            System.out.println("Lanzando sleep 10 con PID: " + p.pid());

            boolean terminado = p.waitFor(3, TimeUnit.SECONDS);

            if(terminado){
                System.out.println("Han pasado 3 seg y sigue vivo");
                System.out.println("Vivo antes de destruirlo? " + p.isAlive());

                p.destroy();
                p.waitFor();
                System.out.println("Vivo despues de destruirlo? " + p.isAlive());
            }

            System.out.println("Codigo de salida final: " + p.exitValue());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
