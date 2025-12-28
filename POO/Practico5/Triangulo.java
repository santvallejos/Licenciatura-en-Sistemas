
/**
 * Write a description of class Triangulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triangulo extends FiguraGeometrica
{
    private double base;
    private double altura;

    Triangulo(double p_base, double p_altura)
    {
        super();
        setBase(p_base);
        setAltura(p_altura);
    }

    Triangulo(double p_x, double p_y, double p_base, double p_altura)
    {
        super(p_x, p_y);
        setBase(p_base);
        setAltura(p_altura);
    }

    private void setBase(double p_base)
    {
        this.base = p_base;
    }

    public double getBase()
    {
        return this.base;
    }

    private void setAltura(double p_altura)
    {
        this.altura = p_altura;
    }

    public double getAltura()
    {
        return this.altura;
    }

    @Override
    public String nombreFigura()
    {
        return "Triángulo";
    }

    @Override
    public double superficie()
    {
        return (this.base * this.altura) / 2;
    }

    @Override
    public void mostrarSuperficie()
    {
        System.out.println("La superficie del " + nombreFigura() + " es: " + superficie());
    }
}