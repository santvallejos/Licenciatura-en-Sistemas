
public class Premiun extends Etiqueta
{
    private int colores;

    Premiun(double p_costo, int p_colores)
    {
        super(p_costo);
        this.setColores(p_colores);
    }

    private void setColores(int p_colores)
    {
        this.colores = p_colores;
    }

    public int getColores()
    {
        return this.colores;
    }

    @Override
    public double precio(int q)
    {
        return (this.getCosto() * q) + (this.getCosto() * q * this.adicional());
    }

    private double adicional()
    {
        switch (this.getColores())
        {
            case 1:
                return 0;
        
            case 2:
                return 0.05;
            
            case 3:
                return 0.07;
            
            default:
                return this.getColores() * 0.03;
        }
    }

    @Override
    public String tipo()
    {
        return "Premium";
    }
}