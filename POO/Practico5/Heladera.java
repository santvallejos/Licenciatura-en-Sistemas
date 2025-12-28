
/**
 * Clase Heladera que hereda de ArtefactoHogar
 * 
 * @version 1.0
 * @author Ivan Benitez
 */
public class Heladera extends ArtefactoHogar {
    private int pies;
    private int puertas;
    private boolean compresor;

    /**
     * Constructor de la clase Heladera
     * 
     * @param p_marca     Marca de la heladera
     * @param p_precio    Precio de la heladera
     * @param p_stock     Stock de la heladera
     * @param p_pies      Pies de la heladera
     * @param p_puertas   Puertas de la heladera
     * @param p_compresor Indica si la heladera tiene compresor
     */
    public Heladera(String p_marca, float p_precio, int p_stock, int p_pies, int p_puertas, boolean p_compresor) {
        super(p_marca, p_precio, p_stock);
        this.setPies(p_pies);
        this.setPuertas(p_puertas);
        this.setCompresor(p_compresor);
    }

    /**
     * Establece los pies de la heladera
     * 
     * @param p_pies
     */
    public void setPies(int p_pies) {
        this.pies = p_pies;
    }

    /**
     * Obtiene los pies de la heladera
     * 
     * @return pies de la heladera
     */
    public int getPies() {
        return this.pies;
    }

    /**
     * Establece las puertas de la heladera
     * 
     * @param p_puertas
     */
    public void setPuertas(int p_puertas) {
        this.puertas = p_puertas;
    }

    /**
     * Obtiene las puertas de la heladera
     * 
     * @return puertas de la heladera
     */
    public int getPuertas() {
        return this.puertas;
    }

    /**
     * Establece si la heladera tiene compresor
     * 
     * @param p_compresor
     */
    public void setCompresor(boolean p_compresor) {
        this.compresor = p_compresor;
    }

    /**
     * Obtiene si la heladera tiene compresor
     * 
     * @return true si tiene compresor, false en caso contrario
     */
    public boolean getCompresor() {
        return this.compresor;
    }

    /**
     * Imprime los detalles de la heladera.
     * 
     */
    @Override
    public void imprimir() {
        System.out.println("**** Heladera ****");
        super.imprimir();
        System.out.println("Pies: " + this.getPies());
        System.out.println("Puertas: " + this.getPuertas());
        System.out.println("Compresor: " + this.getCompresor());
    }

    @Override
    /**
     * Calcula la cuota de crédito con un adicional si la heladera tiene compresor.
     * 
     * @param p_cuotas  Número de cuotas
     * @param p_interes Tasa de interés
     * @return Monto de la cuota de crédito con adicional si tiene compresor
     * @return Monto de la cuota de crédito sin adicional si no tiene compresor
     */
    public float creditoConAdicional(int p_cuotas, float p_interes) {

        if (this.getCompresor() == true) {
            float precioOriginal = this.getPrecio(); // asignamos en una variable temporal el precio original.
            float interes = precioOriginal * p_interes / 100; // calculamos el interes.
            float precioConInteres = precioOriginal + interes; // calculamos el precio con interes.
            float precioConadicional = precioConInteres + 50; // agregamos un adicional al precio si contiene compresor.
            float cuota = precioConadicional / p_cuotas; // dividimos el precio con adicional por las cuotas.
            return cuota;

        } else {
            return this.cuotaCredito(p_cuotas, p_interes);

        }

    }

}
