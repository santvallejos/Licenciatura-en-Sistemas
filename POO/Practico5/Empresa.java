import java.util.*;

public class Empresa {
    public static void main(String[] args) {

        Persona persona1 = new Persona(20304050, "Perez", "Juliana", 2005);
        Persona persona2 = new Persona(20159462, "Dominguez", "Pedro", 1995);

        Empleado empleado1 = new Empleado(20304050, "Perez", "Juliana", 2005, 22030405002L, 600000);
        Empleado empleado2 = new Empleado(20159462, "Dominguez", "Pedro", 1995, 20201594623l, 325000);

        persona1.mostrar();
        empleado1.mostrar();

        persona2.mostrar();
        empleado2.mostrar();

    }
}