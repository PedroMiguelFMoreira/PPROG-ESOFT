package jogadoresconvocados.ui;

import jogadoresconvocados.model.ListaJogadores;

public class Main {

    public static void main(String[] args) {

        ListaJogadores listaCompleta = new ListaJogadores();
        ListaJogadores listaConvocados = new ListaJogadores();
        FicheiroListaJogadores ficheiroListaJogadores = new FicheiroListaJogadores();

        Janela janela = new Janela(listaCompleta, listaConvocados, ficheiroListaJogadores);
    }

}
