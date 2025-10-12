import java.util.*;
/**
 * Aplicacion para gestionar los profesores y sus cargos en una facultad
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AplicacionFacultad
{
    public static void main(String[] args)
    {
        // Crear cargos
        Cargo cargo1 = new Cargo("Simple", 10000, 2010, 10);
        SemiExclusivo cargo2 = new SemiExclusivo("Semi-exclusivo", 40000, 2005, 10, 10);
        Exclusivo cargo3 = new Exclusivo("Exclusivo", 70000, 2000, 40, 10, 5);
        
        // Crear profesores
        // Al instanciar se le agrega o un solo cargo o una lista de cargos
        // Crear un arraylist de cargos para el segundo profesor
        ArrayList<Cargo> listaCargos = new ArrayList<>();
        listaCargos.add(cargo1);
        listaCargos.add(cargo2);

        Profesor profesor1 = new Profesor(12345678, "Juan", "Perez", 1980, "Licenciado en Informatica", listaCargos);
        Profesor profesor2 = new Profesor(87654321, "Maria", "Gomez", 1975, "Profesor de Matematicas", cargo2);

        profesor2.agregarCargo(cargo3);

        // Crear facultad y agregar profesores
        ArrayList<Profesor> listaProfesores = new ArrayList<>();
        listaProfesores.add(profesor1);
        listaProfesores.add(profesor2);

        Facultad facultad = new Facultad("Facultad de Ciencias Exactas", listaProfesores);

        // Mostrar informacion de la facultad y sus profesores
        System.out.println("Facultad: " + facultad.getNombre());
        facultad.nominaProfesores();
        facultad.listarProfesorCargos();
    }
}