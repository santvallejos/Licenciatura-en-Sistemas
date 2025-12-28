import java.util.Scanner;

/**
 * Clase principal que simula un sistema de registro civil.
 * Permite registrar matrimonios y divorcios entre personas,
 * demostrando la funcionalidad de las clases Hombre y Mujer.
 * 
 * @author Sistema de Registro Civil
 */
public class RegistroCivil {
    /**
     * Método principal que ejecuta el sistema de registro civil.
     * Solicita datos de una pareja, registra su matrimonio y posteriormente
     * simula un divorcio, mostrando los cambios de estado civil.
     * 
     * @param args Argumentos de la línea de comandoss
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== CERTIFICADO DE MATRIMONIO ===\n");
        // Ingreso de datos Hombre
        System.out.println("Ingrese el Nombre del Hombre: ");
        String nombreHombre = sc.nextLine();

        System.out.println("Ingrese el Apellido del Hombre: ");
        String apellidoHombre = sc.nextLine();

        System.out.println("Ingrese la Edad del Hombre: ");
        int edadHombre = sc.nextInt();
        sc.nextLine();

        // Ingreso de datos Mujer
        System.out.println("Ingrese el Nombre de la Mujer: ");
        String nombreMujer = sc.nextLine();

        System.out.println("Ingrese el Apellido de la Mujer: ");
        String apellidoMujer = sc.nextLine();

        System.out.println("Ingrese la Edad de la Mujer: ");
        int edadMujer = sc.nextInt();
        sc.nextLine();

        // crear Hombre
        Hombre hombre = new Hombre(nombreHombre, apellidoHombre, edadHombre);
        // crear Mujer
        Mujer mujer = new Mujer(nombreMujer, apellidoMujer, edadMujer);

        System.out.println("=== DATOS DE LA PAREJA ===\n");
        System.out.println(hombre.datos());
        System.out.println(mujer.datos());

        // Casamiento
        System.out.println("=== REGISTRANDO MATRIMONIO ===\n");
        hombre.casarseCon(mujer);

        // Mostrar estados despues de casarse
        hombre.casadoCon();
        mujer.casadaCon();
    }
}
