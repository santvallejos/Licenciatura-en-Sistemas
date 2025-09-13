
/**
 * Clase que representa un cliente bancario con sus datos personales y saldo.
 * Permite gestionar la información de un cliente incluyendo su DNI, nombre, apellido y saldo.
 * 
 * La clase proporciona métodos para:
 * - Agregar saldo al balance actual
 * - Reemplazar el saldo actual por un nuevo valor
 * - Mostrar la información completa del cliente
 * 
 * @author Sistema de Gestión Bancaria
 */
public class Cliente
{
    private int nroDNI;
    private String apellido;
    private String nombre;
    private double saldo;

    /**
     * Constructor de la clase Cliente.
     * Inicializa un cliente con su DNI, apellido, nombre y saldo inicial.
     * 
     * @param p_dni Número de DNI del cliente
     * @param p_apellido Apellido del cliente
     * @param p_nombre Nombre del cliente
     * @param p_saldo Saldo inicial del cliente
     */
    Cliente(int p_dni, String p_apellido, String p_nombre, double p_saldo)
    {
        setNroDNI(p_dni);
        setApellido(p_apellido);
        setNombre(p_nombre);
        setSaldo(p_saldo);
    }

    /**
     * Establece el número de DNI del cliente.
     * 
     * @param p_dni Número de DNI a asignar
     */
    private void setNroDNI(int p_dni)
    {
        this.nroDNI = p_dni;
    }

    /**
     * Obtiene el número de DNI del cliente.
     * 
     * @return Número de DNI del cliente
     */
    public int getNroDNI()
    {
        return this.nroDNI;
    }

    /**
     * Establece el apellido del cliente.
     * 
     * @param p_apellido Apellido a asignar al cliente
     */
    private void setApellido(String p_apellido)
    {
        this.apellido = p_apellido;
    }

    /**
     * Obtiene el apellido del cliente.
     * 
     * @return Apellido del cliente
     */
    public String getApellido()
    {
        return this.apellido;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param p_nombre Nombre a asignar al cliente
     */
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Establece el saldo del cliente.
     * 
     * @param p_saldo Saldo a asignar al cliente
     */
    private void setSaldo(double p_saldo)
    {
        this.saldo = p_saldo;
    }

    /**
     * Obtiene el saldo actual del cliente.
     * 
     * @return Saldo actual del cliente
     */
    public double getSaldo()
    {
        return this.saldo;
    }

    /**
     * Reemplaza el saldo actual del cliente con un nuevo valor.
     * 
     * @param p_importe Nuevo saldo a establecer
     * @return El saldo actualizado
     */
    public double nuevoSaldo(double p_importe)
    {
        setSaldo(p_importe);
        return getSaldo();
    }

    /**
     * Agrega un importe al saldo actual del cliente.
     * 
     * @param p_importe Importe a agregar al saldo actual
     * @return El saldo actualizado después de la suma
     */
    public double agregaSaldo(double p_importe)
    {
        setSaldo(getSaldo() + p_importe);
        return getSaldo();
    }

    /**
     * Concatena el apellido y nombre del cliente separados por un espacio.
     * 
     * @return Cadena con formato "Apellido Nombre"
     */
    public String apeYnom()
    {
        return getApellido() + " " + getNombre();
    }

    /**
     * Concatena el nombre y apellido del cliente separados por un espacio.
     * 
     * @return Cadena con formato "Nombre Apellido"
     */
    public String nomYape()
    {
        return getNombre() + " " + getApellido();
    }

    /**
     * Muestra por consola toda la información del cliente.
     * Incluye nombre completo, DNI y saldo formateado con dos decimales.
     * Formato de salida:
     * - Cliente -
     * Nombre y Apellido: [Apellido Nombre] ([DNI])
     * Saldo: $[saldo con 2 decimales]
     */
    public void mostrar()
    {
        System.out.println("- Cliente -");
        System.out.println("Nombre y Apellido: " + apeYnom() + "(" + getNroDNI() + ")");
        System.out.println("Saldo: $" + String.format("%.2f", getSaldo()));
    }
}