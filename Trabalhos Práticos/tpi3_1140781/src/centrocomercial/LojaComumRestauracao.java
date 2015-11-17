package centrocomercial;

/**
 * Cria uma instância de uma loja, guardando um id, uma descrição, uma àrea, um
 * rendimento, um número de funcionários e um custo de manutenção.
 *
 * @author Pedro
 */
public class LojaComumRestauracao extends LojaComum implements Seguranca {

    /**
     * Custo de manutenção da loja.
     */
    private double custoManutencao;

    /**
     * Número de mesas da loja.
     */
    private int nMesas;

    /**
     * Valor pago por mesa, relativamente ao custo de segurança.
     */
    private static double valorMesa = 20;

    /**
     * Custo de manutenção da loja por omissão.
     */
    private static final double CUSTOMANUTENCAO_POR_DEFEITO = 0;

    /**
     * Número de mesas da loja por omissão.
     */
    private static final int NMESAS_POR_DEFEITO = 0;

    /**
     * Constrói uma instância de Loja recebendo o id, a descrição, a area, a
     * receitaAnoAnt e o número de funcionários.
     *
     * @param id ID da loja.
     * @param descr Descrição da loja.
     * @param area �?rea da Loja em metros quadrados.
     * @param receitaAnoAnt Receita da loja relativa ao ano anterior em Euros.
     * @param nFuncionarios Número de funcionários da loja.
     * @param custoManutencao Custo de manutenção da loja.
     * @param nMesas Número de mesas da loja.
     */
    public LojaComumRestauracao(int id, String descr, int area, double receitaAnoAnt, int nFuncionarios, int custoManutencao, int nMesas) {
        super(id, descr, area, receitaAnoAnt, nFuncionarios);
        this.custoManutencao = custoManutencao;
        this.nMesas = nMesas;
    }

    /**
     * Constrói uma instância de Loja com o id -1, a descrição "Sem descrição",
     * a área -1, a receitaAnoAnt 0.0, o custo de manutenção a 0 e o número de
     * mesas 0.
     */
    public LojaComumRestauracao() {
        super();
        this.custoManutencao = CUSTOMANUTENCAO_POR_DEFEITO;
        this.nMesas = NMESAS_POR_DEFEITO;
    }

    /**
     * Constrói uma instância de Loja com as mesmas caraterísticas da loja
     * recebida por parametro.
     *
     * @param outraLoja A loja com as caraterísticas a copiar.
     */
    public LojaComumRestauracao(LojaComumRestauracao outraLoja) {
        super(outraLoja);
        this.custoManutencao = outraLoja.getCustoManutencao();
        this.nMesas = outraLoja.getNMesas();
    }

    /**
     * Devolve o custo de manutenção da loja.
     *
     * @return Custo de manutenção da loja.
     */
    public double getCustoManutencao() {
        return this.custoManutencao;
    }

    /**
     * Devolve o número de mesas da loja.
     *
     * @return Número de mesas da loja.
     */
    public int getNMesas() {
        return this.nMesas;
    }

    /**
     * Modifica o custo de manutenção da loja.
     *
     * @param custoManutencao Novo custo de manutenção da loja.
     */
    public void setCustoManutencao(double custoManutencao) {
        this.custoManutencao = custoManutencao;
    }

    /**
     * Modifica o número de mesas da loja.
     *
     * @param nMesas Novo número de mesas da loja.
     */
    public void setNMesas(int nMesas) {
        this.nMesas = nMesas;
    }

    /**
     * Devolve as carateristicas da loja no formato:
     *
     * Ex: A loja x, é uma y, com z metros quadrados e rendeu no ano anterior w,
     * tem t funcionários, um custo de manutenção de u€ e v mesas.
     *
     * @return Carateristicas da loja.
     */
    @Override
    public String toString() {
        return String.format("%s, um custo de manutenção de %.2f€ e %d mesas.", super.toString(), this.custoManutencao, this.nMesas);
    }

    /**
     * Calcula o valor da renda a ser pago pela loja.
     *
     * @return Valor da renda.
     */
    @Override
    public double calcularRenda() {
        return (Renda.VALOR_RENDA * (1 + super.getArea() / 100.0) + (super.getReceitaAnoAnt() / 100));
    }

    /**
     * Calcula o valor do custo de segurança a ser pago pela loja.
     *
     * @return Valor do custo de segurança.
     */
    @Override
    public double calcularSeguranca() {
        return this.nMesas * LojaComumRestauracao.valorMesa;
    }

    /**
     * Devolve o valor por mesa da loja.
     *
     * @return Valor por mesa da loja.
     */
    public static double getValorMesa() {
        return LojaComumRestauracao.valorMesa;
    }

    /**
     * Modifica o valor por mesa da loja.
     *
     * @param valorMesa Novo valor por mesa da loja.
     */
    public static void setValorMesa(double valorMesa) {
        LojaComumRestauracao.valorMesa = valorMesa;
    }

}
