import java.util.*;
import java.util.Calendar;

/**
 * Clase que representa un empleado con sus datos personales y laborales.
 */
public class Empleado extends Persona {
    private long cuil;
    private double sueldoBasico;
    private Calendar fechaIngreso;

    // ------------------- Constructores -------------------

    // Constructor que recibe un año de ingreso (int)
    public Empleado(int p_dni, String p_nombre, String p_apellido, int p_anio, long p_cuil, double p_importe) {
        super(p_dni, p_nombre, p_apellido, p_anio);
        this.setCuil(p_cuil);
        this.setSueldoBasico(p_importe);
        // Se crea una fecha con 1 de enero del año indicado
        this.setFechaIngreso(new GregorianCalendar(p_anio, Calendar.JANUARY, 1));
    }

    // Constructor que recibe una fecha de ingreso completa (Calendar)
    public Empleado(int p_dni, String p_nombre, String p_apellido, int p_anio, long p_cuil, double p_importe,
            Calendar p_fecha) {
        super(p_dni, p_nombre, p_apellido, p_anio);
        this.cuil = p_cuil;
        this.sueldoBasico = p_importe;
        this.fechaIngreso = p_fecha;
    }

    /**
     * Establece el CUIL del empleado.
     * 
     * @param p_cuil CUIL a asignar al empleado
     */
    private void setCuil(long p_cuil) {
        this.cuil = p_cuil;
    }

    /**
     * Obtiene el CUIL del empleado.
     * 
     * @return CUIL del empleado
     */
    public long getCuil() {
        return cuil;
    }

    /**
     * Establece el sueldo básico del empleado.
     * 
     * @param p_importe Sueldo básico a asignar al empleado
     */
    private void setSueldoBasico(double p_importe) {
        this.sueldoBasico = p_importe;
    }

    /**
     * Obtiene el sueldo básico del empleado.
     * 
     * @return Sueldo básico del empleado
     */
    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    /**
     * Establece la fecha de ingreso del empleado.
     * 
     * @param p_fecha fecha de ingreso a asignar al empleado
     */
    private void setFechaIngreso(Calendar p_fecha) {
        this.fechaIngreso = p_fecha;
    }

    /**
     * Calcula la antigüedad del empleado en años.
     * Se basa en la diferencia entre el año actual y el año de ingreso.
     * 
     * @return Antigüedad del empleado en años
     */
    public int antiguedad() {
        Calendar fechaHoy = Calendar.getInstance(); // Fecha actual
        int anioHoy = fechaHoy.get(Calendar.YEAR); // Año actual
        int anioIngreso = fechaIngreso.get(Calendar.YEAR); // Año de ingreso desde fechaIngreso
        return anioHoy - anioIngreso; // Diferencia de años
    }

    /**
     * Calcula el descuento aplicado al sueldo básico.
     * Se aplica un descuento del 2% del sueldo básico más $1500 fijos.
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
    public double sueldoNeto() {
        return getSueldoBasico() + adicional();
    }

    /**
     * Concatena el nombre y apellido del empleado separados por un espacio.
     * 
     * @return Cadena con formato "Nombre Apellido"
     */
    public String nomYApe() {
        return getNombre() + " " + getApellido();
    }

    /**
     * Concatena el apellido y nombre del empleado separados por coma y espacio.
     * 
     * @return Cadena con formato "Apellido, Nombre"
     */
    public String apeYNom() {
        return getApellido() + " " + getNombre();
    }

    /**
     * Muestra por consola toda la información del empleado.
     * Incluye nombre completo, CUIL, antigüedad y sueldo neto.
     * Formato de salida:
     * Nombre y Apellido: [Nombre Apellido]
     * CUIL: [CUIL] Antiguedad: [años] años de servicio
     * Sueldo Neto: $ [sueldo neto]
     */
    public void mostrar() {
        super.mostrar();
        System.out.println("CUIL: " + getCuil() + " " + "Antiguedad: " + antiguedad() + " años de servicio");
        System.out.println("Sueldo Neto: $ " + sueldoNeto());
    }

    /**
     * Genera una representación en línea de los datos del empleado.
     * Útil para mostrar información resumida en formato tabular.
     * 
     * @return Cadena con formato: "[CUIL] [Apellido, Nombre] ................ $
     *         [sueldo neto]"
     */
    public String mostrarLinea() {
        return getCuil() + "  " + apeYNom() + "  ................  " + " $ " + sueldoNeto();
    }

    /**
     * Genera un condicional para saber si es su aniversario.
     * 
     * @return System.out.println ("\nPermiso autorizado: puede salir más
     *         temprano"); si es verdadero.
     * @return System.out.println("\nPermiso denegado: aún no cumple su
     *         aniversario"); si es falso.
     */
    public boolean esAniversario() {
        Calendar hoy = Calendar.getInstance();
        int diaHoy = hoy.get(Calendar.DAY_OF_MONTH);
        int mesHoy = hoy.get(Calendar.MONTH);

        int diaIngreso = fechaIngreso.get(Calendar.DAY_OF_MONTH);
        int mesIngreso = fechaIngreso.get(Calendar.MONTH);
        return (diaHoy == diaIngreso && mesHoy == mesIngreso);
    }
}
