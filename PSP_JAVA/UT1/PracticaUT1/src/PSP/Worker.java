package PSP;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Worker {

    private Process proceso;
    private PrintWriter entrada;
    private BufferedReader salida;
    private int atendidas = 0;
    private boolean caido = false;

    public Worker() throws IOException {
        // Usamos la misma JVM y el mismo classpath que el gestor, así funciona
        // igual desde IntelliJ que desde la terminal.
        String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");

        ProcessBuilder pb = new ProcessBuilder(java, "-cp", classpath, "PSP.SumWorker");

        // Los errores del worker se añaden al final de workers.log sin borrar lo anterior.
        pb.redirectError(ProcessBuilder.Redirect.appendTo(new File("workers.log")));

        proceso = pb.start();
        entrada = new PrintWriter(proceso.getOutputStream(), true);
        salida = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
    }

    public void enviar(String orden) {
        entrada.println(orden);
    }

    public String leer() throws IOException {
        return salida.readLine();
    }

    public int esperarFin() throws InterruptedException {
        return proceso.waitFor();
    }

    public void cerrar() throws IOException, InterruptedException {
        enviar("EXIT");
        String respuesta = leer();
        if (respuesta != null) {
            System.out.println("[PID " + getPid() + "] " + respuesta);
        } else {
            System.out.println("[PID " + getPid() + "] no ha contestado al EXIT");
        }

        // Esperamos como máximo 2 segundos. Devuelve true si ha terminado.
        boolean termino = proceso.waitFor(2, TimeUnit.SECONDS);
        if (!termino) {
            System.out.println("El worker " + getPid() + " no termina, lo forzamos");
            proceso.destroyForcibly();
            proceso.waitFor();
        }
        System.out.println("Worker " + getPid() + " terminado con código " + proceso.exitValue());
    }

    public long getPid() {
        return proceso.pid();
    }

    public void sumarAtendida() {
        atendidas++;
    }

    public int getAtendidas() {
        return atendidas;
    }

    public void setCaido(boolean caido) {
        this.caido = caido;
    }

    public boolean isCaido() {
        return caido;
    }
}
