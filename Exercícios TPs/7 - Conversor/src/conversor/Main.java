package conversor;

import javax.swing.JFrame;

/**
 * Apoio Teorico:
 * 
 * Componentes Swing:   http://docs.oracle.com/javase/tutorial/uiswing/components/index.html
 * - JFrame:            http://docs.oracle.com/javase/tutorial/uiswing/components/frame.html
 * - JPanel:            http://docs.oracle.com/javase/tutorial/uiswing/components/panel.html
 * - JButton:           http://docs.oracle.com/javase/tutorial/uiswing/components/button.html
 * - JTextField:        http://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
 * - JLabel:            http://docs.oracle.com/javase/tutorial/uiswing/components/label.html
 * - JDialog:           http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
 *
 * Gestores de posicionamento:  http://docs.oracle.com/javase/tutorial/uiswing/layout/index.html
 * - BorderLayout:              http://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html#border
 * - FlowLayout:		http://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html#flow
 * - GridLayout:		http://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html#grid
 *
 * Tratamento de eventos:   http://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
 * 
 * Esta interface gráfica vai usar:
 * 
 * - Um JLabel para os graus Centígrados.
 * - Um JLabel para os graus Fahrenheit.
 * - Um JTextField para os graus Centígrados.
 * - Um JTextField para os graus Fahrenheit, que não seja editável
 * - Três JButton para os botões de conversão, limpeza e saida.
 * 
 * (Os componentes gráficos podem ser guardados dentro de vários JPanel, desta
 * forma é possível garantir a posição correta dos mesmos, através de gestores
 * de posicionamento.)
 * 
 * Tudo isto é guardado dentro de um JFrame.
 * 
 * Layout Gráfico:
 * - Janela - JFrame - ContentPane - BorderLayout
 * - Linha Centígrados - JPanel - FlowLayout (Adicionado a Norte)
 * - Linha Fahrenheit - JPanel - FlowLayout (Adicionado a Centro)
 * - Butões - JPanel - FlowLayout (Adicionado a Sul)
 * 
 * Notas:
 * - É necessário guardar os componentes gráficos a JPanels para garantir a
 * sua correta visualização dentro do ContentPane, visto que o mesmo implementa
 * BorderLayout.
 * - Componentes do tipo JPanel tem como prefixo p.
 * - Componentes do tipo JLabel tem como prefixo lbl.
 * - Componentes do tipo JTextField tem como prefixo txt.
 * - Componentes do tipo JButton tem como prefixo btn.
 * 
 * @author Pedro
 */
public class Main {

    public static void main(String[] args) {
        Janela janela = new Janela();
    }
    
}
