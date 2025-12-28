/**
 * Clase que representa una cuenta bancaria con operaciones básicas de depósito y extracción.
 * Cada cuenta bancaria está asociada a una persona (titular) y mantiene un registro del saldo actual.
 * 
 * @author Sistema Bancario POO
 * @version 1.0
 */
public class CuentaBancaria {
    private int nroCuenta;
    private double saldo;
    private Persona titular;

    /**
     * Constructor que inicializa una cuenta bancaria con número de cuenta y titular.
     * El saldo inicial se establece en 0.0 por defecto.
     * 
     * @param p_nroCuenta Número único que identifica la cuenta bancaria
     * @param p_titular Persona que es titular de la cuenta bancaria
     */
    CuentaBancaria(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0.0);
    }

    /**
     * Constructor que inicializa una cuenta bancaria con número de cuenta, titular y saldo inicial.
     * 
     * @param p_nroCuenta Número único que identifica la cuenta bancaria
     * @param p_titular Persona que es titular de la cuenta bancaria
     * @param p_saldo Saldo inicial de la cuenta bancaria
     */
    CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }

    /**
     * Establece el número de cuenta bancaria.
     * 
     * @param p_nroCuenta Número de cuenta a asignar
     */
    private void setNroCuenta(int p_nroCuenta) {
        this.nroCuenta = p_nroCuenta;
    }

    /**
     * Establece el saldo de la cuenta bancaria.
     * 
     * @param p_saldo Saldo a asignar a la cuenta
     */
    private void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
    }

    /**
     * Establece el titular de la cuenta bancaria.
     * 
     * @param p_titular Persona titular de la cuenta
     */
    private void setTitular(Persona p_titular) {
        this.titular = p_titular;
    }

    /**
     * Obtiene el número de cuenta bancaria.
     * 
     * @return Número de cuenta bancaria
     */
    public int getNroCuenta() {
        return this.nroCuenta;
    }

    /**
     * Obtiene el saldo actual de la cuenta bancaria.
     * 
     * @return Saldo actual de la cuenta
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Obtiene el titular de la cuenta bancaria.
     * 
     * @return Persona titular de la cuenta
     */
    public Persona getTitular() {
        return this.titular;
    }

    /**
     * Realiza un depósito en la cuenta bancaria aumentando el saldo.
     * El importe debe ser un valor positivo para realizar la operación.
     * 
     * @param p_importe Cantidad de dinero a depositar (debe ser mayor a 0)
     * @return El nuevo saldo después del depósito, o el saldo actual si el importe es inválido
     */
    public double depositar(double p_importe) {
        if (p_importe > 0) {
            this.saldo += p_importe;
        }
        return this.saldo;
    }

    /**
     * Realiza una extracción de la cuenta bancaria disminuyendo el saldo.
     * Solo se permite extraer si hay fondos suficientes y el importe es positivo.
     * 
     * @param p_importe Cantidad de dinero a extraer (debe ser mayor a 0 y menor o igual al saldo)
     * @return El nuevo saldo después de la extracción, o el saldo actual si la operación no es válida
     */
    public double extraer(double p_importe) {
        if (p_importe > 0 && p_importe <= this.saldo) {
            this.saldo -= p_importe;
        }
        return this.saldo;
    }

    /**
     * Muestra por consola la información completa de la cuenta bancaria.
     * Incluye los datos del titular y el estado actual de la cuenta.
     * Formato de salida según especificación: número, titular, saldo tabulado.
     */
    public void mostrar() {
        System.out.println("- Cuenta Bancaria -");
        System.out.println("Titular: " + this.titular.apeYNom() + " (" + this.titular.edad() + " años)");
        System.out.println("Saldo: " + this.saldo);
        System.out.println();
    }

    /**
     * Retorna una cadena con el formato especificado en el diagrama.
     * Concatena número de cuenta, nombre del titular y saldo en formato tabular.
     * 
     * @return String con formato: "nroCuenta    titular    saldo"
     */
    public String toString() {
        return this.nroCuenta + "\t\t" + this.titular.nomYApe() + "\t\t" + this.saldo;
    }
}
