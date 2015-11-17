package jogadoresconvocados.ui;

import jogadoresconvocados.model.Jogador;
import jogadoresconvocados.model.ListaJogadores;
import javax.swing.AbstractListModel;

public class ModeloListaJogadores extends AbstractListModel {

    private ListaJogadores listaJogadores;
    
    public ModeloListaJogadores(ListaJogadores listaJogadores) {
        this.listaJogadores = listaJogadores;
    }

    @Override
    public int getSize() {
        return this.listaJogadores.tamanho();
    }

    @Override
    public Object getElementAt(int indice) {
        return this.listaJogadores.obterJogador(indice);
    }
    
    public boolean addElement(Jogador jogador){
        boolean jogadorAdicionado = this.listaJogadores.adicionarJogador(jogador);
        if(jogadorAdicionado)
            fireIntervalAdded(jogador, this.getSize()-1, this.getSize()-1);
        return jogadorAdicionado;
    } 

    public boolean removeElement(Jogador jogador){
        int indice = this.listaJogadores.indiceDe(jogador);
        boolean jogadorRemovido = this.listaJogadores.removerJogador(jogador);
        if(jogadorRemovido)
            fireIntervalRemoved(jogador, indice, indice);
        return jogadorRemovido;
    }
    
    public boolean contains(Jogador jogador){
        return this.listaJogadores.contem(jogador);
    }
    
    public void sort(){
        this.listaJogadores.ordenarPorPosicao();
    }

}
