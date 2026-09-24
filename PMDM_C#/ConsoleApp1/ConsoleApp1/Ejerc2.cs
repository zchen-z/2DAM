using System.ComponentModel;

namespace ConsoleApp1;

using System;


class Ejerc2
{
    public static void Ejerc_2()
    {
        string respuesta;
        float num;
        Console.Write("Introduce un numero: ");
        respuesta = Console.ReadLine();

        num = float.Parse(respuesta);

        if(num < 0)
        {
            Console.Write("Es negativo");
        }
        else
        {
            Console.Write("Es positivo");
        }
        
        
       
    }
}