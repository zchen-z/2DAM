using System.ComponentModel;

namespace ConsoleApp1;

using System; 

class Ejerc1
{
    public static void Ejerc_1()
    {
        Console.WriteLine("Hello, World!");

        string respuesta;
   
        float numero = 0, resultado = 0; 

        Console.Write("Introduce un numero: ");
        respuesta = Console.ReadLine();
        
        while (!float.TryParse(respuesta, out numero) || numero < 0)
        {
            Console.Write("Error. Introduzca un numero positivo: ");
            respuesta = Console.ReadLine();
        }
        
        resultado = (float)Math.Sqrt(numero);
        
        Console.WriteLine("Raiz de su numero: " + resultado);
    }
}



