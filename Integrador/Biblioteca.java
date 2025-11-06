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
    StringBuilder sb = new StringBuilder(); //StringBuilder usa un bufer interno que se expande si es necesario permitiendo que agregues texto (append) sin crear un nuevo objeto
    
    // Getters y Setters
    private void setSocios(HashMap<Integer, Socio> p_socios)
    {
        this.socios = p_socios;
    }
    
    public HashMap<Integer, Socio> getSocios()
    {
        return this.socios;
    }

    /**
     * Calcular la cantidad de socios por tipo (Estudiante o Docente)
     * 
     * @param p_objeto - Tipo de socio a contar
     * @return Cantidad de socios del tipo especificado
    */
    public int cantidadDeSociosPorTipo(String p_objeto)
    {
        int contador = 0;
        for(Socio s : this.getSocios())
        {
            if(s.soyDeLaClase().equalsIgnoreCase(p_objeto)){
                contador++;
            }
        }

        return contador;
    }
    
    /**
     * Devuelve el Socio que tiene el dni pasado como parámetro, o null si no lo encuentra.
     * 
     * @param p_dni DNI del socio a buscar.
     * @return El objeto Socio o null.
     */
    public Socio buscarSocio(int p_dni)
    {
        return getSocios().get(p_dni);
    }

    /**
     * Devuelve la lista de libros de la biblioteca.
     * 
     * @return Conjunto de libros.
     */
    public String listaDeLibros()
    {
        sb.append("Lista de libros: \n");

        int i=1;
        for(Libro l: getLibros()){
            String prestado = l.prestado() ? "Si" : "No";
            sb.append(i++).append(") Titulo: ").append(l.getTitulo()).append(" || Prestado: (").append(prestado).append(")\n");
        }

        return sb.toString();
    }

    /**
     * Devuelve una lista con los títulos de los libros.
     * 
     * @return Lista de títulos.
    */
    public String listaDeTitulos()
    {
        return libros.stream().libro.getTitulo().distinct().collect(Collectors.joining("\n"));
    }

    /**
     * Devuelve la lista de socios de la biblioteca.
     * 
     * @return Lista de socios.
    */
    public String listaDeSocios()
    {
        sb.append("Lista de Socios:\n"); 

        int i = 1;
        for (Socio s : getSocios()) {
            sb.append(i++).append(") ").append(s.toString()).append("\n"); 
        }

        // Agregar el resumen de cantidad de tipos 
        sb.append("**************************************\n");
        sb.append("Cantidad de Socios del tipo Estudiante: ").append(cantidadDeSociosPorTipo("Estudiante")).append("\n"); 
        sb.append("Cantidad de Socios del tipo Docente: ").append(cantidadDeSociosPorTipo("Docente")).append("\n"); 
        sb.append("**************************************\n");

        return sb.toString();
    }
}