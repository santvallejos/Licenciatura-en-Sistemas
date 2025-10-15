
import java.util.*;

/**
 * Clase ejecutable para simular el pintado de un jardín con figuras geométricas.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administracion
{
    public static void main(String[] args)
    {
        // Crear instancias de figuras geométricas
        ArrayList<FiguraGeometrica> figuras = new ArrayList<FiguraGeometrica>();
        
        // Agregar un rectángulo
        Rectangulo rectangulo = new Rectangulo(10.0, 5.0, 0, 0);
        figuras.add(rectangulo);
        
        // Agregar un círculo
        Punto centroCirculo = new Punto(5, 5);
        Circulo circulo = new Circulo(5, 5, 3.0, centroCirculo);
        figuras.add(circulo);
        
        // Agregar otro rectángulo
        Rectangulo rectangulo2 = new Rectangulo(8.0, 4.0, 10, 10);
        figuras.add(rectangulo2);
        
        // Crear el jardín
        Jardin jardin = new Jardin("Mi Jardín", figuras);
        
        // Mostrar detalle de las figuras
        System.out.println("Detalle de las figuras en el jardín:");
        jardin.detalleFiguras();
        
        // Mostrar cantidad de latas a comprar
        int latas = jardin.cuantasLatas();
        System.out.println("Cantidad de latas de pintura a comprar: " + latas);
    }
}