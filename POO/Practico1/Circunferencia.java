/**
 * 3. Crear una clase ejecutable denominada “Circunferencia”, en la que se calcule el perímetro de una
 * circunferencia, ingresando el radio de tipo entero a través del argumento del main().
 */
public class Circunferencia
{
    public static void main(String[] args){ 
        int radio = Integer.parseInt(args[0]);

        double perimetro = 2 * Math.PI * radio; /* Ocupamos Java.lang que contiene la clase Math que contiene el valor de PI */

        System.out.println("El perímetro de la circunferencia es: " + perimetro);
    }
}