package contribuinte;

/**
 *
 * @author Pedro
 */
public class Reformado extends Contribuinte {

    private static double TaxaRT = 0.01;
    private static double TaxaOR = 0.03;

    public Reformado(String nome, String morada, double rendimentosTrabalho, double outrosRendimentos) {
        super(nome, morada, rendimentosTrabalho, outrosRendimentos);
    }

    @Override
    public String toString() {
        return String.format("%s.", super.toString());
    }

    public static double getTaxaRT() {
        return Reformado.TaxaRT;
    }

    public static double getTaxaOR() {
        return Reformado.TaxaOR;
    }

    public static void setTaxaRT(double aTaxaRT) {
        Reformado.TaxaRT = aTaxaRT;
    }

    public static void setTaxaOR(double aTaxaOR) {
        Reformado.TaxaOR = aTaxaOR;
    }

    @Override
    protected double taxaRT() {
        return getTaxaRT();
    }

    @Override
    protected double taxaOR() {
        return getTaxaOR();
    }

}
