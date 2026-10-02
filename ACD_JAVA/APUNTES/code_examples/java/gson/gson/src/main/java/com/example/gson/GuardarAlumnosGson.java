package com.example.gson;

// Importamos la clase Alumno del paquete model
import com.example.model.Alumno;

// Importamos Gson y GsonBuilder
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// Importamos clases de E/S y colecciones
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejemplo con Gson:
 * - Crear varios objetos Alumno
 * - Guardarlos en un fichero JSON dentro del directorio "data"
 */
public class GuardarAlumnosGson {
    public static void main(String[] args) {

        // 1. Crear una lista de alumnos
        List<Alumno> lista = new ArrayList<>();
        lista.add(new Alumno("Ana", 20));
        lista.add(new Alumno("Luis", 22));
        lista.add(new Alumno("Marta", 19));

        // 2. Crear un objeto Gson con formato bonito
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // 3. Definir ruta del fichero JSON en la carpeta "data"
        File directorio = new File("src/main/data");
        if (!directorio.exists()) {
            directorio.mkdirs(); // crea la carpeta si no existe
        }

        File fichero = new File(directorio, "alumnos.json");

        // 4. Guardar la lista en el fichero
        try (FileWriter writer = new FileWriter(fichero)) {
            gson.toJson(lista, writer); // convierte lista -> JSON y escribe en fichero
            System.out.println("Fichero creado en: " + fichero.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
