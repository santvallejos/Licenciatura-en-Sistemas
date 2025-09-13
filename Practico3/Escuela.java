/**
 * Clase que representa una escuela con sus datos institucionales y docente asociado.
 * Permite gestionar la información de la escuela y generar recibos de sueldo para los docentes.
 * 
 * @author Sistema POO
 * @version 1.0
 */
public class Escuela {
    private String nombre;
    private String domicilio;
    private String director;
    private Docente docente;

    /**
     * Constructor que inicializa una escuela con todos sus datos y docente asociado.
     * 
     * @param p_nombre El nombre de la escuela
     * @param p_domicilio El domicilio de la escuela
     * @param p_director El nombre del director de la escuela
     * @param p_docente El docente asociado a la escuela
     */
    Escuela(String p_nombre, String p_domicilio, String p_director, Docente p_docente) {
        this.setnombre(p_nombre);
        this.setdomicilio(p_domicilio);
        this.setdirector(p_director);
        this.setdocente(p_docente);

    }

    private void setnombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    public String getnombre() {
        return this.nombre;
    }

    private void setdomicilio(String p_domicilio) {
        this.domicilio = p_domicilio;
    }

    public String getdomicilio() {
        return this.domicilio;
    }

    private void setdirector(String p_director) {
        this.director = p_director;
    }

    public String getdirector() {
        return this.director;
    }

    private void setdocente(Docente p_docente) {
        this.docente = p_docente;
    }

    public Docente getdocente() {
        return this.docente;
    }

    /**
     * Imprime un recibo de sueldo para el docente asociado a la escuela.
     * Muestra los datos de la escuela y el desglose del sueldo del docente.
     * 
     * @param p_Docente El docente para el cual se emite el recibo
     */
    public void ImprimirRecibo(Docente p_Docente) {
        System.out.println(
                "Escuela: " + this.nombre + "  " + "Domicilio: " + this.domicilio + "  " + "Director:" + this.director);
        System.out.println(
                "---------------------------------------------------------------------------------------------------");
        System.out.println("Docente:    " + this.docente);
        System.out.println("Sueldo: " + "..........................." + this.docente.calcularSueldo());
        System.out.println("Sueldo Basico: " + "..........................." + this.docente.getsueldoBasico());
        System.out.println(
                "Asignacion Familiar: " + "..........................." + this.docente.getasignacionFamiliar());
    }
}
