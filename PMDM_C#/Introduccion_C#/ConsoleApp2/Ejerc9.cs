class Ejerc9
{
    public static void Ejerc_9()
    {
        
            Console.WriteLine("{0,-10} {1,-5} {2,-10} {3,-10}", "Número", "|", "Cuadrado", "Cubo");
            Console.WriteLine("------------------------------------");

            // Bucle del 0 al 10
            for (int i = 0; i <= 10; i++)
            {
                int cuadrado = i * i;
                int cubo = i * i * i;

Console.WriteLine("{0,-10} {1,-5} {2,-10} {3,-10}", i, "|",  cuadrado, cubo);            }
        
    }
}