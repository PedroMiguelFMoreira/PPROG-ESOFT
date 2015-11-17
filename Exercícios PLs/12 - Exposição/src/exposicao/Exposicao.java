package exposicao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exposicao implements Comparable<Exposicao> {

    private String designacao;
    private int anoRealizacao;
    private List<Quadro> listaQuadros;

    public Exposicao(String designacao, int anoRealizacao) {
        this.designacao = designacao;
        this.anoRealizacao = anoRealizacao;
        this.listaQuadros = new ArrayList<Quadro>();
    }

    public String getDesignacao() {
        return designacao;
    }

    public int getAnoRealizacao() {
        return anoRealizacao;
    }

    public List<Quadro> getListaQuadros() {
        return listaQuadros;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setAnoRealizacao(int anoRealizacao) {
        this.anoRealizacao = anoRealizacao;
    }

    public void setListaQuadros(List<Quadro> listaQuadros) {
        this.listaQuadros = listaQuadros;
    }

    @Override
    public String toString() {
        Collections.sort(this.listaQuadros);

        return String.format("%s, realizada no ano %d com os quadros %s", this.designacao, this.anoRealizacao, this.listaQuadros);
    }

    @Override
    public int compareTo(Exposicao outraExposicao) {
        if (this.getAnoRealizacao() < outraExposicao.getAnoRealizacao()) {
            return 1;
        } else if (this.getAnoRealizacao() > outraExposicao.getAnoRealizacao()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object outroObjeto) {
        // Posição de memória
        if (this == outroObjeto) {
            return true;
        }

        // Classe ou vazio
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }

        // Downcasting para comparar atributos
        Exposicao outraExposicao = (Exposicao) outroObjeto;

        return this.getDesignacao().equalsIgnoreCase(outraExposicao.getDesignacao())
                && this.getAnoRealizacao() == outraExposicao.getAnoRealizacao()
                && this.getListaQuadros().equals(outraExposicao.getListaQuadros());
    }

    public boolean adicionarQuadro(Quadro quadro) {
        return this.listaQuadros.add(quadro);
    }

    public boolean removarQuadro(Quadro quadro) {
        return this.listaQuadros.remove(quadro);
    }

}
