
/**
 * Write a description of class Docente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Docente extends Socio
{
    private String area;

    /**
     * Constructor de Docente con prestamos.
     * 
     * @param p_dni - dni del docente
     * @param p_nombre - nombre del docente
     * @param p_diasPrestamo - días de préstamo
     * @param p_area - área del docente
     */
    public Docente(int p_dni, String p_nombre, int p_diasPrestamo, String p_area)
    {
        super(p_dni, p_nombre, 5);
        this.setArea(p_area);// initialise instance variables
    }

    /**
     * Constructor de Docente sin prestamos.
     * 
     * @param p_dni - dni del docente
     * @param p_nombre - nombre del docente
     * @param p_area - área del docente
    */
    public Docente (int p_dni, String p_nombre, String p_area)
    {
        super(p_dni, p_nombre, 5);
        this.setArea(p_area);
    }

    // Getters y Setters
    private void setArea(String p_area)
    {
        this.area = p_area;
    }

    public String getArea()
    {
        return this.area;
    }

    /**
     * - esResponsable(): devuelve true si el Docente nunca tuvo ni tiene un préstamo vencido.
     * - puedePedir(): devuelve true si el socio no tiene ningún préstamo vencido.
     * nunca tuve prestamo vencido --> persistencia?
     * 
     * @return boolean - true si el docente es responsable, false en caso contrario
     */
    public boolean esResponsable()
    {
        return super.puedePedir();
    }
    
    @Override
    public String soyDeLaClase()
    {
        return "Docente";
    }

    /**
     * Cambia los días de préstamo del docente si es responsable.
     * 
     * @param p_dias - nuevos días de préstamo
    */
    public void cambiarDiasDePrestamo(int p_dias)
    {
        if(this.esResponsable())
        {
            int nuevosDiasPrestamo = super.getDiasPrestamo() + p_dias;
            super.setDiasPrestamo(nuevosDiasPrestamo);
        }
    }
}