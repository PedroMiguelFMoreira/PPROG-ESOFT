package shifts;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Shifts extends JFrame {

    private JTextField qtdLetras;
    private JPanel painelLetras;

    private static String[] letras = {"A", "B", "C", "D", "E", "F", "G"};

    public Shifts() {
        super("SHIFTS");
        this.setLayout(new BorderLayout());

        this.add(criarPainelAlinhamentoOpcao(), BorderLayout.NORTH);
        this.painelLetras = criarPainelLetras();
        this.add(this.painelLetras, BorderLayout.CENTER);
        this.add(criarPainelShift(), BorderLayout.SOUTH);

        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel criarPainelAlinhamentoOpcao() {
        JPanel pnl = new JPanel(new BorderLayout());
        pnl.add(criarPainelOpcao(), BorderLayout.WEST);

        return pnl;
    }

    public JPanel criarPainelOpcao() {
        JPanel pnl = new JPanel();
        pnl.setBorder(new TitledBorder(new EtchedBorder(), "Opção"));

        pnl.add(criarLabelQtdLetras());
        this.qtdLetras = new JTextField(1);
        pnl.add(this.qtdLetras);
        pnl.add(criarBotaoConfirmar());

        return pnl;
    }

    public JLabel criarLabelQtdLetras() {
        return new JLabel("Quantidade de Letras [3,7]:");
    }

    public JButton criarBotaoConfirmar() {
        JButton btn = new JButton("Confirmar");
        btn.setToolTipText("Confirma a quantidade de letras");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int letras = Integer.parseInt(qtdLetras.getText());

                    if (letras < 3 || letras > 7) {
                        throw new NumberFormatException();
                    }

                    if (letras > painelLetras.getComponentCount()) {
                        int adicionar = letras - painelLetras.getComponentCount();
                        
                        for (int i = 0; i < adicionar; i++) {
                            painelLetras.add(criarLetra(painelLetras.getComponentCount()));
                        }
                    } else if (letras < painelLetras.getComponentCount()) {
                        int remover = painelLetras.getComponentCount() - letras;

                        for (int i = 0; i < remover; i++) {
                            painelLetras.remove(painelLetras.getComponent(painelLetras.getComponentCount() - 1));
                        }
                    }
                    
                    painelLetras.revalidate();
                } catch (InputMismatchException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Shifts.this, "Quantidade de letras inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return btn;
    }

    public JPanel criarPainelLetras() {
        JPanel pnl = new JPanel(new GridLayout());

        for (int i = 0; i < 3; i++) {
            pnl.add(criarLetra(i));
        }

        return pnl;
    }

    public JLabel criarLetra(int i) {
        JLabel lbl = new JLabel(letras[i]);
        
        lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setFont(new Font(Font.SANS_SERIF, 1, 60));
        
        return lbl;
    }

    public JPanel criarPainelShift() {
        JPanel pnl = new JPanel(new BorderLayout());

        pnl.add(criarPainelShiftDireita(), BorderLayout.EAST);
        pnl.add(criarPainelShiftEsquerda(), BorderLayout.WEST);

        return pnl;
    }

    public JPanel criarPainelShiftEsquerda() {
        JPanel pnl = new JPanel();
        pnl.add(criarBotaoShiftEsquerda());

        return pnl;
    }

    public JButton criarBotaoShiftEsquerda() {
        JButton btn = new JButton("<<");

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String letra = ((JLabel) painelLetras.getComponent(0)).getText();

                for (int i = 0; i < painelLetras.getComponentCount() - 1; i++) {
                    JLabel labelLeft = (JLabel) painelLetras.getComponent(i);
                    JLabel labelRight = (JLabel) painelLetras.getComponent(i + 1);

                    labelLeft.setText(labelRight.getText());
                }

                ((JLabel) painelLetras.getComponent(painelLetras.getComponentCount() - 1)).setText(letra);
            }
        });

        return btn;
    }

    public JPanel criarPainelShiftDireita() {
        JPanel pnl = new JPanel();
        pnl.add(criarBotaoShiftDireita());

        return pnl;
    }

    public JButton criarBotaoShiftDireita() {
        JButton btn = new JButton(">>");

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String letra = ((JLabel) painelLetras.getComponent(painelLetras.getComponentCount() - 1)).getText();

                for (int i = painelLetras.getComponentCount() - 1; i > 0; i--) {
                    JLabel labelRight = (JLabel) painelLetras.getComponent(i);
                    JLabel labelLeft = (JLabel) painelLetras.getComponent(i - 1);

                    labelRight.setText(labelLeft.getText());
                }

                ((JLabel) painelLetras.getComponent(0)).setText(letra);
            }
        });

        return btn;
    }

    public static void main(String[] args) {
        Shifts janela1 = new Shifts();
    }

}
