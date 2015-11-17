package centrocomercial;

/**
 * Cria uma instância de uma loja, guardando um id, uma descrição, uma àrea, um
 * rendimento e um custo de segurança.
 *
 * @author Pedro
 */
public class LojaAncoraPropria extends LojaAncora {

    /**
     * Número de instâncias da classe.
     */
    private static int nLojas = 0;

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
    public LojaAncoraPropria(int id, String descr, int area, double receitaAnoAnt, double custoSeguranca) {
        super(id, descr, area, receitaAnoAnt, custoSeguranca);
        LojaAncoraPropria.nLojas++;
    }

    /**
     * Constrói uma instância de Loja com o id -1, a descrição "Sem descrição",
     * a área -1, a receitaAnoAnt 0,0 e o custo de segurança 0.
     */
    public LojaAncoraPropria() {
        super();
        LojaAncoraPropria.nLojas++;
    }

    /**
     * Constrói uma instância de Loja com as mesmas caraterísticas da loja
     * recebida por parametro.
     *
     * @param outraLoja A loja com as caraterísticas a copiar.
     */
    public LojaAncoraPropria(LojaAncoraPropria outraLoja) {
        super(outraLoja);
        LojaAncoraPropria.nLojas++;
    }

    /**
     * Devolve as carateristicas da loja no formato:
     *
     * Ex: A loja x, é uma y, com z metros quadrados e rendeu no ano anterior w,
     * tem um custo de segurança de t.
     *
     * @return Carateristicas da loja.
     */
    @Override
    public String toString() {
        return String.format("%s.", super.toString());
    }

    /**
     * Devolve o número de instâncias da classe.
     *
     * @return Número de instâncias da classe.
     */
    public static int getNLojas() {
        return LojaAncoraPropria.nLojas;
    }

}
