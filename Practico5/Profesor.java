import java.util.*;

public class Profesor extends Persona {
    private String titulo;
    private ArrayList<Cargo> cargos;

    /**
     * Constructor de la clase Profesor que se le pasa un cargo
     * 
     * @param nroDNI;
     * @param nombre;
     * @param apellido;
     * @param anioNacimiento;
     * @param titulo;
     * @param cargo;
    */
    public Profesor(int p_nroDNI, String p_nombre, String p_apellido, int p_anioNacimiento, String p_titulo, Cargo p_cargo) {
        super(p_nroDNI, p_nombre, p_apellido, p_anioNacimiento);
        setTitulo(p_titulo);
        this.setCargo(new ArrayList<Cargo>());
        this.agregarCargo(p_cargo);
    }

    /**
     * Constructor de la clase Profesor que se le pasa una lista de cargos
     * 
     * @param nroDNI;
     * @param nombre;
     * @param apellido;
     * @param anioNacimiento;
     * @param titulo;
     * @param cargos;
    */
    public Profesor(int p_nroDNI, String p_nombre, String p_apellido, int p_anioNacimiento, String p_titulo, ArrayList<Cargo> p_cargos) {
        super(p_nroDNI, p_nombre, p_apellido, p_anioNacimiento);
        setTitulo(p_titulo);
        this.setCargo(new ArrayList<Cargo>());
        this.agregarCargos(p_cargos);
    }

    /* Getters y Setters */
    private void setTitulo(String p_titulo)
    {
        this.titulo = p_titulo;
    }

    public String getTitulo()
    {
        return this.titulo;
    }

    private void setCargo(ArrayList<Cargo> p_cargos)
    {
        this.cargos = p_cargos;
    }

    public ArrayList<Cargo> getCargos()
    {
        return this.cargos;
    }

    public void agregarCargo(Cargo p_cargo)
    {
        if (this.cargos.size() < 3 && !this.cargos.contains(p_cargo))
        {
            this.cargos.add(p_cargo);
        }
    }

    /**
     * Agregar una lista de cargos al profesor
     * 
     * @param p_cargos
     * @return true si se agregaron todos los cargos, false si no se pudo agregar alguno
    */
    public boolean agregarCargos(ArrayList<Cargo> p_cargos)
    {
        // Verificar que la lista de cargos no sea mas de 3 cargos
        if (p_cargos.size() <= 3)
        {
            // Verificar que no haya cargos repetidos
            for (Cargo cargo : p_cargos)
            {
                if (!this.getCargos().contains(cargo))
                {
                    this.agregarCargo(cargo);
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Listar los cargos del profesor
     */
    public void listarCargos()
    {
        System.out.println("-***** Cargos Asignados *****-");
        System.out.println("---------------------------------------");
        for (Cargo cargo : this.getCargos())
        {
            cargo.mostrarCargo();
            System.out.println("");
        }
    }

    /**
     * Sueldo total del profesor
     * 
     * @return double - Sueldo total del profesor
    */
    public double sueldoTotal()
    {
        double sueldoTotal = 0;
        for (Cargo cargo : this.getCargos())
        {
            sueldoTotal += cargo.sueldoDelCargo();
        }
        return sueldoTotal;
    }

    /**
     * Mostrar el profesor
    */
    @Override
    public void mostrar()
    {
        super.mostrar();
        System.out.println("Titulo: " + getTitulo());
        System.out.println("");
        this.listarCargos();
        this.sueldoTotal();
    }

    /**
     * Mostrar Profesor en una sola linea
    */
    public void mostrarLinea()
    {
        System.out.println("DNI: " + super.getDNI() + " - Nombre: " + super.getNombre() + " - Sueldo Total: " + this.sueldoTotal());
    }
}