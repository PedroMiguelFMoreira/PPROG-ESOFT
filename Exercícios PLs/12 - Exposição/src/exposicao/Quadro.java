package exposicao;

public class Quadro implements Comparable<Quadro> {

    private String designacao;
    private String autor;
    private int anoCriacao;

    public Quadro(String designacao, String autor, int anoCriacao) {
        this.designacao = designacao;
        this.autor = autor;
        this.anoCriacao = anoCriacao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    @Override
    public String toString() {
        return String.format("%s, pintado por %s, no ano de %d.", this.designacao, this.autor, this.anoCriacao);
    }

    @Override
    public int compareTo(Quadro outroQuadro) {
        return this.autor.compareToIgnoreCase(outroQuadro.getAutor());
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
        Quadro outroQuadro = (Quadro) outroObjeto;

        return this.getDesignacao().equalsIgnoreCase(outroQuadro.getDesignacao())
                && this.getAutor().equalsIgnoreCase(outroQuadro.getAutor())
                && this.getAnoCriacao() == outroQuadro.getAnoCriacao();
    }
}
