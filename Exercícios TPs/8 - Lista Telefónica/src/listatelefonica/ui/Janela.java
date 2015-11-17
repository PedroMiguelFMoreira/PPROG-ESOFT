package listatelefonica.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import listatelefonica.model.*;

public class Janela extends JFrame {

    private JTable tableListaTelefonica;
    private JMenuItem menuItemEliminar;
    private JTabbedPane tabPane;

    public Janela(JTable tableListaTelefonica) {

        super("Lista Telefónica");

        this.tableListaTelefonica = tableListaTelefonica;

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(criarMenuTelefone());
        menuBar.add(criarMenuOpcoes());

        tabPane = criarSeparadores();
        add(tabPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private JTabbedPane criarSeparadores() {
        JTabbedPane tabPane = new JTabbedPane();
        tabPane.addTab("Início", new PainelInicio());
        tabPane.addTab("Lista Telefónica",
                new PainelListaTelefonica(tableListaTelefonica));
        tableListaTelefonica.getTableHeader().setEnabled(false);
        return tabPane;
    }

    private JMenu criarMenuTelefone() {
        JMenu menu = new JMenu("Telefone");
        menu.setMnemonic(KeyEvent.VK_T);

        menu.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                menuItemEliminar.setEnabled(
                        tableListaTelefonica.getModel().getRowCount() != 0);
            }
        });

        menu.add(criarItemNovoTelefone());

        menuItemEliminar = criarItemEliminarTelefone();
        menu.add(menuItemEliminar);

        menu.addSeparator();
        menu.add(criarItemSair());

        return menu;
    }

    private JMenu criarMenuOpcoes() {
        JMenu menu = new JMenu("Opções");
        menu.setMnemonic(KeyEvent.VK_O);

        menu.add(criarSubMenuEstilo());
        menu.addSeparator();
        menu.add(criarItemAcerca());

        return menu;
    }

    private JMenuItem criarItemNovoTelefone() {
        JMenuItem item = new JMenuItem("Novo", KeyEvent.VK_N);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogoNovoTelefone(Janela.this, tableListaTelefonica, tabPane);
            }
        });

        return item;
    }

    private JMenuItem criarItemEliminarTelefone() {
        JMenuItem item = new JMenuItem("Eliminar", KeyEvent.VK_E);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloTabelaListaTelefonica modeloTabelaListaTelefonica
                        = (ModeloTabelaListaTelefonica) tableListaTelefonica.getModel();
                Telefone[] opcoes = modeloTabelaListaTelefonica.getArray();
                Telefone telefone = (Telefone) JOptionPane.showInputDialog(
                        Janela.this,
                        "Escolha um telefone:", "Eliminar Telefone",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);
                if (telefone != null) {
                    String[] opcoes2 = {"Sim", "Não"};
                    int resposta = JOptionPane.showOptionDialog(
                            Janela.this,
                            "Eliminar\n" + telefone.toString(),
                            "Eliminar Telefone",
                            0,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcoes2,
                            opcoes2[1]);
                    final int SIM = 0;
                    if (resposta == SIM) {
                        modeloTabelaListaTelefonica.removeRow(telefone);
                        if (modeloTabelaListaTelefonica.getRowCount() == 0) {
                            tableListaTelefonica.getTableHeader().setEnabled(false);
                        }
                    }
                }
            }
        });

        return item;
    }

    private JMenu criarSubMenuEstilo() {
        JMenu menu = new JMenu("Estilo");
        menu.setMnemonic(KeyEvent.VK_E);

        menu.add(criarItemEstilo("Mac OS X", KeyEvent.VK_X));
        menu.add(criarItemEstilo("Metal", KeyEvent.VK_M));
        menu.add(criarItemEstilo("Nimbus", KeyEvent.VK_I));
        menu.add(criarItemEstilo("Windows", KeyEvent.VK_W));

        return menu;
    }

    private JMenuItem criarItemEstilo(String estilo, int keyEvent) {
        JMenuItem item = new JMenuItem(estilo, keyEvent);
        item.setAccelerator(KeyStroke.getKeyStroke(keyEvent, InputEvent.CTRL_MASK));

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                try {
                    boolean encontrouEstilo = false;
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if (menuItem.getActionCommand().equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            encontrouEstilo = true;
                            break;
                        }
                    }
                    if (!encontrouEstilo) {
                        throw new Exception();
                    }
                    SwingUtilities.updateComponentTreeUI(Janela.this);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            Janela.this,
                            "Estilo indisponível!",
                            "Estilo " + menuItem.getActionCommand(),
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return item;
    }

    private JMenuItem criarItemSair() {
        JMenuItem item = new JMenuItem("Sair", KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return item;
    }

    private JMenuItem criarItemAcerca() {
        JMenuItem item = new JMenuItem("Acerca", KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        Janela.this,
                        "@Copyright\nPPROG 2014/2015",
                        "Acerca",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return item;
    }

}
