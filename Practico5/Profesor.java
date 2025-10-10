import java.util.*;
/**
 * Clase que representa un Profesor que hereda de Persona.
 * Un profesor tiene un título y puede tener entre 1 y 3 cargos.
 * Los cargos pueden ser: Simple (Cargo), SemiExclusivo o Exclusivo.
 * No se pueden duplicar los tipos de cargo.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Profesor extends Persona
{
    private String titulo;
    private ArrayList<Cargo> cargos;

    /**
     * Constructor de la clase Profesor.
     * 
     * @param p_dni Número de DNI del profesor
     * @param p_nombre Nombre del profesor
     * @param p_apellido Apellido del profesor
     * @param p_anio Año de nacimiento del profesor
     * @param p_titulo Título académico del profesor
     */
    public Profesor(int p_dni, String p_nombre, String p_apellido, int p_anio, String p_titulo, ArrayList<Cargo> p_cargos)
    {
        super(p_dni, p_nombre, p_apellido, p_anio);
        this.setTitulo(p_titulo);
        this.setCargos(p_cargos);
    }

    private void setTitulo(String p_titulo)
    {
        this.titulo = p_titulo;
    }

    public String getTitulo()
    {
        return this.titulo;
    }

    public void setCargos(ArrayList<Cargo> p_cargos)
    {
        this.cargos = p_cargos;
    }

    public ArrayList<Cargo> getCargos()
    {
        return this.cargos;
    }

    /**
     * Agrega un cargo al profesor.
     * Valida que:
     * - No se exceda el máximo de 3 cargos
     * - No se dupliquen los tipos de cargo (Simple, SemiExclusivo, Exclusivo)
     * 
     * @param p_cargo El cargo a agregar
     * @return boolean - true si se agregó correctamente, false en caso contrario
     */
    public boolean agregarCargo(Cargo p_cargo)
    {
        // Verificar que no tenga más de 3 cargos
        if (this.cargos.size() >= 3) {
            System.out.println("Error: No se puede tener más de 3 cargos.");
            return false;
        }

        // Verificar que no se duplique el tipo de cargo
        String tipoNuevoCargo = p_cargo.getClass().getSimpleName();
        
        for (Cargo cargo : this.cargos) {
            String tipoCargoExistente = cargo.getClass().getSimpleName();
            if (tipoCargoExistente.equals(tipoNuevoCargo)) {
                System.out.println("Error: Ya existe un cargo de tipo " + tipoNuevoCargo);
                return false;
            }
        }

        // Si pasa las validaciones, agregar el cargo
        this.cargos.add(p_cargo);
        return true;
    }

    /**
     * Elimina un cargo del profesor.
     * 
     * @param p_cargo El cargo a eliminar
     * @return boolean - true si se eliminó correctamente, false si no existía
     */
    public boolean quitarCargo(Cargo p_cargo)
    {
        if (this.getCargos().size() > 1)
        {
            return this.cargos.remove(p_cargo);
        }
        return false;
    }

    /**
     * Listar los cargos del profesor.
     * 
     * @return String - Lista de cargos
    */
    public void listarCargos()
    {
        System.out.println("Cargos del profesor " + this.nomYApe() + ":");
        for (Cargo cargo : this.cargos) {
            System.out.println(cargo.getNombreCargo());
        }
    }

    /**
     * Calcula el sueldo total del profesor sumando todos sus cargos.
     * 
     * @return double - Sueldo total del profesor
     */
    public double sueldoTotal()
    {
        double total = 0.0;
        for (Cargo cargo : this.cargos) {
            total += cargo.sueldoDelCargo();
        }
        return total;
    }

    /**
     * Muestra la información completa del profesor y sus cargos.
     */
    public void mostrarCargos()
    {
        System.out.println("***** Profesor *****");
        System.out.println(this.nomYApe());
        System.out.println("Titulo: " + this.getTitulo());
        System.out.println("Sueldo Total: $" + this.sueldoTotal());
        System.out.println("\n----- Cargos (" + this.cargos.size() + ") -----");
        
        for (Cargo cargo : this.cargos) {
            cargo.mostrarCargo();
            System.out.println();
        }
    }

    /**
     * Devuelve el nombre y apellido concatenados.
     * 
     * @return String - Nombre completo
     */
    public String nomYApe()
    {
        return this.getNombre() + " " + this.getApellido();
    }

    /**
     * Devuelve el apellido y nombre concatenados.
     * 
     * @return String - Apellido y nombre
     */
    public String apeYNom()
    {
        return this.getApellido() + " " + this.getNombre();
    }
}