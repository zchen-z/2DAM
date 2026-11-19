package UT1.Ejerc_ProcessBuilder_Process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ejercicio12 {
    static ArrayList<Process> procesos = new ArrayList<>();
    static ArrayList<String> comandos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n1. Lanzar proceso");
            System.out.println("2. Listar procesos lanzados");
            System.out.println("3. Terminar un proceso por PID");
            System.out.println("4. Salir");
            System.out.println("5. Terminar cualquier proceso del sistema (ampliación)");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = 0;
            }


        }
    }

    public static void lanzar(){
        System.out.println("Comando: ");
        String comando = sc.nextLine().trim();

        if(comando.isEmpty()){
            System.out.println("No has escrito nada");
        }else{
            String[] partes = comando.split(" +");
            try {
                Process p = new ProcessBuilder(partes).start();
                procesos.add(p);
                comandos.add(comando);
                System.out.println("Proceso lanzado con PID " + p.pid());
            } catch (IOException e) {
                System.out.println("No se pudo lanzar: " + e.getMessage());
            }
        }
    }

    public static void listar(){
        if (procesos.isEmpty()){
            System.out.println("No has lanzado ningun proceso");
        }else{
            for (int i = 0; i < procesos.size(); i++) {
                Process p = procesos.get(i);
                String linea = "PID " + p.pid() + " |" + comandos.get(i);

                if(p.isAlive()){
                    linea = linea + " | vivo";
                }else{
                    linea = linea + " | terminado codigo de salida: " + p.exitValue();  
                }
                System.out.println(linea);
            }
        }
    }

    public static void terminarLanzado(){
        long pid = pedirPid();

        Process encontrado = null;
        for (int i = 0; i < procesos.size(); i++) {
            if(procesos.get(i).pid() == pid){
                encontrado = procesos.get(i);
            }
        }

        if(encontrado == null){
            System.out.println("El PID: " + pid + "no es ningun proceso lanzado");
        }else if(!encontrado.isAlive()){
            System.out.println("Ese proceso ya ha terminado");
        }else{
            try {
            encontrado.destroy();
            boolean terminado = encontrado.waitFor(2, TimeUnit.SECONDS);
            
            if(!terminado){
                System.out.println("No ha terminado con destroy(), usando destroyForcibly()");
                encontrado.destroyForcibly();
                encontrado.waitFor();
            }

            System.out.println("PID " + encontrado.pid() + "terminado con codigo " + encontrado.exitValue());
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida");
        }
        }
    }

     

    public static long pedirPid(){
        System.out.println("PID: ");
        long pid = -1;
        try {
            pid = Long.parseLong(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Eso no es un numero");
        }
        return pid;
    }
}
