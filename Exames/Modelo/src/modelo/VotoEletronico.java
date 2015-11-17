package modelo;

/**
 *
 * @author Pedro
 */
public class VotoEletronico extends Voto implements validaVotos {

    public VotoEletronico(Candidato candidato, int data, int dataLim) {
        super(candidato, data, dataLim);
    }
    
    public String toString() {
        return String.format("voto eletrónico para %s", super.toString());
    }

    @Override
    public boolean eValido() {
        return verificarData();
    }

    @Override
    public boolean verificarData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
