import java.util.*;

/**
 * Clase abstracta que representa a un visitante.
 * Contiene información como el nombre y la fecha de visita,
 * y define métodos abstractos que deben ser implementados por sus subclases.
 * 
 * @author Ivan Benitez
 * @version 1.0
 */
public abstract class Visitante {
    private String nombre;
    private Calendar fechaVisita;

    /**
     * Constructor que inicializa un visitante con su nombre y fecha de visita.
     *
     * @param p_nombre      Nombre del visitante.
     * @param p_fechaVisita Fecha en la que se realizó la visita.
     */
    public Visitante(String p_nombre, Calendar p_fechaVisita) {
        this.setNombre(p_nombre);
        this.setFechaVisita(p_fechaVisita);
    }

    /**
     * Establece el nombre del visitante.
     *
     * @param p_nombre Nombre del visitante.
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /**
     * Devuelve el nombre del visitante.
     *
     * @return Nombre del visitante.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece la fecha de la visita.
     *
     * @param p_fechaVisita Fecha de la visita.
     */
    private void setFechaVisita(Calendar p_fechaVisita) {
        this.fechaVisita = p_fechaVisita;
    }

    /**
     * Devuelve la fecha de la visita.
     *
     * @return Fecha de la visita.
     */
    public Calendar getFechaVisita() {
        return this.fechaVisita;
    }

    /**
     * Muestra la información del visitante.
     * Este método debe ser implementado por las subclases
     */
    public abstract void mostrar();

    /**
     * Calcula el costo de la entrada del visitante.
     * Este método debe ser implementado por las subclases
     * 
     * @return Monto de la entrada con formato double.
     */
    public abstract double entrada();

    /**
     * Lista la información del visitante si coincide con la fecha y nombre.
     * Este método debe ser implementado por las subclases
     * 
     * @param p_fecha     Fecha de referencia.
     * @param p_visitante Nombre del visitante a buscar.
     */
    public abstract void listarPorFecha(Calendar p_fecha, String p_visitante);

    /**
     * Devuelve el tipo de visitante, "Individuo" o "Delegacion".
     ** Este método debe ser implementado por las subclases.
     * 
     * @return Tipo de visitante en formato String.
     */
    public abstract String tipoVisitante();

    /**
     * Devuelve un conjunto de personas asociadas al visitante.
     * Dependiendo del tipo de visitante (Individuo o Delegacion),
     *
     * @return Conjunto de objetos asociados al visitante.
     */
    public abstract HashSet<Persona> listarPersonas();
}
