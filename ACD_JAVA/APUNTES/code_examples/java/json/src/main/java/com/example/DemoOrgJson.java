package com.example;

import org.json.JSONObject;

public class DemoOrgJson {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject(); //se crea el objeto JSON en memoria vacío. Piensa en un diccionario clave:valor vacío
        obj.put("nombre", "Ana"); //Añadimos la clave "nombre" y el valor "Ana" Internamente el JSON sería {"nombre": "Ana"}
        obj.put("edad", 25); //Añadimos la clave "edad" y el valor 25Internamente el JSON sería {"nombre": "Ana", "edad": 25}

        System.out.println("JSON: " + obj.toString()); //Convierte el objeto JSONObject a texto (formato JSON) y lo imprime.

        // Acceso
        String nombre = obj.getString("nombre"); //Recupera el valor de la clave "nombre".
        int edad = obj.getInt("edad"); //Recupera el valor de la clave "edad".
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }
}
