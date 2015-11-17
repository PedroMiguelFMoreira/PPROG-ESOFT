package contribuinte;

/**
 *
 * @author Pedro
 */
public abstract class Contribuinte {
    
    private String nome;
    private String morada;
    private double rendimentosTrabalho;
    private double outrosRendimentos;
    
    public Contribuinte(String nome, String morada, double rendimentosTrabalho, double outrosRendimentos) {
        this.nome = nome;
        this.morada = morada;
        this.rendimentosTrabalho = rendimentosTrabalho;
        this.outrosRendimentos = outrosRendimentos;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMorada() {
        return this.morada;
    }

    public double getRendimentosTrabalho() {
        return this.rendimentosTrabalho;
    }

    public double getOutrosRendimentos() {
        return this.outrosRendimentos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setRendimentosTrabalho(double rendimentosTrabalho) {
        this.rendimentosTrabalho = rendimentosTrabalho;
    }

    public void setOutrosRendimentos(double outrosRendimentos) {
        this.outrosRendimentos = outrosRendimentos;
    }
    
    @Override
    public String toString() {
        return String.format("%s, residente na %s, obteve %.1f€ de RT e %.1f de OR", this.nome, this.morada, this.rendimentosTrabalho, this.outrosRendimentos);
    }

    protected abstract double taxaRT();
    
    protected abstract double taxaOR();
    
    public double calcularImposto() {
        return this.rendimentosTrabalho * taxaRT() + this.outrosRendimentos * taxaOR();
    }
}
