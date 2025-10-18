public class Renglon
{
    private Etiqueta item;
    private int cantidad;
    private double importe;

    Renglon(Etiqueta p_item, int p_cantidad, double p_importe)
    {
        this.setItem(p_item);
        this.setCantidad(p_cantidad);
        this.setImporte(p_importe);
    }

    private void setItem(Etiqueta p_item)
    {
        this.item = p_item;
    }

    public Etiqueta getItem()
    {
        return this.item;
    }

    private void setCantidad(int p_cantidad)
    {
        this.cantidad = p_cantidad;
    }

    public int getCantidad()
    {
        return this.cantidad;
    }

    private void setImporte(double p_importe)
    {
        this.importe = p_importe;
    }

    public double getImporte()
    {
        return this.importe;
    }

    public void mostrar()
    {
        System.out.println(this.getCantidad() + " Etiquetas de tipo " + this.getItem().toString());
    }
}