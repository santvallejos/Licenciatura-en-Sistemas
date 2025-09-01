
public class CajaDeAhorro {
    private int nroCuenta;
    private double saldo;
    private int extraccionesPosibles;
    private Persona titular;

    public CajaDeAhorro(int p_nroCuenta, Persona p_titular) {
        this.setTitular(p_titular);
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(0);
        this.setExtraccionesPosibles(10);
    }

    public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo) {
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

    public void depositar(double p_importe) {
        this.setSaldo(this.getSaldo() + p_importe);
    }

    public void extraer(double p_importe) {
        this.extraccion(p_importe);
    }

    private boolean puedeExtraer(double p_importe) {
        if (p_importe <= this.getSaldo()) {
            return true;
        } else {
            return false;
        }
    }

    private void extraccion(double p_importe) {
        if (this.puedeExtraer(p_importe)) {
            this.setSaldo(this.getSaldo() - p_importe);
            this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
        }
    }

    public void mostrar() {
        System.out.println("Caja de Ahorro --");
        System.out.println("Nro. Cuenta: " + this.getNroCuenta() + "-" + "Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().getNombre());
        System.out.println("Extracciones Posibles: " + this.getExtraccionesPosibles());
    }
}