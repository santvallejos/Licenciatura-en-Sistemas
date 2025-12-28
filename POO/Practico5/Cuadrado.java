
/**
 * Write a description of class Cuadrado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuadrado extends Rectangulo
{
    Cuadrado(int p_x, int p_y, double p_lado){
        super(p_lado, p_lado, p_x, p_y);
    }

    public String nombreFigura(){
        return "******Cuadrado******";
    }

    @Override
    public double superficie()
    {
        return Math.pow(this.getAncho(), 2);
    }

    @Override
    public void mostrarSuperficie()
    {
        System.out.println("Superficie: " + this.superficie());
    }

    public void caracteristicas(){
        System.out.println(this.nombreFigura());
        System.out.println("Lado: " + this.getAncho());
        System.out.println("Origen: " + this.getOrigen());
        System.out.println("Superficie: " + this.superficie() + " - Perímetro: " + this.perimetro());
    }
}