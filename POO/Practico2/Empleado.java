import java.util.*;

/**
 * Clase que representa un empleado con sus datos personales y laborales.
 * Permite gestionar la información de un empleado incluyendo su CUIL, nombre, apellido,
 * sueldo básico y año de ingreso. Calcula automáticamente la antigüedad, adicionales
 * por antigüedad y el sueldo neto.
 * 
 * @author Sistema de Recursos Humanos
 */
public class Empleado
{
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private int anioIngreso;

    /**
     * Constructor de la clase Empleado.
     * Inicializa un empleado con todos sus datos laborales y personales.
     * 
     * @param p_cuil CUIL del empleado
     * @param p_apellido Apellido del empleado
     * @param p_nombre Nombre del empleado
     * @param p_importe Sueldo básico del empleado
     * @param p_anioIngreso Año de ingreso del empleado a la empresa
     */
    Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anioIngreso)
    {
        setCuil(p_cuil);
        setApellido(p_apellido);
        setNombre(p_nombre);
        setSueldoBasico(p_importe);
        setAnioIngreso(p_anioIngreso);
    }

    /**
     * Establece el CUIL del empleado.
     * 
     * @param p_cuil CUIL a asignar al empleado
     */
    private void setCuil(long p_cuil)
    {
        this.cuil = p_cuil;
    }

    /**
     * Obtiene el CUIL del empleado.
     * 
     * @return CUIL del empleado
     */
    public long getCuil()
    {
        return cuil;
    }

    /**
     * Establece el apellido del empleado.
     * 
     * @param p_apellido Apellido a asignar al empleado
     */
    private void setApellido(String p_apellido)
    {
        this.apellido = p_apellido;
    }

    /**
     * Obtiene el apellido del empleado.
     * 
     * @return Apellido del empleado
     */
    public String getApellido()
    {
        return this.apellido;
    }

    /**
     * Establece el nombre del empleado.
     * 
     * @param p_nombre Nombre a asignar al empleado
     */
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    /**
     * Obtiene el nombre del empleado.
     * 
     * @return Nombre del empleado
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Establece el sueldo básico del empleado.
     * 
     * @param p_importe Sueldo básico a asignar al empleado
     */
    private void setSueldoBasico(double p_importe)
    {
        this.sueldoBasico = p_importe;
    }

    /**
     * Obtiene el sueldo básico del empleado.
     * 
     * @return Sueldo básico del empleado
     */
    public double getSueldoBasico()
    {
        return this.sueldoBasico;
    }

    /**
     * Establece el año de ingreso del empleado.
     * 
     * @param p_anioIngreso Año de ingreso a asignar al empleado
     */
    private void setAnioIngreso(int p_anioIngreso)
    {
        this.anioIngreso = p_anioIngreso;
    }

    /**
     * Obtiene el año de ingreso del empleado.
     * 
     * @return Año de ingreso del empleado
     */
    public int getAnioIngreso()
    {
        return this.anioIngreso;
    }

    /**
     * Calcula la antigüedad del empleado en años.
     * Se basa en la diferencia entre el año actual y el año de ingreso.
     * 
     * @return Antigüedad del empleado en años
     */
    public int antiguedad()
    {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);

        return anioHoy - getAnioIngreso();
    }

    /**
     * Calcula el descuento aplicado al sueldo básico.
     * Se aplica un descuento del 2% del sueldo básico más $1500 fijos.
     * 
     * @return Sueldo básico menos los descuentos aplicados
     */
    private double descuento()
    {
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
    private double adicional()
    {
        if(antiguedad() < 2)
        {
            return getSueldoBasico() * 0.02;
        }
        else if(antiguedad() >= 2 && antiguedad() < 10)
        {
            return getSueldoBasico() * 0.04;
        }
        else
        {
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