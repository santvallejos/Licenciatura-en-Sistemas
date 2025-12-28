import java.util.Scanner;

/**
 * Clase ejecutable que demuestra el funcionamiento básico del sistema hospitalario.
 * Permite crear un hospital, paciente con localidades y mostrar los datos filiatorios
 * mediante un menú sencillo con validaciones para verificar las funcionalidades básicas.
 * 
 * @author Sistema Hospitalario Integral
 * @version 1.0
 */
public class GestionHospital {
    
    /**
     * Método principal que ejecuta el sistema hospitalario con menú interactivo.
     * Permite crear hospitales y pacientes con validaciones apropiadas.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Variables para almacenar los objetos
        Hospital hospital = null;
        Paciente paciente = null;
        String[] datosHospital = null;
        
        System.out.println("=== SISTEMA HOSPITALARIO - GESTIÓN COMPLETA ===");
        System.out.println();
        
        // Menú principal
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear Hospital");
            System.out.println("2. Crear Paciente");
            System.out.println("3. Mostrar datos filiatorios oficiales");
            System.out.println("4. Mostrar datos del paciente");
            System.out.println("5. Mostrar cadena de datos resumida");
            System.out.println("6. Mostrar información de localidades");
            System.out.println("7. Mostrar datos del hospital");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    datosHospital = obtenerDatosHospital(scanner);
                    System.out.println("✓ Datos del hospital guardados. Puede crear un paciente ahora.");
                    break;
                    
                case 2:
                    if (datosHospital == null) {
                        System.out.println("❌ ERROR: Debe crear un hospital primero.");
                    } else {
                        hospital = crearPacienteYHospital(scanner, datosHospital);
                        paciente = hospital.getPaciente();
                        System.out.println("✓ Paciente y hospital creados exitosamente.");
                    }
                    break;
                    
                case 3:
                    if (hospital == null || paciente == null) {
                        System.out.println("❌ ERROR: Debe crear un hospital y un paciente primero.");
                    } else {
                        System.out.println("\n=== DATOS FILIATORIOS OFICIALES ===");
                        hospital.consultaDatosFiliatorios(paciente);
                    }
                    break;
                    
                case 4:
                    if (paciente == null) {
                        System.out.println("❌ ERROR: Debe crear un paciente primero.");
                    } else {
                        System.out.println("\n=== DATOS DEL PACIENTE ===");
                        paciente.mostrarDatosPantalla();
                    }
                    break;
                    
                case 5:
                    if (paciente == null) {
                        System.out.println("❌ ERROR: Debe crear un paciente primero.");
                    } else {
                        System.out.println("\n=== CADENA DE DATOS RESUMIDA ===");
                        System.out.println(paciente.cadenaDeDatos());
                    }
                    break;
                    
                case 6:
                    if (paciente == null) {
                        System.out.println("❌ ERROR: Debe crear un paciente primero.");
                    } else {
                        System.out.println("\n=== INFORMACIÓN DE LOCALIDADES ===");
                        System.out.println("Nacimiento: " + paciente.getNacido().mostrar());
                        System.out.println("Residencia: " + paciente.getVive().mostrar());
                    }
                    break;
                    
                case 7:
                    if (hospital == null) {
                        System.out.println("❌ ERROR: Debe crear un hospital primero.");
                    } else {
                        System.out.println("\n=== DATOS DEL HOSPITAL ===");
                        System.out.println("Hospital: " + hospital.getNombreHospital());
                        System.out.println("Director: " + hospital.getNombreDirector());
                    }
                    break;
                    
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                    
                default:
                    System.out.println("❌ Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
        
        System.out.println("Gracias por utilizar el Sistema Hospitalario.");
        scanner.close();
    }
    
    /**
     * Método auxiliar para crear un hospital.
     * Solicita los datos necesarios al usuario y crea una instancia de Hospital temporal.
     * 
     * @param scanner Scanner para entrada de datos
     * @return Array con los datos del hospital [nombreHospital, nombreDirector]
     */
    private static String[] obtenerDatosHospital(Scanner scanner) {
        System.out.println("\n--- CREANDO HOSPITAL ---");
        System.out.print("Ingrese nombre del hospital: ");
        String nombreHospital = scanner.nextLine();
        
        System.out.print("Ingrese nombre del director: ");
        String nombreDirector = scanner.nextLine();
        
        return new String[]{nombreHospital, nombreDirector};
    }
    
    /**
     * Método auxiliar para crear un paciente con localidades y actualizar el hospital.
     * Solicita todos los datos necesarios y crea el hospital con el paciente asociado.
     * 
     * @param scanner Scanner para entrada de datos
     * @param datosHospital Array con los datos del hospital [nombre, director]
     * @return Hospital creado con el paciente asociado
     */
    private static Hospital crearPacienteYHospital(Scanner scanner, String[] datosHospital) {
        System.out.println("\n--- CREANDO PACIENTE ---");
        
        // Solicitar datos de localidad de nacimiento
        System.out.println("\n-- Localidad de Nacimiento --");
        System.out.print("Ingrese localidad de nacimiento: ");
        String localidadNac = scanner.nextLine();
        
        System.out.print("Ingrese provincia de nacimiento: ");
        String provinciaNac = scanner.nextLine();
        
        Localidad localidadNacimiento = new Localidad(localidadNac, provinciaNac);
        
        // Solicitar datos de localidad de residencia
        System.out.println("\n-- Localidad de Residencia --");
        System.out.print("¿Vive en la misma localidad donde nació? (s/n): ");
        String mismaLocalidad = scanner.nextLine().toLowerCase();
        
        Localidad localidadResidencia;
        if (mismaLocalidad.equals("s") || mismaLocalidad.equals("si")) {
            localidadResidencia = localidadNacimiento;
            System.out.println("✓ Usando la misma localidad para residencia.");
        } else {
            System.out.print("Ingrese localidad donde vive: ");
            String localidadRes = scanner.nextLine();
            
            System.out.print("Ingrese provincia donde vive: ");
            String provinciaRes = scanner.nextLine();
            
            localidadResidencia = new Localidad(localidadRes, provinciaRes);
        }
        
        // Solicitar datos del paciente
        System.out.println("\n-- Datos del Paciente --");
        System.out.print("Ingrese número de historia clínica: ");
        int historiaClinica = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();
        
        System.out.print("Ingrese domicilio: ");
        String domicilio = scanner.nextLine();
        
        // Crear el paciente
        Paciente paciente = new Paciente(historiaClinica, nombrePaciente, domicilio, 
                                       localidadNacimiento, localidadResidencia);
        
        // Crear el hospital con el paciente asociado
        Hospital hospital = new Hospital(datosHospital[0], datosHospital[1], paciente);
        
        return hospital;
    }
}
