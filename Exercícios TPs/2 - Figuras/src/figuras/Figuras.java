package figuras;

public abstract class Figuras {

    private String cor;
    protected static final String COR_POR_OMISSAO = "Cinzento";

    public Figuras(String cor) {
        this.cor = cor;
    }

    public Figuras() {
        this(Figuras.COR_POR_OMISSAO);
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String novaCor) {
        this.cor = novaCor;
    }

    @Override
    public String toString() {
        return String.format("Cor: %s", this.cor);
    }

    public abstract double calcularArea();

}
