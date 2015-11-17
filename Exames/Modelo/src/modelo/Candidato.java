package modelo;

/**
 *
 * @author Pedro
 */
public class Candidato {

    private String nome;
    private int numVotos;

    public Candidato(String nome) {
        this.nome = nome;
        this.numVotos = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public int getNumVotos() {
        return this.numVotos;
    }

    public void incrementarVotos() {
        this.numVotos++;
    }

    public void inicializarNumVotos() {
        this.numVotos = 0;
    }

}
