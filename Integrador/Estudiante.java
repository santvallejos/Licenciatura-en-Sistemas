
/**
 * Write a description of class Estudiante here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Estudiante extends Socio {
    private String carrera;

    /**
     * Constructor de la clase Estudiante con un préstamo.
     * 
     * @param p_dni - dni del estudiante
     * @param p_nombre - nombre del estudiante
     * @param p_carrera - carrera del estudiante
     * @param p_prestamo - préstamo del estudiante
     */
    public Estudiante(int p_dni, String p_nombre, String p_carrera, Prestamo p_prestamo)
    {
        super(p_dni, p_nombre, 0);
        this.setCarrera(p_carrera);
    }

    /**
     * Constructor de la clase Estudiante sin préstamos.
     * 
     * @param p_dni - dni del estudiante
     * @param p_nombre - nombre del estudiante
     * @param p_carrera - carrera del estudiante
    */
    public Estudiante(int p_dni, String p_nombre, String p_carrera)
    {
        super(p_dni, p_nombre, 0);
        this.setCarrera(p_carrera);
    }

    // Getters y Setters
    private void setCarrera(String p_carrera)
    {
        this.carrera = p_carrera;
    }

    public String getCarrera()
    {
        return this.carrera;
    }

    /**
     * Verifica si el estudiante puede pedir un libro prestado.
     * 
     * @return boolean - true si puede pedir, false si no puede
    */
    public boolean puedePedir()
    {
        if (super.puedePedir() && super.cantLibrosPrestados() < 3) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String soyDeLaClase()
    {
        return "Estudiante";
    }
}