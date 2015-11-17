package junho2013_2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Pedro
 */
public class Calendario extends JFrame {

    public Calendario() {
        super("Calendário");
        setLayout(new BorderLayout(10, 10));
        setJMenuBar(criarJMenuBar());
        add(criarPainelMesAno(), BorderLayout.NORTH);
        add(criarPainelDias(), BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private JPanel criarPainelDias() {
        JPanel jPanel = new JPanel(new GridLayout(7, 7));

        jPanel.add(new JLabel("D"));
        jPanel.add(new JLabel("S"));
        jPanel.add(new JLabel("T"));
        jPanel.add(new JLabel("Q"));
        jPanel.add(new JLabel("Q"));
        jPanel.add(new JLabel("S"));
        jPanel.add(new JLabel("S"));
        jPanel.add(new JLabel(""));
        jPanel.add(new JLabel(""));
        jPanel.add(new JLabel(""));
        jPanel.add(new JLabel(""));
        jPanel.add(new JLabel(""));
        jPanel.add(new JLabel(""));
        jPanel.add(new JLabel("1"));
        jPanel.add(new JLabel("2"));
        jPanel.add(new JLabel("3"));
        jPanel.add(new JLabel("4"));
        jPanel.add(new JLabel("5"));
        jPanel.add(new JLabel("6"));
        jPanel.add(new JLabel("7"));
        jPanel.add(new JLabel("8"));
        jPanel.add(new JLabel("9"));
        jPanel.add(new JLabel("10"));
        jPanel.add(new JLabel("11"));
        jPanel.add(new JLabel("12"));
        jPanel.add(new JLabel("13"));
        jPanel.add(new JLabel("14"));
        jPanel.add(new JLabel("15"));
        jPanel.add(new JLabel("16"));
        jPanel.add(new JLabel("17"));
        jPanel.add(new JLabel("18"));
        jPanel.add(new JLabel("19"));
        jPanel.add(new JLabel("20"));
        jPanel.add(new JLabel("21"));
        jPanel.add(new JLabel("22"));
        jPanel.add(new JLabel("23"));
        jPanel.add(new JLabel("24"));
        jPanel.add(new JLabel("25"));
        jPanel.add(new JLabel("26"));
        jPanel.add(new JLabel("27"));
        jPanel.add(new JLabel("28"));
        jPanel.add(new JLabel("29"));
        jPanel.add(new JLabel("30"));
        jPanel.add(new JLabel(""));

        return jPanel;
    }

    private JPanel criarPainelMesAno() {
        JPanel jPanel = new JPanel(new BorderLayout());

        jPanel.add(new JButton("<"), BorderLayout.WEST);
        JLabel anoMes = new JLabel("Junho 2013");
        anoMes.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        jPanel.add(anoMes, BorderLayout.CENTER);
        jPanel.add(new JButton(">"), BorderLayout.EAST);

        return jPanel;
    }

    private JMenuBar criarJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        jMenuBar.add(criarJMenu());

        return jMenuBar;
    }

    private JMenu criarJMenu() {
        JMenu jMenu = new JMenu("Modificar");

        jMenu.add(criarJMenuItem());

        return jMenu;
    }

    private JMenuItem criarJMenuItem() {
        return new JMenuItem("Ano");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Calendario();
    }

}
