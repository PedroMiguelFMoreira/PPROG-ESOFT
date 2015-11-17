package junho2013_1;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public abstract class Pessoa implements Serializable {

    private String nome;
    private String modalidade;

    public Pessoa(String nome, String modalidade) {
        this.nome = nome;
        this.modalidade = modalidade;
    }

    public String getNome() {
        return this.nome;
    }

    public String getModalidade() {
        return this.modalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

}
