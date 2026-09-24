class Ejerc5
{
    public static void Ejerc_5()
    {
        Console.Write("Introduce la nota del examen (0 al 10): ");
        
        if (double.TryParse(Console.ReadLine(), out double nota))
        {
            if (nota >= 0 && nota <= 10)
            {
                switch (nota)
                {
                    case < 5:
                        Console.WriteLine("Categoría: Suspenso");
                        break;
                    case < 7:
                        Console.WriteLine("Categoría: Aprobado");
                        break;
                    case < 9:
                        Console.WriteLine("Categoría: Notable");
                        break;
                    default:
                        Console.WriteLine("Categoría: Sobresaliente");
                        break;
                }
            }
            else
            {
                Console.WriteLine("Error: La nota debe estar entre 0 y 10.");
            }
        }
        else
        {
            Console.WriteLine("Entrada inválida. Por favor, introduce un número.");
        }
    }
}