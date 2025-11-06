
/**
 * Write a description of class Estudiante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estudiante extends Socio
{
    // instance variables - replace the example below with your own
    private String carrera;

    /**
     * Constructor de la clase Estudiante
     * 
     * @param p_dni El dni del estudiante
     * @param p_nombre El nombre del estudiante
     * @param p_diasPrestamo Los dias de prestamo del estudiante
     * @param p_carrera La carrera del estudiante
     */
    public Estudiante(int p_dni, String p_nombre, int p_diasPrestamo, String p_carrera)
    {
        // initialise instance variables
        super(p_dni, p_nombre, p_diasPrestamo);
        this.setCarrera(p_carrera);
        
    }

    // getters y setters
    private void setCarrera(String p_carrera)
    {
        this.carrera = p_carrera;
    }

    public String getCarrera()
    {
        return this.carrera;
    }

    /**
     * Metodo que indica si un estudiante puede pedir prestado un libro
     * 
     * @return true si puede pedir prestado un libro, false en caso contrario
    */
    public boolean puedePedir()
    {
        if(super.puedePedir() && super.cantLibrosPrestados() < 3){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String soyDeLaClase()
    {
        return "Estudiante";
    }
}