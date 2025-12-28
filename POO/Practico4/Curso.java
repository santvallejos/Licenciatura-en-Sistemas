import java.util.*;

/**
 * Sistema de Cursos
 * 
 * @author Sistema de Cursos
 * @version 1.0
 */
public class Curso
{
    private String nombre;
    private HashMap<Integer, Alumno> alumnos;

    /**
     * Constructor unicamente con el nombre del curso
     * 
     * @param p_nombre Nombre del curso
    */
    Curso(String p_nombre)
    {
        setNombre(p_nombre);
    }

    /**
     * Constructor con el nombre del curso y una lista de alumnos
     * 
     * @param nombre Nombre del curso
     * @param p_alumnos Lista de alumnos
    */
    Curso(String p_nombre, HashMap<Integer, Alumno> p_alumnos)
    {
        setNombre(p_nombre);
        setAlumnos(p_alumnos);
    }

    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    private void setAlumnos(HashMap<Integer, Alumno> p_alumnos)
    {
        this.alumnos = p_alumnos;
    }

    public HashMap<Integer, Alumno> getAlumnos()
    {
        return this.alumnos;
    }

    public void inscribirAlumno(Alumno p_alumno)
    {
        this.alumnos.put(p_alumno.getLu(), p_alumno);
    }

    public Alumno quitarAlumno(int p_lu)
    {
        return this.getAlumnos().remove(p_lu);
    }

    public int cantidadDeAlumnos()
    {
        return this.getAlumnos().size();
    }

    public boolean estaInscripto(int p_lu)
    {
        // Busca por clave con containsKer
        return this.getAlumnos().containsKey(p_lu);
    }

    public boolean estaInscripto(Alumno p_alumno)
    {
        // Buscar por valor con containsValue
        return this.getAlumnos().containsValue(p_alumno);
    }

    public Alumno buscarAlumno(int p_lu)
    {
        // Retorna un alumno por su lu
        return this.getAlumnos().get(p_lu);
    }

    public void imprimirPromedioDelAlumno(int p_lu)
    {
        Alumno alumno = this.buscarAlumno(p_lu);
        if (alumno != null)
        {
            System.out.println("****-- Busca y muestra el alumno con numero de libreta " + p_lu + " --****");
            System.out.println("Apellido y Nombre: " + alumno.apeYNom());
            System.out.println("LU: " + alumno.getLu() + "  Notas: " + alumno.getNota1() + ", " + alumno.getNota2());
            System.out.println("Promedio: " + alumno.promedio());
        }
        else
        {
            System.out.println("No se encontro el alumno con LU " + p_lu);
        }
    }

    public void mostarInscriptos()
    {
        System.out.println("****-- Cantidad de inscriptos: " + this.cantidadDeAlumnos());
        for (Alumno alumno : this.getAlumnos().values())
        {
            System.out.println(alumno.getLu() + " " + alumno.apeYNom());
        }
    }
}