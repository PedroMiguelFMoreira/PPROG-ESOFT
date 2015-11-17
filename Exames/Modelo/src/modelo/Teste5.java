package modelo;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Pedro
 */
public class Teste5 extends JDialog {
    
    private JTextField candidato, data;

    public Teste5() {
        super();
        setLayout(new GridLayout(0, 1));
        
        JPanel pnl_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel pnl_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel pnl_3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        pnl_1.add(new JLabel("Candidato: "));
        this.candidato = new JTextField(40);
        pnl_1.add(this.candidato);
        pnl_2.add(new JLabel("Data do voto: "));
        this.data = new JTextField(40);
        pnl_2.add(this.data);
        JButton btn = new JButton("Votar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = String.format("Votou no candidato %s, na data %s", candidato.getText(), data.getText());
                JOptionPane.showMessageDialog(Teste5.this, texto, "Voto", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        add(pnl_1);
        add(pnl_2);
        add(pnl_3);
        add(btn);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        pack();
    }
    
    public static void main(String[] args) {
        new Teste5();
    }
    
}
