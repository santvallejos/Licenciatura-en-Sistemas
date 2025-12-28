
/**
 * Clase que representa un paciente con su información médica y personal.
 * Gestiona los datos básicos del paciente incluyendo historia clínica,
 * datos personales y localidades de nacimiento y residencia.
 * 
 * @author Sistema Hospitalario
 */
public class Paciente
{
    private int historiaClinica;
    private String nombre;
    private String domicilio;
    private Localidad localidadNacido;
    private Localidad localidadVive;

    /**
     * Constructor del paciente.
     * Inicializa un paciente con toda su información personal y médica.
     * 
     * @param p_historiaClinica Número de historia clínica del paciente
     * @param p_nombre Nombre del paciente
     * @param p_domicilio Domicilio actual del paciente
     * @param p_localidadNacido Localidad donde nació el paciente
     * @param p_localidadVive Localidad donde vive actualmente el paciente
     */
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

    /**
     * Muestra en pantalla los datos del paciente de forma estructurada.
     * Incluye nombre, historia clínica, domicilio y localidad de residencia.
     */
    public void mostrarDatosPantalla()
    {
        System.out.println("Paciente: " + this.getNombre() + "        Historia Clinica:" + this.getHistoriaClinica() + "        Domicilio:" + this.getDomicilio());
        System.out.println("Localidad: " + this.localidadVive.mostrar());
    }

    /**
     * Genera una cadena con los datos del paciente en formato resumido.
     * Útil para listados o reportes que requieren información compacta.
     * 
     * @return Cadena con formato: "Nombre ...... Historia Clínica ..... Domicilio - Localidad"
     */
    public String cadenaDeDatos()
    {
        return this.getNombre() + " ...... " + this.getHistoriaClinica() + " ..... " + this.getDomicilio() + " - " + this.localidadVive.mostrar();
    }
}