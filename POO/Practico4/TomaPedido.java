import java.util.*;

/**
 * Ejecutable de Pedido que simula la toma de un pedido 
 * 
 * @author Sistema de pedidos
 * @version 1.0
 */
public class TomaPedido
{
    public static void main(String[] args)
    {
        Cliente cliente1 = new Cliente(44563531, "Perez", "Juan", 0); // Instanciar un cliente
        System.out.println("Se crea el Cliente: " + cliente1.getApellido() + ", " + cliente1.getNombre() + " - DNI: " + cliente1.getNroDNI());

        // Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio p_lab)
        Producto producto1 = new Producto(1, "Alimentos", "Arroz", 250, null); // Instanciar un producto
        System.out.println("Se crea el Producto: " + producto1.getDescripcion() + " - Precio: $" + producto1.getCosto());

        Producto producto2 = new Producto(2, "Limpieza", "Detergente", 300, null); // Instanciar un producto
        System.out.println("Se crea el Producto: " + producto2.getDescripcion() + " - Precio: $" + producto2.getCosto());

        System.out.println("---------------------------------------------------------");
        System.out .println("Se inicia un nuevo pedido para el cliente " + cliente1.getApellido() + ", " + cliente1.getNombre());
        ArrayList productos = new ArrayList(); // Crear una lista de productos
        productos.add(producto1); // Agregar el primer producto a la lista
        productos.add(producto2); // Agregar el segundo producto a la lista
        Calendar fechaPedido = Calendar.getInstance(); // Obtener la fecha actual
        Pedido pedido1 = new Pedido(fechaPedido, cliente1, productos); // Crear un pedido con la lista de productos
        pedido1.mostrarPedido();
    }
}