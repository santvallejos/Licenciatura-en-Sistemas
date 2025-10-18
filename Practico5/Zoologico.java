import java.util.*;

public class Zoologico {
    private String nombre;
    private ArrayList<Visitante> visitantes;

    Zoologico(String p_nombre) {
        this.setNombre(p_nombre);
        this.visitantes = new ArrayList<Visitante>();
    }

    Zoologico(String p_nombre, ArrayList<Visitante> p_visitantes) {
        this.setNombre(p_nombre);
        this.visitantes = new ArrayList<Visitante>();
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    private void setVisitantes(ArrayList<Visitante> p_visitantes) {
        this.visitantes = p_visitantes;
    }

    public ArrayList<Visitante> getVisitantes() {
        return this.visitantes;

    }

    public void nuevoVisitante(Visitante p_Visitante) {
        this.visitantes.add(p_Visitante);
    }

    public void quitarVisitante(Visitante p_Visitante) {
        this.visitantes.remove(p_Visitante);
    }

    public void listarTipoVisitantePorFecha(Calendar p_fecha, String p_tipoVisitante) {
        for (Visitante visitante : this.getVisitantes()) {
            visitante.listarPorFecha(p_fecha, p_tipoVisitante);
        }
    }

    public void listarVisitantePorFecha(Calendar p_fecha) {
        for (Visitante visitante : this.getVisitantes()) {
            if (visitante.getFechaVisita().equals(p_fecha)) {
                visitante.mostrar();
            }
        }
    }

    public double recaudacion(Calendar p_fechaDesde, Calendar p_fechaHasta) {
        double total = 0;

        for (Visitante visitante : getVisitantes()) {

            if ((visitante.getFechaVisita().compareTo(p_fechaDesde) >= 0)
                    && (visitante.getFechaVisita().compareTo(p_fechaHasta) <= 0)) {
                total = total + visitante.entrada();
            }

        }
        return total;
    }

    public HashSet<Persona> listarPersonasQueVisitaronElZoo() {
        HashSet<Persona> personas = new HashSet<Persona>();
        for (Visitante visitante : getVisitantes()) {
            personas.addAll(visitante.listarPersonas());
        }

        return personas;
    }

}