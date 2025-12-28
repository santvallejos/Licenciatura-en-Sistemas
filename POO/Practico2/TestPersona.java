/**
 * Clase ejecutable para probar la funcionalidad de la clase Persona.
 * Prueba simple de los métodos públicos principales.
 * 
 * @author Test - Sistema de Gestión de Personas
 */
public class TestPersona
{
    public static void main(String[] args)
    {
        System.out.println("=== PRUEBA DE LA CLASE PERSONA ===\n");
        
        // Crear una persona
        Persona persona = new Persona(12345678, "Juan", "Pérez", 1990);
        
        // Mostrar información completa
        persona.mostrar();
        System.out.println();
        
        // Probar métodos de concatenación
        System.out.println("Nombre y Apellido: " + persona.nomYApe());
        System.out.println("Apellido y Nombre: " + persona.apeYNom());
        System.out.println("Edad: " + persona.edad() + " años");
        
        System.out.println("\n=== FIN DE LA PRUEBA ===");
    }
}
