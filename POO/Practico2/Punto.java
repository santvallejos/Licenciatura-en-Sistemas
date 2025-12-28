
/**
 * Representa un punto en el plano cartesiano bidimensional.
 * La clase permite crear puntos con coordenadas (x, y), desplazarlos
 * y obtener información sobre su posición.
 * 
 * @author Sofía Cubilla
 */
public class Punto
{
    private double x;
    private double y;

    /**
     * Constructor por defecto que crea un punto en el origen (0, 0).
     */
    Punto()
    {
        setX(0);
        setY(0);
    }

    /**
     * Constructor que crea un punto con coordenadas específicas.
     * 
     * @param p_x Coordenada x del punto
     * @param p_y Coordenada y del punto
     */
    Punto(double p_x, double p_y)
    {
        setX(p_x);
        setY(p_y);
    }

    /**
     * Establece la coordenada x del punto.
     * 
     * @param p_x Nueva coordenada x
     */
    private void setX(double p_x)
    {
        this.x = p_x;
    }

    /**
     * Obtiene la coordenada x del punto.
     * 
     * @return Coordenada x actual del punto
     */
    public double getX()
    {
        return this.x;
    }

    /**
     * Establece la coordenada y del punto.
     * 
     * @param p_y Nueva coordenada y
     */
    private void setY(double p_y)
    {
        this.y = p_y;
    }

    /**
     * Obtiene la coordenada y del punto.
     * 
     * @return Coordenada y actual del punto
     */
    public double getY()
    {
        return this.y;
    }

    /**
     * Desplaza el punto sumando los incrementos especificados a sus coordenadas actuales.
     * 
     * @param p_dx Incremento en la coordenada x
     * @param p_dy Incremento en la coordenada y
     */
    public void desplazar(double p_dx, double p_dy)
    {
        setX(getX() + p_dx);
        setY(getY() + p_dy);
    }

    /**
     * Devuelve las coordenadas del punto en formato de cadena.
     * 
     * @return Cadena con formato "(x, y)" representando las coordenadas del punto
     */
    public String coordenadas()
    {
        return "(" + getX() + ", " + getY() + ")";
    }

    /**
     * Muestra por consola la información del punto.
     * Formato de salida: "Punto. X: [x], Y: [y]"
     */
    public void mostrar()
    {
        System.out.println("Punto. " + "X: " + getX() + ", Y: " + getY());
    }
}
