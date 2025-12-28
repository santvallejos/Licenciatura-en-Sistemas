
public class Comercio {
    public static void main(String[] args) {

        Heladera heladera = new Heladera("Samsung", 150000, 10, 6, 3, true);
        Lavarropas lavarropas = new Lavarropas("LG", 120000, 5, 10, 7.5f, false);
        Cocina cocina = new Cocina("LG", 80000, 8, 4, 5000, "80x60x60");

        int cuotasH = 12;
        float interesH = 5;

        float valorCuotaHeladera = heladera.cuotaCredito(cuotasH, interesH);
        float valorCuotaConAdicionalesH = heladera.creditoConAdicional(cuotasH, interesH);

        heladera.imprimir();
        System.out.println("Cuotas: " + cuotasH + " - " + "Interes: " + interesH + "%");
        System.out.println("Valor Cuota: " + valorCuotaHeladera);
        System.out.println("Valor Cuota con Adicionales: " + valorCuotaConAdicionalesH);

        int cuotasL = 12;
        float interesL = 8;

        float valorCuotaLavarropas = lavarropas.cuotaCredito(cuotasL, interesL);
        float valorCuotaConAdicionalesL = lavarropas.creditoConAdicional(cuotasL, interesL);

        lavarropas.imprimir();
        System.out.println("Cuotas: " + cuotasL + " - " + "Interes: " + interesL + "%");
        System.out.println("Valor Cuota: " + valorCuotaLavarropas);
        System.out.println("Valor Cuota con Adicionales: " + valorCuotaConAdicionalesL);

        int cuotasC = 24;
        float interesC = 16;

        float valorCuotaCocina = cocina.cuotaCredito(cuotasC, interesC);
        float valorCuotaConAdicionalesC = cocina.creditoConAdicional(cuotasC, interesC);

        cocina.imprimir();
        System.out.println("Cuotas: " + cuotasC + " - " + "Interes: " + interesC + "%");
        System.out.println("Valor Cuota: " + valorCuotaCocina);
        System.out.println("Valor Cuota con Adicionales: " + valorCuotaConAdicionalesC);

    }
}
