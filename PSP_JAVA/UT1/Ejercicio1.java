package UT1;

import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        String[] comandoCalculadora = {"open", "-a", "kcalc"};

        ProcessBuilder pbCalculadora = new ProcessBuilder(comandoCalculadora);

        try {
    
            Process procesoCalculadora = pbCalculadora.start();
            System.out.println("¡Calculadora lanzada con éxito!");
            
            int codigoCalculadora = procesoCalculadora.waitFor();
            System.out.println("Calculadora cerrada. Código de salida: " + codigoCalculadora);
            
        } catch (IOException e) {
            System.err.println("ERROR I/O: No se pudo ejecutar el comando de la calculadora.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("ERROR: El hilo fue interrumpido mientras esperaba a la calculadora.");
            e.printStackTrace();
        }

        String[] comandoTextEdit = {"open", "-a", "TextEdit"};
        
        System.out.println("Configurando el comando: " + String.join(" ", comandoTextEdit));
        
        ProcessBuilder pbTextEdit = new ProcessBuilder(comandoTextEdit);
        
        try {
            Process procesoTextEdit = pbTextEdit.start();
            System.out.println("¡TextEdit lanzado con éxito!");
            
            int codigoTextEdit = procesoTextEdit.waitFor();
            System.out.println("TextEdit cerrado. Código de salida: " + codigoTextEdit);
            
        } catch (IOException e) {
            System.err.println("ERROR I/O: No se pudo ejecutar el comando de TextEdit.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("ERROR: El hilo fue interrumpido mientras esperaba a TextEdit.");
            e.printStackTrace();
        }
    }
}
