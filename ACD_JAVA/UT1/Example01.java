package UT1;

import java.io.File;

/**
 * Example01
 * Ejemplo de uso de metodos de la clase File
 * @author Yo
 * @version 1.0
 */
public class Example01 {
    public static void main(String[] args) {

        /*new File no crea ningun fichero en disco.
        Solo crea un objeto Java que representa un ruta
        Rutas:
        relativas: "datos"
        absoluta: c:\\datos o /home/alumno/datos */

        File ruta = new File("datos.txt");
        /*comprobar si existe la ruta qeu acabamos de crear */
        if(!ruta.exists()){
            System.out.println("La ruta no existe");
            System.out.println("Ruta buscada " + ruta.getAbsolutePath());
        }else{
            System.out.println("Nombre: " + ruta.getName());
            System.out.println("Ruta: " + ruta.getPath());
            System.out.println("Ruta absoluta: " + ruta.getAbsolutePath());
            System.out.println("Directorio Padre: " + ruta.getParent());

            if(ruta.isFile()){
                System.out.println("Tipo:  FICHERO");
                System.out.println("Tamaño: " + ruta.length() + " bytes");
            }

            if(ruta.isDirectory()){
                System.out.println("Tipo: DIRECTORIO");
                File[] contenido = ruta.listFiles();

                if(contenido!= null){
                    System.out.println("----- COntnido del dierectorio -----");
                    for (File elemento : contenido) {
                        if (elemento.isDirectory()){
                            System.out.println("[DIR] " + elemento.getName());
                        }else if(elemento.isFile()){
                            System.out.println("[FICHERO] " + elemento.getName() + " - " + elemento.length() + "bytes");
                            System.out.println("Permiso de lectuta: " + elemento.canRead());
                            System.out.println("Permiso de escritura: " + elemento.canWrite());
                            System.out.println("Permiso de ejecucion: " + elemento.canExecute());
                        }
                    }
                }
            }
        }

    }
}