import java.util.*;

/**
 * Ejecutable de la clase Curso
 * 
 * @author Sistema ejecutable para cursos
 * @version 1.0
 */
public class Carrera {
    public static void main(String[] args) {
        // 5.1.1. Crear una instancia de Curso y varias de la clase Alumno
        Curso curso1 = new Curso("Programacion 1", new HashMap<>());

        Alumno alumno1 = new Alumno(12345, "Juan", "Perez");
        Alumno alumno2 = new Alumno(23456, "Maria", "Gomez");
        Alumno alumno3 = new Alumno(34567, "Carlos", "Lopez");

        // 5.1.2. Asignarles notas de parciales a los alumnos
        alumno1.setNota1(8.5);
        alumno1.setNota2(7.0);

        alumno2.setNota1(9.0);
        alumno2.setNota2(8.5);

        alumno3.setNota1(6.0);
        alumno3.setNota2(7.5);

        // 5.1.3. Inscribir los alumnos al curso creado anteriormente.
        curso1.inscribirAlumno(alumno1);
        curso1.inscribirAlumno(alumno2);
        curso1.inscribirAlumno(alumno3);

        // 5.1.4.   Imprimir la cantidad y la lista de alumnos inscriptos al curso
        curso1.mostarInscriptos();

        //5.1.5.   Dar de baja un alumno del curso, y luego verificar que no esté inscripto
        System.out.println("****-- Se da de baja a Juan porque abandona el curso --****");
        curso1.quitarAlumno(alumno1.getLu());
        System.out.println("Está Juan Perez inscripto ?? --> " + curso1.estaInscripto(alumno1));

        //5.1.6.   Imprimir nuevamente la lista de alumnos para ver como que queda definitivamente y la cantidad total de alumnos inscriptos en el curso
        System.out.println("****-- Alumnos inscriptos actualmente: " + curso1.cantidadDeAlumnos());
        curso1.mostarInscriptos();

        //5.1.7.   Buscar un alumno por su libreta. Una vez encontrado, mostrarlo con el método apropiado.
        System.out.println("****-- Busca y muestra el alumno con numero de libreta " + alumno2.getLu() + " --****");
        curso1.buscarAlumno(alumno2.getLu()).mostrar();

        //5.1.8.   Mostrar el promedio del alumno solicitado, según libreta
        System.out.println("****-- Mostrar promedio del alumno " + alumno3.getLu() + " --****");
        System.out.println("Promedio: " + curso1.buscarAlumno(alumno3.getLu()).promedio());
    }
}