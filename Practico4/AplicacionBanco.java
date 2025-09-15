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

        Banco banco1 = new Banco("Banco de Corrientes", localidad1, 1, empleados); /* Instancia banco con un solo empleado */

        banco1.mostrar();
    }
}