import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class Barra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barra
{
    private double ventasTotales;
    private ArrayList<Trago> tragos;
    private HashMap<Ingrediente, Integer> stock;
    
    public Barra(ArrayList<Trago> p_tragos, HashMap<Ingrediente, Integer> p_stock){
        this.setVentasTotales(0);
        this.setTragos(p_tragos);
        this.setStock(p_stock);
    }
    
    private void setVentasTotales(double p_ventas){
        this.ventasTotales = p_ventas;
    }
    
    private void setTragos(ArrayList <Trago> p_tragos){
        this.tragos = p_tragos;
    }
    
    private void setStock (HashMap<Ingrediente, Integer> p_stock){
        this.stock = p_stock;
    }
    
    public double getVentasTotales(){
        return this.ventasTotales;
    }
    
    public ArrayList<Trago> getTragos(){
        return this.tragos;
    }
    
    public HashMap<Ingrediente, Integer> getStock(){
        return this.stock;
    }
    
    public boolean agregarTrago(Trago p_trago){
        return this.getTragos().add(p_trago);
    }
    
    public boolean quitarTrago(Trago p_trago){
        if(this.getTragos().size() > 1){
            return this.getTragos().remove(p_trago);
        }
        return false;
    }
    
    public void agregarIngrediente(Ingrediente p_ingrediente, int p_stock){
        this.getStock().put(p_ingrediente, p_stock);
    }
    
    public void quitarIngrediente(Ingrediente p_ingrediente){
        if(this.getStock().size() > 1){
            this.getStock().remove(p_ingrediente);
        }
    }
    
    public void listaDePrecios(){
        System.out.println("==== PRECIOS DE TRAGOS ====");
    
        for(Trago trago : this.getTragos()){
            System.out.println(trago.toString() + ": $" + trago.calcularPrecio());
        }
    }
    
    public void mostrarStock(){
        System.out.println("==== STOCK ACTUAL DE INGREDIENTES ====");
        
        for(Map.Entry<Ingrediente, Integer> ingrediente : this.getStock().entrySet()){
            System.out.println(ingrediente.getKey().toString() + ": " + ingrediente.getValue());
        }
    }
    
    private void reducirStock(Trago p_trago){
        for(Ingrediente ingrediente : p_trago.getIngredientes()){
            for(Map.Entry <Ingrediente, Integer> entrada : this.getStock().entrySet()){
                if(ingrediente.equals(entrada.getKey())){
                    //Dos formas de resolver:
                    
                    //this.getStock().put(entrada.getKey(), entrada.getValue() - 1);
                    entrada.setValue(entrada.getValue() - 1);
                }
            }
        }
    }
    
    public void reponerIngrediente(Ingrediente p_ingrediente, int p_cantidad){
        int stockActual = this.getStock().get(p_ingrediente);
        this.agregarIngrediente(p_ingrediente, stockActual + p_cantidad);
    }
    
    public void venderTrago (String p_nombre){
        //Buscamos el trago cuyo nombre coincida con p_nombre
        Trago tragoVender = null;
        for(Trago trago : this.getTragos()){
            if(trago.getNombre().equalsIgnoreCase(p_nombre)){
                tragoVender = trago;
                break;
            }
        }
        
        if(verificarStock(tragoVender)){
            reducirStock(tragoVender);
            System.out.println(tragoVender.toString() + ": $" + tragoVender.calcularPrecio());
            this.setVentasTotales(this.getVentasTotales() + tragoVender.calcularPrecio());
        } else {
            System.out.println("Sin stock para: " + tragoVender.getNombre());
        }
    }
    
    private boolean verificarStock(Trago p_trago){
        for(Ingrediente ingrediente : p_trago.getIngredientes()){
            for(Map.Entry<Ingrediente, Integer> entrada : this.getStock().entrySet()){
                if(entrada.getKey().equals(ingrediente) && entrada.getValue() == 0){
                    return false;
                }
            }
        }
        //return true;
        
        
        //Esta parte es por si no existe el ingrediente en la lista de stock directamente, se puede omitir:
        int contar = 0;
        for(Ingrediente ingrediente : p_trago.getIngredientes()){
            for(Map.Entry<Ingrediente, Integer> entrada : this.getStock().entrySet()){
                if(entrada.getKey().equals(ingrediente)){
                    contar++;
                }
            }
        }
        
        if(p_trago.getIngredientes().size() == contar){
            return true;
        }
        return false;
    }
}