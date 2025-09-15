/**
 * Clase que representa un hombre con sus datos personales y estado civil.
 * Permite gestionar información personal y relaciones matrimoniales.
 * 
 * @author Sistema de Registro Civil
 */
public class Hombre {
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private Mujer esposa;

    /**
     * Constructor básico del hombre.
     * Crea un hombre soltero con sus datos personales.
     * 
     * @param p_nombre   Nombre del hombre
     * @param p_apellido Apellido del hombre
     * @param p_edad     Edad del hombre
     */
    public Hombre(String p_nombre, String p_apellido, int p_edad) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltero");
    }

    /**
     * Constructor completo del hombre.
     * Crea un hombre casado con su esposa.
     * 
     * @param p_nombre   Nombre del hombre
     * @param p_apellido Apellido del hombre
     * @param p_edad     Edad del hombre
     * @param p_esposa   Mujer con la que está casado
     */
    public Hombre(String p_nombre, String p_apellido, int p_edad, Mujer p_esposa) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEsposa(p_esposa);
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    private void setEdad(int p_edad) {
        this.edad = p_edad;
    }

    public int getEdad() {
        return this.edad;
    }

    private void setEstadoCivil(String p_estadoCivil) {
        this.estadoCivil = p_estadoCivil;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    private void setEsposa(Mujer p_esposa) {
        this.esposa = p_esposa;
    }

    public Mujer getEsposa() {
        return this.esposa;
    }

    /**
     * Realiza el matrimonio con una mujer.
     * Establece la relación matrimonial bidireccional si ambos están solteros.
     * 
     * @param p_mujer Mujer con la que se casará
     */
    public void casarseCon(Mujer p_mujer) {
        /* Si el casamiento se realiza por parte de él */
        if(p_mujer.getEsposo() == null && this.getEsposa() == null)
        {
            this.setEsposa(p_mujer);
            this.setEstadoCivil("Casado/a");
            p_mujer.casarseCon(this);
            System.out.println("Ahora el estado civil de " + p_mujer.getNombre() + " " + p_mujer.getApellido() + " es " + p_mujer.getEstadoCivil());
        } 
        /* Si el casamiento se realiza por parte de ella y él es su esposo */
        else if ((p_mujer.getEsposo() != null && p_mujer.getEsposo() == this) && this.getEsposa() == null) 
        {
            this.setEsposa(p_mujer);
            this.setEstadoCivil("Casado/a");
            System.out.println("Ahora el estado civil de " + p_mujer.getNombre() + " " + p_mujer.getApellido() + " es " + p_mujer.getEstadoCivil());
        }
        else
        {
            System.out.println("El matrimonio no se puede realizar. Alguno de los dos ya está casado.");
        }
    }

    /**
     * Realiza el divorcio si está casado.
     * Cambia el estado civil a divorciado y elimina la referencia a la esposa.
     */
    public void divorcio() {
        if (this.getEsposa() != null) {
            this.setEsposa(null);
            this.getEsposa().divorcio();
            this.setEstadoCivil("Divorciado/a");
            System.out.println("Ahora el estado civil de " + this.getNombre() + " " + this.getApellido() + " es " + this.getEstadoCivil());
        }

    }

    /**
     * Genera una cadena con los datos básicos del hombre.
     * 
     * @return Cadena con formato: "Nombre Apellido de [edad] años"
     */
    public String datos() {
        return (this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años ");

    }

    /**
     * Muestra en pantalla el estado civil del hombre.
     */
    public void mostrarEstadoCivil() {
        System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años " + " - "
                + this.getEstadoCivil());
    }

    /**
     * Muestra información sobre el estado matrimonial del hombre.
     * Si está casado, muestra los datos de la esposa; si no, indica que está
     * soltero.
     */
    public void casadoCon() {
        if (this.getEsposa() != null) {
            System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años " +
                    "está casado con " + this.getEsposa().getNombre() + " " +
                    this.getEsposa().getApellido() + " de " + this.getEsposa().getEdad() + " años.");
        } else {
            System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años " +
                    "no está casado.");
        }
    }
}
