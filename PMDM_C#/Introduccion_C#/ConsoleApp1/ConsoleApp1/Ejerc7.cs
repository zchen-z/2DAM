class Ejerc7
{
    public static void Ejerc_7()
    {
        Console.Write("Introduce un número entero: ");
        
        if (int.TryParse(Console.ReadLine(), out int numero))
        {
            int[] divisores = { 2, 3, 5, 7, 11 };

            foreach (int d in divisores)
            {
                if (numero % d == 0)
                {
                    Console.WriteLine($"- Es divisible por {d}.");
                }
                else
                {
                    Console.WriteLine($"- NO es divisible por {d}.");
                }
            }
        }
        else
        {
            Console.WriteLine("Error: Introduce un número entero válido.");
        }
    }
}