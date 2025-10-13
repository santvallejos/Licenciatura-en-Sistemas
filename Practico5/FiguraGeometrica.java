
/**
 * Figura geometrica es una clase abstracta que representa una figura de las que se estan especializando
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiguraGeometrica
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

    public String nombreFigura()
    {
        return "Figura Geométrica";
    }

    public double superficie()
    {
        return 0;
    }

    public void mostrarSuperficie()
    {
        System.out.println("Superficie: " + superficie());
    }
}