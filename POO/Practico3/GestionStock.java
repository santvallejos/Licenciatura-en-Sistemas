
/**
 * Clase principal para probar la gestión de stock de productos farmacéuticos.
 * Demuestra la funcionalidad de las clases Laboratorio y Producto
 * mediante la creación de instancias y la realización de operaciones básicas.
 * 
 * @author Sistema de Gestión Farmacéutica
 */
public class GestionStock
{
    /**
     * Método principal que ejecuta ejemplos de gestión de stock.
     * Crea un laboratorio y un producto, realiza ajustes de stock
     * y muestra información sobre precios y disponibilidad.
     * 
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args)
    {
        /* Instanciar un Laboratorio */
        Laboratorio laboratorio = new Laboratorio("Colgate S.A", "Scalabrini  Ortiz 552", "54-11 -4239-8447");
        /* Instanciar un nuevo producto */
        Producto newProduct = new Producto(01, "Perfumería", "Jabón Deluxe", 5.25, 20, 5, laboratorio);

        /* Prueba */
        System.out.println(newProduct);
        System.out.println("Se agregan 500 de stock");
        newProduct.ajuste(500);
        newProduct.mostrar();
        System.out.println("Se eliminan 200 de stock");
        newProduct.ajuste(-200);
        newProduct.mostrar();

        /* Mostrar precios */
        System.out.println("------------- Precios del producto -------------");
        System.out.println("Precio Lista");
        System.out.println(newProduct.precioLista());
        System.out.println("Precio contado");
        System.out.println(newProduct.precioContado());
    }
}