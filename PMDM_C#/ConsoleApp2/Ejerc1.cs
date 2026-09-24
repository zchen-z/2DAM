class Ejerc1
{
    public static void Ejercicio_1()
    {
        Console.WriteLine("--- NÚMEROS IMPARES ENTRE 0 Y 100 ---");
        
        for (int i = 1; i <= 100; i += 2)
        {
            Console.Write($"{i} ");
        }
        Console.WriteLine();

        Console.WriteLine("--- NÚMEROS PARES ENTRE 0 Y 100 ---");
        
        for (int i = 0; i <= 100; i += 2)
        {
            Console.Write($"{i} ");
        }
        Console.WriteLine();
    }
}