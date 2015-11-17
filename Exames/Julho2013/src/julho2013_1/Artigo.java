package julho2013_1;

/**
 *
 * @author Pedro
 */
public abstract class Artigo {

    private String titulo;
    private String autorOuInterprete;
    private int anoLancamento;

    public Artigo(String titulo, String autorOuInterprete, int anoLancamento) {
        this.titulo = titulo;
        this.autorOuInterprete = autorOuInterprete;
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutorOuInterprete() {
        return this.autorOuInterprete;
    }

    public int getAnoLancamento() {
        return this.anoLancamento;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutorOuInterprete(String autorOuInterprete) {
        this.autorOuInterprete = autorOuInterprete;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return String.format("%s - %s, %d", getTitulo(), getAutorOuInterprete(), getAnoLancamento());
    }

}
