package exame;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class Alimento implements Comparable<Alimento>, Serializable {

    private String designacao;
    private int calorias;

    public Alimento(String designacao, int calorias) {
        setDesignacao(designacao);
        setCalorias(calorias);
    }

    public String getDesignacao() {
        return this.designacao;
    }

    public int getCalorias() {
        return this.calorias;
    }

    public void setDesignacao(String designacao) {
        if (designacao.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.designacao = designacao;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return String.format("%s : %d", getDesignacao(), getCalorias());
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }

        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }

        Alimento outroAlimento = (Alimento) outroObjeto;

        return this.getDesignacao().equals(outroAlimento.getDesignacao());
    }

    @Override
    public int compareTo(Alimento alimento) {
        if (this.getCalorias() > alimento.getCalorias()) {
            return 1;
        } else if (this.getCalorias() < alimento.getCalorias()) {
            return -1;
        }

        return 0;
    }

}
