import java.util.*;

/**
 * Clase que representa una persona con sus datos personales básicos.
 * Permite gestionar la información de una persona incluyendo DNI, nombre, apellido
 * y año de nacimiento. Calcula automáticamente la edad basada en el año actual.
 * 
 * @author Sistema de Gestión de Personas
 */
public class Persona
{
    private int nroDNI;            ///
    private String nombre;         ///
    private String apellido;       ///
    private int anioNacimiento;    ///

    /**
     * Constructor de la clase Persona.
     * Inicializa una persona con todos sus datos personales básicos.
     * 
     * @param p_dni Número de DNI de la persona
     * @param p_nombre Nombre de la persona
     * @param p_apellido Apellido de la persona
     * @param p_anio Año de nacimiento de la persona
     */
    Persona(int p_dni, String p_nombre, String p_apellido, int p_anio)
    {
        setDNI(p_dni);
        setNombre(p_nombre);
        setApellido(p_apellido);
        setAnioNacimiento(p_anio);
    }

    /**
     * Establece el número de DNI de la persona.
     * 
     * @param p_dni Número de DNI a asignar
     */
    private void setDNI(int p_dni)
    {
        this.nroDNI = p_dni;
    }

    /**
     * Establece el nombre de la persona.
     * 
     * @param p_nombre Nombre a asignar a la persona
     */
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    /**
     * Establece el apellido de la persona.
     * 
     * @param p_apellido Apellido a asignar a la persona
     */
    private void setApellido(String p_apellido)
    {
        this.apellido = p_apellido;
    }

    /**
     * Establece el año de nacimiento de la persona.
     * 
     * @param p_anio Año de nacimiento a asignar
     */
    private void setAnioNacimiento(int p_anio)
    {
        this.anioNacimiento = p_anio;
    }

    /**
     * Obtiene el número de DNI de la persona.
     * 
     * @return Número de DNI de la persona
     */
    public int getDNI()
    {
        return this.nroDNI;
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return Nombre de la persona
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     * 
     * @return Apellido de la persona
     */
    public String getApellido()
    {
        return this.apellido;
    }

    /**
     * Obtiene el año de nacimiento de la persona.
     * 
     * @return Año de nacimiento de la persona
     */
    public int getAnioNacimiento()
    {
        return this.anioNacimiento;
    }

    /**
     * Calcula la edad actual de la persona.
     * Se basa en la diferencia entre el año actual y el año de nacimiento.
     * 
     * @return Edad de la persona en años
     */
    public int edad()
    {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);      // Obtengo el año actual

        int edad = anioHoy - getAnioNacimiento();       // resta los años para obtener la edad del usuario
        return edad;
    }

    /**
     * Concatena el nombre y apellido de la persona separados por un espacio.
     * 
     * @return Cadena con formato "Nombre Apellido"
     */
    public String nomYApe()
    {
        return getNombre() + " " + getApellido();       // Concatena los datos, con doble encapsulamiento
    }

    /**
     * Concatena el apellido y nombre de la persona separados por un espacio.
     * 
     * @return Cadena con formato "Apellido Nombre"
     */
    public String apeYNom()
    {
        return getApellido() + " " + getNombre();       // Concatena los datos, con doble encapsulamiento
    }

    /**
     * Muestra por consola toda la información de la persona.
     * Incluye nombre completo, DNI y edad calculada automáticamente.
     * Formato de salida:
     * Nombre y Apellido: [Nombre Apellido]
     * DNI: [DNI]    Edad: [edad]
     */
    public void mostrar()
    {
        System.out.println("Nombre y Apellido: " + nomYApe());
        System.out.println("DNI: " + getDNI() + "    " + "Edad: " + edad());
    }
}