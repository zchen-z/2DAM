package com.example.gson;

import com.example.model.Alumno;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Ejemplo con Gson:
 * - Leer el fichero alumnos.json desde el directorio "data"
 * - Convertir su contenido a una lista de objetos Alumno
 * - Mostrar los alumnos leídos por consola
 */
public class LeerAlumnosGson {
    public static void main(String[] args) {
        // 1. Crear un objeto Gson
        Gson gson = new Gson();

        // 2. Definir la ruta del fichero JSON en la carpeta "data"
        File fichero = new File("src/main/data/alumnos.json");

        // 3. Definir el tipo de dato que vamos a deserializar (Lista de Alumno)
        // TypeToken permite especificar tipos genéricos en tiempo de ejecución
        Type listaAlumnosType = new TypeToken<List<Alumno>>(){}.getType(); //Usar TypeToken<List<Alumno>> → Gson necesita saber que el JSON es una lista de objetos Alumno.

        // 4. Intentar leer el fichero
        try (FileReader reader = new FileReader(fichero)) {
            // Convertir JSON → Lista de Alumno
            List<Alumno> lista = gson.fromJson(reader, listaAlumnosType);

            // 5. Mostrar los alumnos leídos
            System.out.println("Alumnos leídos desde el fichero:");
            for (Alumno a : lista) {
                System.out.println("- " + a.getNombre() + " (" + a.getEdad() + " años)");
            }

        } catch (IOException e) {
            // Si hay un error al leer el fichero, lo mostramos
            System.err.println("Error al leer el fichero JSON.");
            e.printStackTrace();
        }
    }
}
