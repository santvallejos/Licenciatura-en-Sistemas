import java.util.*;

/**
 * Representa una delegación de visitantes compuesta por varios individuos.
 * 
 * La clase Delegacion hereda de Visitante y modela el caso
 * en que un grupo de personas instancias de Individuo realiza una visita
 * en conjunto.
 * 
 * @author Ivan Benitez
 * @version 1.0
 */
public class Delegacion extends Visitante {
    private ArrayList<Individuo> individuos;

    /**
     * Constructor de Delegación con un único individuo inicial.
     *
     * @param p_nombre      Nombre de la delegación.
     * @param p_fechaVisita Fecha de la visita.
     * @param p_Individuo   Individuo inicial que forma parte de la delegación.
     */
    public Delegacion(String p_nombre, Calendar p_fechaVisita, Individuo p_Individuo) {
        super(p_nombre, p_fechaVisita);
        this.setIndividuos(new ArrayList<Individuo>());
        this.inscribirIndividuo(p_Individuo);
    }

    /**
     * Constructor de Delegación a partir de una lista de individuos.
     *
     * @param p_nombre      Nombre de la delegación.
     * @param p_fechaVisita Fecha de la visita.
     * @param p_Individuos  Lista de individuos que integran la delegación.
     */
    public Delegacion(String p_nombre, Calendar p_fechaVisita, ArrayList<Individuo> p_Individuos) {
        super(p_nombre, p_fechaVisita);
        this.setIndividuos(new ArrayList<Individuo>());
        this.inscribirIndividuos(p_Individuos);
    }

    /**
     * Establece la lista de individuos de la delegación.
     *
     * @param p_Individuos Lista de individuos.
     */
    private void setIndividuos(ArrayList<Individuo> p_Individuos) {
        this.individuos = p_Individuos;
    }

    /**
     * Devuelve la lista de individuos que integran la delegación.
     *
     * @return Lista de Individuos.
     */
    public ArrayList<Individuo> getIndividuos() {
        return this.individuos;
    }

    /**
     * Devuelve el tipo de visitante.
     *
     * @return La cadena "Delegacion".
     */
    @Override
    public String tipoVisitante() {
        return "Delegacion";
    }

    /**
     * Inscribe un nuevo individuo en la delegación.
     * 
     * Si el individuo ya está inscrito o es nulo, se muestra un mensaje por consola
     * y no se realiza la operación.
     *
     * @param p_Individuo Individuo a inscribir.
     */
    public void inscribirIndividuo(Individuo p_Individuo) {
        if (p_Individuo != null && !this.individuos.contains(p_Individuo)) {
            this.individuos.add(p_Individuo);
        } else {
            System.out.println("El individuo ya está inscripto o es nulo");
        }
    }

    /**
     * Inscribe múltiples individuos en la delegación.
     * 
     * Ignora individuos nulos o repetidos, mostrando un mensaje por consola
     * si alguno no puede agregarse.
     *
     * @param p_Individuos Lista de individuos a inscribir.
     */
    public void inscribirIndividuos(ArrayList<Individuo> p_Individuos) {
        for (Individuo individuo : p_Individuos) {
            if (individuo != null && !this.individuos.contains(individuo)) {
                this.individuos.add(individuo);
            } else {
                System.out.println("El individuo ya está inscripto o es nulo");
            }
        }
    }

    /**
     * Quita un individuo de la delegación si se encuentra presente.
     *
     * @param p_Individuo Individuo a eliminar.
     * @return true si se eliminó correctamente, false en caso contrario.
     */
    public boolean quitarIndividuo(Individuo p_Individuo) {
        if (p_Individuo != null && this.individuos.contains(p_Individuo)) {
            this.individuos.remove(p_Individuo);
            return true;
        }
        return false;
    }

    /**
     * Devuelve la cantidad de integrantes de la delegación.
     *
     * @return Número de individuos en la delegación.
     */
    public int cantidadIntegrantes() {
        return this.individuos.size();
    }

    /**
     * Muestra por consola la información completa de la delegación,
     * incluyendo el nombre, los integrantes y su cantidad.
     */
    @Override
    public void mostrar() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Delegación: " + this.getNombre());
        System.out.println("Integrantes:");
        for (Individuo i : this.individuos) {
            i.mostrar();
        }
        System.out.println("Cantidad de integrantes: " + this.cantidadIntegrantes());
        System.out.println("-------------------------------------------------------------");
    }

    /**
     * Calcula el costo total de las entradas para la delegación.
     * 
     * Se cobra 10$ por integrante y se aplica un descuento del 10%
     * sobre el total.
     *
     * @return Costo total con descuento.
     */
    @Override
    public double entrada() {
        if (this.tipoVisitante().equals("Delegacion")) {
            double total = this.cantidadIntegrantes() * 10;
            double descuento = total * 10 / 100;
            return total - descuento;
        }
        return 0;
    }

    /**
     * Lista la información de los individuos de la delegación cuya fecha de visita
     * y tipo coincidan con los parámetros dados.
     *
     * @param p_fecha     Fecha de referencia.
     * @param p_visitante Tipo de visitante a comparar.
     */
    @Override
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
        for (Individuo individuo : getIndividuos()) {
            if (individuo.getFechaVisita().equals(p_fecha) && individuo.tipoVisitante().equals(p_visitante)) {
                individuo.mostrar();
            }
        }
    }

    /**
     * Devuelve un conjunto con todas las personas asociadas a los individuos
     * de la delegación.
     *
     * @return Conjunto de objetos Persona.
     */
    @Override
    public HashSet<Persona> listarPersonas() {
        HashSet<Persona> personas = new HashSet<Persona>();
        for (Individuo individuo : this.getIndividuos()) {
            personas.add(individuo.getPersona());
        }
        return personas;
    }
}
