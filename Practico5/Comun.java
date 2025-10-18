
public class Comun extends Etiqueta
{
    private double plus;

    /**
     * Constructor de una etiqueta de tipo Comun (ya tiene un precio fijo este tipo de etiqueta)
     * 
     * @param p_plus
    */
    public Comun(double p_plus)
    {
        super(100);
        this.setPlus(p_plus);
    }

    private void setPlus(double p_plus)
    {
        this.plus = p_plus;
    }

    public double getPlus()
    {
        return this.plus;
    }

    @Override
    public double precio(int q)
    {
        return (this.getCosto() * q) - (this.getCosto() * q * this.descuento(q)) + this.getPlus();
    }

    /**
     * Devuelve el descuento que se le tiene que aplicar segun la cantidad de etiquetas
     * 
     * @param q
     * @return double - descuento a aplicar
    */
    private double descuento(int q)
    {
        if(q > 1 && q <= 10)
        {
            return 0;
        }
        else if(q >= 11 && q <= 50)
        {
            return 0.02;
        }
        else if (q >= 51 && q <= 100)
        {
            return 0.05;
        }
        else /* Mas de 100 unidades con un descuento de 1% cada 10 unidades */
        {
            return (q / 10) * 0.01;
        }
    }

    @Override
    public String tipo()
    {
        return "Comun";
    }
}