package datagui.ui;

import com.sun.glass.events.KeyEvent;
import datagui.model.Data;
import datagui.model.DiaInvalidoException;
import datagui.model.MesInvalidoException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Janela extends JFrame {
    // 3 Campos que são acedidos por diferentes botões, logo resultam em variáveis de instância
    private JTextField caixaData;
    private JTextField caixaDiaDaSemana;
    private JLabel dataPorExtenso;

    public Janela() {
        super("Data GUI");
        this.setLayout(new GridLayout(5, 1));
        
        // Podia criar um método criarCompenentes aqui
        this.add(new JLabel());
        this.add(criarPainelData());
        this.add(criarPainelDiaDaSemana());
        this.add(criarPainelDataPorExtenso());
        this.add(criarPainelBotoes());
        
        this.setSize(400, 300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel criarPainelData() {
        JPanel pnl = new JPanel();
        
        pnl.add(criarLabelData());
        
        this.caixaData = new JTextField(8);
        pnl.add(this.caixaData);
        
        return pnl;
    }

    public JLabel criarLabelData() {
        return new JLabel("Data (aaaa/mm/dd):");        
    }

    public JPanel criarPainelDiaDaSemana() {
        JPanel pnl = new JPanel();
        
        pnl.add(criarLabelDiaDaSemana());
        this.caixaDiaDaSemana = new JTextField(10);
        this.caixaDiaDaSemana.setEditable(false);
        pnl.add(this.caixaDiaDaSemana);
        
        return pnl;
    }
 
    public JLabel criarLabelDiaDaSemana() {
        return new JLabel("Dia da semana:");
    }
    
    private JPanel criarPainelDataPorExtenso() {
        JPanel pnl = new JPanel();
        
        this.dataPorExtenso = new JLabel();
        pnl.add(this.dataPorExtenso);
        
        return pnl;        
    }
    
    private JPanel criarPainelBotoes() {
        JPanel pnl = new JPanel();
        
        pnl.add(criarBotaoDiaDaSemana());
        pnl.add(criarBotaoDataPorExtenso());
        pnl.add(criarBotaoLimpar());
        
        return pnl;
    }
    
    //  Deve atualizar o JTextField do dia da semana
    private JButton criarBotaoDiaDaSemana() {
        JButton btn = new JButton("Dia da Semana");
        btn.setMnemonic(KeyEvent.VK_S);
        btn.setToolTipText("Determina o dia da semana");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    caixaDiaDaSemana.setText(getData().diaDaSemana());
                } catch(DiaInvalidoException | MesInvalidoException ex) {
                    caixaDiaDaSemana.setText(null);
                    caixaData.setText(null);
                    JOptionPane.showMessageDialog(Janela.this, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    caixaDiaDaSemana.requestFocus();
                } catch(NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(Janela.this, "A data é inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
                    caixaDiaDaSemana.requestFocus();
                }
            }
        });
        
        return btn;
    }
    
    // Deve atualizar a JLabel da data por extenso
    private JButton criarBotaoDataPorExtenso() {
        JButton btn = new JButton("Data por Extenso");
        btn.setMnemonic(KeyEvent.VK_E);
        btn.setToolTipText("Imprime a data por extenso");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dataPorExtenso.setText(getData().toString());
                } catch(DiaInvalidoException | MesInvalidoException ex) {
                    caixaData.setText(null);
                    caixaDiaDaSemana.setText(null);
                    JOptionPane.showMessageDialog(Janela.this, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    dataPorExtenso.requestFocus();
                } catch(NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(Janela.this, "A data é inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
                    dataPorExtenso.requestFocus();
                }
            }
        });
        
        return btn; 
    }
    
    // Deve limpar a JLabel e os dois JTextField
    private JButton criarBotaoLimpar() {
        JButton btn = new JButton("Limpar");
        btn.setMnemonic(KeyEvent.VK_L);
        btn.setToolTipText("Limpa a data");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                caixaData.setText(null);
                caixaDiaDaSemana.setText(null);
                dataPorExtenso.setText(null);
                caixaData.requestFocus();
            }
        });
        
        return btn;
    }

    private Data getData() {
        String dataPartida[] = caixaData.getText().split("/");
        
        return new Data(Integer.parseInt(dataPartida[0]),
                        Integer.parseInt(dataPartida[1]),
                        Integer.parseInt(dataPartida[2]));
    }
}
