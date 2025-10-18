
public abstract class Etiqueta
{
    private double costo;

    Etiqueta(double p_costo)
    {
        this.setCosto(p_costo);
    }

    private void setCosto(double p_costo)
    {
        this.costo = p_costo;
    }

    public double getCosto()
    {
        return this.costo;
    }

    public abstract double precio(int q);

    public String toString()
    {
        if(this instanceof Comun) {
            Comun comun = (Comun) this;
            return "tipo " + this.tipo() + " - Costo: $" + this.getCosto() + " - Diseño: $" + comun.getPlus();
        }else if(this instanceof Premiun) {
            Premiun premium = (Premiun) this;
            return "tipo " + this.tipo() + " - Costo: $" + this.getCosto() + " - Colores: " + premium.getColores();
        }else{
            return "ERROR";
        }
    }

    public abstract String tipo();
}