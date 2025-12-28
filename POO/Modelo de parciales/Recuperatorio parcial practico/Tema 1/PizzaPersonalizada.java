import java.util.ArrayList;

public class PizzaPersonalizada extends Pizza 
{
    public PizzaPersonalizada(String p_nombre, ArrayList<Ingrediente> p_ingredientes) 
    {
        super(p_nombre, p_ingredientes);
    }

    @Override
    public double calcularPrecio()
    {
        double precioTotal = 150.0; // Precio base para pizza personalizada
        // Tiene que incluir hasta 3 ingredientes sin costo adicional, luego de eso, cada ingrediente adicional suma 10.0
        int ingredientesGratis = 3;

        if (this.getIngredientes().size() > ingredientesGratis) // Si hay más de 3 ingredientes
        {
            int ingredientesAdicionales = this.getIngredientes().size() - ingredientesGratis;
            precioTotal += ingredientesAdicionales * 10.0; // Sumamos el costo extra que tiene por mas de 3 ingredientes
        }

        for (Ingrediente i : this.getIngredientes()) // Luego sumamos el precio de todos los ingredientes
        {
            precioTotal += i.getPrecio();
        }
        return precioTotal;
    }

    @Override
    public String mensajeVenta()
    {
        return "Pizza Personalizada: " + super.toString() + " - $" + this.calcularPrecio();
    }
}
