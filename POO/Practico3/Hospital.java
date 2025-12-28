
/**
 * Clase que representa un hospital con su información básica.
 * Gestiona los datos de un hospital incluyendo nombre, director
 * y la asociación con un paciente.
 * 
 * @author Sistema Hospitalario
 */
public class Hospital
{
    private String nombreHospital;
    private String nombreDirector;
    private Paciente paciente;

    /**
     * Constructor del hospital.
     * Inicializa un hospital con su nombre, director y paciente asociado.
     * 
     * @param p_nombreHospital Nombre del hospital
     * @param p_nombreDirector Nombre del director del hospital
     * @param p_paciente Paciente asociado al hospital
     */
    Hospital(String p_nombreHospital, String p_nombreDirector, Paciente p_paciente)
    {
        this.setNombreHospital(p_nombreHospital);
        this.setNombreDirector(p_nombreDirector);
        this.setPaciente(p_paciente);
    }

    private void setNombreHospital(String p_nombreHospital)
    {
        this.nombreHospital = p_nombreHospital;
    }

    public String getNombreHospital()
    {
        return this.nombreHospital;
    }

    private void setNombreDirector(String p_nombreDirector)
    {
        this.nombreDirector = p_nombreDirector;
    }

    public String getNombreDirector()
    {
        return this.nombreDirector;
    }

    private void setPaciente(Paciente p_paciente)
    {
        this.paciente = p_paciente;
    }

    public Paciente getPaciente()
    {
        return this.paciente;
    }

    /**
     * Muestra la consulta de datos filiatorios del paciente.
     * Presenta información del hospital, director y datos del paciente.
     * 
     * @param p_paciente Paciente del cual se mostrarán los datos
     */
    public void consultaDatosFiliatorios(Paciente p_paciente)
    {
        System.out.println("Hospital: " + this.getNombreHospital() + "    Director: " + this.getNombreDirector());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        this.paciente.mostrarDatosPantalla();
    }
}