package centrocomercial;

/**
 * Interface responsável por implementar o método de cálculo de renda
 *
 * @author Pedro
 */
public interface Renda {

    /**
     * Valor usado no cálculo da renda de algumas lojas.
     */
    double VALOR_RENDA = 500;

    /**
     * Método abstracto responsável por calcular o valor da renda.
     *
     * @return Valor da renda a pagar por uma loja.
     */
    double calcularRenda();

}
