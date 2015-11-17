package exame;

/**
 *
 * @author Pedro
 */
public class PratoMenu extends Prato {

    private String designacao;
    private float preco;
    
    public PratoMenu(String designacao, float preco, ListaAlimentos listaAlimentos) {
        super(listaAlimentos);
        setDesignacao(designacao);
        setPreco(preco);
    }

    public String getDesignacao() {
        return this.designacao;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public float calcularPreco() {
        return this.getPreco() * (1 + Prato.getIVA());
    }

}
