
/**
 * Write a description of class Circulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circulo
{
    private double radio;
    private Punto centro;

    Circulo(double p_radio, Punto p_centro)
    {
        setRadio(p_radio);
        setCentro(p_centro);
    }

    Circulo()
    {
        setRadio(0);
        setCentro(new Punto(0, 0));
    }

    private void setRadio(double p_radio)
    {
        this.radio = p_radio;
    }

    public double getRadio()
    {
        return this.radio;
    }

    private void setCentro(Punto p_centro)
    {
        this.centro = p_centro;
    }

    public Punto getCentro()
    {
        return this.centro;
    }

    public void desplazar(double p_x, double p_y)
    {
        this.centro.desplazar(p_x, p_y);
    }

    public double perimetro()
    {
        return 2 * Math.PI * getRadio();
    }

    public double superficie()
    {
        return Math.PI * Math.pow(getRadio(), 2);
    }

    public double distanciaA(Circulo otroCirculo)
    {
        double distanciaX = this.centro.getX() - otroCirculo.getCentro().getX();
        double distanciaY = this.centro.getY() - otroCirculo.getCentro().getY();
        return Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
    }

    public Circulo elMayor(Circulo otroCirculo)
    {
        if (this.superficie() > otroCirculo.superficie())
        {
            return this;
        }
        return otroCirculo;
    }

    public void caracteristicas()
    {
        System.out.println("*********Circulo*********");
        System.out.println("Centro: " + getCentro() + "   -" + "Radio: " + getRadio());
        System.out.println("Superficie: " + superficie() + "   -" + "Périmetro: " + perimetro());
    }
}