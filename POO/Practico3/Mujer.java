/**
 * Clase que representa una mujer con sus datos personales y estado civil.
 * Permite gestionar información personal y relaciones matrimoniales.
 * 
 * @author Sistema de Registro Civil
 */
public class Mujer {
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private Hombre esposo;

    /**
     * Constructor básico de la mujer.
     * Crea una mujer soltera con sus datos personales.
     * 
     * @param p_nombre   Nombre de la mujer
     * @param p_apellido Apellido de la mujer
     * @param p_edad     Edad de la mujer
     */
    public Mujer(String p_nombre, String p_apellido, int p_edad) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltera");
    }

    /**
     * Constructor completo de la mujer.
     * Crea una mujer casada con su esposo.
     * 
     * @param p_nombre   Nombre de la mujer
     * @param p_apellido Apellido de la mujer
     * @param p_edad     Edad de la mujer
     * @param p_esposo   Hombre con el que está casada
     */
    public Mujer(String p_nombre, String p_apellido, int p_edad, Hombre p_esposo) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEsposo(p_esposo);
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

    private void setEsposo(Hombre p_esposo) {
        this.esposo = p_esposo;
    }

    public Hombre getEsposo() {
        return this.esposo;
    }

    /**
     * Realiza el matrimonio con un hombre.
     * Establece la relación matrimonial bidireccional si ambos están solteros.
     * 
     * @param p_hombre Hombre con el que se casará
     */
    public void casarseCon(Hombre p_hombre) {
        /* Si el casamiento se realiza por parte de ella */
        if(p_hombre.getEsposa() == null && this.getEsposo() == null)
        {
            this.setEsposo(p_hombre);
            this.setEstadoCivil("Casado/a");
            p_hombre.casarseCon(this);
            System.out.println("Ahora el estado civil de " + p_hombre.getNombre() + " " + p_hombre.getApellido() + " es " + p_hombre.getEstadoCivil());
        }
        /* Si el casamiento se realiza por parte de él y ella es su esposa */
        else if ((p_hombre.getEsposa() != null && p_hombre.getEsposa() == this) && this.getEsposo() == null) 
        {
            this.setEsposo(p_hombre);
            this.setEstadoCivil("Casado/a");
            System.out.println("Ahora el estado civil de " + p_hombre.getNombre() + " " + p_hombre.getApellido() + " es " + p_hombre.getEstadoCivil());
        }
        else
        {
            System.out.println("El matrimonio no se puede realizar. Alguno de los dos ya está casado.");
        }
    }

    /**
     * Realiza el divorcio si está casada.
     * Cambia el estado civil a divorciada y elimina la referencia al esposo.
     */
    public void divorcio() {
        if (this.getEsposo() != null) {
            this.setEsposo(null);
            this.getEsposo().divorcio();
            this.setEstadoCivil("Divorciado/a");
            System.out.println("Ahora el estado civil de " + this.getNombre() + " " + this.getApellido() + " es " + this.getEstadoCivil());
        }
    }

    /**
     * Genera una cadena con los datos básicos de la mujer.
     * 
     * @return Cadena con formato: "Nombre Apellido de [edad] años"
     */
    public String datos() {
        return (this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años ");

    }

    /**
     * Muestra en pantalla el estado civil de la mujer.
     */
    public void mostrarEstadoCivil() {
        System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años " + " - "
                + this.getEstadoCivil());
    }

    /**
     * Muestra información sobre el estado matrimonial de la mujer.
     * Si está casada, muestra los datos del esposo; si no, indica que está soltera.
     */
    public void casadaCon() {
        if (this.getEsposo() != null) {
            System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años " +
                    "está casada con " + this.getEsposo().getNombre() + " " +
                    this.getEsposo().getApellido() + " de " + this.getEsposo().getEdad() + " años.");
        } else {
            System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años " +
                    "no está casada.");
        }
    }
}
