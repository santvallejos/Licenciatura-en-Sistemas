
/**
 * Clase ArtefactoHogar
 * 
 * @version 1.0
 * @author Ivan Benitez
 */
public abstract class ArtefactoHogar {
    private String marca;
    private float precio;
    private int stock;

    /**
     * Constructor de la clase ArtefactoHogar
     * 
     * @param p_marca  Marca del artefacto
     * @param p_precio Precio del artefacto
     * @param p_stock  Stock del artefacto
     * 
     */
    public ArtefactoHogar(String p_marca, float p_precio, int p_stock) {
        this.setMarca(p_marca);
        this.setPrecio(p_precio);
        this.setStock(p_stock);
    }

    /**
     * Establece la marca del artefacto
     * 
     * @param p_marca
     */
    public void setMarca(String p_marca) {
        this.marca = p_marca;
    }

    /**
     * Obtiene la marca del artefacto
     * 
     * @return marca del artefacto
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * Establece el precio del artefacto
     * 
     * @param p_precio
     */
    public void setPrecio(float p_precio) {
        this.precio = p_precio;
    }

    /**
     * Obtiene el precio del artefacto
     * 
     * @return precio del artefacto
     */
    public float getPrecio() {
        return this.precio;
    }

    /**
     * Establece el stock del artefacto
     * 
     * @param p_stock
     */
    public void setStock(int p_stock) {
        this.stock = p_stock;
    }

    /**
     * Obtiene el stock del artefacto
     * 
     * @return stock del artefacto
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Imprime los datos del artefacto
     */
    public void imprimir() {
        System.out.println("Marca: " + this.getMarca() + " - " + " Precio: " + this.getPrecio() + " - " + " Stock: "
                + this.getStock());
    }

    /**
     * Calcula la cuota del credito
     * 
     * @param p_cuotas
     * @param p_interes
     * @return cuota del credito
     */
    public float cuotaCredito(int p_cuotas, float p_interes) {
        float precioOriginal = this.getPrecio();
        float interes = precioOriginal * p_interes / 100;
        float precioConInteres = precioOriginal + interes;
        float cuota = precioConInteres / p_cuotas;
        return cuota;
    }

    /**
     * Calcula la cuota del credito con adicional
     * 
     * @param p_cuotas
     * @param p_interes
     * @return
     */
    public abstract float creditoConAdicional(int p_cuotas, float p_interes);

}