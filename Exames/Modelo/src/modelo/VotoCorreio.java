package modelo;

/**
 *
 * @author Pedro
 */
public class VotoCorreio extends VotoPapel implements validaVotos {

    public VotoCorreio(Candidato candidato, int data, int dataLim, boolean boletimAssinado) {
        super(candidato, data, dataLim, boletimAssinado);
    }

    @Override
    public String toString() {
        return String.format("envio de %s", super.toString());
    }

    @Override
    public boolean eValido() {
        return super.eValido() && verificarData();
    }

    @Override
    public boolean verificarData() {
        return super.getData() < super.getDataLim();
    }

}
