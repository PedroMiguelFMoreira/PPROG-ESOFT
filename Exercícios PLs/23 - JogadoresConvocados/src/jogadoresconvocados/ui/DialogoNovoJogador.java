/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogadoresconvocados.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import jogadoresconvocados.model.Jogador;
import jogadoresconvocados.model.PosicaoJogador;

/**
 *
 * @author Pedro
 */
public class DialogoNovoJogador extends JDialog {

    private JTextField txtNome;
    private JFrame framePai;
    private JList lstJogadores;
    private JComboBox cmbPosicao;

    private static final Dimension LABEL_TAMANHO = new JLabel("Posição:").getPreferredSize();

    public DialogoNovoJogador(JFrame framePai, JList lstJogadores) {
        super(framePai, "Novo Jogador", true);

        final int NUMERO_LINHAS = 3, NUMERO_COLUNAS = 1;
        setLayout(new GridLayout(NUMERO_LINHAS, NUMERO_COLUNAS));

        this.framePai = framePai;
        this.lstJogadores = lstJogadores;

        JPanel p1 = criarPainelNome();
        JPanel p2 = criarPainelPosicao();
        JPanel p3 = criarPainelBotoes();

        add(p1);
        add(p2);
        add(p3);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        pack();
        setResizable(false);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }

    private JPanel criarPainelNome() {
        JLabel lbl = new JLabel("Nome: ", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 20;
        txtNome = new JTextField(CAMPO_LARGURA);
        txtNome.requestFocus();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(lbl);
        p.add(txtNome);

        return p;
    }

    private JPanel criarPainelPosicao() {
        JLabel lbl = new JLabel("Posição: ", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        cmbPosicao = new JComboBox(PosicaoJogador.values());
        cmbPosicao.setSelectedIndex(-1);

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(lbl);
        p.add(cmbPosicao);

        return p;
    }

    private JPanel criarPainelBotoes() {
        JButton btnOK = criarBotaoOk();
        getRootPane().setDefaultButton(btnOK);

        JButton btnCancelar = criarBotaoCancelar();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(btnOK);
        p.add(btnCancelar);

        return p;
    }

    private JButton criarBotaoOk() {
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    String nome = txtNome.getText();
                    
                    PosicaoJogador posicaoJogador = 
                            (PosicaoJogador) cmbPosicao.getSelectedItem();
                    
                    Jogador jogador = new Jogador(nome, posicaoJogador);
                    
                    ModeloListaJogadores modeloListaJogadores = 
                            (ModeloListaJogadores) lstJogadores.getModel();
                    
                    boolean jogadorAdicionado =
                            modeloListaJogadores.addElement(jogador);
                    
                    dispose();
                    
                    if (!jogadorAdicionado) {
                        JOptionPane.showMessageDialog(
                                framePai, 
                                "Jogador já existente!", 
                                "Novo jogador", 
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch(IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(
                            framePai,
                            ex.getMessage(),
                            "Novo jogador",
                            JOptionPane.ERROR_MESSAGE);
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
