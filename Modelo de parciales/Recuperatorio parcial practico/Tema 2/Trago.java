import java.util.ArrayList;

/**
 * Write a description of class Trago here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Trago
{
    private String nombre;
    private ArrayList<Ingrediente> ingredientes;
    
    public Trago(String p_nombre, ArrayList<Ingrediente> p_ingredientes){
        this.setNombre(p_nombre);
        this.setIngredientes(p_ingredientes);
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setIngredientes(ArrayList <Ingrediente> p_ingredientes){
        this.ingredientes = p_ingredientes;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public ArrayList<Ingrediente> getIngredientes(){
        return this.ingredientes;
    }
    
    public boolean agregarIngrediente(Ingrediente p_ingrediente){
        return this.getIngredientes().add(p_ingrediente);
    }
    
    public boolean quitarIngrediente(Ingrediente p_ingrediente){
        if(this.getIngredientes().size() > 1){
            return this.getIngredientes().remove(p_ingrediente);
        }
        return false;
    }
    
    public abstract double calcularPrecio();
    
    public abstract String mensajeVenta();
    
    public String toString(){
        String cadena = "";
        
        for(Ingrediente ingrediente : this.getIngredientes()){
            cadena = cadena + ingrediente.getNombre() + ", ";
        }
        return this.getNombre() +" (" + cadena + ")";
    }
}