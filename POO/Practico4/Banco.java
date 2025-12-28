import java.util.*;

/**
 * Write a description of class Banco here.
 * 
 * @author Clase de sistema bancario
 * @version 1.0
 */
public class Banco
{
    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList<Empleado> empleados;
    private ArrayList<CuentaBancaria> cuentasBancarias;


    /**
     * Constructor de banco con un solo empleado
     * 
     * @param p_nombre
     * @param p_localidad
     * @param p_nroSucursal
     * @param p_empleado
     */
    Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado)
    {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList<Empleado>());
        this.agregarEmpleado(p_empleado);
    }

    /**
     * Constructor de banco con muchos empleados
     * 
     * @param p_nombre
     * @param p_localidad
     * @param p_nroSucursal
     * @param p_empleados
     */
    Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados)
    {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList<Empleado>());
        this.agregarEmpleados(p_empleados);
    }

    /**
     * Constructor de banco con muchos empleados y muchas cuentas bancarias
     * 
     * @param p_nombre
     * @param p_localidad
     * @param p_nroSucursal
     * @param p_empleados
     * @param p_cuentas
     */
    Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados, ArrayList<CuentaBancaria> p_cuentas)
    {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList<Empleado>());
        this.agregarEmpleados(p_empleados);
        this.setCuentas(new ArrayList<CuentaBancaria>());
        this.agregarCuentasBancarias(p_cuentas);
    }

    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    private void setNroSucursal(int p_nroSucursal)
    {
        this.nroSucursal = p_nroSucursal;
    }

    public int getNroSucursal()
    {
        return this.nroSucursal;
    }

    private void setLocalidad(Localidad p_localidad)
    {
        this.localidad = p_localidad;
    }

    public Localidad getLocalidad()
    {
        return this.localidad;
    }

    private void setEmpleados(ArrayList<Empleado> p_empleados)
    {
        this.empleados = p_empleados;
    }

    public ArrayList<Empleado> getEmpleados()
    {
        return this.empleados;
    }

    private void setCuentas(ArrayList<CuentaBancaria> p_cuentas)
    {
        this.cuentasBancarias = p_cuentas;
    }

    public ArrayList<CuentaBancaria> getCuentas()
    {
        return this.cuentasBancarias;
    }

    public boolean agregarEmpleado(Empleado p_empleado)
    {
        if(p_empleado != null && !this.empleados.contains(p_empleado))
        {
            this.empleados.add(p_empleado);
            return true;
        }
        return false;
    }

    public boolean agregarEmpleados(ArrayList<Empleado> p_empleados)
    {
        for (int i = 0; i < p_empleados.size(); i++) {
            Empleado empleado = p_empleados.get(i);
            if (empleado != null && !this.empleados.contains(empleado)) {
                this.empleados.add(empleado);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean quitarEmpleado(Empleado p_empleado)
    {
        if(p_empleado != null && this.getEmpleados().size() > 1)
        {
            this.empleados.remove(p_empleado);
            return true;
        }
        return false;
    }

    public boolean agregarCuentaBancaria(CuentaBancaria p_cuenta)
    {
        /* Para validar que una cuenta sea agregada no tiene que ser null y debe tener un titular */
        if(p_cuenta != null && p_cuenta.getTitular() != null)
        {
            this.cuentasBancarias.add(p_cuenta);
            return true;
        }
        return false;
    }

    public boolean agregarCuentasBancarias(ArrayList<CuentaBancaria> p_cuentas)
    {
        for (int i = 0; i < p_cuentas.size(); i++) {
            CuentaBancaria cuenta = p_cuentas.get(i);
            /* Para validar que una cuenta sea agregada no tiene que ser null y debe tener un titular */
            if (cuenta != null && cuenta.getTitular() != null) {
                this.cuentasBancarias.add(cuenta);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean quitarCuentaBancaria(CuentaBancaria p_cuenta)
    {
        /* En este caso el Arraylist, CuentasBancarias, si puede estar vacio */
        if(p_cuenta != null)
        {
            this.cuentasBancarias.remove(p_cuenta);
            return true;
        }
        return false;
    }

    /**
     * Imprime datos y sueldo de la lista de empleados
     */
    public void listarSueldos()
    {
        for(int i = 0; i < this.empleados.size(); i++)
        {
            Empleado empleado = this.empleados.get(i);
            System.out.println(empleado.getCuil() + empleado.getApellido() + ", " + empleado.getNombre() + " ----------------------------------------- $" + empleado.sueldoNeto());
        }
    }

    /**
     * Calcula el total de sueldos a pagar de cada empleado
     * 
     * @return El total de sueldos a pagar
     */
    public double sueldosAPagar()
    {
        double totalSueldos = 0;
        for(int i = 0; i < this.empleados.size(); i++)
        {
            Empleado empleado = this.empleados.get(i);
            totalSueldos += empleado.sueldoNeto();
        }
        return totalSueldos;
    }

    public void listarCuentasConSaldoCero()
    {
        System.out.println("Cuentas sin saldo:");
        System.out.println("--- Cuenta --------------------  Apellido y Nombre ---------------");
        for(int i = 0; i < this.cuentasBancarias.size(); i++)
        {
            CuentaBancaria cuenta = this.cuentasBancarias.get(i); // Reemplazar con get(i)
            if(cuenta.getSaldo() == 0)
            {
                // Tambien se pude hacer this.cuentasBancarias.get(i) en vez de crear la variable cuenta
                System.out.println(cuenta.getNroCuenta() + "                                " + cuenta.getTitular().getApellido() + ", " + cuenta.getTitular().getNombre());
            }
        }
    }

    /* Utilizar HashSet<Persona> para la siguiente funcion */
    public HashSet<Persona> listaDeTitulares()
    {
        HashSet<Persona> titulares = new HashSet<Persona>();
        for(int i = 0; i < this.cuentasBancarias.size(); i++)
        {
            CuentaBancaria cuenta = this.cuentasBancarias.get(i);
            titulares.add(cuenta.getTitular());
        }
        return titulares;
    }

    private int cuentasSaldoActivo()
    {
        int contador = 0;
        for(int i = 0; i < this.cuentasBancarias.size(); i++)
        {
            CuentaBancaria cuenta = this.cuentasBancarias.get(i);
            if(cuenta.getSaldo() > 0)
            {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Muestra los datos del banco, la lista de sueldos y el total a pagar
     */
    public void mostrar()
    {
        System.out.println("Banco: " + this.getNombre() + "  Sucursal: " + this.getNroSucursal());
        System.out.println("Localidad: " + this.getLocalidad().getNombre() + "  Provincia: " + this.getLocalidad().getProvincia());
        System.out.println("");
        this.listarSueldos();
        System.out.println("");
        System.out.println("Total a pagar:  ----------------------------------------- $" + this.sueldosAPagar());
    }

    public void mostrarResumen()
    {
        System.out.println("Banco: " + this.getNombre() + "  -  Sucursal: " + this.getNroSucursal());
        System.out.println("Localidad: " + this.getLocalidad().getNombre() + "       Provincia: " + this.getLocalidad().getProvincia());
        System.out.println("************************************************************");
        System.out.println("RESUMEN DE CUENTAS BANCARIAS");
        System.out.println("************************************************************");
        System.out.println("Número total de Cuentas Bancarias: " + this.getCuentas().size());
        System.out.println("Cuentas Activas:  " + this.cuentasSaldoActivo());
        System.out.println("Cuentas Saldo Cero: " + (this.getCuentas().size() - this.cuentasSaldoActivo()) + ".");
        System.out.println("-------------------------------------------------------------------------------------------");
        this.listarCuentasConSaldoCero();
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.print("Listado de Clientes: ");
        HashSet<Persona> titulares = this.listaDeTitulares();
        int contador = 0;
        for (Persona titular : titulares) {
            System.out.print(titular.getApellido() + ", " + titular.getNombre());
            contador++;
            if (contador < titulares.size()) {
                System.out.print("; ");
            }
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------- -------");
    }
}