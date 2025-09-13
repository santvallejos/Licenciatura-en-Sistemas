import java.util.*;

/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido
{
    private Calendar fecha;
    private Cliente cliente;
    private ArrayList productos;

    /**
     * Constructor para pedido con muchos productos
     * 
     * @param fecha 
     * @param cliente
     * @param productos
     */
    Pedido(Calendar p_fecha, Cliente p_cliente, ArrayList p_productos)
    {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList());
        this.agregarProductos(p_productos);
    }

    /**
     * Contructor para pedido de un solo producto
     * 
     * @param fecha
     * @param cliente
     * @param productos
     */
    Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_producto)
    {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList());
        this.agregarProducto(p_producto);
    }

    private void setFecha(Calendar p_fecha)
    {
        this.fecha = p_fecha;
    }

    public Calendar getFecha()
    {
        return this.fecha;
    }

    private void setCliente(Cliente p_cliente)
    {
        this.cliente = p_cliente;
    }

    public Cliente getCliente()
    {
        return this.cliente;
    }

    private void setProductos(ArrayList p_productos)
    {
        this.productos = p_productos;
    }

    public ArrayList getProductos()
    {
        return this.productos;
    }

    /**
     * Agregar productos al array de productos, se valida de si un producto es == null
     * 
     * @param productos
     * @return Si se agregaron exitosamente o no
     */
    public boolean agregarProductos(ArrayList p_productos)
    {
        for (int i = 0; i < p_productos.size(); i++) {
            Producto prod = (Producto) p_productos.get(i);
            if (prod != null) {
                this.getProductos().add(prod);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Agregar un producto al array de productos
     * 
     * @param producto
     * @return Si se agrego exitosamente o no
     */
    public boolean agregarProducto(Producto p_producto)
    {
        if (p_producto != null) {
            return this.getProductos().add(p_producto);
        }
        return false;
    }

    /**
     * Eliminar un producto especifico del array
     * 
     * @param producto
     * @return Si se elimino exitosamente el producto
     */
    public boolean quitarProducto(Producto p_producto)
    {
        return this.getProductos().remove(p_producto);
    }

    /**
     * Recorre y calcula el total al contado de todos los productos del pedido
     * 
     * @return El valor total al contado del pedido
     */
    public double totalAlContado()
    {
        double total = 0;
        for(int i = 0 ; i < this.getProductos().size(); i++) {
            Producto prod = (Producto) this.getProductos().get(i);
            total += prod.getCosto();
        }
        return total;
    }

    /**
     * Recorre y calcula el total financiado de todos los productos del pedido
     * 
     * @return El valor total financiado del pedido
     */
    public double totalFinanciado()
    {
        double total = 0;
        for(int i = 0 ; i < this.getProductos().size(); i++) {
            Producto prod = (Producto) this.getProductos().get(i);
            total += prod.precioLista();
        }
        return total;
    }

    /**
     * Imprimir el pedido
     */
    public void mostrarPedido()
    {
        System.out.println("* ****** Detalle del pedido ****** Fecha: "+ getFecha() +  ".");
        System.out.println("   Producto        Precio Lista   Precio Contado ");
        System.out.println("---------------------------------------------------------");
        for(int i = 0; i < this.getProductos().size(); i++)
        {
            System.out.println(((Producto) this.getProductos().get(i)).getDescripcion() + "        " + ((Producto) this.getProductos().get(i)).precioLista() + "            " + ((Producto) this.getProductos().get(i)).getCosto());
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("***  Total ------ " + this.totalFinanciado()  + "            " + this.totalAlContado());
    }
}