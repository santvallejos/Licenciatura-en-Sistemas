/**
 * Write a description of class SemiExclusivo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SemiExclusivo extends Cargo
{
    private int horasDeInvestigacion;

    SemiExclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int horasDeDocencia, int p_horasDeInvestigacion)
    {
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, horasDeDocencia);
        this.setHorasDeInvestigacion(p_horasDeInvestigacion);
    }

    private void setHorasDeInvestigacion(int p_horasDeInvestigacion) 
    {
        this.horasDeInvestigacion = p_horasDeInvestigacion;
    }

    public int getHorasDeInvestigacion() 
    {
        return this.horasDeInvestigacion;
    }

    @Override
    public void mostrarCargo()
    {
        super.mostrarCargo();
        System.out.println("----Cargo de caracter SemiExclusivo----");
        System.out.println("Horas investigación: " + this.getHorasDeInvestigacion());
    }
}