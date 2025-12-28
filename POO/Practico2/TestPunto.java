/**
 * Clase ejecutable para probar la funcionalidad de la clase Punto.
 * Prueba simple de los métodos públicos principales.
 * 
 * @author Test - Sistema de Geometría
 */
public class TestPunto
{
    public static void main(String[] args)
    {
        System.out.println("=== PRUEBA DE LA CLASE PUNTO ===\n");
        
        // Crear un punto
        Punto punto = new Punto(3.5, 2.8);
        
        // Mostrar información del punto
        System.out.print("Punto inicial: ");
        punto.mostrar();
        
        // Probar método coordenadas
        System.out.println("Coordenadas: " + punto.coordenadas());
        
        // Probar getters
        System.out.println("X: " + punto.getX());
        System.out.println("Y: " + punto.getY());
        System.out.println();
        
        // Probar desplazamiento
        System.out.println("Desplazando punto (2.0, -1.5)...");
        punto.desplazar(2.0, -1.5);
        System.out.print("Punto después del desplazamiento: ");
        punto.mostrar();
        
        System.out.println("\n=== FIN DE LA PRUEBA ===");
    }
}
