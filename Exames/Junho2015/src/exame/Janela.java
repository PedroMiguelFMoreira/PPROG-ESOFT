package exame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Pedro
 */
public class Janela extends JFrame {
    
    private JTextField caixaTexto;
    private int alimentoAtual;
    private List<Alimento> listaAlimentos;

    public Janela() {
        this.listaAlimentos = new ArrayList();
        this.listaAlimentos.add(new Alimento("Ervilha", 12));
        this.listaAlimentos.add(new Alimento("Melão", 40));
        this.listaAlimentos.add(new Alimento("Hugo Miranda", 100));
        this.alimentoAtual = 0;
        
        add(criarPainelCentro(), BorderLayout.NORTH);
        add(criarPainelSul(), BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private JPanel criarPainelCentro() {
        JPanel pnl = new JPanel(new FlowLayout(FlowLayout.LEADING));

        pnl.add(new JLabel("Designação:"));
        this.caixaTexto = new JTextField(this.listaAlimentos.get(this.alimentoAtual).getDesignacao());
        pnl.add(this.caixaTexto);

        return pnl;
    }

    private JPanel criarPainelSul() {
        JPanel pnl = new JPanel(new BorderLayout());

        pnl.add(criarPainelBotoes(), BorderLayout.EAST);

        return pnl;
    }

    private JPanel criarPainelBotoes() {
        JPanel pnl = new JPanel();

        pnl.add(criarBotaoAnterior());
        pnl.add(criarBotaoSeguinte());

        return pnl;
    }

    private JButton criarBotaoAnterior() {
        JButton btn = new JButton("Anterior");

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(--alimentoAtual< 0) {
                    alimentoAtual = listaAlimentos.size() - 1;
                }
                
                caixaTexto.setText(listaAlimentos.get(alimentoAtual).getDesignacao());
                revalidate();
            }
        });
        
        return btn;
    }

    private JButton criarBotaoSeguinte() {
        JButton btn = new JButton("Seguinte");
        
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {                
                if(++alimentoAtual == listaAlimentos.size()) {
                    alimentoAtual = 0;
                }
                
                caixaTexto.setText(listaAlimentos.get(alimentoAtual).getDesignacao());
                revalidate();
            }
        });

        return btn;
    }

    public static void main(String[] args) {
        new Janela();
    }

}
