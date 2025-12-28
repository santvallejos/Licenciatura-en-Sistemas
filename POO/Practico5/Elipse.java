/**
 * Write a description of class Elipse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elipse extends FiguraGeometrica{
    //instance
    private double sEjeMayor;
    private double sEjeMenor;

    Elipse(double p_sEjeMayor, double p_sEjeMenor)
    {
        super(0, 0);
        this.setSEjeMayor(p_sEjeMayor);
        this.setSEjeMenor(p_sEjeMenor);
    }

    /**
     * Constructor de la clase Elipse
     */
    public Elipse(double p_x, double p_y, double p_sEjeMayor, double p_sEjeMenor){
        super(p_x, p_y); 
        this.setSEjeMayor(p_sEjeMayor);
        this.setSEjeMenor(p_sEjeMenor);
    }

    private void setSEjeMayor(double p_sEjeMayor){
        this.sEjeMayor = p_sEjeMayor;
    }
    
    private void setSEjeMenor(double p_sEjeMenor){
        this.sEjeMenor = p_sEjeMenor;
    }
    
    public double getSEjeMayor(){
        return this.sEjeMayor;
    }
    
    public double getSEjeMenor(){
        return this.sEjeMenor;
    }

    @Override
    public String nombreFigura (){
        return "******** Elipse ********";
    }

    @Override
    public double superficie(){
        return Math.PI * this.getSEjeMayor() * this.getSEjeMenor();
    }

    @Override
    public void mostrarSuperficie()
    {
        System.out.println("Superficie: " + this.superficie());
    }

    /**
     * Metodo caracteristicas
     */
    public void caracteristicas (){
        System.out.println(nombreFigura());
        System.out.println("Centro: (" + this.getOrigen().getX() + ", " + this.getOrigen().getY() + ") - Semieje Mayor: " + this.getSEjeMayor() + " - Semieje Menor: " + this.getSEjeMenor());
        System.out.println("Superficie: " + this.superficie());
    }

    /**
     * Metodo elMayor
     * @param otraElipse
     * @return el mas grande
     */
    public Elipse elMayor (Elipse otraElipse){
        if (this.superficie() > otraElipse.superficie()){
            return this;
        }
        else{
            return otraElipse;
        }
    }
}