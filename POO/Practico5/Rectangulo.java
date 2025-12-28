
/**
 * Clase que representa un rectángulo en el plano cartesiano.
 * Permite crear rectángulos con un punto de origen, ancho y alto específicos,
 * y realizar operaciones geométricas básicas como cálculo de superficie y perímetro.
 * 
 * @author Sistema de Geometría
 */
public class Rectangulo extends FiguraGeometrica
{
    private double ancho;
    private double alto;

    /**
     * Constructor completo del rectángulo.
     * Crea un rectángulo con origen, ancho y alto específicos.
     * 
     * @param p_ancho Ancho del rectángulo
     * @param p_alto Alto del rectángulo
     * @param p_x Coordenada x del origen del rectángulo
     * @param p_y Coordenada y del origen del rectángulo
     */
    Rectangulo(double p_ancho, double p_alto, int p_x, int p_y) 
    {
        super(p_x, p_y);
        setAncho(p_ancho);
        setAlto(p_alto);
    }

    /**
     * Constructor básico del rectángulo.
     * Crea un rectángulo con origen en (0,0) y dimensiones específicas.
     * 
     * @param p_ancho Ancho del rectángulo
     * @param p_alto Alto del rectángulo
     */
    Rectangulo(double p_ancho, double p_alto) 
    {
        super(0, 0);
        setAncho(p_ancho);
        setAlto(p_alto);
    }

    private void setAncho(double p_ancho) 
    {
        this.ancho = p_ancho;
    }

    public double getAncho() 
    {
        return this.ancho;
    }

    private void setAlto(double p_alto) 
    {
        this.alto = p_alto;
    }

    public double getAlto() 
    {
        return this.alto;
    }

    @Override
    public String nombreFigura()
    {
        return "******Rectángulo******";
    }

    /**
     * Desplaza el rectángulo moviendo su origen por los incrementos especificados.
     * 
     * @param p_dx Incremento en la coordenada x
     * @param p_dy Incremento en la coordenada y
     */
    public void desplazar(double p_dx, double p_dy)
    {
        getOrigen().desplazar(p_dx, p_dy);
    }

    /**
     * Calcula el perímetro del rectángulo.
     * 
     * @return Perímetro del rectángulo (2 * (ancho + alto))
     */
    public double perimetro() 
    {
        return 2 * (getAncho() + getAlto());
    }

    @Override
    public double superficie() 
    {
        return getAncho() * getAlto();
    }

    @Override
    public void mostrarSuperficie()
    {
        System.out.println("Superficie: " + this.superficie());
    }

    /**
     * Calcula la distancia entre los orígenes de este rectángulo y otro rectángulo.
     * 
     * @param otroRectangulo Rectángulo al cual se calculará la distancia
     * @return Distancia entre los orígenes de los rectángulos
     */
    public double distanciaA(Rectangulo otroRectangulo){
        double dx = getOrigen().getX() - otroRectangulo.getOrigen().getX();
        double dy = getOrigen().getY() - otroRectangulo.getOrigen().getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Determina cuál rectángulo tiene mayor superficie entre este y otro rectángulo.
     * 
     * @param otroRectangulo Rectángulo a comparar
     * @return El rectángulo con mayor superficie
     */
    public Rectangulo elMayor(Rectangulo otroRectangulo){
        if (this.superficie() > otroRectangulo.superficie()) {
            return this;
        } else {
            return otroRectangulo;
        }
    }

    /**
     * Muestra en pantalla las características del rectángulo.
     * Incluye origen, alto, ancho, superficie y perímetro.
     */
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        System.out.println("Origen: " + getOrigen() + " - Alto: " + getAlto() + " - Ancho: " + getAncho());
        System.out.println("Superficie: " + superficie() + " - Perímetro: " + perimetro());
    }
}