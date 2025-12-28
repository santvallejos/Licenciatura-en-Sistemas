import java.util.*;

public class GestionComercio {
    public static void main(String[] args) {
        Comercio comercio = new Comercio("Avanti SRL", new HashMap<>()); // Instanciar comercio

        // instancio empleados
        Empleado empleado1 = new Empleado(203040506012L, "Perez", "Matias", 233000, 2023);
        Empleado empleado2 = new Empleado(203131346211L, "Benitez", "Lautaro", 500000, 2022);
        Empleado empleado3 = new Empleado(293424341239L, "Canteros", "Juan", 255000, 2025);

        // añado empleados al comercio
        comercio.altaEmpleado(empleado1);
        comercio.altaEmpleado(empleado2);
        comercio.altaEmpleado(empleado3);

        comercio.nomina();

        // cantidad empleados en el comercio
        System.out.println("Cantidad de empleados en el comercio: " + comercio.cantidadEmpleados());
        // quitamos un empleado del comercio
        comercio.bajaEmpleado(empleado1.getCuil());

        comercio.nomina();

        // cantidad empleados en el comercio actualizado
        System.out.println("Cantidad de empleados en el comercio: " + comercio.cantidadEmpleados());
        // es empleado?
        System.out.println("¿Es empleado Lautaro Benitez? " + comercio.esEmpleado(empleado2.getCuil()));

        // buscamos el empleado
        System.out.println("Busca y muestra el empleado con el cuil " + empleado2.getCuil());
        comercio.buscarEmpleado(empleado2.getCuil());

        // retornamos el sueldo neto de ese empleado
        comercio.sueldoNeto(empleado2.getCuil());

    }

}
