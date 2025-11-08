import java.util.ArrayList;
import java.util.Calendar;

/**
 * Write a description of class Socio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Socio
{
    // instance variables - replace the example below with your own
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList<Prestamo> prestamos;

    /**
     * Constructor for objects of class Socio
     * Añadir otro constructor donde se pasa un array ya creado, 
     * o donde hay un metodo agregarPrestamo??
     */
    public Socio(int p_dni, String p_nombre, int p_dias){
        this.setDni(p_dni);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_dias);
        this.setPrestamos(new ArrayList<>());
        // initialise instance variables
    
    }
    private void setPrestamos(ArrayList<Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }
    /**
     * agregar algo mas a ArrayList?
     */
    public ArrayList <Prestamo> getPrestamos(){
        return this.prestamos;
    }
    private void setDni(int p_dni){
        this.dniSocio = p_dni;
    }
    public int getDni(){
        return this.dniSocio;
    }
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    //para el metodo cambiarDiasPrestamo() de Docente
    protected void setDiasPrestamo(int p_dias){
        this.diasPrestamo = p_dias;
    }
    public int getDiasPrestamo(){
        return this.diasPrestamo;
    }
    
    public int cantLibrosPrestados(){
        return this.getPrestamos().size();
    }
    public String toString(){
        return "D.N.I: " + this.getDni() + "||" + this.getNombre() + this.soyDeLaClase() 
        + "||" + this.cantLibrosPrestados(); 
    }
    /**
     * Pense en compararlo con p.fechaDevolucion() pero en ese caso
     * me daria false siempre ya que estoy comparando la misma fecha
     * consigo misma. En este caso la comparo con la fecha actual
     */
    public boolean puedePedir(){
        Calendar fechaHoy = Calendar.getInstance();
        
        for(Prestamo p : this.getPrestamos()){
            if(p.vencido(fechaHoy)){
                return false;
            }
            
        }
        return true;
    }
    //En la clase Biblioteca hay un metodo prestarLibro()
    //Crea el préstamo, y lo agrega en el libro y el socio.
    //No deberia hacer el metodo agregar en Socio entonces?
    
    
    public void agregarPrestamo(Prestamo p_prestamo){
        if(!this.getPrestamos().contains(p_prestamo)){
            this.getPrestamos().add(p_prestamo);
        }
    }
    
    public void quitarPrestamo(Prestamo p_prestamo) {
    this.getPrestamos().remove(p_prestamo);
}

    
    public abstract String soyDeLaClase();
    
    

}