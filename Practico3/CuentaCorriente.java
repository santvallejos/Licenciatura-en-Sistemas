
/**
 * Write a description of class CuentaCorriente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CuentaCorriente
{
    private int nroCuenta;
    private double saldo;
    private double limiteDescubierto;
    private Persona titular;

    CuentaCorriente(int p_nroCuenta, Persona p_titular)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0);
        this.setLimiteDescubierto(500);
    }

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

    public void depositar(double p_saldo)
    {
        this.setSaldo(this.getSaldo() + p_saldo);
    }

    public void extraer(double p_importe)
    {
        this.extraccion(p_importe);
    }

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

    private void extraccion(double p_importe)
    {
        if(this.puedeExtraer(p_importe))
        {
            this.setSaldo(this.getSaldo() - p_importe);
        }
    }

    public void mostrar()
    {
        System.out.println("- Cuenta Corriente -- " + this.getNroCuenta());
        System.out.println("Nro. Cuenta:  - " + this.getNroCuenta() + " Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().getNombre());
        System.out.println("Descubierto: " + this.getLimiteDescubierto());
    }
}