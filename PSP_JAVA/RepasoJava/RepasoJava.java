
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class RepasoJava {
    public static void Calualadora() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("""
                1) Sumar
                2) Restar
                3) Multiplicar
                4) Dividir
                5) Salir.
                 """);

        boolean terminado = false;
        int opcion, num1, num2, resultado;

        while (!terminado) {
            System.out.println("Opcion: ");
            opcion = Integer.parseInt(br.readLine());

            if (opcion == 5) {
                System.out.println("Saliendo...");
                terminado = true;
            } else if (opcion < 1 || opcion > 5) {
                System.out.println("Opcion no valida de la calculadora");
            } else {
                System.out.println("Num 1: ");
                num1 = Integer.parseInt(br.readLine());
                System.out.println("Num 2: ");
                num2 = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1 -> {
                        resultado = num1 + num2;
                        System.out.println("Resultado de la Suma: " + resultado);
                    }
                    case 2 -> {
                        resultado = num1 - num2;
                        System.out.println("Resultado de la Resta: " + resultado);
                    }
                    case 3 -> {
                        resultado = num1 * num2;
                        System.out.println("Resultado de la Multiplicacion: " + resultado);
                    }
                    case 4 -> {
                        if (num2 < 0) {
                            System.out.println("Division invalida. Introduzaca numero entero positivo");
                        } else {
                            resultado = num1 / num2;
                            System.out.println("Resultado de la Division: " + resultado);
                        }
                    }

                    default -> System.out.println("Opcion no valida");
                }
            }

        }
    }

    public static void Argumentos() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String edad;
        int edad_;
        String nombre;
        System.out.println("Nombre: ");
        nombre = br.readLine();
        System.out.println("Edad: ");
        edad = br.readLine();

        if (edad.isEmpty() && nombre.isEmpty()) {
            System.out.println("No se introdujo ningun argumento. ");
        } else if (!nombre.isEmpty() && edad.isEmpty()) {
            System.out.println("Hola " + nombre);
        } else if (!edad.isEmpty() && nombre.isEmpty()) {
            edad_ = Integer.parseInt(edad);
            System.out.println("Tienes " + edad_);
        } else {
            edad_ = Integer.parseInt(edad);
            System.out.println("Hola " + nombre + " tienes " + edad_ + " años");
        }

    }

    public static void Notas() throws IOException {
        double[] notas = { 4.5, 7.0, 8.5, 3.0, 9.5, 5.0, 2.5, 6.0 };

        int aprobados = 0;
        int suspendidos = 0;

        for (double nota : notas) {
            if (nota >= 5.0) {
                aprobados++;
            } else {
                suspendidos++;
            }
        }

        double porcentajeAprobados = ((double) aprobados / notas.length) * 100;

        System.out.println("Las notas: { 4.5, 7.0, 8.5, 3.0, 9.5, 5.0, 2.5, 6.0 }");
        System.out.println("Alumnos aprobados: " + aprobados);
        System.out.println("Alumnos suspendidos: " + suspendidos);
        System.out.println("Porcentaje de aprobados: " + porcentajeAprobados + "%");

    }

    public static void ListaCompras() {
        ArrayList<String> listaCompra = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        String producto;

        while (!ok) {
            System.out.println("Introduce productos para la lista de la compra. Escribe \"fin\" para terminar:");
            producto = sc.nextLine().trim();

            if (producto.equalsIgnoreCase("fin")) {
                ok = true;
            } else if (listaCompra.contains(producto)) {
                System.out.println("El producto '" + producto + "' ya está en la lista. No se añade.");
            } else {
                listaCompra.add(producto);
                System.out.println(producto + " Añadido correctamente");
            }
        }

        System.out.print("\n Introduce un producto a eliminar: ");
        String productoAEliminar = sc.nextLine().trim();

        if (listaCompra.contains(productoAEliminar)) {
            listaCompra.remove(productoAEliminar);
            System.out.println(productoAEliminar + " ha sido eliminado");
        } else {
            System.out.println("El producto no existía en la lista, por lo que no se ha eliminado nada.");
        }

        System.out.println("\n LISTA DE LA COMPRA FINAL ");
        if (listaCompra.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            for (String p : listaCompra) {
                System.out.println("- " + p);
            }
        }
        System.out.println("Número total de productos: " + listaCompra.size());
    }

    public static void LectorAlumnos() {

        String archivo = "alumnos.txt";
        int numeroLinea = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(numeroLinea + ". " + linea);
                numeroLinea++;
            }

        } catch (IOException e) {
            System.out.println("Error: El fichero '" + archivo + "' no existe o no se puede leer.");
        }

    }

    public static void EscribirFichero() throws IOException{
        System.out.println("Mi Diario Personal");
        System.out.println("Escribe tus frases. Escribe salir  para terminar.\n");

        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter("diario.txt", true))) {
            
            String frase;
            boolean ok = false;
            while (!ok) {
                System.out.print("Escribe una frase: ");
                frase = scanner.nextLine();
                
                if (frase.equalsIgnoreCase("salir")) {
                    System.out.println("\nDiario guardado con éxito");
                    ok = true;
                }
                
                writer.write(frase);
                writer.newLine();
            }
            
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo: " + e.getMessage());
        }
    }

}
