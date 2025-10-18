
public class Escuela {
    public static void main(String[] args) {
        Persona persona1 = new Persona(12223311, "Juan", "Benitez", 2005);
        Persona persona2 = new Persona(40212304, "Rocio", "Fernandez", 2002);

        Alumno alumno1 = new Alumno(persona1, 42111452);
        Alumno alumno2 = new Alumno(persona2, 42111453);

        alumno1.setNota1(9);
        alumno1.setNota2(7);

        alumno2.setNota1(6);
        alumno2.setNota2(9);

        alumno1.mostrar();
        alumno2.mostrar();
        persona1.mostrar();
        persona2.mostrar();

    }
}
