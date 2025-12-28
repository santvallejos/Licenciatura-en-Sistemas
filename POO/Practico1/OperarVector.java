
/*Crear una clase denominada OperarVector que permita ingresar por teclado (Scanner) 5 notas de alumnos, las
que serán almacenadas en un array de enteros. Calcular el promedio y determinar la mayor nota. El promedio
debe permitir resultado con decimales (aplicar cast a los elementos enteros cuando sea necesario para obtener
dicho resultado). Mostrar los elementos ingresados, separados por un tabulador. Mostrar el promedio y la
mayor nota con el mensaje respectivo */
import java.util.Scanner; // importamos la clase Scanner 

public class OperarVector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // creamos el objeto sc de la clase Scanner para el ingreso por teclado
        int[] notas = new int[5]; // creamos el array de tipo entero con 5 elementos
        int suma = 0;
        int mayor = 0;
        double promedio = 0.0;

        System.out.println("ingrese las notas de los alumnos"); // ingreso de las notas

        for (int i = 0; i < 5; i++) // bucle para el ingreso de las notas
        {
            System.out.print("Nota " + (i + 1) + ": "); // utilizamos (i+1) para que empieze las notas desde 1 y no
                                                        // desde 0
            notas[i] = sc.nextInt();
            suma = suma + notas[i]; // acumulador de la suma de las notas
            if (notas[i] > mayor) { // condicion para determinar la mayor nota
                mayor = notas[i];
            }
        }

        promedio = (double) suma / notas.length; // calculamos el promedio, y casteamos la asignacion de valor suma para
                                                 // que sea de un valor double

        System.out.println("Las notas ingresadas son: "); // mensaje de las notas ingresadas

        for (int i = 0; i < notas.length; i++) {
            System.out.println(notas[i] + "\t"); // mostramos las notas ingresadas, separadas por un tabulador
        }
        
        System.out.println("Promedio: " + promedio); // mostramos el promedio de notas
        System.out.println("Mayor nota: " + mayor); // mostramos la mayor nota
    }
}