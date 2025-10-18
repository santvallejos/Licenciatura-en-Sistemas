
/**
 * Clase que representa una cuenta de caja de ahorro bancaria.
 * Permite gestionar depósitos, extracciones y consultar el saldo.
 * Incluye un límite de extracciones posibles por período.
 * 
 * @author Sistema Bancario
 */
public class CajaDeAhorro extends CuentaBancaria {

    private int extraccionesPosibles;

    /**
     * Constructor básico de la cuenta de caja de ahorro.
     * Inicializa la cuenta con saldo cero y 10 extracciones posibles.
     * 
     * @param p_nroCuenta Número de cuenta a asignar
     * @param p_titular   Persona titular de la cuenta
     */
    CajaDeAhorro(int p_nroCuenta, Persona p_titular) {
        super(p_nroCuenta, p_titular, 0);
        this.setExtraccionesPosibles(10);
    }

    /**
     * Constructor completo de la cuenta de caja de ahorro.
     * Inicializa la cuenta con un saldo específico y 10 extracciones posibles.
     * 
     * @param p_nroCuenta Número de cuenta a asignar
     * @param p_titular   Persona titular de la cuenta
     * @param p_saldo     Saldo inicial de la cuenta
     */
    CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo) {
        super(p_nroCuenta, p_titular, p_saldo);
        this.setExtraccionesPosibles(10);
    }

    /**
     * establece las extracciones posibles restantes.
     * 
     * @param p_extraccionesPosibles número de extracciones posibles restantes
     */
    private void setExtraccionesPosibles(int p_extraccionesPosibles) {
        this.extraccionesPosibles = p_extraccionesPosibles;
    }

    /**
     * Obtiene las extracciones posibles restantes.
     * 
     * @return número de extracciones posibles restantes
     */
    public int getExtraccionesPosibles() {
        return this.extraccionesPosibles;
    }

    /**
     * Realiza la extracción de un importe si es posible.
     * Descuenta el importe del saldo y reduce las extracciones posibles.
     * 
     * @param p_importe Importe a extraer
     */
    @Override
    protected void extraccion(double p_importe) {
        super.extraccion(p_importe);
        this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
    }

    /**
     * Muestra en pantalla la información completa de la cuenta de caja de ahorro.
     * Incluye número de cuenta, saldo, titular y extracciones posibles restantes.
     * Redefinido del método mostrar() de la clase base CuentaBancaria.
     */
    @Override
    public void mostrar() {
        System.out.println("Caja de Ahorro --");
        System.out.println("Nro. Cuenta: " + this.getNroCuenta() + "-" + "Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().getNombre());
        System.out.println("Extracciones Posibles: " + this.getExtraccionesPosibles());
    }

}