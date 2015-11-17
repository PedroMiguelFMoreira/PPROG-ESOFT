package junho2013_1;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class Seccionista extends Pessoa implements Serializable, Vencimento {

    private static float vencimento = 500.0f;

    public Seccionista(String nome, String modalidade) {
        super(nome, modalidade);
    }

    public static float getVencimento() {
        return Seccionista.vencimento;
    }

    public static void setVencimento(float vencimento) {
        Seccionista.vencimento = vencimento;
    }

    @Override
    public float calcularVencimento() {
        return Seccionista.vencimento;
    }

}
