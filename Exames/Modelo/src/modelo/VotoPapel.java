package modelo;

/**
 *
 * @author Pedro
 */
public class VotoPapel extends Voto {

    private boolean boletimAssinado;

    public VotoPapel(Candidato candidato, int data, int dataLim, boolean boletimAssinado) {
        super(candidato, data, dataLim);
        this.boletimAssinado = boletimAssinado;
    }

    @Override
    public String toString() {
        return String.format("voto em papel para %s", super.toString());
    }

    public boolean getBoletimAssinado() {
        return this.boletimAssinado;
    }

    @Override
    public boolean eValido() {
        return getBoletimAssinado();
    }

}
