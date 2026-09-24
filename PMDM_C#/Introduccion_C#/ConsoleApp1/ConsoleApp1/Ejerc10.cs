using System.Text;

class Ejerc10
{
    public static void Ejerc_10()
    {
        String entrada;
        String[] letras = ["a", "e", "i", "o", "u"];

        Console.WriteLine("Caracter: ");
        entrada = Console.ReadLine();

        if (string.IsNullOrWhiteSpace(entrada) || (entrada.Length)!=1)
        {
            Console.WriteLine("La entrada es nula, vacía o tine mas de un caracter.");
        }
        else
        {
            char caracter = entrada[0];
            if (letras.Contains(entrada))
            {
                Console.WriteLine("La letra es una vocal");
            }
            else
            {
                Console.WriteLine("La letra es un consonante");

            }

            if (char.IsUpper(caracter))
            {
                Console.WriteLine("La letra es Mayuscula");
                
            }else if (char.IsLower(caracter))
            {
                Console.WriteLine("La letra es Minuscula");
            }
        }


    }
}