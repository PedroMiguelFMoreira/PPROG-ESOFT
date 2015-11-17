package escola;

public class Professor extends Pessoa implements Custo {

    private String categoria;
    private double vencimento;
    private static double vencimentoBase = 1500;
    private static final String[] categorias = {"Assistente", "Adjunto", "Coordenador"};
    private static final double majAdjunto = 0.2;
    private static final double majCoordenador = 0.5;

    public Professor(String nome, String categoria) {
        super(nome);
        this.categoria = categoria;
        this.vencimento = this.calcularVencimento(categoria);
    }

    public String getCategoria() {
        return this.categoria;
    }

    public double getVencimento() {
        return this.vencimento;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setVencimento(double vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public String toString() {
        return String.format("%s, é um professor %s e recebe %.1f€.", super.toString(), this.categoria, this.vencimento);
    }

    private double calcularVencimento(String categoria) {
        if (categoria.equalsIgnoreCase(Professor.categorias[2])) {
            return Professor.vencimentoBase + (Professor.vencimentoBase * Professor.majCoordenador);
        } else if (categoria.equalsIgnoreCase(Professor.categorias[1])) {
            return Professor.vencimentoBase + (Professor.vencimentoBase * Professor.majAdjunto);
        }

        return Professor.vencimentoBase;
    }

    @Override
    public double calcularCusto() {
        return this.vencimento;
    }

    public static double getVencimentoBase() {
        return Professor.vencimentoBase;
    }

    public static void setVencimentoBase(double vencimentoBase) {
        Professor.vencimentoBase = vencimentoBase;
    }

}
