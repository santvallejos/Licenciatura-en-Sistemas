import java.util.Calendar;

/**
 * Clase representativa de un Préstamo realizado por un Socio sobre un Libro.
 * 
 * @version 1.0
*/
public class Prestamo
{
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;

    /**
     * Constructor de la clase Prestamo.
     * 
     * @param p_fR - Fecha de retiro
     * @param p_socio - Socio que realiza el préstamo
     * @param p_libro - Libro que se presta
     */
    public Prestamo(Calendar p_fR, Socio p_socio, Libro p_libro)
    {
        this.setFechaRetiro(p_fR);
        this.fechaDevolucion = null;
        this.setSocio(p_socio);
        this.setLibro(p_libro);
    }

    // Getters y Setters
    private void setFechaRetiro(Calendar p_fR)
    {
        this.fechaRetiro = p_fR;
    }

    private void setFechaDevolucion(Calendar p_fD)
    {
        this.fechaDevolucion = p_fD;
    }

    private void setSocio(Socio p_socio)
    {
        this.socio = p_socio;
    }

    private void setLibro(Libro p_libro)
    {
        this.libro = p_libro;
    }

    public Calendar getFechaRetiro()
    {
        return this.fechaRetiro;
    }

    public Calendar getFechaDevolucion()
    {
        return this.fechaDevolucion;
    }

    public Socio getSocio()
    {
        return this.socio;
    }

    public Libro getLibro()
    {
        return this.libro;
    }

    /**
     * Registra la fecha de devolución del préstamo.
     * 
     * @param p_fecha - Fecha de devolución
    */
    public void registrarFechaDevolucion(Calendar p_fecha)
    {
        this.fechaDevolucion = p_fecha;
    }

    /**
     * Verifica si el préstamo está vencido en una fecha dada.
     * 
     * @param p_fecha - Fecha a verificar
     * @return true si el préstamo está vencido, false en caso contrario
    */
    public boolean vencido(Calendar p_fecha)
    {
        Calendar fechaVencimiento = Calendar.getInstance();
        fechaVencimiento.set(fechaRetiro.get(Calendar.YEAR),fechaRetiro.get(Calendar.MONTH),fechaRetiro.get(Calendar.DAY_OF_MONTH));
        fechaVencimiento.add(Calendar.DAY_OF_YEAR, getSocio().getDiasPrestamo());

        if(fechaVencimiento.before(this.getFechaDevolucion()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Representación en cadena del préstamo.
     * 
     * @return String - Representación en cadena del préstamo
    */
    public String toString()
    {
        String fechaRetiro = this.fechaRetiro.get(Calendar.YEAR) + "/" + (this.fechaRetiro.get(Calendar.MONTH) + 1) + "/" + this.fechaRetiro.get(Calendar.DAY_OF_MONTH);
        String fechaDevolucion;
        if (this.fechaDevolucion != null)
        {
            fechaDevolucion = this.fechaDevolucion.get(Calendar.YEAR) + "/" + (this.fechaDevolucion.get(Calendar.MONTH) + 1) + "/" + this.fechaDevolucion.get(Calendar.DAY_OF_MONTH);
        }
        else
        {
        fechaDevolucion = "Aún no devuelto";
        }
        return "Retiro: " + fechaRetiro + " - Devolución: " + fechaDevolucion + "\nLibro: " + this.libro.getTitulo() + "\nSocio: " + this.socio.getNombre();
    }
}