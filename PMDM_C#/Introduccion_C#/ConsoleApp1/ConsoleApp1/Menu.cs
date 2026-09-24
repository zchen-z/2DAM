using ConsoleApp1;

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
                    Ejerc1.Ejerc_1();
                    break;
                case 2:
                    Ejerc2.Ejerc_2();
                    break;
                case 3:
                Ejerc3.Ejerc_3();
                    break;
                case 4:
                Ejerc4.Ejerc_4();
                break;
                case 5:
                Ejerc5.Ejerc_5();
                    break;
                case 6:
                Ejerc6.Ejerc_6();
                    break;
                case 7:
                Ejerc7.Ejerc_7();
                break;
                case 8:
                Ejerc8.Ejerc_8();
                break;
                case 9:
                Ejerc9.Ejerc_9();
                break;
                case 10:
                Ejerc10.Ejerc_10();
                break;

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


