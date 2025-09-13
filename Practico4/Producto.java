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
     * Constructor completo de la clase Producto.
     * Inicializa un producto con todos sus atributos.
     * 
     * @param p_codigo Código del producto
     * @param p_rubro Rubro del producto
     * @param p_desc Descripción del producto
     * @param p_costo Costo del producto
     * @param p_porcPtoRepo Porcentaje de punto de reposición del producto
     * @param p_existMinima Existencia mínima del producto
     * @param p_lab Laboratorio del producto
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

    /** 
     * Constructor básico de la clase Producto.
     * Inicializa un producto con los atributos esenciales.
     * El porcentaje de punto de reposición y la existencia mínima quedan sin definir.
     * 
     * @param p_codigo Código del producto
     * @param p_rubro Rubro del producto
     * @param p_desc Descripción del producto
     * @param p_costo Costo del producto
     * @param p_lab Laboratorio del producto
    */
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

    /**
     * Ajusta el stock del producto.
     * 
     * @param p_cantidad Cantidad a ajustar (puede ser positiva o negativa)
     */
    public void ajuste(int p_cantidad)
    {
        this.setStock(this.getStock() + p_cantidad);
    }

    /**
     * Calcula el precio de lista del producto.
     * 
     * @return Precio de lista del producto
     */
    public double precioLista()
    {
        return getCosto() + (getCosto() * 0.12); // El precio de lista es el costo mas un 12%
    }

    /**
     * Calcula el precio de contado del producto.
     * 
     * @return Precio de contado del producto
     */
    public double precioContado()
    {
        return getCosto() - (getCosto() * 0.05); // El precio de contado es el costo menos un 5%
    }

    /**
     * Calcula el valor de stock valorizado del producto.
     * 
     * @return Valor de stock valorizado del producto
     */
    public double stockValorizado()
    {
        return (this.getStock() * this.getCosto()) + (this.getCosto() * 0.12);
    }

    /**
     * Ajusta el porcentaje de punto de reposición del producto.
     * 
     * @param p_porce Porcentaje de punto de reposición a asignar
     */
    public void ajustarPtoRepo(double p_porce)
    {
        this.setPorcPtoRepo(p_porce);
    }

    /**
     * Ajusta la existencia mínima del producto.
     * 
     * @param p_cantidad Cantidad de existencia mínima a asignar
     */
    public void ajustarExistMinima(int p_cantidad)
    {
        this.setExistMinima(p_cantidad);
    }

    /**
     * Muestra la información del producto.
     */
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

    /**
     * Muestra una línea de información del producto.
     * 
     * @return Línea de información del producto
     */
    public String mostrarLinea()
    {
        return this.getDescripcion() + "   " + this.precioLista() + "   " + this.getCosto(); 
    }
}
