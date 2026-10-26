package PSP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SumManager {

    static Worker[] workers;
    static ArrayList<Worker> todos = new ArrayList<>();
    static int errores = 0;
    static int caidas = 0;
    static int relanzados = 0;

    public static void main(String[] args) {
        int numWorkers = 2;
        boolean argumentosBien = true;

        if (args.length >= 1) {
            try {
                numWorkers = Integer.parseInt(args[0]);
                if (numWorkers < 1) {
                    argumentosBien = false;
                }
            } catch (NumberFormatException e) {
                argumentosBien = false;
            }
        }

        if (argumentosBien) {
            String fichero = null;
            if (args.length >= 2) {
                fichero = args[1];
            }
            ejecutar(numWorkers, fichero);
        } else {
            System.out.println("Uso: java -cp bin PSP.SumManager [numWorkers] [ficheroOrdenes]");
        }
    }

    public static void ejecutar(int numWorkers, String fichero) {
        long inicio = System.currentTimeMillis();
        BufferedReader lote = null;
        PrintWriter resultados = null;

        try {
            if (fichero != null) {
                lote = new BufferedReader(new FileReader(fichero));
                resultados = new PrintWriter(new FileWriter("resultados.txt"));
                System.out.println("Modo lote: leyendo órdenes de " + fichero);
            }

            workers = new Worker[numWorkers];
            for (int i = 0; i < numWorkers; i++) {
                workers[i] = new Worker();
                todos.add(workers[i]);
                System.out.println("Worker " + (i + 1) + " lanzado con PID " + workers[i].getPid());
            }

            Scanner sc = new Scanner(System.in);
            int turno = 0;
            boolean seguir = true;

            while (seguir) {
                String orden = leerOrden(sc, lote);

                if (orden == null) {
                    seguir = false;
                } else if (!orden.isEmpty()) {
                    // Reparto por turnos: 0, 1, 2... y vuelta a empezar.
                    int pos = turno % numWorkers;
                    turno++;

                    String respuesta = mandarOrden(pos, orden);
                    Worker w = workers[pos];

                    if (respuesta != null) {
                        w.sumarAtendida();
                        if (respuesta.equals("ERROR")) {
                            errores++;
                        }
                        System.out.println("[PID " + w.getPid() + "] " + respuesta);
                        if (resultados != null) {
                            resultados.println(orden + " | PID " + w.getPid() + " | " + respuesta);
                        }
                    } else {
                        if (resultados != null) {
                            resultados.println(orden + " | sin respuesta (worker caído)");
                        }
                    }
                }
            }

            System.out.println("\nCerrando workers...");
            for (int i = 0; i < workers.length; i++) {
                workers[i].cerrar();
            }

            if (lote != null) {
                lote.close();
                resultados.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido la espera");
        }

        long fin = System.currentTimeMillis();
        mostrarResumen(fin - inicio);
    }

    public static String leerOrden(Scanner sc, BufferedReader lote) throws IOException {
        String orden = null;

        if (lote != null) {
            String linea = lote.readLine();
            if (linea != null) {
                orden = linea.trim();
            }
        } else {
            System.out.print("Orden> ");
            if (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();
                if (!linea.equalsIgnoreCase("SALIR")) {
                    orden = linea;
                }
            }
        }

        return orden;
    }

    public static String mandarOrden(int pos, String orden) throws IOException, InterruptedException {
        Worker w = workers[pos];
        w.enviar(orden);
        String respuesta = w.leer();

        // Si readLine() devuelve null es que el worker ha muerto.
        if (respuesta == null) {
            int codigo = w.esperarFin();
            w.setCaido(true);
            caidas++;
            System.out.println("Worker caído: PID " + w.getPid() + ", código de salida " + codigo);

            Worker nuevo = new Worker();
            workers[pos] = nuevo;
            todos.add(nuevo);
            relanzados++;
            System.out.println("Lanzado un worker nuevo con PID " + nuevo.getPid());

            // La orden CRASH no se reenvía porque tiraría también al nuevo.
            if (!orden.equalsIgnoreCase("CRASH")) {
                System.out.println("Reenviando la orden al worker nuevo");
                nuevo.enviar(orden);
                respuesta = nuevo.leer();
            }
        }

        return respuesta;
    }

    public static void mostrarResumen(long milisegundos) {
        System.out.println("\n----- RESUMEN -----");
        System.out.println("Órdenes atendidas por cada worker:");
        for (int i = 0; i < todos.size(); i++) {
            Worker w = todos.get(i);
            if (w.isCaido()) {
                System.out.println("  PID " + w.getPid() + ": " + w.getAtendidas() + " (caído)");
            } else {
                System.out.println("  PID " + w.getPid() + ": " + w.getAtendidas());
            }
        }
        System.out.println("Respuestas ERROR: " + errores);
        System.out.println("Caídas: " + caidas);
        System.out.println("Workers relanzados: " + relanzados);
        System.out.println("Tiempo total: " + (milisegundos / 1000.0) + " segundos");
    }
}
