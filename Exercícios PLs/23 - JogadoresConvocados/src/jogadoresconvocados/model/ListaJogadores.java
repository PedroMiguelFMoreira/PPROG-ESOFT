package jogadoresconvocados.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaJogadores {

    private List<Jogador> listaJogadores;

    public ListaJogadores() {
        this.listaJogadores = new ArrayList<>();
    }
    
    public Jogador obterJogador(int indice) {
        return listaJogadores.get(indice);
    }

    public boolean adicionarJogador(Jogador jogador) {
        if (!this.listaJogadores.contains(jogador)) {
            return this.listaJogadores.add(jogador);
        }
        return false;
    }

    public boolean removerJogador(Jogador jogador) {
        return this.listaJogadores.remove(jogador);
    }

    public int tamanho() {
        return this.listaJogadores.size();
    }

    public int indiceDe(Jogador jogador) {
        return this.listaJogadores.indexOf(jogador);
    }
    
    public boolean contem(Jogador jogador){
        return this.listaJogadores.contains(jogador);
    }
    
    public void ordenarPorPosicao(){
        Collections.sort(this.listaJogadores);
    }
    
}
