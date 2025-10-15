import java.util.*;
/**
 * La clase alojamiento es una clases abstracta que representara distintos tipos de alojamientos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Alojamiento
{
    private String nombre;
    private double precioBase;
    private int diasAlquiler;
    private ArrayList<Servicio> servicios;

    /**
     * Constructor de alojamiento con una lista de serivicios vacia
     * 
     * @param p_nombre
     * @param p_precioBase
     * @param p_diasAlquiler
    */
    Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler) 
    {
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquiler(p_diasAlquiler);
        this.setServicios(new ArrayList<>());
    }

    /**
     * Constructor de alojamiento con una lista de servicios dada
     * 
     * @param p_nombre
     * @param p_precioBase
     * @param p_diasAlquiler
     * @param p_servicios
    */
    Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList<Servicio> p_servicios) 
    {
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquiler(p_diasAlquiler);
        this.setServicios(p_servicios);
    }

    private void setNombre(String p_nombre) 
    {
        this.nombre = p_nombre;
    }

    public String getNombre() 
    {
        return this.nombre;
    }

    private void setPrecioBase(double p_precioBase) 
    {
        this.precioBase = p_precioBase;
    }

    public double getPrecioBase() 
    {
        return this.precioBase;
    }

    private void setDiasAlquiler(int p_diasAlquiler) 
    {
        this.diasAlquiler = p_diasAlquiler;
    }

    public int getDiasAlquiler() 
    {
        return this.diasAlquiler;
    }

    private void setServicios(ArrayList<Servicio> p_servicios) 
    {
        this.servicios = p_servicios;
    }

    public ArrayList<Servicio> getServicios() 
    {
        return this.servicios;
    }

    /**
     * Crear un nuevo servicio de alojamiento
     * 
     * @param p_servicio - servicio a agregar
     * @return boolean - true si se pudo crear el servicio, false en caso contrario
    */
    public boolean agregarServicio(Servicio p_servicio)
    {
        return this.getServicios().add(p_servicio);
    }

    /**
     * Quitar un servicio de alojamiento
     * 
     * @param p_servicio - servicio a quitar
     * @return boolean - true si se pudo quitar el servicio, false en caso contrario
    */
    public boolean quitarServicio(Servicio p_servicio)
    {
        return this.getServicios().remove(p_servicio);
    }

    /**
     * Contar los servicios de un tipo de alojamiento
     * 
     * @param p_alojamiento
     * @return int - cantidad de servicios del tipo de alojamiento
    */
    public abstract int contar(String p_alojamiento);

    /**
     * Calcular el costo del alojamiento
     * 
     * @return double - costo del alojamiento
    */
    public abstract double costo();

    /**
     * Listar los servicios de alojamiento
    */
    public void listarServicios()
    {
        for (Servicio servicio : this.getServicios()) 
        {
            System.out.println(servicio.getDescription() + ": $" + servicio.getPrecio());
        }
    }

    /**
     * Calcular el precio total de los servicios
     * 
     * @return double - precio total de los servicios
    */
    public double costoServicios()
    {
        double costoTotal = 0;
        for (Servicio servicio : this.getServicios()) 
        {
            costoTotal += servicio.getPrecio();
        }
        return costoTotal;
    }

    /**
     * Liquidar el alojamiento
    */
    public abstract void liquidar();
}