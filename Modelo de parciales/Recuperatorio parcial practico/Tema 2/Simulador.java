import java.util.ArrayList;
import java.util.HashMap;

/**
 * Write a description of class Simulador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Simulador
{
    public static void main (String [] args){
        Ingrediente hielo = new Ingrediente ("Hielo", 5.0);
        Ingrediente fernet = new Ingrediente ("Fernet", 20.0);
        Ingrediente cocaCola = new Ingrediente ("Coca Cola", 10);
        Ingrediente gin = new Ingrediente ("Gin", 30.0);
        
        ArrayList<Ingrediente> comun = new ArrayList<>();
        comun.add(cocaCola);
        comun.add(hielo);
        comun.add(fernet);
        
        TragoComun tragoComun = new TragoComun("Fernet con Coca", comun);
        
        ArrayList<Ingrediente> autor = new ArrayList<>();
        autor.add(fernet);
        autor.add(hielo);
        autor.add(gin);
        
        TragoDeAutor tragoDeAutor = new TragoDeAutor("La Bomba", autor);
        
        HashMap<Ingrediente, Integer> stock = new HashMap<>();
        stock.put(hielo, 8);
        stock.put(fernet, 2);
        stock.put(cocaCola, 10);
        stock.put(gin, 4);
        
        ArrayList<Trago> tragos = new ArrayList<>();
        tragos.add(tragoComun);
        tragos.add(tragoDeAutor);
        tragos.add(tragoDeAutor);
        
        Barra barra = new Barra(tragos, stock);
        barra.listaDePrecios();
        barra.mostrarStock();
        
        System.out.println("\n=== SIMULACIÓN DE VENTAS ===");
        barra.venderTrago ("Fernet con Coca");
        barra.venderTrago ("La Bomba");
        barra.venderTrago ("La Bomba");
        System.out.println("===================================");
        System.out.println("Ventas totales: $" + barra.getVentasTotales());
        
        System.out.println();
        barra.mostrarStock();
    }
}