package centrocomercial;

/**
 * Representa um id, uma descrição, uma área e um rendimento do ano anterior de
 * uma loja.
 *
 * @author Pedro
 */
public abstract class Loja {

    /**
     * ID da loja.
     */
    private int id;

    /**
     * Descrição da loja.
     */
    private String descr;

    /**
     * �?rea da loja em metros quadrados.
     */
    private int area;

    /**
     * Receita anual da loja relativa ao ano anterior em Euros.
     */
    private double receitaAnoAnt;

    /**
     * Id da loja por omissão.
     */
    private static final int ID_POR_OMISSAO = -1;

    /**
     * Descrição da loja por omissão.
     */
    private static final String DESCRICAO_POR_OMISSAO = "Sem descrição";

    /**
     * Area da loja por omissão.
     */
    private static final int AREA_POR_OMISSAO = -1;

    /**
     * Receita anual da loja por omissão.
     */
    private static final double RECEITA_POR_OMISSAO = 0.0;

    /**
     * Possíveis classificações em relação à area da loja.
     */
    private static final String[] classificacao = {"Não foi possivel determinar a área", "Pequena", "Média", "Grande"};

    /**
     * Limite que separa as classificações Pequena e Média.
     */
    private static int limiteA = 20;

    /**
     * Limite que separa as classificações Média e Grande.
     */
    private static int limiteB = 100;

    /**
     * Constrói uma instância de Loja recebendo o id, a descrição, a area e a
     * receitaAnoAnt.
     *
     * @param id ID da loja.
     * @param descr Descrição da loja.
     * @param area �?rea da Loja em metros quadrados.
     * @param receitaAnoAnt Receita da loja relativa ao ano anterior em Euros.
     */
    public Loja(int id, String descr, int area, double receitaAnoAnt) {
        this.id = id;
        this.descr = descr;
        this.area = area;
        this.receitaAnoAnt = receitaAnoAnt;
    }

    /**
     * Constrói uma instância de Loja com o id -1, a descrição "Sem descrição",
     * a área -1 e a receitaAnoAnt 0,0.
     */
    public Loja() {
        this(Loja.ID_POR_OMISSAO, Loja.DESCRICAO_POR_OMISSAO, Loja.AREA_POR_OMISSAO, Loja.RECEITA_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de Loja com as mesmas caraterísticas da loja
     * recebida por parametro.
     *
     * @param outraLoja A loja com as caraterísticas a copiar.
     */
    public Loja(Loja outraLoja) {
        this(outraLoja.getId(), outraLoja.getDescr(), outraLoja.getArea(), outraLoja.getReceitaAnoAnt());
    }

    /**
     * Devolve o ID da loja.
     *
     * @return ID da loja.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Devolve a descrição da loja.
     *
     * @return Descrição da loja.
     */
    public String getDescr() {
        return this.descr;
    }

    /**
     * Devolve a área da loja em metros quadrados.
     *
     * @return Área da loja em metros quadrados.
     */
    public int getArea() {
        return this.area;
    }

    /**
     * Devolve a receitaAnoAnt da loja relativa ao ano anterior em Euros.
     *
     * @return Receita da loja relativa ao ano anterior em Euros.
     */
    public double getReceitaAnoAnt() {
        return this.receitaAnoAnt;
    }

    /**
     * Modifica o ID da loja.
     *
     * @param id O novo ID da loja.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Modifica a descrição da loja.
     *
     * @param descr A nova descrição da loja.
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * Modifica a área da loja em metros quadrados.
     *
     * @param area A nova área da loja em metros quadrados.
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * Modifica a receitaAnoAnt da loja relativa ao ano anterior em Euros.
     *
     * @param receitaAnoAnt A nova receitaAnoAnt da loja relativa ao ano
     * anterior em Euros.
     */
    public void setReceitaAnoAnt(double receitaAnoAnt) {
        this.receitaAnoAnt = receitaAnoAnt;
    }

    /**
     * Devolve as carateristicas da loja no formato:
     *
     * Ex: A loja x, é uma y, com z metros quadrados e rendeu no ano anterior w.
     *
     * @return Carateristicas da loja.
     */
    @Override
    public String toString() {
        return String.format("A loja %d, é uma loja %s, com %d metros quadrados de espaço e rendeu no ano passado %.2f€", this.id, this.descr, this.area, this.receitaAnoAnt);
    }

    /**
     * Determina a classificação da loja, tendo por base a area da mesma.
     *
     * @return Classificação da loja.
     */
    public String classificarLoja() {
        if (this.area <= 0) {
            return classificacao[0];
        } else if (this.area < limiteA) {
            return classificacao[1];
        } else if (this.area <= limiteB) {
            return classificacao[2];
        } else {
            return classificacao[3];
        }
    }

    /**
     * Devolve o limite que separa as classificações Pequena e Média.
     *
     * @return Limite que separa as classificações Pequena e Média.
     */
    public static int getLimiteA() {
        return Loja.limiteA;
    }

    /**
     * Devolve o limite que separa as classificações Média e Grande.
     *
     * @return Limite que separa as classificações Média e Grande.
     */
    public static int getLimiteB() {
        return Loja.limiteB;
    }

    /**
     * Modifica o limite que separa as classificações Pequena e Média.
     *
     * @param novoLimite O novo limite que separa as classificações Pequena e
     * Média.
     */
    public static void setLimiteA(int novoLimite) {
        Loja.limiteA = novoLimite;
    }

    /**
     * Modifica o limite que separa as classificações Média e Grande.
     *
     * @param novoLimite O novo limite que separa as classificações Média e
     * Grande.
     */
    public static void setLimiteB(int novoLimite) {
        Loja.limiteB = novoLimite;
    }

}
