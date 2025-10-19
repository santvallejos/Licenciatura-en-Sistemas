
import java.util.*;

/**
 * Clase ejecutable para simular el pintado de un jardín con figuras geométricas.
 * Permite al usuario agregar diferentes figuras de forma interactiva mediante un menú.
 * 
 * @author Sistema de Gestión de Jardines
 * @version 2.0
 */
public class Administracion
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        ArrayList<FiguraGeometrica> figuras = new ArrayList<FiguraGeometrica>();
        String nombreJardin;
        int opcion;
        
        System.out.println("===========================================");
        System.out.println("  SISTEMA DE PRESUPUESTO PARA JARDÍN");
        System.out.println("===========================================\n");
        
        System.out.print("Ingrese el nombre del jardín: ");
        nombreJardin = teclado.nextLine();
        
        do {
            mostrarMenu();
            opcion = leerOpcion(teclado);
            
            switch (opcion) {
                case 1:
                    agregarCuadrado(teclado, figuras);
                    break;
                case 2:
                    agregarRectangulo(teclado, figuras);
                    break;
                case 3:
                    agregarTriangulo(teclado, figuras);
                    break;
                case 4:
                    agregarCirculo(teclado, figuras);
                    break;
                case 5:
                    agregarElipse(teclado, figuras);
                    break;
                case 6:
                    if (figuras.isEmpty()) {
                        System.out.println("\n¡No hay figuras agregadas aún!");
                    } else {
                        Jardin jardin = new Jardin(nombreJardin, figuras);
                        System.out.println();
                        jardin.detalleFiguras();
                    }
                    break;
                case 7:
                    if (figuras.isEmpty()) {
                        System.out.println("\n¡No se agregaron figuras!");
                        System.out.println("¡Gracias por usar el sistema!");
                    } else {
                        System.out.println("\n===========================================");
                        System.out.println("         PRESUPUESTO FINAL");
                        System.out.println("===========================================\n");
                        Jardin jardin = new Jardin(nombreJardin, figuras);
                        jardin.detalleFiguras();
                        System.out.println("\n¡Gracias por usar el sistema!");
                    }
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente nuevamente.");
            }
            
            if (opcion != 7) {
                System.out.println("\nPresione ENTER para continuar...");
                teclado.nextLine();
            }
            
        } while (opcion != 7);
        
        teclado.close();
    }
    
    /**
     * Muestra el menú principal de opciones.
     */
    private static void mostrarMenu()
    {
        System.out.println("\n===========================================");
        System.out.println("              MENÚ PRINCIPAL");
        System.out.println("===========================================");
        System.out.println("1. Agregar Cuadrado");
        System.out.println("2. Agregar Rectángulo");
        System.out.println("3. Agregar Triángulo");
        System.out.println("4. Agregar Círculo");
        System.out.println("5. Agregar Elipse");
        System.out.println("6. Ver presupuesto actual");
        System.out.println("7. Finalizar y mostrar presupuesto");
        System.out.println("===========================================");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Lee y valida la opción ingresada por el usuario.
     */
    private static int leerOpcion(Scanner teclado)
    {
        int opcion = 0;
        try {
            opcion = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            opcion = 0;
        }
        return opcion;
    }
    
    /**
     * Agrega un cuadrado al jardín.
     */
    private static void agregarCuadrado(Scanner teclado, ArrayList<FiguraGeometrica> figuras)
    {
        System.out.println("\n--- Agregar Cuadrado ---");
        try {
            System.out.print("Ingrese el lado del cuadrado: ");
            double lado = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Ingrese coordenada X del origen: ");
            int x = Integer.parseInt(teclado.nextLine());
            
            System.out.print("Ingrese coordenada Y del origen: ");
            int y = Integer.parseInt(teclado.nextLine());
            
            Cuadrado cuadrado = new Cuadrado(x, y, lado);
            figuras.add(cuadrado);
            System.out.println("✓ Cuadrado agregado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("✗ Error: Debe ingresar valores numéricos válidos.");
        }
    }
    
    /**
     * Agrega un rectángulo al jardín.
     */
    private static void agregarRectangulo(Scanner teclado, ArrayList<FiguraGeometrica> figuras)
    {
        System.out.println("\n--- Agregar Rectángulo ---");
        try {
            System.out.print("Ingrese el ancho del rectángulo: ");
            double ancho = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Ingrese el alto del rectángulo: ");
            double alto = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Ingrese coordenada X del origen: ");
            int x = Integer.parseInt(teclado.nextLine());
            
            System.out.print("Ingrese coordenada Y del origen: ");
            int y = Integer.parseInt(teclado.nextLine());
            
            Rectangulo rectangulo = new Rectangulo(ancho, alto, x, y);
            figuras.add(rectangulo);
            System.out.println("✓ Rectángulo agregado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("✗ Error: Debe ingresar valores numéricos válidos.");
        }
    }
    
    /**
     * Agrega un triángulo al jardín.
     */
    private static void agregarTriangulo(Scanner teclado, ArrayList<FiguraGeometrica> figuras)
    {
        System.out.println("\n--- Agregar Triángulo ---");
        try {
            System.out.print("Ingrese la base del triángulo: ");
            double base = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Ingrese la altura del triángulo: ");
            double altura = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Ingrese coordenada X del origen: ");
            double x = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Ingrese coordenada Y del origen: ");
            double y = Double.parseDouble(teclado.nextLine());
            
            Triangulo triangulo = new Triangulo(x, y, base, altura);
            figuras.add(triangulo);
            System.out.println("✓ Triángulo agregado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("✗ Error: Debe ingresar valores numéricos válidos.");
        }
    }
    
    /**
     * Agrega un círculo al jardín.
     */
    private static void agregarCirculo(Scanner teclado, ArrayList<FiguraGeometrica> figuras)
    {
        System.out.println("\n--- Agregar Círculo ---");
        try {
            System.out.print("Ingrese el radio del círculo: ");
            double radio = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Ingrese coordenada X del centro: ");
            double x = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Ingrese coordenada Y del centro: ");
            double y = Double.parseDouble(teclado.nextLine());
            
            Punto centro = new Punto(x, y);
            Circulo circulo = new Circulo(x, y, radio, centro);
            figuras.add(circulo);
            System.out.println("✓ Círculo agregado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("✗ Error: Debe ingresar valores numéricos válidos.");
        }
    }
    
    /**
     * Agrega una elipse al jardín.
     */
    private static void agregarElipse(Scanner teclado, ArrayList<FiguraGeometrica> figuras)
    {
        System.out.println("\n--- Agregar Elipse ---");
        try {
            System.out.print("Ingrese el semieje mayor: ");
            double sEjeMayor = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Ingrese el semieje menor: ");
            double sEjeMenor = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Ingrese coordenada X del centro: ");
            double x = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Ingrese coordenada Y del centro: ");
            double y = Double.parseDouble(teclado.nextLine());
            
            Elipse elipse = new Elipse(x, y, sEjeMayor, sEjeMenor);
            figuras.add(elipse);
            System.out.println("✓ Elipse agregada exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("✗ Error: Debe ingresar valores numéricos válidos.");
        }
    }
}