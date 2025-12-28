import java.util.Scanner;

/**
 * Clase ejecutable que demuestra el funcionamiento de la clase CuentaBancaria.
 * Permite al usuario ingresar datos por teclado para crear personas, cuentas bancarias
 * y realizar operaciones de depósito y extracción de forma interactiva.
 * 
 * @author Sistema Bancario
 * @version 1.0
 */
public class EjecutarCuentaBancaria {
    
    /**
     * Método principal que ejecuta el programa de demostración interactivo.
     * Solicita al usuario ingresar datos para crear personas, cuentas bancarias 
     * y realizar operaciones bancarias básicas.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE CUENTAS BANCARIAS ===");
        System.out.println();
        
        // Solicitar datos de la primera persona
        System.out.println("--- DATOS DE LA PRIMERA PERSONA ---");
        System.out.print("Ingrese DNI: ");
        int dni1 = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Ingrese nombre: ");
        String nombre1 = scanner.nextLine();
        
        System.out.print("Ingrese apellido: ");
        String apellido1 = scanner.nextLine();
        
        System.out.print("Ingrese año de nacimiento: ");
        int anio1 = scanner.nextInt();
        
        Persona persona1 = new Persona(dni1, nombre1, apellido1, anio1);
        
        // Solicitar datos de la segunda persona
        System.out.println("\n--- DATOS DE LA SEGUNDA PERSONA ---");
        System.out.print("Ingrese DNI: ");
        int dni2 = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Ingrese nombre: ");
        String nombre2 = scanner.nextLine();
        
        System.out.print("Ingrese apellido: ");
        String apellido2 = scanner.nextLine();
        
        System.out.print("Ingrese año de nacimiento: ");
        int anio2 = scanner.nextInt();
        
        Persona persona2 = new Persona(dni2, nombre2, apellido2, anio2);
        
        // Solicitar datos de las cuentas bancarias
        System.out.println("\n--- DATOS DE LA PRIMERA CUENTA BANCARIA ---");
        System.out.print("Ingrese número de cuenta: ");
        int nroCuenta1 = scanner.nextInt();
        
        CuentaBancaria cuenta1 = new CuentaBancaria(nroCuenta1, persona1);
        
        System.out.println("\n--- DATOS DE LA SEGUNDA CUENTA BANCARIA ---");
        System.out.print("Ingrese número de cuenta: ");
        int nroCuenta2 = scanner.nextInt();
        
        System.out.print("Ingrese saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        
        CuentaBancaria cuenta2 = new CuentaBancaria(nroCuenta2, persona2, saldoInicial);
        
        // Mostrar estado inicial de las cuentas
        System.out.println("\n=== ESTADO INICIAL DE LAS CUENTAS ===");
        cuenta1.mostrar();
        cuenta2.mostrar();
        
        // Realizar operaciones en la primera cuenta
        System.out.println("=== OPERACIONES EN PRIMERA CUENTA ===");
        System.out.print("Ingrese monto a depositar: ");
        double montoDeposito1 = scanner.nextDouble();
        cuenta1.depositar(montoDeposito1);
        System.out.println("Nuevo saldo: $" + cuenta1.getSaldo());
        
        System.out.print("Ingrese monto a extraer: ");
        double montoExtraccion1 = scanner.nextDouble();
        cuenta1.extraer(montoExtraccion1);
        System.out.println("Nuevo saldo: $" + cuenta1.getSaldo());
        
        // Realizar operaciones en la segunda cuenta
        System.out.println("\n=== OPERACIONES EN SEGUNDA CUENTA ===");
        System.out.print("Ingrese monto a depositar: ");
        double montoDeposito2 = scanner.nextDouble();
        cuenta2.depositar(montoDeposito2);
        System.out.println("Nuevo saldo: $" + cuenta2.getSaldo());
        
        System.out.print("Ingrese monto a extraer: ");
        double montoExtraccion2 = scanner.nextDouble();
        double saldoAntes = cuenta2.getSaldo();
        cuenta2.extraer(montoExtraccion2);
        if (cuenta2.getSaldo() == saldoAntes && montoExtraccion2 > saldoAntes) {
            System.out.println("Operación rechazada: fondos insuficientes");
        }
        System.out.println("Saldo actual: $" + cuenta2.getSaldo());
        
        // Mostrar estado final de las cuentas
        System.out.println("\n=== ESTADO FINAL DE LAS CUENTAS ===");
        cuenta1.mostrar();
        cuenta2.mostrar();
        
        // Demostrar el método toString
        System.out.println("=== LISTADO DE CUENTAS (toString) ===");
        System.out.println("Nro. Cuenta\tTitular\t\tSaldo");
        System.out.println(cuenta1.toString());
        System.out.println(cuenta2.toString());
        
        scanner.close();
    }
}
