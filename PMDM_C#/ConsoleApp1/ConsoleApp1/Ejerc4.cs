class Ejerc4
{
    public static void Ejerc_4()
    {
        bool ok = false;
        while (!ok)
        {
            Console.Write("Introduce el primer número (dividendo): ");
        if (double.TryParse(Console.ReadLine(), out double num1))
        {
            Console.Write("Introduce el segundo número (divisor): ");
            if (double.TryParse(Console.ReadLine(), out double num2))
            {
                if (num2 != 0)
                {
                    double resultado = num1 / num2;

                    if (resultado % 1 == 0)
                    {
                        Console.WriteLine($"El resultado es un número entero: {(int)resultado}");
                        ok = true;
                    }
                    else
                    {
                        Console.WriteLine($"El resultado es un número decimal: {resultado}");
                        ok = true;
                    }
                }
                else
                {
                    Console.WriteLine("Error: No se puede dividir entre cero.");
                }
            }
            else
            {
                Console.WriteLine("Entrada inválida en el segundo número. Debe ser numérico.");
            }
        }
        else
        {
            Console.WriteLine("Entrada inválida en el primer número. Debe ser numérico.");
        }
        }
        
    }
    
}