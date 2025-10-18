import java.util.*;

public class Pedido
{
    private ArrayList<Renglon> renglones;

    /**
     * Constructor de la clase Pedido.
     * 
     * @param p_renglones
    */
    public Pedido(ArrayList<Renglon> p_renglones)
    {
        this.setRenglones(p_renglones);
    }

    private void setRenglones(ArrayList<Renglon> p_renglones)
    {
        this.renglones = p_renglones;
    }

    public ArrayList<Renglon> getRenglones()
    {
        return this.renglones;
    }

    /**
     * Muestra por pantalla el detalle del pedido, incluyendo la cantidad de items,
    */
    public void mostrar()
    {
        double importeTotal = 0;
        int totalEtiquetas = 0;
        System.out.println("Pedido: ");
        System.out.println("Cantidad de items: " + this.getRenglones().size());
        for (int i = 0; i < this.getRenglones().size(); i++) {
            System.out.print("Item " + (i + 1) + ": ");
            this.getRenglones().get(i).mostrar();
            importeTotal += this.getRenglones().get(i).getImporte();
            totalEtiquetas += this.getRenglones().get(i).getCantidad();
        }
        System.out.println("--- Total pedido: " + totalEtiquetas + " etiquetas por un importe total de: $" + importeTotal);
    }
}