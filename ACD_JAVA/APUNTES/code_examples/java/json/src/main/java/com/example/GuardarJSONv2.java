package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class GuardarJSONv2 {

    public static void main(String[] args) {
        // Scanner para leer datos desde teclado
        Scanner sc = new Scanner(System.in);

        // JSONArray que contendrá todos los objetos persona
        JSONArray listaPersonas = new JSONArray();

        System.out.println("Introduce personas (nombre y edad). Para terminar escribe 'fin' en el nombre.");

        // Pedimos el primer nombre fuera del bucle
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();

        // Mientras el usuario no escriba "fin", seguimos pidiendo datos
        while (!nombre.equalsIgnoreCase("fin")) {
            // Pedimos la edad asociada al nombre
            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine().trim());

            // Creamos un objeto JSON para cada persona
            JSONObject persona = new JSONObject();
            persona.put("nombre", nombre); // clave "nombre"
            persona.put("edad", edad);     // clave "edad"

            // Añadimos la persona al array de personas
            listaPersonas.put(persona);

            // Volvemos a pedir un nombre (puede ser otro o "fin" para terminar)
            System.out.print("Nombre: ");
            nombre = sc.nextLine().trim();
        }

        // Al salir del bucle comprobamos si se introdujeron personas
        if (listaPersonas.isEmpty()) {
            // Si el array está vacío → no se creó ninguna persona
            System.out.println("No se introdujo ninguna persona. No se creó el fichero.");
        } else {
            
           // Crear una carpeta data/ para ficheros generados
            File carpeta = new File("data");
            if (!carpeta.exists())
                carpeta.mkdir();


            // Si hay personas, las guardamos en el fichero JSON
            try (FileWriter file = new FileWriter("data/personas.json")) {
                // toString(4) genera un JSON con formato indentado (4 espacios)
                file.write(listaPersonas.toString(4));
                System.out.println("Fichero personas.json creado con éxito.");
            } catch (IOException e) {
                // En caso de error al escribir en disco
                e.printStackTrace();
            }
        }

        // Cerramos el Scanner
        sc.close();
    }
}
