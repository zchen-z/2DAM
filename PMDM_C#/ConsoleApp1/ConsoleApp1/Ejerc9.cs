class Ejerc9
{
    public static void Ejerc_9()
    {
        Console.Write("Introduce el día actual (1-31): ");
        int dia = int.Parse(Console.ReadLine());

        Console.Write("Introduce el mes actual (1-12): ");
        int mes = int.Parse(Console.ReadLine());

        Console.Write("Introduce el año actual: ");
        int anio = int.Parse(Console.ReadLine());

        int diasDelMes = 0;

        switch (mes)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diasDelMes = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diasDelMes = 30;
                break;
            case 2:
                diasDelMes = 28; // Febrero fijo en 28 días
                break;
            default:
                Console.WriteLine("Mes no válido.");
                break;
        }

        if (dia < 1 || dia > diasDelMes)
        {
            Console.WriteLine($"Fecha inválida. El mes {mes} solo tiene {diasDelMes} días.");
        }
        else
        {
            int mananaDia = dia + 1;
            int mananaMes = mes;
            int mananaAnio = anio;

            if (mananaDia > diasDelMes)
            {
                mananaDia = 1;      
                mananaMes++;       

                if (mananaMes > 12)
                {
                    mananaMes = 1;  
                    mananaAnio++;  
                }
            }

            Console.WriteLine($"\nMañana será: {mananaDia:D2}/{mananaMes:D2}/{mananaAnio}");
        }
    }


}