import java.util.*;

/**
 * Representa a un visitante individual.
 * 
 * La clase Individuo hereda de Visitante y modela el caso en que
 * el visitante es una sola persona. Contiene una referencia a un objeto
 * Persona que almacena los datos personales del individuo
 * 
 * Esta clase implementa los métodos abstractos definidos en Visitante
 * para comportamientos específicos de los visitantes individuales.
 * 
 * @author Ivan Benitez
 * @version 1.0
 */
public class Individuo extends Visitante {
    private Persona persona;

    /**
     * Constructor de la clase Individuo
     * Inicializa un visitante individual con su nombre, fecha de visita y datos
     * personales.
     *
     * @param p_nombre      Nombre del visitante.
     * @param p_fechaVisita Fecha de la visita.
     * @param p_persona     Objeto asociado al visitante.
     */
    public Individuo(String p_nombre, Calendar p_fechaVisita, Persona p_persona) {
        super(p_nombre, p_fechaVisita);
        this.setPersona(p_persona);
    }

    /**
     * Establece la persona asociada al visitante individual.
     *
     * @param p_persona Persona a asignar.
     */
    private void setPersona(Persona p_persona) {
        this.persona = p_persona;
    }

    /**
     * Devuelve la persona asociada al visitante individual.
     *
     * @return Objeto Persona del visitante.
     */
    public Persona getPersona() {
        return this.persona;
    }

    /**
     * Devuelve el tipo de visitante.
     *
     * @return La cadena "Individuo"}.
     */
    @Override
    public String tipoVisitante() {
        return "Individuo";
    }

    /**
     * Lista la información del visitante si la fecha de visita y el tipo de
     * visitante coinciden.
     *
     * @param p_fecha     Fecha de referencia.
     * @param p_visitante Tipo de visitante a comparar.
     */
    @Override
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
        if (this.getFechaVisita().equals(p_fecha) && this.tipoVisitante().equals(p_visitante)) {
            this.mostrar();
        }
    }

    /**
     * Muestra por consola los datos del visitante individual,
     * nombre, apellido, DNI y año de nacimiento.
     */
    @Override
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.persona.getNombre() + " " + this.persona.getApellido());
        System.out.println("DNI: " + this.persona.getDNI() + "  " + "Edad: " + this.persona.getAnioNacimiento());
    }

    /**
     * Devuelve el costo de la entrada del visitante individual.
     * 
     * En este caso, el costo fijo es de 10$.
     *
     * @return Valor de la entrada (10).
     */
    @Override
    public double entrada() {
        if (this.tipoVisitante().equals("Individuo")) {
            return 10;
        }
        return 0;
    }

    /**
     * Devuelve un conjunto que contiene la persona asociada al visitante
     * individual.
     *
     * @return Conjunto con una única Persona.
     */
    @Override
    public HashSet<Persona> listarPersonas() {
        HashSet<Persona> personas = new HashSet<Persona>();
        personas.add(this.getPersona());
        return personas;
    }
}
