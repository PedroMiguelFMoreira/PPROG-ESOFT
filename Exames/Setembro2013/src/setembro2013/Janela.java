package setembro2013;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Pedro
 */
public class Janela extends JFrame {

    private int[] numerosSorteados;
    private JTextField[] camposTexto;
    private JLabel[] legendasCamposTexto;

    public Janela() {
        super();

        this.numerosSorteados = Util.sorteio(1, 0, 49);
        add(new JPanel(new FlowLayout(FlowLayout.CENTER)).add(new JLabel("Totoloto")), BorderLayout.NORTH);

        legendasCamposTexto = new JLabel[7];
        camposTexto = new JTextField[7];
        for (int i = 1; i < 7; i++) {
            legendasCamposTexto[i] = new JLabel(String.valueOf(i));
            camposTexto[i] = new JTextField(14);
        }

        JPanel numeros = new JPanel(new GridLayout(6, 1));

        for (int i = 1; i < legendasCamposTexto.length; i++) {
            JPanel pnl = new JPanel();

            pnl.add(legendasCamposTexto[i]);
            pnl.add(camposTexto[i]);

            numeros.add(pnl);
        }

        add(numeros, BorderLayout.CENTER);

        JPanel pnl = new JPanel();
        pnl.add(criarBotaoJogar(), BorderLayout.SOUTH);
        pnl.add(criarBotaoLimpar(), BorderLayout.SOUTH);
        add(pnl);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private JButton criarBotaoJogar() {
        JButton btn = new JButton("Jogar");

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        Janela.this, "Texto", "Resultados",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        return btn;
    }

    private JButton criarBotaoLimpar() {
        JButton btn = new JButton("Limpar");

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        return btn;
    }

    public static void main(String[] args) {
        new Janela();
    }

}
