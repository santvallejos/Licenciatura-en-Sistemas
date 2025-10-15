
/**
 * Write a description of class Cuadrado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuadrado extends Rectangulo
{
    Cuadrado(int p_x, int p_y, double p_lado){
        super(p_x, p_y, p_lado, p_lado);
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