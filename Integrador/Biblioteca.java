import java.util.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Clase representativa de una Biblioteca que contiene una colección de socios y libros.
 * 
 * @version 1.0
*/
public class Biblioteca {
    private String nombre;
    private HashMap<Integer, Socio> socios;
    private Set<Libro> libros;

    /**
     * Constructor de la clase Biblioteca con socios y libros.
     * 
     * @param p_nombre - nombre de la biblioteca
     * @param p_socios - colección de socios
     * @param p_libros - colección de libros
    */
    public Biblioteca(String p_nombre, HashMap<Integer, Socio> p_socios, Set<Libro> p_libros)
    {
        this.setNombre(p_nombre);
        this.setSocios(p_socios);
        this.setLibros(p_libros);
    }

    /**
     * Constructor de la clase Biblioteca sin socios ni libros.
     * 
     * @param p_nombre - nombre de la biblioteca
    */
    public Biblioteca(String p_nombre)
    {
        this.setNombre(p_nombre);
        this.setSocios(new HashMap<Integer, Socio>());
        this.setLibros(new HashSet<Libro>());
    }

    // Getters y Setters
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    private void setSocios(HashMap<Integer, Socio> p_socios)
    {
        this.socios = p_socios;
    }

    public HashMap<Integer, Socio> getSocios()
    {
        return this.socios;
    }

    public void setLibros(Set<Libro> p_libros)
    {
        this.libros = p_libros;
    }

    public Set<Libro> getLibros()
    {
        return this.libros;
    }

    /**
     * Agregar un socio a la collección de socios.
     * 
     * @param p_socio - socio a agregar
    */
    public void agregarSocio(Socio p_socio)
    {
        if (!this.getSocios().containsKey(p_socio.getDni())) // Si el socio no existe en la lista
        {
            this.getSocios().put(p_socio.getDni(), p_socio);
        }
        else
        {
            System.out.println("Socio añadido con anterioridad");
        }
    }

    /**
     * Quitar un socio de la colección de socios.
     * 
     * @param p_socio - socio a quitar
     * @return boolean - true si se quitó el socio, false en caso contrario
    */
    public boolean quitarSocio(Socio p_socio)
    {
        if (this.getSocios().containsKey(p_socio.getDni())) // Si el socio existe en la lista
        {
            this.getSocios().remove(p_socio.getDni());
            return true;
        }
        return false;
    }

    /**
     * Agregar un libro a la colección de libros.
     * 
     * @param p_libro - libro a agregar
    */
    public void agregarLibro(Libro p_libro)
    {
        this.getLibros().add(p_libro);
    }

    /**
     * Quitar un libro de la colección de libros.
     * 
     * @param p_libro - libro a quitar
     * @return boolean - true si se quitó el libro, false en caso contrario
    */
    public boolean quitarLibro(Libro p_libro)
    {
        return this.getLibros().remove(p_libro);
    }

    /**
     * Crea un nuevo libro y lo agrega a la colección de libros.
     * 
     * @param p_titulo - título del libro
     * @param p_edicion - edición del libro
     * @param p_editorial - editorial del libro
     * @param p_anio - año de publicación del libro
     */
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio)
    {
        Libro libro = new Libro(p_titulo, p_edicion, p_editorial, p_anio); // Instancia un nuevo libro
        this.agregarLibro(libro);
    }

    /**
     * Crea un nuevo socio de tipo Estudiante y lo agrega a la colección de socios.
     * 
     * @param p_dniSocio - DNI del socio
     * @param p_nombre - nombre del socio
     * @param p_carrera - carrera del socio
     */
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre, String p_carrera)
    {
        Estudiante estudiante = new Estudiante(p_dniSocio, p_nombre, p_carrera); 
        this.getSocios().put(estudiante.getDni(), estudiante);
    }

    /**
     * Crea un nuevo socio de tipo Docente y lo agrega a la colección de socios.
     * 
     * @param p_dniSocio - DNI del socio
     * @param p_nombre - nombre del socio
     * @param p_area - área del socio
     */
    public void nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area)
    {
        Docente docente = new Docente(p_dniSocio, p_nombre, p_area);
        this.getSocios().put(docente.getDni(), docente);
    }

    /**
     * Presta un libro a un socio si cumple con las condiciones.
     * 
     * @param p_fechaRetiro - fecha de retiro del libro
     * @param p_socio - socio que solicita el libro
     * @param p_libro - libro a prestar
     * @return boolean - true si se prestó el libro, false en caso contrario
     */
    public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro)
    {
        boolean prestado = false;
        if (p_socio.soyDeLaClase().equals("Estudiante")) // Si el socio es un Estudiante
        {
            if (p_socio.cantLibrosPrestados() <= 3 && p_socio.puedePedir()) // Evaluar que el Estudiante no tenga más de 3 libros prestados y pueda pedir
            {
                Prestamo prestamo = new Prestamo(p_fechaRetiro, p_socio, p_libro);
                p_socio.agregarPrestamo(prestamo);
                p_libro.agregarPrestamo(prestamo);
                return prestado = true;
            }
        }
        else // Si no el socio es un Docente
        {
            if (p_socio.soyDeLaClase().equals("Docente"))
            {
                if (p_socio.puedePedir()) // Pueden pedir la cantidad de libros que quieran
                {
                    if (((Docente) p_socio).esResponsable()) // Y si el docente es responsable se le agrega un día más de préstamo
                    {
                        ((Docente) p_socio).cambiarDiasDePrestamo(p_socio.getDiasPrestamo() + 1);
                    }
                }
                Prestamo prestamo = new Prestamo(p_fechaRetiro, p_socio, p_libro);
                p_socio.agregarPrestamo(prestamo);
                p_libro.agregarPrestamo(prestamo);
                return prestado = true;
            }
        }
        return prestado;
    }

    /**
     * Devuelve un libro prestado.
     * 
     * @param p_libro
     * @throws LibroNoPrestadoException
     */
    public void devolverLibro(Libro p_libro) throws LibroNoPrestadoException
    {
        if (p_libro.prestado()) // Evaluar si el libro está prestado
        {
            Prestamo prestamo = p_libro.ultimoPrestamo();
            Socio socio = prestamo.getSocio();

            prestamo.registrarFechaDevolucion(Calendar.getInstance());
            socio.quitarPrestamo(prestamo);
        }
        else
        {
            throw new LibroNoPrestadoException(
                    "El libro: " + p_libro.getTitulo() + " no se puede devolver ya que se encuentra en la biblioteca");
        }
    }

    /**
     * Calcular la cantidad de socios por tipo.
     * 
     * @param p_objeto - tipo de socio (Estudiante o Docente)
     * @return int - cantidad de socios del tipo especificado
    */
    public int cantidadDeSociosPorTipo(String p_objeto)
    {
        int contador = 0;
        for (Socio s : this.getSocios().values())
        {
            if (s.soyDeLaClase().equalsIgnoreCase(p_objeto))
            {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Devuelve el Socio que tiene el dni pasado como parámetro, o null si no lo
     * encuentra.
     * 
     * @param p_dni DNI del socio a buscar.
     * @return El objeto Socio o null.
     */
    public Socio buscarSocio(int p_dni)
    {
        return getSocios().get(p_dni);
    }

    /**
     * Lista de libros con su estado de préstamo.
     * 
     * @return String - lista de libros con su estado de préstamo
    */
    public String listaDeLibros()
    {
        // StringBuilder usa un bufer interno que se expande si es necesario
        // permitiendo que agregues texto (append) sin crear un nuevo objeto
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de libros: \n");

        int i = 1;
        for (Libro l : getLibros())
        {
            String prestado = l.prestado() ? "Si" : "No";
            sb.append(i++).append(") Titulo: ").append(l.getTitulo()).append(" || Prestado: (").append(prestado)
                    .append(")\n");
        }
        return sb.toString();
    }

    /**
     * Lista de títulos de libros sin repeticiones.
     * 
     * @return String - lista de títulos de libros
    */
    public String listaDeTitulos()
    {
        return libros.stream().map(libro -> libro.getTitulo()).distinct().collect(Collectors.joining("\n"));
    }

    /**
     * Lista de socios con su información.
     * 
     * @return String - lista de socios
    */
    public String listaDeSocios()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Socios:\n");

        int i = 1;
        for (Socio s : this.getSocios().values())
        {
            sb.append(i++).append(") ").append(s.toString()).append("\n");
        }

        sb.append("**************************************\n");
        sb.append("Cantidad de Socios del tipo Estudiante: ").append(cantidadDeSociosPorTipo("Estudiante"))
                .append("\n");
        sb.append("Cantidad de Socios del tipo Docente: ").append(cantidadDeSociosPorTipo("Docente")).append("\n");
        sb.append("**************************************\n");

        return sb.toString();
    }

    /**
     * Lista de docentes responsables.
     * 
     * @return String - lista de docentes responsables
    */
    public String listaDeDocentesResponsables()
    {
        StringBuilder entr = new StringBuilder();
        entr.append("Lista de Docentes Responsables: \n");

        // Uso de pattern matching
        // Matched target --> s(Socio)
        // Pattern --> (Docente)d
        // Match result --> resultado de la coincidencia (d)
        for (Socio s : this.getSocios().values())
        {
            if (s instanceof Docente d)
            {
                if (d.esResponsable())
                {
                    entr.append(d.toString()).append("\n");
                }
            }
        }
        return entr.toString();
    }

    /**
     * Devuelve el nombre del socio que tiene el libro prestado.
     * 
     * @param p_libro Libro del cual se desea conocer el socio que lo tiene prestado.
     * @return El nombre del socio que tiene el libro prestado.
     * @throws LibroNoPrestadoException Si el libro no está prestado.
    */
    public String quienTieneElLibro(Libro p_libro) throws LibroNoPrestadoException
    {
        if (!p_libro.prestado())
        {
            throw new LibroNoPrestadoException("El libro se encuentra en la biblioteca");
        }
        Prestamo prestamo = p_libro.ultimoPrestamo();
        Socio socio = prestamo.getSocio();
        return socio.getNombre();
    }

    /**
     * Lista de préstamos vencidos.
     * 
     * @return ArrayList<Prestamo> - lista de préstamos vencidos
    */
    public ArrayList<Prestamo> prestamosVencidos()
    {
        ArrayList<Prestamo> listaVencidos = new ArrayList<>();
        Calendar hoy = Calendar.getInstance();
        for (Libro libro : this.getLibros())
        {
            for (Prestamo prestamo : libro.getPrestamos())
            {
                if (prestamo.vencido(hoy))
                {
                    listaVencidos.add(prestamo);
                }
            }
        }
        return listaVencidos;
    }

    /**
     * Lista de docentes responsables.
     * 
     * @return ArrayList<Docente> - lista de docentes responsables
    */
    public ArrayList<Docente> docentesResponsables()
    {
        ArrayList<Docente> listaResponsables = new ArrayList<>();
        for (Socio socio : this.getSocios().values())
        {
            if (socio instanceof Docente)
            {
                Docente docente = (Docente) socio;
                if (docente.esResponsable())
                {
                    listaResponsables.add(docente);
                }
            }
        }
        return listaResponsables;
    }
}
