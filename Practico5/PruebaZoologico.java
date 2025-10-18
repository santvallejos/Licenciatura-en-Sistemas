import java.util.*;

public class PruebaZoologico {
    public static void main(String[] args) {

        // Instacio la fecha 22/09/2024
        Calendar fecha = new GregorianCalendar(2024, Calendar.SEPTEMBER, 22);
        // *Instanciar un zoológico con el nombre “El Caribú”
        Zoologico zoologico = new Zoologico("El Caribu");
        // *Instanciar tres individuos que asistieron al zoológico.
        // *uno de ellos en forma independiente.
        Persona persona1 = new Persona(42123134, "Pepe", "Rodriguez", 23);
        Individuo Pepe = new Individuo("Pepe", fecha, persona1);

        // * los otros dos formando parte de la delegación “PAMI”, el día 22/09/2024
        Persona persona2 = new Persona(41021202, "German", "Perez", 24);
        Persona persona3 = new Persona(35321241, "Sara", "Gimenez", 30);
        Individuo German = new Individuo("German", fecha, persona2);
        Individuo Sara = new Individuo("Sara", fecha, persona3);
        Delegacion Pami = new Delegacion("PAMI", fecha, German); // creamos la delegacion con 1 individuo
        Pami.inscribirIndividuo(Sara); // agregamos el otro individuo a la delegacion "Pami"

        // *inscribimos al individuo y a la delegacion al zoologico.
        zoologico.nuevoVisitante(Pepe);
        zoologico.nuevoVisitante(Pami);

        // Listamos todos los visitantes que acudieron al zoológico el día 22/09/2024
        zoologico.listarVisitantePorFecha(fecha);

        // Listamos la recaudación del último mes.
        Calendar fechaHasta = Calendar.getInstance(); // Instancio la Fecha Actual
        Calendar fechaDesde = Calendar.getInstance(); // Instancio la Fecha Actual
        fechaDesde.add(Calendar.MONTH, -1); // Resto 1 mes a Fecha Desde, para la recaudacion del ultimo mes.

        double Recaudacion = zoologico.recaudacion(fechaDesde, fechaHasta);
        System.out.println("La recaudacion del ultimo mes es: $" + Recaudacion);

        // Listamos las delegaciones que acudieron el día 22/09/2024
        zoologico.listarTipoVisitantePorFecha(fecha, "Delegacion");

    }
}