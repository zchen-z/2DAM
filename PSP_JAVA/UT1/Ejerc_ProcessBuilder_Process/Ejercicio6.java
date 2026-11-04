package UT1.Ejerc_ProcessBuilder_Process;

import java.io.File;

public class Ejercicio6 {
    public static void main(String[] args) {
        File carpeta = new File("pruebas");
        ProcessBuilder pb = new ProcessBuilder("touch", "fichero.txt");

        pb.directory(carpeta);
    }
}
