package junho2013_1;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class Profissional extends Atleta implements Serializable, Vencimento {

    private Desempenho desempenho;
    private static float vencimento = 500.0f;

    public Profissional(String nome, String modalidade, int numero, Desempenho desempenho) {
        super(nome, modalidade, numero);
        this.desempenho = desempenho;
    }

    @Override
    public float calcularVencimento() {
        if (this.desempenho.equals(Desempenho.ALTO)) {
            return (float) (Profissional.vencimento * (1 + 0.5));
        } else if (this.desempenho.equals(Desempenho.RAZOAVEL)) {
            return (float) (Profissional.vencimento * (1 + 0.1));
        }

        return Profissional.vencimento;
    }

}
