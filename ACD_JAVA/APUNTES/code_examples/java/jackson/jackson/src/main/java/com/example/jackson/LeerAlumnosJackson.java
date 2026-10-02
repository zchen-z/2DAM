package com.example.jackson;

import com.example.model.Alumno;
// Librerías de Jackson
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Ejemplo con Jackson:
 * - Leer un fichero JSON desde el directorio "data"
 * - Convertirlo en una lista de objetos Alumno
 * - Mostrar los alumnos leídos por consola
 */
public class LeerAlumnosJackson {
    public static void main(String[] args) {
        // 1. Crear el ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // 2. Definir el fichero JSON a leer
        File fichero = new File("src/main/data/alumnos_jackson.json");

        try {
            // 3. Leer el fichero y deserializar JSON → Lista<Alumno>
            // Usamos TypeReference para manejar colecciones genéricas
            List<Alumno> lista = mapper.readValue(fichero, new TypeReference<List<Alumno>>() {});

            // 4. Mostrar alumnos leídos
            System.out.println("Alumnos leídos desde Jackson:");
            for (Alumno a : lista) {
                System.out.println("- " + a.getNombre() + " (" + a.getEdad() + " años)");
            }

        } catch (IOException e) {
            // Capturamos errores de lectura
            System.err.println("Error al leer el fichero JSON.");
            e.printStackTrace();
        }
    }
}
