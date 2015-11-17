package junho2014;

/**
 *
 * @author Pedro
 */
public abstract class Artigo {

    private String titulo;
    private int anoLancamento;

    public Artigo(String titulo, int anoLancamento) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return String.format("%s, %d ", getTitulo(), getAnoLancamento());
    }

}
