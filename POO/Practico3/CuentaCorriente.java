
/**
 * Clase que representa una cuenta corriente bancaria.
 * Permite gestionar depósitos, extracciones con un límite de descubierto.
 * A diferencia de la caja de ahorro, permite extraer más allá del saldo disponible
 * hasta un límite establecido.
 * 
 * @author Sistema Bancario
 */
public class CuentaCorriente
{
    private int nroCuenta;
    private double saldo;
    private double limiteDescubierto;
    private Persona titular;

    /**
     * Constructor básico de la cuenta corriente.
     * Inicializa la cuenta con saldo cero y límite de descubierto de 500.
     * 
     * @param p_nroCuenta Número de cuenta a asignar
     * @param p_titular Persona titular de la cuenta
     */
    CuentaCorriente(int p_nroCuenta, Persona p_titular)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0);
        this.setLimiteDescubierto(500);
    }

    /**
     * Constructor completo de la cuenta corriente.
     * Inicializa la cuenta con un saldo específico y límite de descubierto de 500.
     * 
     * @param p_nroCuenta Número de cuenta a asignar
     * @param p_titular Persona titular de la cuenta
     * @param p_saldo Saldo inicial de la cuenta
     */
    CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
        this.setLimiteDescubierto(500);
    }

    private void setNroCuenta(int p_nroCuenta)
    {
        this.nroCuenta = p_nroCuenta;
    }

    public int getNroCuenta()
    {
        return this.nroCuenta;
    }

    private void setSaldo(double p_saldo)
    {
        this.saldo = p_saldo;
    }

    public double getSaldo()
    {
        return this.saldo;
    }

    private void setLimiteDescubierto(double p_limiteDescubierto)
    {
        this.limiteDescubierto = p_limiteDescubierto;
    }

    public double getLimiteDescubierto()
    {
        return this.limiteDescubierto;
    }

    private void setTitular(Persona p_titular)
    {
        this.titular = p_titular;
    }

    public Persona getTitular()
    {
        return this.titular;
    }

    /**
     * Deposita un importe en la cuenta corriente.
     * El importe se suma al saldo actual.
     * 
     * @param p_saldo Importe a depositar en la cuenta
     */
    public void depositar(double p_saldo)
    {
        this.setSaldo(this.getSaldo() + p_saldo);
    }

    /**
     * Extrae un importe de la cuenta corriente.
     * Permite extraer hasta el límite de descubierto establecido.
     * 
     * @param p_importe Importe a extraer de la cuenta
     */
    public void extraer(double p_importe)
    {
        this.extraccion(p_importe);
    }

    /**
     * Verifica si es posible extraer un importe determinado.
     * La extracción es posible si no supera el saldo más el límite de descubierto.
     * 
     * @param p_importe Importe que se desea extraer
     * @return true si la extracción es posible, false en caso contrario
     */
    private boolean puedeExtraer(double p_importe)
    {
        if(p_importe <= this.getSaldo() && p_importe <= this.getLimiteDescubierto())
        {
            return true;
        } 
        else
        {
            return false;
        }
    }

    /**
     * Realiza la extracción de un importe si es posible.
     * Descuenta el importe del saldo actual.
     * 
     * @param p_importe Importe a extraer
     */
    private void extraccion(double p_importe)
    {
        if(this.puedeExtraer(p_importe))
        {
            this.setSaldo(this.getSaldo() - p_importe);
        }
    }

    /**
     * Muestra en pantalla la información completa de la cuenta corriente.
     * Incluye número de cuenta, saldo, titular y límite de descubierto.
     */
    public void mostrar()
    {
        System.out.println("- Cuenta Corriente -- " + this.getNroCuenta());
        System.out.println("Nro. Cuenta:  - " + this.getNroCuenta() + " Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().getNombre());
        System.out.println("Descubierto: " + this.getLimiteDescubierto());
    }
}