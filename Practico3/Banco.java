import java.util.Scanner;

/**
 * Clase ejecutable que demuestra el funcionamiento básico de las cuentas bancarias.
 * Permite crear una caja de ahorro y una cuenta corriente para un mismo titular,
 * realizando operaciones simples para verificar las funcionalidades.
 * 
 * @author Sistema Bancario Integral
 * @version 1.0
 */
public class Banco {
    
    /**
     * Método principal que ejecuta pruebas básicas del sistema bancario.
     * Crea un titular y dos cuentas, realiza operaciones básicas.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA BANCARIO - VERIFICACIÓN DE FUNCIONES ===");
        System.out.println();
        
        // Solicitar datos del titular
        System.out.println("--- DATOS DEL TITULAR ---");
        System.out.print("Ingrese DNI del titular: ");
        int dni = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        
        System.out.print("Ingrese año de nacimiento: ");
        int anioNacimiento = scanner.nextInt();
        
        // Crear el titular
        Persona titular = new Persona(dni, nombre, apellido, anioNacimiento);
        
        // Crear caja de ahorro
        System.out.print("\nIngrese número de cuenta para la caja de ahorro: ");
        int nroCuentaAhorro = scanner.nextInt();
        CajaDeAhorro cajaAhorro = new CajaDeAhorro(nroCuentaAhorro, titular, 1000.0);
        
        // Crear cuenta corriente
        System.out.print("Ingrese número de cuenta corriente: ");
        int nroCuentaCorriente = scanner.nextInt();
        CuentaCorriente cuentaCorriente = new CuentaCorriente(nroCuentaCorriente, titular, 500.0);
        
        // Mostrar estado inicial
        System.out.println("\n=== ESTADO INICIAL ===");
        System.out.println("Titular: " + titular.nomYApe() + " (" + titular.edad() + " años)");
        System.out.println();
        cajaAhorro.mostrar();
        System.out.println();
        cuentaCorriente.mostrar();
        
        // Operaciones en caja de ahorro
        System.out.println("\n=== PRUEBAS CAJA DE AHORRO ===");
        System.out.print("Ingrese monto a depositar: ");
        double deposito = scanner.nextDouble();
        cajaAhorro.depositar(deposito);
        System.out.println("Después del depósito:");
        cajaAhorro.mostrar();
        
        System.out.print("\nIngrese monto a extraer: ");
        double extraccion = scanner.nextDouble();
        cajaAhorro.extraer(extraccion);
        System.out.println("Después de la extracción:");
        cajaAhorro.mostrar();
        
        // Operaciones en cuenta corriente
        System.out.println("\n=== PRUEBAS CUENTA CORRIENTE ===");
        System.out.print("Ingrese monto a depositar: ");
        double depositoCC = scanner.nextDouble();
        cuentaCorriente.depositar(depositoCC);
        System.out.println("Después del depósito:");
        cuentaCorriente.mostrar();
        
        System.out.print("\nIngrese monto a extraer: ");
        double extraccionCC = scanner.nextDouble();
        cuentaCorriente.extraer(extraccionCC);
        System.out.println("Después de la extracción:");
        cuentaCorriente.mostrar();
        
        // Estado final
        System.out.println("\n=== ESTADO FINAL ===");
        cajaAhorro.mostrar();
        System.out.println();
        cuentaCorriente.mostrar();
        
        System.out.println("\nVerificación completada.");
        scanner.close();
    }
}
