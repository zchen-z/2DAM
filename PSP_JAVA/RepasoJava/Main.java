import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean ok = false;
        int opcion;
        while (!ok) {
            System.out.println("------------------------------------------------------");
            System.out.println("1. Calculadora \n2. Argumentos \n3. Notas \n4. Lista de Compra \n5.Leer fichero Alumnos \n6.Escribir Fichero \n7. Salir");
            System.out.println("------------------------------------------------------");
            System.out.println("Opcion de Menú: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    RepasoJava.Calualadora();
                    break;

                case 2:
                    RepasoJava.Argumentos();
                    break;
                case 3:
                    RepasoJava.Notas();
                    break;
                case 4:
                    RepasoJava.ListaCompras();
                    break;
                case 5:
                    RepasoJava.LectorAlumnos();
                    break;

                case 6: 
                    RepasoJava.EscribirFichero();
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    ok = true;
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }

    }
}
