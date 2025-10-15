import java.util.*;

/**
 * Clase para administrar la gerencia de alojamientos y servicios
 * 
 * @author Gestion de Alojamientos y servicios
 * @version 1.0
 */
public class Gerencia {
    private String nombre;
    private ArrayList<Alojamiento> alojamientos;

    Gerencia(String p_nombre) {
        this.setNombre(p_nombre);
        this.setAlojamientos(new ArrayList<Alojamiento>());
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    private void setAlojamientos(ArrayList<Alojamiento> p_alojamientos) {
        this.alojamientos = p_alojamientos;
    }

    public ArrayList<Alojamiento> getAlojamientos() {
        return this.alojamientos;
    }

    public boolean agregarAlojamiento(Alojamiento p_alojamiento) {
        return this.getAlojamientos().add(p_alojamiento);
    }

    public boolean quitarAlojamiento(Alojamiento p_alojamiento) {
        return this.getAlojamientos().remove(p_alojamiento);
    }

    /**
     * Contar alojamientos por tipo
     * 
     * @param tipoAlojamiento
     * @return int - cantidad de alojamientos del tipo especificado
    */
    public int contarAlojamiento(String tipoAlojamiento) {
        int contador = 0;
        for (Alojamiento alojamiento : this.getAlojamientos()) {
            if (alojamiento.getClass().getSimpleName().equals(tipoAlojamiento)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Liquidar todos los alojamientos y mostrar la cantidad por tipo
    */
    public void liquidar() {
        System.out.println("Gerencia " + nombre);
        System.out.println("Liquidación-------------------");

        for (Alojamiento alojamiento : this.getAlojamientos()) {
            alojamiento.liquidar();
            System.out.println();
        }

        System.out.println("Alojamiento tipo Cabaña ---->" + contarAlojamiento("Cabaña"));
        System.out.println("Alojamiento tipo Hotel ------->" + contarAlojamiento("Hotel"));
    }
}