package listatelefonica.ui;

import javax.swing.JTable;

public class Main {

    public static void main(String[] args) {
        
        ModeloTabelaListaTelefonica modeloTabela = new ModeloTabelaListaTelefonica();
        JTable tableListaTelefonica = new JTable(modeloTabela);
        
        new Janela(tableListaTelefonica);

    }

}
