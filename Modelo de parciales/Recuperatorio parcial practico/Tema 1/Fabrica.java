import java.util.ArrayList;
import java.util.HashMap;

/**
 * Principal funcionalidad es de controlar la venta de pizzas y el stock de ingredientes.
*/
public class Fabrica
{
    private double ventasTotales;
    private ArrayList<Pizza> pizzas;
    private HashMap<Ingrediente, Integer> stock;

    /*Cuando se instancia esta clase la idea es trabajar a medida que se utiliza la aplicacion es de ahi donde se obtienen los datos*/
    public Fabrica(ArrayList<Pizza> p_pizzas, HashMap<Ingrediente, Integer> p_stock)
    {
        this.setVentasTotales(0);
        this.setPizzas(p_pizzas);
        this.setStock(p_stock);
    }

    // Getters y setters
    private void setVentasTotales(double ventasTotales)
    {
        this.ventasTotales = ventasTotales;
    }

    public double getVentasTotales()
    {
        return this.ventasTotales;
    }

    private void setPizzas(ArrayList<Pizza> pizzas)
    {
        this.pizzas = pizzas;
    }

    public ArrayList<Pizza> getPizzas()
    {
        return this.pizzas;
    }

    private void setStock(HashMap<Ingrediente, Integer> stock)
    {
        this.stock = stock;
    }

    public HashMap<Ingrediente, Integer> getStock()
    {
        return this.stock;
    }

    public void listaDePrecios()
    {
        System.out.println("=== Precios de Pizzas ===");
        for (Pizza p : this.getPizzas())
        {
            System.out.print(p.mensajeVenta());
            System.out.println();
        }
    }

    public void mostrarStock()
    {
        System.out.println("=== Stock actual de ingredientes ===");
        for (Ingrediente i : this.getStock().keySet())
        {
            System.out.println(i.toString() + " :" + this.getStock().get(i));
        }
    }

    public void reponerIngrediente(Ingrediente i, int c)
    {
        if (this.getStock().containsKey(i))
        {
            int cantidadActual = this.getStock().get(i);
            this.getStock().put(i, cantidadActual + c);
        }
        else
        {
            this.getStock().put(i, c);
        }
    }

    // Al vender una pizza se tiene que actualizar el stock
    private void reducirStock(Pizza p)
    {
        for (Ingrediente i : p.getIngredientes())
        {
            if (this.getStock().containsKey(i))
            {
                int cantidadActual = this.getStock().get(i);
                this.getStock().put(i, cantidadActual - 1);
            }
        }
    }

    // para vender una pizza tenemos que verificar que haya stock de ingredientes
    public boolean verificarStock(Pizza p)
    {
        for (Ingrediente i : p.getIngredientes())
        {
            if (!this.getStock().containsKey(i) || this.getStock().get(i) <= 0)
            {
                return false; // No hay stock suficiente
            }
        }
        return true; // Hay stock suficiente
    }

    public void venderPizza(String p_nombrePizza)
    {
        for (Pizza p : this.getPizzas())
        {
            if (p.getNombre().equalsIgnoreCase(p_nombrePizza))
            {
                if (this.verificarStock(p))
                {
                    this.reducirStock(p);
                    double precioVenta = p.calcularPrecio();
                    this.setVentasTotales(this.getVentasTotales() + precioVenta);
                    System.out.println("Pizza " + p.getNombre() + " vendida por $" + precioVenta);
                }
                else
                {
                    System.out.println("No hay stock suficiente para vender la pizza " + p.getNombre());
                }
                return; // Salir después de encontrar la pizza
            }
        }
        System.out.println("La pizza " + p_nombrePizza + " no existe en el menú.");
    }
}
