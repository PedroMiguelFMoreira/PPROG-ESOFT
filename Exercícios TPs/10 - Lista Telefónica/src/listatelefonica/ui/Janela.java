package listatelefonica.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileFilter;
import listatelefonica.model.*;

public class Janela extends JFrame {

    private ListaTelefonica listaTelefonica;
    private FicheiroListaTelefonica ficheiroListaTelefonica;
    private JTable tableListaTelefonica;
    private JMenuItem menuItemEliminar, menuItemExportarLista;
    private JTabbedPane tabPane;
    private JFileChooser fileChooser;

    public Janela(  ListaTelefonica listaTelefonica, 
                    FicheiroListaTelefonica ficheiroListaTelefonica) {

        super("Lista Telefónica 3.0");

        this.listaTelefonica = listaTelefonica;
        
        this.ficheiroListaTelefonica = ficheiroListaTelefonica;
        
        JMenuBar menuBar = criarBarraMenus();
        setJMenuBar(menuBar);

        tabPane = criarSeparadores();
        add(tabPane, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sair();
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        pack();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private JMenuBar criarBarraMenus() {
        JMenuBar menuBar = new JMenuBar();
        
        menuBar.add(criarMenuTelefone());
        menuBar.add(criarMenuOpcoes());

        return menuBar;
    }

    private JMenu criarMenuTelefone() {
        JMenu menu = new JMenu("Telefone");
        menu.setMnemonic(KeyEvent.VK_T);

        menu.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                boolean tabelaPreenchida = tableListaTelefonica.getModel().getRowCount() != 0;                
                menuItemEliminar.setEnabled(tabelaPreenchida);
                menuItemExportarLista.setEnabled(tabelaPreenchida);
            }
        });

        menu.add(criarItemNovoTelefone());

        menuItemEliminar = criarItemEliminarTelefone();
        menu.add(menuItemEliminar);

        menu.addSeparator();
        menu.add(criarSubMenuLista());
        menu.addSeparator();
        menu.add(criarItemSair());

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

        item.setEnabled(listaTelefonica.tamanho() != 0);

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Telefone[] opcoes = listaTelefonica.getArray();
                Telefone telefone = (Telefone) JOptionPane.showInputDialog(
                        Janela.this,
                        "Escolha um telefone:", 
                        "Eliminar Telefone",
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
                        ModeloTabelaListaTelefonica modeloTabelaListaTelefonica
                                = (ModeloTabelaListaTelefonica) tableListaTelefonica.getModel();
                        modeloTabelaListaTelefonica.removeRow(telefone);
                    }
                }
            }
        });

        return item;
    }

    private JMenu criarSubMenuLista() {
        JMenu menu = new JMenu("Lista");
        menu.setMnemonic(KeyEvent.VK_L);

        menu.add(criarItemImportarLista());
        
        menuItemExportarLista = criarItemExportarLista();
        menu.add(menuItemExportarLista);

        personalizarFileChooserEmPortugues();
        fileChooser = new JFileChooser();
        
        definirFiltroExtensaoBin(fileChooser);
        
        return menu;
    }

    private JMenuItem criarItemImportarLista() {
        JMenuItem item = new JMenuItem("Importar", KeyEvent.VK_I);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int resposta = fileChooser.showOpenDialog(Janela.this);

                if (resposta == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    ListaTelefonica listaTelefonica
                            = ficheiroListaTelefonica.ler(file.getPath());
                    if (listaTelefonica == null) {
                        JOptionPane.showMessageDialog(
                                Janela.this,
                                "Impossível ler o ficheiro: " + file.getPath()+ " !",
                                "Importar",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        ModeloTabelaListaTelefonica modeloTabela
                                = (ModeloTabelaListaTelefonica) tableListaTelefonica.getModel();
                        int totalTelefonesAdicionados = modeloTabela.addRows(listaTelefonica);
                        JOptionPane.showMessageDialog(
                                Janela.this,
                                "Telefones importados: " + totalTelefonesAdicionados,
                                "Importar Lista Telefónica",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        return item;
    }
    
    private JMenuItem criarItemExportarLista() {
        JMenuItem item = new JMenuItem("Exportar", KeyEvent.VK_X);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int resposta = fileChooser.showSaveDialog(Janela.this);
                if (resposta == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (!file.getName().endsWith(".bin")) {
                        file = new File(file.getPath().trim() + ".bin");
                    }
                    boolean ficheiroGuardado
                            = ficheiroListaTelefonica.guardar(
                                    file.getPath(),
                                    listaTelefonica);
                    if (!ficheiroGuardado) {
                        JOptionPane.showMessageDialog(
                                Janela.this,
                                "Impossível gravar o ficheiro: "
                                + file.getPath() + " !",
                                "Exportar",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                Janela.this,
                                "Ficheiro gravado com sucesso.",
                                "Exportar",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
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
                sair();
            }
        });

        return item;
    }

    private JMenu criarMenuOpcoes() {
        JMenu menu = new JMenu("Opções");
        menu.setMnemonic(KeyEvent.VK_O);

        menu.add(criarSubMenuEstilo());
        menu.addSeparator();
        menu.add(criarItemAcerca());

        return menu;
    }
    
    private JMenu criarSubMenuEstilo() {
        JMenu menu = new JMenu("Estilo");
        menu.setMnemonic(KeyEvent.VK_E);

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            menu.add(criarItemEstilo(info));
        }

        return menu;
    }

    private JMenuItem criarItemEstilo(UIManager.LookAndFeelInfo info) {
        JMenuItem item = new JMenuItem(info.getName());

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if (menuItem.getActionCommand().equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    SwingUtilities.updateComponentTreeUI(Janela.this);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            Janela.this,
                            ex.getMessage(),
                            "Estilo " + menuItem.getActionCommand(),
                            JOptionPane.ERROR_MESSAGE);
                }
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

    private JTabbedPane criarSeparadores() {
        JTabbedPane tabPane = new JTabbedPane();
        tabPane.addTab("Início", new PainelInicio());

        PainelListaTelefonica pListaTelefonica = 
                new PainelListaTelefonica(listaTelefonica);
        tabPane.addTab("Lista Telefónica", pListaTelefonica);
        
        tableListaTelefonica = pListaTelefonica.getTableListaTelefonica();
        
        tableListaTelefonica.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                boolean tabelaPreenchida = tableListaTelefonica.getModel().getRowCount() != 0;
                tableListaTelefonica.getTableHeader().setEnabled(tabelaPreenchida);
            }
        });        
        
        boolean tabelaPreenchida = tableListaTelefonica.getModel().getRowCount() != 0;
        tableListaTelefonica.getTableHeader().setEnabled(tabelaPreenchida);
        
        return tabPane;
    }
    
    public static void personalizarFileChooserEmPortugues() {

        // Títulos das Caixas de Diálogo
        UIManager.put("FileChooser.openDialogTitleText", "Importar Lista Telefónica");
        UIManager.put("FileChooser.saveDialogTitleText", "Exportar Lista Telefónica");

        // Botão "Importar"
        UIManager.put("FileChooser.openButtonText", "Importar");
        UIManager.put("FileChooser.openButtonMnemonic", "I");
        UIManager.put("FileChooser.openButtonToolTipText", "Importar Lista Telefónica");
        
        // Botão "Exportar"
        UIManager.put("FileChooser.saveButtonText", "Exportar");
        UIManager.put("FileChooser.saveButtonMnemonic", "E");
        UIManager.put("FileChooser.saveButtonToolTipText", "Exportar Lista Telefónica");
        
        // Botão "Cancelar"
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        
        // Botão "Ajuda"
        UIManager.put("FileChooser.helpButtonText", "Ajuda");
        UIManager.put("FileChooser.helpButtonMnemonic", "A");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ajuda");
        
        // Legenda "Procurar em:"
        UIManager.put("FileChooser.lookInLabelMnemonic", "E");
        UIManager.put("FileChooser.lookInLabelText", "Procurar em:");
        
        // Legenda "Guardar em:"
        UIManager.put("FileChooser.saveInLabelText", "Guardar em:");
        UIManager.put("FileChooser.saveInLabelMnemonic", "G");
                
        // Legenda "Tipo de ficheiros:"
        UIManager.put("FileChooser.filesOfTypeLabelText", "Ficheiros do tipo:");
        UIManager.put("FileChooser.filesOfTypeLabelMnemonic", "F");

        // Legenda "Nome do ficheiro:"
        UIManager.put("FileChooser.fileNameLabelMnemonic", "N");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do ficheiro:");

        // Filtro "Todos os Ficheiros"
        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos os Ficheiros");

        // Botão "Um nível acima"
        UIManager.put("FileChooser.upFolderToolTipText", "Um nível acima");
        UIManager.put("FileChooser.upFolderAccessibleName", "Um nível acima");

        // Botão "Ambiente de Trabalho"
        UIManager.put("FileChooser.homeFolderToolTipText", "Ambiente");
        UIManager.put("FileChooser.homeFolderToolTipText", "Ambiente de Trabalho");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Ambiente de Trabalho");
        
        // Botão "Nova Pasta"
        UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");
        UIManager.put("FileChooser.newFolderAccessibleName", "Criar nova pasta");

        // Botão "Vista Lista"
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");

        // Botão "Vista Detalhada"
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");
        
        // Cabeçalhos da "Vista Lista Detalhada"
        UIManager.put("FileChooser.fileNameHeaderText", "Nome");
        UIManager.put("FileChooser.fileSizeHeaderText", "Tamanho");
        UIManager.put("FileChooser.fileTypeHeaderText", "Tipo");
        UIManager.put("FileChooser.fileDateHeaderText", "Data");
        UIManager.put("FileChooser.fileAttrHeaderText", "Atributos");
    }
    
    private void definirFiltroExtensaoBin(JFileChooser fileChooser){
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String extensao = extensao(f);
                if (extensao != null) {
                    return extensao.equals("bin");
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "*.bin";
            }

            private String extensao(File f) {
                String ext = null;
                String s = f.getName();
                int i = s.lastIndexOf(".");
                if (i != -1) {
                    ext = s.substring(i + 1).toLowerCase();
                }
                return ext;
            }
        });
    }    
    
    private void sair() {
        boolean listaTelefonicaGuardada = 
                ficheiroListaTelefonica.guardar(FicheiroListaTelefonica.NOME, listaTelefonica);
        if (!listaTelefonicaGuardada) {
            JOptionPane.showMessageDialog(
                    this,
                    "Impossível guardar lista telefónica!",
                    "Sair",
                    JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }    

}
