package centrocomercial;

/**
 * Cria uma instância de uma loja, guardando um id, uma descrição, uma àrea, um
 * rendimento, um custo de segurança, um desconto e um número de funcionários.
 *
 * @author Pedro
 */
public class LojaAncoraExterna extends LojaAncora implements Renda {

    /**
     * Desconto na renda da loja.
     */
    private double desconto;

    /**
     * Número de funcionários da loja.
     */
    private int nFuncionarios;

    /**
     * Desconto na renda da loja por omissão.
     */
    private static double DESCONTO_POR_OMISSAO = 0.0;

    /**
     * Número de funcionários da loja por omissão.
     */
    private static int NFUNCIONARIOS_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de Loja recebendo o id, a descrição, a area,a
     * receitaAnoAnt, o custo de segurança, desconto da renda e número de
     * funcionários.
     *
     * @param id Id da loja.
     * @param descr Descrição da loja.
     * @param area Área da loja em metros quadrados.
     * @param receitaAnoAnt Receita da loja relativa ao ano anterior.
     * @param custoSeguranca Custo da segurança da loja.
     * @param desconto Desconto na renda da loja.
     * @param nFuncionarios Número de funcionários da loja.
     */
    public LojaAncoraExterna(int id, String descr, int area, double receitaAnoAnt, double custoSeguranca, double desconto, int nFuncionarios) {
        super(id, descr, area, receitaAnoAnt, custoSeguranca);
        this.desconto = desconto;
        this.nFuncionarios = nFuncionarios;
    }

    /**
     * Constrói uma instância de Loja com o id -1, a descrição "Sem descrição",
     * a área -1, a receitaAnoAnt 0.0, o custo de segurança 0, o desconto 0 e o
     * número de funcionários.
     */
    public LojaAncoraExterna() {
        super();
        this.desconto = LojaAncoraExterna.DESCONTO_POR_OMISSAO;
        this.nFuncionarios = LojaAncoraExterna.NFUNCIONARIOS_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de Loja com as mesmas caraterísticas da loja
     * recebida por parametro.
     *
     * @param outraLoja A loja com as caraterísticas a copiar.
     */
    public LojaAncoraExterna(LojaAncoraExterna outraLoja) {
        super(outraLoja);
        this.desconto = outraLoja.getDesconto();
        this.nFuncionarios = outraLoja.getNFuncionarios();
    }

    /**
     * Devolve o desconto na renda da loja.
     *
     * @return Desconto na renda da loja.
     */
    public double getDesconto() {
        return this.desconto;
    }

    /**
     * Devolve o número de funcionários da loja.
     *
     * @return Número de funcionários da loja.
     */
    public int getNFuncionarios() {
        return this.nFuncionarios;
    }

    /**
     * Modifica o desconto na renda da loja.
     *
     * @param desconto Novo desconto na renda da loja.
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
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
     * Ex: A loja x, é uma y, com z metros quadrados e rendeu no ano anterior w,
     * tem um custo de segurança de t, um desconto de u e v funcinários.
     *
     * @return Carateristicas da loja.
     */
    @Override
    public String toString() {
        return String.format("%s, um desconto de %.1f%% e %d funcionários.", super.toString(), this.desconto, this.nFuncionarios);
    }

    /**
     * Calcula o valor da renda a ser pago por uma loja
     *
     * @return Valor da renda.
     */
    @Override
    public double calcularRenda() {
        return (Renda.VALOR_RENDA * (1 + super.getArea() / 100.0) + (super.getReceitaAnoAnt() / 100)) * (1 - (this.desconto / 100));
    }

}
