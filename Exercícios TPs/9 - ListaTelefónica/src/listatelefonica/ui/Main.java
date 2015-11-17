package listatelefonica.ui;

import listatelefonica.model.FicheiroListaTelefonica;
import listatelefonica.model.ListaTelefonica;

public class Main {

    public static void main(String[] args) {

        FicheiroListaTelefonica ficheiroListaTelefonica = new FicheiroListaTelefonica();

        ListaTelefonica listaTelefonica = ficheiroListaTelefonica.ler(
                FicheiroListaTelefonica.NOME);
        
        if (listaTelefonica == null) {
            listaTelefonica = new ListaTelefonica();
        }

        new Janela(listaTelefonica, ficheiroListaTelefonica);
        
    }

}
