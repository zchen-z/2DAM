package com.example.model;


public class Alumno {
    // Atributos privados
    private String nombre;
    private int edad;

    // Constructor vacío (necesario para librerías como Gson y Jackson al deserializar)
    public Alumno() {
    }

    // Constructor con parámetros
    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para edad
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método toString para mostrar el alumno de forma legible
    @Override
    public String toString() {
        return "Alumno{nombre='" + nombre + "', edad=" + edad + "}";
    }
}
