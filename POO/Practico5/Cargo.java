import java.util.*;

/**
 * Write a description of class Cargo here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cargo {
    private String nombreCargo;
    private double sueldoBasico;
    private int anioIngreso;
    private int horasDeDocencia;

    Cargo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDeDocencia)
    {
        this.setNombreCargo(p_nombreCargo);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAnioIngreso(p_anioIngreso);
        this.setHorasDeDocencia(p_horasDeDocencia);
    }

    private void setNombreCargo(String p_nombreCargo) 
    {
        this.nombreCargo = p_nombreCargo;
    }

    public String getNombreCargo() 
    {
        return this.nombreCargo;
    }

    private void setSueldoBasico(double p_sueldoBasico) 
    {
        this.sueldoBasico = p_sueldoBasico;
    }

    public double getSueldoBasico() 
    {
        return this.sueldoBasico;
    }

    private void setAnioIngreso(int p_anioIngreso) 
    {
        this.anioIngreso = p_anioIngreso;
    }

    public int getAnioIngreso() 
    {
        return this.anioIngreso;
    }

    private void setHorasDeDocencia(int p_horasDeDocencia) 
    {
        this.horasDeDocencia = p_horasDeDocencia;
    }

    public int getHorasDeDocencia() 
    {
        return this.horasDeDocencia;
    }

    /**
     * Devolver la antiguedad del usuario
     * 
     * @return int - Antiguedad en años
    */
    public int antiguedad() 
    {
        Calendar fechaHoy = Calendar.getInstance(); // Fecha actual
        int anioHoy = fechaHoy.get(Calendar.YEAR); // Año actual
        int anioIngreso = this.getAnioIngreso();
        return anioHoy - anioIngreso; // Diferencia de años
    }

    /**
     * Devolver la adicional por cada año de antiguedad
     * 
     * @return double - Adicional por antiguedad
    */
    private double adicionalXantiguedad() 
    {
        return this.getSueldoBasico() * 0.01 * this.antiguedad();
    }

    /**
     * Devolver el sueldo del cargo
     * 
     * @return double - Sueldo del cargo
    */
    public double sueldoDelCargo()
    {
        return this.getSueldoBasico() + adicionalXantiguedad();
    }

    /**
     * Mostrar el cargo
    */
    public void mostrarCargo() 
    {
        System.out.println (this.getNombreCargo() + " - Sueldo Basico: " + getSueldoBasico() + " - Sueldo Cargo: " + sueldoDelCargo() + " - Antiguedad: " + this.antiguedad() + " años");
        System.out.println("Horas Docencia: " + getHorasDeDocencia());
    }
}