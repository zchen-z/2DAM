package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public class GuardarJSONv1 {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject(); // Crea un objeto JSON vacío en memoria. Es como un diccionario clave–valor.
        obj.put("nombre", "Ana"); // Añade al JSON la clave "nombre" con valor "Ana".
        obj.put("edad", 25);// Añade otra clave "edad" con valor 25.

        // El objeto en memoria sería: {"nombre":"Ana","edad":25}

        // Crear una carpeta data/ para ficheros generados
        File carpeta = new File("data");
        if (!carpeta.exists())
            carpeta.mkdir();

        try (FileWriter file = new FileWriter("data/persona.json")) {
            // Abre un flujo de escritura (FileWriter) hacia un fichero llamado
            // persona.json.
            // Si el fichero no existe → lo crea. Si existe → lo sobreescribe.
            file.write(obj.toString(4)); // Convierte el JSONObject a un String en formato JSON. 4 = indenta con 4
                                         // espacios
            System.out.println("Fichero persona.json creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
