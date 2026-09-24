class Ejerc0
{
    public static void Ejerc_0()
    {
        for (int i = 10; i >= 1; i--)
        {
            Console.WriteLine($"{i}...");
            Thread.Sleep(1000);
        }

        Console.ForegroundColor = ConsoleColor.Green;
        Console.WriteLine("\nEl cohete ha sido lanzado con éxito.");
        Console.ResetColor(); 
    }
}
