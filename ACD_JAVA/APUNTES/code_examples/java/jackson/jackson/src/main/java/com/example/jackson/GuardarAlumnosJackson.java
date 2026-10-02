package com.example.jackson;

import com.example.model.Alumno;
// Librerías de Jackson
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejemplo con Jackson:
 * - Crear varios objetos Alumno
 * - Guardarlos en un fichero JSON dentro del directorio "data"
 */
public class GuardarAlumnosJackson {
    public static void main(String[] args) {
        // 1. Crear lista de alumnos
        List<Alumno> lista = new ArrayList<>();
        lista.add(new Alumno("Ana", 20));
        lista.add(new Alumno("Luis", 22));
        lista.add(new Alumno("Marta", 19));

        // 2. Crear el ObjectMapper (clase principal de Jackson)
        ObjectMapper mapper = new ObjectMapper();

        // 3. Preparar el directorio "data"
        File directorio = new File("src/main/data");
        if (!directorio.exists()) {
            directorio.mkdirs(); // Crear carpeta si no existe
        }

        // 4. Definir el fichero donde se guardará el JSON
        File fichero = new File(directorio, "alumnos_jackson.json");

        try {
            // 5. Crear un escritor con formato bonito (pretty printing)
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

            // 6. Convertir la lista de alumnos en JSON y escribir en el fichero
            writer.writeValue(fichero, lista);

            System.out.println("Fichero creado en: " + fichero.getAbsolutePath());

        } catch (IOException e) {
            // Capturamos errores de E/S
            System.err.println("Error al guardar el fichero JSON.");
            e.printStackTrace();
        }
    }
}
