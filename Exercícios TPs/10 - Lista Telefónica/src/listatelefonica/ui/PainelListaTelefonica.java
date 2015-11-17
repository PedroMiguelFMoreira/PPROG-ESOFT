package listatelefonica.ui;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import listatelefonica.model.ListaTelefonica;

public class PainelListaTelefonica extends JPanel {

    private JTable tableListaTelefonica;

    public PainelListaTelefonica(ListaTelefonica listaTelefonica) {
        
        super(new BorderLayout());

        ModeloTabelaListaTelefonica modeloTabela = 
                new ModeloTabelaListaTelefonica(listaTelefonica);
        this.tableListaTelefonica = new JTable(modeloTabela);

        JPanel p = criarPainelListaTelefonica();

        add(p, BorderLayout.CENTER);

    }

    public JTable getTableListaTelefonica() {
        return tableListaTelefonica;
    }
    
    private JPanel criarPainelListaTelefonica() {

        tableListaTelefonica.setAutoCreateRowSorter(true);
                
        JScrollPane scrollPane = new JScrollPane(tableListaTelefonica);  

        JPanel p = new JPanel(new BorderLayout());
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(BorderFactory.createEmptyBorder( MARGEM_SUPERIOR, 
                                                     MARGEM_ESQUERDA,
                                                     MARGEM_INFERIOR, 
                                                     MARGEM_DIREITA));
        p.add(scrollPane, BorderLayout.CENTER);

        return p;
    }

}
