package centrocomercial;

/**
 * Representa uma loja através de um id, uma descrição, uma área e o rendimento
 * do ano anterior.
 *
 * @author Pedro
 */
public class Loja {

    /**
     * ID da loja.
     */
    private int id;

    /**
     * Descrição da loja.
     */
    private String descricao;

    /**
     * Área da loja em metros quadrados.
     */
    private int area;

    /**
     * Receita anual da loja relativa ao ano anterior em Euros.
     */
    private double receita;

    /**
     * Valor fixo que auxilia no cálculo da renda de uma loja.
     */
    private static double rendaFixa = 500.0;

    /**
     * Id da loja por omissão.
     */
    private static final int ID_POR_OMISSAO = 0;

    /**
     * Descrição da loja por omissão.
     */
    private static final String DESCRICAO__POR_OMISSAO = "Sem descrição!";

    /**
     * Area da loja por omissão.
     */
    private static final int AREA_POR_OMISSAO = 0;

    /**
     * Receita anual da loja por omissão.
     */
    private static final double RECEITA_POR_OMISSAO = 0.0;

    /**
     * Possíveis classificações em relação à area da loja.
     */
    private static final String[] classificacao = {"Pequena", "Média", "Grande"};

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
     * receita.
     *
     * @param id ID da loja.
     * @param descricao Descrição da loja.
     * @param area Área da Loja em metros quadrados.
     * @param receita Receita da loja relativa ao ano anterior em Euros.
     */
    public Loja(int id, String descricao, int area, double receita) {
        this.id = id;
        this.descricao = descricao;
        this.area = area;
        this.receita = receita;
    }

    /**
     * Constrói uma instância de Loja com o id 0, a descrição "Sem descrição", a
     * área 0 e a receita 0.
     */
    public Loja() {
        this(Loja.ID_POR_OMISSAO, Loja.DESCRICAO__POR_OMISSAO, Loja.AREA_POR_OMISSAO, Loja.RECEITA_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de Loja com as mesmas caraterísticas da loja
     * recebida por parametro.
     *
     * @param outraLoja A loja com as caraterísticas a copiar.
     */
    public Loja(Loja outraLoja) {
        this(outraLoja.getId(), outraLoja.getDescricao(), outraLoja.getArea(), outraLoja.getReceita());
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
    public String getDescricao() {
        return this.descricao;
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
     * Devolve a receita da loja relativa ao ano anterior em Euros.
     *
     * @return Receita da loja relativa ao ano anterior em Euros.
     */
    public double getReceita() {
        return this.receita;
    }

    /**
     * Modifica o ID da loja.
     *
     * @param novoId O novo ID da loja.
     */
    public void setId(int novoId) {
        this.id = novoId;
    }

    /**
     * Modifica a descrição da loja.
     *
     * @param novaDescricao A nova descrição da loja.
     */
    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    /**
     * Modifica a área da loja em metros quadrados.
     *
     * @param novaArea A nova área da loja em metros quadrados.
     */
    public void setArea(int novaArea) {
        this.area = novaArea;
    }

    /**
     * Modifica a receita da loja relativa ao ano anterior em Euros.
     *
     * @param novaReceita A nova receita da loja relativa ao ano anterior em
     * Euros.
     */
    public void setReceita(double novaReceita) {
        this.receita = novaReceita;
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
        return String.format("A loja %d, é uma %s, com %d metros quadrados de espaço e rendeu no ano passado %.1f.", this.id, this.descricao, this.area, this.receita);
    }

    /**
     * Cálcula a renda que uma loja deve de pagar, tendo por base um valor comum
     * a todas elas, juntamente da area e receitas da mesma.
     *
     * @return Renda a pagar de uma dada loja.
     */
    public double calcularRenda() {
        return (rendaFixa * (1 + (this.area / 100.0))) + (this.receita / 100.0);
    }

    /**
     * Determina a classificação da loja, tendo por base a area da mesma.
     *
     * @return Classificação da loja.
     */
    public String determinarTamanho() {
        if (this.getArea() < limiteA) {
            return classificacao[0];
        } else if (this.getArea() <= limiteB) {
            return classificacao[1];
        } else {
            return classificacao[2];
        }
    }

    /**
     * Devolva a Renda fixa a ser paga por qualquer loja.
     *
     * @return Renda fixa a ser paga por qualquer loja.
     */
    public static double getRendaFixa() {
        return rendaFixa;
    }

    /**
     * Devolve o limite que separa as classificações Pequena e Média.
     *
     * @return Limite que separa as classificações Pequena e Média.
     */
    public static int getLimiteA() {
        return limiteA;
    }

    /**
     * Devolve o limite que separa as classificações Média e Grande.
     *
     * @return Limite que separa as classificações Média e Grande.
     */
    public static int getLimiteB() {
        return limiteB;
    }

    /**
     * Modifica o valor da renda fixa.
     *
     * @param novaRendaFixa O novo valor da renda fixa.
     */
    public static void setRendaFixa(double novaRendaFixa) {
        rendaFixa = novaRendaFixa;
    }

    /**
     * Modifica o limite que separa as classificações Pequena e Média.
     *
     * @param novoLimite O novo limite que separa as classificações Pequena e
     * Média.
     */
    public static void setLimiteA(int novoLimite) {
        limiteA = novoLimite;
    }

    /**
     * Devolve o limite que separa as classificações Média e Grande.
     *
     * @param novoLimite O novo limite que separa as classificações Média e
     * Grande.
     */
    public static void setLimiteB(int novoLimite) {
        limiteB = novoLimite;
    }

}
