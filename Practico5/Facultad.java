
import java.util.ArrayList;

/**
 * Write a description of class Facultad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Facultad
{
    private String nombre;
    private ArrayList<Profesor> profesores;

    /**
     * Constructor de la clase Facultad con un solo profesor
     * 
     * @param p_nombre
     * @param p_profesor
    */
    public Facultad(String p_nombre, Profesor p_profesor)
    {
        this.setNombre(p_nombre);
        this.setProfesores(new ArrayList<>());
        this.agregarProfesor(p_profesor);
    }

    /**
     * Constructor de la clase Facultad con una lista de profesores
     * 
     * @param nombre;
     * @param profesores;
    */
    public Facultad(String p_nombre, ArrayList<Profesor> p_profesores)
    {
        this.setNombre(p_nombre);
        this.setProfesores(new ArrayList<>());
        this.agregarProfesores(p_profesores);
    }

    /* Getters y Setters */
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    private void setProfesores(ArrayList<Profesor> p_profesores)
    {
        this.profesores = p_profesores;
    }

    public ArrayList<Profesor> getProfesores()
    {
        return this.profesores;
    }

    /**
     * Metodo para agregar un profesor a la facultad
     * 
     * @param p_profesor
     * @return true si se agrego el profesor, false si no se pudo agregar
    */
    public boolean agregarProfesor(Profesor p_profesor)
    {
        if (!this.profesores.contains(p_profesor))
        {
            this.profesores.add(p_profesor);
            return true;
        }
        return false;
    }

    /**
     * Metodo para agregar una lista de profesores a la facultad
     * 
     * @param p_profesores
     * @return true si se agregaron todos los profesores, false si no se pudo agregar alguno
    */
    public boolean agregarProfesores(ArrayList<Profesor> p_profesores)
    {
        for (Profesor profesor : p_profesores)
        {
            if (!this.profesores.contains(profesor))
            {
                this.profesores.add(profesor);
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Emitir nómina de profesores con el total a pagar
    */
    public void nominaProfesores()
    {
        System.out.println("*************** Nómina Facultad: FaCENA");
        System.out.println("------------------------------------------------------------------");
        for (Profesor profesor : this.getProfesores())
        {
            profesor.mostrarLinea();
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Total a pagar: $" + this.totalAPagar());
    }

    public double totalAPagar()
    {
        double total = 0;
        for (Profesor profesor : this.getProfesores())
        {
            total += profesor.sueldoTotal();
        }
        return total;
    }

    public void listarProfesorCargos()
    {
        System.out.println("--------------------------------------------------------------------------------");
        for (Profesor profesor : this.getProfesores())
        {
            profesor.mostrar();
            System.out.println("");
            System.out.println("------------------  **** -------------------");
        }
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Hay " + this.getProfesores().size() + " Profesores.");
    }
}