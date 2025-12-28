import java.util.Scanner;

/**
 * Clase ejecutable que simula las funciones de una secretaría escolar.
 * Permite al usuario ingresar datos por teclado para gestionar escuelas, 
 * docentes y la emisión de recibos de sueldo de forma interactiva.
 * 
 * @author Sistema POO
 * @version 1.0
 */
public class Secretaria {
    
    /**
     * Método principal que ejecuta el programa de forma interactiva.
     * Solicita al usuario ingresar datos para crear una escuela, un docente y emite un recibo de sueldo.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE SECRETARÍA ESCOLAR ===");
        System.out.println();
        
        // Solicitar datos del docente
        System.out.println("--- DATOS DEL DOCENTE ---");
        System.out.print("Ingrese nombre completo del docente: ");
        String nombreDocente = scanner.nextLine();
        
        System.out.print("Ingrese grado académico: ");
        String gradoDocente = scanner.nextLine();
        
        System.out.print("Ingrese sueldo básico: ");
        double sueldoBasico = scanner.nextDouble();
        
        System.out.print("Ingrese asignación familiar: ");
        double asignacionFamiliar = scanner.nextDouble();
        scanner.nextLine();
        
        // Crear instancia de Docente
        Docente docente1 = new Docente(nombreDocente, gradoDocente, sueldoBasico, asignacionFamiliar);
        
        // Solicitar datos de la escuela
        System.out.println("\n--- DATOS DE LA ESCUELA ---");
        System.out.print("Ingrese nombre de la escuela: ");
        String nombreEscuela = scanner.nextLine();
        
        System.out.print("Ingrese domicilio de la escuela: ");
        String domicilioEscuela = scanner.nextLine();
        
        System.out.print("Ingrese nombre del director: ");
        String nombreDirector = scanner.nextLine();
        
        // Crear instancia de Escuela
        Escuela escuela1 = new Escuela(nombreEscuela, domicilioEscuela, nombreDirector, docente1);
        
        // Mostrar información del docente
        System.out.println("\n=== INFORMACIÓN DEL DOCENTE ===");
        System.out.println("Nombre: " + docente1.getnombre());
        System.out.println("Grado: " + docente1.getgrado());
        System.out.println("Sueldo básico: $" + docente1.getsueldoBasico());
        System.out.println("Asignación familiar: $" + docente1.getasignacionFamiliar());
        System.out.println("Sueldo total calculado: $" + docente1.calcularSueldo());
        System.out.println();
        
        // Preguntar si desea emitir el recibo
        System.out.print("¿Desea emitir el recibo de sueldo? (s/n): ");
        String respuesta = scanner.nextLine().toLowerCase();
        
        if (respuesta.equals("s") || respuesta.equals("si")) {
            // Emitir el recibo
            System.out.println("\n=== RECIBO DE SUELDO ===");
            escuela1.ImprimirRecibo(docente1);
            System.out.println("\nRecibo emitido exitosamente por la Secretaría.");
        } else {
            System.out.println("\nOperación cancelada. No se emitió el recibo.");
        }
        
        System.out.println("\nGracias por utilizar el Sistema de Secretaría Escolar.");
        scanner.close();
    }
}
