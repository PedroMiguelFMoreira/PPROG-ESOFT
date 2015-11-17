package junho2013_1;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public abstract class Atleta extends Pessoa implements Serializable {

    private int numero;

    public Atleta(String nome, String modalidade, int numero) {
        super(nome, modalidade);
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
