import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase ejecutable que demuestra el funcionamiento del sistema de empleados con jefe.
 * Permite gestionar empleados, asignar jefes y emitir permisos de salida
 * firmados por el jefe correspondiente.
 * 
 * @author Sistema de Recursos Humanos
 * @version 1.0
 */
public class GestionEmpleados {
    
    /**
     * Método principal que ejecuta el sistema de gestión de empleados interactivo.
     * Permite crear empleados, asignar jefes y emitir permisos de salida.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE GESTIÓN DE EMPLEADOS ===");
        System.out.println();
        
        // Primero crear un jefe (empleado sin jefe asignado)
        System.out.println("--- DATOS DEL JEFE/SUPERVISOR ---");
        System.out.print("Ingrese CUIL del jefe: ");
        long cuilJefe = scanner.nextLong();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese apellido del jefe: ");
        String apellidoJefe = scanner.nextLine();
        
        System.out.print("Ingrese nombre del jefe: ");
        String nombreJefe = scanner.nextLine();
        
        System.out.print("Ingrese sueldo básico del jefe: ");
        double sueldoJefe = scanner.nextDouble();
        
        System.out.print("Ingrese año de ingreso del jefe: ");
        int anioIngresoJefe = scanner.nextInt();
        
        System.out.print("Ingrese mes de ingreso del jefe (1-12): ");
        int mesIngresoJefe = scanner.nextInt();
        
        System.out.print("Ingrese día de ingreso del jefe: ");
        int diaIngresoJefe = scanner.nextInt();
        
        Calendar fechaIngresoJefe = new GregorianCalendar(anioIngresoJefe, mesIngresoJefe - 1, diaIngresoJefe);
        
        // Crear el jefe
        EmpleadoConJefe jefe = new EmpleadoConJefe(cuilJefe, apellidoJefe, nombreJefe, 
                                                  sueldoJefe, fechaIngresoJefe);
        
        // Crear un empleado subordinado
        System.out.println("\n--- DATOS DEL EMPLEADO ---");
        System.out.print("Ingrese CUIL del empleado: ");
        long cuilEmpleado = scanner.nextLong();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese apellido del empleado: ");
        String apellidoEmpleado = scanner.nextLine();
        
        System.out.print("Ingrese nombre del empleado: ");
        String nombreEmpleado = scanner.nextLine();
        
        System.out.print("Ingrese sueldo básico del empleado: ");
        double sueldoEmpleado = scanner.nextDouble();
        
        System.out.print("Ingrese año de ingreso del empleado: ");
        int anioIngresoEmpleado = scanner.nextInt();
        
        System.out.print("Ingrese mes de ingreso del empleado (1-12): ");
        int mesIngresoEmpleado = scanner.nextInt();
        
        System.out.print("Ingrese día de ingreso del empleado: ");
        int diaIngresoEmpleado = scanner.nextInt();
        
        Calendar fechaIngresoEmpleado = new GregorianCalendar(anioIngresoEmpleado, 
                                                             mesIngresoEmpleado - 1, 
                                                             diaIngresoEmpleado);
        
        // Crear el empleado con su jefe asignado
        EmpleadoConJefe empleado = new EmpleadoConJefe(cuilEmpleado, apellidoEmpleado, nombreEmpleado, 
                                                      sueldoEmpleado, fechaIngresoEmpleado, jefe);
        
        // Mostrar información de los empleados
        System.out.println("\n=== INFORMACIÓN DE EMPLEADOS ===");
        System.out.println("\n--- JEFE/SUPERVISOR ---");
        jefe.mostrar();
        
        System.out.println("\n--- EMPLEADO ---");
        empleado.mostrar();
        
        if (empleado.getJefe() != null) {
            System.out.println("Jefe asignado: " + empleado.getJefe().nomYApe());
        }
        
        // Menú de opciones
        int opcion;
        do {
            System.out.println("\n=== MENÚ DE OPCIONES ===");
            System.out.println("1. Mostrar información completa");
            System.out.println("2. Emitir permiso de salida");
            System.out.println("3. Mostrar datos en formato línea");
            System.out.println("4. Comparar sueldos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    mostrarInformacionCompleta(jefe, empleado);
                    break;
                    
                case 2:
                    emitirPermisoSalida(empleado, scanner);
                    break;
                    
                case 3:
                    System.out.println("\n=== DATOS EN FORMATO LÍNEA ===");
                    System.out.println("Jefe: " + jefe.mostrarLinea());
                    System.out.println("Empleado: " + empleado.mostrarLinea());
                    break;
                    
                case 4:
                    compararSueldos(jefe, empleado);
                    break;
                    
                case 0:
                    System.out.println("Gracias por utilizar el Sistema de Gestión de Empleados.");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
        
        scanner.close();
    }
    
    /**
     * Muestra información completa de ambos empleados.
     * 
     * @param jefe Empleado que actúa como jefe
     * @param empleado Empleado subordinado
     */
    private static void mostrarInformacionCompleta(EmpleadoConJefe jefe, EmpleadoConJefe empleado) {
        System.out.println("\n=== INFORMACIÓN COMPLETA DE EMPLEADOS ===");
        
        System.out.println("\n--- JEFE/SUPERVISOR ---");
        System.out.println("CUIL: " + jefe.getCuil());
        System.out.println("Nombre: " + jefe.nomYApe());
        System.out.println("Antigüedad: " + jefe.antiguedad() + " años");
        System.out.println("Sueldo básico: $" + jefe.getSueldoBasico());
        System.out.println("Sueldo neto: $" + jefe.sueldoNeto());
        System.out.println("Fecha de ingreso: " + 
                          jefe.getAnioIngreso().get(Calendar.DAY_OF_MONTH) + "/" +
                          (jefe.getAnioIngreso().get(Calendar.MONTH) + 1) + "/" +
                          jefe.getAnioIngreso().get(Calendar.YEAR));
        
        System.out.println("\n--- EMPLEADO ---");
        System.out.println("CUIL: " + empleado.getCuil());
        System.out.println("Nombre: " + empleado.nomYApe());
        System.out.println("Antigüedad: " + empleado.antiguedad() + " años");
        System.out.println("Sueldo básico: $" + empleado.getSueldoBasico());
        System.out.println("Sueldo neto: $" + empleado.sueldoNeto());
        System.out.println("Fecha de ingreso: " + 
                          empleado.getAnioIngreso().get(Calendar.DAY_OF_MONTH) + "/" +
                          (empleado.getAnioIngreso().get(Calendar.MONTH) + 1) + "/" +
                          empleado.getAnioIngreso().get(Calendar.YEAR));
        System.out.println("Jefe: " + (empleado.getJefe() != null ? empleado.getJefe().nomYApe() : "Sin jefe asignado"));
    }
    
    /**
     * Emite un permiso de salida para el empleado firmado por su jefe.
     * 
     * @param empleado Empleado que solicita el permiso
     * @param scanner Scanner para entrada de datos
     */
    private static void emitirPermisoSalida(EmpleadoConJefe empleado, Scanner scanner) {
        if (empleado.getJefe() == null) {
            System.out.println("ERROR: El empleado no tiene jefe asignado. No se puede emitir el permiso.");
            return;
        }
        
        scanner.nextLine(); // Limpiar buffer
        
        System.out.println("\n=== EMISIÓN DE PERMISO DE SALIDA ===");
        System.out.print("Ingrese motivo del permiso: ");
        String motivo = scanner.nextLine();
        
        System.out.print("Ingrese fecha del permiso (dd/mm/yyyy): ");
        String fechaPermiso = scanner.nextLine();
        
        System.out.print("Ingrese hora de salida: ");
        String horaSalida = scanner.nextLine();
        
        System.out.print("Ingrese hora de regreso: ");
        String horaRegreso = scanner.nextLine();
        
        // Generar el permiso de salida
        Calendar fechaActual = new GregorianCalendar();
        String fechaEmision = fechaActual.get(Calendar.DAY_OF_MONTH) + "/" + 
                             (fechaActual.get(Calendar.MONTH) + 1) + "/" + 
                             fechaActual.get(Calendar.YEAR);
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                         PERMISO DE SALIDA");
        System.out.println("=".repeat(80));
        System.out.println();
        System.out.println("Fecha de emisión: " + fechaEmision);
        System.out.println("Fecha del permiso: " + fechaPermiso);
        System.out.println();
        System.out.println("DATOS DEL EMPLEADO:");
        System.out.println("  Nombre: " + empleado.nomYApe());
        System.out.println("  CUIL: " + empleado.getCuil());
        System.out.println("  Antigüedad: " + empleado.antiguedad() + " años de servicio");
        System.out.println();
        System.out.println("DETALLES DEL PERMISO:");
        System.out.println("  Motivo: " + motivo);
        System.out.println("  Hora de salida: " + horaSalida);
        System.out.println("  Hora de regreso: " + horaRegreso);
        System.out.println();
        System.out.println("AUTORIZACIÓN:");
        System.out.println("  Autorizado por: " + empleado.getJefe().nomYApe());
        System.out.println("  Cargo: Jefe/Supervisor");
        System.out.println("  CUIL del autorizante: " + empleado.getJefe().getCuil());
        System.out.println();
        System.out.println("                    ________________________");
        System.out.println("                    Firma: " + empleado.getJefe().apeYNom());
        System.out.println("                    " + empleado.getJefe().nomYApe());
        System.out.println("                    Jefe/Supervisor");
        System.out.println();
        System.out.println("=".repeat(80));
        System.out.println("Permiso emitido exitosamente y firmado por el jefe autorizante.");
    }
    
    /**
     * Compara los sueldos entre el jefe y el empleado.
     * 
     * @param jefe Empleado que actúa como jefe
     * @param empleado Empleado subordinado
     */
    private static void compararSueldos(EmpleadoConJefe jefe, EmpleadoConJefe empleado) {
        System.out.println("\n=== COMPARACIÓN DE SUELDOS ===");
        System.out.println("Sueldo neto del jefe: $" + jefe.sueldoNeto());
        System.out.println("Sueldo neto del empleado: $" + empleado.sueldoNeto());
        
        double diferencia = jefe.sueldoNeto() - empleado.sueldoNeto();
        if (diferencia > 0) {
            System.out.println("El jefe gana $" + diferencia + " más que el empleado.");
        } else if (diferencia < 0) {
            System.out.println("El empleado gana $" + Math.abs(diferencia) + " más que el jefe.");
        } else {
            System.out.println("Ambos tienen el mismo sueldo neto.");
        }
        
        System.out.println("\nAntiguedad del jefe: " + jefe.antiguedad() + " años");
        System.out.println("Antigüedad del empleado: " + empleado.antiguedad() + " años");
    }
}
