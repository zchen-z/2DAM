class Ejerc3
{
    public static void Ejerc_3()
    {
        string respuesta;
        Console.Write("Introduce un numero: ");
        
        if (int.TryParse(Console.ReadLine(), out int numero))
        {

        if(numero % 2 == 0)
        {
            Console.Write("Es par");
        }
        else
        {
            Console.Write("Es impar");
        }
        }
        else
        {
            Console.WriteLine("Numero invalido. vuelva a intentarlo");
        }
    }
}