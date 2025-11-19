
/**
 * Write a description of class Ingrediente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ingrediente
{
    private String nombre;
    private double precio;
    
    public Ingrediente(String p_nombre, double p_precio){
        this.setNombre(p_nombre);
        this.setPrecio(p_precio);
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setPrecio(double p_precio){
        this.precio = p_precio;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public String toString(){
        return this.getNombre() + " ($ " + this.getPrecio() + ")";
    }
}