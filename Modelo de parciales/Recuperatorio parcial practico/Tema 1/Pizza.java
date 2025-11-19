import java.util.ArrayList;

public abstract class Pizza 
{
    private String nombre;
    private ArrayList<Ingrediente> ingredientes;

    public Pizza(String p_nombre, ArrayList<Ingrediente> p_ingredientes) 
    {
        this.setNombre(p_nombre);
        this.setIngredientes(p_ingredientes);
    }

    // Getters y setters
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    private void setIngredientes(ArrayList<Ingrediente> p_ingredientes)
    {
        this.ingredientes = p_ingredientes;
    }

    public ArrayList<Ingrediente> getIngredientes()
    {
        return this.ingredientes;
    }

    public boolean agregarIngrediente(Ingrediente p_ingrediente)
    {
        return this.getIngredientes().add(p_ingrediente);
    }

    // La lista no puede quedar vacia
    public boolean eliminarIngrediente(Ingrediente p_ingrediente)
    {
        if(this.getIngredientes().size() > 1)
        {
            return this.getIngredientes().remove(p_ingrediente);
        }
        return false;
    }

    public abstract double calcularPrecio();

    public abstract String mensajeVenta();

    public String toString()
    {
        String texto = this.getNombre() + " (";
        for(Ingrediente i : this.getIngredientes())
        {
            texto += i.getNombre() + ", ";
        }
        texto = texto.substring(0, texto.length() - 2) + ")";
        return texto;
    }
}
