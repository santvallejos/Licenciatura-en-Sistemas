import java.util.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Biblioteca{
    private String nombre;
    private HashMap<Integer, Socio> socios;
    private Set<Libro> libros;

   public Biblioteca (String p_nombre, HashMap <Integer, Socio> p_socios, Set <Libro> p_libros) {
        this.setNombre(p_nombre);
        this.setSocios(p_socios);
        this.setLibros(p_libros);
    }

   public Biblioteca (String p_nombre) {
        this.setNombre(p_nombre);
        this.setSocios(new HashMap<Integer, Socio>());
        this.setLibros(new HashSet<Libro>());
    }
    private void setNombre (String p_nombre) {
        this.nombre = p_nombre;
    }
    public String getNombre() {
        return this.nombre;
    }
    private void setSocios(HashMap<Integer, Socio> p_socios){
        this.socios = p_socios;
    }
    
    public HashMap<Integer, Socio> getSocios(){
        return this.socios;
    }

    public  void setLibros (Set <Libro> p_libros){
        this.libros = p_libros;
    }
    public Set <Libro> getLibros(){
        return this.libros;
    }
public void agregarSocio(Socio p_socio) {
    if(!this.getSocios().containsKey(p_socio.getDni())){
       this.getSocios().put(p_socio.getDni(), p_socio);    
    }else{
        System.out.println("Socio añadido con anterioridad");
    }
}

public boolean quitarSocio(Socio p_socio) {
    if (this.getSocios().containsKey(p_socio.getDni())) {
        this.getSocios().remove(p_socio.getDni());
        return true;
    }
    return false;
}
public void agregarLibro(Libro p_libro) {  
    this.getLibros().add(p_libro);
}
public boolean quitarLibro(Libro p_libro) {
    return this.getLibros().remove(p_libro);

}

/**
 * Crea un nuevo libro y lo agrega a la colección de libros.
 * @param p_titulo
 * @param p_edicion
 * @param p_editorial
 * @param p_anio
 */
public void nuevoLibro (String p_titulo, int p_edicion, String p_editorial, int p_anio) {
 Libro libro = new Libro (p_titulo, p_edicion, p_editorial, p_anio);
    this.agregarLibro(libro);
}
/**
 * Crea un nuevo socio de tipo Estudiante y lo agrega a la colección de socios.
 * @param p_dniSocio
 * @param p_nombre
 * @param p_carrera
 */
public void nuevoSocioEstudiante (int p_dniSocio, String p_nombre, String p_carrera) {
    Estudiante estudiante = new Estudiante (p_dniSocio, p_nombre, p_carrera);
    this.getSocios().put(estudiante.getDni(), estudiante);
}
/**
 * Crea un nuevo socio de tipo Docente y lo agrega a la colección de socios.
 * @param p_dniSocio
 * @param p_nombre
 * @param p_area
 */
public void nuevoSocioDocente (int p_dniSocio, String p_nombre, String p_area) {
    Docente docente = new Docente (p_dniSocio, p_nombre, p_area);
    this.getSocios().put(docente.getDni(), docente);
}
/**
 * Presta un libro a un socio si cumple con las condiciones.
 * @param p_fechaRetiro
 * @param p_socio
 * @param p_libro
 * @return
 */
public boolean prestarLibro (Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) {
    boolean prestado = false;
    if (p_socio.soyDeLaClase().equals("Estudiante")) {
        if (p_socio.cantLibrosPrestados() <= 3 && p_socio.puedePedir()) {
    Prestamo prestamo = new Prestamo (p_fechaRetiro, p_socio, p_libro);
    p_socio.agregarPrestamo(prestamo);
    p_libro.agregarPrestamo(prestamo);
    return prestado = true;
    }
    } else {
        if (p_socio.soyDeLaClase().equals("Docente")) {
           if (p_socio.puedePedir()) {
            if (((Docente)p_socio).esResponsable()) {
                ((Docente)p_socio).cambiarDiasDePrestamo(p_socio.getDiasPrestamo() + 1);
                
               }
            }
            Prestamo prestamo = new Prestamo (p_fechaRetiro, p_socio, p_libro);
            p_socio.agregarPrestamo(prestamo);
            p_libro.agregarPrestamo(prestamo);
            return prestado = true;
        }
    }
    
    return prestado;
}

/**
 * Devuelve un libro prestado.
 * @param p_libro
 * @throws LibroNoPrestadoException
 */
public void devolverLibro (Libro p_libro) throws LibroNoPrestadoException {
    if (p_libro.prestado()) {
        Prestamo prestamo = p_libro.ultimoPrestamo();
        Socio socio = prestamo.getSocio();

        prestamo.registrarFechaDevolucion(Calendar.getInstance());
        socio.quitarPrestamo(prestamo);     
    } else {
        throw new LibroNoPrestadoException("El libro: " + p_libro.getTitulo() + " no se puede devolver ya que se encuentra en la biblioteca");
    }
}

public int cantidadDeSociosPorTipo(String p_objeto){
    int contador = 0;
        for(Socio s : this.getSocios().values()){
            if(s.soyDeLaClase().equalsIgnoreCase(p_objeto)){
                contador++;
            }
        }
        return contador;
        
}
    
    /**
     * Devuelve el Socio que tiene el dni pasado como parámetro, o null si no lo encuentra.
     * @param p_dni DNI del socio a buscar.
     * @return El objeto Socio o null.
     */
    
    public Socio buscarSocio(int p_dni){
        return getSocios().get(p_dni);
    }
    
    public String listaDeLibros(){
         //StringBuilder usa un bufer interno que se expande si es necesario
         //permitiendo que agregues texto (append) sin crear un nuevo objeto
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de libros: \n");
        int i=1;
        for(Libro l: getLibros()){
            String prestado = l.prestado() ? "Si" : "No";
            sb.append(i++).append(") Titulo: ").append(l.getTitulo()).append(" || Prestado: (").append(prestado).append(")\n");
        }
        return sb.toString();
    }
    
    public String listaDeTitulos(){
        return libros.stream().map(libro -> libro.getTitulo()).distinct().collect(Collectors.joining("\n"));
    }
    
    public String listaDeSocios() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Socios:\n"); 
        
        int i = 1;
        for (Socio s : this.getSocios().values()) {
            sb.append(i++).append(") ").append(s.toString()).append("\n"); 
        }

        sb.append("**************************************\n");
        sb.append("Cantidad de Socios del tipo Estudiante: ").append(cantidadDeSociosPorTipo("Estudiante")).append("\n"); 
        sb.append("Cantidad de Socios del tipo Docente: ").append(cantidadDeSociosPorTipo("Docente")).append("\n"); 
        sb.append("**************************************\n");

        return sb.toString();
    }
    public String listaDeDocentesResponsables(){
        StringBuilder entr = new StringBuilder();
        entr.append("Lista de Docentes Responsables: \n");

        //Uso de pattern matching
        //Matched target --> s(Socio)
        //Pattern --> (Docente)d
        //Match result --> resultado de la coincidencia (d)
        for(Socio s : this.getSocios().values()){
            if (s instanceof Docente d){
                if(d.esResponsable()){
                    entr.append(d.toString()).append("\n");
                }
            }
        }
        return entr.toString();
    }
    
    public String quienTieneElLibro(Libro p_libro) throws LibroNoPrestadoException{
      if (!p_libro.prestado()){
        throw new LibroNoPrestadoException("El libro se encuentra en la biblioteca");
      }
      Prestamo prestamo = p_libro.ultimoPrestamo();
      Socio socio = prestamo.getSocio();
      return socio.getNombre();
    }

    public ArrayList<Prestamo> prestamosVencidos() {
       ArrayList<Prestamo> listaVencidos = new ArrayList<>();
       Calendar hoy = Calendar.getInstance();
       for (Libro libro : this.getLibros()) {
           for (Prestamo prestamo : libro.getPrestamos()) {
              if (prestamo.vencido(hoy)) {
                listaVencidos.add(prestamo);
              }
           }
       }
       return listaVencidos;
    }

    public ArrayList<Docente> docentesResponsables() {
    ArrayList<Docente> listaResponsables = new ArrayList<>();
    for (Socio socio : this.getSocios().values()) {
        if (socio instanceof Docente) {
            Docente docente = (Docente) socio;
            if (docente.esResponsable()) {
                listaResponsables.add(docente);
            }
        }
    }
    return listaResponsables;
}

}
