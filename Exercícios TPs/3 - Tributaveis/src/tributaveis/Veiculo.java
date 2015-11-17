package tributaveis;

public class Veiculo implements Cores, Tributavel {

    private String matricula;
    private int cilindrada;
    private String cor;

    private static int limiteEscalao = 1500;
    private static int escalao1 = 15;
    private static int escalao2 = 40;

    public Veiculo(String matricula, int cilindrada, String cor) {
        this.matricula = matricula;
        this.cilindrada = cilindrada;
        this.cor = cor;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public int getCilindrada() {
        return this.cilindrada;
    }

    public String getCor() {
        return this.cor;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return String.format("Veículo com matrícula %s e cilindrada %d tem cor %s", this.matricula, this.cilindrada, this.cor);
    }

    @Override
    public float calcularImposto() {
        return (this.getCilindrada() < Veiculo.limiteEscalao) ? Veiculo.escalao1 : Veiculo.escalao2;
    }

    public static int getLimiteEscalao() {
        return Veiculo.limiteEscalao;
    }

    public static int getEscalao1() {
        return Veiculo.escalao1;
    }

    public static int getEscalao2() {
        return Veiculo.escalao2;
    }

    public static void setLimiteEscalao(int limiteEscalao) {
        Veiculo.limiteEscalao = limiteEscalao;
    }

    public static void setEscalao1(int escalao1) {
        Veiculo.escalao1 = escalao1;
    }

    public static void setEscalao2(int escalao2) {
        Veiculo.escalao2 = escalao2;
    }

}
