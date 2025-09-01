
/**
 * Write a description of class Paciente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paciente
{
    private int historiaClinica;
    private String nombre;
    private String domicilio;
    private Localidad localidadNacido;
    private Localidad localidadVive;

    Paciente(int p_historiaClinica, String p_nombre, String p_domicilio, Localidad p_localidadNacido, Localidad p_localidadVive)
    {
        this.setHistoriaClinica(p_historiaClinica);
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setNacido(p_localidadNacido);
        this.setVive(p_localidadVive);
    }

    private void setHistoriaClinica(int p_historiaClinica)
    {
        this.historiaClinica = p_historiaClinica;
    }

    public int getHistoriaClinica()
    {
        return this.historiaClinica;
    }

    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    private void setDomicilio(String p_domicilio)
    {
        this.domicilio = p_domicilio;
    }

    public String getDomicilio()
    {
        return this.domicilio;
    }

    private void setNacido(Localidad p_nacido)
    {
        this.localidadNacido = p_nacido;
    }

    public Localidad getNacido()
    {
        return this.localidadNacido;
    }

    private void setVive(Localidad p_vive)
    {
        this.localidadVive = p_vive;
    }

    public Localidad getVive()
    {
        return this.localidadVive;
    }

    public void mostrarDatosPantalla()
    {
        System.out.println("Paciente: " + this.getNombre() + "        Historia Clinica:" + this.getHistoriaClinica() + "        Domicilio:" + this.getDomicilio());
        System.out.println("Localidad: " + this.localidadVive.mostrar());
    }

    public String cadenaDeDatos()
    {
        return this.getNombre() + " ...... " + this.getHistoriaClinica() + " ..... " + this.getDomicilio() + " - " + this.localidadVive.mostrar();
    }
}