/* Lectura */
package com.example;



import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class LeerJSONv1 {
    public static void main(String[] args) {
        // Ruta del fichero 
        String ruta = "data/persona.json";

        try (FileReader reader = new FileReader(ruta)) {
            // JSONTokener convierte el flujo de caracteres en datos JSON
            JSONTokener tokener = new JSONTokener(reader);

            // Creamos el objeto JSONObject a partir del fichero
            JSONObject obj = new JSONObject(tokener);

            // Accedemos a las claves
            String nombre = obj.getString("nombre");
            int edad = obj.getInt("edad");

            // Mostrar por consola
            System.out.println("Contenido del JSON:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);

        } catch (IOException e) {
            System.err.println("Error al leer el fichero JSON: " + e.getMessage());
        }
    }
}

