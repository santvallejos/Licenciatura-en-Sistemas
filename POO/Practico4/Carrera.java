import java.util.*;

/**
 * Sistema de gestión de cursos con menú interactivo
 * 
 * @author Sistema ejecutable para cursos
 * @version 2.0
 */
public class Carrera {
    private static Scanner scanner = new Scanner(System.in);
    private static Curso curso = null;
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE CURSOS ===");
        
        // Crear curso por defecto
        curso = new Curso("Programación Orientada a Objetos", new HashMap<>());
        System.out.println("✓ Curso '" + curso.getNombre() + "' creado automáticamente.");
        
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 8);
        
        scanner.close();
    }
    
    /**
     * Muestra el menú principal del sistema
     */
    private static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("           MENÚ PRINCIPAL");
        System.out.println("       Curso: " + curso.getNombre());
        System.out.println("========================================");
        System.out.println("1. Crear e inscribir alumno");
        System.out.println("2. Mostrar alumnos inscriptos");
        System.out.println("3. Buscar alumno por LU");
        System.out.println("4. Asignar notas a alumno");
        System.out.println("5. Mostrar promedio de alumno");
        System.out.println("6. Dar de baja alumno");
        System.out.println("7. Verificar si alumno está inscripto");
        System.out.println("8. Salir");
        System.out.println("========================================");
        System.out.print("Ingrese su opción (1-8): ");
    }
    
    /**
     * Lee y valida la opción ingresada por el usuario
     */
    private static int leerOpcion() {
        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            if (opcion < 1 || opcion > 8) {
                System.out.println("Error: Opción no válida. Ingrese un número entre 1 y 8.");
                return leerOpcion();
            }
            return opcion;
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un número válido.");
            return leerOpcion();
        }
    }
    
    /**
     * Procesa la opción seleccionada por el usuario
     */
    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearEInscribirAlumno();
                break;
            case 2:
                mostrarAlumnosInscriptos();
                break;
            case 3:
                buscarAlumnoPorLU();
                break;
            case 4:
                asignarNotasAlumno();
                break;
            case 5:
                mostrarPromedioAlumno();
                break;
            case 6:
                darDeBajaAlumno();
                break;
            case 7:
                verificarAlumnoInscripto();
                break;
            case 8:
                System.out.println("\n¡Gracias por usar el sistema! Hasta luego.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
    
    /**
     * Crea un nuevo alumno e inscribirlo al curso
     */
    private static void crearEInscribirAlumno() {
        System.out.println("\n--- CREAR E INSCRIBIR ALUMNO ---");
        
        System.out.print("Ingrese el número de libreta universitaria: ");
        int lu;
        try {
            lu = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: El número de LU debe ser un número entero válido.");
            return;
        }
        
        // Verificar si el alumno ya está inscripto
        if (curso.estaInscripto(lu)) {
            System.out.println("Error: Ya existe un alumno con LU " + lu + " inscripto en el curso.");
            return;
        }
        
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = scanner.nextLine();
        
        Alumno nuevoAlumno = new Alumno(lu, nombre, apellido);
        curso.inscribirAlumno(nuevoAlumno);
        
        System.out.println("✓ Alumno " + nuevoAlumno.apeYNom() + " (LU: " + lu + ") inscripto exitosamente.");
    }
    
    /**
     * Muestra todos los alumnos inscriptos en el curso
     */
    private static void mostrarAlumnosInscriptos() {
        System.out.println("\n--- ALUMNOS INSCRIPTOS ---");
        if (curso.cantidadDeAlumnos() == 0) {
            System.out.println("No hay alumnos inscriptos en el curso.");
        } else {
            curso.mostarInscriptos();
        }
    }
    
    /**
     * Busca y muestra un alumno por su LU
     */
    private static void buscarAlumnoPorLU() {
        System.out.println("\n--- BUSCAR ALUMNO ---");
        System.out.print("Ingrese el número de LU del alumno a buscar: ");
        
        int lu;
        try {
            lu = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: El número de LU debe ser un número entero válido.");
            return;
        }
        
        Alumno alumno = curso.buscarAlumno(lu);
        if (alumno != null) {
            System.out.println("\n--- INFORMACIÓN DEL ALUMNO ---");
            alumno.mostrar();
        } else {
            System.out.println("No se encontró un alumno con LU " + lu);
        }
    }
    
    /**
     * Asigna notas a un alumno específico
     */
    private static void asignarNotasAlumno() {
        System.out.println("\n--- ASIGNAR NOTAS ---");
        System.out.print("Ingrese el número de LU del alumno: ");
        
        int lu;
        try {
            lu = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: El número de LU debe ser un número entero válido.");
            return;
        }
        
        Alumno alumno = curso.buscarAlumno(lu);
        if (alumno == null) {
            System.out.println("No se encontró un alumno con LU " + lu);
            return;
        }
        
        System.out.println("Alumno encontrado: " + alumno.apeYNom());
        
        try {
            System.out.print("Ingrese la primera nota: ");
            double nota1 = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Ingrese la segunda nota: ");
            double nota2 = Double.parseDouble(scanner.nextLine());
            
            alumno.setNota1(nota1);
            alumno.setNota2(nota2);
            
            System.out.println("✓ Notas asignadas correctamente a " + alumno.apeYNom());
            System.out.println("Nota 1: " + nota1 + ", Nota 2: " + nota2 + ", Promedio: " + alumno.promedio());
        } catch (NumberFormatException e) {
            System.out.println("Error: Las notas deben ser números válidos.");
        }
    }
    
    /**
     * Muestra el promedio de un alumno específico
     */
    private static void mostrarPromedioAlumno() {
        System.out.println("\n--- PROMEDIO DEL ALUMNO ---");
        System.out.print("Ingrese el número de LU del alumno: ");
        
        int lu;
        try {
            lu = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: El número de LU debe ser un número entero válido.");
            return;
        }
        
        curso.imprimirPromedioDelAlumno(lu);
    }
    
    /**
     * Da de baja un alumno del curso
     */
    private static void darDeBajaAlumno() {
        System.out.println("\n--- DAR DE BAJA ALUMNO ---");
        System.out.print("Ingrese el número de LU del alumno a dar de baja: ");
        
        int lu;
        try {
            lu = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: El número de LU debe ser un número entero válido.");
            return;
        }
        
        Alumno alumnoEliminado = curso.quitarAlumno(lu);
        if (alumnoEliminado != null) {
            System.out.println("✓ Alumno " + alumnoEliminado.apeYNom() + " (LU: " + lu + ") dado de baja exitosamente.");
        } else {
            System.out.println("No se encontró un alumno con LU " + lu + " para dar de baja.");
        }
    }
    
    /**
     * Verifica si un alumno está inscripto en el curso
     */
    private static void verificarAlumnoInscripto() {
        System.out.println("\n--- VERIFICAR INSCRIPCIÓN ---");
        System.out.print("Ingrese el número de LU del alumno: ");
        
        int lu;
        try {
            lu = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: El número de LU debe ser un número entero válido.");
            return;
        }
        
        if (curso.estaInscripto(lu)) {
            Alumno alumno = curso.buscarAlumno(lu);
            System.out.println("✓ El alumno " + alumno.apeYNom() + " (LU: " + lu + ") SÍ está inscripto en el curso.");
        } else {
            System.out.println("✗ No hay ningún alumno con LU " + lu + " inscripto en el curso.");
        }
    }
}