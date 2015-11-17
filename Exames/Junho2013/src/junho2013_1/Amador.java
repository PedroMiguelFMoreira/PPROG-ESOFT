package junho2013_1;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class Amador extends Atleta implements Serializable {

    private String profissao;

    public Amador(String nome, String modalidade, int numero, String profissao) {
        super(nome, modalidade, numero);
        this.profissao = profissao;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

}
