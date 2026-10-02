package com.example.model;

public class Alumno {
    private String nombre;
    private int edad;

    // Constructor vacío (obligatorio para Gson al deserializar)
    public Alumno() {}

    // Constructor
    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    @Override
    public String toString() {
        return "Alumno{nombre='" + nombre + "', edad=" + edad + "}";
    }
}
