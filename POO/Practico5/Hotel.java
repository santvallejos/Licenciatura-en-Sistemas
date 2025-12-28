/**
 * La clase Hotel representa un tipo de alojamiento.
 */
public class Hotel extends Alojamiento
{
    private String tipoHabitacion;

    /**
     * Constructor de hotel
     * 
     * @param p_nombre
     * @param p_precioBase
     * @param p_diasAlquiler
     * @param p_tipoHabitacion
    */
    Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler, String p_tipoHabitacion) 
    {
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setTipoHabitacion(p_tipoHabitacion);
    }

    private void setTipoHabitacion(String p_tipoHabitacion) 
    {
        this.tipoHabitacion = p_tipoHabitacion;
    }

    public String getTipoHabitacion()
    {
        return this.tipoHabitacion;
    }

    @Override
    public double costo()
    {
        // Agregar costo adicional segun tipo de habitacion
        double tipoHabitacionCosto = 0;
        if( this.getTipoHabitacion().equals("Single"))
        {
            tipoHabitacionCosto = 20;
        }
        else
        {
            tipoHabitacionCosto = 35;
        }

        double costoBase = this.getPrecioBase() * this.getDiasAlquiler();
        double costoHabitacion = tipoHabitacionCosto * this.getDiasAlquiler();
        return costoBase + costoHabitacion;
    }

    @Override
    public int contar(String p_alojamiento)
    {
        if (p_alojamiento.equals("Hotel"))
        {
            return 1;
        }
        return 0;
    }

    @Override
    public void liquidar() {
        System.out.println("Alojamiento: " + this.getNombre());
        System.out.println("Costo por " + this.getDiasAlquiler() + " dias: $" + this.costo());
        listarServicios();
        System.out.println("Habitacion " + this.getTipoHabitacion());
        System.out.println("Total: -------> $" + (this.costo() + this.costoServicios()));
    }
}