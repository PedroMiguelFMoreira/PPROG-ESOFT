package escola;

public class AlunoBolseiro extends Aluno implements Custo {

    private double valorBolsa;

    public AlunoBolseiro(String nome, int numero, double valorBolsa) {
        super(nome, numero);
        this.valorBolsa = valorBolsa;
    }

    public double getValorBolsa() {
        return this.valorBolsa;
    }

    public void setValorBolsa(double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    @Override
    public String toString() {
        return String.format("%s, recebe %.1f€ de bolsa.", super.toString(), this.valorBolsa);
    }
    
    @Override
    public double calcularCusto() {
        return this.valorBolsa;
    }

}
