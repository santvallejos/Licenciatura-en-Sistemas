import java.util.*;

/**
 * La clase ArrayDePuntos se debe resolver utilizando cast al recuperar elementos
 * 
 * @author Sistema de array de puntos 
 * @version 1.0
 */
public class ArrayDePuntos
{
    public static void main(String[] args)
    {
        // defininir el arraya de los 6 puntos
        Punto[] puntos = new Punto[6];

        // crear un scanner para leer por teclado
        Scanner scanner = new Scanner(System.in);

        // recorrer el array y pedir los datos por teclado
        for (int i = 0; i < puntos.length; i++)
        {
            System.out.println("Ingrese la coordenada x del punto " + (i + 1) + ": ");
            double x = scanner.nextDouble();
            System.out.println("Ingrese la coordenada y del punto " + (i + 1) + ": ");
            double y = scanner.nextDouble();
            puntos[i] = new Punto(x, y);
        }

        // imprimir las coordenadas de cada punto
        for (int i = 0; i < puntos.length; i++)
        {
            System.out.println("Coordenadas del punto " + (i + 1) + ": " + puntos[i].getX() + ", " + puntos[i].getY());
        }

        // imprimir la distancia entre puntos consecutivos
        for (int i = 0; i < puntos.length - 1; i++)
        {
            System.out.println("Distancia entre punto " + (i + 1) + " y punto " + (i + 2) + ": " + puntos[i].distancia(puntos[i + 1]));
        }
        scanner.close();
    }
}