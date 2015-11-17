package junho2014;

/**
 *
 * @author Pedro
 */
public class Aplicacao extends Artigo {

    private String nomeProdutor;

    Aplicacao(String titulo, int anoLancamento, String nomeProdutor) {
        super(titulo, anoLancamento);
        this.nomeProdutor = nomeProdutor;
    }

    public String getNomeProdutor() {
        return this.nomeProdutor;
    }

    public void setNomeProdutor(String nomeProdutor) {
        this.nomeProdutor = nomeProdutor;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", super.toString(), getNomeProdutor());
    }

}
