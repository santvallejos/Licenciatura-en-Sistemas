import java.util.*;

/**
 * Clase que representa un comercio
 * 
 * @author Sistema de comercio
 * @version 1.0
 */
public class Comercio {
    private String nombre;
    private HashMap<Long, Empleado> empleados;

    /**
     * Constructor por defecto
     *
     * @param p_nombre Nombre del comercio 
     */
    public Comercio(String p_nombre) {
        setNombre(p_nombre);
    }

    /**
     * Constructor parametrizado
     *
     * @param p_nombre    Nombre del comercio
     * @param p_empleados Coleccion de empleados del comercio
     */
    public Comercio(String p_nombre, HashMap<Long, Empleado> p_empleados) {
        setNombre(p_nombre);
        setEmpleados(p_empleados);
    }

    // setters y getters
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    private void setEmpleados(HashMap<Long, Empleado> p_empleados) {
        this.empleados = p_empleados;
    }

    public HashMap<Long, Empleado> getEmpleados() {
        return this.empleados;
    }

    /**
     * Agrega un empleado a la coleccion
     *
     * @param p_empleado Empleado a agregar
     */
    public void altaEmpleado(Empleado p_empleado) { // agrego un empleado a la coleccion
        this.empleados.put(p_empleado.getCuil(), p_empleado);
    }

    /**
     * Elimina un empleado de la coleccion
     *
     * @param p_cuil CUIL del empleado a eliminar
     */
    public void bajaEmpleado(long p_cuil) { // elimino un empleado de la coleccion
        this.getEmpleados().remove(p_cuil);
    }

    /**
     * Devuelve la cantidad de empleados en la coleccion
     *
     * @return Cantidad de empleados
     */
    public int cantidadEmpleados() {
        return this.getEmpleados().size(); // devuelve la cantidad de empleados en la coleccion
    }

    /**
     * Verifica si un empleado existe en la coleccion
     *
     * @param p_cuil CUIL del empleado a buscar
     * @return true si el empleado existe, false en caso contrario
     */
    public boolean esEmpleado(long p_cuil) {
        return this.getEmpleados().containsKey(p_cuil); // devuelve true si el empleado esta en la coleccion
    }

    /**
     * Busca y devuelve un empleado de la coleccion
     *
     * @param p_cuil CUIL del empleado a buscar
     * @return Empleado si existe, null en caso contrario
     */
    public Empleado buscarEmpleado(long p_cuil) {
        return this.getEmpleados().get(p_cuil); // devuelve el empleado si esta en la coleccion
    }

    /**
     * Muestra el sueldo neto de un empleado
     *
     * @param p_cuil CUIL del empleado
     */
    public void sueldoNeto(long p_cuil) {
        Empleado empleado = this.buscarEmpleado(p_cuil);
        if (empleado != null) {
            System.out.println("El sueldo neto del empleado buscado es: " + empleado.sueldoNeto());
        } else {
            System.out.println("El empleado no existe");
        }
    }

    /**
     * Muestra la nomina de empleados con su sueldo neto
     */
    public void nomina() {
        System.out.println("**** Nomina de empleados de: " + this.getNombre() + " ****");
        for (Empleado empleado : this.getEmpleados().values()) {
            System.out.println(empleado.getCuil() + " " + empleado.getApellido() + ", " + empleado.getNombre()
                    + "------------ $" + empleado.sueldoNeto());
        }
    }
}