package centrocomercial;

/**
 * Cria uma instância de uma loja, guardando um id, uma descrição, uma àrea, um
 * rendimento e um número de funcionários.
 *
 * @author Pedro
 */
public class LojaComumQuiosque extends LojaComum {

    /**
     * Valor usado no cálculo da renda de lojas da classe.
     */
    public static double valorRenda = 200;

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
    public LojaComumQuiosque(int id, String descr, int area, double receita, int nFuncionarios) {
        super(id, descr, area, receita, nFuncionarios);
    }

    /**
     * Constrói uma instância de Loja com o id -1, a descrição "Sem descrição",
     * a área -1, a receitaAnoAnt 0,0 e o número de funcionários a 0.
     */
    public LojaComumQuiosque() {
        super();
    }

    /**
     * Constrói uma instância de Loja com as mesmas caraterísticas da loja
     * recebida por parametro.
     *
     * @param outraLoja A loja com as caraterísticas a copiar.
     */
    public LojaComumQuiosque(LojaComumQuiosque outraLoja) {
        super(outraLoja);
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
        return String.format("%s.", super.toString());
    }

    /**
     * Calcula o valor da renda.
     *
     * @return Valor da renda.
     */
    @Override
    public double calcularRenda() {
        return LojaComumQuiosque.valorRenda;
    }

    /**
     * Devolve o valor usado no cálculo da renda de lojas da classe.
     *
     * @return Valor usado no cálculo da renda de lojas da classe.
     */
    public static double getValorRenda() {
        return LojaComumQuiosque.valorRenda;
    }

    /**
     * Modifica o valor usado no cálculo da renda de lojas da classe.
     *
     * @param valorRenda Novo valor a ser usado no cálculo da renda de lojas da
     * classe.
     */
    public static void setValorRenda(double valorRenda) {
        LojaComumQuiosque.valorRenda = valorRenda;
    }

}
