
/**
 * Clase que representa una cuenta corriente bancaria.
 * Permite gestionar depósitos, extracciones con un límite de descubierto.
 * A diferencia de la caja de ahorro, permite extraer más allá del saldo
 * disponible
 * hasta un límite establecido.
 * 
 * @author Sistema Bancario
 */
public class CuentaCorriente extends CuentaBancaria {
    private double limiteDescubierto;

    /**
     * Constructor básico de la cuenta corriente.
     * Inicializa la cuenta con saldo cero y límite de descubierto de 500.
     * 
     * @param p_nroCuenta Número de cuenta a asignar
     * @param p_titular   Persona titular de la cuenta
     */
    CuentaCorriente(int p_nroCuenta, Persona p_titular) {
        super(p_nroCuenta, p_titular, 0);
        this.setLimiteDescubierto(500);
    }

    /**
     * Constructor completo de la cuenta corriente.
     * Inicializa la cuenta con un saldo específico y límite de descubierto de 500.
     * 
     * @param p_nroCuenta Número de cuenta a asignar
     * @param p_titular   Persona titular de la cuenta
     * @param p_saldo     Saldo inicial de la cuenta
     */
    CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo) {
        super(p_nroCuenta, p_titular, p_saldo);
        this.setLimiteDescubierto(500);
    }

    /**
     * Establece el limite Descubierto
     * 
     * @param p_limiteDescubierto
     */
    private void setLimiteDescubierto(double p_limiteDescubierto) {
        this.limiteDescubierto = p_limiteDescubierto;
    }

    /**
     * Obtiene el Limite Descubierto
     * 
     * @return el numero de Limite Descubierto
     */
    public double getLimiteDescubierto() {
        return this.limiteDescubierto;
    }

    /**
     * Verifica si es posible extraer un importe determinado.
     * La extracción es posible si no supera el saldo más el límite de descubierto.
     * 
     * @param p_importe Importe que se desea extraer
     * @return true si la extracción es posible, false en caso contrario
     */
    @Override
    protected boolean puedeExtraer(double p_importe) {
        if (p_importe <= this.getSaldo() && p_importe <= this.getLimiteDescubierto()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Muestra en pantalla la información completa de la cuenta corriente.
     * Incluye número de cuenta, saldo, titular y límite de descubierto.
     * Redefinido del metodo mostrar() de la clase CuentaBancaria
     */
    @Override
    public void mostrar() {
        System.out.println("- Cuenta Corriente -- " + this.getNroCuenta());
        System.out.println("Nro. Cuenta:  - " + this.getNroCuenta() + " Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().getNombre());
        System.out.println("Descubierto: " + this.getLimiteDescubierto());
    }
}