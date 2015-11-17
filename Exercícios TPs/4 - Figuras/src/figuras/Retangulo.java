package figuras;

public class Retangulo extends Figura {

    private double comprimento;
    private double largura;
    protected static final int COMPRIMENTO_POR_OMISSAO = 2;
    protected static final int LARGURA_POR_OMISSAO = 1;

    public Retangulo(int comprimento, int largura, String cor) {
        super(cor);
        this.comprimento = comprimento;
        this.largura = largura;
    }
    
    public Retangulo(int comprimento, int largura) {
        super();
        this.comprimento = comprimento;
        this.largura = largura;
    }
    
    public Retangulo(String cor) {
        this(Retangulo.COMPRIMENTO_POR_OMISSAO, Retangulo.LARGURA_POR_OMISSAO, cor);
    }

    public Retangulo() {
        this(Retangulo.COMPRIMENTO_POR_OMISSAO, Retangulo.LARGURA_POR_OMISSAO, Figura.COR_POR_OMISSAO);
    }

    public double getComprimento() {
        return this.comprimento;
    }

    public double getLargura() {
        return this.largura;
    }


    public void setComprimento(double novoComprimento) {
        this.comprimento = novoComprimento;
    }

    public void setLargura(double novaLargura) {
        this.largura = novaLargura;
    }

    @Override
    public String toString() {
        return String.format("Comprimento: %f | Largura: %f | %s%n", this.comprimento, this.largura, super.toString());
    }
    
    public boolean equal(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        
        Retangulo r = (Retangulo) outroObjeto;
        return this.comprimento == r.getComprimento() && this.largura == r.getLargura();
    }

    @Override
    public double calcularArea() {
        return this.comprimento * this.largura;
    }
}
