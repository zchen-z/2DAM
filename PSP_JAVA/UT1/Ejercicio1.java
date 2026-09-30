package UT1;

import java.io.IOException;

public class Ejercicio1 {

    public static void main(String[] args) {
        // 1. Configuramos el comando de Linux para abrir la calculadora
        // Nota: En Ubuntu/Debian suele ser "gnome-calculator"
        ProcessBuilder pb = new ProcessBuilder("kcalc"); 

        try {
            System.out.println("Abriendo la calculadora en Linux...");
            
            // 2. Arrancamos el proceso
            Process proceso = pb.start();
            
            System.out.println("¡Proceso lanzado con éxito!");

        } catch (IOException e) {
            System.err.println("Error al intentar abrir la calculadora: " + e.getMessage());
            System.err.println("Asegúrate de que 'gnome-calculator' está instalado o cambia el comando.");
        }
    }
}

    

