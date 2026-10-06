package exercises.util;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import exercises.modelo.Empleado;

public class Controller {
    /**
     * Pide datos de empleados una y otra vez hasta que el usuario
     * diga que no quiere continuar.
     */
    public static void darDeAltaEmpleados(List<Empleado> empleados)
            throws IOException {
        boolean continuar = true;
        while (continuar) {
            System.out.println("--- Nuevo empleado ---");
            String dni = Lector.leerTextoNoVacio("DNI: ");
            String nombre = Lector.leerTextoNoVacio("Nombre: ");
            LocalDate fechaAlta = Lector.leerFechaIso("Fecha de alta (yyyy-MM-dd): ");
            double salario = Lector.leerDoubleNoNegativo("Salario mensual: ");
            boolean activo = Lector.leerSiNo("¿Activo? (s/n): ");

            empleados.add(new Empleado(dni, nombre, fechaAlta, salario, activo));
            System.out.println("Empleado añadido. Total en memoria: " + empleados.size());

            continuar = Lector.leerSiNo("¿Quieres dar de alta otro empleado? (s/n): ");
        }
    }
}
