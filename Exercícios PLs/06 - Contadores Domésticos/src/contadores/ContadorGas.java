package contadores;

public class ContadorGas extends Contador {

    private static double custo = 0.8;
    private static int numContGas = 1;
    private static final String ID = "GAZ-";

    public ContadorGas(String cliente, int consumo) {
        super(ContadorGas.ID + (ContadorGas.numContGas + 1), cliente, consumo);
        ContadorGas.numContGas++;
    }

    @Override
    public String toString() {
        return String.format("%s Consumo Gás: %d", super.toString(), super.getConsumo());
    }

    @Override
    public double calcularCusto() {
        return ContadorGas.custo * super.getConsumo();
    }

    public static double getCustoUnitario() {
        return ContadorGas.custo;
    }

    public static int getNumContador() {
        return ContadorGas.numContGas;
    }

    public static void setCustoUnitario(double custoUnitario) {
        ContadorGas.custo = custoUnitario;
    }

}
