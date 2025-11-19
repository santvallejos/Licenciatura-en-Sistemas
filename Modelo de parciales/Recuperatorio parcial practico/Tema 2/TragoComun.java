import java.util.ArrayList;

/**
 * Write a description of class TragoComun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TragoComun extends Trago
{
    public TragoComun(String p_nombre, ArrayList<Ingrediente> p_ingredientes){
        super(p_nombre, p_ingredientes);
    }
    
    public double calcularPrecio(){
        double precio = 100;
        
        for(Ingrediente ingrediente : this.getIngredientes()){
            precio += ingrediente.getPrecio();
        }
        return precio;
    }
    
    public String mensajeVenta(){
        return "TRAGO COMÚN";
    }
}