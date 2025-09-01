
/**
 * Write a description of class Hospital here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hospital
{
    private String nombreHospital;
    private String nombreDirector;
    private Paciente paciente;

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

    public void consultaDatosFiliatorios(Paciente p_paciente)
    {
        System.out.println("Hospital: " + this.getNombreHospital() + "    Director: " + this.getNombreDirector());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        this.paciente.mostrarDatosPantalla();
    }
}