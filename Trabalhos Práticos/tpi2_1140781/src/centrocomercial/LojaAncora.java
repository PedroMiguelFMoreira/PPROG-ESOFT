package centrocomercial;

/**
 * Representa  um id, uma descrição, uma área o rendimento do ano anterior e o 
 * custo de segurança de uma loja.
 *
 * @author Pedro
 */
public abstract class LojaAncora extends Loja {

    /**
     * Custo de segurança.
     */
    private double custoSeguranca;

    /**
     * Contador que guarda o numéro de instâncias da classe.
     */
    private static int nLojas = 0;

    /**
     * Valor do custo de segurança por omissão.
     */
    private static final int CUSTOSEGURANCA_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de Loja recebendo o id, a descrição, a area,a
     * receitaAnoAnt e o custo de segurança.
     *
     * @param id Id da loja.
     * @param descr Descrição da loja.
     * @param area �?rea da loja em metros quadrados.
     * @param receitaAnoAnt Receita da loja relativa ao ano anterior.
     * @param custoSeguranca Custo da segurança da loja.
     */
    public LojaAncora(int id, String descr, int area, double receitaAnoAnt, double custoSeguranca) {
        super(id, descr, area, receitaAnoAnt);
        this.custoSeguranca = custoSeguranca;
        LojaAncora.nLojas++;
    }

    /**
     * Constrói uma instância de Loja com o id -1, a descrição "Sem descrição",
     * a área -1, a receitaAnoAnt 0,0 e o custo de segurança 0.
     */
    public LojaAncora() {
        super();
        this.custoSeguranca = LojaAncora.CUSTOSEGURANCA_POR_OMISSAO;
        LojaAncora.nLojas++;
    }

    /**
     * Constrói uma instância de Loja com as mesmas caraterísticas da loja
     * recebida por parametro.
     *
     * @param outraLoja A loja com as caraterísticas a copiar.
     */
    public LojaAncora(LojaAncora outraLoja) {
        super(outraLoja);
        this.custoSeguranca = outraLoja.getCustoSeguranca();
        LojaAncora.nLojas++;
    }

    /**
     * Devolve o custo de segurança da loja.
     *
     * @return Custo de segurança da loja.
     */
    public double getCustoSeguranca() {
        return this.custoSeguranca;
    }

    /**
     * Modifica o custo de segurança da loja.
     *
     * @param custoSeguranca Novo custo de segurança loja.
     */
    public void setCustoSeguranca(double custoSeguranca) {
        this.custoSeguranca = custoSeguranca;
    }

    /**
     * Devolve as carateristicas da loja no formato:
     *
     * Ex: A loja x, é uma y, com z metros quadrados e rendeu no ano anterior w,
     * tem um custo de segurança de t
     *
     * @return Carateristicas da loja.
     */
    @Override
    public String toString() {
        return String.format("%s, tem um custo de segurança de %.2f€", super.toString(), this.custoSeguranca);
    }

    /**
     * Devolve o número de instâncias da classe.
     *
     * @return Número de instâncias da classe.
     */
    public static int getNLojas() {
        return LojaAncora.nLojas;
    }

}
