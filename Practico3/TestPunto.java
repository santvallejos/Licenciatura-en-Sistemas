/**
 * Clase ejecutable para probar la funcionalidad de la clase Punto.
 * Demuestra la creación de puntos, desplazamientos y cálculo de distancias.
 * 
 * @author Sistema de Geometría
 */
public class TestPunto {
    
    /**
     * Método principal que ejecuta las pruebas de la clase Punto.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE LA CLASE PUNTO ===\n");
        
        // Crear punto por defecto (origen)
        System.out.println("1. Creando punto por defecto:");
        Punto puntoOrigen = new Punto();
        puntoOrigen.mostrar();
        System.out.println("Coordenadas: " + puntoOrigen.coordenadas());
        
        // Crear punto con coordenadas específicas
        System.out.println("\n2. Creando punto con coordenadas (3.5, 7.2):");
        Punto punto1 = new Punto(3.5, 7.2);
        punto1.mostrar();
        System.out.println("Coordenadas: " + punto1.coordenadas());
        
        // Desplazar punto
        System.out.println("\n3. Desplazando el punto 2.5 unidades en X y -1.8 unidades en Y:");
        punto1.desplazar(2.5, -1.8);
        punto1.mostrar();
        System.out.println("Nuevas coordenadas: " + punto1.coordenadas());
        
        // Crear otro punto para calcular distancia
        System.out.println("\n4. Creando segundo punto (10.0, 5.0):");
        Punto punto2 = new Punto(10.0, 5.0);
        punto2.mostrar();
        
        // Calcular distancia entre puntos
        System.out.println("\n5. Calculando distancia entre los puntos:");
        double distancia = punto1.distancia(punto2);
        System.out.printf("Distancia entre %s y %s: %.2f unidades\n", 
                         punto1.coordenadas(), punto2.coordenadas(), distancia);
        
        // Verificar distancia desde el segundo punto al primero
        double distanciaInversa = punto2.distancia(punto1);
        System.out.printf("Verificación (distancia inversa): %.2f unidades\n", distanciaInversa);
        
        // Crear y mostrar varios puntos desplazados
        System.out.println("\n6. Demostrando múltiples desplazamientos:");
        Punto puntoMovil = new Punto(0, 0);
        System.out.println("Punto inicial: " + puntoMovil.coordenadas());
        
        puntoMovil.desplazar(5, 3);
        System.out.println("Después de desplazar (5, 3): " + puntoMovil.coordenadas());
        
        puntoMovil.desplazar(-2, 4);
        System.out.println("Después de desplazar (-2, 4): " + puntoMovil.coordenadas());
        
        puntoMovil.desplazar(-3, -7);
        System.out.println("Después de desplazar (-3, -7): " + puntoMovil.coordenadas());
        
        System.out.println("\n=== FIN DE PRUEBAS ===");
    }
}
