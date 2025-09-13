/**
 * Clase que representa un laboratorio farmacéutico con sus datos de contacto y condiciones comerciales.
 * Permite gestionar la información de un laboratorio incluyendo nombre, domicilio, teléfono,
 * compra mínima requerida y día de entrega.
 * 
 * @author Sistema de Gestión Farmacéutica
 */
public class Laboratorio
{
    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima;
    private int diaEntrega;

    /**
     * Constructor completo de la clase Laboratorio.
     * Inicializa un laboratorio con todos sus datos incluyendo condiciones comerciales.
     * 
     * @param p_nombre Nombre del laboratorio
     * @param p_domicilio Domicilio del laboratorio
     * @param p_telefono Teléfono de contacto del laboratorio
     * @param p_compraMinima Monto mínimo de compra requerido
     * @param p_diaEntrega Día de entrega de los productos
     */
    Laboratorio(String p_nombre, String p_domicilio, String p_telefono, int p_compraMinima, int p_diaEntrega)
    {
        setNombre(p_nombre);
        setDomicilio(p_domicilio);
        setTelefono(p_telefono);
        setCompraMinima(p_compraMinima);
        setDiaEntrega(p_diaEntrega);
    }

    /**
     * Constructor básico de la clase Laboratorio.
     * Inicializa un laboratorio solo con datos de contacto básicos.
     * Las condiciones comerciales quedan sin definir.
     * 
     * @param p_nombre Nombre del laboratorio
     * @param p_domicilio Domicilio del laboratorio
     * @param p_telefono Teléfono de contacto del laboratorio
     */
    Laboratorio(String p_nombre, String p_domicilio, String p_telefono)
    {
        setNombre(p_nombre);
        setDomicilio(p_domicilio);
        setTelefono(p_telefono);
    }

    /**
     * Establece el nombre del laboratorio.
     * 
     * @param p_nombre Nombre a asignar al laboratorio
     */
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    /**
     * Establece el domicilio del laboratorio.
     * 
     * @param p_domicilio Domicilio a asignar al laboratorio
     */
    private void setDomicilio(String p_domicilio)
    {
        this.domicilio = p_domicilio;
    }

    /**
     * Establece el teléfono del laboratorio.
     * 
     * @param p_telefono Teléfono a asignar al laboratorio
     */
    private void setTelefono(String p_telefono)
    {
        this.telefono = p_telefono;
    }

    /**
     * Establece el monto mínimo de compra del laboratorio.
     * 
     * @param p_compraMinima Monto mínimo de compra a asignar
     */
    private void setCompraMinima(int p_compraMinima)
    {
        this.compraMinima = p_compraMinima;
    }

    /**
     * Establece el día de entrega del laboratorio.
     * 
     * @param p_diaEntrega Día de entrega a asignar
     */
    private void setDiaEntrega(int p_diaEntrega)
    {
        this.diaEntrega = p_diaEntrega;
    }

    /**
     * Obtiene el nombre del laboratorio.
     * 
     * @return Nombre del laboratorio
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Obtiene el domicilio del laboratorio.
     * 
     * @return Domicilio del laboratorio
     */
    public String getDomicilio()
    {
        return this.domicilio;
    }

    /**
     * Obtiene el teléfono del laboratorio.
     * 
     * @return Teléfono del laboratorio
     */
    public String getTelefono()
    {
        return this.telefono;
    }

    /**
     * Obtiene el monto mínimo de compra del laboratorio.
     * 
     * @return Monto mínimo de compra requerido
     */
    public int getCompraMinima()
    {
        return this.compraMinima;
    }

    /**
     * Obtiene el día de entrega del laboratorio.
     * 
     * @return Día de entrega de los productos
     */
    public int getDiaEntrega()
    {
        return this.diaEntrega;
    }

    /**
     * Actualiza el monto mínimo de compra del laboratorio.
     * 
     * @param p_compraMinima Nuevo monto mínimo de compra a establecer
     */
    public void nuevaCompraMinima(int p_compraMinima)
    {
        setCompraMinima(p_compraMinima);
    }

    /**
     * Actualiza el día de entrega del laboratorio.
     * 
     * @param p_diaEntrega Nuevo día de entrega a establecer
     */
    public void nuevoDiaEntrega(int p_diaEntrega)
    {
        setDiaEntrega(p_diaEntrega);
    }

    /**
     * Muestra por consola la información básica del laboratorio.
     * Incluye nombre, domicilio y teléfono de contacto.
     * Formato de salida:
     * Laboratorio: [nombre]
     * Domicilio: [domicilio]  -  Teléfono: [teléfono]
     */
    public void mostrar()
    {
        System.out.println("Laboratorio: " + getNombre());
        System.out.println("Domicilio: " + getDomicilio() + "  -  " + "Teléfono: " + getTelefono());
    }
}
