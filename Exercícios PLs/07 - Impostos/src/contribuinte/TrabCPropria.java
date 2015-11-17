package contribuinte;

/**
 *
 * @author Pedro
 */
public class TrabCPropria extends Contribuinte {
    
    private String profissao;
    
    private static double taxaRT = 0.03;
    private static double taxaORa = 0.02;
    private static double taxaORb = 0.05;
    private static double limiteOR = 50000;
    
    public TrabCPropria(String nome, String morada, double rendimentosTrabalho, double outrosRendimentos, String profissao) {
        super(nome, morada, rendimentosTrabalho, outrosRendimentos);
        this.profissao = profissao;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    @Override
    public String toString() {
        return String.format("%s, exerce a profissão de %s.", super.toString(), this.profissao);
    }

    @Override
    protected double taxaRT() {
        return TrabCPropria.taxaRT;
    }

    @Override
    protected double taxaOR() {
        return getOutrosRendimentos() < TrabCPropria.limiteOR ? TrabCPropria.taxaORa : TrabCPropria.taxaORb;
    }
    

    public static double getTaxaRT() {
        return TrabCPropria.taxaRT;
    }

    public static double getTaxaORa() {
        return TrabCPropria.taxaORa;
    }

    public static double getTaxaORb() {
        return TrabCPropria.taxaORb;
    }

    public static double getLimiteOR() {
        return TrabCPropria.limiteOR;
    }

    public static void setTaxaRT(double aTaxaRT) {
        TrabCPropria.taxaRT = aTaxaRT;
    }

    public static void setTaxaORa(double aTaxaORa) {
        TrabCPropria.taxaORa = aTaxaORa;
    }

    public static void setTaxaORb(double aTaxaORb) {
        TrabCPropria.taxaORb = aTaxaORb;
    }

    public static void setLimiteOR(double aLimiteOR) {
        TrabCPropria.limiteOR = aLimiteOR;
    }
}