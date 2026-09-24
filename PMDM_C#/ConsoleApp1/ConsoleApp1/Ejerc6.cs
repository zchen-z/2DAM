class Ejerc6
{
    public static void Ejerc_6()
    {
       Console.Write("Introduce el primer número: ");
        if (double.TryParse(Console.ReadLine(), out double num1))
        {
            Console.Write("Introduce el segundo número: ");
            if (double.TryParse(Console.ReadLine(), out double num2))
            {
                Console.Write("Introduce el tercer número: ");
                if (double.TryParse(Console.ReadLine(), out double num3))
                {
                    double intermedio;

                    if ((num1 >= num2 && num1 <= num3) || (num1 <= num2 && num1 >= num3))
                    {
                        intermedio = num1;
                    }
                    else if ((num2 >= num1 && num2 <= num3) || (num2 <= num1 && num2 >= num3))
                    {
                        intermedio = num2;
                    }
                    else
                    {
                        intermedio = num3;
                    }

                    Console.WriteLine($"El número con el valor intermedio es: {intermedio}");
                }
                else
                {
                    Console.WriteLine("Error: El tercer valor debe ser un número válido.");
                }
            }
            else
            {
                Console.WriteLine("Error: El segundo valor debe ser un número válido.");
            }
        }
        else
        {
            Console.WriteLine("Error: El primer valor debe ser un número válido.");
        }
    }
}
