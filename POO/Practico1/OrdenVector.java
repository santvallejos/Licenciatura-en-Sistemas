
/*9. Crear una clase denominada OrdenVector, que permita ingresar por teclado (Scanner) 4 elementos de tipo
doble, y almacenarlos en un array. Determinar el menor elemento y mostrarlo. Ordenar los elementos del
vector de menor a mayor. Mostrar los elementos ordenados, separados por un tabulador. Usar instrucción
FOR para el ingreso de datos. Utilizar método de la Burb */
import java.util.Scanner; // importamos la clase Scanner

public class OrdenVector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // creamos el objeto sc de la clase Scanner para el ingreso por teclado
        double[] elementos = new double[4];// creamos el array de tipo double con 4 elementos
        double menor = Double.MAX_VALUE;
        System.out.println("ingrese el array de elementos");

        for (int i = 0; i < 4; i++) {
            System.out.println("elemento" + (i + 1) + ": "); // mensaje de los elementos ingresados
            elementos[i] = sc.nextDouble();
            if (elementos[i] < menor) { // condicion para determinar el menor elemento
                menor = elementos[i];

            }

        }
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (elementos[i] > elementos[j]) { // ordenamos los elementos de menor a mayor
                    double temp = elementos[i]; // variable temporal para el intercambio
                    elementos[i] = elementos[j]; // asignamos el valor del elemento j al elemento i
                    elementos[j] = temp; // asignamos el valor del elemento i al elemento j
                }
            }

        }
        System.out.println("El menor elemento es: " + menor); // mostramos el menor elemento
        System.out.println("Los elementos ordenados de menor a mayor son: ");
        for (int i = 0; i < 4; i++) {
            System.out.println(elementos[i] + "\t"); // mostramos los elementos ordenados, separados por un tabulador
        }

    }
}