import java.util.*;
/**
 * Clase representativa de un Libro que puede contener una lista de prestamos de dicho libro.
 * 
 * @version 1.0
 */
public class Libro
{
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList<Prestamo> prestamos;

    /**
     * Constructor de la clase Libro con una lista de préstamos.
     * 
     * @param p_titulo
     * @param p_edicion
     * @param p_editorial
     * @param p_anio
     * @param p_prestamos
    */
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio, ArrayList<Prestamo> p_prestamos)
    {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(p_prestamos);
    }

    // Getters y Setters
    private void setTitulo(String p_titulo)
    {
        this.titulo = p_titulo;
    }

    public String getTitulo()
    {
        return this.titulo;
    }

    private void setEdicion(int p_edicion)
    {
        this.edicion = p_edicion;
    }

    public int getEdicion()
    {
        return this.edicion;
    }

    private void setEditorial(String p_editorial)
    {
        this.editorial = p_editorial;
    }

    public String getEditorial()
    {
        return this.editorial;
    }

    private void setAnio(int p_anio)
    {
        this.anio = p_anio;
    }

    public int getAnio()
    {
        return this.anio;
    }

    private void setPrestamos(ArrayList<Prestamo> p_prestamos)
    {
        this.prestamos = p_prestamos;
    }

    public ArrayList<Prestamo> getPrestamos()
    {
        return this.prestamos;
    }

    /**
     * Indica si el libro se encuentra prestado o no.
     * 
     * @return boolean - true si el libro se encuentra prestado, false en caso contrario.
    */
    public boolean prestado()
    {
        return !this.prestamos.isEmpty();
    }

    /**
     * Devuelve el último préstamo realizado del libro.
     * 
     * @return Prestamo - Último préstamo realizado del libro. Null si no tiene préstamos.
    */
    public Prestamo ultimoPrestamo()
    {
        if (this.prestamos.isEmpty()) {
            return null;
        }
        return this.prestamos.get(this.prestamos.size() - 1); // Obtener el último préstamo y se le resta -1 porque los índices comienzan en 0 y size devuelve la cantidad total de elementos
    }

    public String toString()
    {
        return "Título: " + this.getTitulo();
    }
}