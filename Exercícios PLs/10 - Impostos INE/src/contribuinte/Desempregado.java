package contribuinte;

/**
 *
 * @author Pedro
 */
public class Desempregado extends Contribuinte {

    private int mesesParagem;

    private static double taxaRT = 0;
    private static double taxaOR = 0.02;

    public Desempregado(String nome, String morada, double outrosRendimentos, int mesesParagem) {
        super(nome, morada, 0, outrosRendimentos);
        this.mesesParagem = mesesParagem;
    }

    public int getMesesParagem() {
        return this.mesesParagem;
    }

    public void setMesesParagem(int mesesParagem) {
        this.mesesParagem = mesesParagem;
    }

    @Override
    public String toString() {
        return String.format("%s, está parado à %d", super.toString(), this.mesesParagem);
    }

    @Override
    protected double taxaRT() {
        return Desempregado.taxaRT;
    }

    @Override
    protected double taxaOR() {
        return Desempregado.taxaOR;
    }

    public static double getTaxaRT() {
        return Desempregado.taxaRT;
    }

    public static double getTaxaOR() {
        return Desempregado.taxaOR;
    }

    public static void setTaxaRT(double TaxaRT) {
        Desempregado.taxaRT = TaxaRT;
    }

    public static void setTaxaOR(double TaxaOR) {
        Desempregado.taxaOR = TaxaOR;
    }

}
