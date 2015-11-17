package junho2014;

/**
 *
 * @author Pedro
 */
public class Cliente {

    private String nome;
    private int pontos;

    public Cliente(String nome) {
        this.nome = nome;
        this.pontos = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPontos() {
        return this.pontos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return String.format("%s: %d", getNome(), getPontos());
    }

    @Override
    public boolean equals(Object outroObjeto) {
        return this.getNome().equals(((Cliente) outroObjeto).getNome());
    }

    public void acumularPontos(int pontos) {
        if (pontos < 0) {
            throw new IllegalArgumentException();
        }

        this.pontos += pontos;
    }

    public void descontarPontos(int pontos) {
        if (pontos < 0 || pontos > this.pontos) {
            throw new IllegalArgumentException();
        }

        this.pontos -= pontos;
    }

}
