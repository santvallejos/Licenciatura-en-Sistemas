import java.util.*;

/**
    * Representa un jardín con diversas figuras geométricas.
 */
public class Jardin
{
    private String nombre;
    private ArrayList<FiguraGeometrica> figuras;

    Jardin(String p_nombre, ArrayList<FiguraGeometrica> p_figuras)
    {
        this.setNombre(p_nombre);
        this.setFiguras(p_figuras);
    }

    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    private void setFiguras(ArrayList<FiguraGeometrica> p_figuras)
    {
        this.figuras = p_figuras;
    }

    public ArrayList<FiguraGeometrica> getFiguras()
    {
        return this.figuras;
    }

    /**
     * Calcula cuántos litros de pintura se necesitan para cubrir la superficie total del jardín.
     * 
     * @return Cantidad de litros necesarios
    */
    private double cuantosLitros()
    {
        double superficieTotal = 0;
        for (FiguraGeometrica figura : this.getFiguras())
        {
            superficieTotal += figura.superficie();
        }
        return superficieTotal / 5; // 1 litro cubre 5 m2
    }

    /**
     * Calcula cuántas latas de pintura se necesitan para cubrir la superficie total del jardín.
     * 
     * @return Cantidad de latas necesarias (redondeado hacia arriba)
    */
    public int cuantasLatas()
    {
        double litros = this.cuantosLitros();
        return (int) Math.ceil(litros / 4); // cada lata tiene 4 litros
    }

    /**
     * Calcula la superficie total a cubrir en el jardín.
     * 
     * @return Superficie total en metros cuadrados
    */
    public double cuantosMetros()
    {
        double superficieTotal = 0;
        for (FiguraGeometrica figura : this.getFiguras())
        {
            superficieTotal += figura.superficie();
        }
        return superficieTotal;
    }

    /**
     * Muestra el detalle de las figuras en el jardín, incluyendo su nombre y superficie.
    */
    public void detalleFiguras()
    {
        System.out.println("Presupuesto: " + this.getNombre());
        for (FiguraGeometrica figura : this.getFiguras())
        {
            System.out.println(figura.nombreFigura());
            figura.mostrarSuperficie();
        }
        System.out.println("----------------------------------");
        System.out.printf("Total a cubrir: %.2f%n", this.cuantosMetros());
        System.out.println("Comprar " + this.cuantasLatas() + " latas");
    }
}