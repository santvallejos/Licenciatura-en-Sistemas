/**
 * Clase ejecutable para probar la funcionalidad de la clase Alumno.
 * Prueba simple de los métodos públicos principales.
 * 
 * @author Test - Sistema de Gestión Académica
 */
public class TestAlumno
{
    public static void main(String[] args)
    {
        System.out.println("=== PRUEBA DE LA CLASE ALUMNO ===\n");
        
        // Crear un alumno
        Alumno alumno = new Alumno(12345, "Pedro", "Gómez");
        
        // Mostrar alumno sin notas
        System.out.println("Alumno creado (sin notas):");
        alumno.mostrar();
        System.out.println();
        
        // Asignar notas
        alumno.setNota1(8.5);
        alumno.setNota2(7.8);
        
        // Mostrar alumno con notas
        System.out.println("Alumno con notas asignadas:");
        alumno.mostrar();
        System.out.println();
        
        // Probar métodos de concatenación y promedio
        System.out.println("Nombre y Apellido: " + alumno.nomYApe());
        System.out.println("Apellido y Nombre: " + alumno.apeYNom());
        System.out.println("Promedio: " + alumno.promedio());
        
        System.out.println("\n=== FIN DE LA PRUEBA ===");
    }
}
