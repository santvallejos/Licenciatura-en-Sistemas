import java.util.ArrayList;

/**
 * Write a description of class TragoDeAutor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TragoDeAutor extends Trago
{
    public TragoDeAutor(String p_nombre, ArrayList<Ingrediente> p_ingredientes){
        super(p_nombre, p_ingredientes);
    }
    
    public double calcularPrecio(){
        double precio = 150;
        int contador = 0;
        
        for(Ingrediente ingrediente : this.getIngredientes()){
            contador ++;
            if(contador > 3){
                precio += 10;
            }
        }
        return precio;
    }
    
    public String mensajeVenta(){
        return "TRAGO DE AUTOR";
    }
}