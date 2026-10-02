package com.example.gson;
import com.example.model.Alumno;
import com.google.gson.Gson;

public class DemoGson {
    public static void main(String[] args) {
        // 1. Crear un objeto Alumno
        Alumno alumno = new Alumno("Ana", 20);

        // 2. Crear el objeto Gson
        Gson gson = new Gson();

        // 3. Convertir objeto Java → JSON
        String json = gson.toJson(alumno);
        System.out.println("Objeto en JSON: " + json);
        // Salida: {"nombre":"Ana","edad":20}

        // 4. Convertir JSON → objeto Java
        String jsonEntrada = "{\"nombre\":\"Luis\",\"edad\":30}";
        Alumno alumno2 = gson.fromJson(jsonEntrada, Alumno.class);
        System.out.println("Objeto desde JSON: " 
            + alumno2.getNombre() + " - " + alumno2.getEdad());
        // Salida: Objeto desde JSON: Luis - 30
    }
}
