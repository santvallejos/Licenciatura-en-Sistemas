
/**
 * Write a description of class Exclusivo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exclusivo extends Cargo
{
    private int horasDeInvestigacion;
    private int horasDeExtension;

    Exclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int horasDeDocencia, int p_horasDeInvestigacion, int p_horasDeExtension)
    {
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, horasDeDocencia);
        this.setHorasDeInvestigacion(p_horasDeInvestigacion);
        this.setHorasDeExtension(p_horasDeExtension);
    }

    private void setHorasDeInvestigacion(int p_horasDeInvestigacion) 
    {
        this.horasDeInvestigacion = p_horasDeInvestigacion;
    }

    public int getHorasDeInvestigacion() 
    {
        return this.horasDeInvestigacion;
    }

    private void setHorasDeExtension(int p_horasDeExtension) 
    {
        this.horasDeExtension = p_horasDeExtension;
    }

    public int getHorasDeExtension() 
    {
        return this.horasDeExtension;
    }

    @Override
    public void mostrarCargo()
    {
        super.mostrarCargo();
        System.out.println("----Cargo de caracter SemiExclusivo----");
        System.out.println("Horas investigación: " + this.getHorasDeInvestigacion());
        System.out.println("Horas extensión: " + this.getHorasDeExtension());
    }
}