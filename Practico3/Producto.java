/**
 * Write a description of class Producto here.
 * 
 * @author 
 * @version (a version number or a date)
 */
public class Producto
{
    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio laboratorio;

    /** 
     * 
    */
    Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, double p_porcPtoRepo, int p_existMinima, Laboratorio p_lab)
    {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setStock(0);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExistMinima(p_existMinima);
        this.setLaboratorio(p_lab);
    }

    Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio p_lab)
    {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setStock(0);
        this.setLaboratorio(p_lab);
    }

    private void setCodigo(int p_codigo)
    {
        this.codigo = p_codigo;
    }

    public int getCodigo()
    {
        return this.codigo;
    }

    private void setRubro(String p_rubro)
    {
        this.rubro = p_rubro;
    }

    public String getRubro()
    {
        return this.rubro;
    }

    private void setDescripcion(String p_descripcion)
    {
        this.descripcion = p_descripcion;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }

    private void setCosto(double p_costo)
    {
        this.costo = p_costo;
    }

    public double getCosto()
    {
        return this.costo;
    }

    private void setStock(int p_stock)
    {
        this.stock = p_stock;
    }

    public int getStock()
    {
        return this.stock;
    }

    private void setPorcPtoRepo(double p_porcPtoRepo)
    {
        this.porcPtoRepo = p_porcPtoRepo;
    }

    public double getPorcPtoRepo()
    {
        return this.porcPtoRepo;
    }

    private void setExistMinima(int p_existMinima)
    {
        this.existMinima = p_existMinima;
    }

    public int getExistMinima()
    {
        return this.existMinima;
    }

    private void setLaboratorio(Laboratorio p_laboratorio)
    {
        this.laboratorio = p_laboratorio;
    }

    public Laboratorio getLaboratorio()
    {
        return this.laboratorio;
    }

    // Como saber cuando se esta agregando o quitando dependiendo del parametro que se pasa.
    public void ajuste(int p_cantidad)
    {
        this.setStock(this.getStock() + p_cantidad);
    }

    public double precioLista()
    {
        // El precio de lista es el costo mas un 12%
        return getCosto() + (getCosto() * 0.12);
    }

    public double precioContado()
    {
        //  El método  precioContado() devuelve el valor que representa el precio por pago al contado del producto, que se calcula restando un 5% al precio de lista.
        return getCosto() - (getCosto() * 0.05);
    }

    public double stockValorizado()
    {
        // Devuelve el valor de stock valorizado mas una rentabilidad del 12%
        return (this.getStock() * this.getCosto()) + (this.getCosto() * 0.12);
    }

    public void ajustarPtoRepo(double p_porce)
    {
        this.setPorcPtoRepo(p_porce);
    }

    public void ajustarExistMinima(int p_cantidad)
    {
        this.setExistMinima(p_cantidad);
    }

    public void mostrar()
    {
        System.out.println("Laboratorio: " + this.getLaboratorio().getNombre());
        System.out.println("Domicilio: " + this.getLaboratorio().getDomicilio() + "  - " + "Teléfono: " + this.getLaboratorio().getTelefono());

        System.out.println();

        System.out.println("Rubro: " + this.getRubro());
        System.out.println("Descripción: " + this.getDescripcion());
        System.out.println("Precio Costo: " + this.getCosto());
        System.out.println("Stock: " + this.getStock() + "  - " + "Stock Valorizado: $" + this.stockValorizado());
    }

    public String mostrarLinea()
    {
        return this.getDescripcion() + "   " + this.precioLista() + "   " + this.getCosto(); 
    }
}
