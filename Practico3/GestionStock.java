
/**
 * Write a description of class GestionStock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestionStock
{
    public static void main(String[] args)
    {
        Laboratorio laboratorio = new Laboratorio("Colgate S.A", "Scalabrini  Ortiz 552", "54-11 -4239-8447");
        Producto newProduct = new Producto(01, "Perfumería", "Jabón Deluxe", 5.25, 20, 5, laboratorio);
        System.out.println(newProduct);
        System.out.println("Se agregan 500 de stock");
        newProduct.ajuste(500);
        newProduct.mostrar();
        System.out.println("Se eliminan 200 de stock");
        newProduct.ajuste(-200);
        newProduct.mostrar();
        System.out.println("Precio Lista");
        System.out.println(newProduct.precioLista());
        System.out.println("Precio contado");
        System.out.println(newProduct.precioContado());
    }
}