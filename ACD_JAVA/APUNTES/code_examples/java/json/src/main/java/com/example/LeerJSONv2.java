/*Lee un JSONArray de personas*/
package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class LeerJSONv2 {

    // Ruta del fichero JSON 
    private static final Path RUTA_JSON = Path.of("data/personas.json");

    public static void main(String[] args) {
        // 1) Comprobaciones previas: existencia y tamaño > 0
        if (!Files.exists(RUTA_JSON)) {
            System.err.println("No existe el fichero: " + RUTA_JSON.toAbsolutePath());
            return;
        }
        try {
            if (Files.size(RUTA_JSON) == 0) {
                System.err.println("El fichero está vacío: " + RUTA_JSON.toAbsolutePath());
                return;
            }
        } catch (IOException e) {
            System.err.println("No se pudo comprobar el tamaño del fichero: " + e.getMessage());
            return;
        }

        // 2) Lectura con BufferedReader y UTF-8 (buena práctica)
        try (BufferedReader br = Files.newBufferedReader(RUTA_JSON, StandardCharsets.UTF_8)) {
            // 3) El tokener interpretará el flujo de texto como JSON
            JSONTokener tokener = new JSONTokener(br);
            /*
            * JSONTokener es una clase de la librería org.json.
            * Su función es leer un flujo de texto carácter a carácter y convertirlo 
            * en tokens JSON (objetos, arrays, claves, valores…).
            */


            // 4) La raíz puede ser un array de objetos o un objeto único
            Object raiz = tokener.nextValue();

            if (raiz instanceof JSONArray) {
                procesarArray((JSONArray) raiz);
            } else if (raiz instanceof JSONObject) {
                procesarObjetoUnico((JSONObject) raiz);
            } else {
                System.err.println("El contenido del JSON no es un objeto ni un array válido.");
            }

        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        } catch (JSONException e) {
            System.err.println("El contenido no es un JSON válido: " + e.getMessage());
        }
    }

    /**
     * Procesa un array JSON con forma:
     * [
     *   {"nombre":"Ana","edad":25},
     *   {"nombre":"Luis","edad":30}
     * ]
     */
    private static void procesarArray(JSONArray array) {
        if (array.isEmpty()) {
            System.out.println("El fichero JSON contiene un array vacío.");
            return;
        }

        int totalValidas = 0;
        int sumaEdades = 0;

        System.out.println("Listado de personas leídas de " + RUTA_JSON.toAbsolutePath() + ":");

        // Bucle básico sin 'continue': se resuelve cada caso en un if/else
        for (int i = 0, n = array.length(); i < n; i++) {
            Object entrada = array.get(i);

            // Validar que cada elemento sea un objeto JSON
            if (!(entrada instanceof JSONObject)) {
                System.out.println(" - Entrada " + i + " ignorada: no es un objeto JSON.");
            } else {
                JSONObject persona = (JSONObject) entrada;

                // Extracción segura de campos
                String nombre = persona.optString("nombre", null);

                // Edad: validar existencia y tipo entero
                Integer edad = null;
                if (persona.has("edad")) {
                    try {
                        edad = persona.getInt("edad");
                    } catch (JSONException e) {
                        edad = null; // la clave existe pero no es un entero válido
                    }
                }

                // Reglas mínimas de validación
                boolean nombreValido = (nombre != null && !nombre.isBlank());
                boolean edadValida = (edad != null && edad >= 0);

                if (!nombreValido || !edadValida) {
                    System.out.println(" - Entrada " + i + " inválida o incompleta: " + persona);
                } else {
                    // Caso válido: mostrar y acumular
                    System.out.println(" - " + nombre + " (" + edad + " años)");
                    totalValidas++;
                    sumaEdades += edad;
                }
            }
        }

        // Resumen final
        if (totalValidas == 0) {
            System.out.println("No se encontraron personas válidas en el fichero.");
        } else {
            double media = (double) sumaEdades / totalValidas;
            System.out.printf("Total: %d  |  Edad media: %.2f%n", totalValidas, media);
        }
    }

    /**
     * Procesa el caso alternativo con un único objeto JSON:
     * {"nombre":"Ana","edad":25}
     */
    private static void procesarObjetoUnico(JSONObject obj) {
        String nombre = obj.optString("nombre", null);

        Integer edad = null;
        if (obj.has("edad")) {
            try {
                edad = obj.getInt("edad");
            } catch (JSONException e) {
                edad = null;
            }
        }

        boolean nombreValido = (nombre != null && !nombre.isBlank());
        boolean edadValida = (edad != null && edad >= 0);

        if (!nombreValido || !edadValida) {
            System.out.println("Objeto único inválido o incompleto: " + obj);
        } else {
            System.out.println("Se encontró un único objeto:");
            System.out.println(" - " + nombre + " (" + edad + " años)");
        }
    }
}
