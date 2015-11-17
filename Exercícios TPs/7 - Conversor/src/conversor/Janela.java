package conversor;

// import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private JTextField txtCentigrados, txtFarenheit;
    private JButton btnConverter, btnLimpar, btnSair;
    private TrataEvento trataEvento;

    public Janela() {
        super("Conversor Centrígrados - Fahrenheit");
        JPanel pCentrigrados = criarPainelCentigrados();
        JPanel pFahrenheit = criarPainelFahrenheit();
        JPanel pbotoes = criarPainelBotoes();

        add(pCentrigrados, BorderLayout.NORTH);
        add(pFahrenheit, BorderLayout.CENTER);
        add(pbotoes, BorderLayout.SOUTH);

        // Garante o fecho da janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Método trabalha em pixeis
        this.setSize(400, 200);
        this.setMinimumSize(new Dimension(getWidth(), getHeight()));
        // Abrir a janela no meio do ecrã
        this.setLocationRelativeTo(null);
        // Torna a janela visivel
        this.setVisible(true);
    }

    private JPanel criarPainelCentigrados() {
        // Legenda e caixa de texto
        JLabel lbl = new JLabel("Centígrados");
        this.txtCentigrados = new JTextField(10);

        // Instância do painel
        JPanel p = new JPanel();

        // Adição dos componentes
        p.add(lbl);
        p.add(this.txtCentigrados);

        return p;
    }

    private JPanel criarPainelFahrenheit() {
        // Legenda e caixa de texto
        JLabel lbl = new JLabel("Fahrenheit");
        this.txtFarenheit = new JTextField(10);

        // Instância do painel
        JPanel p = new JPanel();

        // Adição dos componentes
        p.add(lbl);
        p.add(this.txtFarenheit);

        return p;
    }

    private JPanel criarPainelBotoes() {
        // Objeto que trata de eventos
        trataEvento = new TrataEvento();

        // 3 Butões
        this.btnConverter = criarBotaoConverter();
        this.btnLimpar = criarBotaoLimpar();
        this.btnSair = criarBotaoSair();

        // Instância do painel
        JPanel p = new JPanel();

        // Adição dos componentes
        p.add(this.btnConverter);
        p.add(this.btnLimpar);
        p.add(this.btnSair);

        return p;
    }

    private JButton criarBotaoConverter() {
        return new JButton("Converter");
    }

    private JButton criarBotaoLimpar() {
        return new JButton("Limpar");
    }

    private JButton criarBotaoSair() {
        JButton btn = new JButton("Sair");
        btn.addActionListener(this.trataEvento);
        
        return btn;
    }

    private class TrataEvento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();

            if (obj == btnSair) {
                dispose();
            }
        }

    }

}
