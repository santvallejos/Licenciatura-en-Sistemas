
/**
 * Crear una clase denominada TrianguloRectangulo, en la que se determine si un triangulo es rectángulo
 * (Teorema de Pitágoras → h2 = cateto12 + cateto22). Los lados se deben ingresar por teclado, utilizando el
 * argumento del main().
 * Nota: probar con hipotenusa = 5; cateto1 = 3; cateto2 = 4;
 */
public class TrianguloRectangulo
{
    public static void main(String[] args)
    {
        double hipotenusa = Double.parseDouble(args[0]);
        double cateto1 = Double.parseDouble(args[1]);
        double cateto2 = Double.parseDouble(args[2]);

        if(hipotenusa * hipotenusa == (cateto1 * cateto1) + (cateto2 * cateto2))
        {
            System.out.println("El triangulo es rectangulo");
        }
        else
        {
            System.out.println("El triangulo no es rectangulo");
        }
    }
}