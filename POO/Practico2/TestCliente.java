/**
 * Clase ejecutable para probar la funcionalidad de la clase Cliente.
 * Prueba simple de los métodos públicos principales.
 * 
 * @author Test - Sistema de Gestión Bancaria
 */
public class TestCliente
{
    public static void main(String[] args)
    {
        System.out.println("=== PRUEBA DE LA CLASE CLIENTE ===\n");
        
        // Crear un cliente
        Cliente cliente = new Cliente(12345678, "García", "Ana", 15000.50);
        
        // Mostrar información inicial
        System.out.println("Cliente creado:");
        cliente.mostrar();
        System.out.println();
        
        // Probar métodos de concatenación
        System.out.println("Apellido y Nombre: " + cliente.apeYnom());
        System.out.println("Nombre y Apellido: " + cliente.nomYape());
        System.out.println();
        
        // Probar operaciones con saldo
        System.out.println("Saldo inicial: $" + cliente.getSaldo());
        cliente.agregaSaldo(2500.75);
        System.out.println("Después de agregar $2500.75: $" + cliente.getSaldo());
        
        cliente.nuevoSaldo(20000.00);
        System.out.println("Después de establecer nuevo saldo $20000.00: $" + cliente.getSaldo());
        
        System.out.println("\n=== FIN DE LA PRUEBA ===");
    }
}
