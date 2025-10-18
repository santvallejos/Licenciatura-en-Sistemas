
public abstract class Etiqueta
{
    private double costo;

    /**
     * Constructor de la clase Etiqueta
     * 
     * @param p_costo Costo de la etiqueta
    */
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

    /**
     * Precio total de la etiqueta segun su tipo y cantidad
     * 
     * @param q Cantidad de etiquetas
     * @return Precio total de las etiquetas
    */
    public abstract double precio(int q);

    /**
     * Mostrar informacion de la etiqueta segun su tipo
     * 
     * @return Informacion de la etiqueta
    */
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

    /**
     * Tipo de etiqueta
     * 
     * @return Tipo de etiqueta
    */
    public abstract String tipo();
}