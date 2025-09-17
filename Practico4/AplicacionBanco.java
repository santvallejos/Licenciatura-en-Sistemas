import java.util.*;

/**
 * Write a description of class AplicacionBanco here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class AplicacionBanco {
    public static void main(String[] args) {

        
        Localidad localidad1 = new Localidad("Corrientes", "Corrientes"); /* Instancia localidad */

        /* Lista de empleados */
        Empleado empleado1 = new Empleado(203245662, "Juan", "Torrico", 500000, 2010);
        Empleado empleado2 = new Empleado(203245663, "Ana", "Gonzalez", 600000, 2012);
        Empleado empleado3 = new Empleado(203245664, "Luis", "Martinez", 550000, 2011);
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);

        /* Lista de titulares (Personas) */
        Persona titular1 = new Persona(12345678, "Maria", "Lopez", 1985);
        Persona titular2 = new Persona(87654321, "Carlos", "Rodriguez", 1990);
        Persona titular3 = new Persona(11223344, "Laura", "Fernandez", 1975);

        /* Lista de cuentas bancarias */
        CuentaBancaria cuenta1 = new CuentaBancaria(1001, titular1, 5000.0);
        CuentaBancaria cuenta2 = new CuentaBancaria(1002, titular2, 0.0);
        CuentaBancaria cuenta3 = new CuentaBancaria(1003, titular3, 15000.0);
        ArrayList<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);

        Banco banco1 = new Banco("Banco de Corrientes", localidad1, 1, empleados, cuentas); /* Instancia banco con empleados y cuentas */

        banco1.mostrar();
        System.out.println();
        banco1.mostrarResumen();
    }
}