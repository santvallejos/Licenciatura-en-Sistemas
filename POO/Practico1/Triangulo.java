
/**
 * Crear clase ejecutable “Triangulo”, declarar las variables a, b y c de tipo double, que corresponden a los lados
 * de un triángulo. Los valores deben ser ingresados por teclado como argumentos del método main(). Calcular y
 * mostrar el semiperímetro y el área del triángulo.
 * semiperimetro= (a+b+c)/2
 * area= raíz cuadrada(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c))
 */
public class Triangulo
{
    public static void main(String[] args){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        double semiperimetro = (a + b + c) / 2;
        double area = Math.sqrt(semiperimetro * (semiperimetro - a) * (semiperimetro - b) * (semiperimetro - c));
        System.out.println("El semiperímetro del triángulo es: " + semiperimetro);
        System.out.println("El área del triángulo es: " + area);
    }
}