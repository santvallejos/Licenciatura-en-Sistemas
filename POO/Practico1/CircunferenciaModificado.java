import java.util.Scanner; // Importamos la clase Scanner

/**
 * Modificar la clase Circunferencia para permitir que el usuario pueda calcular el perímetro de muchas
 * circunferencias, utilizando la estructura while. Modificar además el ingreso de datos, utilizando la clase
 * Scanner
 */
public class CircunferenciaModificado
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creamos un objeto Scanner

        int radio = 0;
        double perimetro = 0;

        while (radio != -1) {
            System.out.println("Ingrese el radio de la circunferencia: ");
            radio = sc.nextInt();

            if (radio != -1) {
                perimetro = 2 * Math.PI * radio;
                System.out.println("El perímetro de la circunferencia es: " + perimetro);
            }
        }
    }
}