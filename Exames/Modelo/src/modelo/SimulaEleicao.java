package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class SimulaEleicao {

    private List<Voto> votos;

    public SimulaEleicao() {
        this.votos = new ArrayList();
    }

    public void contarVotos() {
        for (Voto voto : this.votos) {
            if (voto.eValido()) {
                voto.getCandidato().incrementarVotos();
            }
        }
    }

}
