
/**
 * Clase que representa una localidad con su nombre y provincia.
 * Permite gestionar información geográfica básica para ubicación
 * de personas, hospitales u otras entidades.
 * 
 * @author Sistema Geográfico
 */
public class Localidad
{
    private String nombre;
    private String provincia;

    /**
     * Constructor de la localidad.
     * Inicializa una localidad con su nombre y provincia.
     * 
     * @param p_nombre Nombre de la localidad
     * @param p_provincia Provincia a la que pertenece la localidad
     */
    public Localidad(String p_nombre, String p_provincia)
    {
        this.setNombre(p_nombre);
        this.setProvincia(p_provincia);
    }

    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    private void setProvincia(String p_provincia)
    {
        this.provincia = p_provincia;
    }

    public String getProvincia()
    {
        return this.provincia;
    }

    /**
     * Genera una representación textual de la localidad.
     * 
     * @return Cadena con formato: "Localidad: [nombre]     Provincia: [provincia]"
     */
    public String mostrar()
    {
        return "Localidad: " + this.getNombre() + "     Provincia: " + this.getProvincia();
    }
}