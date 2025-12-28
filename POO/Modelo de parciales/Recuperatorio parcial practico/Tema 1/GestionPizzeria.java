import java.util.*;
public class GestionPizzeria
{
    public static void main(String[] args)
    {
        // Crear ingredientes
        Ingrediente queso = new Ingrediente("Queso", 50);
        Ingrediente tomate = new Ingrediente("Tomate", 30);
        Ingrediente jamon = new Ingrediente("Jamón", 70);
        Ingrediente aceitunas = new Ingrediente("Aceitunas", 40);

        // Crear pizzas
        ArrayList<Ingrediente> ingredientesMuzzarella = new ArrayList<>();
        ingredientesMuzzarella.add(queso);
        ingredientesMuzzarella.add(tomate);
        Pizza muzzarella = new PizzaSimple("Muzzarella", ingredientesMuzzarella);

        ArrayList<Ingrediente> ingredientesJamon = new ArrayList<>();
        ingredientesJamon.add(queso);
        ingredientesJamon.add(tomate);
        ingredientesJamon.add(jamon);
        Pizza jamonPizza = new PizzaSimple("Jamón", ingredientesJamon);

        ArrayList<Ingrediente> ingredientesJamonConAceitunas = new ArrayList<>();
        ingredientesJamonConAceitunas.add(queso);
        ingredientesJamonConAceitunas.add(tomate);
        ingredientesJamonConAceitunas.add(jamon);
        ingredientesJamonConAceitunas.add(aceitunas);
        Pizza jamonConAceitunasPizza = new PizzaPersonalizada("Jamón con Aceitunas",ingredientesJamonConAceitunas);

        // Crear stock inicial
        HashMap<Ingrediente, Integer> stockInicial = new HashMap<>();
        stockInicial.put(queso, 10);
        stockInicial.put(tomate, 10);
        stockInicial.put(jamon, 5);

        // Crear fábrica
        ArrayList<Pizza> pizzasDisponibles = new ArrayList<>();
        pizzasDisponibles.add(muzzarella);
        pizzasDisponibles.add(jamonPizza);
        pizzasDisponibles.add(jamonConAceitunasPizza);
        Fabrica fabrica = new Fabrica(pizzasDisponibles, stockInicial);

        // Mostrar lista de precios y stock
        fabrica.listaDePrecios();
        System.out.println();
        fabrica.mostrarStock();

        // Reponer ingrediente
        fabrica.reponerIngrediente(jamon, 10);
        fabrica.mostrarStock();

        fabrica.venderPizza("Muzzarella");
        fabrica.mostrarStock();

        fabrica.venderPizza("Jamón con Aceitunas");
        fabrica.mostrarStock();
        System.out.println("Ventas totales: " + fabrica.getVentasTotales());
    }
}
