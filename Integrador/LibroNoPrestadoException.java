
/**
 * Excepción personalizada para indicar que un libro no está prestado.
 * 
 * @author Ivan Benitez
 * @version 1.0
 */
public class LibroNoPrestadoException extends Exception
{
    public LibroNoPrestadoException(String mensaje)
    {
        super(mensaje);
    }
}