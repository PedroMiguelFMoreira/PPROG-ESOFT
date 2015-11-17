package contador;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Esta Janela será composta por um JFrame que dara uso ao BorderLayout, onde
 * serão usadas as posições, norte e centro. A norte irá ser colocado um painel
 * com uma JLabel, contendo um titulo e uma variável incrementável. No centro
 * será colocado um painel com um botão responsável por incrementar essa mesma
 * variável.
 *
 *
 *
 * @author Pedro
 */
public class Contador extends JFrame {
    
    private int contador = 0;
    private final JButton btnContador = criarBotaoContagem();
    private final JLabel lblContador = criarLegendaContagem();
    
    private static final int JANELA_LARGURA = 300;
    private static final int JANELA_ALTURA = 200;
    private static final String JANELA_TITULO = "Contador de cliques";
    private static final String BOTAO_TEXTO = "Clica aqui!";
    private static final String LEGENDA_TEXTO = "Número de cliques: ";

    public Contador(String titulo) {
        super(titulo);

        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        criarComponentes();

        this.setSize(JANELA_LARGURA, JANELA_ALTURA);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void criarComponentes() {
        JPanel pnlCenter = new JPanel(new BorderLayout());
        JPanel pnlSouth = new JPanel();

        pnlCenter.add(lblContador, BorderLayout.CENTER);
        pnlSouth.add(btnContador);

        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);
    }
    
    private JLabel criarLegendaContagem() {
        JLabel lbl = new JLabel(LEGENDA_TEXTO + this.contador);
        
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setFont(new Font(Font.SANS_SERIF, 1, 20));
        
        return lbl;
    }

    public JButton criarBotaoContagem() {
        JButton btn = new JButton(BOTAO_TEXTO);
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lblContador.setText(LEGENDA_TEXTO + ++contador);
            }
        });

        return btn;
    }

    public static void main(String[] args) {
        Contador contadorCliques = new Contador(JANELA_TITULO);
    }

}
