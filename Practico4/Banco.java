import java.util.*;

/**
 * Write a description of class Banco here.
 * 
 * @author Clase de sistema bancario
 * @version 1.0
 */
public class Banco
{
    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList<Empleado> empleados;


    /**
     * Constructor de banco con un solo empleado
     * 
     * @param p_nombre
     * @param p_localidad
     * @param p_nroSucursal
     * @param p_empleado
     */
    Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado)
    {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList<Empleado>());
        this.agregarEmpleado(p_empleado);
    }

    /**
     * Constructor de banco con muchos empleados
     * 
     * @param p_nombre
     * @param p_localidad
     * @param p_nroSucursal
     * @param p_empleados
     */
    Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados)
    {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList<Empleado>());
        this.agregarEmpleados(p_empleados);
    }

    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    private void setNroSucursal(int p_nroSucursal)
    {
        this.nroSucursal = p_nroSucursal;
    }

    public int getNroSucursal()
    {
        return this.nroSucursal;
    }

    private void setLocalidad(Localidad p_localidad)
    {
        this.localidad = p_localidad;
    }

    public Localidad getLocalidad()
    {
        return this.localidad;
    }

    private void setEmpleados(ArrayList<Empleado> p_empleados)
    {
        this.empleados = p_empleados;
    }

    public ArrayList<Empleado> getEmpleados()
    {
        return this.empleados;
    }

    public boolean agregarEmpleado(Empleado p_empleado)
    {
        if(p_empleado != null && !this.empleados.contains(p_empleado))
        {
            this.empleados.add(p_empleado);
            return true;
        }
        return false;
    }

    public boolean agregarEmpleados(ArrayList<Empleado> p_empleados)
    {
        for (int i = 0; i < p_empleados.size(); i++) {
            Empleado empleado = p_empleados.get(i);
            if (empleado != null && !this.empleados.contains(empleado)) {
                this.empleados.add(empleado);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean quitarEmpleado(Empleado p_empleado)
    {
        if(p_empleado != null && this.empleados.contains(p_empleado))
        {
            this.empleados.remove(p_empleado);
            return true;
        }
        return false;
    }

    /**
     * Imprime datos y sueldo de la lista de empleados
     */
    public void listarSueldos()
    {
        for(int i = 0; i < this.empleados.size(); i++)
        {
            Empleado empleado = this.empleados.get(i);
            System.out.println(empleado.getCuil() + empleado.getApellido() + ", " + empleado.getNombre() + " ----------------------------------------- $" + empleado.sueldoNeto());
        }
    }

    /**
     * Calcula el total de sueldos a pagar de cada empleado
     * 
     * @return El total de sueldos a pagar
     */
    public double sueldosAPagar()
    {
        double totalSueldos = 0;
        for(int i = 0; i < this.empleados.size(); i++)
        {
            Empleado empleado = this.empleados.get(i);
            totalSueldos += empleado.sueldoNeto();
        }
        return totalSueldos;
    }

    /**
     * Muestra los datos del banco, la lista de sueldos y el total a pagar
     */
    public void mostrar()
    {
        System.out.println("Banco: " + this.getNombre() + "  Sucursal: " + this.getNroSucursal());
        System.out.println("Localidad: " + this.getLocalidad().getNombre() + "  Provincia: " + this.getLocalidad().getProvincia());
        System.out.println("");
        this.listarSueldos();
        System.out.println("");
        System.out.println("Total a pagar:  ----------------------------------------- $" + this.sueldosAPagar());
    }
}