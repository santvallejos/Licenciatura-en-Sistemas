import java.util.*;

/**
 * Clase que representa un alumno con sus datos personales y académicos.
 * Permite gestionar la información de un estudiante incluyendo su legajo universitario,
 * nombre, apellido y sus calificaciones.
 * 
 * @author Sistema de Gestión Académica
 */
public class Alumno extends Persona
{
    private int lu;
    private double nota1;
    private double nota2;

    /**
     * Constructor de la clase Alumno.
     * Inicializa un alumno con su legajo universitario, nombre y apellido.
     * Las notas se inicializan en 0.
     * 
     * @param p_lu Legajo universitario del alumno
     * @param p_nombre Nombre del alumno
     * @param p_apellido Apellido del alumno
     */
    Alumno(Persona p_persona, int p_lu)
    {
        super(p_persona.getDNI(),p_persona.getNombre(),p_persona.getApellido(),p_persona.getAnioNacimiento().get(Calendar.YEAR));
        setLu(p_lu);
        setNota1(0);
        setNota2(0);
    }

    /**
     * Establece el legajo universitario del alumno.
     * 
     * @param p_lu Legajo universitario a asignar
     */
    private void setLu(int p_lu)
    {
        this.lu = p_lu;
    }

    /**
     * Obtiene el legajo universitario del alumno.
     * 
     * @return Legajo universitario del alumno
     */
    public int getLu()
    {
        return this.lu;
    }

    /**
     * Establece la primera nota del alumno.
     * 
     * @param p_nota1 Primera nota a asignar (valor numérico)
     */
    public void setNota1(double p_nota1)
    {
        this.nota1 = p_nota1;
    }

    /**
     * Obtiene la primera nota del alumno.
     * 
     * @return Primera nota del alumno
     */
    public double getNota1()
    {
        return this.nota1;
    }

    /**
     * Establece la segunda nota del alumno.
     * 
     * @param p_nota2 Segunda nota a asignar (valor numérico)
     */
    public void setNota2(double p_nota2)
    {
        this.nota2 = p_nota2;
    }

    /**
     * Obtiene la segunda nota del alumno.
     * 
     * @return Segunda nota del alumno
     */
    public double getNota2()
    {
        return this.nota2;
    }

    /**
     * Calcula el promedio de las dos notas del alumno.
     * 
     * @return Promedio aritmético de las dos notas
     */
    public double promedio()
    {
        return (getNota1() + getNota2()) / 2;
    }

    /**
     * Determina si el alumno aprueba la materia.
     * Para aprobar debe tener un promedio >= 7.0 y ambas notas >= 6.0.
     * 
     * @return true si aprueba, false en caso contrario
     */
    private boolean aprueba()
    {
        if (promedio() >= 7.0 && getNota1() >= 6.0 && getNota2() >= 6.0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Obtiene la leyenda que indica si el alumno aprobó o no.
     * 
     * @return "APROBADO" si cumple los criterios de aprobación, "DESAPROBADO" en caso contrario
     */
    private String leyendaAprueba()
    {
        if (aprueba() == true) {
            return "APROBADO";
        }
        else
        {
            return "DESAPROBADO";
        }
    }

    /**
     * Concatena el nombre y apellido del alumno separados por un espacio.
     * 
     * @return Cadena con formato "Nombre Apellido"
     */
    public String nomYApe()
    {
        return getNombre() + " " + getApellido();
    }

    /**
     * Concatena el apellido y nombre del alumno separados por un espacio.
     * 
     * @return Cadena con formato "Apellido Nombre"
     */
    public String apeYNom()
    {
        return getApellido() + " " + getNombre();
    }

    /**
     * Muestra por consola toda la información del alumno.
     * Incluye nombre completo, legajo universitario, notas, promedio y estado de aprobación.
     */
    public void mostrar()
    {
        super.mostrar();
        System.out.println("LU: " + getLu() + "     " + "Notas: " + getNota1() + " - " + getNota2());
        System.out.println("Promedio: " + promedio() + " - " + leyendaAprueba());
    }
}