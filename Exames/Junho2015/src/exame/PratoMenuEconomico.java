package exame;

/**
 *
 * @author Pedro
 */
public class PratoMenuEconomico extends PratoMenu implements Desconto {

    public PratoMenuEconomico(String designacao, float preco, ListaAlimentos listaAlimentos) {
        super(designacao, preco, listaAlimentos);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public float calcularPreco() {
        return super.calcularPreco() - calcularDesconto();
    }

    @Override
    public float calcularDesconto() {
        return super.getPreco() * Desconto.DESCONTO;
    }

}
