
/**
 * Clase que representa un círculo en el plano cartesiano.
 * Permite calcular el perímetro, superficie, distancia entre círculos,
 * y realizar operaciones geométricas básicas.
 * 
 * @author Sistema de Geometría
 */
public class Circulo
{
    private double radio;
    private Punto centro;

    /**
     * Constructor parametrizado del círculo.
     * Crea un círculo con radio y centro específicos.
     * 
     * @param p_radio Radio del círculo
     * @param p_centro Punto que representa el centro del círculo
     */
    Circulo(double p_radio, Punto p_centro)
    {
        setRadio(p_radio);
        setCentro(p_centro);
    }

    /**
     * Constructor por defecto del círculo.
     * Crea un círculo con radio 0 y centro en el origen (0,0).
     */
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

    /**
     * Desplaza el círculo moviendo su centro por los incrementos especificados.
     * 
     * @param p_x Incremento en la coordenada x
     * @param p_y Incremento en la coordenada y
     */
    public void desplazar(double p_x, double p_y)
    {
        this.centro.desplazar(p_x, p_y);
    }

    /**
     * Calcula el perímetro del círculo.
     * 
     * @return Perímetro del círculo (2 * π * radio)
     */
    public double perimetro()
    {
        return 2 * Math.PI * getRadio();
    }

    /**
     * Calcula la superficie del círculo.
     * 
     * @return Superficie del círculo (π * radio²)
     */
    public double superficie()
    {
        return Math.PI * Math.pow(getRadio(), 2);
    }

    /**
     * Calcula la distancia entre los centros de este círculo y otro círculo.
     * 
     * @param otroCirculo Círculo al cual se calculará la distancia
     * @return Distancia entre los centros de los círculos
     */
    public double distanciaA(Circulo otroCirculo)
    {
        double distanciaX = this.centro.getX() - otroCirculo.getCentro().getX();
        double distanciaY = this.centro.getY() - otroCirculo.getCentro().getY();
        return Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
    }

    /**
     * Determina cuál círculo tiene mayor superficie entre este y otro círculo.
     * 
     * @param otroCirculo Círculo a comparar
     * @return El círculo con mayor superficie
     */
    public Circulo elMayor(Circulo otroCirculo)
    {
        if (this.superficie() > otroCirculo.superficie())
        {
            return this;
        }
        return otroCirculo;
    }

    /**
     * Muestra en pantalla las características del círculo.
     * Incluye centro, radio, superficie y perímetro.
     */
    public void caracteristicas()
    {
        System.out.println("*********Circulo*********");
        System.out.println("Centro: " + getCentro() + "   -" + "Radio: " + getRadio());
        System.out.println("Superficie: " + superficie() + "   -" + "Périmetro: " + perimetro());
    }
}