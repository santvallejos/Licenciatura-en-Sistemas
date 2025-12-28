
/**
 * Write a description of class Servicio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Servicio
{
    private String description;
    private double precio;

    /**
     * Constructor principal de la clase Servicio
     * 
     * @param p_description
     * @param p_precio
    */
    Servicio(String p_description, double p_precio)
    {
        this.setDescription(p_description);
        this.setPrecio(p_precio);
    }

    private void setDescription(String p_description)
    {
        this.description = p_description;
    }

    public String getDescription()
    {
        return this.description;
    }

    private void setPrecio(double p_precio)
    {
        this.precio = p_precio;
    }

    public double getPrecio()
    {
        return this.precio;
    }
}