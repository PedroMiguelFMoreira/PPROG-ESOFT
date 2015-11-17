package listatelefonica.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import listatelefonica.model.*;

public class DialogoNovoTelefone extends JDialog {

    private JTextField txtTitular, txtNumero;
    private JFrame framePai;
    private JTable tableListaTelefonica;
    private JTabbedPane tabPane;

    private static final Dimension LABEL_TAMANHO = new JLabel("Número:").getPreferredSize();

    public DialogoNovoTelefone(JFrame framePai, JTable tableListaTelefonica, JTabbedPane tabPane) {

        super(framePai, "Novo Telefone", true);

        this.framePai = framePai;
        this.tableListaTelefonica = tableListaTelefonica;
        this.tabPane = tabPane;

        JPanel p1 = criarPainelTitular();
        JPanel p2 = criarPainelNumero();
        JPanel p3 = criarPainelBotoes();

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        pack();
        setResizable(false);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }

    private JPanel criarPainelTitular() {
        JLabel lbl = new JLabel("Titular:", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 20;
        txtTitular = new JTextField(CAMPO_LARGURA);
        txtTitular.requestFocus();

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);
        p.add(txtTitular);

        return p;
    }

    private JPanel criarPainelNumero() {
        JLabel lbl = new JLabel("Número:", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 9;
        txtNumero = new JTextField(CAMPO_LARGURA);   

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(lbl);
        p.add(txtNumero);

        return p;
    }

    private JPanel criarPainelBotoes() {
        JButton btnOK = criarBotaoOK();
        getRootPane().setDefaultButton(btnOK);

        JButton btnCancelar = criarBotaoCancelar();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(btnOK);
        p.add(btnCancelar);

        return p;
    }

    private JButton criarBotaoOK() {
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String titular = txtTitular.getText();
                    int numero = Integer.parseInt(txtNumero.getText());

                    ModeloTabelaListaTelefonica modeloTabelaListaTelefonica = 
                            (ModeloTabelaListaTelefonica) tableListaTelefonica.getModel();
                    
                    modeloTabelaListaTelefonica.addRow(new Telefone(titular, numero));

                    setVisible(false);

                    JOptionPane.showMessageDialog(
                            framePai,
                            "Telefone adicionado à lista telefónica.",
                            "Novo Telefone",
                            JOptionPane.INFORMATION_MESSAGE);

                    dispose();

                    tableListaTelefonica.getTableHeader().setEnabled(true);
                    final int TAB_LISTA_TELEFONICA = 1;                    
                    tabPane.setSelectedIndex(TAB_LISTA_TELEFONICA);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            framePai,
                            "Tem que introduzir um número inteiro com 9 digitos.",
                            "Novo Telefone",
                            JOptionPane.WARNING_MESSAGE);
                    txtNumero.requestFocus();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(
                            framePai,
                            ex.getMessage(),
                            "Novo Telefone",
                            JOptionPane.WARNING_MESSAGE);
                    txtTitular.requestFocus();
                }
            }
        });
        return btn;
    }

    private JButton criarBotaoCancelar() {
        JButton btn = new JButton("Cancelar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btn;
    }

}
