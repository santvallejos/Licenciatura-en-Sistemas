
/**
 * Clase que representa una cuenta de caja de ahorro bancaria.
 * Permite gestionar depósitos, extracciones y consultar el saldo.
 * Incluye un límite de extracciones posibles por período.
 * 
 * @author Sistema Bancario
 */
public class CajaDeAhorro {
    private int nroCuenta;
    private double saldo;
    private int extraccionesPosibles;
    private Persona titular;

    /**
     * Constructor básico de la cuenta de caja de ahorro.
     * Inicializa la cuenta con saldo cero y 10 extracciones posibles.
     * 
     * @param p_nroCuenta Número de cuenta a asignar
     * @param p_titular Persona titular de la cuenta
     */
    CajaDeAhorro(int p_nroCuenta, Persona p_titular) {
        this.setTitular(p_titular);
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(0);
        this.setExtraccionesPosibles(10);
    }

    /**
     * Constructor completo de la cuenta de caja de ahorro.
     * Inicializa la cuenta con un saldo específico y 10 extracciones posibles.
     * 
     * @param p_nroCuenta Número de cuenta a asignar
     * @param p_titular Persona titular de la cuenta
     * @param p_saldo Saldo inicial de la cuenta
     */
    CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
        this.setExtraccionesPosibles(10);
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    private void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public Persona getTitular() {
        return titular;
    }

    private void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private void setExtraccionesPosibles(int extraccionesPosibles) {
        this.extraccionesPosibles = extraccionesPosibles;
    }

    public int getExtraccionesPosibles() {
        return extraccionesPosibles;
    }

    /**
     * Deposita un importe en la cuenta de caja de ahorro.
     * El importe se suma al saldo actual.
     * 
     * @param p_importe Importe a depositar en la cuenta
     */
    public void depositar(double p_importe) {
        this.setSaldo(this.getSaldo() + p_importe);
    }

    /**
     * Extrae un importe de la cuenta de caja de ahorro.
     * Solo se realiza la extracción si hay saldo suficiente y extracciones disponibles.
     * 
     * @param p_importe Importe a extraer de la cuenta
     */
    public void extraer(double p_importe) {
        this.extraccion(p_importe);
    }

    /**
     * Verifica si es posible extraer un importe determinado.
     * La extracción es posible si el importe no supera el saldo disponible.
     * 
     * @param p_importe Importe que se desea extraer
     * @return true si la extracción es posible, false en caso contrario
     */
    private boolean puedeExtraer(double p_importe) {
        if (p_importe <= this.getSaldo()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Realiza la extracción de un importe si es posible.
     * Descuenta el importe del saldo y reduce las extracciones posibles.
     * 
     * @param p_importe Importe a extraer
     */
    private void extraccion(double p_importe) {
        if (this.puedeExtraer(p_importe)) {
            this.setSaldo(this.getSaldo() - p_importe);
            this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
        }
    }

    /**
     * Muestra en pantalla la información completa de la cuenta de caja de ahorro.
     * Incluye número de cuenta, saldo, titular y extracciones posibles restantes.
     */
    public void mostrar() {
        System.out.println("Caja de Ahorro --");
        System.out.println("Nro. Cuenta: " + this.getNroCuenta() + "-" + "Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().getNombre());
        System.out.println("Extracciones Posibles: " + this.getExtraccionesPosibles());
    }
}