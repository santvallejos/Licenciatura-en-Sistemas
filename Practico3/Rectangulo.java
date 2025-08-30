
/**
 * Write a description of class Rectangulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangulo
{
    private Punto origen;
    private double ancho;
    private double alto;

    Rectangulo(Punto p_origen, double p_ancho, double p_alto) {
        setOrigen(p_origen);
        setAncho(p_ancho);
        setAlto(p_alto);
    }

    Rectangulo(double p_ancho, double p_alto) {
        setOrigen(new Punto(0, 0));
        setAncho(p_ancho);
        setAlto(p_alto);
    }

    private void setOrigen(Punto p_origen) {
        this.origen = p_origen;
    }

    public Punto getOrigen() {
        return this.origen;
    }

    private void setAncho(double p_ancho) {
        this.ancho = p_ancho;
    }

    public double getAncho() {
        return this.ancho;
    }

    private void setAlto(double p_alto) {
        this.alto = p_alto;
    }

    public double getAlto() {
        return this.alto;
    }

    public void desplazar(double p_dx, double p_dy){
        getOrigen().desplazar(p_dx, p_dy);
    }

    public double perimetro() {
        return 2 * (getAncho() + getAlto());
    }

    public double superficie() {
        return getAncho() * getAlto();
    }

    public double distanciaA(Rectangulo otroRectangulo){
        double dx = getOrigen().getX() - otroRectangulo.getOrigen().getX();
        double dy = getOrigen().getY() - otroRectangulo.getOrigen().getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Rectangulo elMayor(Rectangulo otroRectangulo){
        if (this.superficie() > otroRectangulo.superficie()) {
            return this;
        } else {
            return otroRectangulo;
        }
    }

    public void caracteristicas() {
        System.out.println("****** Rectangulo ****** ");
        System.out.println("Origen: " + getOrigen() + " - Alto: " + getAlto() + " - Ancho: " + getAncho());
        System.out.println("Superficie: " + superficie() + " - Perímetro: " + perimetro());
    }
}