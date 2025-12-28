/**
 * La clase Cabaña representa un tipo de alojamiento.
 */
public class Cabaña extends Alojamiento
{
    private int nroHabitaciones;

    /**
     * Constructor de cabaña 
     * 
     * @param p_nombre
     * @param p_precioBase
     * @param p_diasAlquiler
    */
    Cabaña(String p_nombre, double p_precioBase, int p_diasAlquiler, int p_nroHabitaciones) 
    {
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setNroHabitaciones(p_nroHabitaciones);
    }

    private void setNroHabitaciones(int p_nroHabitaciones) 
    {
        this.nroHabitaciones = p_nroHabitaciones;
    }

    public int getNroHabitaciones() 
    {
        return this.nroHabitaciones;
    }

    @Override
    public double costo()
    {
        double costoBase = this.getPrecioBase() * this.getDiasAlquiler();
        double costoHabitaciones = 30 * this.getDiasAlquiler() * this.getNroHabitaciones();
        return costoBase + costoHabitaciones;
    }

    @Override
    public int contar(String p_alojamiento)
    {
        if (p_alojamiento.equals("Cabaña")) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void liquidar()
    {
        System.out.println("Alojamiento: " + this.getNombre());
        System.out.println("Costo por " + this.getDiasAlquiler() + " días: $" + this.costo() + " alquiler");
        this.listarServicios();
        System.out.println("Cabaña con " + this.getNroHabitaciones() + " habitaciones");
        System.out.println("Total: -------> $" + (this.costo() + this.costoServicios()));
    }
}