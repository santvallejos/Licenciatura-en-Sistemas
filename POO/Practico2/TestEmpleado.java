/**
 * Clase ejecutable para probar la funcionalidad de la clase Empleado.
 * Prueba simple de los métodos públicos principales.
 * 
 * @author Test - Sistema de Recursos Humanos
 */
public class TestEmpleado
{
    public static void main(String[] args)
    {
        System.out.println("=== PRUEBA DE LA CLASE EMPLEADO ===\n");
        
        // Crear un empleado
        Empleado empleado = new Empleado(20123456789L, "Rodríguez", "Carmen", 85000.0, 2020);
        
        // Mostrar información completa
        empleado.mostrar();
        System.out.println();
        
        // Probar métodos de concatenación
        System.out.println("Nombre y Apellido: " + empleado.nomYApe());
        System.out.println("Apellido y Nombre: " + empleado.apeYNom());
        System.out.println();
        
        // Probar métodos de cálculo
        System.out.println("Antigüedad: " + empleado.antiguedad() + " años");
        System.out.println("Sueldo Básico: $" + empleado.getSueldoBasico());
        System.out.println("Sueldo Neto: $" + empleado.sueldoNeto());
        System.out.println();
        
        // Mostrar en formato de línea
        System.out.println("Formato línea: " + empleado.mostrarLinea());
        
        System.out.println("\n=== FIN DE LA PRUEBA ===");
    }
}
