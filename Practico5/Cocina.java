
/**
 * Clase que hereda de Artefacto Hogar
 * 
 * @version 1.0
 * @author Ivan Benitez
 */

public class Cocina extends ArtefactoHogar {
    private int hornillas;
    private int calorias;
    private String dimensiones;

    /**
     * Constructor de la clase Cocina
     * 
     * @param p_marca       Marca de la cocina
     * @param p_precio      Precio de la cocina
     * @param p_stock       Stock de la cocina
     * @param p_hornillas   Hornillas de la cocina
     * @param p_calorias    Calorias de la cocina
     * @param p_dimensiones Dimensiones de la cocina
     * 
     */
    Cocina(String p_marca, float p_precio, int p_stock, int p_hornillas, int p_calorias, String p_dimensiones) {
        super(p_marca, p_precio, p_stock);
        this.setHornillas(p_hornillas);
        this.setCalorias(p_calorias);
        this.setDimensiones(p_dimensiones);
    }

    /**
     * Establece las hornillas de la cocina
     * 
     * @param p_hornillas
     */
    public void setHornillas(int p_hornillas) {
        this.hornillas = p_hornillas;
    }

    /**
     * Obtiene las hornillas de la cocina
     * 
     * @return hornillas de la cocina
     */
    public int getHornillas() {
        return this.hornillas;
    }

    /**
     * Establece las calorias de la cocina
     * 
     * @param p_calorias
     */
    public void setCalorias(int p_calorias) {
        this.calorias = p_calorias;
    }

    /**
     * Obtiene las calorias de la cocina
     * 
     * @return calorias de la cocina
     */
    public int getCalorias() {
        return this.calorias;
    }

    /**
     * Establece las dimensiones de la cocina
     * 
     * @param p_dimensiones
     */
    public void setDimensiones(String p_dimensiones) {
        this.dimensiones = p_dimensiones;
    }

    /**
     * Obtiene las dimensiones de la cocina
     * 
     * @return las dimensiones de la cocina
     */
    public String getDimensiones() {
        return this.dimensiones;
    }

    /**
     * Imprime los datos de la cocina
     */
    @Override
    public void imprimir() {
        System.out.println("**** Cocina ****");
        super.imprimir();
        System.out.println("Hornillas: " + this.getHornillas());
        System.out.println("Calorias: " + this.getCalorias());
        System.out.println("Dimensiones: " + this.getDimensiones());
    }

    /**
     * @param p_cuotas
     * @param p_interes
     * @return Monto de la cuotaCredito
     */
    @Override
    public float creditoConAdicional(int p_cuotas, float p_interes) {
        return this.cuotaCredito(p_cuotas, p_interes);
    }

}