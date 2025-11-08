
/**
 * Write a description of class Estudiante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estudiante extends Socio{
    // instance variables - replace the example below with your own
    private String carrera;

    /**
     * Constructor for objects of class Estudiante
     */

    public Estudiante (int p_dni, String p_nombre, String p_carrera, Prestamo p_prestamo) {
     super (p_dni, p_nombre, 0);
     this.setCarrera(p_carrera);
    }

    public Estudiante (int p_dni, String p_nombre, String p_carrera) {
     super (p_dni, p_nombre, 0);
     this.setCarrera(p_carrera);
    }
    

    private void setCarrera(String p_carrera){
        this.carrera = p_carrera;
    }
    public String getCarrera(){
        return this.carrera;
    }
    
    public boolean puedePedir(){
        if(super.puedePedir() && super.cantLibrosPrestados() < 3){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String soyDeLaClase(){
        return "Estudiante";
    }

    
}