package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;

public class Ejercicio8Padre {
    public static void main(String[] args) {
        String[] valores = {"0", "5", "42", "300", "-1"};

        for (int i = 0; i < valores.length; i++) {
            String[] comando = {
    "java",
    "-cp", System.getProperty("java.class.path"),
    "UT1.Ejerc_ProcessBuilder_Process.Ejercicio8Hijo",
    valores[i]
};
            ProcessBuilder pb = new ProcessBuilder((comando));

            try {
                Process p = pb.start();
                int codigo = p.waitFor();
                System.out.println("El hijo hizo System.exit(" + valores[i] + ") -> el padre recide " + codigo );

            } catch (IOException e) {
                System.out.println("No se pudo lanzar el hijo: " + e.getMessage());
            } catch (InterruptedException e){
                System.out.println("La espera fue interrumpida");
            }
        }
    }
}
