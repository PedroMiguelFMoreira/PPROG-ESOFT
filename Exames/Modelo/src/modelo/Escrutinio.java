package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class Escrutinio {

    private List<Candidato> candidatos;
    private int numEleitores;
    private int numVot;
    private int data;

    private Escrutinio(List<Candidato> candidatos, int numEleitores, int data) {
        this.candidatos = candidatos;
        this.numEleitores = numEleitores;
        this.data = data;
    }

    public void calcularVotantes() {
        for (Candidato candidato : this.candidatos) {
            this.numVot += candidato.getNumVotos();
        }
    }

    public void inicializarVotosCandidatos() {
        for (Candidato candidato : this.candidatos) {
            candidato.inicializarNumVotos();
        }
    }

    public List<Candidato> vencedor() {
        int totalVotos = 0;
        List<Candidato> vencedores = new ArrayList();

        for (Candidato candidato : this.candidatos) {
            if (candidato.getNumVotos() == totalVotos) {
                vencedores.add(candidato);
            } else if (candidato.getNumVotos() > totalVotos) {
                vencedores.clear();
                vencedores.add(candidato);
                totalVotos = candidato.getNumVotos();
            }
        }

        return vencedores;
    }

}
