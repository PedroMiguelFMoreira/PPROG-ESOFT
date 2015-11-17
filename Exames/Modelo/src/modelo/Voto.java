package modelo;

/**
 *
 * @author Pedro
 */
public abstract class Voto {

    private Candidato candidato;
    private int data;
    private int dataLim;

    public Voto(Candidato candidato, int data, int dataLim) {
        this.candidato = candidato;
        this.data = data;
        this.dataLim = dataLim;
    }

    public Candidato getCandidato() {
        return this.candidato;
    }

    public int getData() {
        return this.data;
    }

    public int getDataLim() {
        return this.dataLim;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s",
                getCandidato().getNome(), eValido() ? "válido" : "inválido");
    }

    public abstract boolean eValido();

}
