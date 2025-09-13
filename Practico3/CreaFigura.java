import java.util.Scanner;

/**
 * Clase ejecutable para crear y probar figuras geométricas de forma interactiva.
 * Permite al usuario ingresar datos por teclado para crear círculos y rectángulos,
 * realizar operaciones y comparaciones entre las figuras.
 * 
 * @author Sistema de Geometría
 */
public class CreaFigura {
    
    /**
     * Método principal que ejecuta las pruebas de círculos y rectángulos de forma interactiva.
     * Solicita al usuario ingresar datos para crear figuras geométricas y realizar operaciones.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CREACIÓN DE FIGURAS GEOMÉTRICAS ===\n");
        
        // ========== CREACIÓN DE CÍRCULOS ==========
        System.out.println("*** CÍRCULOS ***\n");
        
        // Crear primer círculo
        System.out.println("--- PRIMER CÍRCULO ---");
        System.out.print("Ingrese coordenada X del centro: ");
        double x1 = scanner.nextDouble();
        System.out.print("Ingrese coordenada Y del centro: ");
        double y1 = scanner.nextDouble();
        System.out.print("Ingrese radio del círculo: ");
        double radio1 = scanner.nextDouble();
        
        Circulo circulo1 = new Circulo(radio1, new Punto(x1, y1));
        System.out.println("\n1. Círculo creado:");
        circulo1.caracteristicas();
        
        // Preguntar si desea desplazar el círculo
        System.out.print("\n¿Desea desplazar el círculo? (s/n): ");
        scanner.nextLine();
        String respuesta = scanner.nextLine().toLowerCase();
        
        if (respuesta.equals("s") || respuesta.equals("si")) {
            System.out.print("Ingrese desplazamiento en X: ");
            double despX = scanner.nextDouble();
            System.out.print("Ingrese desplazamiento en Y: ");
            double despY = scanner.nextDouble();
            
            System.out.println("\n2. Desplazando el círculo:");
            circulo1.desplazar(despX, despY);
            circulo1.caracteristicas();
        }
        
        // Crear segundo círculo
        System.out.println("\n--- SEGUNDO CÍRCULO ---");
        System.out.print("Ingrese coordenada X del centro: ");
        double x2 = scanner.nextDouble();
        System.out.print("Ingrese coordenada Y del centro: ");
        double y2 = scanner.nextDouble();
        System.out.print("Ingrese radio del círculo: ");
        double radio2 = scanner.nextDouble();
        
        Circulo circulo2 = new Circulo(radio2, new Punto(x2, y2));
        System.out.println("\n3. Segundo círculo creado:");
        circulo2.caracteristicas();
        
        // Comparar círculos
        System.out.println("\n4. Comparando círculos - El mayor es:");
        Circulo circuloMayor = circulo1.elMayor(circulo2);
        circuloMayor.caracteristicas();
        
        // Mostrar distancia entre círculos
        System.out.println("\n5. Distancia entre los centros de los círculos:");
        double distanciaCirculos = circulo1.distanciaA(circulo2);
        System.out.printf("Distancia: %.2f unidades\n", distanciaCirculos);
        
        System.out.println("\n" + "=".repeat(50));
        
        // ========== CREACIÓN DE RECTÁNGULOS ==========
        System.out.println("\n*** RECTÁNGULOS ***\n");
        
        // Crear primer rectángulo
        System.out.println("--- PRIMER RECTÁNGULO ---");
        System.out.print("Ingrese coordenada X del origen: ");
        double xRect1 = scanner.nextDouble();
        System.out.print("Ingrese coordenada Y del origen: ");
        double yRect1 = scanner.nextDouble();
        System.out.print("Ingrese ancho del rectángulo: ");
        double ancho1 = scanner.nextDouble();
        System.out.print("Ingrese alto del rectángulo: ");
        double alto1 = scanner.nextDouble();
        
        Rectangulo rectangulo1 = new Rectangulo(new Punto(xRect1, yRect1), ancho1, alto1);
        System.out.println("\n1. Rectángulo creado:");
        rectangulo1.caracteristicas();
        
        // Preguntar si desea desplazar el rectángulo
        System.out.print("\n¿Desea desplazar el rectángulo? (s/n): ");
        scanner.nextLine();
        String respuesta2 = scanner.nextLine().toLowerCase();
        
        if (respuesta2.equals("s") || respuesta2.equals("si")) {
            System.out.print("Ingrese desplazamiento en X: ");
            double despXRect = scanner.nextDouble();
            System.out.print("Ingrese desplazamiento en Y: ");
            double despYRect = scanner.nextDouble();
            
            System.out.println("\n2. Desplazando el rectángulo:");
            rectangulo1.desplazar(despXRect, despYRect);
            rectangulo1.caracteristicas();
        }
        
        // Crear segundo rectángulo
        System.out.println("\n--- SEGUNDO RECTÁNGULO ---");
        System.out.print("Ingrese coordenada X del origen: ");
        double xRect2 = scanner.nextDouble();
        System.out.print("Ingrese coordenada Y del origen: ");
        double yRect2 = scanner.nextDouble();
        System.out.print("Ingrese ancho del rectángulo: ");
        double ancho2 = scanner.nextDouble();
        System.out.print("Ingrese alto del rectángulo: ");
        double alto2 = scanner.nextDouble();
        
        Rectangulo rectangulo2 = new Rectangulo(new Punto(xRect2, yRect2), ancho2, alto2);
        System.out.println("\n3. Segundo rectángulo creado:");
        rectangulo2.caracteristicas();
        
        // Comparar rectángulos
        System.out.println("\n4. Comparando rectángulos - El mayor es:");
        Rectangulo rectanguloMayor = rectangulo1.elMayor(rectangulo2);
        rectanguloMayor.caracteristicas();
        
        // Mostrar distancia entre rectángulos
        System.out.println("\n5. Distancia entre los orígenes de los rectángulos:");
        double distanciaRectangulos = rectangulo1.distanciaA(rectangulo2);
        System.out.printf("Distancia: %.2f unidades\n", distanciaRectangulos);
        
        // Resumen final
        System.out.println("\n" + "=".repeat(50));
        System.out.println("*** RESUMEN FINAL ***");
        System.out.printf("• Círculo mayor tiene una superficie de: %.2f unidades²\n", circuloMayor.superficie());
        System.out.printf("• Rectángulo mayor tiene una superficie de: %.2f unidades²\n", rectanguloMayor.superficie());
        System.out.printf("• Distancia entre círculos: %.2f unidades\n", distanciaCirculos);
        System.out.printf("• Distancia entre rectángulos: %.2f unidades\n", distanciaRectangulos);
        
        System.out.println("\n=== FIN DE CREACIÓN DE FIGURAS ===");
        scanner.close();
    }
}
