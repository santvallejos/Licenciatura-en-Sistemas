import java.util.ArrayList;

public class PizzaSimple extends Pizza
{
    public PizzaSimple(String p_nombre, ArrayList<Ingrediente> p_ingredientes)
    {
        super(p_nombre, p_ingredientes);
    }

    @Override
    public double calcularPrecio()
    {
        double precioTotal = 100.0; // Precio base de la pizza simple
        for (Ingrediente i : this.getIngredientes())
        {
            precioTotal += i.getPrecio();
        }
        return precioTotal;
    }

    @Override
    public String mensajeVenta()
    {
        return "Pizza Simple: " + super.getNombre() + super.toString() + " - $" + this.calcularPrecio();
    }
}
