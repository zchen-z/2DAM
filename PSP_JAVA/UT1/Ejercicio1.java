package UT1;

import java.io.IOException;

public class Ejercicio1 {

    public static void main(String[] args) {
        ProcessBuilder pbCalc = new ProcessBuilder("kcalc");

        try {
            System.out.println("Abriendo la calculadora KCalc...");
            Process procesoCalc = pbCalc.start();
            System.out.println("KCalc lanzada. El programa esperará a que la cierres...");
            
            procesoCalc.waitFor(); 
            System.out.println("Calculadora cerrada.\n");

        } catch (IOException e) {
            System.err.println("Error al intentar abrir KCalc: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El proceso de la calculadora fue interrumpido.");
            Thread.currentThread().interrupt();
        }

        ProcessBuilder pbEditor = new ProcessBuilder("kate");

        try {
            System.out.println("Abriendo editor kate");
            Process procesoEditor = pbEditor.start();
            System.out.println("Kate lanzada. ");
        } catch (Exception e) {
            System.err.println("Error al intentar abrir el editor de textos: " + e.getMessage());

        }

        
    }
}

    

