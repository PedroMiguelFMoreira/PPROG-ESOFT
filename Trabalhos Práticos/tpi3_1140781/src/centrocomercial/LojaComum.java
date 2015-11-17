package centrocomercial;

/**
 * Representa um id, uma descrição, uma área o rendimento do ano anterior e o
 * número de funcionários de uma loja.
 *
 * @author Pedro
 */
public abstract class LojaComum extends Loja implements Renda {

    /**
     * Número de funcionários da loja.
     */
    private int nFuncionarios;

    /**
     * Número de instancia da loja.
     */
    private static int nLojas = 0;

    /**
     * Número de funcionários da loja por omissão.
     */
    private static final int NFUNCIONARIOS_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de Loja recebendo o id, a descrição, a area, a
     * receitaAnoAnt e o número de funcionários.
     *
     * @param id ID da loja.
     * @param descr Descrição da loja.
     * @param area �?rea da Loja em metros quadrados.
     * @param receita Receita da loja relativa ao ano anterior em Euros.
     * @param nFuncionarios Número de funcionários da loja.
     */
    public LojaComum(int id, String descr, int area, double receita, int nFuncionarios) {
        super(id, descr, area, receita);
        this.nFuncionarios = nFuncionarios;
        LojaComum.nLojas++;
    }

    /**
     * Constrói uma instância de Loja com o id -1, a descrição "Sem descrição",
     * a área -1, a receitaAnoAnt 0,0 e o número de funcionários a 0.
     */
    public LojaComum() {
        super();
        this.nFuncionarios = LojaComum.NFUNCIONARIOS_POR_OMISSAO;
        LojaComum.nLojas++;
    }

    /**
     * Constrói uma instância de Loja com as mesmas caraterísticas da loja
     * recebida por parametro.
     *
     * @param outraLoja A loja com as caraterísticas a copiar.
     */
    public LojaComum(LojaComum outraLoja) {
        super(outraLoja);
        this.nFuncionarios = outraLoja.getNFuncionarios();
        LojaComum.nLojas++;
    }

    /**
     * Devolve o número de funcionários da loja.
     *
     * @return Novo númerod de funcionários da loja.
     */
    public int getNFuncionarios() {
        return this.nFuncionarios;
    }

    /**
     * Modifica o número de funcionários da loja.
     *
     * @param nFuncionarios Novo número de funcionários da loja.
     */
    public void setNFuncionarios(int nFuncionarios) {
        this.nFuncionarios = nFuncionarios;
    }

    /**
     * Devolve as carateristicas da loja no formato:
     *
     * Ex: A loja x, é uma y, com z metros quadrados, rendeu no ano anterior w,
     * tem t funcionários.
     *
     * @return Carateristicas da loja.
     */
    @Override
    public String toString() {
        return String.format("%s, tem %d funcionários", super.toString(), this.nFuncionarios);
    }

    /**
     * Calcula o valor da renda.
     *
     * @return Valor da renda.
     */
    @Override
    public abstract double calcularRenda();

    /**
     * Devolve o número de instâncias da classe.
     *
     * @return Número de instâncias da classe.
     */
    public static int getNLojas() {
        return LojaComum.nLojas;
    }

}
