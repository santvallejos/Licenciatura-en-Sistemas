
/**
 * Clase Lavarropas que hereda de ArtefactoHogar
 * 
 * @version 1.0
 * @author Ivan Benitez
 */
public class Lavarropas extends ArtefactoHogar {
    private int programas;
    private float kilos;
    private boolean automatico;

    /**
     * Constructor de la clase Lavarropas
     * 
     * @param p_marca
     * @param p_precio
     * @param p_stock
     * @param p_programas
     * @param p_kilos
     * @param p_automatico
     */
    public Lavarropas(String p_marca, float p_precio, int p_stock, int p_programas, float p_kilos,
            boolean p_automatico) {
        super(p_marca, p_precio, p_stock);
        this.setProgramas(p_programas);
        this.setKilos(p_kilos);
        this.setAutomatico(p_automatico);
    }

    /**
     * Establece los programas del lavarropas
     * 
     * @param p_programas
     */
    public void setProgramas(int p_programas) {
        this.programas = p_programas;
    }

    /**
     * Obtiene los programas del lavarropas
     * 
     * @return programas del lavarropas
     */
    public int getProgramas() {
        return this.programas;
    }

    /**
     * Establece los kilos del lavarropas
     * 
     * @param p_kilos
     */
    public void setKilos(float p_kilos) {
        this.kilos = p_kilos;
    }

    /**
     * Obtiene los kilos del lavarropas
     * 
     * @return kilos del lavarropas
     */
    public float getKilos() {
        return this.kilos;
    }

    /**
     * Establece si el lavarropas es automatico
     * 
     * @param p_automatico
     */
    public void setAutomatico(boolean p_automatico) {
        this.automatico = p_automatico;
    }

    /**
     * Obtiene si el lavarropas es automatico
     * 
     * @return automatico del lavarropas
     */
    public boolean getAutomatico() {
        return this.automatico;
    }

    /**
     * Imprime los datos del lavarropas
     */
    @Override
    public void imprimir() {
        System.out.println("**** Lavarropas ****");
        super.imprimir();
        System.out.println("Progamas: " + this.getProgramas());
        System.out.println("Kilos: " + this.getKilos());
        System.out.println("Automatico: " + this.getAutomatico());
    }

    /**
     * Calcula la cuota del credito con adicional si el lavarropas no es automatico
     * 
     * @param p_cuotas
     * @param p_interes
     * @return cuota con adicional si no es automatico
     * @return cuota sin adicional si es automatico
     * 
     */
    @Override
    public float creditoConAdicional(int p_cuotas, float p_interes) {
        if (this.getAutomatico() == false) {
            float precioOriginal = this.getPrecio(); // asignamos en una variable temporal el precio original.
            float interes = precioOriginal * p_interes / 100; // calculamos el interes.
            float precioConInteres = precioOriginal + interes; // calculamos el precio con interes.
            float precioConDescuento = precioConInteres * 0.98f; // aplicamos el descuento del 2%
            float cuota = precioConDescuento / p_cuotas; // calculamos la cuota.
            return cuota;
        } else {
            return this.cuotaCredito(p_cuotas, p_interes);
        }

    }
}