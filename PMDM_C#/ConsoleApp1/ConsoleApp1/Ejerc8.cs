class Ejerc8
{
    public static void Ejerc_8()
    {
        int mayoresQueCero = 0;
        int menoresQueCero = 0;

        Console.WriteLine("Introduce 10 números:");

        for (int i = 1; i <= 10; i++)
        {
            Console.Write($"Número {i}: ");

            if (double.TryParse(Console.ReadLine(), out double numero))
            {
                if (numero > 0)
                {
                    mayoresQueCero++;
                }
                else if (numero < 0)
                {
                    menoresQueCero++;
                }
            }
            else
            {
                Console.WriteLine("Entrada no válida. Por favor, introduce un número.");
                i--;
                Console.WriteLine("\n--- Resultados ---");
                Console.WriteLine($"Cantidad de números mayores que cero: {mayoresQueCero}");
                Console.WriteLine($"Cantidad de números menores que cero: {menoresQueCero}");
            }
        }
    }
}