class Menu
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Menu (22 para salir): ");
        Console.WriteLine("------------------------------------------------------------ ");
        
        bool termiando = false;

        while (!termiando)
        {
            Console.WriteLine();
            Console.WriteLine("Opcion: ");
            if (int.TryParse(Console.ReadLine(), out int numero))
        {
            switch (numero)
            {
                case 1:
                Ejerc0.Ejerc_0();
                break;

                case 2:
                Ejerc1.Ejercicio_1();
                break;
                    
                case 9:
                    Ejerc9.Ejerc_9();
                    break;
                case 3:
                
                case 4:
                
                case 5:
                
                case 6:
                
                case 7:
               
                case 8:
               
                case 10:
            

                default:
                    Console.WriteLine("Opcion no valida");
                    break;

            }
            }
            else
            {
                Console.WriteLine("Numero invalido. vuelva a intentarlo");
        }
            }
    }
}