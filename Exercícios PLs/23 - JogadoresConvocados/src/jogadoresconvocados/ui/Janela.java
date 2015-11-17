package jogadoresconvocados.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jogadoresconvocados.model.Jogador;
import jogadoresconvocados.model.ListaJogadores;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class Janela extends JFrame {

    private ListaJogadores listaCompleta, listaConvocados;
    private FicheiroListaJogadores ficheiroListaJogadores;
    private JList lstCompleta, lstConvocados;
    private JButton btnEliminarCompleta, btnEliminarConvocados;
    private JButton btnConvocar, btnCriarFicheiro;

    public Janela(
            ListaJogadores listaCompleta,
            ListaJogadores listaConvocados,
            FicheiroListaJogadores ficheiroListaJogadores) {

        super("Jogadores Convocados");

        this.listaCompleta = listaCompleta;
        this.listaConvocados = listaConvocados;
        this.ficheiroListaJogadores = ficheiroListaJogadores;

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(criarMenu());

        add(criarPainelListas(), BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                terminar("Fechar");
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void terminar(String text) {
        dispose();
    }

    private JMenu criarMenu() {

        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_F);

        menu.add(criarItemNovoJogador());

        menu.addSeparator();

        JMenuItem menuItemGuardar = criarItemGuardar();
        menu.add(menuItemGuardar);

        menu.addSeparator();

        menu.add(criarItemSair());

        return menu;
    }

    private JMenuItem criarItemNovoJogador() {
        JMenuItem item = new JMenuItem("Novo Jogador", KeyEvent.VK_N);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogoNovoJogador(Janela.this, lstCompleta);
            }
        });
        return item;
    }

    private JMenuItem criarItemGuardar() {
        JMenuItem item = new JMenuItem("Guardar Listas", KeyEvent.VK_G);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
        return item;
    }

    private JMenuItem criarItemSair() {
        JMenuItem item = new JMenuItem("Sair", KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        return item;
    }

    private JPanel criarPainelListas() {
        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
        final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
        JPanel p = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        ModeloListaJogadores modeloListaCompleta = new ModeloListaJogadores(listaCompleta);
        lstCompleta = new JList(modeloListaCompleta);
        btnEliminarCompleta = criarBotaoEliminarJogador(lstCompleta);
        btnConvocar = criarBotaoConvocarJogador();
        p.add(criarPainelLista(
                "Lista de Jogadores Completa:",
                lstCompleta,
                modeloListaCompleta,
                btnEliminarCompleta,
                btnConvocar));

        ModeloListaJogadores modeloListaConvocados = new ModeloListaJogadores(listaConvocados);
        lstConvocados = new JList(modeloListaConvocados);
        btnEliminarConvocados = criarBotaoEliminarJogador(lstConvocados);
        btnCriarFicheiro = criarBotaoCriarFicheiro();
        p.add(criarPainelLista(
                "Lista de Jogadores Convocados:",
                lstConvocados,
                modeloListaConvocados,
                btnEliminarConvocados,
                btnCriarFicheiro));
        return p;
    }

    private JPanel criarPainelLista(
            String tituloLista,
            JList lstLista,
            ModeloListaJogadores modeloLista,
            JButton btnSuperior,
            JButton btnInferior) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        modeloLista.addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {
                btnSuperior.setEnabled(lstLista.getModel().getSize() != 0);
                btnInferior.setEnabled(lstLista.getModel().getSize() != 0);
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {
                btnSuperior.setEnabled(lstLista.getModel().getSize() != 0);
                btnInferior.setEnabled(lstLista.getModel().getSize() != 0);
            }

            @Override
            public void contentsChanged(ListDataEvent e) {
            }
        });
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        final int MARGEM_SUPERIOR = 20, MARGEM_INFERIOR = 20;
        final int MARGEM_ESQUERDA = 20, MARGEM_DIREITA = 20;
        p.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        JPanel pBotoes = criarPainelBotoes(btnSuperior, btnInferior);
        p.add(pBotoes, BorderLayout.SOUTH);
        return p;
    }

    private JPanel criarPainelBotoes(JButton btn1, JButton btn2) {

        final int NUMERO_LINHAS = 2, NUMERO_COLUNAS = 1;
        final int INTERVALO_HORIZONTAL = 0, INTERVALO_VERTICAL = 10;
        JPanel p = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;
        p.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(btn1);
        p.add(btn2);

        return p;
    }

    private JButton criarBotaoEliminarJogador(JList lstLista) {
        JButton btn = new JButton("Eliminar Jogador");
        btn.setEnabled(lstLista.getModel().getSize() != 0);

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloListaJogadores ListaJogadores = (ModeloListaJogadores) lstLista.getModel();

                if (ListaJogadores.getSize() == 0) {
                    JOptionPane.showMessageDialog(
                            Janela.this,
                            "Não existem jogadores para remover!",
                            "Novo jogador",
                            JOptionPane.ERROR_MESSAGE);
                } else if (!ListaJogadores.removeElement((Jogador) lstLista.getSelectedValue())) {
                    JOptionPane.showMessageDialog(
                            Janela.this,
                            "Não selecionou nenhum jogador para remover!",
                            "Novo jogador",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return btn;
    }

    private JButton criarBotaoConvocarJogador() {
        btnConvocar = new JButton("Convocar Jogador");
        btnConvocar.setEnabled(lstCompleta.getModel().getSize() != 0);
        btnConvocar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloListaJogadores listaConvocados = (ModeloListaJogadores) lstConvocados.getModel();
                Jogador jogadorConvocado = (Jogador) lstCompleta.getSelectedValue();

                if (jogadorConvocado == null) {
                    JOptionPane.showMessageDialog(
                            Janela.this,
                            "Não selecionou um jogador para convocar!",
                            "Convocar jogador",
                            JOptionPane.ERROR_MESSAGE);
                } else if (listaConvocados.contains(jogadorConvocado)) {
                    JOptionPane.showMessageDialog(
                            Janela.this,
                            "O jogador selecionado já se encontra convocado!",
                            "Convocar jogador",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    listaConvocados.addElement(jogadorConvocado);
                }

            }
        });

        return btnConvocar;
    }

    private JButton criarBotaoCriarFicheiro() {
        btnCriarFicheiro = new JButton("Criar Ficheiro Convocados");
        btnCriarFicheiro.setEnabled(lstConvocados.getModel().getSize() != 0);

        //
        return btnCriarFicheiro;
    }

}
