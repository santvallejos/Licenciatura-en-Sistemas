import java.util.*;

/**
 * Clase que representa un empleado que puede tener un jefe asignado.
 * Extiende la funcionalidad básica de empleado añadiendo la relación jerárquica
 * con otro empleado que actúa como jefe.
 * 
 * @author Sistema de Recursos Humanos
 */
public class EmpleadoConJefe {
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private Calendar fechaIngreso;
    private EmpleadoConJefe jefe;

    /**
     * Constructor completo del empleado con jefe.
     * Crea un empleado con todos sus datos incluyendo la asignación de un jefe.
     * 
     * @param p_cuil CUIL del empleado
     * @param p_apellido Apellido del empleado
     * @param p_nombre Nombre del empleado
     * @param p_importe Sueldo básico del empleado
     * @param p_fecha Fecha de ingreso del empleado
     * @param p_jefe Empleado que actúa como jefe
     */
    EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha,
            EmpleadoConJefe p_jefe) {
        setCuil(p_cuil);
        setApellido(p_apellido);
        setNombre(p_nombre);
        setSueldoBasico(p_importe);
        setAnioIngreso(p_fecha);
        setJefe(p_jefe);
    }

    /**
     * Constructor del empleado sin jefe asignado.
     * Crea un empleado con sus datos básicos pero sin jefe.
     * 
     * @param p_cuil CUIL del empleado
     * @param p_apellido Apellido del empleado
     * @param p_nombre Nombre del empleado
     * @param p_importe Sueldo básico del empleado
     * @param p_fecha Fecha de ingreso del empleado
     */
    EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha) {
        setCuil(p_cuil);
        setApellido(p_apellido);
        setNombre(p_nombre);
        setSueldoBasico(p_importe);
        setAnioIngreso(p_fecha);
        setJefe(null);
    }

    /**
     * Constructor básico del empleado con año de ingreso.
     * Crea un empleado especificando solo el año de ingreso (se asume 1 de enero).
     * 
     * @param p_cuil CUIL del empleado
     * @param p_apellido Apellido del empleado
     * @param p_nombre Nombre del empleado
     * @param p_importe Sueldo básico del empleado
     * @param p_anio Año de ingreso del empleado
     */
    EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio) {
        setCuil(p_cuil);
        setApellido(p_apellido);
        setNombre(p_nombre);
        setSueldoBasico(p_importe);
        /*
         * definiendo la variable fecha del tipo calendar se puede setear el año, mes y
         * día
         */
        Calendar fecha = new GregorianCalendar();
        fecha.set(p_anio, 0, 1);
        setAnioIngreso(fecha);
        setJefe(null);
    }

    private void setCuil(long p_cuil) {
        this.cuil = p_cuil;
    }

    public long getCuil() {
        return this.cuil;
    }

    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    private void setSueldoBasico(double p_importe) {
        this.sueldoBasico = p_importe;
    }

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    private void setAnioIngreso(Calendar p_fecha) {
        this.fechaIngreso = p_fecha;
    }

    public Calendar getAnioIngreso() {
        return this.fechaIngreso;
    }

    private void setJefe(EmpleadoConJefe p_jefe) {
        this.jefe = p_jefe;
    }

    public EmpleadoConJefe getJefe() {
        return this.jefe;
    }

    /**
     * Calcula la antigüedad del empleado en años.
     * Se basa en la diferencia entre el año actual y el año de ingreso.
     * 
     * @return Cantidad de años de antigüedad del empleado
     */
    public int antiguedad() {
        Calendar fechaActual = new GregorianCalendar();
        return fechaActual.get(Calendar.YEAR) - this.fechaIngreso.get(Calendar.YEAR);
    }

    /**
     * Calcula el descuento aplicado al sueldo básico.
     * Aplica un descuento del 2% del sueldo básico más $1500 fijos.
     * 
     * @return Sueldo básico menos los descuentos aplicados
     */
    private double descuento() {
        // Necesito hacer un descuento del 2% a getSueldoBasico y restar $1500 tambien
        double descuento = (getSueldoBasico() * 0.02) + 1500;
        return getSueldoBasico() - descuento;
    }

    /**
     * Calcula el adicional por antigüedad del empleado.
     * Los porcentajes se aplican según los años de antigüedad:
     * - Menos de 2 años: 2% del sueldo básico
     * - Entre 2 y 9 años: 4% del sueldo básico
     * - 10 años o más: 6% del sueldo básico
     * 
     * @return Monto adicional por antigüedad
     */
    private double adicional() {
        if (antiguedad() < 2) {
            return getSueldoBasico() * 0.02;
        } else if (antiguedad() >= 2 && antiguedad() < 10) {
            return getSueldoBasico() * 0.04;
        } else {
            return getSueldoBasico() * 0.06;
        }
    }

        /**
     * Calcula el sueldo neto del empleado.
     * Se obtiene sumando el sueldo básico más el adicional por antigüedad.
     * 
     * @return Sueldo neto del empleado
     */
    public double sueldoNeto()
    {
        return getSueldoBasico() + adicional();
    }

        /**
     * Concatena el nombre y apellido del empleado separados por un espacio.
     * 
     * @return Cadena con formato "Nombre Apellido"
     */
    public String nomYApe()
    {
        return getNombre() + " " + getApellido();
    }

    /**
     * Concatena el apellido y nombre del empleado separados por coma y espacio.
     * 
     * @return Cadena con formato "Apellido, Nombre"
     */
    public String apeYNom()
    {
        return getApellido() + ", " + getNombre();
    }

    /**
     * Muestra por consola toda la información del empleado.
     * Incluye nombre completo, CUIL, antigüedad y sueldo neto.
     * Formato de salida:
     * Nombre y Apellido: [Nombre Apellido]
     * CUIL: [CUIL] Antiguedad: [años] años de servicio
     * Sueldo Neto: $ [sueldo neto]
     */
    public void mostrar()
    {
        System.out.println("Nombre y Apellido: " + nomYApe());
        System.out.println("CUIL: " + getCuil() + " " + "Antiguedad: " + antiguedad() + " años de servicio");
        System.out.println("Sueldo Neto: $ " + sueldoNeto());
    }

    /**
     * Genera una representación en línea de los datos del empleado.
     * Útil para mostrar información resumida en formato tabular.
     * 
     * @return Cadena con formato: "[CUIL]  [Apellido, Nombre]  ................  $ [sueldo neto]"
     */
    public String mostrarLinea()
    {
        return getCuil() + "  " + apeYNom() + "  ................  " + " $ " + sueldoNeto();
    }
}