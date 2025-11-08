
/**
 * Write a description of class Docente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Docente extends Socio
{
    // instance variables - replace the example below with your own
    private String area;

    /**
     * Constructor for objects of class Docente
     */
    public Docente(int p_dni, String p_nombre, int p_diasPrestamo, String p_area)
    {
        super(p_dni, p_nombre, 5);
        this.setArea(p_area);// initialise instance variables
        
    }

    public Docente (int p_dni, String p_nombre, String p_area){
        super(p_dni, p_nombre, 5);
        this.setArea(p_area);
    }
    private void setArea(String p_area){
        this.area = p_area;
    }
    public String getArea(){
        return this.area;
    }
    /**
     * - esResponsable(): devuelve true si el Docente nunca tuvo ni tiene un préstamo vencido.
     * - puedePedir(): devuelve true si el socio no tiene ningún préstamo vencido.
     * nunca tuve prestamo vencido --> persistencia?
     */
    public boolean esResponsable(){
        return super.puedePedir();
    }
    
    @Override
    public String soyDeLaClase(){
        return "Docente";
    }
    
    public void cambiarDiasDePrestamo(int p_dias){
        if(this.esResponsable()){
            int nuevosDiasPrestamo = super.getDiasPrestamo() + p_dias;
            super.setDiasPrestamo(nuevosDiasPrestamo);
        }
    }
    
    

    
}