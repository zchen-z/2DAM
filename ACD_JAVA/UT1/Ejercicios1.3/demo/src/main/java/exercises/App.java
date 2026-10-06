package exercises;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import exercises.modelo.Empleado;
import exercises.util.Lector;
import exercises.util.LocalDateAdapter;
import exercises.util.View;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .setPrettyPrinting()
            .create();

    public static void main( String[] args )
    {       
            List<Empleado> empleados = new ArrayList<>();
            boolean salir = false;

            while (!salir) {
                View.mostrarMenu();
                int opcion = Lector.leerEnteroEnRango("Eleje una opcion", 1, 4);

                if (opcion == 1) {
                    darDeAltaEmpleados(entrada, empleados);
                } else if (opcion == 2) {
                    exportarJson(empleados);
                } else if (opcion == 3) {
                    leerJson();
                } else {
                    salir = true;
                    System.out.println("¡Hasta luego!");
                }
            }
        
    }

}
