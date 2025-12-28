/**
 * Clase ejecutable para probar la funcionalidad de la clase Laboratorio.
 * Prueba simple de los métodos públicos principales.
 * 
 * @author Test - Sistema de Gestión Farmacéutica
 */
public class TestLaboratorio
{
    public static void main(String[] args)
    {
        System.out.println("=== PRUEBA DE LA CLASE LABORATORIO ===\n");
        
        // Crear un laboratorio
        Laboratorio lab = new Laboratorio("Laboratorio Bayer", "Av. Corrientes 1234", "011-4567-8900", 5000, 3);
        
        // Mostrar información del laboratorio
        lab.mostrar();
        System.out.println();
        
        // Probar getters
        System.out.println("Nombre: " + lab.getNombre());
        System.out.println("Domicilio: " + lab.getDomicilio());
        System.out.println("Teléfono: " + lab.getTelefono());
        System.out.println("Compra Mínima: $" + lab.getCompraMinima());
        System.out.println("Día de Entrega: " + lab.getDiaEntrega());
        System.out.println();
        
        // Probar métodos de actualización
        System.out.println("Actualizando condiciones comerciales...");
        lab.nuevaCompraMinima(7500);
        lab.nuevoDiaEntrega(2);
        
        System.out.println("Condiciones actualizadas:");
        System.out.println("Compra Mínima: $" + lab.getCompraMinima());
        System.out.println("Día de Entrega: " + lab.getDiaEntrega());
        
        System.out.println("\n=== FIN DE LA PRUEBA ===");
    }
}
