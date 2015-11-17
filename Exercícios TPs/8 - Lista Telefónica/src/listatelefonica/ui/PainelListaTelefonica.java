package listatelefonica.ui;

import java.awt.*;
import javax.swing.*;

public class PainelListaTelefonica extends JPanel {

    private JTable tableListaTelefonica;

    public PainelListaTelefonica(JTable tableListaTelefonica) {
        super(new BorderLayout());

        this.tableListaTelefonica = tableListaTelefonica;

        JPanel p = criarPainelListaTelefonica();

        add(p, BorderLayout.CENTER);

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
