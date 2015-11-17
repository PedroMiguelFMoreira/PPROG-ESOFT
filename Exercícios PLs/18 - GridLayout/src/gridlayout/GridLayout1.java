package gridlayout;

import java.awt.*;
import javax.swing.*;

/**
 * Representa uma janela cujo ContentPane tem um gestor de posicionamento 
 * GridLayout.
 * 
 * @author ISEP-DEI-PPROG
 */
public class GridLayout1 extends JFrame {

    /**
     * A largura da janela em píxeis.
     */
    private static final int JANELA_LARGURA = 400;

    /**
     * A altura da janela em píxeis.
     */
    private static final int JANELA_ALTURA = 200;

    /**
     * Constrói uma instância de GridLayout1.
     *
     * @param titulo o título da janela
     */
    public GridLayout1(String titulo) {

        super(titulo);

        getContentPane().setBackground(Color.cyan);
           
        //add(new JLabel());
        criarComponentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setVisible(true);   
    }

    /**
     * Cria e adiciona componentes à janela.
     */
    private void criarComponentes() {
        JPanel pnlAmarelo = new JPanel(new BorderLayout());
        pnlAmarelo.setBackground(Color.YELLOW);
        
        JPanel pnlPreto = new JPanel(new GridLayout(7, 1, 20, 20));
        pnlPreto.setBackground(Color.BLACK);
        
        pnlPreto.add(new JButton("Um"));
        pnlPreto.add(new JButton("Dois"));
        pnlPreto.add(new JButton("Três"));
        pnlPreto.add(new JButton("Quatro"));
        pnlPreto.add(new JButton("Cinco"));
        pnlPreto.add(new JButton("Seis"));
        pnlPreto.add(new JButton("Sete"));
        
        pnlAmarelo.add(pnlPreto, BorderLayout.NORTH);
        add(pnlAmarelo, BorderLayout.WEST);
    }    

    /**
     * Para testar a janela GridLayout1.
     *
     * @param args as opções de execução
     */
    public static void main(String args[]) {

        GridLayout1 jan = new GridLayout1("Gestor de Posicionamento: GridLayout");

    }
}

