
/**
 * Write a description of class AdministracionGerencia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AdministracionGerencia
{
    public static void main(String[] args) {
        // Crear gerencia
        Gerencia gerencia = new Gerencia("Los Arroyos");
        
        // Situación 1: Hotel con 1 semana de estadía, internet y lavandería
        Hotel hotel = new Hotel("Hotel Guaraní", 90.0, 7, "Single");
        hotel.agregarServicio(new Servicio("internet", 5.0));
        hotel.agregarServicio(new Servicio("lavanderia", 20.0));
        gerencia.agregarAlojamiento(hotel);
        
        // Situación 2: Cabaña por 5 días, lavandería y alquiler de auto
        Cabaña cabaña = new Cabaña("Cabañas La Alondra", 120.0, 3, 5);
        cabaña.agregarServicio(new Servicio("lavanderia", 20.0));
        cabaña.agregarServicio(new Servicio("alquiler auto", 100.0));
        gerencia.agregarAlojamiento(cabaña);
        
        // Mostrar liquidación
        gerencia.liquidar();
    }
}