
/**
 * Figura geometrica es una clase abstracta que representa una figura de las que se estan especializando
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class FiguraGeometrica
{
    private Punto origen;

    FiguraGeometrica()
    {
        setOrigen(0, 0);
    }

    FiguraGeometrica(double p_x, double p_y)
    {
        setOrigen(p_x, p_y);
    }

    private void setOrigen(double p_x, double p_y)
    {
        this.origen = new Punto(p_x, p_y);
    }

    public Punto getOrigen()
    {
        return this.origen;
    }

    /**
     * Devolver el nombre de la figura
     * 
     * @return String - nombre de la figura
    */
    public abstract String nombreFigura();

    /**
     * Calcular la superficie de la figura
     * 
     * @return double - superficie de la figura
    */
    public abstract double superficie();

    /**
     * Mostrar la superficie de la figura
    */
    public abstract void mostrarSuperficie();
}